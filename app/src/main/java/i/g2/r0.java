package i.g2;

/* JADX INFO: compiled from: IndexedValue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class r0<T> {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f12099b;

    public r0(int i2, T t) {
        this.a = i2;
        this.f12099b = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ r0 a(r0 r0Var, int i2, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            i2 = r0Var.a;
        }
        if ((i3 & 2) != 0) {
            obj = r0Var.f12099b;
        }
        return r0Var.a(i2, obj);
    }

    public final int a() {
        return this.a;
    }

    @j.c.a.d
    public final r0<T> a(int i2, T t) {
        return new r0<>(i2, t);
    }

    public final T b() {
        return this.f12099b;
    }

    public final int c() {
        return this.a;
    }

    public final T d() {
        return this.f12099b;
    }

    public boolean equals(@j.c.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) obj;
        return this.a == r0Var.a && i.q2.t.i0.a(this.f12099b, r0Var.f12099b);
    }

    public int hashCode() {
        int i2 = this.a * 31;
        T t = this.f12099b;
        return i2 + (t != null ? t.hashCode() : 0);
    }

    @j.c.a.d
    public String toString() {
        return "IndexedValue(index=" + this.a + ", value=" + this.f12099b + ")";
    }
}
