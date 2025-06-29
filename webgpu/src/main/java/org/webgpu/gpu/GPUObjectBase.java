package org.webgpu.gpu;

/**
 * A WebGPU object consists of a WebGPU Interface and an internal object.
 * 
 * The WebGPU interface defines the public interface and state of the WebGPU
 * object. It can be used on the content timeline where it was created, where it
 * is a JavaScript-exposed WebIDL interface.
 * 
 * Any interface which includes GPUObjectBase is a WebGPU interface.
 * 
 * The internal object tracks the state of the WebGPU object on the device
 * timeline. All reads/writes to the mutable state of an internal object occur
 * from steps executing on a single well-ordered device timeline.
 */
public interface GPUObjectBase {
    /**
     * A developer-provided label which is used in an implementation-defined way. It
     * can be used by the browser, OS, or other tools to help identify the
     * underlying internal object to the developer. Examples include displaying the
     * label in GPUError messages, console warnings, browser developer tools, and
     * platform debugging utilities.
     */
    public String label();
}
