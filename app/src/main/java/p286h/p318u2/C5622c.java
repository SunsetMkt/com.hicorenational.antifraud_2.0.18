package p286h.p318u2;

import java.util.Random;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: PlatformRandom.kt */
/* renamed from: h.u2.c */
/* loaded from: classes2.dex */
final class C5622c extends Random {

    @InterfaceC5816d
    private final AbstractC5625f impl;
    private boolean seedInitialized;

    public C5622c(@InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(abstractC5625f, "impl");
        this.impl = abstractC5625f;
    }

    @InterfaceC5816d
    public final AbstractC5625f getImpl() {
        return this.impl;
    }

    @Override // java.util.Random
    protected int next(int i2) {
        return this.impl.mo22943a(i2);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.impl.mo22944a();
    }

    @Override // java.util.Random
    public void nextBytes(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "bytes");
        this.impl.mo22945a(bArr);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.impl.mo22946b();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.impl.mo22947c();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.impl.mo22949d();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.impl.mo22950e();
    }

    @Override // java.util.Random
    public void setSeed(long j2) {
        if (this.seedInitialized) {
            throw new UnsupportedOperationException("Setting seed is not supported.");
        }
        this.seedInitialized = true;
    }

    @Override // java.util.Random
    public int nextInt(int i2) {
        return this.impl.mo22948c(i2);
    }
}
