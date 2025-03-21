package p031c.p091d.p092a.p093a;

/* compiled from: Pair.java */
/* renamed from: c.d.a.a.c */
/* loaded from: classes.dex */
public final class C1219c<A, B> {

    /* renamed from: a */
    private final A f2673a;

    /* renamed from: b */
    private final B f2674b;

    private C1219c(A a2, B b2) {
        this.f2673a = a2;
        this.f2674b = b2;
    }

    /* renamed from: a */
    public static <A, B> C1219c<A, B> m2368a(A a2, B b2) {
        return new C1219c<>(a2, b2);
    }

    /* renamed from: b */
    public B m2370b() {
        return this.f2674b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1219c.class != obj.getClass()) {
            return false;
        }
        C1219c c1219c = (C1219c) obj;
        A a2 = this.f2673a;
        if (a2 == null) {
            if (c1219c.f2673a != null) {
                return false;
            }
        } else if (!a2.equals(c1219c.f2673a)) {
            return false;
        }
        B b2 = this.f2674b;
        if (b2 == null) {
            if (c1219c.f2674b != null) {
                return false;
            }
        } else if (!b2.equals(c1219c.f2674b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a2 = this.f2673a;
        int hashCode = ((a2 == null ? 0 : a2.hashCode()) + 31) * 31;
        B b2 = this.f2674b;
        return hashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public String toString() {
        return "first = " + this.f2673a + " , second = " + this.f2674b;
    }

    /* renamed from: a */
    public A m2369a() {
        return this.f2673a;
    }
}
