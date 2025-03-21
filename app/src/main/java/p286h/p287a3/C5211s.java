package p286h.p287a3;

import p286h.InterfaceC5610t0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: measureTime.kt */
@InterfaceC5202j
@InterfaceC5610t0(version = "1.3")
/* renamed from: h.a3.s */
/* loaded from: classes2.dex */
public final class C5211s<T> {

    /* renamed from: a */
    private final T f20079a;

    /* renamed from: b */
    private final double f20080b;

    private C5211s(T t, double d2) {
        this.f20079a = t;
        this.f20080b = d2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static /* synthetic */ C5211s m18803a(C5211s c5211s, Object obj, double d2, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = c5211s.f20079a;
        }
        if ((i2 & 2) != 0) {
            d2 = c5211s.f20080b;
        }
        return c5211s.m18804a(obj, d2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final C5211s<T> m18804a(T t, double d2) {
        return new C5211s<>(t, d2);
    }

    /* renamed from: a */
    public final T m18805a() {
        return this.f20079a;
    }

    /* renamed from: b */
    public final double m18806b() {
        return this.f20080b;
    }

    /* renamed from: c */
    public final double m18807c() {
        return this.f20080b;
    }

    /* renamed from: d */
    public final T m18808d() {
        return this.f20079a;
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5211s)) {
            return false;
        }
        C5211s c5211s = (C5211s) obj;
        return C5544i0.m22531a(this.f20079a, c5211s.f20079a) && Double.compare(this.f20080b, c5211s.f20080b) == 0;
    }

    public int hashCode() {
        T t = this.f20079a;
        int hashCode = t != null ? t.hashCode() : 0;
        long doubleToLongBits = Double.doubleToLongBits(this.f20080b);
        return (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    @InterfaceC5816d
    public String toString() {
        return "TimedValue(value=" + this.f20079a + ", duration=" + C5196d.m18722x(this.f20080b) + ")";
    }

    public /* synthetic */ C5211s(Object obj, double d2, C5586v c5586v) {
        this(obj, d2);
    }
}
