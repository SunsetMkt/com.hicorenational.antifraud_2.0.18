package h.a.y0.e.d;

import java.util.Iterator;

/* JADX INFO: compiled from: ObservableFlattenIterable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z0<T, R> extends h.a.y0.e.d.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends Iterable<? extends R>> f11725b;

    /* JADX INFO: compiled from: ObservableFlattenIterable.java */
    static final class a<T, R> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super R> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.o<? super T, ? extends Iterable<? extends R>> f11726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11727c;

        a(h.a.i0<? super R> i0Var, h.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
            this.a = i0Var;
            this.f11726b = oVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11727c.dispose();
            this.f11727c = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11727c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            h.a.u0.c cVar = this.f11727c;
            h.a.y0.a.d dVar = h.a.y0.a.d.DISPOSED;
            if (cVar == dVar) {
                return;
            }
            this.f11727c = dVar;
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            h.a.u0.c cVar = this.f11727c;
            h.a.y0.a.d dVar = h.a.y0.a.d.DISPOSED;
            if (cVar == dVar) {
                h.a.c1.a.b(th);
            } else {
                this.f11727c = dVar;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11727c == h.a.y0.a.d.DISPOSED) {
                return;
            }
            try {
                Iterator<? extends R> it = this.f11726b.apply(t).iterator();
                h.a.i0<? super R> i0Var = this.a;
                while (it.hasNext()) {
                    try {
                        try {
                            i0Var.onNext((Object) h.a.y0.b.b.a(it.next(), "The iterator returned a null value"));
                        } catch (Throwable th) {
                            h.a.v0.b.b(th);
                            this.f11727c.dispose();
                            onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        h.a.v0.b.b(th2);
                        this.f11727c.dispose();
                        onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                h.a.v0.b.b(th3);
                this.f11727c.dispose();
                onError(th3);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11727c, cVar)) {
                this.f11727c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public z0(h.a.g0<T> g0Var, h.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
        super(g0Var);
        this.f11725b = oVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super R> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11725b));
    }
}
