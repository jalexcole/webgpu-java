package org.webgpu.api;

import java.security.InvalidParameterException;
import java.util.Arrays;

import org.webgpu.foreign.webgpu_h;

/**
 * The callback mode controls how a callback for an asynchronous operation may
 * be fired. See @ref Asynchronous-Operations for how these are used.
 */
public enum CallbackMode {
    INVALID(0), // Placed by alex.
    WAIT_ANY_ONLY(webgpu_h.WGPUCallbackMode_WaitAnyOnly()),
    ALLOW_PROCESS_EVENtS(webgpu_h.WGPUCallbackMode_AllowProcessEvents()),
    ALLOW_SPONTANEOUS(webgpu_h.WGPUCallbackMode_AllowSpontaneous()),
    FORCE32(webgpu_h.WGPUCallbackMode_Force32());

    private final int value;

    CallbackMode(int value) {
        this.value = value;
    }

    static CallbackMode of(int mode) {
        if (mode == CallbackMode.INVALID.value)
            return CallbackMode.INVALID;
        if (mode == CallbackMode.WAIT_ANY_ONLY.value)
            return CallbackMode.WAIT_ANY_ONLY;
        if (mode == CallbackMode.ALLOW_PROCESS_EVENtS.value)
            return CallbackMode.ALLOW_PROCESS_EVENtS;
        if (mode == CallbackMode.ALLOW_SPONTANEOUS.value)
            return CallbackMode.ALLOW_SPONTANEOUS;
        if (mode == CallbackMode.FORCE32.value)
            return CallbackMode.FORCE32;

        throw new InvalidParameterException(
                "Invalid mode: " + mode + ". Must consist of: " + Arrays.toString(CallbackMode.values()));
    }

    public int value() {
        return this.value;
    }

}
