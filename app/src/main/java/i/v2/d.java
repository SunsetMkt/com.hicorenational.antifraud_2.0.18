package i.v2;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes2.dex */
final class d implements f<Double> {
    private final double a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f12303b;

    public d(double d2, double d3) {
        this.a = d2;
        this.f12303b = d3;
    }

    public boolean a(double d2, double d3) {
        return d2 <= d3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.v2.f
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable, Comparable comparable2) {
        return a(((Number) comparable).doubleValue(), ((Number) comparable2).doubleValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.v2.f, i.v2.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((Number) comparable).doubleValue());
    }

    public boolean equals(@j.c.a.e Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (this.a != dVar.a || this.f12303b != dVar.f12303b) {
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
        return (Double.valueOf(this.a).hashCode() * 31) + Double.valueOf(this.f12303b).hashCode();
    }

    @Override // i.v2.f, i.v2.g
    public boolean isEmpty() {
        return this.a > this.f12303b;
    }

    @j.c.a.d
    public String toString() {
        return this.a + ".." + this.f12303b;
    }

    public boolean a(double d2) {
        return d2 >= this.a && d2 <= this.f12303b;
    }

    @Override // i.v2.g
    @j.c.a.d
    public Double getEndInclusive() {
        return Double.valueOf(this.f12303b);
    }

    @Override // i.v2.g
    @j.c.a.d
    public Double getStart() {
        return Double.valueOf(this.a);
    }
}
