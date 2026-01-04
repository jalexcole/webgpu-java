package org.webgpu.generator.generators;

import java.util.List;

import javax.lang.model.element.Modifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.generator.domain.YamlModel;
import org.webgpu.utils.Bitflag;

import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;

public class BitflagGenerator {
    
    private YamlModel yamlModel;
    private String packageName;
    private static final Logger logger = LoggerFactory.getLogger(BitflagGenerator.class);
    public BitflagGenerator(YamlModel yamlModel, String packageName) {
        this.yamlModel = yamlModel;
        this.packageName = packageName;
    }

    public List<JavaFile> generate() {
        return yamlModel.getBitflags().stream().map(e -> {
            var bitFlagBuilder = TypeSpec.enumBuilder(Utils.toPascalCase(e.getName())).addModifiers(Modifier.PUBLIC).addJavadoc(e.getDoc()).addAnnotation(Bitflag.class).addSuperinterface(Utils.map("WGPUBitFlag"));
            for (int i = 0; i < e.getEntries().size(); i++) {
                logger.info("Generated bitflag: {}", e.getEntries().get(i).getName());
                bitFlagBuilder.addEnumConstant(e.getEntries().get(i).getName().toUpperCase(),
                        TypeSpec.anonymousClassBuilder("$L", (i != 0 ? 1 << (i - 1) : 0)).build());
            }
            
            bitFlagBuilder.addField(FieldSpec.builder(TypeName.LONG, "value", Modifier.PRIVATE, Modifier.FINAL).build());
            bitFlagBuilder.addMethod(MethodSpec.constructorBuilder().addParameter(TypeName.LONG, "value")
                    .addCode("this.value = value;").build());
            bitFlagBuilder.addMethod(MethodSpec.methodBuilder("value").addModifiers(Modifier.PUBLIC).returns(TypeName.LONG).addStatement("return value").build());


            return bitFlagBuilder.build();
        }).map(ts -> JavaFile.builder(packageName, ts).build()).toList();
    }

}
