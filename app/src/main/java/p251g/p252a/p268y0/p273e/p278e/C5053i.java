package p251g.p252a.p268y0.p273e.p278e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p254b1.AbstractC4471b;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ParallelJoin.java */
/* renamed from: g.a.y0.e.e.i */
/* loaded from: classes2.dex */
public final class C5053i<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final AbstractC4471b<? extends T> f19611b;

    /* renamed from: c */
    final int f19612c;

    /* renamed from: d */
    final boolean f19613d;

    /* compiled from: ParallelJoin.java */
    /* renamed from: g.a.y0.e.e.i$a */
    static final class a<T> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final int limit;
        final c<T> parent;
        final int prefetch;
        long produced;
        volatile InterfaceC4615n<T> queue;

        a(c<T> cVar, int i2) {
            this.parent = cVar;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        public boolean cancel() {
            return EnumC5160j.cancel(this);
        }

        InterfaceC4615n<T> getQueue() {
            InterfaceC4615n<T> interfaceC4615n = this.queue;
            if (interfaceC4615n != null) {
                return interfaceC4615n;
            }
            C5110b c5110b = new C5110b(this.prefetch);
            this.queue = c5110b;
            return c5110b;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.parent.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.parent.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.parent.onNext(this, t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                interfaceC5823d.request(this.prefetch);
            }
        }

        public void request(long j2) {
            long j3 = this.produced + j2;
            if (j3 < this.limit) {
                this.produced = j3;
            } else {
                this.produced = 0L;
                get().request(j3);
            }
        }

        public void requestOne() {
            long j2 = this.produced + 1;
            if (j2 != this.limit) {
                this.produced = j2;
            } else {
                this.produced = 0L;
                get().request(j2);
            }
        }
    }

    /* compiled from: ParallelJoin.java */
    /* renamed from: g.a.y0.e.e.i$b */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        b(InterfaceC5822c<? super T> interfaceC5822c, int i2, int i3) {
            super(interfaceC5822c, i2, i3);
        }

        @Override // p251g.p252a.p268y0.p273e.p278e.C5053i.c
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        /* JADX WARN: Code restructure failed: missing block: B:78:0x005f, code lost:
        
            if (r13 == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0061, code lost:
        
            if (r11 == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0063, code lost:
        
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0066, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0067, code lost:
        
            if (r11 == false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0069, code lost:
        
            r10 = r14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                Method dump skipped, instructions count: 216
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p278e.C5053i.b.drainLoop():void");
        }

        @Override // p251g.p252a.p268y0.p273e.p278e.C5053i.c
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // p251g.p252a.p268y0.p273e.p278e.C5053i.c
        public void onError(Throwable th) {
            if (this.errors.compareAndSet(null, th)) {
                cancelAll();
                drain();
            } else if (th != this.errors.get()) {
                C4476a.m17152b(th);
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p278e.C5053i.c
        public void onNext(a<T> aVar, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t);
                    if (this.requested.get() != C5556m0.f20396b) {
                        this.requested.decrementAndGet();
                    }
                    aVar.request(1L);
                } else if (!aVar.getQueue().offer(t)) {
                    cancelAll();
                    C4562c c4562c = new C4562c("Queue full?!");
                    if (this.errors.compareAndSet(null, c4562c)) {
                        this.actual.onError(c4562c);
                        return;
                    } else {
                        C4476a.m17152b(c4562c);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!aVar.getQueue().offer(t)) {
                cancelAll();
                onError(new C4562c("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }
    }

    /* compiled from: ParallelJoin.java */
    /* renamed from: g.a.y0.e.e.i$c */
    static abstract class c<T> extends AtomicInteger implements InterfaceC5823d {
        private static final long serialVersionUID = 3100232009247827843L;
        final InterfaceC5822c<? super T> actual;
        volatile boolean cancelled;
        final a<T>[] subscribers;
        final C5163c errors = new C5163c();
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger done = new AtomicInteger();

        c(InterfaceC5822c<? super T> interfaceC5822c, int i2, int i3) {
            this.actual = interfaceC5822c;
            a<T>[] aVarArr = new a[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                aVarArr[i4] = new a<>(this, i3);
            }
            this.subscribers = aVarArr;
            this.done.lazySet(i2);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                cleanup();
            }
        }

        void cancelAll() {
            int i2 = 0;
            while (true) {
                a<T>[] aVarArr = this.subscribers;
                if (i2 >= aVarArr.length) {
                    return;
                }
                aVarArr[i2].cancel();
                i2++;
            }
        }

        void cleanup() {
            int i2 = 0;
            while (true) {
                a<T>[] aVarArr = this.subscribers;
                if (i2 >= aVarArr.length) {
                    return;
                }
                aVarArr[i2].queue = null;
                i2++;
            }
        }

        abstract void drain();

        abstract void onComplete();

        abstract void onError(Throwable th);

        abstract void onNext(a<T> aVar, T t);

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                drain();
            }
        }
    }

    /* compiled from: ParallelJoin.java */
    /* renamed from: g.a.y0.e.e.i$d */
    static final class d<T> extends c<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        d(InterfaceC5822c<? super T> interfaceC5822c, int i2, int i3) {
            super(interfaceC5822c, i2, i3);
        }

        @Override // p251g.p252a.p268y0.p273e.p278e.C5053i.c
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        /* JADX WARN: Code restructure failed: missing block: B:74:0x004d, code lost:
        
            if (r13 == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x004f, code lost:
        
            if (r11 == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0059, code lost:
        
            if (r17.errors.get() == null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x005b, code lost:
        
            r3.onError(r17.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0065, code lost:
        
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0068, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0069, code lost:
        
            if (r11 == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x006b, code lost:
        
            r10 = r14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainLoop() {
            /*
                Method dump skipped, instructions count: 221
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p278e.C5053i.d.drainLoop():void");
        }

        @Override // p251g.p252a.p268y0.p273e.p278e.C5053i.c
        void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // p251g.p252a.p268y0.p273e.p278e.C5053i.c
        void onError(Throwable th) {
            this.errors.addThrowable(th);
            this.done.decrementAndGet();
            drain();
        }

        @Override // p251g.p252a.p268y0.p273e.p278e.C5053i.c
        void onNext(a<T> aVar, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t);
                    if (this.requested.get() != C5556m0.f20396b) {
                        this.requested.decrementAndGet();
                    }
                    aVar.request(1L);
                } else if (!aVar.getQueue().offer(t)) {
                    aVar.cancel();
                    this.errors.addThrowable(new C4562c("Queue full?!"));
                    this.done.decrementAndGet();
                    drainLoop();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                if (!aVar.getQueue().offer(t) && aVar.cancel()) {
                    this.errors.addThrowable(new C4562c("Queue full?!"));
                    this.done.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }
    }

    public C5053i(AbstractC4471b<? extends T> abstractC4471b, int i2, boolean z) {
        this.f19611b = abstractC4471b;
        this.f19612c = i2;
        this.f19613d = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        c dVar = this.f19613d ? new d(interfaceC5822c, this.f19611b.mo16967a(), this.f19612c) : new b(interfaceC5822c, this.f19611b.mo16967a(), this.f19612c);
        interfaceC5822c.onSubscribe(dVar);
        this.f19611b.mo16994a(dVar.subscribers);
    }
}
