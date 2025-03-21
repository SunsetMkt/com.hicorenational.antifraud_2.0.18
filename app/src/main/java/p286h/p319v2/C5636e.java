package p286h.p319v2;

import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Ranges.kt */
/* renamed from: h.v2.e */
/* loaded from: classes2.dex */
final class C5636e implements InterfaceC5637f<Float> {

    /* renamed from: a */
    private final float f20506a;

    /* renamed from: b */
    private final float f20507b;

    public C5636e(float f2, float f3) {
        this.f20506a = f2;
        this.f20507b = f3;
    }

    /* renamed from: a */
    public boolean m23016a(float f2, float f3) {
        return f2 <= f3;
    }

    @Override // p286h.p319v2.InterfaceC5637f
    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo23014a(Float f2, Float f3) {
        return m23016a(f2.floatValue(), f3.floatValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p286h.p319v2.InterfaceC5637f, p286h.p319v2.InterfaceC5638g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return m23015a(((Number) comparable).floatValue());
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj instanceof C5636e) {
            if (!isEmpty() || !((C5636e) obj).isEmpty()) {
                C5636e c5636e = (C5636e) obj;
                if (this.f20506a != c5636e.f20506a || this.f20507b != c5636e.f20507b) {
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
        return (Float.valueOf(this.f20506a).hashCode() * 31) + Float.valueOf(this.f20507b).hashCode();
    }

    @Override // p286h.p319v2.InterfaceC5637f, p286h.p319v2.InterfaceC5638g
    public boolean isEmpty() {
        return this.f20506a > this.f20507b;
    }

    @InterfaceC5816d
    public String toString() {
        return this.f20506a + ".." + this.f20507b;
    }

    /* renamed from: a */
    public boolean m23015a(float f2) {
        return f2 >= this.f20506a && f2 <= this.f20507b;
    }

    @Override // p286h.p319v2.InterfaceC5638g
    @InterfaceC5816d
    public Float getEndInclusive() {
        return Float.valueOf(this.f20507b);
    }

    @Override // p286h.p319v2.InterfaceC5638g
    @InterfaceC5816d
    public Float getStart() {
        return Float.valueOf(this.f20506a);
    }
}
