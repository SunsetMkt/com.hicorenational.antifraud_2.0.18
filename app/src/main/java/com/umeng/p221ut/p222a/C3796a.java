package com.umeng.p221ut.p222a;

import android.content.Context;

/* renamed from: com.umeng.ut.a.a */
/* loaded from: classes2.dex */
public class C3796a {

    /* renamed from: a */
    private static final C3796a f13855a = new C3796a();

    /* renamed from: a */
    private Context f13857a = null;

    /* renamed from: a */
    private long f13856a = 0;

    private C3796a() {
    }

    /* renamed from: a */
    public static C3796a m12755a() {
        return f13855a;
    }

    /* renamed from: a */
    public synchronized void m12760a(Context context) {
        if (this.f13857a == null) {
            if (context == null) {
                return;
            }
            if (context.getApplicationContext() != null) {
                this.f13857a = context.getApplicationContext();
            } else {
                this.f13857a = context;
            }
        }
    }

    /* renamed from: a */
    public Context m12757a() {
        return this.f13857a;
    }

    /* renamed from: a */
    public void m12759a(long j2) {
        this.f13856a = j2 - System.currentTimeMillis();
    }

    /* renamed from: a */
    public long m12756a() {
        return System.currentTimeMillis() + this.f13856a;
    }

    /* renamed from: a */
    public String m12758a() {
        return "" + m12756a();
    }
}
