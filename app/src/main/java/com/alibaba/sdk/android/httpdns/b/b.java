package com.alibaba.sdk.android.httpdns.b;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static f a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static com.alibaba.sdk.android.httpdns.c.a f5a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f6a = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static boolean f2546n = true;

    public static List<e> a() {
        ArrayList arrayList = new ArrayList();
        if (!f6a) {
            return arrayList;
        }
        arrayList.addAll(a.a());
        return arrayList;
    }

    public static void a(Context context) {
        a(context, (com.alibaba.sdk.android.httpdns.c.a) null);
    }

    public static void a(Context context, com.alibaba.sdk.android.httpdns.c.a aVar) {
        a = new a(context);
        f5a = aVar;
        if (f5a == null) {
            f5a = com.alibaba.sdk.android.httpdns.c.a.a();
        }
    }

    public static void a(e eVar) {
        if (eVar == null) {
            return;
        }
        a.a(eVar);
    }

    public static void a(boolean z, boolean z2) {
        f6a = z;
        f2546n = z2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m7a() {
        return f6a;
    }

    public static void b(Context context) {
        if (context != null) {
            f5a.c(context);
        }
    }

    public static void b(e eVar) {
        if (eVar == null) {
            return;
        }
        a.b(eVar);
    }

    public static boolean g() {
        return f2546n;
    }

    public static String i() {
        return f5a.i();
    }
}
