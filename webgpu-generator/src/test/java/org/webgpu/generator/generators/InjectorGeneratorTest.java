package org.webgpu.generator.generators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.webgpu.generator.domain.GpuFunction;
import org.webgpu.generator.domain.YamlModel;

import com.palantir.javapoet.JavaFile;

@Disabled
class InjectorGeneratorTest {
    
    private YamlModel yamlModel;
    private String packageName = "org.webgpu.api";
    private InjectorGenerator injectorGenerator;
    
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
        injectorGenerator = new InjectorGenerator(yamlModel, packageName);
    }
    
    @Test
    void testEmptyFunctions() {
        yamlModel.setFunctions(List.of());
        
        JavaFile file = injectorGenerator.generate();
        
        assertNotNull(file);
        String source = file.toString();
        assertTrue(source.contains("package " + packageName + ".spi"));
        assertTrue(source.contains("interface InstanceInjector"));
    }
    
    @Test
    void testSingleFunction() {
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
        
        JavaFile file = injectorGenerator.generate();
        
        assertNotNull(file);
        String source = file.toString();
        assertTrue(source.contains("package " + packageName + ".spi"));
        assertTrue(source.contains("interface InstanceInjector"));
        
        // Check that the method is present
        assertTrue(source.contains("createInstance"));
        assertTrue(source.contains("InstanceDescriptor"));
        assertTrue(source.contains("Instance"));
    }
    
    @Test
    void testFunctionWithNoReturn() {
        GpuFunction function = new GpuFunction();
        function.setName("destroy_instance");
        function.setDoc("Destroys an instance");
        
        GpuFunction.Arg arg = new GpuFunction.Arg();
        arg.setName("instance");
        arg.setType("object.Instance");
        
        function.setArgs(List.of(arg));
        // No return value
        
        yamlModel.setFunctions(List.of(function));
        
        JavaFile file = injectorGenerator.generate();
        
        assertNotNull(file);
        
        String source = file.toString();
        
        // Check that the method returns void
        assertTrue(source.contains("destroyInstance"));
        assertTrue(source.contains("void"));
    }
    
    @Test
    void testMultipleFunctions() {
        GpuFunction function1 = new GpuFunction();
        function1.setName("func1");
        function1.setDoc("Function 1");
        
        GpuFunction function2 = new GpuFunction();
        function2.setName("func2");
        function2.setDoc("Function 2");
        
        yamlModel.setFunctions(List.of(function1, function2));
        
        JavaFile file = injectorGenerator.generate();
        
        assertNotNull(file);
        
        String source = file.toString();
        
        // Check that both methods are present
        assertTrue(source.contains("func1"));
        assertTrue(source.contains("func2"));
    }
    
    @Test
    void testFunctionWithPointerArgs() {
        GpuFunction function = new GpuFunction();
        function.setName("test_func");
        
        GpuFunction.Arg arg1 = new GpuFunction.Arg();
        arg1.setName("immutable_arg");
        arg1.setType("int");
        arg1.setPointer("immutable");
        
        GpuFunction.Arg arg2 = new GpuFunction.Arg();
        arg2.setName("mutable_arg");
        arg2.setType("String");
        arg2.setPointer("mutable");
        
        function.setArgs(List.of(arg1, arg2));
        
        yamlModel.setFunctions(List.of(function));
        
        JavaFile file = injectorGenerator.generate();
        
        assertNotNull(file);
        
        String source = file.toString();
        
        // Check that pointer annotations are present
        assertTrue(source.contains("@Immutable"));
        assertTrue(source.contains("@Mutable"));
    }
    
    @Test
    void testInterfaceModifiers() {
        yamlModel.setFunctions(List.of());
        
        JavaFile file = injectorGenerator.generate();
        
        String source = file.toString();
        
        // Check that it's a public interface
        assertTrue(source.contains("public interface"));
    }
    
    @Test
    void testInjectorClassName() {
        assertEquals("InstanceInjector", injectorGenerator.injectorClassName);
    }
    
    @Test
    void testInjectorFieldName() {
        assertEquals("INSTANCE_INJECTOR", injectorGenerator.injectorFieldName);
    }
    
    @Test
    void testPackageNameInSpi() {
        yamlModel.setFunctions(List.of());
        
        JavaFile file = injectorGenerator.generate();
        
        String source = file.toString();
        assertTrue(source.contains("package " + packageName + ".spi"));
    }
}
