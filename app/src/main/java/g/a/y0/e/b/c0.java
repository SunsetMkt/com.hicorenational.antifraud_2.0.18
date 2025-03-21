package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableCreate.java */
/* loaded from: classes2.dex */
public final class c0<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.o<T> f14146b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.b f14147c;

    /* compiled from: FlowableCreate.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14148a = new int[g.a.b.values().length];

        static {
            try {
                f14148a[g.a.b.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14148a[g.a.b.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14148a[g.a.b.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14148a[g.a.b.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: FlowableCreate.java */
    static abstract class b<T> extends AtomicLong implements g.a.n<T>, i.d.d {
        private static final long serialVersionUID = 7326289992464377023L;
        final i.d.c<? super T> actual;
        final g.a.y0.a.k serial = new g.a.y0.a.k();

        b(i.d.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // i.d.d
        public final void cancel() {
            this.serial.dispose();
            onUnsubscribed();
        }

        protected void complete() {
            if (isCancelled()) {
                return;
            }
            try {
                this.actual.onComplete();
            } finally {
                this.serial.dispose();
            }
        }

        protected boolean error(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return false;
            }
            try {
                this.actual.onError(th);
                this.serial.dispose();
                return true;
            } catch (Throwable th2) {
                this.serial.dispose();
                throw th2;
            }
        }

        @Override // g.a.n
        public final boolean isCancelled() {
            return this.serial.isDisposed();
        }

        @Override // g.a.k
        public void onComplete() {
            complete();
        }

        @Override // g.a.k
        public final void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            g.a.c1.a.b(th);
        }

        void onRequested() {
        }

        void onUnsubscribed() {
        }

        @Override // i.d.d
        public final void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this, j2);
                onRequested();
            }
        }

        @Override // g.a.n
        public final long requested() {
            return get();
        }

        @Override // g.a.n
        public final g.a.n<T> serialize() {
            return new i(this);
        }

        @Override // g.a.n
        public final void setCancellable(g.a.x0.f fVar) {
            setDisposable(new g.a.y0.a.b(fVar));
        }

        @Override // g.a.n
        public final void setDisposable(g.a.u0.c cVar) {
            this.serial.update(cVar);
        }

        @Override // g.a.n
        public boolean tryOnError(Throwable th) {
            return error(th);
        }
    }

    /* compiled from: FlowableCreate.java */
    static final class c<T> extends b<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final g.a.y0.f.c<T> queue;
        final AtomicInteger wip;

        c(i.d.c<? super T> cVar, int i2) {
            super(cVar);
            this.queue = new g.a.y0.f.c<>(i2);
            this.wip = new AtomicInteger();
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            i.d.c<? super T> cVar = this.actual;
            g.a.y0.f.c<T> cVar2 = this.queue;
            int i2 = 1;
            do {
                long j2 = get();
                long j3 = 0;
                while (j3 != j2) {
                    if (isCancelled()) {
                        cVar2.clear();
                        return;
                    }
                    boolean z = this.done;
                    T poll = cVar2.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            error(th);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    cVar.onNext(poll);
                    j3++;
                }
                if (j3 == j2) {
                    if (isCancelled()) {
                        cVar2.clear();
                        return;
                    }
                    boolean z3 = this.done;
                    boolean isEmpty = cVar2.isEmpty();
                    if (z3 && isEmpty) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            error(th2);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                }
                if (j3 != 0) {
                    g.a.y0.j.d.c(this, j3);
                }
                i2 = this.wip.addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // g.a.y0.e.b.c0.b, g.a.k
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // g.a.k
        public void onNext(T t) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.offer(t);
                drain();
            }
        }

        @Override // g.a.y0.e.b.c0.b
        void onRequested() {
            drain();
        }

        @Override // g.a.y0.e.b.c0.b
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // g.a.y0.e.b.c0.b, g.a.n
        public boolean tryOnError(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }
    }

    /* compiled from: FlowableCreate.java */
    static final class d<T> extends h<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        d(i.d.c<? super T> cVar) {
            super(cVar);
        }

        @Override // g.a.y0.e.b.c0.h
        void onOverflow() {
        }
    }

    /* compiled from: FlowableCreate.java */
    static final class e<T> extends h<T> {
        private static final long serialVersionUID = 338953216916120960L;

        e(i.d.c<? super T> cVar) {
            super(cVar);
        }

        @Override // g.a.y0.e.b.c0.h
        void onOverflow() {
            onError(new g.a.v0.c("create: could not emit value due to lack of requests"));
        }
    }

    /* compiled from: FlowableCreate.java */
    static final class f<T> extends b<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue;
        final AtomicInteger wip;

        f(i.d.c<? super T> cVar) {
            super(cVar);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            i.d.c<? super T> cVar = this.actual;
            AtomicReference<T> atomicReference = this.queue;
            int i2 = 1;
            do {
                long j2 = get();
                long j3 = 0;
                while (true) {
                    if (j3 == j2) {
                        break;
                    }
                    if (isCancelled()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z = this.done;
                    T andSet = atomicReference.getAndSet(null);
                    boolean z2 = andSet == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            error(th);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    cVar.onNext(andSet);
                    j3++;
                }
                if (j3 == j2) {
                    if (isCancelled()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z3 = this.done;
                    boolean z4 = atomicReference.get() == null;
                    if (z3 && z4) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            error(th2);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                }
                if (j3 != 0) {
                    g.a.y0.j.d.c(this, j3);
                }
                i2 = this.wip.addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // g.a.y0.e.b.c0.b, g.a.k
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // g.a.k
        public void onNext(T t) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.set(t);
                drain();
            }
        }

        @Override // g.a.y0.e.b.c0.b
        void onRequested() {
            drain();
        }

        @Override // g.a.y0.e.b.c0.b
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        @Override // g.a.y0.e.b.c0.b, g.a.n
        public boolean tryOnError(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th == null) {
                onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }
    }

    /* compiled from: FlowableCreate.java */
    static final class g<T> extends b<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        g(i.d.c<? super T> cVar) {
            super(cVar);
        }

        @Override // g.a.k
        public void onNext(T t) {
            long j2;
            if (isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            this.actual.onNext(t);
            do {
                j2 = get();
                if (j2 == 0) {
                    return;
                }
            } while (!compareAndSet(j2, j2 - 1));
        }
    }

    /* compiled from: FlowableCreate.java */
    static abstract class h<T> extends b<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        h(i.d.c<? super T> cVar) {
            super(cVar);
        }

        @Override // g.a.k
        public final void onNext(T t) {
            if (isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (get() == 0) {
                onOverflow();
            } else {
                this.actual.onNext(t);
                g.a.y0.j.d.c(this, 1L);
            }
        }

        abstract void onOverflow();
    }

    /* compiled from: FlowableCreate.java */
    static final class i<T> extends AtomicInteger implements g.a.n<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final b<T> emitter;
        final g.a.y0.j.c error = new g.a.y0.j.c();
        final g.a.y0.c.n<T> queue = new g.a.y0.f.c(16);

        i(b<T> bVar) {
            this.emitter = bVar;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            b<T> bVar = this.emitter;
            g.a.y0.c.n<T> nVar = this.queue;
            g.a.y0.j.c cVar = this.error;
            int i2 = 1;
            while (!bVar.isCancelled()) {
                if (cVar.get() != null) {
                    nVar.clear();
                    bVar.onError(cVar.terminate());
                    return;
                }
                boolean z = this.done;
                T poll = nVar.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    bVar.onComplete();
                    return;
                } else if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    bVar.onNext(poll);
                }
            }
            nVar.clear();
        }

        @Override // g.a.n
        public boolean isCancelled() {
            return this.emitter.isCancelled();
        }

        @Override // g.a.k
        public void onComplete() {
            if (this.emitter.isCancelled() || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // g.a.k
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            g.a.c1.a.b(th);
        }

        @Override // g.a.k
        public void onNext(T t) {
            if (this.emitter.isCancelled() || this.done) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                g.a.y0.c.n<T> nVar = this.queue;
                synchronized (nVar) {
                    nVar.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // g.a.n
        public long requested() {
            return this.emitter.requested();
        }

        @Override // g.a.n
        public g.a.n<T> serialize() {
            return this;
        }

        @Override // g.a.n
        public void setCancellable(g.a.x0.f fVar) {
            this.emitter.setCancellable(fVar);
        }

        @Override // g.a.n
        public void setDisposable(g.a.u0.c cVar) {
            this.emitter.setDisposable(cVar);
        }

        @Override // g.a.n
        public boolean tryOnError(Throwable th) {
            if (!this.emitter.isCancelled() && !this.done) {
                if (th == null) {
                    th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                if (this.error.addThrowable(th)) {
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return false;
        }
    }

    public c0(g.a.o<T> oVar, g.a.b bVar) {
        this.f14146b = oVar;
        this.f14147c = bVar;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        int i2 = a.f14148a[this.f14147c.ordinal()];
        b cVar2 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? new c(cVar, g.a.l.Q()) : new f(cVar) : new d(cVar) : new e(cVar) : new g(cVar);
        cVar.onSubscribe(cVar2);
        try {
            this.f14146b.a(cVar2);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            cVar2.onError(th);
        }
    }
}
