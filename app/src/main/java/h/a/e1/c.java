package h.a.e1;

import h.a.t0.f;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Timed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T> {
    final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f10333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f10334c;

    public c(@f T t, long j2, @f TimeUnit timeUnit) {
        this.a = t;
        this.f10333b = j2;
        this.f10334c = (TimeUnit) h.a.y0.b.b.a(timeUnit, "unit is null");
    }

    public long a() {
        return this.f10333b;
    }

    @f
    public TimeUnit b() {
        return this.f10334c;
    }

    @f
    public T c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return h.a.y0.b.b.a(this.a, cVar.a) && this.f10333b == cVar.f10333b && h.a.y0.b.b.a(this.f10334c, cVar.f10334c);
    }

    public int hashCode() {
        T t = this.a;
        int iHashCode = t != null ? t.hashCode() : 0;
        long j2 = this.f10333b;
        return (((iHashCode * 31) + ((int) (j2 ^ (j2 >>> 31)))) * 31) + this.f10334c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f10333b + ", unit=" + this.f10334c + ", value=" + this.a + "]";
    }

    public long a(@f TimeUnit timeUnit) {
        return timeUnit.convert(this.f10333b, this.f10334c);
    }
}
