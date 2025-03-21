package p286h.p319v2;

import java.util.NoSuchElementException;
import p286h.C5215b2;
import p286h.C5230f1;
import p286h.C5341j1;
import p286h.C5441n1;
import p286h.C5611t1;
import p286h.InterfaceC5339j;
import p286h.InterfaceC5352k;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;
import p286h.p318u2.AbstractC5625f;
import p286h.p318u2.C5627h;
import p286h.p319v2.C5649r;
import p286h.p319v2.C5652u;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: _URanges.kt */
/* renamed from: h.v2.y */
/* loaded from: classes2.dex */
class C5656y {
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final int m23183a(@InterfaceC5816d C5651t c5651t) {
        return m23184a(c5651t, AbstractC5625f.f20486c);
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    private static final C5341j1 m23207b(@InterfaceC5816d C5651t c5651t) {
        return m23208b(c5651t, AbstractC5625f.f20486c);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: c */
    public static final C5649r m23212c(byte b2, byte b3) {
        return C5649r.f20530d.m23169a(C5341j1.m21929c(b2 & C5230f1.f20085c), C5341j1.m21929c(b3 & C5230f1.f20085c), -1);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: d */
    public static final C5651t m23216d(byte b2, byte b3) {
        return C5544i0.m22512a(b3 & C5230f1.f20085c, 0) <= 0 ? C5651t.f20539f.m23172a() : new C5651t(C5341j1.m21929c(b2 & C5230f1.f20085c), C5341j1.m21929c(C5341j1.m21929c(r3) - 1), null);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final long m23188a(@InterfaceC5816d C5654w c5654w) {
        return m23189a(c5654w, AbstractC5625f.f20486c);
    }

    @InterfaceC5426f
    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    private static final C5441n1 m23209b(@InterfaceC5816d C5654w c5654w) {
        return m23210b(c5654w, AbstractC5625f.f20486c);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: c */
    public static final C5649r m23213c(int i2, int i3) {
        return C5649r.f20530d.m23169a(i2, i3, -1);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final int m23184a(@InterfaceC5816d C5651t c5651t, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(c5651t, "$this$random");
        C5544i0.m22546f(abstractC5625f, "random");
        try {
            return C5627h.m22978a(abstractC5625f, c5651t);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5817e
    /* renamed from: b */
    public static final C5341j1 m23208b(@InterfaceC5816d C5651t c5651t, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(c5651t, "$this$randomOrNull");
        C5544i0.m22546f(abstractC5625f, "random");
        if (c5651t.isEmpty()) {
            return null;
        }
        return C5341j1.m21921a(C5627h.m22978a(abstractC5625f, c5651t));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: c */
    public static final C5652u m23215c(long j2, long j3) {
        return C5652u.f20540d.m23174a(j2, j3, -1L);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: d */
    public static final C5651t m23217d(int i2, int i3) {
        return C5215b2.m18812a(i3, 0) <= 0 ? C5651t.f20539f.m23172a() : new C5651t(i2, C5341j1.m21929c(i3 - 1), null);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: c */
    public static final C5649r m23214c(short s, short s2) {
        return C5649r.f20530d.m23169a(C5341j1.m21929c(s & C5611t1.f20467c), C5341j1.m21929c(s2 & C5611t1.f20467c), -1);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final long m23189a(@InterfaceC5816d C5654w c5654w, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(c5654w, "$this$random");
        C5544i0.m22546f(abstractC5625f, "random");
        try {
            return C5627h.m22981a(abstractC5625f, c5654w);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5817e
    /* renamed from: b */
    public static final C5441n1 m23210b(@InterfaceC5816d C5654w c5654w, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(c5654w, "$this$randomOrNull");
        C5544i0.m22546f(abstractC5625f, "random");
        if (c5654w.isEmpty()) {
            return null;
        }
        return C5441n1.m22197a(C5627h.m22981a(abstractC5625f, c5654w));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: d */
    public static final C5654w m23219d(long j2, long j3) {
        return C5215b2.m18813a(j3, 0L) <= 0 ? C5654w.f20549f.m23177a() : new C5654w(j2, C5441n1.m22205c(j3 - C5441n1.m22205c(1 & 4294967295L)), null);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final boolean m23198a(@InterfaceC5816d C5651t c5651t, C5341j1 c5341j1) {
        C5544i0.m22546f(c5651t, "$this$contains");
        return c5341j1 != null && c5651t.m23171a(c5341j1.m21968a());
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    public static final int m23205b(int i2, int i3) {
        return C5215b2.m18812a(i2, i3) > 0 ? i3 : i2;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: d */
    public static final C5651t m23218d(short s, short s2) {
        return C5544i0.m22512a(s2 & C5611t1.f20467c, 0) <= 0 ? C5651t.f20539f.m23172a() : new C5651t(C5341j1.m21929c(s & C5611t1.f20467c), C5341j1.m21929c(C5341j1.m21929c(r3) - 1), null);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final boolean m23202a(@InterfaceC5816d C5654w c5654w, C5441n1 c5441n1) {
        C5544i0.m22546f(c5654w, "$this$contains");
        return c5441n1 != null && c5654w.m23176a(c5441n1.m22244a());
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    public static final long m23206b(long j2, long j3) {
        return C5215b2.m18813a(j2, j3) > 0 ? j3 : j2;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final boolean m23196a(@InterfaceC5816d C5651t c5651t, byte b2) {
        C5544i0.m22546f(c5651t, "$this$contains");
        return c5651t.m23171a(C5341j1.m21929c(b2 & C5230f1.f20085c));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    public static final byte m23204b(byte b2, byte b3) {
        return C5544i0.m22512a(b2 & C5230f1.f20085c, b3 & C5230f1.f20085c) > 0 ? b3 : b2;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final boolean m23200a(@InterfaceC5816d C5654w c5654w, byte b2) {
        C5544i0.m22546f(c5654w, "$this$contains");
        return c5654w.m23176a(C5441n1.m22205c(b2 & 255));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    public static final short m23211b(short s, short s2) {
        return C5544i0.m22512a(s & C5611t1.f20467c, 65535 & s2) > 0 ? s2 : s;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final boolean m23201a(@InterfaceC5816d C5654w c5654w, int i2) {
        C5544i0.m22546f(c5654w, "$this$contains");
        return c5654w.m23176a(C5441n1.m22205c(i2 & 4294967295L));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final boolean m23197a(@InterfaceC5816d C5651t c5651t, long j2) {
        C5544i0.m22546f(c5651t, "$this$contains");
        return C5441n1.m22205c(j2 >>> 32) == 0 && c5651t.m23171a(C5341j1.m21929c((int) j2));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final boolean m23199a(@InterfaceC5816d C5651t c5651t, short s) {
        C5544i0.m22546f(c5651t, "$this$contains");
        return c5651t.m23171a(C5341j1.m21929c(s & C5611t1.f20467c));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final boolean m23203a(@InterfaceC5816d C5654w c5654w, short s) {
        C5544i0.m22546f(c5654w, "$this$contains");
        return c5654w.m23176a(C5441n1.m22205c(s & 65535));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final C5649r m23190a(@InterfaceC5816d C5649r c5649r) {
        C5544i0.m22546f(c5649r, "$this$reversed");
        return C5649r.f20530d.m23169a(c5649r.getLast(), c5649r.getFirst(), -c5649r.m23168b());
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final C5652u m23192a(@InterfaceC5816d C5652u c5652u) {
        C5544i0.m22546f(c5652u, "$this$reversed");
        return C5652u.f20540d.m23174a(c5652u.getLast(), c5652u.getFirst(), -c5652u.m23173b());
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final C5649r m23191a(@InterfaceC5816d C5649r c5649r, int i2) {
        C5544i0.m22546f(c5649r, "$this$step");
        C5647p.m23042a(i2 > 0, Integer.valueOf(i2));
        C5649r.a aVar = C5649r.f20530d;
        int first = c5649r.getFirst();
        int last = c5649r.getLast();
        if (c5649r.m23168b() <= 0) {
            i2 = -i2;
        }
        return aVar.m23169a(first, last, i2);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final C5652u m23193a(@InterfaceC5816d C5652u c5652u, long j2) {
        C5544i0.m22546f(c5652u, "$this$step");
        C5647p.m23042a(j2 > 0, Long.valueOf(j2));
        C5652u.a aVar = C5652u.f20540d;
        long first = c5652u.getFirst();
        long last = c5652u.getLast();
        if (c5652u.m23173b() <= 0) {
            j2 = -j2;
        }
        return aVar.m23174a(first, last, j2);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final int m23180a(int i2, int i3) {
        return C5215b2.m18812a(i2, i3) < 0 ? i3 : i2;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final long m23185a(long j2, long j3) {
        return C5215b2.m18813a(j2, j3) < 0 ? j3 : j2;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final byte m23178a(byte b2, byte b3) {
        return C5544i0.m22512a(b2 & C5230f1.f20085c, b3 & C5230f1.f20085c) < 0 ? b3 : b2;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final short m23194a(short s, short s2) {
        return C5544i0.m22512a(s & C5611t1.f20467c, 65535 & s2) < 0 ? s2 : s;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final int m23181a(int i2, int i3, int i4) {
        if (C5215b2.m18812a(i3, i4) <= 0) {
            return C5215b2.m18812a(i2, i3) < 0 ? i3 : C5215b2.m18812a(i2, i4) > 0 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + C5341j1.m21963n(i4) + " is less than minimum " + C5341j1.m21963n(i3) + '.');
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final long m23186a(long j2, long j3, long j4) {
        if (C5215b2.m18813a(j3, j4) <= 0) {
            return C5215b2.m18813a(j2, j3) < 0 ? j3 : C5215b2.m18813a(j2, j4) > 0 ? j4 : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + C5441n1.m22239n(j4) + " is less than minimum " + C5441n1.m22239n(j3) + '.');
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final byte m23179a(byte b2, byte b3, byte b4) {
        int i2 = b3 & C5230f1.f20085c;
        int i3 = b4 & C5230f1.f20085c;
        if (C5544i0.m22512a(i2, i3) <= 0) {
            int i4 = b2 & C5230f1.f20085c;
            return C5544i0.m22512a(i4, i2) < 0 ? b3 : C5544i0.m22512a(i4, i3) > 0 ? b4 : b2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + C5230f1.m18961n(b4) + " is less than minimum " + C5230f1.m18961n(b3) + '.');
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final short m23195a(short s, short s2, short s3) {
        int i2 = s2 & C5611t1.f20467c;
        int i3 = s3 & C5611t1.f20467c;
        if (C5544i0.m22512a(i2, i3) <= 0) {
            int i4 = 65535 & s;
            return C5544i0.m22512a(i4, i2) < 0 ? s2 : C5544i0.m22512a(i4, i3) > 0 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + C5611t1.m22908n(s3) + " is less than minimum " + C5611t1.m22908n(s2) + '.');
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final int m23182a(int i2, @InterfaceC5816d InterfaceC5638g<C5341j1> interfaceC5638g) {
        C5544i0.m22546f(interfaceC5638g, "range");
        if (interfaceC5638g instanceof InterfaceC5637f) {
            return ((C5341j1) C5648q.m23084a(C5341j1.m21921a(i2), (InterfaceC5637f<C5341j1>) interfaceC5638g)).m21968a();
        }
        if (!interfaceC5638g.isEmpty()) {
            return C5215b2.m18812a(i2, interfaceC5638g.getStart().m21968a()) < 0 ? interfaceC5638g.getStart().m21968a() : C5215b2.m18812a(i2, interfaceC5638g.getEndInclusive().m21968a()) > 0 ? interfaceC5638g.getEndInclusive().m21968a() : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + interfaceC5638g + '.');
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final long m23187a(long j2, @InterfaceC5816d InterfaceC5638g<C5441n1> interfaceC5638g) {
        C5544i0.m22546f(interfaceC5638g, "range");
        if (interfaceC5638g instanceof InterfaceC5637f) {
            return ((C5441n1) C5648q.m23084a(C5441n1.m22197a(j2), (InterfaceC5637f<C5441n1>) interfaceC5638g)).m22244a();
        }
        if (!interfaceC5638g.isEmpty()) {
            return C5215b2.m18813a(j2, interfaceC5638g.getStart().m22244a()) < 0 ? interfaceC5638g.getStart().m22244a() : C5215b2.m18813a(j2, interfaceC5638g.getEndInclusive().m22244a()) > 0 ? interfaceC5638g.getEndInclusive().m22244a() : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + interfaceC5638g + '.');
    }
}
