package com.vsupa.common;

/**
 * 分页参数Vo，IndexByOne。
 * @author Maxwell.Lee
 * @date 2018-01-08 16:08
 * @since   1.0.0
 */
public class PageVo extends ServiceAbstractVo {

    private static final long serialVersionUID = 7317567503391592334L;

    /**
     * 页码，IndexByOne
     */
    private int no;

    /**
     * 每页记录个数，默认值10
     */
    private int size;

    public PageVo() {
        this.no = 1;
        this.size = 10;
    }

    public PageVo(int no, int size) {
        this.no = no;
        this.size = size;
    }

    /**
     * @return 记录的偏移量，IndexByZero（跟随MySQL的规则）；
     */
    public int getOffset() {
        return (no - 1) * size;
    }

    /**
     * @return  页码，IndexByOne
     */
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
