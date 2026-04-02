package h.a.y0.e.b;

import h.a.y0.e.b.y1;

/* JADX INFO: compiled from: FlowableMapPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a2<T, U> extends h.a.l<U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<T> f10567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends U> f10568c;

    public a2(j.d.b<T> bVar, h.a.x0.o<? super T, ? extends U> oVar) {
        this.f10567b = bVar;
        this.f10568c = oVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super U> cVar) {
        this.f10567b.subscribe(new y1.b(cVar, this.f10568c));
    }
}
