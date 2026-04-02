package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableRepeatWhen.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w2<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super h.a.l<Object>, ? extends j.d.b<?>> f11034c;

    /* JADX INFO: compiled from: FlowableRepeatWhen.java */
    static final class a<T> extends c<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        a(j.d.c<? super T> cVar, h.a.d1.c<Object> cVar2, j.d.d dVar) {
            super(cVar, cVar2, dVar);
        }

        @Override // j.d.c
        public void onComplete() {
            again(0);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.f11035receiver.cancel();
            ((c) this).actual.onError(th);
        }
    }

    /* JADX INFO: compiled from: FlowableRepeatWhen.java */
    static final class b<T, U> extends AtomicInteger implements h.a.q<Object>, j.d.d {
        private static final long serialVersionUID = 2827772011130406689L;
        final j.d.b<T> source;
        c<T, U> subscriber;
        final AtomicReference<j.d.d> subscription = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        b(j.d.b<T> bVar) {
            this.source = bVar;
        }

        @Override // j.d.d
        public void cancel() {
            h.a.y0.i.j.cancel(this.subscription);
        }

        @Override // j.d.c
        public void onComplete() {
            this.subscriber.cancel();
            this.subscriber.actual.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.subscriber.cancel();
            this.subscriber.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(Object obj) {
            if (getAndIncrement() == 0) {
                while (!h.a.y0.i.j.isCancelled(this.subscription.get())) {
                    this.source.subscribe(this.subscriber);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            h.a.y0.i.j.deferredSetOnce(this.subscription, this.requested, dVar);
        }

        @Override // j.d.d
        public void request(long j2) {
            h.a.y0.i.j.deferredRequest(this.subscription, this.requested, j2);
        }
    }

    /* JADX INFO: compiled from: FlowableRepeatWhen.java */
    static abstract class c<T, U> extends h.a.y0.i.i implements h.a.q<T> {
        private static final long serialVersionUID = -5604623027276966720L;
        protected final j.d.c<? super T> actual;
        protected final h.a.d1.c<U> processor;
        private long produced;

        /* JADX INFO: renamed from: receiver, reason: collision with root package name */
        protected final j.d.d f11035receiver;

        c(j.d.c<? super T> cVar, h.a.d1.c<U> cVar2, j.d.d dVar) {
            this.actual = cVar;
            this.processor = cVar2;
            this.f11035receiver = dVar;
        }

        protected final void again(U u) {
            long j2 = this.produced;
            if (j2 != 0) {
                this.produced = 0L;
                produced(j2);
            }
            this.f11035receiver.request(1L);
            this.processor.onNext(u);
        }

        @Override // h.a.y0.i.i, j.d.d
        public final void cancel() {
            super.cancel();
            this.f11035receiver.cancel();
        }

        @Override // j.d.c
        public final void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        @Override // h.a.q
        public final void onSubscribe(j.d.d dVar) {
            setSubscription(dVar);
        }
    }

    public w2(h.a.l<T> lVar, h.a.x0.o<? super h.a.l<Object>, ? extends j.d.b<?>> oVar) {
        super(lVar);
        this.f11034c = oVar;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        h.a.g1.e eVar = new h.a.g1.e(cVar);
        h.a.d1.c<T> cVarX = h.a.d1.g.m(8).X();
        try {
            j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.f11034c.apply(cVarX), "handler returned a null Publisher");
            b bVar2 = new b(this.f10561b);
            a aVar = new a(eVar, cVarX, bVar2);
            bVar2.subscriber = aVar;
            cVar.onSubscribe(aVar);
            bVar.subscribe(bVar2);
            bVar2.onNext(0);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.i.g.error(th, cVar);
        }
    }
}
