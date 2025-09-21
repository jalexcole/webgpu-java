package org.webgpu.api;

import org.webgpu.panama.foreign.webgpu_h;

public enum StorageTextureAccess {
    BindingNotUsed(webgpu_h.WGPUStorageTextureAccess_BindingNotUsed()),
    UNDEFINED(webgpu_h.WGPUStorageTextureAccess_Undefined()),
    WRITE_ONLY(webgpu_h.WGPUStorageTextureAccess_WriteOnly()),
    READ_ONLY(webgpu_h.WGPUStorageTextureAccess_ReadOnly()),
    READ_WRITE(webgpu_h.WGPUStorageTextureAccess_ReadWrite()),
    FORCE32(webgpu_h.WGPUStorageTextureAccess_Force32());

    public final int value;

    StorageTextureAccess(int value) {
        this.value = value;
    }

    public static StorageTextureAccess fromValue(int value) {
        for (StorageTextureAccess access : values()) {
            if (access.value == value) {
                return access;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }

    public static StorageTextureAccess fromValue(String value) {
        for (StorageTextureAccess access : values()) {
            if (access.name().equals(value)) {
                return access;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}