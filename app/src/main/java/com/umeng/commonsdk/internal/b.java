package com.umeng.commonsdk.internal;

import android.content.Context;

/* JADX INFO: compiled from: UMInternalData.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: b */
    private static b f7590b;
    private Context a;

    /* JADX INFO: renamed from: c */
    private c f7591c;

    private b(Context context) {
        this.a = context;
        this.f7591c = new c(context);
    }

    public static synchronized b a(Context context) {
        if (f7590b == null) {
            f7590b = new b(context.getApplicationContext());
        }
        return f7590b;
    }

    public c a() {
        return this.f7591c;
    }
}
