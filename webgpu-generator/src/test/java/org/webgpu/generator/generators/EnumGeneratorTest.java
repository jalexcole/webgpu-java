package org.webgpu.generator.generators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.webgpu.generator.domain.GpuEnum;
import org.webgpu.generator.domain.YamlModel;

import com.palantir.javapoet.JavaFile;

@Disabled
class EnumGeneratorTest {
    
    private YamlModel yamlModel;
    private String packageName = "org.webgpu.api";
    private EnumGenerator enumGenerator;
    
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
        enumGenerator = new EnumGenerator(yamlModel, packageName);
    }
    
    @Test
    void testEmptyEnums() {
        yamlModel.setEnums(List.of());
        
        List<JavaFile> files = enumGenerator.generate();
        
        assertNotNull(files);
        assertTrue(files.isEmpty());
    }
    
    @Test
    void testSingleEnum() {
        GpuEnum gpuEnum = new GpuEnum();
        gpuEnum.setName("PrimitiveTopology");
        gpuEnum.setDoc("Primitive topology types");
        
        GpuEnum.Entry entry1 = new GpuEnum.Entry();
        entry1.setName("point_list");
        entry1.setDoc("Point list topology");
        entry1.setValue(0);
        
        GpuEnum.Entry entry2 = new GpuEnum.Entry();
        entry2.setName("line_list");
        entry2.setDoc("Line list topology");
        entry2.setValue(1);
        
        gpuEnum.setEntries(List.of(entry1, entry2));
        yamlModel.setEnums(List.of(gpuEnum));
        
        List<JavaFile> files = enumGenerator.generate();
        
        assertNotNull(files);
        assertEquals(1, files.size());
        
        String source = files.getFirst().toString();
        assertTrue(source.contains("package " + packageName));
        assertTrue(source.contains("enum PrimitiveTopology"));
        assertTrue(source.contains("POINT_LIST"));
        assertTrue(source.contains("LINE_LIST"));
    }
    
    @Test
    void testEnumWithNumericPrefix() {
        GpuEnum gpuEnum = new GpuEnum();
        gpuEnum.setName("TestEnum");
        
        // Test enum entries that start with numbers
        GpuEnum.Entry entry1 = new GpuEnum.Entry();
        entry1.setName("0_Buffer");
        entry1.setValue(0);
        
        GpuEnum.Entry entry2 = new GpuEnum.Entry();
        entry2.setName("1_Texture");
        entry2.setValue(1);
        
        GpuEnum.Entry entry3 = new GpuEnum.Entry();
        entry3.setName("2_Sampler");
        entry3.setValue(2);
        
        gpuEnum.setEntries(List.of(entry1, entry2, entry3));
        yamlModel.setEnums(List.of(gpuEnum));
        
        List<JavaFile> files = enumGenerator.generate();
        
        assertNotNull(files);
        assertEquals(1, files.size());
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Check that numeric prefixes are handled correctly
        assertTrue(source.contains("ZERO_Buffer"));
        assertTrue(source.contains("ONE_Texture"));
        assertTrue(source.contains("TWO_Sampler"));
    }
    
    @Test
    void testMultipleEnums() {
        GpuEnum enum1 = new GpuEnum();
        enum1.setName("FirstEnum");
        GpuEnum.Entry entry1 = new GpuEnum.Entry();
        entry1.setName("first_value");
        entry1.setValue(0);
        enum1.setEntries(List.of(entry1));
        
        GpuEnum enum2 = new GpuEnum();
        enum2.setName("SecondEnum");
        GpuEnum.Entry entry2 = new GpuEnum.Entry();
        entry2.setName("second_value");
        entry2.setValue(0);
        enum2.setEntries(List.of(entry2));
        
        yamlModel.setEnums(List.of(enum1, enum2));
        
        List<JavaFile> files = enumGenerator.generate();
        
        assertNotNull(files);
        assertEquals(2, files.size());
        
        String source1 = files.getFirst().toString();
        String source2 = files.get(1).toString();
        assertTrue(source1.contains("enum FirstEnum"));
        assertTrue(source2.contains("enum SecondEnum"));
    }
    
    @Test
    void testEnumWithNullEntries() {
        GpuEnum gpuEnum = new GpuEnum();
        gpuEnum.setName("TestEnum");
        
        // Add a null entry to test the Optional handling
        gpuEnum.setEntries(List.of(null));
        yamlModel.setEnums(List.of(gpuEnum));
        
        List<JavaFile> files = enumGenerator.generate();
        
        assertNotNull(files);
        assertEquals(1, files.size());
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Should contain NULL constant for null entry
        assertTrue(source.contains("NULL"));
    }
    
    @Test
    void testEnumValueField() {
        GpuEnum gpuEnum = new GpuEnum();
        gpuEnum.setName("TestEnum");
        
        GpuEnum.Entry entry = new GpuEnum.Entry();
        entry.setName("test_value");
        entry.setValue(42);
        gpuEnum.setEntries(List.of(entry));
        
        yamlModel.setEnums(List.of(gpuEnum));
        
        List<JavaFile> files = enumGenerator.generate();
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Check that the value field and methods are present
        assertTrue(source.contains("private final int value"));
        assertTrue(source.contains("public int value()"));
        assertTrue(source.contains("$L")); // Check that the enum constant uses the $L placeholder
    }
    
    @Test
    void testEnumWithoutValues() {
        GpuEnum gpuEnum = new GpuEnum();
        gpuEnum.setName("TestEnum");
        
        GpuEnum.Entry entry = new GpuEnum.Entry();
        entry.setName("test_value");
        entry.setDoc("Test value");
        // Don't set value, let it be Optional.empty()
        gpuEnum.setEntries(List.of(entry));
        
        yamlModel.setEnums(List.of(gpuEnum));
        
        List<JavaFile> files = enumGenerator.generate();
        
        assertNotNull(files);
        assertEquals(1, files.size());
    }
    
    @Test
    void testEnumWithDocumentation() {
        GpuEnum gpuEnum = new GpuEnum();
        gpuEnum.setName("DocumentedEnum");
        gpuEnum.setDoc("This is a documented enum");
        
        GpuEnum.Entry entry = new GpuEnum.Entry();
        entry.setName("documented_value");
        entry.setDoc("This is a documented value");
        entry.setValue(0);
        gpuEnum.setEntries(List.of(entry));
        
        yamlModel.setEnums(List.of(gpuEnum));
        
        List<JavaFile> files = enumGenerator.generate();
        
        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();
        
        // Check that documentation is present
        assertTrue(source.contains("This is a documented enum"));
        assertTrue(source.contains("This is a documented value"));
    }
}
