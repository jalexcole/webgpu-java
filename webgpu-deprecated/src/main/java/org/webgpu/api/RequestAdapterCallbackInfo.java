package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import org.webgpu.panama.foreign.WGPURequestAdapterCallbackInfo;

public class RequestAdapterCallbackInfo {
    private MemorySegment ptr;

    public RequestAdapterCallbackInfo() {
        try {
            Arena arena = Arena.ofAuto();
            ptr = WGPURequestAdapterCallbackInfo.allocate(arena);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<ChainedStruct> nextInChain() {
        var chainedStructPtr = WGPURequestAdapterCallbackInfo.nextInChain(ptr);

        if (chainedStructPtr.equals(MemorySegment.NULL)) {
            return Optional.empty();
        }

        return Optional.of(new ChainedStruct(WGPURequestAdapterCallbackInfo.nextInChain(ptr)));
    }

    public CallbackMode mode() {
        return CallbackMode.of(WGPURequestAdapterCallbackInfo.mode(ptr));
    }

    public void mode(CallbackMode mode) {
        WGPURequestAdapterCallbackInfo.mode(ptr, mode.value());
    }

    public RequestAdapterCallback callback() {
        var callbackPtr = WGPURequestAdapterCallbackInfo.callback(ptr);
        throw new UnsupportedOperationException("Unimplemented method 'callback'");
    }

    public void callback(RequestAdapterCallback callback) {
        throw new UnsupportedOperationException("Unimplemented method 'callback'");
    }

    public MemorySegment userdata1() {

        return WGPURequestAdapterCallbackInfo.userdata1(ptr);
    }

    public void userdata1(MemorySegment userdata1) {
        WGPURequestAdapterCallbackInfo.userdata1(ptr, userdata1);
    }

    public MemorySegment userdata2() {
        return WGPURequestAdapterCallbackInfo.userdata2(ptr);
    }

    public void userdata2(MemorySegment userdata2) {
        WGPURequestAdapterCallbackInfo.userdata2(ptr, userdata2);
    }

    @Override
    public String toString() {
        return "RequestAdapterCallbackInfo [nextInChain()=" + nextInChain() + ", mode()=" + mode() + ", callback()="
                + callback() + ", userdata1()=" + userdata1() + ", getClass()=" + getClass() + ", userdata2()="
                + userdata2() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    public static void main(String... args) {
        var callbackInfo = new RequestAdapterCallbackInfo();
        System.out.println(callbackInfo);
    }

}
