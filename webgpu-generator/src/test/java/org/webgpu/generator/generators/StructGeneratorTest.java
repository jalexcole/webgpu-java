package org.webgpu.generator.generators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.webgpu.generator.domain.GpuStruct;
import org.webgpu.generator.domain.YamlModel;

import com.palantir.javapoet.JavaFile;

@Disabled
class StructGeneratorTest {
    
    private YamlModel yamlModel;
    private String packageName = "org.webgpu.api";
    private StructGenerator structGenerator;
    
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
        structGenerator = new StructGenerator(yamlModel, packageName);
    }
    
    @Test
    void testEmptyStructs() {
        yamlModel.setStructs(List.of());
        
        List<JavaFile> files = structGenerator.generate();
        
        assertNotNull(files);
        assertTrue(files.isEmpty());
    }
    
    @Test
    void testSingleStruct() {
        GpuStruct gpuStruct = new GpuStruct();
        gpuStruct.setName("BufferDescriptor");
        gpuStruct.setDoc("Buffer descriptor");
        
        yamlModel.setStructs(List.of(gpuStruct));
        
        List<JavaFile> files = structGenerator.generate();
        
        assertNotNull(files);
        assertEquals(1, files.size());
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        assertTrue(source.contains("package " + packageName));
        assertTrue(source.contains("class BufferDescriptor"));
    }
    
    @Test
    void testStructWithMembers() {
        GpuStruct gpuStruct = new GpuStruct();
        gpuStruct.setName("TextureDescriptor");
        
        GpuStruct.Member member1 = new GpuStruct.Member();
        member1.setName("label");
        member1.setType("String");
        member1.setDoc("Texture label");
        
        GpuStruct.Member member2 = new GpuStruct.Member();
        member2.setName("usage");
        member2.setType("bitflag.TextureUsage");
        member2.setDoc("Texture usage");
        
        gpuStruct.setMembers(List.of(member1, member2));
        yamlModel.setStructs(List.of(gpuStruct));
        
        List<JavaFile> files = structGenerator.generate();
        
        assertNotNull(files);
        assertEquals(1, files.size());
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Check that members are present as fields
        assertTrue(source.contains("private String label"));
        assertTrue(source.contains("private EnumSet<TextureUsage> usage"));
        
        // Check that getters and setters are present
        assertTrue(source.contains("public String label()"));
        assertTrue(source.contains("public void label(String label)"));
        assertTrue(source.contains("public EnumSet<TextureUsage> usage()"));
    }
    
    @Test
    void testStructWithConstructor() {
        GpuStruct gpuStruct = new GpuStruct();
        gpuStruct.setName("SimpleStruct");
        
        GpuStruct.Member member = new GpuStruct.Member();
        member.setName("value");
        member.setType("int");
        
        gpuStruct.setMembers(List.of(member));
        yamlModel.setStructs(List.of(gpuStruct));
        
        List<JavaFile> files = structGenerator.generate();
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Check that constructor with parameters is present
        assertTrue(source.contains("public SimpleStruct(int value)"));
    }
    
    @Test
    void testStructWithDefaultConstructor() {
        GpuStruct gpuStruct = new GpuStruct();
        gpuStruct.setName("SimpleStruct");
        
        GpuStruct.Member member = new GpuStruct.Member();
        member.setName("value");
        member.setType("int");
        
        gpuStruct.setMembers(List.of(member));
        yamlModel.setStructs(List.of(gpuStruct));
        
        List<JavaFile> files = structGenerator.generate();
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Check that default constructor is present
        assertTrue(source.contains("public SimpleStruct()"));
        // Check that it initializes fields
        assertTrue(source.contains("this.value = 0"));
    }
    
    @Test
    void testStructInheritance() {
        GpuStruct parentStruct = new GpuStruct();
        parentStruct.setName("BaseStruct");
        
        GpuStruct childStruct = new GpuStruct();
        childStruct.setName("DerivedStruct");
        childStruct.setExtends(List.of("BaseStruct"));
        
        yamlModel.setStructs(List.of(parentStruct, childStruct));
        
        List<JavaFile> files = structGenerator.generate();
        
        assertNotNull(files);
        assertEquals(2, files.size());
        
        // Find the child struct file
        JavaFile childFile = files.stream()
            .filter(f -> f.toString().contains("class DerivedStruct"))
            .findFirst()
            .orElse(null);
        
        assertNotNull(childFile);
        String source = childFile.toString();
        
        // Check that it extends the parent
        assertTrue(source.contains("extends BaseStruct"));
        
        // Parent should be sealed since it has children
        JavaFile parentFile = files.stream()
            .filter(f -> f.toString().contains("class BaseStruct"))
            .findFirst()
            .orElse(null);
        
        assertNotNull(parentFile);
        String parentSource = parentFile.toString();
        assertTrue(parentSource.contains("sealed class"));
        assertTrue(parentSource.contains("permits DerivedStruct"));
    }
    
    @Test
    void testStructWithFinalModifier() {
        GpuStruct parentStruct = new GpuStruct();
        parentStruct.setName("BaseStruct");
        
        GpuStruct childStruct = new GpuStruct();
        childStruct.setName("FinalStruct");
        childStruct.setExtends(List.of("BaseStruct"));
        
        yamlModel.setStructs(List.of(parentStruct, childStruct));
        
        List<JavaFile> files = structGenerator.generate();
        
        JavaFile childFile = files.stream()
            .filter(f -> f.toString().contains("class FinalStruct"))
            .findFirst()
            .orElse(null);
        
        assertNotNull(childFile);
        String source = childFile.toString();
        
        // Child structs that extend sealed classes should be final
        assertTrue(source.contains("final class"));
    }
    
    @Test
    void testStructWithoutInheritance() {
        GpuStruct gpuStruct = new GpuStruct();
        gpuStruct.setName("StandaloneStruct");
        
        GpuStruct.Member member = new GpuStruct.Member();
        member.setName("value");
        member.setType("int");
        
        gpuStruct.setMembers(List.of(member));
        yamlModel.setStructs(List.of(gpuStruct));
        
        List<JavaFile> files = structGenerator.generate();
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Should not be sealed or final
        assertTrue(source.contains("public class StandaloneStruct"));
        assertFalse(source.contains("sealed"));
        assertFalse(source.contains("final class"));
    }
    
    @Test
    void testStructToString() {
        GpuStruct gpuStruct = new GpuStruct();
        gpuStruct.setName("TestStruct");
        
        GpuStruct.Member member1 = new GpuStruct.Member();
        member1.setName("name");
        member1.setType("String");
        
        GpuStruct.Member member2 = new GpuStruct.Member();
        member2.setName("value");
        member2.setType("int");
        
        gpuStruct.setMembers(List.of(member1, member2));
        yamlModel.setStructs(List.of(gpuStruct));
        
        List<JavaFile> files = structGenerator.generate();
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Check that toString method is present
        assertTrue(source.contains("@Override"));
        assertTrue(source.contains("public String toString()"));
        assertTrue(source.contains("TestStruct["));
    }
    
    @Test
    void testStructWithDocumentation() {
        GpuStruct gpuStruct = new GpuStruct();
        gpuStruct.setName("DocumentedStruct");
        gpuStruct.setDoc("This is a documented struct");
        
        GpuStruct.Member member = new GpuStruct.Member();
        member.setName("documented_field");
        member.setType("String");
        member.setDoc("This is a documented field");
        
        gpuStruct.setMembers(List.of(member));
        yamlModel.setStructs(List.of(gpuStruct));
        
        List<JavaFile> files = structGenerator.generate();
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Check that documentation is present
        assertTrue(source.contains("This is a documented struct"));
        assertTrue(source.contains("This is a documented field"));
    }
    
    @Test
    void testMultipleStructs() {
        GpuStruct struct1 = new GpuStruct();
        struct1.setName("Struct1");
        
        GpuStruct struct2 = new GpuStruct();
        struct2.setName("Struct2");
        
        yamlModel.setStructs(List.of(struct1, struct2));
        
        List<JavaFile> files = structGenerator.generate();
        
        assertNotNull(files);
        assertEquals(2, files.size());
        
        String source1 = files.getFirst().toString();
        String source2 = files.get(1).toString();
        assertTrue(source1.contains("class Struct1"));
        assertTrue(source2.contains("class Struct2"));
    }
    
    @Test
    void testStructWithPrimitiveTypes() {
        GpuStruct gpuStruct = new GpuStruct();
        gpuStruct.setName("PrimitiveStruct");
        
        // Test all primitive types
        GpuStruct.Member boolMember = new GpuStruct.Member();
        boolMember.setName("bool_value");
        boolMember.setType("bool");
        
        GpuStruct.Member intMember = new GpuStruct.Member();
        intMember.setName("int_value");
        intMember.setType("int");
        
        GpuStruct.Member floatMember = new GpuStruct.Member();
        floatMember.setName("float_value");
        floatMember.setType("float");
        
        GpuStruct.Member doubleMember = new GpuStruct.Member();
        doubleMember.setName("double_value");
        doubleMember.setType("double");
        
        gpuStruct.setMembers(List.of(boolMember, intMember, floatMember, doubleMember));
        yamlModel.setStructs(List.of(gpuStruct));
        
        List<JavaFile> files = structGenerator.generate();
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Check that all primitive types are properly handled
        assertTrue(source.contains("boolean boolValue"));
        assertTrue(source.contains("int intValue"));
        assertTrue(source.contains("float floatValue"));
        assertTrue(source.contains("double doubleValue"));
        
        // Check default constructor initializes primitives correctly
        assertTrue(source.contains("this.boolValue = false"));
        assertTrue(source.contains("this.intValue = 0"));
        assertTrue(source.contains("this.floatValue = 0.0f"));
        assertTrue(source.contains("this.doubleValue = 0.0"));
    }
    
    @Test
    void testStructWithArrayTypes() {
        GpuStruct gpuStruct = new GpuStruct();
        gpuStruct.setName("ArrayStruct");
        
        GpuStruct.Member arrayMember = new GpuStruct.Member();
        arrayMember.setName("values");
        arrayMember.setType("array<int>");
        
        gpuStruct.setMembers(List.of(arrayMember));
        yamlModel.setStructs(List.of(gpuStruct));
        
        List<JavaFile> files = structGenerator.generate();
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Check that array types are properly handled
        assertTrue(source.contains("int[] values"));
        // Check default initialization
        assertTrue(source.contains("this.values = new int[0]"));
    }
    
    @Test
    void testStructWithReferenceTypes() {
        GpuStruct gpuStruct = new GpuStruct();
        gpuStruct.setName("ReferenceStruct");
        
        GpuStruct.Member stringMember = new GpuStruct.Member();
        stringMember.setName("name");
        stringMember.setType("String");
        
        GpuStruct.Member enumMember = new GpuStruct.Member();
        enumMember.setName("type");
        enumMember.setType("enum.PrimitiveTopology");
        
        gpuStruct.setMembers(List.of(stringMember, enumMember));
        yamlModel.setStructs(List.of(gpuStruct));
        
        List<JavaFile> files = structGenerator.generate();
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Check that reference types are properly handled
        assertTrue(source.contains("String name"));
        assertTrue(source.contains("PrimitiveTopology type"));
        
        // Check default initialization
        assertTrue(source.contains("this.name = \"\""));
        assertTrue(source.contains("this.type = null"));
    }
}
