package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4611j;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p272d.AbstractC4619b;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p281g.C5129r;

/* compiled from: ObservableObserveOn.java */
/* renamed from: g.a.y0.e.d.y1 */
/* loaded from: classes2.dex */
public final class C5037y1<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final AbstractC4516j0 f19512b;

    /* renamed from: c */
    final boolean f19513c;

    /* renamed from: d */
    final int f19514d;

    /* compiled from: ObservableObserveOn.java */
    /* renamed from: g.a.y0.e.d.y1$a */
    static final class a<T> extends AbstractC4619b<T> implements InterfaceC4514i0<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final InterfaceC4514i0<? super T> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        boolean outputFused;
        InterfaceC4616o<T> queue;

        /* renamed from: s */
        InterfaceC4552c f19515s;
        int sourceMode;
        final AbstractC4516j0.c worker;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, AbstractC4516j0.c cVar, boolean z, int i2) {
            this.actual = interfaceC4514i0;
            this.worker = cVar;
            this.delayError = z;
            this.bufferSize = i2;
        }

        boolean checkTerminated(boolean z, boolean z2, InterfaceC4514i0<? super T> interfaceC4514i0) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (this.delayError) {
                if (!z2) {
                    return false;
                }
                if (th != null) {
                    interfaceC4514i0.onError(th);
                } else {
                    interfaceC4514i0.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            if (th != null) {
                this.queue.clear();
                interfaceC4514i0.onError(th);
                this.worker.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            interfaceC4514i0.onComplete();
            this.worker.dispose();
            return true;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.queue.clear();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f19515s.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drainFused() {
            int i2 = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                Throwable th = this.error;
                if (!this.delayError && z && th != null) {
                    this.actual.onError(th);
                    this.worker.dispose();
                    return;
                }
                this.actual.onNext(null);
                if (z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.actual.onError(th2);
                    } else {
                        this.actual.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        
            r3 = addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        
            if (r3 != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainNormal() {
            /*
                r7 = this;
                g.a.y0.c.o<T> r0 = r7.queue
                g.a.i0<? super T> r1 = r7.actual
                r2 = 1
                r3 = 1
            L6:
                boolean r4 = r7.done
                boolean r5 = r0.isEmpty()
                boolean r4 = r7.checkTerminated(r4, r5, r1)
                if (r4 == 0) goto L13
                return
            L13:
                boolean r4 = r7.done
                java.lang.Object r5 = r0.poll()     // Catch: java.lang.Throwable -> L33
                if (r5 != 0) goto L1d
                r6 = 1
                goto L1e
            L1d:
                r6 = 0
            L1e:
                boolean r4 = r7.checkTerminated(r4, r6, r1)
                if (r4 == 0) goto L25
                return
            L25:
                if (r6 == 0) goto L2f
                int r3 = -r3
                int r3 = r7.addAndGet(r3)
                if (r3 != 0) goto L6
                return
            L2f:
                r1.onNext(r5)
                goto L13
            L33:
                r2 = move-exception
                p251g.p252a.p265v0.C4561b.m18199b(r2)
                g.a.u0.c r3 = r7.f19515s
                r3.dispose()
                r0.clear()
                r1.onError(r2)
                g.a.j0$c r0 = r7.worker
                r0.dispose()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p277d.C5037y1.a.drainNormal():void");
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            schedule();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19515s, interfaceC4552c)) {
                this.f19515s = interfaceC4552c;
                if (interfaceC4552c instanceof InterfaceC4611j) {
                    InterfaceC4611j interfaceC4611j = (InterfaceC4611j) interfaceC4552c;
                    int requestFusion = interfaceC4611j.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = interfaceC4611j;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        schedule();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = interfaceC4611j;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new C5111c(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.mo17282a(this);
            }
        }
    }

    public C5037y1(InterfaceC4504g0<T> interfaceC4504g0, AbstractC4516j0 abstractC4516j0, boolean z, int i2) {
        super(interfaceC4504g0);
        this.f19512b = abstractC4516j0;
        this.f19513c = z;
        this.f19514d = i2;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        AbstractC4516j0 abstractC4516j0 = this.f19512b;
        if (abstractC4516j0 instanceof C5129r) {
            this.f18742a.subscribe(interfaceC4514i0);
        } else {
            this.f18742a.subscribe(new a(interfaceC4514i0, abstractC4516j0.mo17277a(), this.f19513c, this.f19514d));
        }
    }
}
