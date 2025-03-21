package com.vivo.push.p238g;

import java.util.ArrayList;

/* compiled from: TestManager.java */
/* renamed from: com.vivo.push.g.a */
/* loaded from: classes2.dex */
public final class C3918a {

    /* renamed from: a */
    private static String[] f14054a = {"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test"};

    /* renamed from: b */
    private ArrayList<String> f14055b;

    /* compiled from: TestManager.java */
    /* renamed from: com.vivo.push.g.a$a */
    private static class a {

        /* renamed from: a */
        private static C3918a f14056a = new C3918a(0);
    }

    /* synthetic */ C3918a(byte b2) {
        this();
    }

    /* renamed from: a */
    public static C3918a m12991a() {
        return a.f14056a;
    }

    /* renamed from: b */
    public final boolean m12992b() {
        ArrayList<String> arrayList = this.f14055b;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    private C3918a() {
        this.f14055b = null;
        this.f14055b = new ArrayList<>();
    }
}
