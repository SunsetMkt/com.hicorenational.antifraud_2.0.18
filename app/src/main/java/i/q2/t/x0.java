package i.q2.t;

import java.util.Collection;

/* JADX INFO: compiled from: PackageReference.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.t0(version = "1.1")
public final class x0 implements s {

    @j.c.a.d
    private final Class<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12259b;

    public x0(@j.c.a.d Class<?> cls, @j.c.a.d String str) {
        i0.f(cls, "jClass");
        i0.f(str, "moduleName");
        this.a = cls;
        this.f12259b = str;
    }

    @Override // i.w2.f
    @j.c.a.d
    public Collection<i.w2.b<?>> a() {
        throw new i.q2.l();
    }

    public boolean equals(@j.c.a.e Object obj) {
        return (obj instanceof x0) && i0.a(m(), ((x0) obj).m());
    }

    public int hashCode() {
        return m().hashCode();
    }

    @Override // i.q2.t.s
    @j.c.a.d
    public Class<?> m() {
        return this.a;
    }

    @j.c.a.d
    public String toString() {
        return m().toString() + " (Kotlin reflection is not available)";
    }
}
