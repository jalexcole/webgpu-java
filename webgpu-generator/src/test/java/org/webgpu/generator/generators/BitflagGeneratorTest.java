package org.webgpu.generator.generators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.webgpu.generator.domain.GpuBitflag;
import org.webgpu.generator.domain.YamlModel;

import com.palantir.javapoet.JavaFile;

class BitflagGeneratorTest {

    private YamlModel yamlModel;
    private String packageName = "org.webgpu.api";
    private BitflagGenerator bitflagGenerator;

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
        bitflagGenerator = new BitflagGenerator(yamlModel, packageName);
    }

    @Test
    void testEmptyBitflags() {
        yamlModel.setBitflags(List.of());

        List<JavaFile> files = bitflagGenerator.generate();

        assertNotNull(files);
        assertTrue(files.isEmpty());
    }

    @Test
    void testSingleBitflag() {
        GpuBitflag bitflag = new GpuBitflag();
        bitflag.setName("BufferUsage");
        bitflag.setDoc("Buffer usage flags");

        GpuBitflag.Entry entry1 = new GpuBitflag.Entry();
        entry1.setName("MAP_READ");
        entry1.setDoc("Map for read");

        GpuBitflag.Entry entry2 = new GpuBitflag.Entry();
        entry2.setName("MAP_WRITE");
        entry2.setDoc("Map for write");

        bitflag.setEntries(List.of(entry1, entry2));
        yamlModel.setBitflags(List.of(bitflag));

        List<JavaFile> files = bitflagGenerator.generate();

        assertNotNull(files);
        assertEquals(2, files.size());

        String source = files.getFirst().toString();
        assertTrue(source.contains("package " + packageName));
        assertTrue(source.contains("enum BufferUsage"));
        assertTrue(source.contains("MAP_READ"));
        assertTrue(source.contains("MAP_WRITE"));
        assertTrue(source.contains("Bitflag"));
        assertTrue(source.contains("value"));
    }

    @Test
    void testMultipleBitflags() {
        GpuBitflag bitflag1 = new GpuBitflag();
        bitflag1.setName("BufferUsage");
        bitflag1.setDoc("Buffer usage flags");

        GpuBitflag.Entry entry1 = new GpuBitflag.Entry();
        entry1.setName("COPY_SRC");
        entry1.setDoc("Copy source");
        bitflag1.setEntries(List.of(entry1));

        GpuBitflag bitflag2 = new GpuBitflag();
        bitflag2.setName("TextureUsage");
        bitflag2.setDoc("Texture usage flags");

        GpuBitflag.Entry entry2 = new GpuBitflag.Entry();
        entry2.setName("RENDER_ATTACHMENT");
        entry2.setDoc("Render attachment");
        bitflag2.setEntries(List.of(entry2));

        yamlModel.setBitflags(List.of(bitflag1, bitflag2));

        List<JavaFile> files = bitflagGenerator.generate();

        assertNotNull(files);
        assertEquals(3, files.size());

        // Check the enum files and shared interface are generated
        String source1 = files.getFirst().toString();
        String source2 = files.get(1).toString();
        String source3 = files.get(2).toString();
        assertTrue(source1.contains("enum BufferUsage"));
        assertTrue(source2.contains("enum TextureUsage"));
        assertTrue(source3.contains("interface WGPUBitflag"));
    }

    @Test
    void testBitflagWithSingleEntry() {
        GpuBitflag bitflag = new GpuBitflag();
        bitflag.setName("SingleFlag");
        bitflag.setDoc("Single flag");

        GpuBitflag.Entry entry = new GpuBitflag.Entry();
        entry.setName("SINGLE");
        entry.setDoc("Single entry");
        bitflag.setEntries(List.of(entry));

        yamlModel.setBitflags(List.of(bitflag));

        List<JavaFile> files = bitflagGenerator.generate();

        assertNotNull(files);
        assertEquals(2, files.size());

        String source = files.getFirst().toString();

        // Check that the enum is properly generated
        assertTrue(source.contains("enum SingleFlag"));
        assertTrue(source.contains("SINGLE"));
    }

    @Test
    void testBitflagEntryGeneration() {
        GpuBitflag bitflag = new GpuBitflag();
        bitflag.setName("TestFlags");
        bitflag.setDoc("Test flags");

        // Create 3 entries
        GpuBitflag.Entry entry1 = new GpuBitflag.Entry();
        entry1.setName("FLAG_A");
        entry1.setDoc("Flag A");

        GpuBitflag.Entry entry2 = new GpuBitflag.Entry();
        entry2.setName("FLAG_B");
        entry2.setDoc("Flag B");

        GpuBitflag.Entry entry3 = new GpuBitflag.Entry();
        entry3.setName("FLAG_C");
        entry3.setDoc("Flag C");

        bitflag.setEntries(List.of(entry1, entry2, entry3));
        yamlModel.setBitflags(List.of(bitflag));

        List<JavaFile> files = bitflagGenerator.generate();

        assertNotNull(files);
        assertEquals(2, files.size());

        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();

        // Check all flags are present
        assertTrue(source.contains("FLAG_A"));
        assertTrue(source.contains("FLAG_B"));
        assertTrue(source.contains("FLAG_C"));

        // Check that the value field and methods are present
        assertTrue(source.contains("private final long value"));
        assertTrue(source.contains("public long value()"));
    }

    @Test
    void testBitflagInterfaceImplementation() {
        GpuBitflag bitflag = new GpuBitflag();
        bitflag.setName("TestFlags");
        bitflag.setDoc("Test flags");

        GpuBitflag.Entry entry = new GpuBitflag.Entry();
        entry.setName("TEST");
        entry.setDoc("Test entry");
        bitflag.setEntries(List.of(entry));

        yamlModel.setBitflags(List.of(bitflag));

        List<JavaFile> files = bitflagGenerator.generate();

        JavaFile javaFile = files.getFirst();
        String source = javaFile.toString();

        // Check that it implements BitFlag interface
        assertTrue(source.contains("implements BitFlag"));
    }
}
