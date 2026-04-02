package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableConcatMapPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z<T, R> extends h.a.l<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<T> f11077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends j.d.b<? extends R>> f11078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f11079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.y0.j.j f11080e;

    public z(j.d.b<T> bVar, h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar, int i2, h.a.y0.j.j jVar) {
        this.f11077b = bVar;
        this.f11078c = oVar;
        this.f11079d = i2;
        this.f11080e = jVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super R> cVar) {
        if (d3.a(this.f11077b, cVar, this.f11078c)) {
            return;
        }
        this.f11077b.subscribe(w.a(cVar, this.f11078c, this.f11079d, this.f11080e));
    }
}
