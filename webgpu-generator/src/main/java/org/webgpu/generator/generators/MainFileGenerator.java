package org.webgpu.generator.generators;

import java.lang.foreign.Linker;
import java.lang.foreign.SymbolLookup;
import java.util.ServiceLoader;

import javax.lang.model.element.Modifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.generator.domain.YamlModel;

import com.palantir.javapoet.CodeBlock;
import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;

public class MainFileGenerator {

    private final YamlModel yamlModel;
    private final String packageName;

    private static final Logger logger = LoggerFactory.getLogger(MainFileGenerator.class);

    public MainFileGenerator(YamlModel yamlModel, String packageName) {
        this.yamlModel = yamlModel;
        this.packageName = packageName;
    }

    public JavaFile generate() {

        var wgpuBuilder = TypeSpec.classBuilder("WGPU");
        addConstants(wgpuBuilder);
        addFunctions(wgpuBuilder);
        wgpuBuilder.addModifiers(Modifier.PUBLIC, Modifier.FINAL);
        return JavaFile.builder(packageName, wgpuBuilder.build()).build();
    }

    private void addConstants(TypeSpec.Builder wgpuBuilder) {

        yamlModel.getConstants().stream().forEach(e -> logger.info("Generated constant: {}", e.getName()));

        yamlModel.getConstants().stream().forEach(e -> {

            var fieldSpec = switch (e.getValue()) {
                case "uint32_max" -> FieldSpec
                        .builder(TypeName.INT, Utils.toScreamingSnakeCase(e.getName()), Modifier.PUBLIC,
                                Modifier.STATIC, Modifier.FINAL)
                        .addJavadoc(e.getDoc()).initializer(CodeBlock.of("Integer.MAX_VALUE")).build();

                case "uint64_max" -> FieldSpec
                        .builder(TypeName.LONG, Utils.toScreamingSnakeCase(e.getName()), Modifier.PUBLIC,
                                Modifier.STATIC, Modifier.FINAL)
                        .addJavadoc(e.getDoc()).initializer(CodeBlock.of("Long.MAX_VALUE")).build();

                case "usize_max" ->
                    FieldSpec
                            .builder(TypeName.INT, Utils.toScreamingSnakeCase(e.getName()), Modifier.PUBLIC,
                                    Modifier.STATIC, Modifier.FINAL)
                            .addJavadoc(e.getDoc()).initializer(CodeBlock.of("Integer.MAX_VALUE")).build();

                case "nan" -> FieldSpec
                        .builder(TypeName.DOUBLE, Utils.toScreamingSnakeCase(e.getName()), Modifier.PUBLIC,
                                Modifier.STATIC, Modifier.FINAL)
                        .addJavadoc(e.getDoc()).initializer(CodeBlock.of("Double.NaN")).build();

                default -> throw new IllegalStateException("Unknown constant value: " + e.getValue());
            };

            wgpuBuilder.addField(fieldSpec);

        });
    }

    public void addFunctions(TypeSpec.Builder wgpuBuilder) {
        yamlModel.getFunctions().forEach(e -> logger.info("Generated function: {}", e.getName()));
        yamlModel.getFunctions().forEach(f -> {
            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(Utils.toCamelCase(f.getName()))
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL);

            final TypeName returnType = f.getReturns().map(r -> Utils.map(r.getType())).orElse(TypeName.VOID);

            for (var a : f.getArgs()) {

                if (a.getPointer().isPresent()) {
                    methodBuilder.addParameter(Utils.map(a.getType())
                            .annotated(Utils.mapPointer(a.getPointer().get())), Utils.toCamelCase(a.getName()));
                } else {
                    methodBuilder.addParameter(Utils.map(a.getType()), a.getName());
                }

            }
            f.getReturns().ifPresent(r -> methodBuilder.returns(Utils.map(r.getType())));
                if (returnType != TypeName.VOID) {
                
            final TypeName builderType = f.getReturns().map(r -> Utils.map(r.getType() + "Builder"))
                                        .orElseThrow();
                
            final CodeBlock codeBlock = CodeBlock.builder()
                .addStatement("var builder = $T.load($T.class).findFirst().orElseThrow()",
                ServiceLoader.class,
                                                        builderType)
                .addStatement("return builder.$L($L).build()", f.getArgs().getFirst().getName(), f.getArgs().getFirst().getName())
                .build();

                methodBuilder.addCode(codeBlock);
            }

            wgpuBuilder.addMethod(methodBuilder.build());
        });
    }

    public void addFields(TypeSpec.Builder wgpuBuilder) {
        // static final SymbolLookup SYMBOL_LOOKUP =
        // SymbolLookup.libraryLookup(System.mapLibraryName("wgpu_native"),
        // LIBRARY_ARENA)
        // .or(SymbolLookup.loaderLookup())
        // .or(Linker.nativeLinker().defaultLookup());

        FieldSpec symbolLookupField = FieldSpec.builder(SymbolLookup.class, "SYMBOL_LOOKUP",
                Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                .initializer(
                        "$T.libraryLookup($T.mapLibraryName($S), $N)\n" +
                                "    .or($T.loaderLookup())\n" +
                                "    .or($T.nativeLinker().defaultLookup())",
                        SymbolLookup.class,
                        System.class,
                        "wgpu_native",
                        "LIBRARY_ARENA",
                        SymbolLookup.class,
                        Linker.class)
                .build();

        wgpuBuilder.addField(symbolLookupField);
    }
}
