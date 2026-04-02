package h.a.y0.e.a;

import h.a.q0;

/* JADX INFO: compiled from: CompletableFromSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u<T> extends h.a.c {
    final q0<T> a;

    /* JADX INFO: compiled from: CompletableFromSingle.java */
    static final class a<T> implements h.a.n0<T> {
        final h.a.f a;

        a(h.a.f fVar) {
            this.a = fVar;
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.onSubscribe(cVar);
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.a.onComplete();
        }
    }

    public u(q0<T> q0Var) {
        this.a = q0Var;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.a(new a(fVar));
    }
}
