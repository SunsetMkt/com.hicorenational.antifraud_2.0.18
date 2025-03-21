package com.umeng.p221ut.p222a.p223a;

import android.text.TextUtils;
import com.umeng.p221ut.p222a.p225c.C3809d;
import com.umeng.p221ut.p222a.p225c.C3810e;
import com.umeng.p221ut.p226b.p227a.p228a.C3811a;

/* renamed from: com.umeng.ut.a.a.b */
/* loaded from: classes2.dex */
public class C3798b {
    /* renamed from: b */
    public static String m12763b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(C3811a.m12791a(C3809d.m12779b(str.getBytes()), 2), "UTF-8");
        } catch (Exception e2) {
            C3810e.m12783a("", e2, new Object[0]);
            return "";
        }
    }
}
