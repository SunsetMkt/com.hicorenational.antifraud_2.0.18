package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableFlatMapPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a1<T, U> extends h.a.l<U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<T> f10562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends j.d.b<? extends U>> f10563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f10564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f10565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f10566f;

    public a1(j.d.b<T> bVar, h.a.x0.o<? super T, ? extends j.d.b<? extends U>> oVar, boolean z, int i2, int i3) {
        this.f10562b = bVar;
        this.f10563c = oVar;
        this.f10564d = z;
        this.f10565e = i2;
        this.f10566f = i3;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super U> cVar) {
        if (d3.a(this.f10562b, cVar, this.f10563c)) {
            return;
        }
        this.f10562b.subscribe(w0.a(cVar, this.f10563c, this.f10564d, this.f10565e, this.f10566f));
    }
}
