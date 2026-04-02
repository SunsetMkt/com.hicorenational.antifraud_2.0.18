package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableWithLatestFrom.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d4<T, U, R> extends h.a.y0.e.d.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.c<? super T, ? super U, ? extends R> f11306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.g0<? extends U> f11307c;

    /* JADX INFO: compiled from: ObservableWithLatestFrom.java */
    final class a implements h.a.i0<U> {
        private final b<T, U, R> a;

        a(b<T, U, R> bVar) {
            this.a = bVar;
        }

        @Override // h.a.i0
        public void onComplete() {
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.a.otherError(th);
        }

        @Override // h.a.i0
        public void onNext(U u) {
            this.a.lazySet(u);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.setOther(cVar);
        }
    }

    /* JADX INFO: compiled from: ObservableWithLatestFrom.java */
    static final class b<T, U, R> extends AtomicReference<U> implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = -312246233408980075L;
        final h.a.i0<? super R> actual;
        final h.a.x0.c<? super T, ? super U, ? extends R> combiner;
        final AtomicReference<h.a.u0.c> s = new AtomicReference<>();
        final AtomicReference<h.a.u0.c> other = new AtomicReference<>();

        b(h.a.i0<? super R> i0Var, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
            this.actual = i0Var;
            this.combiner = cVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this.s);
            h.a.y0.a.d.dispose(this.other);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(this.s.get());
        }

        @Override // h.a.i0
        public void onComplete() {
            h.a.y0.a.d.dispose(this.other);
            this.actual.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            h.a.y0.a.d.dispose(this.other);
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.actual.onNext(h.a.y0.b.b.a(this.combiner.apply(t, u), "The combiner returned a null value"));
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    dispose();
                    this.actual.onError(th);
                }
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this.s, cVar);
        }

        public void otherError(Throwable th) {
            h.a.y0.a.d.dispose(this.s);
            this.actual.onError(th);
        }

        public boolean setOther(h.a.u0.c cVar) {
            return h.a.y0.a.d.setOnce(this.other, cVar);
        }
    }

    public d4(h.a.g0<T> g0Var, h.a.x0.c<? super T, ? super U, ? extends R> cVar, h.a.g0<? extends U> g0Var2) {
        super(g0Var);
        this.f11306b = cVar;
        this.f11307c = g0Var2;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super R> i0Var) {
        h.a.a1.m mVar = new h.a.a1.m(i0Var);
        b bVar = new b(mVar, this.f11306b);
        mVar.onSubscribe(bVar);
        this.f11307c.subscribe(new a(bVar));
        this.a.subscribe(bVar);
    }
}
