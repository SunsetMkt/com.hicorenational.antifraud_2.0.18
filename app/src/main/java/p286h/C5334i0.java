package p286h;

import java.io.Serializable;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Tuples.kt */
/* renamed from: h.i0 */
/* loaded from: classes2.dex */
public final class C5334i0<A, B> implements Serializable {
    private final A first;
    private final B second;

    public C5334i0(A a2, B b2) {
        this.first = a2;
        this.second = b2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C5334i0 copy$default(C5334i0 c5334i0, Object obj, Object obj2, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj = c5334i0.first;
        }
        if ((i2 & 2) != 0) {
            obj2 = c5334i0.second;
        }
        return c5334i0.copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    @InterfaceC5816d
    public final C5334i0<A, B> copy(A a2, B b2) {
        return new C5334i0<>(a2, b2);
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5334i0)) {
            return false;
        }
        C5334i0 c5334i0 = (C5334i0) obj;
        return C5544i0.m22531a(this.first, c5334i0.first) && C5544i0.m22531a(this.second, c5334i0.second);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a2 = this.first;
        int hashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.second;
        return hashCode + (b2 != null ? b2.hashCode() : 0);
    }

    @InterfaceC5816d
    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
