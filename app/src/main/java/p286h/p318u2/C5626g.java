package p286h.p318u2;

import p286h.InterfaceC5610t0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5556m0;
import p286h.p319v2.C5642k;
import p286h.p319v2.C5645n;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Random.kt */
/* renamed from: h.u2.g */
/* loaded from: classes2.dex */
public final class C5626g {
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final AbstractC5625f m22968a(int i2) {
        return new C5628i(i2, i2 >> 31);
    }

    /* renamed from: b */
    public static final int m22974b(int i2) {
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    /* renamed from: b */
    public static final int m22975b(int i2, int i3) {
        return (i2 >>> (32 - i3)) & ((-i3) >> 31);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final AbstractC5625f m22969a(long j2) {
        return new C5628i((int) j2, (int) (j2 >> 32));
    }

    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    public static final int m22966a(@InterfaceC5816d AbstractC5625f abstractC5625f, @InterfaceC5816d C5642k c5642k) {
        C5544i0.m22546f(abstractC5625f, "$this$nextInt");
        C5544i0.m22546f(c5642k, "range");
        if (!c5642k.isEmpty()) {
            return c5642k.getLast() < Integer.MAX_VALUE ? abstractC5625f.mo22960a(c5642k.getFirst(), c5642k.getLast() + 1) : c5642k.getFirst() > Integer.MIN_VALUE ? abstractC5625f.mo22960a(c5642k.getFirst() - 1, c5642k.getLast()) + 1 : abstractC5625f.mo22949d();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + c5642k);
    }

    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    public static final long m22967a(@InterfaceC5816d AbstractC5625f abstractC5625f, @InterfaceC5816d C5645n c5645n) {
        C5544i0.m22546f(abstractC5625f, "$this$nextLong");
        C5544i0.m22546f(c5645n, "range");
        if (!c5645n.isEmpty()) {
            return c5645n.getLast() < C5556m0.f20396b ? abstractC5625f.mo22962a(c5645n.getFirst(), c5645n.getLast() + 1) : c5645n.getFirst() > Long.MIN_VALUE ? abstractC5625f.mo22962a(c5645n.getFirst() - 1, c5645n.getLast()) + 1 : abstractC5625f.mo22950e();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + c5645n);
    }

    /* renamed from: a */
    public static final void m22972a(int i2, int i3) {
        if (!(i3 > i2)) {
            throw new IllegalArgumentException(m22970a(Integer.valueOf(i2), Integer.valueOf(i3)).toString());
        }
    }

    /* renamed from: a */
    public static final void m22973a(long j2, long j3) {
        if (!(j3 > j2)) {
            throw new IllegalArgumentException(m22970a(Long.valueOf(j2), Long.valueOf(j3)).toString());
        }
    }

    /* renamed from: a */
    public static final void m22971a(double d2, double d3) {
        if (!(d3 > d2)) {
            throw new IllegalArgumentException(m22970a(Double.valueOf(d2), Double.valueOf(d3)).toString());
        }
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m22970a(@InterfaceC5816d Object obj, @InterfaceC5816d Object obj2) {
        C5544i0.m22546f(obj, "from");
        C5544i0.m22546f(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }
}
