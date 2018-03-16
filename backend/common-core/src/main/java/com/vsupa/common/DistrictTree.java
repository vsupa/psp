package com.vsupa.common;

import java.io.Serializable;
import java.util.*;

/**
 * 行政区层级树，三级：省、市、区县；
 * @author Maxwell.Lee
 * @date 2018-03-08 11:35
 * @since   1.0.0
 */
public class DistrictTree implements Serializable {
    private static final long serialVersionUID = 1076124995771631367L;

    private Map<String, DistrictPath>   code2CountyMap;

    private Map<String, _Node>   code2CityMap;

    private Map<String, _Node>   code2ProvinceMap;

    public DistrictTree(List<DistrictPath> counties) {
        Map<String, SortedSet<String>> childrenMap = new HashMap<>();
        Map<String, DistrictPath> notCountyMap = new HashMap<>();

        this.code2CountyMap = new HashMap<>();
        this.code2CityMap = new HashMap<>();
        this.code2ProvinceMap = new HashMap<>();

        for (DistrictPath c : counties) {
            if (c.getProvinceCode() == null || c.getCityCode() == null || c.getCountyCode() == null) continue;

            this.code2CountyMap.put(c.getCountyCode(), c);

            //处理市行政区节点；
            if (!notCountyMap.containsKey(c.getCityCode())) {
                notCountyMap.put(c.getCityCode(), new DistrictPath(c.getProvinceCode(), c.getCityCode(), null));
            }
            childrenMap.computeIfAbsent(c.getCityCode(), k -> new TreeSet<>()).add(c.getCountyCode());

            //处理省行政区节点；
            if (!notCountyMap.containsKey(c.getProvinceCode())) {
                notCountyMap.put(c.getProvinceCode(), new DistrictPath(c.getProvinceCode(), null, null));
            }
            childrenMap.computeIfAbsent(c.getProvinceCode(), k -> new TreeSet<>()).add(c.getProvinceCode());
        }

        notCountyMap.forEach((code, dp) -> {
            SortedSet<String> tmp = childrenMap.get(code);
            List<String> children;
            if (tmp != null) {
                children = Collections.unmodifiableList(new ArrayList<>(tmp));
            } else {
                children = Collections.unmodifiableList(new ArrayList<>());
            }

            if (dp.getCityCode() != null) {
                code2CityMap.put(dp.getCityCode(), new _Node(dp, children));
            } else {
                code2ProvinceMap.put(dp.getProvinceCode(), new _Node(dp, children));
            }
        });

    }

    /**
     * 获取指定行政区的完整的省市区县行政区编码；
     * @param code      行政区编码，（必要）；
     * @return  行政区节点；
     */
    public DistrictPath getByCode(String code) {
        _Node node = code2ProvinceMap.get(code);
        if (node != null) return node.path;

        node = code2CityMap.get(code);
        if (node != null) return node.path;

        return code2CountyMap.get(code);
    }

    /**
     * 获取指定行政区的上级行政区编码；
     * @param code      行政区编码，（必要）；
     * @return  上级行政区编码；如果没有上级，返回空值；
     */
    public String   getSuperiorCode(String code) {
        _Node node = code2CityMap.get(code);
        if (node != null) return node.path.getProvinceCode();

        DistrictPath path = code2CountyMap.get(code);
        if (path != null) return path.getCityCode();

        return null;
    }

    /**
     * 获取指定行政区的下辖行政区编码；
     * @param code      行政区编码，（必要）；
     * @return  下辖行政区编码列表，如果没有下级行政区，返回空值；
     */
    public List<String>     getSubordinateCodes(String code) {
        _Node node = code2ProvinceMap.get(code);
        if (node != null) return node.children;

        node = code2CityMap.get(code);
        if (node != null) return node.children;

        return null;
    }

    private static class _Node {

        private DistrictPath    path;

        private List<String>    children;

        _Node(DistrictPath path, List<String> children) {
            this.path = path;
            this.children = children;
        }

        public DistrictPath getPath() {
            return path;
        }

        public List<String> getChildren() {
            return children;
        }
    }
}
