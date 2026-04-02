package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeDelaySubscriptionOtherPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n<T, U> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<U> f11161b;

    /* JADX INFO: compiled from: MaybeDelaySubscriptionOtherPublisher.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.v<T> {
        private static final long serialVersionUID = 706635022205076709L;
        final h.a.v<? super T> actual;

        a(h.a.v<? super T> vVar) {
            this.actual = vVar;
        }

        @Override // h.a.v
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    /* JADX INFO: compiled from: MaybeDelaySubscriptionOtherPublisher.java */
    static final class b<T> implements h.a.q<Object>, h.a.u0.c {
        final a<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.y<T> f11162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        j.d.d f11163c;

        b(h.a.v<? super T> vVar, h.a.y<T> yVar) {
            this.a = new a<>(vVar);
            this.f11162b = yVar;
        }

        void a() {
            h.a.y<T> yVar = this.f11162b;
            this.f11162b = null;
            yVar.a(this.a);
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11163c.cancel();
            this.f11163c = h.a.y0.i.j.CANCELLED;
            h.a.y0.a.d.dispose(this.a);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(this.a.get());
        }

        @Override // j.d.c
        public void onComplete() {
            j.d.d dVar = this.f11163c;
            h.a.y0.i.j jVar = h.a.y0.i.j.CANCELLED;
            if (dVar != jVar) {
                this.f11163c = jVar;
                a();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            j.d.d dVar = this.f11163c;
            h.a.y0.i.j jVar = h.a.y0.i.j.CANCELLED;
            if (dVar == jVar) {
                h.a.c1.a.b(th);
            } else {
                this.f11163c = jVar;
                this.a.actual.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(Object obj) {
            j.d.d dVar = this.f11163c;
            if (dVar != h.a.y0.i.j.CANCELLED) {
                dVar.cancel();
                this.f11163c = h.a.y0.i.j.CANCELLED;
                a();
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11163c, dVar)) {
                this.f11163c = dVar;
                this.a.actual.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public n(h.a.y<T> yVar, j.d.b<U> bVar) {
        super(yVar);
        this.f11161b = bVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.f11161b.subscribe(new b(vVar, this.a));
    }
}
