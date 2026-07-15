package org.webgpu.impl.util;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.Arrays;

import org.jspecify.annotations.NullMarked;
import org.webgpu.api.WGPUObject;
import org.webgpu.impl.WebGPUObjectImpl;

@NullMarked
public class ObjectUtils {

    private ObjectUtils() {
        
    }

    
	public static <T extends WGPUObject> MemorySegment mapArray(T[] input, Arena arena) {
        @SuppressWarnings("null")
		final var pointers = Arrays.stream((WebGPUObjectImpl[]) input).map(WebGPUObjectImpl::ptr).toList();

        final MemorySegment commandArray = arena.allocate(
                ValueLayout.ADDRESS, pointers.size());

        for (int i = 0; i < pointers.size(); i++) {
            commandArray.setAtIndex(ValueLayout.ADDRESS, i, pointers.get(i));

        }

        return commandArray;

    }

    @SuppressWarnings("null")
	public static <T extends WGPUObject> MemorySegment mapArray(T[] input) {
        return mapArray(input, Arena.ofAuto());
    }
}
