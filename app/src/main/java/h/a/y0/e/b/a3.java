package h.a.y0.e.b;

import h.a.y0.e.b.w2;

/* JADX INFO: compiled from: FlowableRetryWhen.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a3<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super h.a.l<Throwable>, ? extends j.d.b<?>> f10569c;

    /* JADX INFO: compiled from: FlowableRetryWhen.java */
    static final class a<T> extends w2.c<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        a(j.d.c<? super T> cVar, h.a.d1.c<Throwable> cVar2, j.d.d dVar) {
            super(cVar, cVar2, dVar);
        }

        @Override // j.d.c
        public void onComplete() {
            this.f11035receiver.cancel();
            ((w2.c) this).actual.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            again(th);
        }
    }

    public a3(h.a.l<T> lVar, h.a.x0.o<? super h.a.l<Throwable>, ? extends j.d.b<?>> oVar) {
        super(lVar);
        this.f10569c = oVar;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        h.a.g1.e eVar = new h.a.g1.e(cVar);
        h.a.d1.c<T> cVarX = h.a.d1.g.m(8).X();
        try {
            j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.f10569c.apply(cVarX), "handler returned a null Publisher");
            w2.b bVar2 = new w2.b(this.f10561b);
            a aVar = new a(eVar, cVarX, bVar2);
            bVar2.subscriber = aVar;
            cVar.onSubscribe(aVar);
            bVar.subscribe(bVar2);
            bVar2.onNext(0);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.i.g.error(th, cVar);
        }
    }
}
