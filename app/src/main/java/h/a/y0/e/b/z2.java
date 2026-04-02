package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: FlowableRetryPredicate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z2<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.r<? super Throwable> f11087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f11088d;

    /* JADX INFO: compiled from: FlowableRetryPredicate.java */
    static final class a<T> extends AtomicInteger implements h.a.q<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final j.d.c<? super T> actual;
        final h.a.x0.r<? super Throwable> predicate;
        long remaining;
        final h.a.y0.i.i sa;
        final j.d.b<? extends T> source;

        a(j.d.c<? super T> cVar, long j2, h.a.x0.r<? super Throwable> rVar, h.a.y0.i.i iVar, j.d.b<? extends T> bVar) {
            this.actual = cVar;
            this.sa = iVar;
            this.source = bVar;
            this.predicate = rVar;
            this.remaining = j2;
        }

        @Override // j.d.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // j.d.c
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

        @Override // j.d.c
        public void onNext(T t) {
            this.actual.onNext(t);
            this.sa.produced(1L);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            this.sa.setSubscription(dVar);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.sa.isCancelled()) {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }
    }

    public z2(h.a.l<T> lVar, long j2, h.a.x0.r<? super Throwable> rVar) {
        super(lVar);
        this.f11087c = rVar;
        this.f11088d = j2;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        h.a.y0.i.i iVar = new h.a.y0.i.i();
        cVar.onSubscribe(iVar);
        new a(cVar, this.f11088d, this.f11087c, iVar, this.f10561b).subscribeNext();
    }
}
