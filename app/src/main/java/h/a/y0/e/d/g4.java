package h.a.y0.e.d;

import java.util.Iterator;

/* JADX INFO: compiled from: ObservableZipIterable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g4<T, U, V> extends h.a.b0<V> {
    final h.a.b0<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable<U> f11384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.c<? super T, ? super U, ? extends V> f11385c;

    /* JADX INFO: compiled from: ObservableZipIterable.java */
    static final class a<T, U, V> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super V> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Iterator<U> f11386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final h.a.x0.c<? super T, ? super U, ? extends V> f11387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f11389e;

        a(h.a.i0<? super V> i0Var, Iterator<U> it, h.a.x0.c<? super T, ? super U, ? extends V> cVar) {
            this.a = i0Var;
            this.f11386b = it;
            this.f11387c = cVar;
        }

        void a(Throwable th) {
            this.f11389e = true;
            this.f11388d.dispose();
            this.a.onError(th);
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11388d.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11388d.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11389e) {
                return;
            }
            this.f11389e = true;
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11389e) {
                h.a.c1.a.b(th);
            } else {
                this.f11389e = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11389e) {
                return;
            }
            try {
                try {
                    this.a.onNext(h.a.y0.b.b.a(this.f11387c.apply(t, h.a.y0.b.b.a(this.f11386b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.f11386b.hasNext()) {
                            return;
                        }
                        this.f11389e = true;
                        this.f11388d.dispose();
                        this.a.onComplete();
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        a(th);
                    }
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    a(th2);
                }
            } catch (Throwable th3) {
                h.a.v0.b.b(th3);
                a(th3);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11388d, cVar)) {
                this.f11388d = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public g4(h.a.b0<? extends T> b0Var, Iterable<U> iterable, h.a.x0.c<? super T, ? super U, ? extends V> cVar) {
        this.a = b0Var;
        this.f11384b = iterable;
        this.f11385c = cVar;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super V> i0Var) {
        try {
            Iterator it = (Iterator) h.a.y0.b.b.a(this.f11384b.iterator(), "The iterator returned by other is null");
            try {
                if (it.hasNext()) {
                    this.a.subscribe(new a(i0Var, it, this.f11385c));
                } else {
                    h.a.y0.a.e.complete(i0Var);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.y0.a.e.error(th, i0Var);
            }
        } catch (Throwable th2) {
            h.a.v0.b.b(th2);
            h.a.y0.a.e.error(th2, i0Var);
        }
    }
}
