package com.umeng.ut.a;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final a a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f57a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f56a = 0;

    private a() {
    }

    public static a a() {
        return a;
    }

    public synchronized void a(Context context) {
        if (this.f57a == null) {
            if (context == null) {
                return;
            }
            if (context.getApplicationContext() != null) {
                this.f57a = context.getApplicationContext();
            } else {
                this.f57a = context;
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Context m39a() {
        return this.f57a;
    }

    public void a(long j2) {
        this.f56a = j2 - System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m38a() {
        return System.currentTimeMillis() + this.f56a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m40a() {
        return "" + m38a();
    }
}
