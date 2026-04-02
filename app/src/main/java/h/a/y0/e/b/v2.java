package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: FlowableRepeatUntil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v2<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.e f11022c;

    /* JADX INFO: compiled from: FlowableRepeatUntil.java */
    static final class a<T> extends AtomicInteger implements h.a.q<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final j.d.c<? super T> actual;
        final h.a.y0.i.i sa;
        final j.d.b<? extends T> source;
        final h.a.x0.e stop;

        a(j.d.c<? super T> cVar, h.a.x0.e eVar, h.a.y0.i.i iVar, j.d.b<? extends T> bVar) {
            this.actual = cVar;
            this.sa = iVar;
            this.source = bVar;
            this.stop = eVar;
        }

        @Override // j.d.c
        public void onComplete() {
            try {
                if (this.stop.getAsBoolean()) {
                    this.actual.onComplete();
                } else {
                    subscribeNext();
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.actual.onError(th);
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
                do {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                } while (iAddAndGet != 0);
            }
        }
    }

    public v2(h.a.l<T> lVar, h.a.x0.e eVar) {
        super(lVar);
        this.f11022c = eVar;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        h.a.y0.i.i iVar = new h.a.y0.i.i();
        cVar.onSubscribe(iVar);
        new a(cVar, this.f11022c, iVar, this.f10561b).subscribeNext();
    }
}
