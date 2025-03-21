package com.umeng.commonsdk.internal;

import android.content.Context;

/* compiled from: UMInternalData.java */
/* renamed from: com.umeng.commonsdk.internal.b */
/* loaded from: classes2.dex */
public class C3471b {

    /* renamed from: b */
    private static C3471b f12613b;

    /* renamed from: a */
    private Context f12614a;

    /* renamed from: c */
    private C3472c f12615c;

    private C3471b(Context context) {
        this.f12614a = context;
        this.f12615c = new C3472c(context);
    }

    /* renamed from: a */
    public static synchronized C3471b m11589a(Context context) {
        C3471b c3471b;
        synchronized (C3471b.class) {
            if (f12613b == null) {
                f12613b = new C3471b(context.getApplicationContext());
            }
            c3471b = f12613b;
        }
        return c3471b;
    }

    /* renamed from: a */
    public C3472c m11590a() {
        return this.f12615c;
    }
}
