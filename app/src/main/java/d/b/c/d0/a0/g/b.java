package d.b.c.d0.a0.g;

/* JADX INFO: compiled from: ExpandedPair.java */
/* JADX INFO: loaded from: classes.dex */
final class b {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.b.c.d0.a0.b f9564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.b.c.d0.a0.b f9565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.b.c.d0.a0.c f9566d;

    b(d.b.c.d0.a0.b bVar, d.b.c.d0.a0.b bVar2, d.b.c.d0.a0.c cVar, boolean z) {
        this.f9564b = bVar;
        this.f9565c = bVar2;
        this.f9566d = cVar;
        this.a = z;
    }

    d.b.c.d0.a0.c a() {
        return this.f9566d;
    }

    d.b.c.d0.a0.b b() {
        return this.f9564b;
    }

    d.b.c.d0.a0.b c() {
        return this.f9565c;
    }

    boolean d() {
        return this.a;
    }

    public boolean e() {
        return this.f9565c == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return a(this.f9564b, bVar.f9564b) && a(this.f9565c, bVar.f9565c) && a(this.f9566d, bVar.f9566d);
    }

    public int hashCode() {
        return (a(this.f9564b) ^ a(this.f9565c)) ^ a(this.f9566d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append(this.f9564b);
        sb.append(" , ");
        sb.append(this.f9565c);
        sb.append(" : ");
        d.b.c.d0.a0.c cVar = this.f9566d;
        sb.append(cVar == null ? d.c.a.b.a.a.f10075h : Integer.valueOf(cVar.c()));
        sb.append(" ]");
        return sb.toString();
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
