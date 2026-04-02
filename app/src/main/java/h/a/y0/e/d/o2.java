package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ObservableRetryPredicate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o2<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.r<? super Throwable> f11539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f11540c;

    /* JADX INFO: compiled from: ObservableRetryPredicate.java */
    static final class a<T> extends AtomicInteger implements h.a.i0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final h.a.i0<? super T> actual;
        final h.a.x0.r<? super Throwable> predicate;
        long remaining;
        final h.a.y0.a.k sa;
        final h.a.g0<? extends T> source;

        a(h.a.i0<? super T> i0Var, long j2, h.a.x0.r<? super Throwable> rVar, h.a.y0.a.k kVar, h.a.g0<? extends T> g0Var) {
            this.actual = i0Var;
            this.sa = kVar;
            this.source = g0Var;
            this.predicate = rVar;
            this.remaining = j2;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            long j2 = this.remaining;
            if (j2 != i.q2.t.m0.f12222b) {
                this.remaining = j2 - 1;
            }
            if (j2 == 0) {
                this.actual.onError(th);
                return;
            }
            try {
                if (this.predicate.test(th)) {
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

    public o2(h.a.b0<T> b0Var, long j2, h.a.x0.r<? super Throwable> rVar) {
        super(b0Var);
        this.f11539b = rVar;
        this.f11540c = j2;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        h.a.y0.a.k kVar = new h.a.y0.a.k();
        i0Var.onSubscribe(kVar);
        new a(i0Var, this.f11540c, this.f11539b, kVar, this.a).subscribeNext();
    }
}
