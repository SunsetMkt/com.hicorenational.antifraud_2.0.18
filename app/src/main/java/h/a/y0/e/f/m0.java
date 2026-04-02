package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleSubscribeOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m0<T> extends h.a.k0<T> {
    final h.a.q0<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.j0 f11860b;

    /* JADX INFO: compiled from: SingleSubscribeOn.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.n0<T>, h.a.u0.c, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final h.a.n0<? super T> actual;
        final h.a.q0<? extends T> source;
        final h.a.y0.a.k task = new h.a.y0.a.k();

        a(h.a.n0<? super T> n0Var, h.a.q0<? extends T> q0Var) {
            this.actual = n0Var;
            this.source = q0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
            this.task.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.a(this);
        }
    }

    public m0(h.a.q0<? extends T> q0Var, h.a.j0 j0Var) {
        this.a = q0Var;
        this.f11860b = j0Var;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        a aVar = new a(n0Var, this.a);
        n0Var.onSubscribe(aVar);
        aVar.task.replace(this.f11860b.a(aVar));
    }
}
