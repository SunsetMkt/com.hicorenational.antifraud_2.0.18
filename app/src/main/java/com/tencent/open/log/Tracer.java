package com.tencent.open.log;

import com.tencent.open.log.d;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Tracer {
    private volatile int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f6861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f6862c;

    public Tracer() {
        this(c.a, true, g.a);
    }

    public void a(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.a, i2)) {
            doTrace(i2, thread, j2, str, str2, th);
        }
    }

    public boolean d() {
        return this.f6861b;
    }

    protected abstract void doTrace(int i2, Thread thread, long j2, String str, String str2, Throwable th);

    public g e() {
        return this.f6862c;
    }

    public Tracer(int i2, boolean z, g gVar) {
        this.a = c.a;
        this.f6861b = true;
        this.f6862c = g.a;
        a(i2);
        a(z);
        a(gVar);
    }

    public void a(int i2) {
        this.a = i2;
    }

    public void a(boolean z) {
        this.f6861b = z;
    }

    public void a(g gVar) {
        this.f6862c = gVar;
    }
}
