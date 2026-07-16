package org.webgpu.generator.generators;

import javax.lang.model.element.Modifier;

import java.lang.foreign.MemorySegment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.generator.domain.YamlModel;
import org.webgpu.generator.domain.GpuStruct;
import org.webgpu.generator.domain.GpuStruct.Member;

import com.palantir.javapoet.ArrayTypeName;
import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.CodeBlock;
import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.ParameterSpec;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;

public class StructGenerator {

    private final YamlModel yamlModel;
    private final String packageName;

    private static final Logger logger = LoggerFactory.getLogger(StructGenerator.class);
    private static final String COMMON_STRUCT = "WGPUStruct";

    public StructGenerator(YamlModel yamlModel, String packageName) {
        this.yamlModel = yamlModel;
        this.packageName = packageName;
    }

    public List<JavaFile> generate() {

        yamlModel.getStructs().forEach(e -> logger.info("Generated struct: {}", e.getName()));

        // Build a map of parent struct name to list of child structs that extend it
        Map<String, List<GpuStruct>> parentToChildrenMap = new HashMap<>();
        yamlModel.getStructs().forEach(struct -> {
            for (String parentName : struct.getExtends()) {
                parentToChildrenMap.computeIfAbsent(parentName, k -> new ArrayList<>()).add(struct);
            }
        });

        final var javaFiles = yamlModel.getStructs().stream().map(e -> {
            List<GpuStruct> children = parentToChildrenMap.getOrDefault(e.getName(), List.of());
            return generateStructClass(e, children);
        }).map(ts -> JavaFile.builder(packageName, ts).build()).collect(Collectors.toList());

        javaFiles.add(JavaFile.builder(packageName, generateStructInterface(yamlModel.getStructs())).build());

        return javaFiles;

    }

    private TypeSpec generateStructInterface(List<GpuStruct> structs) {
        logger.info("Building: " + COMMON_STRUCT);
        var typeSpecBuild = TypeSpec.interfaceBuilder(COMMON_STRUCT);
        typeSpecBuild.addModifiers(Modifier.PUBLIC, Modifier.SEALED);
        for (GpuStruct struct : structs) {
            typeSpecBuild.addPermittedSubclass(Utils.map(Utils.toPascalCase(struct.getName())));
        }
        logger.info("{}", typeSpecBuild.build());
        return typeSpecBuild.build();
    }

    private TypeSpec generateStructClass(GpuStruct e, SequencedCollection<GpuStruct> children) {
        final TypeSpec.Builder structSpecBuilder = TypeSpec.classBuilder(Utils.toPascalCase(e.getName()));
        if (e.getDoc() != null) {
            structSpecBuilder.addJavadoc(e.getDoc());
        }

        structSpecBuilder.addSuperinterfaces(Collections.singleton(Utils.map(COMMON_STRUCT)));
        structSpecBuilder.addField(
                FieldSpec.builder(MemorySegment.class, "memorySegment", Modifier.PRIVATE, Modifier.FINAL).build());

        // If this struct is extended by other structs, make it sealed
        if (!children.isEmpty()) {
            structSpecBuilder.addModifiers(Modifier.SEALED);
            // Add permits clause with all child class names
            List<ClassName> permittedClasses = children.stream()
                    .map(child -> ClassName.get(packageName, Utils.toPascalCase(child.getName())))
                    .toList();
            structSpecBuilder.addPermittedSubclasses(permittedClasses);
        } else {
            structSpecBuilder.addModifiers(Modifier.FINAL);
        }

        e.getExtends()
                .forEach(ext -> structSpecBuilder.superclass(ClassName.get(packageName, Utils.toPascalCase(ext))));

        structSpecBuilder.addMethod(this.defaultConstructor(""));
        structSpecBuilder.addMethod(this.wrapperConstructor(""));
        structSpecBuilder.addField(addProvider(e.getName()));
        structSpecBuilder.addMethods(getterAndSetters(e));

        final var toStringMethod = generateToString(e);
        structSpecBuilder.addMethod(toStringMethod);

        structSpecBuilder.addModifiers(Modifier.PUBLIC);
        return structSpecBuilder.build();
    }

    private void addingFields(GpuStruct e, final TypeSpec.Builder structSpecBuilder) {
        // Adding Fields.
        e.getMembers().forEach(m -> {
            final FieldSpec field = FieldSpec
                    .builder(Utils.map(m.getType()), Utils.toCamelCase(m.getName()), Modifier.PRIVATE)
                    // .initializer(CodeBlock.of("new $T()", Utils.map(m.getType())))
                    .build();

            structSpecBuilder.addField(field);
        });
    }

    private void oldAddGettersAndSetters(GpuStruct e, final TypeSpec.Builder structSpecBuilder) {
        // Adding getters
        e.getMembers().forEach(m -> {
            final MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(Utils.toCamelCase(m.getName()))
                    .addModifiers(Modifier.PUBLIC)
                    .returns(Utils.map(m.getType()));
            methodBuilder.addStatement("return this.$N", Utils.toCamelCase(m.getName()));
            structSpecBuilder.addMethod(methodBuilder.build());
        });

        // Adding setters
        e.getMembers().forEach(m -> {
            final MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(Utils.toCamelCase(m.getName()))
                    .addModifiers(Modifier.PUBLIC)
                    .returns(void.class)
                    .addParameter(Utils.map(m.getType()), Utils.toCamelCase(m.getName()));
            methodBuilder.addStatement("this.$N = $N", Utils.toCamelCase(m.getName()), Utils.toCamelCase(m.getName()));
            structSpecBuilder.addMethod(methodBuilder.build());
        });
    }

