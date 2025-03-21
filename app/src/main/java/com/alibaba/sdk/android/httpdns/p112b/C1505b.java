package com.alibaba.sdk.android.httpdns.p112b;

import android.content.Context;
import com.alibaba.sdk.android.httpdns.p113c.C1512a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.alibaba.sdk.android.httpdns.b.b */
/* loaded from: classes.dex */
public class C1505b {

    /* renamed from: a */
    private static InterfaceC1509f f3850a = null;

    /* renamed from: a */
    private static C1512a f3851a = null;

    /* renamed from: a */
    private static boolean f3852a = false;

    /* renamed from: n */
    private static boolean f3853n = true;

    /* renamed from: a */
    public static List<C1508e> m3433a() {
        ArrayList arrayList = new ArrayList();
        if (!f3852a) {
            return arrayList;
        }
        arrayList.addAll(f3850a.mo3430a());
        return arrayList;
    }

    /* renamed from: a */
    public static void m3434a(Context context) {
        m3435a(context, (C1512a) null);
    }

    /* renamed from: a */
    public static void m3435a(Context context, C1512a c1512a) {
        f3850a = new C1504a(context);
        f3851a = c1512a;
        if (f3851a == null) {
            f3851a = C1512a.m3464a();
        }
    }

    /* renamed from: a */
    public static void m3436a(C1508e c1508e) {
        if (c1508e == null) {
            return;
        }
        f3850a.mo3431a(c1508e);
    }

    /* renamed from: a */
    public static void m3437a(boolean z, boolean z2) {
        f3852a = z;
        f3853n = z2;
    }

    /* renamed from: a */
    public static boolean m3438a() {
        return f3852a;
    }

    /* renamed from: b */
    public static void m3439b(Context context) {
        if (context != null) {
            f3851a.m3466c(context);
        }
    }

    /* renamed from: b */
    public static void m3440b(C1508e c1508e) {
        if (c1508e == null) {
            return;
        }
        f3850a.mo3432b(c1508e);
    }

    /* renamed from: g */
    public static boolean m3441g() {
        return f3853n;
    }

    /* renamed from: i */
    public static String m3442i() {
        return f3851a.m3468i();
    }
}
