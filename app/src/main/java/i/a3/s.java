package i.a3;

import i.q2.t.i0;
import i.q2.t.v;
import i.t0;

/* JADX INFO: compiled from: measureTime.kt */
/* JADX INFO: loaded from: classes2.dex */
@j
@t0(version = "1.3")
public final class s<T> {
    private final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f12063b;

    private s(T t, double d2) {
        this.a = t;
        this.f12063b = d2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ s a(s sVar, Object obj, double d2, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = sVar.a;
        }
        if ((i2 & 2) != 0) {
            d2 = sVar.f12063b;
        }
        return sVar.a(obj, d2);
    }

    @j.c.a.d
    public final s<T> a(T t, double d2) {
        return new s<>(t, d2);
    }

    public final T a() {
        return this.a;
    }

    public final double b() {
        return this.f12063b;
    }

    public final double c() {
        return this.f12063b;
    }

    public final T d() {
        return this.a;
    }

    public boolean equals(@j.c.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return i0.a(this.a, sVar.a) && Double.compare(this.f12063b, sVar.f12063b) == 0;
    }

    public int hashCode() {
        T t = this.a;
        int iHashCode = t != null ? t.hashCode() : 0;
        long jDoubleToLongBits = Double.doubleToLongBits(this.f12063b);
        return (iHashCode * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
    }

    @j.c.a.d
    public String toString() {
        return "TimedValue(value=" + this.a + ", duration=" + d.x(this.f12063b) + ")";
    }

    public /* synthetic */ s(Object obj, double d2, v vVar) {
        this(obj, d2);
    }
}
