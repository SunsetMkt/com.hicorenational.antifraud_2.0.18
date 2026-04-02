package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class bd {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f8776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f8778e = System.currentTimeMillis();

    public int a() {
        return com.xiaomi.push.service.ag.a() ? 1 : 0;
    }

    public long b() {
        return this.f8775b;
    }

    public long c() {
        return this.f8776c;
    }

    public long d() {
        return this.f8777d;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m177a() {
        return this.a;
    }

    public void b(long j2) {
        this.f8775b += j2;
    }

    public void c(long j2) {
        this.f8777d += j2;
    }

    public void a(long j2) {
        this.a = j2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m178a() {
        this.f8776c++;
    }
}
