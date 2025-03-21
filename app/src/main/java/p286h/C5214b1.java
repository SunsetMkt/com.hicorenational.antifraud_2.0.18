package p286h;

import java.io.Serializable;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Tuples.kt */
/* renamed from: h.b1 */
/* loaded from: classes2.dex */
public final class C5214b1<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public C5214b1(A a2, B b2, C c2) {
        this.first = a2;
        this.second = b2;
        this.third = c2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C5214b1 copy$default(C5214b1 c5214b1, Object obj, Object obj2, Object obj3, int i2, Object obj4) {
        if ((i2 & 1) != 0) {
            obj = c5214b1.first;
        }
        if ((i2 & 2) != 0) {
            obj2 = c5214b1.second;
        }
        if ((i2 & 4) != 0) {
            obj3 = c5214b1.third;
        }
        return c5214b1.copy(obj, obj2, obj3);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    @InterfaceC5816d
    public final C5214b1<A, B, C> copy(A a2, B b2, C c2) {
        return new C5214b1<>(a2, b2, c2);
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5214b1)) {
            return false;
        }
        C5214b1 c5214b1 = (C5214b1) obj;
        return C5544i0.m22531a(this.first, c5214b1.first) && C5544i0.m22531a(this.second, c5214b1.second) && C5544i0.m22531a(this.third, c5214b1.third);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a2 = this.first;
        int hashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.second;
        int hashCode2 = (hashCode + (b2 != null ? b2.hashCode() : 0)) * 31;
        C c2 = this.third;
        return hashCode2 + (c2 != null ? c2.hashCode() : 0);
    }

    @InterfaceC5816d
    public String toString() {
        return '(' + this.first + ", " + this.second + ", " + this.third + ')';
    }
}
