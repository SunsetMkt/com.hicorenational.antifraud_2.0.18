package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ObservableRepeat.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j2<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11438b;

    /* JADX INFO: compiled from: ObservableRepeat.java */
    static final class a<T> extends AtomicInteger implements h.a.i0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final h.a.i0<? super T> actual;
        long remaining;
        final h.a.y0.a.k sd;
        final h.a.g0<? extends T> source;

        a(h.a.i0<? super T> i0Var, long j2, h.a.y0.a.k kVar, h.a.g0<? extends T> g0Var) {
            this.actual = i0Var;
            this.sd = kVar;
            this.source = g0Var;
            this.remaining = j2;
        }

        @Override // h.a.i0
        public void onComplete() {
            long j2 = this.remaining;
            if (j2 != i.q2.t.m0.f12222b) {
                this.remaining = j2 - 1;
            }
            if (j2 != 0) {
                subscribeNext();
            } else {
                this.actual.onComplete();
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.sd.replace(cVar);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.sd.isDisposed()) {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }
    }

    public j2(h.a.b0<T> b0Var, long j2) {
        super(b0Var);
        this.f11438b = j2;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        h.a.y0.a.k kVar = new h.a.y0.a.k();
        i0Var.onSubscribe(kVar);
        long j2 = this.f11438b;
        long j3 = i.q2.t.m0.f12222b;
        if (j2 != i.q2.t.m0.f12222b) {
            j3 = j2 - 1;
        }
        new a(i0Var, j3, kVar, this.a).subscribeNext();
    }
}
