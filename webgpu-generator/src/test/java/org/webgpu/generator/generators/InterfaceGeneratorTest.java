package org.webgpu.generator.generators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.webgpu.generator.domain.GpuCallback;
import org.webgpu.generator.domain.GpuFunction;
import org.webgpu.generator.domain.GpuObject;
import org.webgpu.generator.domain.YamlModel;

import com.palantir.javapoet.JavaFile;

@Disabled
class InterfaceGeneratorTest {
    
    private YamlModel yamlModel;
    private String packageName = "org.webgpu.api";
    private InterfaceGenerator interfaceGenerator;
    
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
        interfaceGenerator = new InterfaceGenerator(yamlModel, packageName);
    }
    
    @Test
    void testEmptyObjects() {
        yamlModel.setObjects(List.of());
        
        List<JavaFile> files = interfaceGenerator.generate();
        
        assertNotNull(files);
        // Should still generate WGPUObject
        assertEquals(1, files.size());
        
        String source = files.getFirst().toString();
        assertTrue(source.contains("interface WGPUObject"));
    }
    
    @Test
    void testSingleObject() {
        GpuObject object = new GpuObject();
        object.setName("Buffer");
        object.setDoc("A buffer object");
        
        yamlModel.setObjects(List.of(object));
        
        List<JavaFile> files = interfaceGenerator.generate();
        
        assertNotNull(files);
        // Should generate Buffer interface + WGPUObject
        assertEquals(2, files.size());
        
        // Find the Buffer interface
        boolean bufferFound = false;
        boolean wgpuObjectFound = false;
        
        for (JavaFile file : files) {
            String source = file.toString();
            if (source.contains("interface Buffer")) {
                bufferFound = true;
                assertTrue(source.contains("package " + packageName));
            } else if (source.contains("interface WGPUObject")) {
                wgpuObjectFound = true;
            }
        }
        
        assertTrue(bufferFound);
        assertTrue(wgpuObjectFound);
    }
    
    @Test
    void testObjectWithMethods() {
        GpuObject object = new GpuObject();
        object.setName("Device");
        object.setDoc("A device object");
        
        GpuFunction method = new GpuFunction();
        method.setName("create_buffer");
        method.setDoc("Creates a buffer");
        
        GpuFunction.Arg arg = new GpuFunction.Arg();
        arg.setName("descriptor");
        arg.setType("struct.BufferDescriptor");
        method.setArgs(List.of(arg));
        
        GpuFunction.Return returnValue = new GpuFunction.Return();
        returnValue.setType("object.Buffer");
        method.setReturns(returnValue);
        
        object.setMethods(List.of(method));
        yamlModel.setObjects(List.of(object));
        
        List<JavaFile> files = interfaceGenerator.generate();
        
        assertNotNull(files);
        
        JavaFile deviceFile = files.stream()
            .filter(f -> f.toString().contains("interface Device"))
            .findFirst()
            .orElse(null);
        
        assertNotNull(deviceFile);
        
        String source = deviceFile.toString();
        
        // Check that the method is present
        assertTrue(source.contains("createBuffer"));
        assertTrue(source.contains("BufferDescriptor"));
        assertTrue(source.contains("Buffer"));
        assertTrue(source.contains("@SymbolLink"));
    }
    
    @Test
    void testMultipleObjects() {
        GpuObject object1 = new GpuObject();
        object1.setName("Buffer");
        
        GpuObject object2 = new GpuObject();
        object2.setName("Texture");
        
        yamlModel.setObjects(List.of(object1, object2));
        
        List<JavaFile> files = interfaceGenerator.generate();
        
        assertNotNull(files);
        // Should generate 2 interfaces + WGPUObject
        assertEquals(3, files.size());
    }
    
    @Test
    void testObjectWithPointerArgs() {
        GpuObject object = new GpuObject();
        object.setName("TestObject");
        
        GpuFunction method = new GpuFunction();
        method.setName("test_method");
        
        GpuFunction.Arg arg1 = new GpuFunction.Arg();
        arg1.setName("immutable_arg");
        arg1.setType("int");
        arg1.setPointer("immutable");
        
        GpuFunction.Arg arg2 = new GpuFunction.Arg();
        arg2.setName("mutable_arg");
        arg2.setType("String");
        arg2.setPointer("mutable");
        
        method.setArgs(List.of(arg1, arg2));
        object.setMethods(List.of(method));
        yamlModel.setObjects(List.of(object));
        
        List<JavaFile> files = interfaceGenerator.generate();
        
        JavaFile testFile = files.stream()
            .filter(f -> f.toString().contains("interface TestObject"))
            .findFirst()
            .orElse(null);
        
        assertNotNull(testFile);
        
        String source = testFile.toString();
        
        // Check that pointer annotations are present
        assertTrue(source.contains("@Immutable"));
        assertTrue(source.contains("@Mutable"));
    }
    
    @Test
    void testWGPUObjectInterface() {
        yamlModel.setObjects(List.of());
        
        List<JavaFile> files = interfaceGenerator.generate();
        
        JavaFile wgpuObjectFile = files.getFirst();
        
        String source = wgpuObjectFile.toString();
        
        // Check that it's a sealed interface
        assertTrue(source.contains("interface WGPUObject"));
        assertTrue(source.contains("sealed interface"));
    }
    
    @Test
    void testWGPUObjectWithSubclasses() {
        GpuObject object1 = new GpuObject();
        object1.setName("Buffer");
        
        GpuObject object2 = new GpuObject();
        object2.setName("Texture");
        
        yamlModel.setObjects(List.of(object1, object2));
        
        List<JavaFile> files = interfaceGenerator.generate();
        
        JavaFile wgpuObjectFile = files.stream()
            .filter(f -> f.toString().contains("interface WGPUObject"))
            .findFirst()
            .orElse(null);
        
        assertNotNull(wgpuObjectFile);
        
        String source = wgpuObjectFile.toString();
        
        // Check that it permits the subclasses
        assertTrue(source.contains("permits"));
        assertTrue(source.contains("Buffer"));
        assertTrue(source.contains("Texture"));
    }
    
    @Test
    void testInterfaceExtendsWGPUObject() {
        GpuObject object = new GpuObject();
        object.setName("Buffer");
        
        yamlModel.setObjects(List.of(object));
        
        List<JavaFile> files = interfaceGenerator.generate();
        
        JavaFile bufferFile = files.stream()
            .filter(f -> f.toString().contains("interface Buffer"))
            .findFirst()
            .orElse(null);
        
        assertNotNull(bufferFile);
        
        String source = bufferFile.toString();
        
        // Check that it extends WGPUObject
        assertTrue(source.contains("extends WGPUObject"));
    }
    
    @Test
    void testInterfaceModifiers() {
        GpuObject object = new GpuObject();
        object.setName("TestObject");
        
        yamlModel.setObjects(List.of(object));
        
        List<JavaFile> files = interfaceGenerator.generate();
        
        JavaFile testFile = files.stream()
            .filter(f -> f.toString().contains("interface TestObject"))
            .findFirst()
            .orElse(null);
        
        assertNotNull(testFile);
        
        String source = testFile.toString();
        
        // Check that it's public and non-sealed
        assertTrue(source.contains("public"));
        assertTrue(source.contains("non-sealed interface"));
    }

    @Test
    void testMethodWithCallback() {
        GpuObject object = new GpuObject();
        object.setName("Adapter");
        object.setDoc("An adapter object");

        GpuFunction method = new GpuFunction();
        method.setName("request_device");
        method.setDoc("Requests a device");

        GpuFunction.Arg arg = new GpuFunction.Arg();
        arg.setName("descriptor");
        arg.setType("struct.DeviceDescriptor");
        arg.setPointer("immutable");
        arg.setOptional(true);
        method.setArgs(List.of(arg));

        // Set the callback reference
        method.setCallback("callback.request_device");

        object.setMethods(List.of(method));
        yamlModel.setObjects(List.of(object));

        // Also add the callback to the model so it can be referenced
        GpuCallback callback = new GpuCallback();
        callback.setName("request_device");
        callback.setDoc("Request device callback");
        callback.setStyle("callback_mode");
        yamlModel.setCallbacks(List.of(callback));

        List<JavaFile> files = interfaceGenerator.generate();

        assertNotNull(files);

        JavaFile adapterFile = files.stream()
            .filter(f -> f.toString().contains("interface Adapter"))
            .findFirst()
            .orElse(null);

        assertNotNull(adapterFile);

        String source = adapterFile.toString();

        // Check that the method is present with callback parameter
        assertTrue(source.contains("requestDevice"));
        assertTrue(source.contains("DeviceDescriptor"));
        assertTrue(source.contains("RequestDevice"));
        assertTrue(source.contains("callback"));
    }

    @Test
    void testMethodWithSimpleCallback() {
        GpuObject object = new GpuObject();
        object.setName("Buffer");

        GpuFunction method = new GpuFunction();
        method.setName("map_async");

        // Set the callback reference without the "callback." prefix
        method.setCallback("buffer_map");

        object.setMethods(List.of(method));
        yamlModel.setObjects(List.of(object));

        List<JavaFile> files = interfaceGenerator.generate();

        JavaFile bufferFile = files.stream()
            .filter(f -> f.toString().contains("interface Buffer"))
            .findFirst()
            .orElse(null);

        assertNotNull(bufferFile);

        String source = bufferFile.toString();

        // Check that the callback parameter is generated correctly
        assertTrue(source.contains("mapAsync"));
        assertTrue(source.contains("BufferMap"));
        assertTrue(source.contains("callback"));
    }
}
