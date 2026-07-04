package org.webgpu.generator.generators;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.webgpu.generator.domain.GpuCallback;
import org.webgpu.generator.domain.YamlModel;

import com.palantir.javapoet.JavaFile;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.dataformat.yaml.YAMLFactory;
@Disabled
class CallbackGeneratorTest {
    
    private YamlModel yamlModel;
    private String packageName = "org.webgpu.api";
    private CallbackGenerator callbackGenerator;
    
    @BeforeEach
    void setUp() {
        yamlModel = new YamlModel();
        // Initialize all lists to avoid NPEs
        yamlModel.setBitflags(List.of());
        yamlModel.setEnums(List.of());
        yamlModel.setStructs(List.of());
        yamlModel.setFunctions(List.of());
        yamlModel.setObjects(List.of());
        yamlModel.setConstants(List.of());
        yamlModel.setCallbacks(List.of());
        callbackGenerator = new CallbackGenerator(packageName);
    }
    
    @Test
    void testEmptyCallbacks() {
        yamlModel.setCallbacks(List.of());
        
        List<JavaFile> files = callbackGenerator.generateCallbacks(yamlModel);
        
        assertNotNull(files);
        assertTrue(files.isEmpty());
    }
    
    @Test
    void testSingleCallback() {
        GpuCallback callback = new GpuCallback();
        callback.setName("WGPUProc");
        callback.setDoc("A callback procedure");
        
        yamlModel.setCallbacks(List.of(callback));
        
        List<JavaFile> files = callbackGenerator.generateCallbacks(yamlModel);
        
        assertNotNull(files);
        assertEquals(1, files.size());
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        assertTrue(source.contains("package " + packageName));
        assertTrue(source.contains("interface WGPUProc"));
    }
    
    @Test
    void testCallbackWithArgs() {
        GpuCallback callback = new GpuCallback();
        callback.setName("ErrorCallback");
        callback.setDoc("Error callback");
        
        GpuCallback.Arg arg = new GpuCallback.Arg();
        arg.setName("error_type");
        arg.setType("enum.ErrorType");
        arg.setDoc("The error type");
        
        callback.setArgs(List.of(arg));
        yamlModel.setCallbacks(List.of(callback));
        
        List<JavaFile> files = callbackGenerator.generateCallbacks(yamlModel);
        
        assertNotNull(files);
        assertEquals(1, files.size());
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Check that the interface has the expected method
        assertTrue(source.contains("ErrorType"));
        assertTrue(source.contains("errorType"));
        assertTrue(source.contains("void"));
    }
    
    @Test
    void testCallbackWithBitflagArgs() {
        GpuCallback callback = new GpuCallback();
        callback.setName("BitflagCallback");
        
        GpuCallback.Arg arg = new GpuCallback.Arg();
        arg.setName("flags");
        arg.setType("bitflag.BufferUsage");
        
        callback.setArgs(List.of(arg));
        yamlModel.setCallbacks(List.of(callback));
        
        List<JavaFile> files = callbackGenerator.generateCallbacks(yamlModel);
        
        assertNotNull(files);
        assertEquals(1, files.size());
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Check that bitflag types are properly handled
        assertTrue(source.contains("EnumSet"));
        assertTrue(source.contains("BufferUsage"));
    }
    
    @Test
    void testCallbackWithMultipleArgs() {
        GpuCallback callback = new GpuCallback();
        callback.setName("MultiArgCallback");
        
        GpuCallback.Arg arg1 = new GpuCallback.Arg();
        arg1.setName("arg1");
        arg1.setType("int");
        
        GpuCallback.Arg arg2 = new GpuCallback.Arg();
        arg2.setName("arg2");
        arg2.setType("String");
        
        callback.setArgs(List.of(arg1, arg2));
        yamlModel.setCallbacks(List.of(callback));
        
        List<JavaFile> files = callbackGenerator.generateCallbacks(yamlModel);
        
        assertNotNull(files);
        assertEquals(1, files.size());
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Check that both args are present
        assertTrue(source.contains("int arg1"));
        assertTrue(source.contains("String arg2"));
    }
    
    @Test
    void testMultipleCallbacks() {
        GpuCallback callback1 = new GpuCallback();
        callback1.setName("Callback1");
        
        GpuCallback callback2 = new GpuCallback();
        callback2.setName("Callback2");
        
        yamlModel.setCallbacks(List.of(callback1, callback2));
        
        List<JavaFile> files = callbackGenerator.generateCallbacks(yamlModel);
        
        assertNotNull(files);
        assertEquals(2, files.size());
        
        String source1 = files.getFirst().toString();
        String source2 = files.get(1).toString();
        assertTrue(source1.contains("interface Callback1"));
        assertTrue(source2.contains("interface Callback2"));
    }
    
    @Test
    void testCallbackInterfaceAnnotations() {
        GpuCallback callback = new GpuCallback();
        callback.setName("TestCallback");
        callback.setDoc("Test callback with documentation");
        
        yamlModel.setCallbacks(List.of(callback));
        
        List<JavaFile> files = callbackGenerator.generateCallbacks(yamlModel);
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Check that it's a functional interface
        assertTrue(source.contains("@FunctionalInterface"));
        assertTrue(source.contains("interface"));
        
        // Check that the method is abstract
        assertTrue(source.contains("abstract"));
        assertTrue(source.contains("apply"));
        
        // Check documentation
        assertTrue(source.contains("Test callback with documentation"));
    }
    
    @Test
    void testCallbackWithYamlFile() {
        final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        var yaml = objectMapper.readTree(new File("../wgpu-native/ffi/webgpu-headers/webgpu.yml"));
        YamlModel yamlModel = objectMapper.convertValue(yaml, YamlModel.class);

        CallbackGenerator callbackGenerator = new CallbackGenerator("org.webgpu.generator");
        var enumFiles = callbackGenerator.generateCallbacks(yamlModel);
        
        // Just check that it doesn't throw exceptions with real data
        assertNotNull(enumFiles);
    }
}
