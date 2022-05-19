package com.github.huajiayi.junittool.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Joey
 */
public class CopyUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 复制.
     * @param v 被复制对象
     * @param kClass 复制成类
     * @param <K> 复制成类
     * @param <V> 被复制对象
     * @return 复制结果
     */
    public static <K, V> K to(final V v, final Class<K> kClass) {
        if (v == null) {
            return null;
        }

        K k = null;
        try {
            k = mapper.readValue(mapper.writeValueAsBytes(v), kClass);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return k;
    }

    /**
     * 转为List类型.
     * @param vList 复制源集合
     * @param kClass 复制结果类
     * @param <K> 复制结果
     * @param <V> 复制源
     * @return 复制结果集合
     */
    public static <K, V> List<K> toList(final Collection<V> vList, final Class<K> kClass) {
        if (vList == null) {
            return null;
        }
        return vList.stream().map(v -> to(v, kClass)).collect(Collectors.toList());
    }
}
