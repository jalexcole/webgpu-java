package org.webgpu.annotations;

public @interface Callback {
    CallbackType callbackType();

    public enum CallbackType {
        CALLBACK_MODE,
        IMMEDIATE
    }
}
