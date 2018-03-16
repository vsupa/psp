package com.vsupa.common;

import java.io.Serializable;

/**
 * 条目Id及其个数
 * @author Maxwell.Lee
 * @date 2018-02-02 16:38
 * @since   1.0.0
 */
public class ItemAndCountVo implements Serializable {

    private static final long serialVersionUID = -4242277930597638616L;

    /**
     * 条目Id；
     */
    private Long        itemId;

    /**
     * 个数；
     */
    private Integer     count;

    public ItemAndCountVo() {

    }

    public ItemAndCountVo(Long itemId, Integer count) {
        this.itemId = itemId;
        this.count = count;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ItemAndCountVo{" +
                "itemId=" + itemId +
                ", count=" + count +
                '}';
    }
}
