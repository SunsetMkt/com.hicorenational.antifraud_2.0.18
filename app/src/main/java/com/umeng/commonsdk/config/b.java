package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: CollectController.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements f {
    private static Map<String, Boolean> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f7501b = new Object();

    /* JADX INFO: compiled from: CollectController.java */
    private static class a {
        private static final b a = new b();

        private a() {
        }
    }

    public static b b() {
        return a.a;
    }

    public void a() {
        synchronized (f7501b) {
            a.clear();
        }
    }

    private b() {
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (f7501b) {
            if (!a.containsKey(str)) {
                return true;
            }
            return a.get(str).booleanValue();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (f7501b) {
                if (a != null) {
                    a.put(str, bool);
                }
            }
        }
    }
}
