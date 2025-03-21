package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* compiled from: CollectController.java */
/* renamed from: com.umeng.commonsdk.config.b */
/* loaded from: classes2.dex */
public class C3456b implements InterfaceC3460f {

    /* renamed from: a */
    private static Map<String, Boolean> f12424a = new HashMap();

    /* renamed from: b */
    private static Object f12425b = new Object();

    /* compiled from: CollectController.java */
    /* renamed from: com.umeng.commonsdk.config.b$a */
    private static class a {

        /* renamed from: a */
        private static final C3456b f12426a = new C3456b();

        private a() {
        }
    }

    /* renamed from: b */
    public static C3456b m11541b() {
        return a.f12426a;
    }

    /* renamed from: a */
    public void m11542a() {
        synchronized (f12425b) {
            f12424a.clear();
        }
    }

    private C3456b() {
    }

    /* renamed from: a */
    public static boolean m11540a(String str) {
        if (!C3458d.m11546a(str)) {
            return false;
        }
        synchronized (f12425b) {
            if (!f12424a.containsKey(str)) {
                return true;
            }
            return f12424a.get(str).booleanValue();
        }
    }

    @Override // com.umeng.commonsdk.config.InterfaceC3460f
    /* renamed from: a */
    public void mo11543a(String str, Boolean bool) {
        if (C3458d.m11546a(str)) {
            synchronized (f12425b) {
                if (f12424a != null) {
                    f12424a.put(str, bool);
                }
            }
        }
    }
}
