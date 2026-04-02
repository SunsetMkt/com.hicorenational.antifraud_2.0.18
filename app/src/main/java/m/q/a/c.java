package m.q.a;

import h.a.b0;
import h.a.i0;
import m.m;

/* JADX INFO: compiled from: CallExecuteObservable.java */
/* JADX INFO: loaded from: classes2.dex */
final class c<T> extends b0<m<T>> {
    private final m.b<T> a;

    /* JADX INFO: compiled from: CallExecuteObservable.java */
    private static final class a implements h.a.u0.c {
        private final m.b<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile boolean f12795b;

        a(m.b<?> bVar) {
            this.a = bVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f12795b = true;
            this.a.cancel();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f12795b;
        }
    }

    c(m.b<T> bVar) {
        this.a = bVar;
    }

    @Override // h.a.b0
    protected void d(i0<? super m<T>> i0Var) {
        boolean z;
        m.b<T> bVarClone = this.a.clone();
        a aVar = new a(bVarClone);
        i0Var.onSubscribe(aVar);
        try {
            m<T> mVarExecute = bVarClone.execute();
            if (!aVar.isDisposed()) {
                i0Var.onNext(mVarExecute);
            }
            if (aVar.isDisposed()) {
                return;
            }
            try {
                i0Var.onComplete();
            } catch (Throwable th) {
                th = th;
                z = true;
                h.a.v0.b.b(th);
                if (z) {
                    h.a.c1.a.b(th);
                    return;
                }
                if (aVar.isDisposed()) {
                    return;
                }
                try {
                    i0Var.onError(th);
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    h.a.c1.a.b(new h.a.v0.a(th, th2));
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }
}
