package h.a.y0.e.d;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: ObservableSkipLast.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b3<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f11250b;

    /* JADX INFO: compiled from: ObservableSkipLast.java */
    static final class a<T> extends ArrayDeque<T> implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = -3807491841935125653L;
        final h.a.i0<? super T> actual;
        h.a.u0.c s;
        final int skip;

        a(h.a.i0<? super T> i0Var, int i2) {
            super(i2);
            this.actual = i0Var;
            this.skip = i2;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.s.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.skip == size()) {
                this.actual.onNext(poll());
            }
            offer(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public b3(h.a.g0<T> g0Var, int i2) {
        super(g0Var);
        this.f11250b = i2;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11250b));
    }
}
