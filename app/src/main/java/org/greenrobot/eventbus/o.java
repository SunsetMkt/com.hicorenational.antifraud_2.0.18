package org.greenrobot.eventbus;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: SubscriberMethod.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {
    final Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ThreadMode f12937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Class<?> f12938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f12939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f12940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f12941f;

    public o(Method method, Class<?> cls, ThreadMode threadMode, int i2, boolean z) {
        this.a = method;
        this.f12937b = threadMode;
        this.f12938c = cls;
        this.f12939d = i2;
        this.f12940e = z;
    }

    private synchronized void a() {
        if (this.f12941f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.a.getName());
            sb.append('(');
            sb.append(this.f12938c.getName());
            this.f12941f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        a();
        o oVar = (o) obj;
        oVar.a();
        return this.f12941f.equals(oVar.f12941f);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
