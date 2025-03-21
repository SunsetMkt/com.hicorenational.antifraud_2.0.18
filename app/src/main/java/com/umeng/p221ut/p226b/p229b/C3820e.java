package com.umeng.p221ut.p226b.p229b;

import com.umeng.p221ut.p222a.p224b.C3799a;
import com.umeng.p221ut.p222a.p225c.C3810e;

/* renamed from: com.umeng.ut.b.b.e */
/* loaded from: classes2.dex */
public class C3820e {
    /* renamed from: a */
    public static boolean m12825a(C3799a c3799a) {
        String str = "";
        try {
            str = new String(c3799a.data, "UTF-8");
        } catch (Exception e2) {
            C3810e.m12784a("", e2);
        }
        if (C3799a.m12764a(str, c3799a.signature)) {
            return C3817b.m12806a(C3817b.m12805a(str).f13891d);
        }
        return false;
    }
}
