package org.webgpu.generator.generators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.webgpu.generator.domain.GpuConstant;
import org.webgpu.generator.domain.GpuFunction;
import org.webgpu.generator.domain.YamlModel;

import com.palantir.javapoet.JavaFile;

@Disabled
class MainFileGeneratorTest {
    
    private YamlModel yamlModel;
    private String packageName = "org.webgpu.api";
    private MainFileGenerator mainFileGenerator;
    
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
        mainFileGenerator = new MainFileGenerator(yamlModel, packageName);
    }
    
    @Test
    void testEmptyModel() {
        yamlModel.setFunctions(List.of());
        yamlModel.setConstants(List.of());
        
        JavaFile file = mainFileGenerator.generate();
        
        assertNotNull(file);
        String source = file.toString();
        assertTrue(source.contains("package " + packageName));
        assertTrue(source.contains("class WGPU"));
    }
    
    @Test
    void testConstantsGeneration() {
        // Initialize lists to avoid NPE
        yamlModel.setFunctions(List.of());
        
        GpuConstant constant1 = new GpuConstant();
        constant1.setName("MAX_BUFFER_SIZE");
        constant1.setValue("uint32_max");
        constant1.setDoc("Maximum buffer size");
        
        GpuConstant constant2 = new GpuConstant();
        constant2.setName("MAX_TEXTURE_DIMENSION");
        constant2.setValue("uint32_max");
        constant2.setDoc("Maximum texture dimension");
        
        GpuConstant constant3 = new GpuConstant();
        constant3.setName("INFINITY_VALUE");
        constant3.setValue("nan");
        constant3.setDoc("Infinity value");
        
        yamlModel.setConstants(List.of(constant1, constant2, constant3));
        
        JavaFile file = mainFileGenerator.generate();
        
        assertNotNull(file);
        
        String source = file.toString();
        
        // Check that constants are generated
        assertTrue(source.contains("MAX_BUFFER_SIZE"));
        assertTrue(source.contains("MAX_TEXTURE_DIMENSION"));
        assertTrue(source.contains("INFINITY_VALUE"));
        
        // Check constant types and initializers
        assertTrue(source.contains("Integer.MAX_VALUE"));
        assertTrue(source.contains("Double.NaN"));
    }
    
    @Test
    void testAllConstantTypes() {
        // Test all supported constant value types
        GpuConstant uint32Max = new GpuConstant();
        uint32Max.setName("UINT32_MAX");
        uint32Max.setValue("uint32_max");
        uint32Max.setDoc("uint32 max constant");
        
        GpuConstant uint64Max = new GpuConstant();
        uint64Max.setName("UINT64_MAX");
        uint64Max.setValue("uint64_max");
        uint64Max.setDoc("uint64 max constant");
        
        GpuConstant usizeMax = new GpuConstant();
        usizeMax.setName("USIZE_MAX");
        usizeMax.setValue("usize_max");
        usizeMax.setDoc("usize max constant");
        
        GpuConstant nan = new GpuConstant();
        nan.setName("NAN");
        nan.setValue("nan");
        nan.setDoc("NaN constant");
        
        yamlModel.setConstants(List.of(uint32Max, uint64Max, usizeMax, nan));
        
        JavaFile file = mainFileGenerator.generate();
        
        assertNotNull(file);
        
        String source = file.toString();
        
        // Check all constant types are handled
        assertTrue(source.contains("Integer.MAX_VALUE"));  // uint32_max and usize_max
        assertTrue(source.contains("Long.MAX_VALUE"));     // uint64_max
        assertTrue(source.contains("Double.NaN"));         // nan
    }
    
    @Test
    void testFunctionGeneration() {
        GpuFunction function = new GpuFunction();
        function.setName("create_instance");
        function.setDoc("Creates an instance");
        
        GpuFunction.Arg arg = new GpuFunction.Arg();
        arg.setName("descriptor");
        arg.setType("struct.InstanceDescriptor");
        
        function.setArgs(List.of(arg));
        
        GpuFunction.Return returnValue = new GpuFunction.Return();
        returnValue.setType("object.Instance");
        function.setReturns(returnValue);
        
        yamlModel.setFunctions(List.of(function));
        
        JavaFile file = mainFileGenerator.generate();
        
        assertNotNull(file);
        
        String source = file.toString();
        
        // Check that the function is present
        assertTrue(source.contains("createInstance"));
        assertTrue(source.contains("descriptor"));
        assertTrue(source.contains("Instance"));
    }
    
    @Test
    void testVoidFunctionGeneration() {
        GpuFunction function = new GpuFunction();
        function.setName("destroy_instance");
        
        GpuFunction.Arg arg = new GpuFunction.Arg();
        arg.setName("instance");
        arg.setType("object.Instance");
        
        function.setArgs(List.of(arg));
        // No return value - void function
        
        yamlModel.setFunctions(List.of(function));
        
        JavaFile file = mainFileGenerator.generate();
        
        assertNotNull(file);
        
        String source = file.toString();
        
        // Check that the void function is present
        assertTrue(source.contains("destroyInstance"));
        assertTrue(source.contains("void"));
    }
    
    @Test
    void testFunctionWithPointerArgs() {
        GpuFunction function = new GpuFunction();
        function.setName("test_func");
        
        GpuFunction.Arg arg = new GpuFunction.Arg();
        arg.setName("mutable_descriptor");
        arg.setType("struct.Descriptor");
        arg.setPointer("mutable");
        
        function.setArgs(List.of(arg));
        
        yamlModel.setFunctions(List.of(function));
        
        JavaFile file = mainFileGenerator.generate();
        
        assertNotNull(file);
        
        String source = file.toString();
        
        // Check that pointer annotations are present
        assertTrue(source.contains("@Mutable"));
    }
    
    @Test
    void testClassModifiers() {
        JavaFile file = mainFileGenerator.generate();
        
        String source = file.toString();
        
        // Check that it's a public final class
        assertTrue(source.contains("public final class WGPU"));
    }
    
    @Test
    void testInjectorField() {
        JavaFile file = mainFileGenerator.generate();
        
        String source = file.toString();
        
        // Check that injector field is present
        assertTrue(source.contains("INSTANCE_INJECTOR"));
        assertTrue(source.contains("ServiceLoader.load"));
    }
    
    @Test
    void testMultipleFunctionsAndConstants() {
        // Initialize with mutable lists
        yamlModel.setFunctions(new java.util.ArrayList<>());
        yamlModel.setConstants(new java.util.ArrayList<>());
        
        // Add constants
        GpuConstant constant = new GpuConstant();
        constant.setName("TEST_CONSTANT");
        constant.setValue("uint32_max");
        constant.setDoc("Test constant");
        yamlModel.getConstants().add(constant);
        
        // Add functions with arguments (MainFileGenerator expects functions to have args)
        GpuFunction function1 = new GpuFunction();
        function1.setName("func1");
        function1.setDoc("Function 1");
        GpuFunction.Arg arg1 = new GpuFunction.Arg();
        arg1.setName("arg1");
        arg1.setType("int");
        function1.setArgs(List.of(arg1));
        
        GpuFunction function2 = new GpuFunction();
        function2.setName("func2");
        function2.setDoc("Function 2");
        GpuFunction.Arg arg2 = new GpuFunction.Arg();
        arg2.setName("arg2");
        arg2.setType("String");
        function2.setArgs(List.of(arg2));
        
        yamlModel.getFunctions().addAll(List.of(function1, function2));
        
        JavaFile file = mainFileGenerator.generate();
        
        assertNotNull(file);
        
        String source = file.toString();
        
        // Check that both functions and constant are present
        assertTrue(source.contains("TEST_CONSTANT"));
        assertTrue(source.contains("func1"));
        assertTrue(source.contains("func2"));
    }
    
    @Test
    void testUnknownConstantValue() {
        GpuConstant constant = new GpuConstant();
        constant.setName("UNKNOWN_CONSTANT");
        constant.setValue("unknown_value");
        
        yamlModel.setConstants(List.of(constant));
        
        // This should throw an IllegalStateException
        assertThrows(IllegalStateException.class, () -> {
            mainFileGenerator.generate();
        });
    }
}
