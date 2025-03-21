package com.umeng.ut.a.b;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f11901a = false;

    /* renamed from: a, reason: collision with other field name */
    private Context f59a;

    public g(Context context) {
        this.f59a = context;
    }

    private void a() {
        com.umeng.ut.a.c.e.c();
        if (com.umeng.ut.a.c.c.b(this.f59a) && !f11901a) {
            f11901a = true;
            if (com.umeng.ut.b.b.d.a(this.f59a).b()) {
                try {
                    m43b();
                } catch (Throwable unused) {
                }
                f11901a = false;
            }
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    private void m43b() {
        com.umeng.ut.a.c.e.c();
        String b2 = b();
        if (TextUtils.isEmpty(b2)) {
            com.umeng.ut.a.c.e.m44a("postData is empty", new Object[0]);
        } else if (a(b2)) {
            com.umeng.ut.a.c.e.m44a("", "upload success");
        } else {
            com.umeng.ut.a.c.e.m44a("", "upload fail");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                Thread.sleep(com.umeng.ut.b.b.a.b());
            } catch (Throwable th) {
                com.umeng.ut.a.c.e.a("", th, new Object[0]);
                return;
            }
        } catch (Exception unused) {
        }
        a();
    }

    private boolean a(String str) {
        a a2 = b.a("https://audid.umeng.com/v3/a/audid/req", str, true);
        if (a2 == null) {
            return false;
        }
        return com.umeng.ut.b.b.e.a(a2);
    }

    private String b() {
        String i2 = com.umeng.ut.b.b.a.a().i();
        if (TextUtils.isEmpty(i2)) {
            return null;
        }
        String a2 = com.umeng.ut.a.a.a.a(i2);
        if (com.umeng.ut.a.c.e.m45a()) {
            com.umeng.ut.a.c.e.b("", a2);
        }
        return com.umeng.ut.a.a.b.b(a2);
    }
}
