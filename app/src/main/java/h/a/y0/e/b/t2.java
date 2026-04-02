package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: FlowableRefCount.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t2<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c */
    final h.a.w0.a<T> f10987c;

    /* JADX INFO: renamed from: d */
    volatile h.a.u0.b f10988d;

    /* JADX INFO: renamed from: e */
    final AtomicInteger f10989e;

    /* JADX INFO: renamed from: f */
    final ReentrantLock f10990f;

    /* JADX INFO: compiled from: FlowableRefCount.java */
    final class a extends AtomicReference<j.d.d> implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = 152064694420235350L;
        final h.a.u0.b currentBase;
        final AtomicLong requested = new AtomicLong();
        final h.a.u0.c resource;
        final j.d.c<? super T> subscriber;

        a(j.d.c<? super T> cVar, h.a.u0.b bVar, h.a.u0.c cVar2) {
            this.subscriber = cVar;
            this.currentBase = bVar;
            this.resource = cVar2;
        }

        @Override // j.d.d
        public void cancel() {
            h.a.y0.i.j.cancel(this);
            this.resource.dispose();
        }

        void cleanup() {
            t2.this.f10990f.lock();
            try {
                if (t2.this.f10988d == this.currentBase) {
                    if (t2.this.f10987c instanceof h.a.u0.c) {
                        ((h.a.u0.c) t2.this.f10987c).dispose();
                    }
                    t2.this.f10988d.dispose();
                    t2.this.f10988d = new h.a.u0.b();
                    t2.this.f10989e.set(0);
                }
            } finally {
                t2.this.f10990f.unlock();
            }
        }

        @Override // j.d.c
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            h.a.y0.i.j.deferredSetOnce(this, this.requested, dVar);
        }

        @Override // j.d.d
        public void request(long j2) {
            h.a.y0.i.j.deferredRequest(this, this.requested, j2);
        }
    }

    /* JADX INFO: compiled from: FlowableRefCount.java */
    final class b implements h.a.x0.g<h.a.u0.c> {
        private final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b */
        private final AtomicBoolean f10991b;

        b(j.d.c<? super T> cVar, AtomicBoolean atomicBoolean) {
            this.a = cVar;
            this.f10991b = atomicBoolean;
        }

        @Override // h.a.x0.g
        /* JADX INFO: renamed from: a */
        public void accept(h.a.u0.c cVar) {
            try {
                t2.this.f10988d.b(cVar);
                t2.this.a((j.d.c) this.a, t2.this.f10988d);
            } finally {
                t2.this.f10990f.unlock();
                this.f10991b.set(false);
            }
        }
    }

    /* JADX INFO: compiled from: FlowableRefCount.java */
    final class c implements Runnable {
        private final h.a.u0.b a;

        c(h.a.u0.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            t2.this.f10990f.lock();
            try {
                if (t2.this.f10988d == this.a && t2.this.f10989e.decrementAndGet() == 0) {
                    if (t2.this.f10987c instanceof h.a.u0.c) {
                        ((h.a.u0.c) t2.this.f10987c).dispose();
                    }
                    t2.this.f10988d.dispose();
                    t2.this.f10988d = new h.a.u0.b();
                }
            } finally {
                t2.this.f10990f.unlock();
            }
        }
    }

    public t2(h.a.w0.a<T> aVar) {
        super(aVar);
        this.f10988d = new h.a.u0.b();
        this.f10989e = new AtomicInteger();
        this.f10990f = new ReentrantLock();
        this.f10987c = aVar;
    }

    private h.a.x0.g<h.a.u0.c> a(j.d.c<? super T> cVar, AtomicBoolean atomicBoolean) {
        return new b(cVar, atomicBoolean);
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        this.f10990f.lock();
        if (this.f10989e.incrementAndGet() != 1) {
            try {
                a((j.d.c) cVar, this.f10988d);
            } finally {
                this.f10990f.unlock();
            }
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.f10987c.l((h.a.x0.g<? super h.a.u0.c>) a((j.d.c) cVar, atomicBoolean));
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
    }

    void a(j.d.c<? super T> cVar, h.a.u0.b bVar) {
        a aVar = new a(cVar, bVar, a(bVar));
        cVar.onSubscribe(aVar);
        this.f10987c.a((h.a.q) aVar);
    }

    private h.a.u0.c a(h.a.u0.b bVar) {
        return h.a.u0.d.a(new c(bVar));
    }
}
