package org.webgpu.impl;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.webgpu.api.Instance;
import org.webgpu.api.WGPU;

public class InstanceImplTest {
    private static final Logger logger = Logger.getLogger(InstanceImplTest.class.getName());
    @Test
    void testClose() {
        try (Instance instance = WGPU.createInstance(null)) {
            instance.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void testRequestAdapterFuture() {
        try (Instance instance = WGPU.createInstance(null)) {
            instance.requestAdapter(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testRequestAdapter() throws InterruptedException {
        try (Instance instance = WGPU.createInstance(null)) {
            var adapterFuture = instance.requestAdapter(null);
            
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        var features = adapterFuture.get().features();
                        logger.info(Arrays.asList(features).toString());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }
            }, 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Thread.sleep(5);
        
        logger.info("done");
    }
}
