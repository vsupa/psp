package com.vsupa.core;

import org.junit.Test;

/**
 * @author Maxwell.Lee
 * @date 2018-01-10 19:57
 * @since   1.0.0
 */
public class ShortCodeGeneratorTest {

    private ShortCodeGenerator generator = new ShortCodeGenerator(6);

    @Test
    public void next() {
        for(int i = 0; i < 100; i++) {
            System.out.println(generator.next());
        }
    }
}