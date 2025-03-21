package com.umeng.p221ut.p226b.p227a.p228a;

import com.umeng.p221ut.p222a.p225c.C3810e;

/* renamed from: com.umeng.ut.b.a.a.e */
/* loaded from: classes2.dex */
class C3815e {
    static String get(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e2) {
            C3810e.m12786b("", e2, new Object[0]);
            return str2;
        }
    }
}
