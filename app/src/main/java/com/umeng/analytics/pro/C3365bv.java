package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

/* compiled from: TEnumHelper.java */
/* renamed from: com.umeng.analytics.pro.bv */
/* loaded from: classes2.dex */
public class C3365bv {
    /* renamed from: a */
    public static InterfaceC3364bu m11071a(Class<? extends InterfaceC3364bu> cls, int i2) {
        try {
            return (InterfaceC3364bu) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i2));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
