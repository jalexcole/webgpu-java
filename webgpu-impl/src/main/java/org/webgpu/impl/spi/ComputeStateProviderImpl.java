package org.webgpu.impl.spi;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.webgpu.api.ConstantEntry;
import org.webgpu.api.ShaderModule;
import org.webgpu.api.spi.ComputeStateProvider;
import org.webgpu.impl.ShaderModuleImpl;
import org.webgpu.impl.util.StringViewMapper;
import org.webgpu.impl.util.StructTools;
import org.webgpu.panama.WGPUConstantEntry;
import org.webgpu.panama.WGPUComputeState;

/**
 * ComputeStateProviderImpl
 */
public class ComputeStateProviderImpl implements ComputeStateProvider {

    private final Arena arena = Arena.ofAuto();

    @Override
    public MemorySegment initializer() {
        return WGPUComputeState.allocate(arena);
    }

    @Override
    public ShaderModuleImpl module(MemorySegment structPtr) {
        final var shaderModulePtr = WGPUComputeState.module(structPtr);
        return new ShaderModuleImpl(shaderModulePtr);
    }

    @Override
    public String entryPoint(MemorySegment structPtr) {
        final var entryPointPtr = WGPUComputeState.entryPoint(structPtr);
        return StringViewMapper.map(entryPointPtr);
    }

    @Override
    public ConstantEntry[] constants(MemorySegment structPtr) {
        final long constantCount = WGPUComputeState.constantCount(structPtr);
        final MemorySegment constantsPtr = WGPUComputeState.constants(structPtr);
        if (constantsPtr == null || constantsPtr.equals(MemorySegment.NULL) || constantCount == 0) {
            return new ConstantEntry[0];
        }

        final var provider = new ConstantEntryProviderImpl();
        final var result = new ConstantEntry[(int) constantCount];
        for (int i = 0; i < constantCount; i++) {
            final MemorySegment constantPtr = WGPUConstantEntry.asSlice(constantsPtr, i);
            final var constant = new ConstantEntry();
            constant.key(provider.key(constantPtr));
            constant.value(provider.value(constantPtr));
            result[i] = constant;
        }
        return result;
    }

    @Override
    public void module(MemorySegment structPtr, ShaderModule module) {
        final var shaderModulePtr = ((ShaderModuleImpl) module).ptr();
        WGPUComputeState.module(structPtr, shaderModulePtr);
    }

    @Override
    public void entryPoint(MemorySegment structPtr, String entryPoint) {

        final var entryPointSegment = StringViewMapper.map(entryPoint, arena);
        WGPUComputeState.entryPoint(structPtr, entryPointSegment);

    }

    @Override
    public void constants(MemorySegment structPtr, ConstantEntry[] constants) {
        if (constants == null || constants.length == 0) {
            WGPUComputeState.constants(structPtr, MemorySegment.NULL);
            WGPUComputeState.constantCount(structPtr, 0);
            return;
        }

        final MemorySegment constantsPtr = WGPUConstantEntry.allocateArray(constants.length, arena);
        for (int i = 0; i < constants.length; i++) {
            final MemorySegment src = StructTools.fetchSegment(constants[i]);
            final MemorySegment dest = WGPUConstantEntry.asSlice(constantsPtr, i);
            MemorySegment.copy(src, 0, dest, 0, WGPUConstantEntry.layout().byteSize());
        }

        WGPUComputeState.constants(structPtr, constantsPtr);
        WGPUComputeState.constantCount(structPtr, constants.length);
    }

}
