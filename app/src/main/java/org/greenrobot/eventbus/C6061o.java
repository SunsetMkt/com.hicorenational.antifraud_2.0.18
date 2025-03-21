package org.greenrobot.eventbus;

import java.lang.reflect.Method;

/* compiled from: SubscriberMethod.java */
/* renamed from: org.greenrobot.eventbus.o */
/* loaded from: classes2.dex */
public class C6061o {

    /* renamed from: a */
    final Method f21590a;

    /* renamed from: b */
    final ThreadMode f21591b;

    /* renamed from: c */
    final Class<?> f21592c;

    /* renamed from: d */
    final int f21593d;

    /* renamed from: e */
    final boolean f21594e;

    /* renamed from: f */
    String f21595f;

    public C6061o(Method method, Class<?> cls, ThreadMode threadMode, int i2, boolean z) {
        this.f21590a = method;
        this.f21591b = threadMode;
        this.f21592c = cls;
        this.f21593d = i2;
        this.f21594e = z;
    }

    /* renamed from: a */
    private synchronized void m25033a() {
        if (this.f21595f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f21590a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f21590a.getName());
            sb.append('(');
            sb.append(this.f21592c.getName());
            this.f21595f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C6061o)) {
            return false;
        }
        m25033a();
        C6061o c6061o = (C6061o) obj;
        c6061o.m25033a();
        return this.f21595f.equals(c6061o.f21595f);
    }

    public int hashCode() {
        return this.f21590a.hashCode();
    }
}
