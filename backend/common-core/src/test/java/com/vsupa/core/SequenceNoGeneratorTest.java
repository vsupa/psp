package com.vsupa.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Maxwell.Lee
 * @date 2018-03-13 18:55
 * @since   1.0.0
 */
public class SequenceNoGeneratorTest {

    private SequenceNoGenerator generator = new SequenceNoGenerator();

    @Test
    public void next() {
        System.out.println(generator.next());
        System.out.println(generator.next());
        System.out.println(generator.next());
        System.out.println(generator.next());
    }
}