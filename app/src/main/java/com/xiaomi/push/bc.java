package com.xiaomi.push;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class bc<T> {
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f8768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f8771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f8772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f8773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f8774i;

    public bc(long j2, long j3) {
        this.f8774i = j2 * 1000000;
        this.a = j3;
    }

    public long a() {
        return this.f8768c;
    }

    public long b() {
        return this.f8769d;
    }

    public long c() {
        long j2 = this.f8771f;
        if (j2 > 0) {
            long j3 = this.f8770e;
            if (j3 > 0) {
                return j2 / j3;
            }
        }
        return 0L;
    }

    public long d() {
        long j2 = this.f8773h;
        long j3 = this.f8772g;
        if (j2 > j3) {
            return j2 - j3;
        }
        return 0L;
    }

    public T a(Callable<T> callable) {
        long j2 = this.f8767b;
        long j3 = this.f8774i;
        if (j2 > j3) {
            long j4 = (j2 / j3) * this.a;
            this.f8767b = 0L;
            if (j4 > 0) {
                try {
                    Thread.sleep(j4);
                } catch (Exception unused) {
                }
            }
        }
        long jNanoTime = System.nanoTime();
        if (this.f8772g <= 0) {
            this.f8772g = jNanoTime;
        }
        T tCall = null;
        try {
            tCall = callable.call();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        long jNanoTime2 = System.nanoTime() - jNanoTime;
        this.f8773h = System.nanoTime();
        this.f8770e++;
        if (this.f8768c < jNanoTime2) {
            this.f8768c = jNanoTime2;
        }
        if (jNanoTime2 > 0) {
            this.f8771f += jNanoTime2;
            long j5 = this.f8769d;
            if (j5 == 0 || j5 > jNanoTime2) {
                this.f8769d = jNanoTime2;
            }
        }
        this.f8767b += Math.max(jNanoTime2, 0L);
        return tCall;
    }
}
