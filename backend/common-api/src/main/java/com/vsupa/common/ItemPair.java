package com.vsupa.common;

import java.io.Serializable;

/**
 * 条目对；
 * @author Maxwell.Lee
 * @date 2018-03-14 10:32
 * @since   1.0.0
 */
public class ItemPair<M, N> implements Serializable{

    private static final long serialVersionUID = 4620193360273048211L;

    private M   from;

    private N   to;

    public ItemPair(M from, N to) {
        this.from = from;
        this.to = to;
    }

    public M getFrom() {
        return from;
    }

    public N getTo() {
        return to;
    }

}
