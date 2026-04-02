package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableCreate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.o<T> f10590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.b f10591c;

    /* JADX INFO: compiled from: FlowableCreate.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[h.a.b.values().length];

        static {
            try {
                a[h.a.b.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.a.b.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[h.a.b.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[h.a.b.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: FlowableCreate.java */
    static abstract class b<T> extends AtomicLong implements h.a.n<T>, j.d.d {
        private static final long serialVersionUID = 7326289992464377023L;
        final j.d.c<? super T> actual;
        final h.a.y0.a.k serial = new h.a.y0.a.k();

        b(j.d.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // j.d.d
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

        @Override // h.a.n
        public final boolean isCancelled() {
            return this.serial.isDisposed();
        }

        @Override // h.a.k
        public void onComplete() {
            complete();
        }

        @Override // h.a.k
        public final void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            h.a.c1.a.b(th);
        }

        void onRequested() {
        }

        void onUnsubscribed() {
        }

        @Override // j.d.d
        public final void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this, j2);
                onRequested();
            }
        }

        @Override // h.a.n
        public final long requested() {
            return get();
        }

        @Override // h.a.n
        public final h.a.n<T> serialize() {
            return new i(this);
        }

        @Override // h.a.n
        public final void setCancellable(h.a.x0.f fVar) {
            setDisposable(new h.a.y0.a.b(fVar));
        }

        @Override // h.a.n
        public final void setDisposable(h.a.u0.c cVar) {
            this.serial.update(cVar);
        }

        @Override // h.a.n
        public boolean tryOnError(Throwable th) {
            return error(th);
        }
    }

    /* JADX INFO: compiled from: FlowableCreate.java */
    static final class c<T> extends b<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final h.a.y0.f.c<T> queue;
        final AtomicInteger wip;

        c(j.d.c<? super T> cVar, int i2) {
            super(cVar);
            this.queue = new h.a.y0.f.c<>(i2);
            this.wip = new AtomicInteger();
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            j.d.c<? super T> cVar = this.actual;
            h.a.y0.f.c<T> cVar2 = this.queue;
            int iAddAndGet = 1;
            do {
                long j2 = get();
                long j3 = 0;
                while (j3 != j2) {
                    if (isCancelled()) {
                        cVar2.clear();
                        return;
                    }
                    boolean z = this.done;
                    T tPoll = cVar2.poll();
                    boolean z2 = tPoll == null;
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
                    cVar.onNext(tPoll);
                    j3++;
                }
                if (j3 == j2) {
                    if (isCancelled()) {
                        cVar2.clear();
                        return;
                    }
                    boolean z3 = this.done;
                    boolean zIsEmpty = cVar2.isEmpty();
                    if (z3 && zIsEmpty) {
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
                    h.a.y0.j.d.c(this, j3);
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // h.a.y0.e.b.c0.b, h.a.k
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // h.a.k
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

        @Override // h.a.y0.e.b.c0.b
        void onRequested() {
            drain();
        }

        @Override // h.a.y0.e.b.c0.b
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // h.a.y0.e.b.c0.b, h.a.n
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

    /* JADX INFO: compiled from: FlowableCreate.java */
    static final class d<T> extends h<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        d(j.d.c<? super T> cVar) {
            super(cVar);
        }

        @Override // h.a.y0.e.b.c0.h
        void onOverflow() {
        }
    }

    /* JADX INFO: compiled from: FlowableCreate.java */
    static final class e<T> extends h<T> {
        private static final long serialVersionUID = 338953216916120960L;

        e(j.d.c<? super T> cVar) {
            super(cVar);
        }

        @Override // h.a.y0.e.b.c0.h
        void onOverflow() {
            onError(new h.a.v0.c("create: could not emit value due to lack of requests"));
        }
    }

    /* JADX INFO: compiled from: FlowableCreate.java */
    static final class f<T> extends b<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue;
        final AtomicInteger wip;

        f(j.d.c<? super T> cVar) {
            super(cVar);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:
        
            if (r9 != r5) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
        
            if (isCancelled() == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        
            r2.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
        
            r5 = r17.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
        
            if (r2.get() != null) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
        
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0064, code lost:
        
            if (r5 == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
        
            if (r11 == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
        
            r1 = r17.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x006a, code lost:
        
            if (r1 == null) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x006c, code lost:
        
            error(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0070, code lost:
        
            complete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0076, code lost:
        
            if (r9 == 0) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0078, code lost:
        
            h.a.y0.j.d.c(r17, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x007b, code lost:
        
            r4 = r17.wip.addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            j.d.c<? super T> cVar = this.actual;
            AtomicReference<T> atomicReference = this.queue;
            int iAddAndGet = 1;
            do {
                long j2 = get();
                long j3 = 0;
                while (true) {
                    boolean z = false;
                    if (j3 == j2) {
                        break;
                    }
                    if (isCancelled()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z2 = this.done;
                    T andSet = atomicReference.getAndSet(null);
                    boolean z3 = andSet == null;
                    if (z2 && z3) {
                        Throwable th = this.error;
                        if (th != null) {
                            error(th);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    cVar.onNext(andSet);
                    j3++;
                }
            } while (iAddAndGet != 0);
        }

        @Override // h.a.y0.e.b.c0.b, h.a.k
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // h.a.k
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

        @Override // h.a.y0.e.b.c0.b
        void onRequested() {
            drain();
        }

        @Override // h.a.y0.e.b.c0.b
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        @Override // h.a.y0.e.b.c0.b, h.a.n
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

    /* JADX INFO: compiled from: FlowableCreate.java */
    static final class g<T> extends b<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        g(j.d.c<? super T> cVar) {
            super(cVar);
        }

        @Override // h.a.k
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

    /* JADX INFO: compiled from: FlowableCreate.java */
    static abstract class h<T> extends b<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        h(j.d.c<? super T> cVar) {
            super(cVar);
        }

        @Override // h.a.k
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
                h.a.y0.j.d.c(this, 1L);
            }
        }

        abstract void onOverflow();
    }

    /* JADX INFO: compiled from: FlowableCreate.java */
    static final class i<T> extends AtomicInteger implements h.a.n<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final b<T> emitter;
        final h.a.y0.j.c error = new h.a.y0.j.c();
        final h.a.y0.c.n<T> queue = new h.a.y0.f.c(16);

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
            h.a.y0.c.n<T> nVar = this.queue;
            h.a.y0.j.c cVar = this.error;
            int iAddAndGet = 1;
            while (!bVar.isCancelled()) {
                if (cVar.get() != null) {
                    nVar.clear();
                    bVar.onError(cVar.terminate());
                    return;
                }
                boolean z = this.done;
                T tPoll = nVar.poll();
                boolean z2 = tPoll == null;
                if (z && z2) {
                    bVar.onComplete();
                    return;
                } else if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    bVar.onNext(tPoll);
                }
            }
            nVar.clear();
        }

        @Override // h.a.n
        public boolean isCancelled() {
            return this.emitter.isCancelled();
        }

        @Override // h.a.k
        public void onComplete() {
            if (this.emitter.isCancelled() || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // h.a.k
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            h.a.c1.a.b(th);
        }

        @Override // h.a.k
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
                h.a.y0.c.n<T> nVar = this.queue;
                synchronized (nVar) {
                    nVar.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // h.a.n
        public long requested() {
            return this.emitter.requested();
        }

        @Override // h.a.n
        public h.a.n<T> serialize() {
            return this;
        }

        @Override // h.a.n
        public void setCancellable(h.a.x0.f fVar) {
            this.emitter.setCancellable(fVar);
        }

        @Override // h.a.n
        public void setDisposable(h.a.u0.c cVar) {
            this.emitter.setDisposable(cVar);
        }

        @Override // h.a.n
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

    public c0(h.a.o<T> oVar, h.a.b bVar) {
        this.f10590b = oVar;
        this.f10591c = bVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        int i2 = a.a[this.f10591c.ordinal()];
        b cVar2 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? new c(cVar, h.a.l.Q()) : new f(cVar) : new d(cVar) : new e(cVar) : new g(cVar);
        cVar.onSubscribe(cVar2);
        try {
            this.f10590b.a(cVar2);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            cVar2.onError(th);
        }
    }
}
