package com.vsupa;

/**
 * 通用状态
 * @author Maxwell.Lee
 * @date 2018-02-05 20:03
 * @since   1.0.0
 */
public enum GeneralState {
    Deleted(-1, "已删除"), Draft(0, "草稿"), Valid(1, "有效");

    private int     code;

    private String  name;

    GeneralState(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "GeneralState{" +
                "code=" + code +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }
}
