package h.a.y0.e.d;

import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableDistinct.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i0<T, K> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, K> f11408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable<? extends Collection<? super K>> f11409c;

    /* JADX INFO: compiled from: ObservableDistinct.java */
    static final class a<T, K> extends h.a.y0.d.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Collection<? super K> f11410f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.x0.o<? super T, K> f11411g;

        a(h.a.i0<? super T> i0Var, h.a.x0.o<? super T, K> oVar, Collection<? super K> collection) {
            super(i0Var);
            this.f11411g = oVar;
            this.f11410f = collection;
        }

        @Override // h.a.y0.d.a, h.a.y0.c.o
        public void clear() {
            this.f11410f.clear();
            super.clear();
        }

        @Override // h.a.y0.d.a, h.a.i0
        public void onComplete() {
            if (this.f10463d) {
                return;
            }
            this.f10463d = true;
            this.f11410f.clear();
            this.a.onComplete();
        }

        @Override // h.a.y0.d.a, h.a.i0
        public void onError(Throwable th) {
            if (this.f10463d) {
                h.a.c1.a.b(th);
                return;
            }
            this.f10463d = true;
            this.f11410f.clear();
            this.a.onError(th);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f10463d) {
                return;
            }
            if (this.f10464e != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                if (this.f11410f.add(h.a.y0.b.b.a(this.f11411g.apply(t), "The keySelector returned a null key"))) {
                    this.a.onNext((Object) t);
                }
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            T tPoll;
            do {
                tPoll = this.f10462c.poll();
                if (tPoll == null) {
                    break;
                }
            } while (!this.f11410f.add((Object) h.a.y0.b.b.a(this.f11411g.apply(tPoll), "The keySelector returned a null key")));
            return tPoll;
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public i0(h.a.g0<T> g0Var, h.a.x0.o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        super(g0Var);
        this.f11408b = oVar;
        this.f11409c = callable;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        try {
            this.a.subscribe(new a(i0Var, this.f11408b, (Collection) h.a.y0.b.b.a(this.f11409c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, i0Var);
        }
    }
}
