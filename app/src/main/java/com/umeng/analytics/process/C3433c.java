package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMProcessDBManager.java */
/* renamed from: com.umeng.analytics.process.c */
/* loaded from: classes2.dex */
class C3433c {

    /* renamed from: a */
    private static C3433c f12319a;

    /* renamed from: b */
    private ConcurrentHashMap<String, a> f12320b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private Context f12321c;

    private C3433c() {
    }

    /* renamed from: a */
    static C3433c m11448a(Context context) {
        if (f12319a == null) {
            synchronized (C3433c.class) {
                if (f12319a == null) {
                    f12319a = new C3433c();
                }
            }
        }
        C3433c c3433c = f12319a;
        c3433c.f12321c = context;
        return c3433c;
    }

    /* renamed from: c */
    private a m11449c(String str) {
        if (this.f12320b.get(str) != null) {
            return this.f12320b.get(str);
        }
        a m11452a = a.m11452a(this.f12321c, str);
        this.f12320b.put(str, m11452a);
        return m11452a;
    }

    /* renamed from: b */
    synchronized void m11451b(String str) {
        m11449c(str).m11454b();
    }

    /* compiled from: UMProcessDBManager.java */
    /* renamed from: com.umeng.analytics.process.c$a */
    static class a {

        /* renamed from: a */
        private AtomicInteger f12322a = new AtomicInteger();

        /* renamed from: b */
        private SQLiteOpenHelper f12323b;

        /* renamed from: c */
        private SQLiteDatabase f12324c;

        private a() {
        }

        /* renamed from: a */
        static a m11452a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.f12323b = C3432b.m11444a(appContext, str);
            return aVar;
        }

        /* renamed from: b */
        synchronized void m11454b() {
            try {
                if (this.f12322a.decrementAndGet() == 0) {
                    this.f12324c.close();
                }
            } catch (Throwable unused) {
            }
        }

        /* renamed from: a */
        synchronized SQLiteDatabase m11453a() {
            if (this.f12322a.incrementAndGet() == 1) {
                this.f12324c = this.f12323b.getWritableDatabase();
            }
            return this.f12324c;
        }
    }

    /* renamed from: a */
    synchronized SQLiteDatabase m11450a(String str) {
        return m11449c(str).m11453a();
    }
}
