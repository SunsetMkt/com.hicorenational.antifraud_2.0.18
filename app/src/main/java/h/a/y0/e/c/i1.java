package h.a.y0.e.c;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeTimeoutPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i1<T, U> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<U> f11144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.y<? extends T> f11145c;

    /* JADX INFO: compiled from: MaybeTimeoutPublisher.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.v<T> {
        private static final long serialVersionUID = 8663801314800248617L;
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

    /* JADX INFO: compiled from: MaybeTimeoutPublisher.java */
    static final class b<T, U> extends AtomicReference<h.a.u0.c> implements h.a.v<T>, h.a.u0.c {
        private static final long serialVersionUID = -5955289211445418871L;
        final h.a.v<? super T> actual;
        final h.a.y<? extends T> fallback;
        final c<T, U> other = new c<>(this);
        final a<T> otherObserver;

        b(h.a.v<? super T> vVar, h.a.y<? extends T> yVar) {
            this.actual = vVar;
            this.fallback = yVar;
            this.otherObserver = yVar != null ? new a<>(vVar) : null;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
            h.a.y0.i.j.cancel(this.other);
            a<T> aVar = this.otherObserver;
            if (aVar != null) {
                h.a.y0.a.d.dispose(aVar);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.v
        public void onComplete() {
            h.a.y0.i.j.cancel(this.other);
            if (getAndSet(h.a.y0.a.d.DISPOSED) != h.a.y0.a.d.DISPOSED) {
                this.actual.onComplete();
            }
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            h.a.y0.i.j.cancel(this.other);
            if (getAndSet(h.a.y0.a.d.DISPOSED) != h.a.y0.a.d.DISPOSED) {
                this.actual.onError(th);
            } else {
                h.a.c1.a.b(th);
            }
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            h.a.y0.i.j.cancel(this.other);
            if (getAndSet(h.a.y0.a.d.DISPOSED) != h.a.y0.a.d.DISPOSED) {
                this.actual.onSuccess(t);
            }
        }

        public void otherComplete() {
            if (h.a.y0.a.d.dispose(this)) {
                h.a.y<? extends T> yVar = this.fallback;
                if (yVar == null) {
                    this.actual.onError(new TimeoutException());
                } else {
                    yVar.a(this.otherObserver);
                }
            }
        }

        public void otherError(Throwable th) {
            if (h.a.y0.a.d.dispose(this)) {
                this.actual.onError(th);
            } else {
                h.a.c1.a.b(th);
            }
        }
    }

    /* JADX INFO: compiled from: MaybeTimeoutPublisher.java */
    static final class c<T, U> extends AtomicReference<j.d.d> implements h.a.q<Object> {
        private static final long serialVersionUID = 8663801314800248617L;
        final b<T, U> parent;

        c(b<T, U> bVar) {
            this.parent = bVar;
        }

        @Override // j.d.c
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.parent.otherError(th);
        }

        @Override // j.d.c
        public void onNext(Object obj) {
            get().cancel();
            this.parent.otherComplete();
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public i1(h.a.y<T> yVar, j.d.b<U> bVar, h.a.y<? extends T> yVar2) {
        super(yVar);
        this.f11144b = bVar;
        this.f11145c = yVar2;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        b bVar = new b(vVar, this.f11145c);
        vVar.onSubscribe(bVar);
        this.f11144b.subscribe(bVar.other);
        this.a.a(bVar);
    }
}