    public FieldSpec addProvider(String name) {
        final ClassName providerName = ClassName.get(packageName + ".spi", Utils.toPascalCase(name) + "Provider");
        final ClassName registry = ClassName.get(packageName + ".spi", "StructProviderRegistry");
        final var builder = FieldSpec.builder(providerName, "PROVIDER", Modifier.PRIVATE, Modifier.STATIC,
                Modifier.FINAL);
        builder.initializer("$T.load($T.class).findFirst().orElseThrow().get($T.class)", ServiceLoader.class, registry,
                providerName);

        return builder.build();
    }

    private void addDefaultAssignment(CodeBlock.Builder initBlock, String fieldName, TypeName fieldType) {
        if (fieldType.isPrimitive()) {
            if (fieldType.equals(TypeName.BOOLEAN)) {
                initBlock.addStatement("this.$N = false", fieldName);
            } else if (fieldType.equals(TypeName.BYTE) || fieldType.equals(TypeName.SHORT) ||
                    fieldType.equals(TypeName.INT) || fieldType.equals(TypeName.LONG)) {
                initBlock.addStatement("this.$N = 0", fieldName);
            } else if (fieldType.equals(TypeName.FLOAT)) {
                initBlock.addStatement("this.$N = 0.0f", fieldName);
            } else if (fieldType.equals(TypeName.DOUBLE)) {
                initBlock.addStatement("this.$N = 0.0", fieldName);
            } else if (fieldType.equals(TypeName.CHAR)) {
                initBlock.addStatement("this.$N = '\\0'", fieldName);
            }
        } else if (fieldType instanceof ArrayTypeName) {
            // For array types, use new Type[0]
            ArrayTypeName arrayType = (ArrayTypeName) fieldType;
            initBlock.addStatement("this.$N = new $T[0]", fieldName, arrayType.componentType());
        } else if (fieldType.equals(ClassName.get(String.class))) {
            // For String, use empty string
            initBlock.addStatement("this.$N = \"\"", fieldName);
        } else {
            // For all other reference types (enums, abstract classes, interfaces, etc.),
            // use null
            initBlock.addStatement("this.$N = null", fieldName);
        }
    }

    
    
    public MethodSpec defaultConstructor(String doc) {
        return MethodSpec.constructorBuilder()
                .addJavadoc(doc)
                .addModifiers(Modifier.PUBLIC)
                .addCode(CodeBlock.builder()
                        .add("this($N.initializer());", "PROVIDER").build())
                .build();
    }

    public MethodSpec wrapperConstructor(String doc) {
        final String pointerName = "memorySegment";
        return MethodSpec.constructorBuilder()
                .addJavadoc(doc)
                .addModifiers(Modifier.PRIVATE)
                .addParameter(ParameterSpec.builder(MemorySegment.class, pointerName).build())
                .addCode(CodeBlock.of(
                        "this.$N = $N;", pointerName, pointerName))
                .build();
    }

    public List<MethodSpec> getterAndSetters(final GpuStruct gpuStruct) {
        final List<MethodSpec> methods = new ArrayList<>(gpuStruct.getMembers().size() * 2);

        for (GpuStruct.Member member : gpuStruct.getMembers()) {
            final var getterSpecBuilder = MethodSpec.methodBuilder(Utils.toCamelCase(member.getName()));
            getterSpecBuilder.addModifiers(Modifier.PUBLIC);
            getterSpecBuilder.returns(Utils.map(member.getType()));
            getterSpecBuilder.addJavadoc(member.getDoc());
            getterSpecBuilder.addCode(
                    CodeBlock.of("return PROVIDER.$L(this.memorySegment);", Utils.toCamelCase(member.getName())));

            methods.add(getterSpecBuilder.build());

            final var setterSpecBuilder = MethodSpec.methodBuilder(Utils.toCamelCase(member.getName()));
            setterSpecBuilder.addModifiers(Modifier.PUBLIC);
            setterSpecBuilder.addParameter(Utils.map(member.getType()), Utils.toCamelCase(member.getName()));
            setterSpecBuilder.addJavadoc(member.getDoc());
            setterSpecBuilder.addCode(
                    CodeBlock.of("PROVIDER.$L(this.memorySegment, $L);", Utils.toCamelCase(member.getName()),
                            Utils.toCamelCase(member.getName())));

            methods.add(setterSpecBuilder.build());
        }

        return methods;
    }

    public MethodSpec generateToString(GpuStruct gpuStruct) {
        // Adding toString method
        MethodSpec.Builder toStringBuilder = MethodSpec.methodBuilder("toString")
                .addModifiers(Modifier.PUBLIC)
                .returns(String.class)
                .addAnnotation(Override.class);

        String className = Utils.toPascalCase(gpuStruct.getName());
        StringBuilder code = new StringBuilder("return \"$L[\"");
        List<String> args = new ArrayList<>();
        args.add(className);

        boolean first = true;
        for (Member m : gpuStruct.getMembers()) {
            String fieldName = Utils.toCamelCase(m.getName());
            if (!first) {
                code.append(" + \", \" + \"$L=\" + $N()");
                args.add(fieldName);
                args.add(fieldName);
            } else {
                code.append(" + \"$L=\" + $N()");
                args.add(fieldName);
                args.add(fieldName);
            }
            first = false;
        }
        code.append(" + \"]\";");

        toStringBuilder.addCode(CodeBlock.of(code.toString(), args.toArray()));

        return toStringBuilder.build();
    }
}
