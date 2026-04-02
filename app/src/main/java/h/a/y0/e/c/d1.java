package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeSwitchIfEmpty.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d1<T> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.y<? extends T> f11123b;

    /* JADX INFO: compiled from: MaybeSwitchIfEmpty.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.v<T>, h.a.u0.c {
        private static final long serialVersionUID = -2223459372976438024L;
        final h.a.v<? super T> actual;
        final h.a.y<? extends T> other;

        /* JADX INFO: renamed from: h.a.y0.e.c.d1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MaybeSwitchIfEmpty.java */
        static final class C0202a<T> implements h.a.v<T> {
            final h.a.v<? super T> a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final AtomicReference<h.a.u0.c> f11124b;

            C0202a(h.a.v<? super T> vVar, AtomicReference<h.a.u0.c> atomicReference) {
                this.a = vVar;
                this.f11124b = atomicReference;
            }

            @Override // h.a.v
            public void onComplete() {
                this.a.onComplete();
            }

            @Override // h.a.v
            public void onError(Throwable th) {
                this.a.onError(th);
            }

            @Override // h.a.v
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.setOnce(this.f11124b, cVar);
            }

            @Override // h.a.v, h.a.n0
            public void onSuccess(T t) {
                this.a.onSuccess(t);
            }
        }

        a(h.a.v<? super T> vVar, h.a.y<? extends T> yVar) {
            this.actual = vVar;
            this.other = yVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.v
        public void onComplete() {
            h.a.u0.c cVar = get();
            if (cVar == h.a.y0.a.d.DISPOSED || !compareAndSet(cVar, null)) {
                return;
            }
            this.other.a(new C0202a(this.actual, this));
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    public d1(h.a.y<T> yVar, h.a.y<? extends T> yVar2) {
        super(yVar);
        this.f11123b = yVar2;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a(new a(vVar, this.f11123b));
    }
}
