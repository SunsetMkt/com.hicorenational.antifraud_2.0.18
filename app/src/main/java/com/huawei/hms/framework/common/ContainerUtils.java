package com.huawei.hms.framework.common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class ContainerUtils {
    public static final String FIELD_DELIMITER = "&";
    public static final String KEY_VALUE_DELIMITER = "=";

    public static <K, V> boolean equals(Map<K, V> map, Map<K, V> map2) {
        boolean z;
        if (map == map2) {
            return true;
        }
        if (map != null && map2 != null && map.size() == map2.size()) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Map.Entry<K, V> next = it.next();
                if (map2.get(next.getKey()) != next.getValue()) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public static <K, V> int hashCode(Map<K, V> map) {
        return toString(map).hashCode();
    }

    public static <K, V> String toString(Map<K, V> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            int i3 = i2 + 1;
            if (i2 > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey().toString());
            sb.append(KEY_VALUE_DELIMITER);
            sb.append(entry.getValue().toString());
            i2 = i3;
        }
        return sb.toString();
    }

    public static <K> String toString(Set<K> set) {
        if (set == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (K k2 : set) {
            int i3 = i2 + 1;
            if (i2 > 0) {
                sb.append("&");
            }
            sb.append(k2.toString());
            i2 = i3;
        }
        return sb.toString();
    }

    public static <K> String toString(List<K> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (K k2 : list) {
            int i3 = i2 + 1;
            if (i2 > 0) {
                sb.append("&");
            }
            sb.append(k2.toString());
            i2 = i3;
        }
        return sb.toString();
    }
}
