package com.umeng.ccg;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: CcgSwitch.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static volatile boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f7451b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f7452c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f7453d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Object f7454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<String, Boolean> f7455f;

    static {
        if (f7455f == null) {
            f7455f = new HashMap();
            f7454e = new Object();
        }
    }

    public static boolean a() {
        boolean z;
        synchronized (f7454e) {
            z = a;
        }
        return z;
    }

    public static boolean b() {
        boolean z;
        synchronized (f7454e) {
            z = f7451b;
        }
        return z;
    }

    public static boolean c() {
        boolean z;
        synchronized (f7454e) {
            z = f7452c;
        }
        return z;
    }

    public static boolean d() {
        boolean z;
        synchronized (f7454e) {
            z = f7453d;
        }
        return z;
    }

    public static void a(boolean z) {
        synchronized (f7454e) {
            f7453d = z;
            f7455f.put(a.f7441e, Boolean.valueOf(z));
        }
    }

    public static boolean a(String str) {
        boolean zBooleanValue;
        synchronized (f7454e) {
            zBooleanValue = f7455f.containsKey(str) ? f7455f.get(str).booleanValue() : true;
        }
        return zBooleanValue;
    }
}
