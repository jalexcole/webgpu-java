package org.webgpu.generator;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.webgpu.generator.domain.YamlModel;
import org.webgpu.generator.generators.BitflagGenerator;
import org.webgpu.generator.generators.CallbackGenerator;
import org.webgpu.generator.generators.EnumGenerator;
import org.webgpu.generator.generators.InterfaceGenerator;
import org.webgpu.generator.generators.MainFileGenerator;
import org.webgpu.generator.generators.StructGenerator;

import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.TypeSpec;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.dataformat.yaml.YAMLFactory;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES, threadSafe = true)
public class GeneratorMojo extends AbstractMojo {
    
    @Parameter(name = "packageName", property = "package", required = true)
    private String packageName;

    @Parameter(name = "path", property = "path", required = true)
    private File path;

    @Parameter(defaultValue = "${project.build.directory}", readonly = true)
    private File buildDir;

    private final Log logger = getLog();

    private static final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

	@Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        logger.info("Executing GeneratorMojo");
        logger.info("Using package name: " + packageName);
        logger.info("Path is correct: " + path.exists());

        if (!path.exists()) {
            throw new MojoExecutionException("Path does not exist");
        }
        
        File generatedSourcesFile = new File(buildDir, "generated-sources");
        if (!generatedSourcesFile.exists()) {
            generatedSourcesFile.mkdirs();
        }
        try {
			createBaseFiles(generatedSourcesFile);
		} catch (IOException e) {
			logger.error(e);
		}
        var yamlTree = objectMapper.readTree(path);
        var yamlModel = objectMapper.convertValue(yamlTree, YamlModel.class);

        CallbackGenerator callbackGenerator = new CallbackGenerator(packageName);
        var callbacks = callbackGenerator.generateCallbacks(yamlModel);

        for (var c : callbacks) {
            try {
                c.writeTo(generatedSourcesFile);
            } catch (IOException e) {
                logger.error(e);
            }
        }

        MainFileGenerator mainFileGenerator = new MainFileGenerator(yamlModel, packageName);
        var mainFile = mainFileGenerator.generate();
        try {
            mainFile.writeTo(generatedSourcesFile);
        } catch (IOException e) {
            logger.error(e);
        }

        StructGenerator structGenerator = new StructGenerator(yamlModel, packageName);

        var structs = structGenerator.generate();
        for (var s : structs) {
            try {

                s.writeTo(generatedSourcesFile);

            } catch (Exception e) {
                logger.error(e);
            }
        }

        EnumGenerator enumGenerator = new EnumGenerator(yamlModel, packageName);
        var enums = enumGenerator.generate();
        for (var e : enums) {
            try {
                e.writeTo(generatedSourcesFile);
            } catch (IOException e1) {
                logger.error(e1);
            }
        }

        InterfaceGenerator interfaceGenerator = new InterfaceGenerator(yamlModel, packageName);

        var interfaces = interfaceGenerator.generate();
        for (var i : interfaces) {
            try {
                i.writeTo(generatedSourcesFile);
            } catch (IOException e) {
                logger.error(e);
            }
        }

        BitflagGenerator bitflagGenerator = new BitflagGenerator(yamlModel, packageName);
        var bitflags = bitflagGenerator.generate();
        for (var b : bitflags) {
            try {
                b.writeTo(generatedSourcesFile);
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }
    
    private void createBaseFiles(File generatedSourcesFile) throws IOException {
        var ob = TypeSpec.interfaceBuilder("WGPUObjectBase").build();
        JavaFile.builder(packageName, ob).build().writeTo(generatedSourcesFile);
        var bf = TypeSpec.interfaceBuilder("WGPUBitFlag").build();
        JavaFile.builder(packageName, bf).build().writeTo(generatedSourcesFile);
    }
}
