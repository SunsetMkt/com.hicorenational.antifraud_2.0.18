package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FieldMetaData.java */
/* JADX INFO: loaded from: classes2.dex */
public class cc implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<Class<? extends bq>, Map<? extends bx, cc>> f7131d = new HashMap();
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f7132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cd f7133c;

    public cc(String str, byte b2, cd cdVar) {
        this.a = str;
        this.f7132b = b2;
        this.f7133c = cdVar;
    }

    public static void a(Class<? extends bq> cls, Map<? extends bx, cc> map) {
        f7131d.put(cls, map);
    }

    public static Map<? extends bx, cc> a(Class<? extends bq> cls) {
        if (!f7131d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            } catch (InstantiationException e3) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e3.getMessage());
            }
        }
        return f7131d.get(cls);
    }
}
