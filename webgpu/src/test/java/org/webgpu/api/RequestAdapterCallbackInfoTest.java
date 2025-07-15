package org.webgpu.api;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import org.junit.jupiter.api.Test;

public class RequestAdapterCallbackInfoTest {

/*************  ✨ Windsurf Command ⭐  *************/
    /**
     * Test that the constructor for RequestAdapterCallbackInfo doesn't throw an
     * exception.
     */
/*******  33f54e77-93e5-41cb-83c4-702eb15e7bcd  *******/
    @Test
    void testRequestAdapterCallbackInfo() {
        var requestAdapterCallbackInfo = new RequestAdapterCallbackInfo();
    }

    @Test
    void testCallback() {
        var requestAdapterCallbackInfo = new RequestAdapterCallbackInfo();

        requestAdapterCallbackInfo.callback();
        requestAdapterCallbackInfo.callback();

        try (Arena arena = Arena.ofConfined()) {
            
        }

    }

    

    @Test
    void testMode() {
        var requestAdapterCallbackInfo = new RequestAdapterCallbackInfo();

        requestAdapterCallbackInfo.mode();
    }

    

    @Test
    void testNextInChain() {
        var requestAdapterCallbackInfo = new RequestAdapterCallbackInfo();
        var chainedStruct = requestAdapterCallbackInfo.nextInChain();
    }

    @Test
    void testToString() {
        var requestAdapterCallbackInfo = new RequestAdapterCallbackInfo();

        requestAdapterCallbackInfo.toString();
    }

    @Test
    void testUserdata1() {
        var requestAdapterCallbackInfo = new RequestAdapterCallbackInfo();

        requestAdapterCallbackInfo.userdata1();
    }

    

    @Test
    void testUserdata2() {
        var requestAdapterCallbackInfo = new RequestAdapterCallbackInfo();

        requestAdapterCallbackInfo.userdata2();
    }

    
}
