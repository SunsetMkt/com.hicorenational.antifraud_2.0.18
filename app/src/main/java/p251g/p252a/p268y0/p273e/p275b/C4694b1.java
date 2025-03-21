package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableFlatMapSingle.java */
/* renamed from: g.a.y0.e.b.b1 */
/* loaded from: classes2.dex */
public final class C4694b1<T, R> extends AbstractC4686a<T, R> {

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> f17780c;

    /* renamed from: d */
    final boolean f17781d;

    /* renamed from: e */
    final int f17782e;

    /* compiled from: FlowableFlatMapSingle.java */
    /* renamed from: g.a.y0.e.b.b1$a */
    static final class a<T, R> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = 8600231336733376951L;
        final InterfaceC5822c<? super R> actual;
        volatile boolean cancelled;
        final boolean delayErrors;
        final InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> mapper;
        final int maxConcurrency;

        /* renamed from: s */
        InterfaceC5823d f17783s;
        final AtomicLong requested = new AtomicLong();
        final C4551b set = new C4551b();
        final C5163c errors = new C5163c();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<C5111c<R>> queue = new AtomicReference<>();

        /* compiled from: FlowableFlatMapSingle.java */
        /* renamed from: g.a.y0.e.b.b1$a$a, reason: collision with other inner class name */
        final class C7388a extends AtomicReference<InterfaceC4552c> implements InterfaceC4524n0<R>, InterfaceC4552c {
            private static final long serialVersionUID = -502562646270949838L;

            C7388a() {
            }

            @Override // p251g.p252a.p264u0.InterfaceC4552c
            public void dispose() {
                EnumC4592d.dispose(this);
            }

            @Override // p251g.p252a.p264u0.InterfaceC4552c
            public boolean isDisposed() {
                return EnumC4592d.isDisposed(get());
            }

            @Override // p251g.p252a.InterfaceC4524n0
            public void onError(Throwable th) {
                a.this.innerError(this, th);
            }

            @Override // p251g.p252a.InterfaceC4524n0
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.setOnce(this, interfaceC4552c);
            }

            @Override // p251g.p252a.InterfaceC4524n0
            public void onSuccess(R r) {
                a.this.innerSuccess(this, r);
            }
        }

        a(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o, boolean z, int i2) {
            this.actual = interfaceC5822c;
            this.mapper = interfaceC4584o;
            this.delayErrors = z;
            this.maxConcurrency = i2;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.cancelled = true;
            this.f17783s.cancel();
            this.set.dispose();
        }

        void clear() {
            C5111c<R> c5111c = this.queue.get();
            if (c5111c != null) {
                c5111c.clear();
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
        
            if (r10 != r6) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x007b, code lost:
        
            if (r17.cancelled == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0083, code lost:
        
            if (r17.delayErrors != false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x008d, code lost:
        
            if (r17.errors.get() == null) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x008f, code lost:
        
            r2 = r17.errors.terminate();
            clear();
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x009b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00a0, code lost:
        
            if (r2.get() != 0) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00a2, code lost:
        
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00a5, code lost:
        
            r7 = r3.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00ab, code lost:
        
            if (r7 == null) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00b1, code lost:
        
            if (r7.isEmpty() == false) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00b4, code lost:
        
            if (r6 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00b6, code lost:
        
            if (r12 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00b8, code lost:
        
            r2 = r17.errors.terminate();
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00be, code lost:
        
            if (r2 == null) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00c0, code lost:
        
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00c4, code lost:
        
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00c7, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00b3, code lost:
        
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00a4, code lost:
        
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x007d, code lost:
        
            clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0080, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00ca, code lost:
        
            if (r10 == 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00cc, code lost:
        
            p251g.p252a.p268y0.p284j.C5164d.m18610c(r17.requested, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00d6, code lost:
        
            if (r17.maxConcurrency == Integer.MAX_VALUE) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00d8, code lost:
        
            r17.f17783s.request(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x00dd, code lost:
        
            r5 = addAndGet(-r5);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                Method dump skipped, instructions count: 229
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4694b1.a.drainLoop():void");
        }

        C5111c<R> getOrCreateQueue() {
            C5111c<R> c5111c;
            do {
                C5111c<R> c5111c2 = this.queue.get();
                if (c5111c2 != null) {
                    return c5111c2;
                }
                c5111c = new C5111c<>(AbstractC4519l.m17539Q());
            } while (!this.queue.compareAndSet(null, c5111c));
            return c5111c;
        }

        void innerError(a<T, R>.C7388a c7388a, Throwable th) {
            this.set.mo18182c(c7388a);
            if (!this.errors.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            if (!this.delayErrors) {
                this.f17783s.cancel();
                this.set.dispose();
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.f17783s.request(1L);
            }
            this.active.decrementAndGet();
            drain();
        }

        void innerSuccess(a<T, R>.C7388a c7388a, R r) {
            this.set.mo18182c(c7388a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.active.decrementAndGet() == 0;
                    if (this.requested.get() != 0) {
                        this.actual.onNext(r);
                        C5111c<R> c5111c = this.queue.get();
                        if (z && (c5111c == null || c5111c.isEmpty())) {
                            Throwable terminate = this.errors.terminate();
                            if (terminate != null) {
                                this.actual.onError(terminate);
                                return;
                            } else {
                                this.actual.onComplete();
                                return;
                            }
                        }
                        C5164d.m18610c(this.requested, 1L);
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            this.f17783s.request(1L);
                        }
                    } else {
                        C5111c<R> orCreateQueue = getOrCreateQueue();
                        synchronized (orCreateQueue) {
                            orCreateQueue.offer(r);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    drainLoop();
                }
            }
            C5111c<R> orCreateQueue2 = getOrCreateQueue();
            synchronized (orCreateQueue2) {
                orCreateQueue2.offer(r);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.active.decrementAndGet();
            if (!this.errors.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            if (!this.delayErrors) {
                this.set.dispose();
            }
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            try {
                InterfaceC4530q0 interfaceC4530q0 = (InterfaceC4530q0) C4601b.m18284a(this.mapper.apply(t), "The mapper returned a null SingleSource");
                this.active.getAndIncrement();
                C7388a c7388a = new C7388a();
                if (this.cancelled || !this.set.mo18181b(c7388a)) {
                    return;
                }
                interfaceC4530q0.mo17490a(c7388a);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f17783s.cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17783s, interfaceC5823d)) {
                this.f17783s = interfaceC5823d;
                this.actual.onSubscribe(this);
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    interfaceC5823d.request(C5556m0.f20396b);
                } else {
                    interfaceC5823d.request(i2);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                drain();
            }
        }
    }

    public C4694b1(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o, boolean z, int i2) {
        super(abstractC4519l);
        this.f17780c = interfaceC4584o;
        this.f17781d = z;
        this.f17782e = i2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f17780c, this.f17781d, this.f17782e));
    }
}
