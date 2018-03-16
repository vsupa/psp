package com.vsupa.core;

import java.util.*;
import java.util.function.Function;

/**
 * Map工具类；
 * @author Maxwell.Lee
 * @date 2018-03-01 14:28
 * @since   1.0.0
 */
public class MapUtils {

    /**
     * 把集合的元素构造成Map，通过keyFun生成键值；
     * @param objects   列表，（必要）；
     * @param keyFun    键值生成函数，（必要）；
     * @param <K>       结果Map的键值类型；
     * @param <V>       输入列表的元素类型；
     * @return  返回键值非空的全部元素构成的Map；
     */
    public static <K, V> Map<K, V> buildMap(Collection<V> objects, Function<V, K> keyFun) {
        if (objects == null || keyFun == null) return null;

        Map<K, V> rst = new HashMap<>();
        objects.forEach(val -> {
            K key = keyFun.apply(val);
            if (key != null) rst.put(key, val);
        });

        return rst;
    }

    /**
     * 把集合的元素构造成Map，通过keyFun生成键值（可以重复，键值重复的元素组成列表）；
     * @param objects       列表，（必要）；
     * @param keyFun        键值生成函数，（必要）；
     * @param <K>           结果Map的键值类型；
     * @param <V>           输入列表的元素类型；
     * @return  返回键值非空的全部元素构成的Map；
     */
    public static <K, V> Map<K, List<V>> buildMapMultiple(Collection<V> objects, Function<V, K> keyFun) {
        if (objects == null || keyFun == null) return null;

        Map<K, List<V>> rst = new HashMap<>();
        objects.forEach(val -> {
            K key = keyFun.apply(val);
            if (key != null) rst.computeIfAbsent(key, c -> new ArrayList<>()).add(val);
        });

        return rst;
    }

    /**
     * 把集合的元素构造成Map，通过keyFun生成键值；
     * @param objects   列表，（必要）；
     * @param keyFun    键值生成函数，（必要）；
     * @param <K>       结果Map的键值类型；
     * @param <V>       输入列表的元素类型；
     * @return  返回键值非空的全部元素构成的Map，否则返回空的Map；
     */
    public static <K, V> Map<K, V> buildMapNotNull(Collection<V> objects, Function<V, K> keyFun) {
        Map<K, V> rst = buildMap(objects, keyFun);

        return (rst != null ? rst : new HashMap<>());
    }

    /**
     * 把集合的元素构造成Map，通过keyFun生成键值（可以重复，键值重复的元素组成列表）；
     * @param objects   列表，（必要）；
     * @param keyFun    键值生成函数，（必要）；
     * @param <K>       结果Map的键值类型；
     * @param <V>       输入列表的元素类型；
     * @return  返回键值非空的全部元素构成的Map，否则返回空的Map；
     */
    public static <K, V> Map<K, List<V>> buildMapNotNullMultiple(Collection<V> objects, Function<V, K> keyFun) {
        Map<K, List<V>> rst = buildMapMultiple(objects, keyFun);

        return (rst != null ? rst : new HashMap<>());
    }

    /**
     * 遍历集合并且成功Map：通过keyFun生成键值，通过valFun生成值；
     * @param objects   列表，（必要）；
     * @param keyFun    键值生成函数，（必要）；
     * @param valFun    取值生成函数，（必要）；
     * @param <K>       结果Map的键值类型；
     * @param <V>       结果Map的取值类型；
     * @param <T>       输入列表的元素类型；
     * @return  返回键值非空的全部元素构成的Map；
     */
    public static <K, V, T> Map<K, V> buildMap(Collection<T> objects, Function<T, K> keyFun, Function<T, V> valFun) {
        if (objects == null || keyFun == null || valFun == null) return null;

        Map<K, V> rst = new HashMap<>();
        objects.forEach(t -> {
            K key = keyFun.apply(t);
            V val = valFun.apply(t);
            if (key != null) rst.put(key, val);
        });

        return rst;
    }

    /**
     * 从Map中批量获取元素；
     * @param map   Map，（必要）；
     * @param keys  键值列表，（必要）；
     * @param <K>   键值类型；
     * @param <V>   元素类型；
     * @return  返回的元素列表满足：keys对应的元素相对顺序保持一致，除非键值没有对应的元素；
     */
    public static  <K, V> List<V> batchGet(Map<K, V> map, Collection<K> keys) {
        if (map == null || keys == null) {
            throw new IllegalArgumentException("参数不全。[0x00MU3361]");
        }

        List<V> rst = new ArrayList<>();
        keys.forEach(k -> {
            V v = map.get(k);
            if (v != null) rst.add(v);
        });

        return rst;
    }

}
