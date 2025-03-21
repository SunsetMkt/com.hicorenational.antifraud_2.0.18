package com.tencent.open.utils;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.n */
/* loaded from: classes2.dex */
public final class C3296n implements Cloneable {

    /* renamed from: a */
    private long f11333a;

    public C3296n(long j2) {
        this.f11333a = j2;
    }

    /* renamed from: a */
    public byte[] m10715a() {
        long j2 = this.f11333a;
        return new byte[]{(byte) (255 & j2), (byte) ((65280 & j2) >> 8), (byte) ((16711680 & j2) >> 16), (byte) ((j2 & 4278190080L) >> 24)};
    }

    /* renamed from: b */
    public long m10716b() {
        return this.f11333a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof C3296n) && this.f11333a == ((C3296n) obj).m10716b();
    }

    public int hashCode() {
        return (int) this.f11333a;
    }
}
