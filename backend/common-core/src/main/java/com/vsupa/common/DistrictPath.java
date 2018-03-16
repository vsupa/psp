package com.vsupa.common;

import java.io.Serializable;

/**
 * 行政区层级路径，包括：省、市和区县；
 * @author Maxwell.Lee
 * @date 2018-03-08 13:33
 * @since   1.0.0
 */
public class DistrictPath implements Serializable {

    private static final long serialVersionUID = -4139726598615428315L;

    /**
     * 省行政区编码；
     */
    private String  provinceCode;

    /**
     * 市行政区编码；
     */
    private String  cityCode;

    /**
     * 区或县行政区编码；
     */
    private String  countyCode;

    public DistrictPath(String provinceCode, String cityCode, String countyCode) {
        this.provinceCode = provinceCode;
        this.cityCode = cityCode;
        this.countyCode = countyCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getCountyCode() {
        return countyCode;
    }

    @Override
    public String toString() {
        return "DistrictPath{" +
                "provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", countyCode='" + countyCode + '\'' +
                '}';
    }
}
