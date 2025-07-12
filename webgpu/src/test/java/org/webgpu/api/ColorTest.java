package org.webgpu.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ColorTest {
    
    public static final Logger logger = LoggerFactory.getLogger(ColorTest.class);
    
    @Test
    void testColor() {
        new Color();
    }

    @Test
    void testA() {
        var color = new Color();
        logger.info("Color a: {}, {}", color.a());
    }

    @Test
    void testB() {
        var color = new Color();
        logger.info("Color b: {}", color.b());
        assertTrue(true);
    }

    @Test
    void testG() {
        var color = new Color();
        logger.info("Color g: {}", color.g());
    }

    @Test
    void testPtr() {
        var color = new Color();
        logger.info("Color memory: {}", color.ptr());
    }

    @Test
    void testR() {
        var color = new Color();
        logger.info("Color g: {}", color.g());
    }

    @Test
    void testToString() {
        var color = new Color();
        logger.info("Color a: {}", color.toString());
    }
}
