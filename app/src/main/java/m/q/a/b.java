package m.q.a;

import h.a.b0;
import h.a.i0;
import m.m;

/* JADX INFO: compiled from: CallEnqueueObservable.java */
/* JADX INFO: loaded from: classes2.dex */
final class b<T> extends b0<m<T>> {
    private final m.b<T> a;

    /* JADX INFO: compiled from: CallEnqueueObservable.java */
    private static final class a<T> implements h.a.u0.c, m.d<T> {
        private final m.b<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final i0<? super m<T>> f12792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile boolean f12793c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f12794d = false;

        a(m.b<?> bVar, i0<? super m<T>> i0Var) {
            this.a = bVar;
            this.f12792b = i0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f12793c = true;
            this.a.cancel();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f12793c;
        }

        @Override // m.d
        public void onFailure(m.b<T> bVar, Throwable th) {
            if (bVar.isCanceled()) {
                return;
            }
            try {
                this.f12792b.onError(th);
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                h.a.c1.a.b(new h.a.v0.a(th, th2));
            }
        }

        @Override // m.d
        public void onResponse(m.b<T> bVar, m<T> mVar) {
            if (this.f12793c) {
                return;
            }
            try {
                this.f12792b.onNext(mVar);
                if (this.f12793c) {
                    return;
                }
                this.f12794d = true;
                this.f12792b.onComplete();
            } catch (Throwable th) {
                if (this.f12794d) {
                    h.a.c1.a.b(th);
                    return;
                }
                if (this.f12793c) {
                    return;
                }
                try {
                    this.f12792b.onError(th);
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    h.a.c1.a.b(new h.a.v0.a(th, th2));
                }
            }
        }
    }

    b(m.b<T> bVar) {
        this.a = bVar;
    }

    @Override // h.a.b0
    protected void d(i0<? super m<T>> i0Var) {
        m.b<T> bVarClone = this.a.clone();
        a aVar = new a(bVarClone, i0Var);
        i0Var.onSubscribe(aVar);
        bVarClone.a(aVar);
    }
}
