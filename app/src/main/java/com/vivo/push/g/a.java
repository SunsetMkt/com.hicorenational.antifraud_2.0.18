package com.vivo.push.g;

import java.util.ArrayList;

/* JADX INFO: compiled from: TestManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static String[] a = {"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<String> f8537b;

    /* JADX INFO: renamed from: com.vivo.push.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TestManager.java */
    private static class C0149a {
        private static a a = new a(0);
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0149a.a;
    }

    public final boolean b() {
        ArrayList<String> arrayList = this.f8537b;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    private a() {
        this.f8537b = null;
        this.f8537b = new ArrayList<>();
    }
}
