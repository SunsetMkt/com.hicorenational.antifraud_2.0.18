package m.q.a;

import h.a.b0;
import h.a.i0;
import m.m;

/* JADX INFO: compiled from: BodyObservable.java */
/* JADX INFO: loaded from: classes2.dex */
final class a<T> extends b0<T> {
    private final b0<m<T>> a;

    /* JADX INFO: renamed from: m.q.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BodyObservable.java */
    private static class C0274a<R> implements i0<m<R>> {
        private final i0<? super R> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f12791b;

        C0274a(i0<? super R> i0Var) {
            this.a = i0Var;
        }

        @Override // h.a.i0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(m<R> mVar) {
            if (mVar.e()) {
                this.a.onNext(mVar.a());
                return;
            }
            this.f12791b = true;
            d dVar = new d(mVar);
            try {
                this.a.onError(dVar);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(new h.a.v0.a(dVar, th));
            }
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f12791b) {
                return;
            }
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (!this.f12791b) {
                this.a.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            h.a.c1.a.b(assertionError);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.onSubscribe(cVar);
        }
    }

    a(b0<m<T>> b0Var) {
        this.a = b0Var;
    }

    @Override // h.a.b0
    protected void d(i0<? super T> i0Var) {
        this.a.subscribe(new C0274a(i0Var));
    }
}
