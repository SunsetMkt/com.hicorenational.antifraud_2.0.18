package h.a.y0.e.b;

import h.a.j0;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableSubscribeOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r3<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.j0 f10949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f10950d;

    /* JADX INFO: compiled from: FlowableSubscribeOn.java */
    static final class a<T> extends AtomicReference<Thread> implements h.a.q<T>, j.d.d, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        final j.d.c<? super T> actual;
        final boolean nonScheduledRequests;
        j.d.b<T> source;
        final j0.c worker;
        final AtomicReference<j.d.d> s = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        /* JADX INFO: renamed from: h.a.y0.e.b.r3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FlowableSubscribeOn.java */
        static final class RunnableC0196a implements Runnable {
            private final j.d.d a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f10951b;

            RunnableC0196a(j.d.d dVar, long j2) {
                this.a = dVar;
                this.f10951b = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.request(this.f10951b);
            }
        }

        a(j.d.c<? super T> cVar, j0.c cVar2, j.d.b<T> bVar, boolean z) {
            this.actual = cVar;
            this.worker = cVar2;
            this.source = bVar;
            this.nonScheduledRequests = !z;
        }

        @Override // j.d.d
        public void cancel() {
            h.a.y0.i.j.cancel(this.s);
            this.worker.dispose();
        }

        @Override // j.d.c
        public void onComplete() {
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this.s, dVar)) {
                long andSet = this.requested.getAndSet(0L);
                if (andSet != 0) {
                    requestUpstream(andSet, dVar);
                }
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                j.d.d dVar = this.s.get();
                if (dVar != null) {
                    requestUpstream(j2, dVar);
                    return;
                }
                h.a.y0.j.d.a(this.requested, j2);
                j.d.d dVar2 = this.s.get();
                if (dVar2 != null) {
                    long andSet = this.requested.getAndSet(0L);
                    if (andSet != 0) {
                        requestUpstream(andSet, dVar2);
                    }
                }
            }
        }

        void requestUpstream(long j2, j.d.d dVar) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                dVar.request(j2);
            } else {
                this.worker.a(new RunnableC0196a(dVar, j2));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            j.d.b<T> bVar = this.source;
            this.source = null;
            bVar.subscribe(this);
        }
    }

    public r3(h.a.l<T> lVar, h.a.j0 j0Var, boolean z) {
        super(lVar);
        this.f10949c = j0Var;
        this.f10950d = z;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        j0.c cVarA = this.f10949c.a();
        a aVar = new a(cVar, cVarA, this.f10561b, this.f10950d);
        cVar.onSubscribe(aVar);
        cVarA.a(aVar);
    }
}
