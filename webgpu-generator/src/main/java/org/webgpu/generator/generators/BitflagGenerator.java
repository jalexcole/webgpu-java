package org.webgpu.generator.generators;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webgpu.generator.domain.YamlModel;
import org.webgpu.utils.Bitflag;

import com.palantir.javapoet.JavaFile;
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
            var bitFlagBuilder = TypeSpec.enumBuilder(e.getName()).addJavadoc(e.getDoc()).addAnnotation(Bitflag.class).addSuperinterface(Utils.map("WGPUBitFlag"));
            for (int i = 0; i < e.getEntries().size(); i++) {
                logger.info("Generated bitflag: {}", e.getEntries().get(i).getName());
                bitFlagBuilder.addEnumConstant(e.getEntries().get(i).getName());
            }


            return bitFlagBuilder.build();
        }).map(ts -> JavaFile.builder(packageName, ts).build()).toList();
    }

}
