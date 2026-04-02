package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMProcessDBManager.java */
/* JADX INFO: loaded from: classes2.dex */
class c {
    private static c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f7433b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f7434c;

    private c() {
    }

    static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        c cVar = a;
        cVar.f7434c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.f7433b.get(str) != null) {
            return this.f7433b.get(str);
        }
        a aVarA = a.a(this.f7434c, str);
        this.f7433b.put(str, aVarA);
        return aVarA;
    }

    synchronized void b(String str) {
        c(str).b();
    }

    /* JADX INFO: compiled from: UMProcessDBManager.java */
    static class a {
        private AtomicInteger a = new AtomicInteger();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SQLiteOpenHelper f7435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private SQLiteDatabase f7436c;

        private a() {
        }

        static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.f7435b = b.a(appContext, str);
            return aVar;
        }

        synchronized void b() {
            try {
                if (this.a.decrementAndGet() == 0) {
                    this.f7436c.close();
                }
            } catch (Throwable unused) {
            }
        }

        synchronized SQLiteDatabase a() {
            if (this.a.incrementAndGet() == 1) {
                this.f7436c = this.f7435b.getWritableDatabase();
            }
            return this.f7436c;
        }
    }

    synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
