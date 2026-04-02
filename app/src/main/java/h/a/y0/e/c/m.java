package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeDelayOtherPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m<T, U> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<U> f11157b;

    /* JADX INFO: compiled from: MaybeDelayOtherPublisher.java */
    static final class a<T, U> implements h.a.v<T>, h.a.u0.c {
        final b<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final j.d.b<U> f11158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11159c;

        a(h.a.v<? super T> vVar, j.d.b<U> bVar) {
            this.a = new b<>(vVar);
            this.f11158b = bVar;
        }

        void a() {
            this.f11158b.subscribe(this.a);
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11159c.dispose();
            this.f11159c = h.a.y0.a.d.DISPOSED;
            h.a.y0.i.j.cancel(this.a);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.i.j.isCancelled(this.a.get());
        }

        @Override // h.a.v
        public void onComplete() {
            this.f11159c = h.a.y0.a.d.DISPOSED;
            a();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.f11159c = h.a.y0.a.d.DISPOSED;
            this.a.error = th;
            a();
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11159c, cVar)) {
                this.f11159c = cVar;
                this.a.actual.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.f11159c = h.a.y0.a.d.DISPOSED;
            this.a.value = t;
            a();
        }
    }

    /* JADX INFO: compiled from: MaybeDelayOtherPublisher.java */
    static final class b<T> extends AtomicReference<j.d.d> implements h.a.q<Object> {
        private static final long serialVersionUID = -1215060610805418006L;
        final h.a.v<? super T> actual;
        Throwable error;
        T value;

        b(h.a.v<? super T> vVar) {
            this.actual = vVar;
        }

        @Override // j.d.c
        public void onComplete() {
            Throwable th = this.error;
            if (th != null) {
                this.actual.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                this.actual.onSuccess(t);
            } else {
                this.actual.onComplete();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            Throwable th2 = this.error;
            if (th2 == null) {
                this.actual.onError(th);
            } else {
                this.actual.onError(new h.a.v0.a(th2, th));
            }
        }

        @Override // j.d.c
        public void onNext(Object obj) {
            j.d.d dVar = get();
            h.a.y0.i.j jVar = h.a.y0.i.j.CANCELLED;
            if (dVar != jVar) {
                lazySet(jVar);
                dVar.cancel();
                onComplete();
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public m(h.a.y<T> yVar, j.d.b<U> bVar) {
        super(yVar);
        this.f11157b = bVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a(new a(vVar, this.f11157b));
    }
}
