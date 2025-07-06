package org.webgpu;

import org.webgpu.extract.webgpu_h;

public enum PresentMode {
    /**
     * Present mode is not specified. Use the default.
     */
    UNDEFINED(webgpu_h.WGPUPresentMode_Undefined()),
    /**
     * The presentation of the image to the user waits for the next vertical
     * blanking period to update in a first-in, first-out manner.
     * Tearing cannot be observed and frame-loop will be limited to the display's
     * refresh rate.
     * This is the only mode that's always available.
     */
    FIFO(webgpu_h.WGPUPresentMode_Fifo()),
    /**
     * The presentation of the image to the user tries to wait for the next vertical
     * blanking period but may decide to not wait if a frame is presented late.
     * Tearing can sometimes be observed but late-frame don't produce a full-frame
     * stutter in the presentation.
     * This is still a first-in, first-out mechanism so a frame-loop will be limited
     * to the display's refresh rate.
     */
    FIFO_RELAXED(webgpu_h.WGPUPresentMode_FifoRelaxed()),
    /**
     * The presentation of the image to the user is updated immediately without
     * waiting for a vertical blank.
     * Tearing can be observed but latency is minimized.
     */
    MAILBOX(webgpu_h.WGPUPresentMode_Mailbox()),
    /**
     * The presentation of the image to the user waits for the next vertical
     * blanking period to update to the latest provided image.
     * Tearing cannot be observed and a frame-loop is not limited to the display's
     * refresh rate.
     */
    FORCE32(webgpu_h.WGPUPresentMode_Force32());

    public final int value;

    PresentMode(int value) {
        this.value = value;
    }
}