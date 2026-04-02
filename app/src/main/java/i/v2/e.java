package i.v2;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes2.dex */
final class e implements f<Float> {
    private final float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f12304b;

    public e(float f2, float f3) {
        this.a = f2;
        this.f12304b = f3;
    }

    public boolean a(float f2, float f3) {
        return f2 <= f3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.v2.f
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable, Comparable comparable2) {
        return a(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.v2.f, i.v2.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((Number) comparable).floatValue());
    }

    public boolean equals(@j.c.a.e Object obj) {
        if (obj instanceof e) {
            if (!isEmpty() || !((e) obj).isEmpty()) {
                e eVar = (e) obj;
                if (this.a != eVar.a || this.f12304b != eVar.f12304b) {
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
        return (Float.valueOf(this.a).hashCode() * 31) + Float.valueOf(this.f12304b).hashCode();
    }

    @Override // i.v2.f, i.v2.g
    public boolean isEmpty() {
        return this.a > this.f12304b;
    }

    @j.c.a.d
    public String toString() {
        return this.a + ".." + this.f12304b;
    }

    public boolean a(float f2) {
        return f2 >= this.a && f2 <= this.f12304b;
    }

    @Override // i.v2.g
    @j.c.a.d
    public Float getEndInclusive() {
        return Float.valueOf(this.f12304b);
    }

    @Override // i.v2.g
    @j.c.a.d
    public Float getStart() {
        return Float.valueOf(this.a);
    }
}
