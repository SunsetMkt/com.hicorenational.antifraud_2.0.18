package com.umeng.ccg;

import java.util.HashMap;
import java.util.Map;

/* compiled from: CcgSwitch.java */
/* renamed from: com.umeng.ccg.b */
/* loaded from: classes2.dex */
public class C3439b {

    /* renamed from: a */
    private static volatile boolean f12348a = true;

    /* renamed from: b */
    private static volatile boolean f12349b = true;

    /* renamed from: c */
    private static volatile boolean f12350c = true;

    /* renamed from: d */
    private static volatile boolean f12351d = true;

    /* renamed from: e */
    private static Object f12352e;

    /* renamed from: f */
    private static Map<String, Boolean> f12353f;

    static {
        if (f12353f == null) {
            f12353f = new HashMap();
            f12352e = new Object();
        }
    }

    /* renamed from: a */
    public static boolean m11458a() {
        boolean z;
        synchronized (f12352e) {
            z = f12348a;
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m11460b() {
        boolean z;
        synchronized (f12352e) {
            z = f12349b;
        }
        return z;
    }

    /* renamed from: c */
    public static boolean m11461c() {
        boolean z;
        synchronized (f12352e) {
            z = f12350c;
        }
        return z;
    }

    /* renamed from: d */
    public static boolean m11462d() {
        boolean z;
        synchronized (f12352e) {
            z = f12351d;
        }
        return z;
    }

    /* renamed from: a */
    public static void m11457a(boolean z) {
        synchronized (f12352e) {
            f12351d = z;
            f12353f.put(C3438a.f12332e, Boolean.valueOf(z));
        }
    }

    /* renamed from: a */
    public static boolean m11459a(String str) {
        boolean booleanValue;
        synchronized (f12352e) {
            booleanValue = f12353f.containsKey(str) ? f12353f.get(str).booleanValue() : true;
        }
        return booleanValue;
    }
}
