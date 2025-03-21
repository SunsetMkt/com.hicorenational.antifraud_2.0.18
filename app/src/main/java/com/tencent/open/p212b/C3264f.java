package com.tencent.open.p212b;

import com.tencent.open.utils.C3289g;
import com.tencent.open.utils.C3291i;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.b.f */
/* loaded from: classes2.dex */
public class C3264f {
    /* renamed from: a */
    public static int m10463a(String str) {
        int m10624a;
        if (C3289g.m10603a() == null || (m10624a = C3291i.m10615a(C3289g.m10603a(), str).m10624a("Common_BusinessReportFrequency")) == 0) {
            return 100;
        }
        return m10624a;
    }

    /* renamed from: a */
    public static int m10462a() {
        int m10624a = C3291i.m10615a(C3289g.m10603a(), (String) null).m10624a("Common_HttpRetryCount");
        if (m10624a == 0) {
            return 2;
        }
        return m10624a;
    }
}
