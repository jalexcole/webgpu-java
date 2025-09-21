package org.webgpu.api;

import java.util.Arrays;

import org.webgpu.foreign.webgpu_h;

public enum WGSLLanguageFeatureName {
    ReadonlyAndReadwriteStorageTextures(webgpu_h.WGPUWGSLLanguageFeatureName_ReadonlyAndReadwriteStorageTextures()),
    Packed4x8IntegerDotProduct(webgpu_h.WGPUWGSLLanguageFeatureName_Packed4x8IntegerDotProduct()),
    UnrestrictedPointerParameters(webgpu_h.WGPUWGSLLanguageFeatureName_UnrestrictedPointerParameters()),
    PointerCompositeAccess(webgpu_h.WGPUWGSLLanguageFeatureName_PointerCompositeAccess()),;
    
    private final int value;

    WGSLLanguageFeatureName(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static WGSLLanguageFeatureName fromValue(int value) {
        for (WGSLLanguageFeatureName level : WGSLLanguageFeatureName.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value + ". Must be one of: " + Arrays.toString(WGSLLanguageFeatureName.values()));
    }
}