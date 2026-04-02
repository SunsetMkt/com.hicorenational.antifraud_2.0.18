package com.umeng.ut.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.ut.a.b.g;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final a a = new a();

    /* JADX INFO: renamed from: c */
    private static long f8432c = 3000;

    /* JADX INFO: renamed from: c */
    private String f63c = "";

    private a() {
    }

    public static a a() {
        return a;
    }

    public static long b() {
        return f8432c;
    }

    private void d() {
        com.umeng.ut.a.c.e.c();
        if (TextUtils.isEmpty(this.f63c)) {
            return;
        }
        try {
            Context contextM39a = com.umeng.ut.a.a.a().m39a();
            if (com.umeng.ut.a.c.a.a(contextM39a)) {
                new Thread(new g(contextM39a)).start();
            }
        } catch (Throwable th) {
            com.umeng.ut.a.c.e.m42a("", th);
        }
    }

    synchronized String getUtdid(Context context) {
        if (!TextUtils.isEmpty(this.f63c)) {
            return this.f63c;
        }
        try {
            String value = d.a(context).getValue();
            if (TextUtils.isEmpty(value)) {
                return "ffffffffffffffffffffffff";
            }
            this.f63c = value;
            d();
            return this.f63c;
        } catch (Throwable th) {
            com.umeng.ut.a.c.e.a("AppUtdid", th, new Object[0]);
            return "ffffffffffffffffffffffff";
        }
    }

    public synchronized String i() {
        return this.f63c;
    }
}
