package h.a.y0.e.b;

import h.a.y0.e.b.x;

/* JADX INFO: compiled from: FlowableConcatMapEagerPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y<T, R> extends h.a.l<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<T> f11063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends j.d.b<? extends R>> f11064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f11065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f11066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h.a.y0.j.j f11067f;

    public y(j.d.b<T> bVar, h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2, int i3, h.a.y0.j.j jVar) {
        this.f11063b = bVar;
        this.f11064c = oVar;
        this.f11065d = i2;
        this.f11066e = i3;
        this.f11067f = jVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super R> cVar) {
        this.f11063b.subscribe(new x.a(cVar, this.f11064c, this.f11065d, this.f11066e, this.f11067f));
    }
}
