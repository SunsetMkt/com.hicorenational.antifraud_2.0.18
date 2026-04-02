package m.q.a;

import h.a.b0;
import h.a.i0;
import m.m;

/* JADX INFO: compiled from: ResultObservable.java */
/* JADX INFO: loaded from: classes2.dex */
final class f<T> extends b0<e<T>> {
    private final b0<m<T>> a;

    /* JADX INFO: compiled from: ResultObservable.java */
    private static class a<R> implements i0<m<R>> {
        private final i0<? super e<R>> a;

        a(i0<? super e<R>> i0Var) {
            this.a = i0Var;
        }

        @Override // h.a.i0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(m<R> mVar) {
            this.a.onNext(e.a(mVar));
        }

        @Override // h.a.i0
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            try {
                this.a.onNext(e.a(th));
                this.a.onComplete();
            } catch (Throwable th2) {
                try {
                    this.a.onError(th2);
                } catch (Throwable th3) {
                    h.a.v0.b.b(th3);
                    h.a.c1.a.b(new h.a.v0.a(th2, th3));
                }
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.onSubscribe(cVar);
        }
    }

    f(b0<m<T>> b0Var) {
        this.a = b0Var;
    }

    @Override // h.a.b0
    protected void d(i0<? super e<T>> i0Var) {
        this.a.subscribe(new a(i0Var));
    }
}
