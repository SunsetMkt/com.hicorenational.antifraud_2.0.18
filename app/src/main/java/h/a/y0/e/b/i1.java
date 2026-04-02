package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableFromPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i1<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<? extends T> f10706b;

    public i1(j.d.b<? extends T> bVar) {
        this.f10706b = bVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10706b.subscribe(cVar);
    }
}
