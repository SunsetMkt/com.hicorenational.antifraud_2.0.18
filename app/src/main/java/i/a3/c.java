package i.a3;

import i.q2.t.v;

/* JADX INFO: compiled from: TimeSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@j
final class c extends o {

    @j.c.a.d
    private final o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f12052b;

    private c(o oVar, double d2) {
        this.a = oVar;
        this.f12052b = d2;
    }

    @Override // i.a3.o
    public double a() {
        return d.e(this.a.a(), this.f12052b);
    }

    @Override // i.a3.o
    @j.c.a.d
    public o b(double d2) {
        return new c(this.a, d.f(this.f12052b, d2), null);
    }

    public final double d() {
        return this.f12052b;
    }

    @j.c.a.d
    public final o e() {
        return this.a;
    }

    public /* synthetic */ c(o oVar, double d2, v vVar) {
        this(oVar, d2);
    }
}
