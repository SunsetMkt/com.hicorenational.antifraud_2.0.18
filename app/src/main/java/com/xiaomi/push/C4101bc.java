package com.xiaomi.push;

import java.util.concurrent.Callable;

/* renamed from: com.xiaomi.push.bc */
/* loaded from: classes2.dex */
public class C4101bc<T> {

    /* renamed from: a */
    private final long f14604a;

    /* renamed from: b */
    private long f14605b;

    /* renamed from: c */
    private long f14606c;

    /* renamed from: d */
    private long f14607d;

    /* renamed from: e */
    private long f14608e;

    /* renamed from: f */
    private long f14609f;

    /* renamed from: g */
    private long f14610g;

    /* renamed from: h */
    private long f14611h;

    /* renamed from: i */
    private final long f14612i;

    public C4101bc(long j2, long j3) {
        this.f14612i = j2 * 1000000;
        this.f14604a = j3;
    }

    /* renamed from: a */
    public long m13890a() {
        return this.f14606c;
    }

    /* renamed from: b */
    public long m13892b() {
        return this.f14607d;
    }

    /* renamed from: c */
    public long m13893c() {
        long j2 = this.f14609f;
        if (j2 > 0) {
            long j3 = this.f14608e;
            if (j3 > 0) {
                return j2 / j3;
            }
        }
        return 0L;
    }

    /* renamed from: d */
    public long m13894d() {
        long j2 = this.f14611h;
        long j3 = this.f14610g;
        if (j2 > j3) {
            return j2 - j3;
        }
        return 0L;
    }

    /* renamed from: a */
    public T m13891a(Callable<T> callable) {
        long j2 = this.f14605b;
        long j3 = this.f14612i;
        if (j2 > j3) {
            long j4 = (j2 / j3) * this.f14604a;
            this.f14605b = 0L;
            if (j4 > 0) {
                try {
                    Thread.sleep(j4);
                } catch (Exception unused) {
                }
            }
        }
        long nanoTime = System.nanoTime();
        if (this.f14610g <= 0) {
            this.f14610g = nanoTime;
        }
        T t = null;
        try {
            t = callable.call();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        this.f14611h = System.nanoTime();
        this.f14608e++;
        if (this.f14606c < nanoTime2) {
            this.f14606c = nanoTime2;
        }
        if (nanoTime2 > 0) {
            this.f14609f += nanoTime2;
            long j5 = this.f14607d;
            if (j5 == 0 || j5 > nanoTime2) {
                this.f14607d = nanoTime2;
            }
        }
        this.f14605b += Math.max(nanoTime2, 0L);
        return t;
    }
}
