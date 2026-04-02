package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: FlowableRetryBiPredicate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y2<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.d<? super Integer, ? super Throwable> f11074c;

    /* JADX INFO: compiled from: FlowableRetryBiPredicate.java */
    static final class a<T> extends AtomicInteger implements h.a.q<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final j.d.c<? super T> actual;
        final h.a.x0.d<? super Integer, ? super Throwable> predicate;
        int retries;
        final h.a.y0.i.i sa;
        final j.d.b<? extends T> source;

        a(j.d.c<? super T> cVar, h.a.x0.d<? super Integer, ? super Throwable> dVar, h.a.y0.i.i iVar, j.d.b<? extends T> bVar) {
            this.actual = cVar;
            this.sa = iVar;
            this.source = bVar;
            this.predicate = dVar;
        }

        @Override // j.d.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // j.d.c
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

    public y2(h.a.l<T> lVar, h.a.x0.d<? super Integer, ? super Throwable> dVar) {
        super(lVar);
        this.f11074c = dVar;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        h.a.y0.i.i iVar = new h.a.y0.i.i();
        cVar.onSubscribe(iVar);
        new a(cVar, this.f11074c, iVar, this.f10561b).subscribeNext();
    }
}
