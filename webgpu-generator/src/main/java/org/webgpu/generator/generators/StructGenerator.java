package org.webgpu.generator.generators;

import javax.lang.model.element.Modifier;
import java.util.List;

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
import com.palantir.javapoet.WildcardTypeName;

public class StructGenerator {

    private final YamlModel yamlModel;
    private final String packageName;

    private static final Logger logger = LoggerFactory.getLogger(StructGenerator.class);

    public StructGenerator(YamlModel yamlModel, String packageName) {
        this.yamlModel = yamlModel;
        this.packageName = packageName;
    }

    public List<JavaFile> generate() {

        yamlModel.getStructs().forEach(e -> logger.info("Generated struct: {}", e.getName()));

        return yamlModel.getStructs().stream().map(e -> {
            return generateStructClass(e);
        }).map(ts -> JavaFile.builder(packageName, ts).build()).toList();

    }

    private TypeSpec generateStructRecord(GpuStruct e) {
        TypeSpec.Builder structSpecBuilder = TypeSpec.recordBuilder(Utils.toPascalCase(e.getName()))
                .addJavadoc(e.getDoc());

        MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder();
        for (Member f : e.getMembers()) {
            final ParameterSpec.Builder parameterSpecBuilder = ParameterSpec
                    .builder(Utils.map(f.getType()), Utils.toCamelCase(f.getName())).addJavadoc(f.getDoc());
                    
            constructorBuilder.addParameter(
                    parameterSpecBuilder.build());
        }

        structSpecBuilder.recordConstructor(constructorBuilder.build());
        structSpecBuilder.addModifiers(Modifier.PUBLIC);
        return structSpecBuilder.build();
    }

    private TypeSpec generateStructClass(GpuStruct e) {
        final TypeSpec.Builder structSpecBuilder = TypeSpec.classBuilder(Utils.toPascalCase(e.getName()))
                .addJavadoc(e.getDoc());

        e.getExtends().forEach(ext -> {
            structSpecBuilder.superclass(ClassName.get(packageName, Utils.toPascalCase(ext)));
        });

        MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder();
        constructorBuilder.addModifiers(Modifier.PUBLIC);
        for (Member f : e.getMembers()) {
            final ParameterSpec.Builder parameterSpecBuilder = ParameterSpec
                    .builder(Utils.map(f.getType()), Utils.toCamelCase(f.getName())).addJavadoc(f.getDoc());

            constructorBuilder.addParameter(
                    parameterSpecBuilder.build());
        }

        

        structSpecBuilder.addMethod(constructorBuilder.build());

        if (!e.getMembers().isEmpty()) {
            MethodSpec.Builder defaultConstructorBuilder = MethodSpec.constructorBuilder()
                    .addModifiers(Modifier.PUBLIC);
            
            CodeBlock.Builder initBlock = CodeBlock.builder();
            e.getMembers().forEach(m -> {
                String fieldName = Utils.toCamelCase(m.getName());
                TypeName fieldType = Utils.map(m.getType());
                addDefaultAssignment(initBlock, fieldName, fieldType);
            });
            
            defaultConstructorBuilder.addCode(initBlock.build());
            structSpecBuilder.addMethod(defaultConstructorBuilder.build());
        }
        // Adding Fields.
        e.getMembers().forEach(m -> {
            final FieldSpec field = FieldSpec
                    .builder(Utils.map(m.getType()), Utils.toCamelCase(m.getName()), Modifier.PRIVATE)
                    // .initializer(CodeBlock.of("new $T()", Utils.map(m.getType())))
                    .build();
            
            structSpecBuilder.addField(field);
        });

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

        // Adding toString method
        MethodSpec.Builder toStringBuilder = MethodSpec.methodBuilder("toString")
                .addModifiers(Modifier.PUBLIC)
                .returns(String.class)
                .addAnnotation(Override.class);

        String className = Utils.toPascalCase(e.getName());
        StringBuilder code = new StringBuilder("return \"$L[\"");
        List<Object> args = new java.util.ArrayList<>();
        args.add(className);
        
        boolean first = true;
        for (Member m : e.getMembers()) {
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
        structSpecBuilder.addMethod(toStringBuilder.build());

        structSpecBuilder.addModifiers(Modifier.PUBLIC);
        return structSpecBuilder.build();
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
            // For all other reference types (enums, abstract classes, interfaces, etc.), use null
            initBlock.addStatement("this.$N = null", fieldName);
        }
    }
}
