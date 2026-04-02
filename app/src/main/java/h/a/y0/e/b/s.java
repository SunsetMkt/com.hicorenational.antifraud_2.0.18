package h.a.y0.e.b;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FlowableCollect.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s<T, U> extends h.a.y0.e.b.a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable<? extends U> f10955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.b<? super U, ? super T> f10956d;

    /* JADX INFO: compiled from: FlowableCollect.java */
    static final class a<T, U> extends h.a.y0.i.f<U> implements h.a.q<T> {
        private static final long serialVersionUID = -3589550218733891694L;
        final h.a.x0.b<? super U, ? super T> collector;
        boolean done;
        j.d.d s;
        final U u;

        a(j.d.c<? super U> cVar, U u, h.a.x0.b<? super U, ? super T> bVar) {
            super(cVar);
            this.collector = bVar;
            this.u = u;
        }

        @Override // h.a.y0.i.f, j.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            complete(this.u);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.collector.a(this.u, t);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public s(h.a.l<T> lVar, Callable<? extends U> callable, h.a.x0.b<? super U, ? super T> bVar) {
        super(lVar);
        this.f10955c = callable;
        this.f10956d = bVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super U> cVar) {
        try {
            this.f10561b.a((h.a.q) new a(cVar, h.a.y0.b.b.a(this.f10955c.call(), "The initial value supplied is null"), this.f10956d));
        } catch (Throwable th) {
            h.a.y0.i.g.error(th, cVar);
        }
    }
}
