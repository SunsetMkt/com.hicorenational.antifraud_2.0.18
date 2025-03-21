package p286h.p319v2;

import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Ranges.kt */
/* renamed from: h.v2.p */
/* loaded from: classes2.dex */
class C5647p {
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T extends Comparable<? super T>> InterfaceC5638g<T> m23041a(@InterfaceC5816d T t, @InterfaceC5816d T t2) {
        C5544i0.m22546f(t, "$this$rangeTo");
        C5544i0.m22546f(t2, "that");
        return new C5639h(t, t2);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final InterfaceC5637f<Double> m23039a(double d2, double d3) {
        return new C5635d(d2, d3);
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final InterfaceC5637f<Float> m23040a(float f2, float f3) {
        return new C5636e(f2, f3);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Ljava/lang/Iterable<+TT;>;:Lh/v2/g<TT;>;>(TR;TT;)Z */
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final boolean m23043a(@InterfaceC5816d Iterable iterable, Object obj) {
        C5544i0.m22546f(iterable, "$this$contains");
        return obj != null && ((InterfaceC5638g) iterable).contains((Comparable) obj);
    }

    /* renamed from: a */
    public static final void m23042a(boolean z, @InterfaceC5816d Number number) {
        C5544i0.m22546f(number, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
    }
}
