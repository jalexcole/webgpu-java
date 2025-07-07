package org.webgpu;

import org.webgpu.extract.webgpu_h;

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
}