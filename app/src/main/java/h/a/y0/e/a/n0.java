package h.a.y0.e.a;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CompletableToSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n0<T> extends h.a.k0<T> {
    final h.a.i a;

    /* JADX INFO: renamed from: b */
    final Callable<? extends T> f10549b;

    /* JADX INFO: renamed from: c */
    final T f10550c;

    /* JADX INFO: compiled from: CompletableToSingle.java */
    final class a implements h.a.f {
        private final h.a.n0<? super T> a;

        a(h.a.n0<? super T> n0Var) {
            this.a = n0Var;
        }

        @Override // h.a.f
        public void onComplete() {
            T tCall;
            n0 n0Var = n0.this;
            Callable<? extends T> callable = n0Var.f10549b;
            if (callable != null) {
                try {
                    tCall = callable.call();
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.a.onError(th);
                    return;
                }
            } else {
                tCall = n0Var.f10550c;
            }
            if (tCall == null) {
                this.a.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.a.onSuccess(tCall);
            }
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.onSubscribe(cVar);
        }
    }

    public n0(h.a.i iVar, Callable<? extends T> callable, T t) {
        this.a = iVar;
        this.f10550c = t;
        this.f10549b = callable;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var));
    }
}
