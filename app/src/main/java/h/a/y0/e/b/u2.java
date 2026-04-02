package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: FlowableRepeat.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u2<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f11011c;

    /* JADX INFO: compiled from: FlowableRepeat.java */
    static final class a<T> extends AtomicInteger implements h.a.q<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final j.d.c<? super T> actual;
        long remaining;
        final h.a.y0.i.i sa;
        final j.d.b<? extends T> source;

        a(j.d.c<? super T> cVar, long j2, h.a.y0.i.i iVar, j.d.b<? extends T> bVar) {
            this.actual = cVar;
            this.sa = iVar;
            this.source = bVar;
            this.remaining = j2;
        }

        @Override // j.d.c
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

        @Override // j.d.c
        public void onError(Throwable th) {
            this.actual.onError(th);
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

    public u2(h.a.l<T> lVar, long j2) {
        super(lVar);
        this.f11011c = j2;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        h.a.y0.i.i iVar = new h.a.y0.i.i();
        cVar.onSubscribe(iVar);
        long j2 = this.f11011c;
        long j3 = i.q2.t.m0.f12222b;
        if (j2 != i.q2.t.m0.f12222b) {
            j3 = j2 - 1;
        }
        new a(cVar, j3, iVar, this.f10561b).subscribeNext();
    }
}
