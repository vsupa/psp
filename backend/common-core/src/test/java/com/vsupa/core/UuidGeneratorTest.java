package com.vsupa.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Maxwell.Lee
 * @date 2018-01-15 15:01
 * @since   1.0.0
 */
public class UuidGeneratorTest {

    private UuidGenerator generator = new UuidGenerator(32);

    @Test
    public void next() {
        for(int i=0; i<100; i++) {
            System.out.println(generator.next());
        }
    }
}