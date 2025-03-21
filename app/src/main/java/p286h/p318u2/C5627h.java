package p286h.p318u2;

import p286h.C5215b2;
import p286h.C5239g1;
import p286h.C5341j1;
import p286h.C5441n1;
import p286h.InterfaceC5352k;
import p286h.InterfaceC5610t0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p319v2.C5651t;
import p286h.p319v2.C5654w;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: URandom.kt */
/* renamed from: h.u2.h */
/* loaded from: classes2.dex */
public final class C5627h {
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final int m22976a(@InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(abstractC5625f, "$this$nextUInt");
        return C5341j1.m21929c(abstractC5625f.mo22949d());
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    public static final int m22988b(@InterfaceC5816d AbstractC5625f abstractC5625f, int i2) {
        C5544i0.m22546f(abstractC5625f, "$this$nextUInt");
        return m22977a(abstractC5625f, 0, i2);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final int m22977a(@InterfaceC5816d AbstractC5625f abstractC5625f, int i2, int i3) {
        C5544i0.m22546f(abstractC5625f, "$this$nextUInt");
        m22982a(i2, i3);
        return C5341j1.m21929c(abstractC5625f.mo22960a(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    public static final long m22989b(@InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(abstractC5625f, "$this$nextULong");
        return C5441n1.m22205c(abstractC5625f.mo22950e());
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final int m22978a(@InterfaceC5816d AbstractC5625f abstractC5625f, @InterfaceC5816d C5651t c5651t) {
        C5544i0.m22546f(abstractC5625f, "$this$nextUInt");
        C5544i0.m22546f(c5651t, "range");
        if (!c5651t.isEmpty()) {
            return C5215b2.m18812a(c5651t.getLast(), -1) < 0 ? m22977a(abstractC5625f, c5651t.getFirst(), C5341j1.m21929c(c5651t.getLast() + 1)) : C5215b2.m18812a(c5651t.getFirst(), 0) > 0 ? C5341j1.m21929c(m22977a(abstractC5625f, C5341j1.m21929c(c5651t.getFirst() - 1), c5651t.getLast()) + 1) : m22976a(abstractC5625f);
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + c5651t);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final long m22979a(@InterfaceC5816d AbstractC5625f abstractC5625f, long j2) {
        C5544i0.m22546f(abstractC5625f, "$this$nextULong");
        return m22980a(abstractC5625f, 0L, j2);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final long m22980a(@InterfaceC5816d AbstractC5625f abstractC5625f, long j2, long j3) {
        C5544i0.m22546f(abstractC5625f, "$this$nextULong");
        m22983a(j2, j3);
        return C5441n1.m22205c(abstractC5625f.mo22962a(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final long m22981a(@InterfaceC5816d AbstractC5625f abstractC5625f, @InterfaceC5816d C5654w c5654w) {
        C5544i0.m22546f(abstractC5625f, "$this$nextULong");
        C5544i0.m22546f(c5654w, "range");
        if (!c5654w.isEmpty()) {
            if (C5215b2.m18813a(c5654w.getLast(), -1L) < 0) {
                return m22980a(abstractC5625f, c5654w.getFirst(), C5441n1.m22205c(c5654w.getLast() + C5441n1.m22205c(1 & 4294967295L)));
            }
            if (C5215b2.m18813a(c5654w.getFirst(), 0L) <= 0) {
                return m22989b(abstractC5625f);
            }
            long j2 = 1 & 4294967295L;
            return C5441n1.m22205c(m22980a(abstractC5625f, C5441n1.m22205c(c5654w.getFirst() - C5441n1.m22205c(j2)), c5654w.getLast()) + C5441n1.m22205c(j2));
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + c5654w);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final byte[] m22985a(@InterfaceC5816d AbstractC5625f abstractC5625f, @InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(abstractC5625f, "$this$nextUBytes");
        C5544i0.m22546f(bArr, "array");
        abstractC5625f.mo22945a(bArr);
        return bArr;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final byte[] m22984a(@InterfaceC5816d AbstractC5625f abstractC5625f, int i2) {
        C5544i0.m22546f(abstractC5625f, "$this$nextUBytes");
        return C5239g1.m18981b(abstractC5625f.mo22964b(i2));
    }

    /* renamed from: a */
    public static /* synthetic */ byte[] m22987a(AbstractC5625f abstractC5625f, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = C5239g1.m18982c(bArr);
        }
        return m22986a(abstractC5625f, bArr, i2, i3);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final byte[] m22986a(@InterfaceC5816d AbstractC5625f abstractC5625f, @InterfaceC5816d byte[] bArr, int i2, int i3) {
        C5544i0.m22546f(abstractC5625f, "$this$nextUBytes");
        C5544i0.m22546f(bArr, "array");
        abstractC5625f.mo22963a(bArr, i2, i3);
        return bArr;
    }

    @InterfaceC5352k
    /* renamed from: a */
    public static final void m22982a(int i2, int i3) {
        if (!(C5215b2.m18812a(i3, i2) > 0)) {
            throw new IllegalArgumentException(C5626g.m22970a(C5341j1.m21921a(i2), C5341j1.m21921a(i3)).toString());
        }
    }

    @InterfaceC5352k
    /* renamed from: a */
    public static final void m22983a(long j2, long j3) {
        if (!(C5215b2.m18813a(j3, j2) > 0)) {
            throw new IllegalArgumentException(C5626g.m22970a(C5441n1.m22197a(j2), C5441n1.m22197a(j3)).toString());
        }
    }
}
