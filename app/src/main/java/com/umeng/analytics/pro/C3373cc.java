package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FieldMetaData.java */
/* renamed from: com.umeng.analytics.pro.cc */
/* loaded from: classes2.dex */
public class C3373cc implements Serializable {

    /* renamed from: d */
    private static Map<Class<? extends InterfaceC3360bq>, Map<? extends InterfaceC3367bx, C3373cc>> f11772d = new HashMap();

    /* renamed from: a */
    public final String f11773a;

    /* renamed from: b */
    public final byte f11774b;

    /* renamed from: c */
    public final C3374cd f11775c;

    public C3373cc(String str, byte b2, C3374cd c3374cd) {
        this.f11773a = str;
        this.f11774b = b2;
        this.f11775c = c3374cd;
    }

    /* renamed from: a */
    public static void m11103a(Class<? extends InterfaceC3360bq> cls, Map<? extends InterfaceC3367bx, C3373cc> map) {
        f11772d.put(cls, map);
    }

    /* renamed from: a */
    public static Map<? extends InterfaceC3367bx, C3373cc> m11102a(Class<? extends InterfaceC3360bq> cls) {
        if (!f11772d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            } catch (InstantiationException e3) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e3.getMessage());
            }
        }
        return f11772d.get(cls);
    }
}
