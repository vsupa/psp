package com.vsupa.common;

import java.util.List;

/**
 * 带分页信息的ResultVo；
 * @author Maxwell.Lee
 * @date 2018-02-02 19:01
 * @since   1.0.0
 */
public class PagedResultVo<T> extends ResultVo<List<T>> {

    private static final long serialVersionUID = 510049707076615952L;

    /**
     * 当前分页条目个数；
     */
    private int     size;

    /**
     * 满足条件的结果记录总个数；
     */
    private int     totalCount;

    /**
     * 页码，IndexByOne；
     */
    private int     pageNo;

    /**
     * 每页条目个数；
     */
    private int     pageSize;

    public PagedResultVo(int flag, String errorCode, String message, String debugMessage) {
        super(flag, errorCode, message, debugMessage);
    }

    public PagedResultVo(int totalCount, int pageNo, int pageSize) {
        super(null);
        this.size = 0;
        this.totalCount = totalCount;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public PagedResultVo(List<T> data, int totalCount, int pageNo, int pageSize) {
        super(data);

        if (data != null) {
            this.size = data.size();
            this.totalCount = totalCount;
        }
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public PagedResultVo(List<T> data) {
        super(data);

        if (data != null) {
            this.size = data.size();
            this.totalCount = data.size();
        }
        this.pageNo = 1;
        this.pageSize = 10;
    }

    public PagedResultVo(PageList<T> data) {
        super(data.getItems());
        if (data.getItems() != null) {
            this.size = data.getItems().size();
        }

        this.pageNo = data.getPageNo();
        this.pageSize = data.getPageSize();
        this.totalCount = data.getTotalCount();
    }

    public int  getPageCount() {
        return (int)Math.ceil(totalCount * 1.0 / pageSize);
    }

    public int getSize() {
        return size;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    @Override
    public String toString() {
        return "PagedResultVo{" +
                "size=" + size +
                ", totalCount=" + totalCount +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                "} " + super.toString();
    }
}
