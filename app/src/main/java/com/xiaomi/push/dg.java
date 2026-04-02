package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class dg {
    private static volatile dg a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private df f326a;

    public static dg a() {
        if (a == null) {
            synchronized (dg.class) {
                if (a == null) {
                    a = new dg();
                }
            }
        }
        return a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public df m267a() {
        return this.f326a;
    }

    public void a(df dfVar) {
        this.f326a = dfVar;
    }
}
