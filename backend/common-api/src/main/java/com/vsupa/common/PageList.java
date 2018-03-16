package com.vsupa.common;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 带分页信息的List
 * @author Maxwell.Lee
 * @date 2018-02-01 20:26
 * @since   1.0.0
 */
public class PageList<T> implements Serializable {

    private static final long serialVersionUID = -1515529231343503315L;

    /**
     * 条目总个数
     */
    private int     totalCount;

    /**
     * 每页条目数
     */
    private int     pageSize;

    /**
     * 当前页码，IndexByOne
     */
    private int     pageNo;

    /**
     * 条目
     */
    private List<T> items;

    public PageList(Pagination page, List<T> items) {
        this.totalCount = page.getTotal();
        this.pageSize = page.getSize();
        this.pageNo = page.getCurrent();
        this.items = items;
    }

    public PageList(int pageNo, int pageSize, int totalCount, List<T> items) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.items = items;
    }

    public <R> List<R> mapAndCollect(Function<T, R> mapper) {
        if (items == null || items.isEmpty()) return null;

        return items.stream().map(mapper).collect(Collectors.toList());
    }

    public boolean isEmpty() {
        return (items == null || items.isEmpty());
    }

    public int getPageCount() {
        return (int) Math.ceil(totalCount * 1.0 / pageSize);
    }

    public int getSize() {
        return (items != null ? items.size() : 0);
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public List<T> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "PageList{" +
                "totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                ", items=" + items +
                '}';
    }
}
