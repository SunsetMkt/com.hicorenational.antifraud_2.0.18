package com.umeng.p221ut.p226b.p227a.p228a;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/* renamed from: com.umeng.ut.b.a.a.d */
/* loaded from: classes2.dex */
public class C3814d {

    /* renamed from: a */
    private static final Pattern f13887a = Pattern.compile("([\t\r\n])+");

    /* renamed from: a */
    public static int m12798a(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i2 = 0;
        for (char c2 : str.toCharArray()) {
            i2 = (i2 * 31) + c2;
        }
        return i2;
    }

    /* renamed from: d */
    public static String m12800d(String str) {
        return (str == null || "".equals(str)) ? str : f13887a.matcher(str).replaceAll("");
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() <= 0;
    }

    /* renamed from: a */
    public static Map<String, String> m12799a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        TreeMap treeMap = new TreeMap(new Comparator<String>() { // from class: com.umeng.ut.b.a.a.d.1
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        });
        treeMap.putAll(map);
        return treeMap;
    }
}
