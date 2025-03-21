package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMDBManager.java */
/* renamed from: com.umeng.analytics.pro.g */
/* loaded from: classes2.dex */
class C3406g {

    /* renamed from: b */
    private static SQLiteOpenHelper f12043b;

    /* renamed from: d */
    private static Context f12044d;

    /* renamed from: a */
    private AtomicInteger f12045a;

    /* renamed from: c */
    private SQLiteDatabase f12046c;

    /* compiled from: UMDBManager.java */
    /* renamed from: com.umeng.analytics.pro.g$a */
    private static class a {

        /* renamed from: a */
        private static final C3406g f12047a = new C3406g();

        private a() {
        }
    }

    /* renamed from: a */
    public static C3406g m11218a(Context context) {
        if (f12044d == null && context != null) {
            f12044d = context.getApplicationContext();
            f12043b = C3405f.m11207a(f12044d);
        }
        return a.f12047a;
    }

    /* renamed from: b */
    public synchronized void m11220b() {
        try {
            if (this.f12045a.decrementAndGet() == 0) {
                this.f12046c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private C3406g() {
        this.f12045a = new AtomicInteger();
    }

    /* renamed from: a */
    public synchronized SQLiteDatabase m11219a() {
        if (this.f12045a.incrementAndGet() == 1) {
            this.f12046c = f12043b.getWritableDatabase();
        }
        return this.f12046c;
    }
}
