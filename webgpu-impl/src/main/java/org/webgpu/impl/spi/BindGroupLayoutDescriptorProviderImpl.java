package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.BindGroupLayoutEntry;
import org.webgpu.api.spi.BindGroupLayoutDescriptorProvider;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.WGPUBindGroupLayoutDescriptor;
import org.webgpu.panama.WGPUBindGroupLayoutEntry;

@NullMarked
public class BindGroupLayoutDescriptorProviderImpl implements BindGroupLayoutDescriptorProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUBindGroupLayoutDescriptor.allocate(arena);
    }

    @Override
    public String label(MemorySegment structPtr) {
        return StringViewMapper.map(WGPUBindGroupLayoutDescriptor.label(structPtr));
    }

    @Override
    public BindGroupLayoutEntry[] entries(MemorySegment structPtr) {
        var entryCount = WGPUBindGroupLayoutDescriptor.entryCount(structPtr);
        var entriesPtr = WGPUBindGroupLayoutDescriptor.entries(structPtr);
        if (entriesPtr == null || entriesPtr.equals(MemorySegment.NULL) || entryCount == 0) {
            return new BindGroupLayoutEntry[0];
        }
        var result = new BindGroupLayoutEntry[(int) entryCount];
        var entryProvider = new BindGroupLayoutEntryProviderImpl();
        for (int i = 0; i < entryCount; i++) {
            var entryPtr = WGPUBindGroupLayoutEntry.asSlice(entriesPtr, i);
            result[i] = new BindGroupLayoutEntry();
            result[i].binding(entryProvider.binding(entryPtr));
            result[i].bindingArraySize(entryProvider.bindingArraySize(entryPtr));
            result[i].visibility(entryProvider.visibility(entryPtr));
            result[i].buffer(entryProvider.buffer(entryPtr));
            result[i].sampler(entryProvider.sampler(entryPtr));
            result[i].texture(entryProvider.texture(entryPtr));
            result[i].storageTexture(entryProvider.storageTexture(entryPtr));
        }
        return result;
    }

    @Override
    public void label(MemorySegment structPtr, String label) {
        WGPUBindGroupLayoutDescriptor.label(structPtr, StringViewMapper.map(label, arena));
    }

    @Override
    public void entries(MemorySegment structPtr, BindGroupLayoutEntry[] entries) {
        if (entries == null || entries.length == 0) {
            WGPUBindGroupLayoutDescriptor.entries(structPtr, MemorySegment.NULL);
            WGPUBindGroupLayoutDescriptor.entryCount(structPtr, 0);
            return;
        }

        final MemorySegment entriesPtr = WGPUBindGroupLayoutEntry.allocateArray(entries.length, arena);

        for (int i = 0; i < entries.length; i++) {
            final MemorySegment src = StructTools.fetchSegment(entries[i]);
            final MemorySegment dest = WGPUBindGroupLayoutEntry.asSlice(entriesPtr, i);
            MemorySegment.copy(src, 0, dest, 0, WGPUBindGroupLayoutEntry.layout().byteSize());
        }

        WGPUBindGroupLayoutDescriptor.entries(structPtr, entriesPtr);
        WGPUBindGroupLayoutDescriptor.entryCount(structPtr, entries.length);
    }
}
