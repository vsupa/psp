package com.vsupa.core;

/**
 * @author Maxwell.Lee
 * @date 2018-03-06 13:30
 * @since   1.0.0
 */
public interface ComposeOperation<M, F, T> {

    T compose(M m, F f);

}
