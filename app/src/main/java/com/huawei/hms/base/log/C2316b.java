package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* compiled from: LogAdaptor.java */
/* renamed from: com.huawei.hms.base.log.b */
/* loaded from: classes.dex */
public class C2316b {

    /* renamed from: b */
    private String f7177b;

    /* renamed from: a */
    private int f7176a = 4;

    /* renamed from: c */
    private InterfaceC2318d f7178c = new C2317c();

    /* renamed from: b */
    private void m6665b() {
    }

    /* renamed from: a */
    public void m6668a(Context context, int i2, String str) {
        this.f7176a = i2;
        this.f7177b = str;
        this.f7178c.mo6661a(context, "HMSCore");
    }

    /* renamed from: b */
    public void m6672b(int i2, String str, String str2, Throwable th) {
        try {
            if (m6671a(i2)) {
                C2319e m6664a = m6664a(i2, str, str2, th);
                String str3 = m6664a.m6680c() + m6664a.m6679a();
                this.f7178c.mo6663a(str3, i2, str, str2 + '\n' + Log.getStackTraceString(th));
            }
        } catch (OutOfMemoryError unused) {
            m6665b();
        }
    }

    /* renamed from: a */
    public InterfaceC2318d m6666a() {
        return this.f7178c;
    }

    /* renamed from: a */
    public void m6669a(InterfaceC2318d interfaceC2318d) {
        this.f7178c = interfaceC2318d;
    }

    /* renamed from: a */
    public boolean m6671a(int i2) {
        return i2 >= this.f7176a;
    }

    /* renamed from: a */
    public void m6667a(int i2, String str, String str2) {
        try {
            if (m6671a(i2)) {
                C2319e m6664a = m6664a(i2, str, str2, null);
                this.f7178c.mo6663a(m6664a.m6680c() + m6664a.m6679a(), i2, str, str2);
            }
        } catch (OutOfMemoryError unused) {
            m6665b();
        }
    }

    /* renamed from: a */
    public void m6670a(String str, String str2) {
        try {
            C2319e m6664a = m6664a(4, str, str2, null);
            this.f7178c.mo6663a(m6664a.m6680c() + '\n' + m6664a.m6679a(), 4, str, str2);
        } catch (OutOfMemoryError unused) {
            m6665b();
        }
    }

    /* renamed from: a */
    private C2319e m6664a(int i2, String str, String str2, Throwable th) {
        C2319e c2319e = new C2319e(8, this.f7177b, i2, str);
        c2319e.m6677a((C2319e) str2);
        c2319e.m6678a(th);
        return c2319e;
    }
}
