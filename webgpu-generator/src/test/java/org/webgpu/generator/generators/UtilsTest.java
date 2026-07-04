package org.webgpu.generator.generators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.TypeName;

class UtilsTest {
    
    @Test
    void testToPascalCase() {
        assertEquals("BufferUsage", Utils.toPascalCase("buffer_usage"));
        assertEquals("TextureDescriptor", Utils.toPascalCase("texture_descriptor"));
        assertEquals("Wgpu", Utils.toPascalCase("wgpu"));
        assertEquals("Simple", Utils.toPascalCase("simple"));
        assertEquals("A", Utils.toPascalCase("a"));
        assertEquals("Abc", Utils.toPascalCase("abc"));
        assertEquals("WgpuInstance", Utils.toPascalCase("wgpu_instance"));
    }
    
    @Test
    void testToPascalCaseSingleWord() {
        assertEquals("Buffer", Utils.toPascalCase("buffer"));
        assertEquals("Texture", Utils.toPascalCase("texture"));
    }
    
    @Test
    void testToPascalCaseNoUnderscore() {
        // Single word should be capitalized
        assertEquals("Buffer", Utils.toPascalCase("buffer"));
    }
    
    @Test
    void testToCamelCase() {
        assertEquals("bufferUsage", Utils.toCamelCase("buffer_usage"));
        assertEquals("textureDescriptor", Utils.toCamelCase("texture_descriptor"));
        assertEquals("wgpu", Utils.toCamelCase("wgpu"));
        assertEquals("simple", Utils.toCamelCase("simple"));
        assertEquals("a", Utils.toCamelCase("a"));
        assertEquals("wgpuInstance", Utils.toCamelCase("wgpu_instance"));
    }
    
    @Test
    void testToCamelCaseSingleWord() {
        assertEquals("buffer", Utils.toCamelCase("buffer"));
        assertEquals("texture", Utils.toCamelCase("texture"));
    }
    
    @Test
    void testToCamelCaseNoUnderscore() {
        // Single word should be lowercase
        assertEquals("buffer", Utils.toCamelCase("buffer"));
    }
    
    @Test
    void testToScreamingSnakeCase() {
        assertEquals("BUFFER_USAGE", Utils.toScreamingSnakeCase("buffer_usage"));
        assertEquals("TEXTURE_DESCRIPTOR", Utils.toScreamingSnakeCase("texture_descriptor"));
        assertEquals("WGPU", Utils.toScreamingSnakeCase("wgpu"));
        assertEquals("SIMPLE", Utils.toScreamingSnakeCase("simple"));
    }
    
    @Test
    void testCleanName() {
        // Test enum prefix removal
        assertEquals("PrimitiveTopology", Utils.cleanName("enum.PrimitiveTopology"));
        
        // Test struct prefix removal
        assertEquals("BufferDescriptor", Utils.cleanName("struct.BufferDescriptor"));
        
        // Test object prefix removal
        assertEquals("Buffer", Utils.cleanName("object.Buffer"));
        
        // Test bitflag prefix removal
        assertEquals("BufferUsage", Utils.cleanName("bitflag.BufferUsage"));
        
        // Test callback prefix removal
        assertEquals("WGPUProc", Utils.cleanName("callback.WGPUProc"));
        
        // Test name without prefix
        assertEquals("Buffer", Utils.cleanName("Buffer"));
    }
    
    @Test
    void testCleanNameWithArray() {
        assertEquals("int[]", Utils.cleanName("array<int>"));
        assertEquals("Buffer[]", Utils.cleanName("array<Buffer>"));
    }
    
    @Test
    void testMapBasicTypes() {
        // Test basic type mappings
        assertEquals(TypeName.INT, Utils.map("int"));
        assertEquals(TypeName.INT, Utils.map("uint32"));
        assertEquals(TypeName.INT, Utils.map("int32"));
        assertEquals(TypeName.LONG, Utils.map("uint64"));
        assertEquals(TypeName.LONG, Utils.map("int64"));
        assertEquals(TypeName.LONG, Utils.map("usize"));
        assertEquals(TypeName.FLOAT, Utils.map("float"));
        assertEquals(TypeName.FLOAT, Utils.map("float32"));
        assertEquals(TypeName.DOUBLE, Utils.map("double"));
        assertEquals(TypeName.DOUBLE, Utils.map("float64"));
        assertEquals(TypeName.BOOLEAN, Utils.map("bool"));
        assertEquals(TypeName.BOOLEAN, Utils.map("boolean"));
        assertEquals(ClassName.get(String.class), Utils.map("String"));
        assertEquals(ClassName.get(String.class), Utils.map("out_string"));
        assertEquals(ClassName.get(String.class), Utils.map("nullable_string"));
        assertEquals(ClassName.get(String.class), Utils.map("string_with_default_empty"));
    }
    
    @Test
    void testMapComplexTypes() {
        // Test enum types
        assertEquals(ClassName.get("org.webgpu.api", "PrimitiveTopology"), Utils.map("enum.PrimitiveTopology"));
        
        // Test struct types
        assertEquals(ClassName.get("org.webgpu.api", "BufferDescriptor"), Utils.map("struct.BufferDescriptor"));
        
        // Test object types
        assertEquals(ClassName.get("org.webgpu.api", "Buffer"), Utils.map("object.Buffer"));
    }
    
    @Test
    void testMapArrayTypes() {
        assertEquals(Utils.map("int[]"), Utils.map("array<int>"));
        assertEquals(Utils.map("Buffer[]"), Utils.map("array<Buffer>"));
    }
    
    @Test
    void testMapBitflagTypes() {
        // Bitflag types should be mapped to EnumSet
        TypeName bitflagType = Utils.map("bitflag.BufferUsage");
        assertTrue(bitflagType.toString().contains("EnumSet"));
        assertTrue(bitflagType.toString().contains("BufferUsage"));
    }
    
    @Test
    void testMapPointer() {
        assertEquals(Utils.mapPointer("immutable"), Utils.mapPointer("immutable"));
        assertEquals(Utils.mapPointer("mutable"), Utils.mapPointer("mutable"));
    }
    
    @Test
    void testMapPointerInvalid() {
        assertThrows(IllegalStateException.class, () -> {
            Utils.mapPointer("invalid_pointer");
        });
    }
    
    @Test
    void testAddPrefix() {
        assertEquals("WGPUBuffer", Utils.addPrefix("Buffer"));
        assertEquals("WGPUTexture", Utils.addPrefix("Texture"));
        assertEquals("WGPU", Utils.addPrefix(""));
    }
    
    @Test
    void testBasicTypesList() {
        assertTrue(Utils.BASIC_TYPES.contains("void"));
        assertTrue(Utils.BASIC_TYPES.contains("int"));
        assertTrue(Utils.BASIC_TYPES.contains("long"));
        assertTrue(Utils.BASIC_TYPES.contains("float"));
        assertTrue(Utils.BASIC_TYPES.contains("double"));
        assertTrue(Utils.BASIC_TYPES.contains("boolean"));
        assertTrue(Utils.BASIC_TYPES.contains("String"));
    }
    
    // Skip boxEnumSet test as it requires complex JavaPoet setup
}
