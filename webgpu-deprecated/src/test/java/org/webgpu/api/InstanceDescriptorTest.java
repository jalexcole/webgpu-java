package org.webgpu.api;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.foreign.MemorySegment;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstanceDescriptorTest {

    private static final Logger logger = LoggerFactory.getLogger(InstanceDescriptorTest.class);

    @Test
    void createInstanceDescriptor() {
        var descriptor = new InstanceDescriptor();
        logger.info("InstanceDescriptor: {}", descriptor);
        assertNotNull(descriptor);
    }

    @Test
    void testAddress() {
        var descriptor = new InstanceDescriptor();
        var address = descriptor.address();
        logger.info("InstanceDescriptor address: {}", address);
        assertNotEquals(address, MemorySegment.NULL);
    }

    @Test
    void testGetSegment() {
        var descriptor = new InstanceDescriptor();
        var segment = descriptor.getSegment();
        logger.info("InstanceDescriptor segment: {}", segment);
        assertNotEquals(segment, MemorySegment.NULL);
    }

    @Test
    void testNextInChain() {
        var descriptor = new InstanceDescriptor();
        var nextInChain = descriptor.nextInChain();
        logger.info("InstanceDescriptor nextInChain: {}", nextInChain);
        // assertNotEquals(nextInChain, MemorySegment.NULL);
    }

    @Test
    void testToString() {
        var descriptor = new InstanceDescriptor();
        var toString = descriptor.toString();
        logger.info("InstanceDescriptor toString: {}", toString);
        assertNotNull(toString);
        assertFalse(toString.isEmpty());
    }
}
