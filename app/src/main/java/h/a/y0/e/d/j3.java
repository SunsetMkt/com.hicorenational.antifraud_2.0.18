package h.a.y0.e.d;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: ObservableTakeLast.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j3<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f11439b;

    /* JADX INFO: compiled from: ObservableTakeLast.java */
    static final class a<T> extends ArrayDeque<T> implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = 7240042530241604978L;
        final h.a.i0<? super T> actual;
        volatile boolean cancelled;
        final int count;
        h.a.u0.c s;

        a(h.a.i0<? super T> i0Var, int i2) {
            this.actual = i0Var;
            this.count = i2;
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // h.a.i0
        public void onComplete() {
            h.a.i0<? super T> i0Var = this.actual;
            while (!this.cancelled) {
                T tPoll = poll();
                if (tPoll == null) {
                    if (this.cancelled) {
                        return;
                    }
                    i0Var.onComplete();
                    return;
                }
                i0Var.onNext(tPoll);
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.count == size()) {
                poll();
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

    public j3(h.a.g0<T> g0Var, int i2) {
        super(g0Var);
        this.f11439b = i2;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11439b));
    }
}
