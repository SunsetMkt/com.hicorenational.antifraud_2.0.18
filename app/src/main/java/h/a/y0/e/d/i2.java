package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: ObservableRefCount.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i2<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b */
    final h.a.z0.a<? extends T> f11416b;

    /* JADX INFO: renamed from: c */
    volatile h.a.u0.b f11417c;

    /* JADX INFO: renamed from: d */
    final AtomicInteger f11418d;

    /* JADX INFO: renamed from: e */
    final ReentrantLock f11419e;

    /* JADX INFO: compiled from: ObservableRefCount.java */
    final class a extends AtomicReference<h.a.u0.c> implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = 3813126992133394324L;
        final h.a.u0.b currentBase;
        final h.a.u0.c resource;
        final h.a.i0<? super T> subscriber;

        a(h.a.i0<? super T> i0Var, h.a.u0.b bVar, h.a.u0.c cVar) {
            this.subscriber = i0Var;
            this.currentBase = bVar;
            this.resource = cVar;
        }

        void cleanup() {
            i2.this.f11419e.lock();
            try {
                if (i2.this.f11417c == this.currentBase) {
                    if (i2.this.f11416b instanceof h.a.u0.c) {
                        ((h.a.u0.c) i2.this.f11416b).dispose();
                    }
                    i2.this.f11417c.dispose();
                    i2.this.f11417c = new h.a.u0.b();
                    i2.this.f11418d.set(0);
                }
            } finally {
                i2.this.f11419e.unlock();
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
            this.resource.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.i0
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }
    }

    /* JADX INFO: compiled from: ObservableRefCount.java */
    final class b implements h.a.x0.g<h.a.u0.c> {
        private final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b */
        private final AtomicBoolean f11420b;

        b(h.a.i0<? super T> i0Var, AtomicBoolean atomicBoolean) {
            this.a = i0Var;
            this.f11420b = atomicBoolean;
        }

        @Override // h.a.x0.g
        /* JADX INFO: renamed from: a */
        public void accept(h.a.u0.c cVar) {
            try {
                i2.this.f11417c.b(cVar);
                i2.this.a((h.a.i0) this.a, i2.this.f11417c);
            } finally {
                i2.this.f11419e.unlock();
                this.f11420b.set(false);
            }
        }
    }

    /* JADX INFO: compiled from: ObservableRefCount.java */
    final class c implements Runnable {
        private final h.a.u0.b a;

        c(h.a.u0.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            i2.this.f11419e.lock();
            try {
                if (i2.this.f11417c == this.a && i2.this.f11418d.decrementAndGet() == 0) {
                    if (i2.this.f11416b instanceof h.a.u0.c) {
                        ((h.a.u0.c) i2.this.f11416b).dispose();
                    }
                    i2.this.f11417c.dispose();
                    i2.this.f11417c = new h.a.u0.b();
                }
            } finally {
                i2.this.f11419e.unlock();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i2(h.a.z0.a<T> aVar) {
        super(aVar);
        this.f11417c = new h.a.u0.b();
        this.f11418d = new AtomicInteger();
        this.f11419e = new ReentrantLock();
        this.f11416b = aVar;
    }

    private h.a.x0.g<h.a.u0.c> a(h.a.i0<? super T> i0Var, AtomicBoolean atomicBoolean) {
        return new b(i0Var, atomicBoolean);
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.f11419e.lock();
        if (this.f11418d.incrementAndGet() != 1) {
            try {
                a((h.a.i0) i0Var, this.f11417c);
            } finally {
                this.f11419e.unlock();
            }
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.f11416b.k((h.a.x0.g<? super h.a.u0.c>) a((h.a.i0) i0Var, atomicBoolean));
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
    }

    void a(h.a.i0<? super T> i0Var, h.a.u0.b bVar) {
        a aVar = new a(i0Var, bVar, a(bVar));
        i0Var.onSubscribe(aVar);
        this.f11416b.subscribe(aVar);
    }

    private h.a.u0.c a(h.a.u0.b bVar) {
        return h.a.u0.d.a(new c(bVar));
    }
}
