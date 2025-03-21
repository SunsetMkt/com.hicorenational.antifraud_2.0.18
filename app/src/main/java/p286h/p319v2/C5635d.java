package p286h.p319v2;

import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Ranges.kt */
/* renamed from: h.v2.d */
/* loaded from: classes2.dex */
final class C5635d implements InterfaceC5637f<Double> {

    /* renamed from: a */
    private final double f20504a;

    /* renamed from: b */
    private final double f20505b;

    public C5635d(double d2, double d3) {
        this.f20504a = d2;
        this.f20505b = d3;
    }

    /* renamed from: a */
    public boolean m23013a(double d2, double d3) {
        return d2 <= d3;
    }

    @Override // p286h.p319v2.InterfaceC5637f
    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo23014a(Double d2, Double d3) {
        return m23013a(d2.doubleValue(), d3.doubleValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p286h.p319v2.InterfaceC5637f, p286h.p319v2.InterfaceC5638g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return m23012a(((Number) comparable).doubleValue());
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj instanceof C5635d) {
            if (!isEmpty() || !((C5635d) obj).isEmpty()) {
                C5635d c5635d = (C5635d) obj;
                if (this.f20504a != c5635d.f20504a || this.f20505b != c5635d.f20505b) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.f20504a).hashCode() * 31) + Double.valueOf(this.f20505b).hashCode();
    }

    @Override // p286h.p319v2.InterfaceC5637f, p286h.p319v2.InterfaceC5638g
    public boolean isEmpty() {
        return this.f20504a > this.f20505b;
    }

    @InterfaceC5816d
    public String toString() {
        return this.f20504a + ".." + this.f20505b;
    }

    /* renamed from: a */
    public boolean m23012a(double d2) {
        return d2 >= this.f20504a && d2 <= this.f20505b;
    }

    @Override // p286h.p319v2.InterfaceC5638g
    @InterfaceC5816d
    public Double getEndInclusive() {
        return Double.valueOf(this.f20505b);
    }

    @Override // p286h.p319v2.InterfaceC5638g
    @InterfaceC5816d
    public Double getStart() {
        return Double.valueOf(this.f20504a);
    }
}
