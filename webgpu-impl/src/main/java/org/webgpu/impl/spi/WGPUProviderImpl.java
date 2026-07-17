package org.webgpu.impl.spi;

import java.io.ByteArrayOutputStream;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.charset.StandardCharsets;
import java.util.function.BiConsumer;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.webgpu.api.Instance;
import org.webgpu.api.InstanceDescriptor;
import org.webgpu.api.InstanceFeatureName;
import org.webgpu.api.InstanceLimits;
import org.webgpu.api.Status;
import org.webgpu.api.SupportedInstanceFeatures;
import org.webgpu.api.exceptions.WGPUException;

import org.webgpu.api.spi.WGPUProvider;
import org.webgpu.impl.InstanceImpl;
import org.webgpu.panama.NativeLibraryLoader;
import org.webgpu.panama.WGPULogCallback;
import org.webgpu.panama.WGPUStringView;
import org.webgpu.panama.WGPUSupportedInstanceFeatures;
import org.webgpu.panama.webgpu_h;

@NullMarked
public class WGPUProviderImpl implements WGPUProvider {

    static {
        NativeLibraryLoader.loadLibrary();
    }

    @Override
    public Instance createInstance(InstanceDescriptor descriptor) {
        return new InstanceImpl(descriptor);
    }

    public void getInstanceFeatures(SupportedInstanceFeatures features) {
        var featuresSegment = Arena.ofAuto().allocate(WGPUSupportedInstanceFeatures.layout());
        webgpu_h.wgpuGetInstanceFeatures(featuresSegment);
        long count = WGPUSupportedInstanceFeatures.featureCount(featuresSegment);
        MemorySegment featuresArray = WGPUSupportedInstanceFeatures.features(featuresSegment);

        InstanceFeatureName[] instanceFeatures = new InstanceFeatureName[(int) count];
        for (int i = 0; i < count; i++) {
            int featureValue = featuresArray.get(ValueLayout.JAVA_INT, i * ValueLayout.JAVA_INT.byteSize());
            instanceFeatures[i] = switch (featureValue) {
                case 0 -> InstanceFeatureName.NULL;
                case 1 -> InstanceFeatureName.TIMED_WAIT_ANY;
                case 2 -> InstanceFeatureName.SHADER_SOURCE_SPIRV;
                case 3 -> InstanceFeatureName.MULTIPLE_DEVICES_PER_ADAPTER;
                default -> throw new WGPUException("Unknown instance feature value: " + featureValue);
            };
        }

        features.features(instanceFeatures);
    }

    @Override
    public Status getInstanceLimits(InstanceLimits limits) {

        return Status.SUCCESS;
    }

    /**
     * Operation is not implemented in wgpu_native
     */
    @Override
    public boolean hasInstanceFeature(InstanceFeatureName feature) {
        return false;
    }

    public void setLogCallback(BiConsumer<Integer, String> consumer) {
        Arena arena = Arena.global();

        MemorySegment callbackSegment = WGPULogCallback
                .allocate((int level, MemorySegment stringViewPtr, MemorySegment userdata) -> {

                    final long length = WGPUStringView.length(stringViewPtr);
                    final String string;
                    // If `length` is WGPU_STRLEN, the string is NULL-terminated.
                    if (length == webgpu_h.WGPU_STRLEN()) {
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        int offset = 0;
                        byte b;

                        while ((b = WGPUStringView.data(stringViewPtr).get(ValueLayout.JAVA_BYTE, offset)) != 0) {
                            bos.write(b);
                            offset++;
                        }

                        string = new String(bos.toByteArray(), StandardCharsets.UTF_8);
                    } else {
                        byte[] dataArray = new byte[(int) length];
                        for (int i = 0; i < length; i++) {
                            byte b = WGPUStringView.data(stringViewPtr).get(ValueLayout.JAVA_BYTE, i);
                            dataArray[i] = b;
                        }

                        string = new String(dataArray, StandardCharsets.UTF_8);
                    }

                    consumer.accept(level, string);
                }, arena);

        webgpu_h.wgpuSetLogCallback(callbackSegment, MemorySegment.NULL);
    }

    public void setLogLevel(int level) {
        webgpu_h.wgpuSetLogLevel(level);
    }
}
