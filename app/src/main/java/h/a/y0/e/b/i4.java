package h.a.y0.e.b;

import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FlowableToListSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i4<T, U extends Collection<? super T>> extends h.a.k0<U> implements h.a.y0.c.b<U> {
    final h.a.l<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<U> f10707b;

    /* JADX INFO: compiled from: FlowableToListSingle.java */
    static final class a<T, U extends Collection<? super T>> implements h.a.q<T>, h.a.u0.c {
        final h.a.n0<? super U> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        j.d.d f10708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        U f10709c;

        a(h.a.n0<? super U> n0Var, U u) {
            this.a = n0Var;
            this.f10709c = u;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10708b.cancel();
            this.f10708b = h.a.y0.i.j.CANCELLED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10708b == h.a.y0.i.j.CANCELLED;
        }

        @Override // j.d.c
        public void onComplete() {
            this.f10708b = h.a.y0.i.j.CANCELLED;
            this.a.onSuccess(this.f10709c);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.f10709c = null;
            this.f10708b = h.a.y0.i.j.CANCELLED;
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.f10709c.add(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10708b, dVar)) {
                this.f10708b = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public i4(h.a.l<T> lVar) {
        this(lVar, h.a.y0.j.b.asCallable());
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super U> n0Var) {
        try {
            this.a.a((h.a.q) new a(n0Var, (Collection) h.a.y0.b.b.a(this.f10707b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, n0Var);
        }
    }

    public i4(h.a.l<T> lVar, Callable<U> callable) {
        this.a = lVar;
        this.f10707b = callable;
    }

    @Override // h.a.y0.c.b
    public h.a.l<U> b() {
        return h.a.c1.a.a(new h4(this.a, this.f10707b));
    }
}
