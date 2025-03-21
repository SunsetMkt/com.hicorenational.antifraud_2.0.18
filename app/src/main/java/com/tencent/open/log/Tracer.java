package com.tencent.open.log;

import com.tencent.open.log.C3277d;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public abstract class Tracer {

    /* renamed from: a */
    private volatile int f11231a;

    /* renamed from: b */
    private volatile boolean f11232b;

    /* renamed from: c */
    private C3280g f11233c;

    public Tracer() {
        this(C3276c.f11255a, true, C3280g.f11276a);
    }

    /* renamed from: a */
    public void m10514a(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        if (m10517d() && C3277d.a.m10549a(this.f11231a, i2)) {
            doTrace(i2, thread, j2, str, str2, th);
        }
    }

    /* renamed from: d */
    public boolean m10517d() {
        return this.f11232b;
    }

    protected abstract void doTrace(int i2, Thread thread, long j2, String str, String str2, Throwable th);

    /* renamed from: e */
    public C3280g m10518e() {
        return this.f11233c;
    }

    public Tracer(int i2, boolean z, C3280g c3280g) {
        this.f11231a = C3276c.f11255a;
        this.f11232b = true;
        this.f11233c = C3280g.f11276a;
        m10513a(i2);
        m10516a(z);
        m10515a(c3280g);
    }

    /* renamed from: a */
    public void m10513a(int i2) {
        this.f11231a = i2;
    }

    /* renamed from: a */
    public void m10516a(boolean z) {
        this.f11232b = z;
    }

    /* renamed from: a */
    public void m10515a(C3280g c3280g) {
        this.f11233c = c3280g;
    }
}
