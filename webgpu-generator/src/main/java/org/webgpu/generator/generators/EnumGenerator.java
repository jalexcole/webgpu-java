package org.webgpu.generator.generators;


import java.util.List;
import java.util.Optional;

import javax.lang.model.element.Modifier;

import com.palantir.javapoet.CodeBlock;
import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.generator.domain.YamlModel;

public class EnumGenerator {


    private YamlModel yamlModel;
	private String packageName;

    private static final Logger logger = LoggerFactory.getLogger(EnumGenerator.class);

    public EnumGenerator(YamlModel yamlModel, String packageName) {
        this.yamlModel = yamlModel;
        this.packageName = packageName;
    }
    

    public List<JavaFile> generate() {

        yamlModel.getEnums().stream().forEach(e -> logger.info("Generated enum: {}", e.getName()));

        return yamlModel.getEnums().stream().map(e -> {
            var enumBuilder = TypeSpec.enumBuilder(Utils.toPascalCase(e.getName())).addJavadoc(e.getDoc());

            for (int i = 0; i < e.getEntries().size(); i++) {
                
                try {
                var entry = Optional.ofNullable(e.getEntries().get(i));

                    if (entry.isPresent()) {
                        var name = entry.get().getName().toUpperCase();

                        var chars = name.toCharArray();

                        final var usable_name = switch(chars[0]) {
                            case '0' -> "ZERO_" + name.substring(1);
                            case '1' -> "ONE_" + name.substring(1);
                            case '2' -> "TWO_" + name.substring(1);
                            case '3' -> "THREE_" + name.substring(1);
                            case '4' -> "FOUR_" + name.substring(1);
                            case '5' -> "FIVE_" + name.substring(1);
                            case '6' -> "SIX_" + name.substring(1);
                            case '7' -> "SEVEN_" + name.substring(1);
                            case '8' -> "EIGHT_" + name.substring(1);
                            case '9' -> "NINE_" + name.substring(1);
                            default -> name;
                        };

                        enumBuilder.addEnumConstant(usable_name, TypeSpec.anonymousClassBuilder("$L", i).addJavadoc(entry.get().getDoc()).build());
                        
                } else {
                    enumBuilder.addEnumConstant("NULL", TypeSpec.anonymousClassBuilder("$L", i).build());
                }
                } catch (Exception ex) {
                    logger.error(ex.getMessage());
                }
               

                
            }
            enumBuilder.addField(FieldSpec.builder(TypeName.INT, "value", Modifier.PRIVATE, Modifier.FINAL).build());

            enumBuilder.addMethod(MethodSpec.constructorBuilder().addParameter(TypeName.INT, "value")
                    .addCode(CodeBlock.of("this.value = value;")).addModifiers(Modifier.PRIVATE).build());

            enumBuilder.addMethod(MethodSpec.methodBuilder("value").addModifiers(Modifier.PUBLIC)
                    .returns(TypeName.INT).addCode(CodeBlock.of("return this.value;")).build());

            return enumBuilder.build();
        }).map(ts -> JavaFile.builder(packageName, ts).build()).toList();
    }
}
