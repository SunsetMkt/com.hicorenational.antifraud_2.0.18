package d.d.a.a;

/* JADX INFO: compiled from: Pair.java */
/* JADX INFO: loaded from: classes.dex */
public final class c<A, B> {
    private final A a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f10111b;

    private c(A a, B b2) {
        this.a = a;
        this.f10111b = b2;
    }

    public static <A, B> c<A, B> a(A a, B b2) {
        return new c<>(a, b2);
    }

    public B b() {
        return this.f10111b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        A a = this.a;
        if (a == null) {
            if (cVar.a != null) {
                return false;
            }
        } else if (!a.equals(cVar.a)) {
            return false;
        }
        B b2 = this.f10111b;
        if (b2 == null) {
            if (cVar.f10111b != null) {
                return false;
            }
        } else if (!b2.equals(cVar.f10111b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a = this.a;
        int iHashCode = ((a == null ? 0 : a.hashCode()) + 31) * 31;
        B b2 = this.f10111b;
        return iHashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public String toString() {
        return "first = " + this.a + " , second = " + this.f10111b;
    }

    public A a() {
        return this.a;
    }
}
