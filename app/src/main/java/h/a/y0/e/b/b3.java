package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableSamplePublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b3<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<T> f10580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final j.d.b<?> f10581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f10582d;

    /* JADX INFO: compiled from: FlowableSamplePublisher.java */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        a(j.d.c<? super T> cVar, j.d.b<?> bVar) {
            super(cVar, bVar);
            this.wip = new AtomicInteger();
        }

        @Override // h.a.y0.e.b.b3.c
        void completeMain() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // h.a.y0.e.b.b3.c
        void completeOther() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // h.a.y0.e.b.b3.c
        void run() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z = this.done;
                    emit();
                    if (z) {
                        this.actual.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    /* JADX INFO: compiled from: FlowableSamplePublisher.java */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        b(j.d.c<? super T> cVar, j.d.b<?> bVar) {
            super(cVar, bVar);
        }

        @Override // h.a.y0.e.b.b3.c
        void completeMain() {
            this.actual.onComplete();
        }

        @Override // h.a.y0.e.b.b3.c
        void completeOther() {
            this.actual.onComplete();
        }

        @Override // h.a.y0.e.b.b3.c
        void run() {
            emit();
        }
    }

    /* JADX INFO: compiled from: FlowableSamplePublisher.java */
    static abstract class c<T> extends AtomicReference<T> implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = -3517602651313910099L;
        final j.d.c<? super T> actual;
        j.d.d s;
        final j.d.b<?> sampler;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<j.d.d> other = new AtomicReference<>();

        c(j.d.c<? super T> cVar, j.d.b<?> bVar) {
            this.actual = cVar;
            this.sampler = bVar;
        }

        @Override // j.d.d
        public void cancel() {
            h.a.y0.i.j.cancel(this.other);
            this.s.cancel();
        }

        public void complete() {
            this.s.cancel();
            completeOther();
        }

        abstract void completeMain();

        abstract void completeOther();

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(andSet);
                    h.a.y0.j.d.c(this.requested, 1L);
                } else {
                    cancel();
                    this.actual.onError(new h.a.v0.c("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        public void error(Throwable th) {
            this.s.cancel();
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onComplete() {
            h.a.y0.i.j.cancel(this.other);
            completeMain();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            h.a.y0.i.j.cancel(this.other);
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new d(this));
                    dVar.request(i.q2.t.m0.f12222b);
                }
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
            }
        }

        abstract void run();

        boolean setOther(j.d.d dVar) {
            return h.a.y0.i.j.setOnce(this.other, dVar);
        }
    }

    /* JADX INFO: compiled from: FlowableSamplePublisher.java */
    static final class d<T> implements h.a.q<Object> {
        final c<T> a;

        d(c<T> cVar) {
            this.a = cVar;
        }

        @Override // j.d.c
        public void onComplete() {
            this.a.complete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.a.error(th);
        }

        @Override // j.d.c
        public void onNext(Object obj) {
            this.a.run();
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (this.a.setOther(dVar)) {
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public b3(j.d.b<T> bVar, j.d.b<?> bVar2, boolean z) {
        this.f10580b = bVar;
        this.f10581c = bVar2;
        this.f10582d = z;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        h.a.g1.e eVar = new h.a.g1.e(cVar);
        if (this.f10582d) {
            this.f10580b.subscribe(new a(eVar, this.f10581c));
        } else {
            this.f10580b.subscribe(new b(eVar, this.f10581c));
        }
    }
}
