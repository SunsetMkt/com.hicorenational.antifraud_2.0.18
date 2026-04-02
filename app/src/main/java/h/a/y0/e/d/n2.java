package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ObservableRetryBiPredicate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n2<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.d<? super Integer, ? super Throwable> f11516b;

    /* JADX INFO: compiled from: ObservableRetryBiPredicate.java */
    static final class a<T> extends AtomicInteger implements h.a.i0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final h.a.i0<? super T> actual;
        final h.a.x0.d<? super Integer, ? super Throwable> predicate;
        int retries;
        final h.a.y0.a.k sa;
        final h.a.g0<? extends T> source;

        a(h.a.i0<? super T> i0Var, h.a.x0.d<? super Integer, ? super Throwable> dVar, h.a.y0.a.k kVar, h.a.g0<? extends T> g0Var) {
            this.actual = i0Var;
            this.sa = kVar;
            this.source = g0Var;
            this.predicate = dVar;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            try {
                h.a.x0.d<? super Integer, ? super Throwable> dVar = this.predicate;
                int i2 = this.retries + 1;
                this.retries = i2;
                if (dVar.a(Integer.valueOf(i2), th)) {
                    subscribeNext();
                } else {
                    this.actual.onError(th);
                }
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.actual.onError(new h.a.v0.a(th, th2));
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.sa.update(cVar);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.sa.isDisposed()) {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }
    }

    public n2(h.a.b0<T> b0Var, h.a.x0.d<? super Integer, ? super Throwable> dVar) {
        super(b0Var);
        this.f11516b = dVar;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        h.a.y0.a.k kVar = new h.a.y0.a.k();
        i0Var.onSubscribe(kVar);
        new a(i0Var, this.f11516b, kVar, this.a).subscribeNext();
    }
}
