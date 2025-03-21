package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p284j.C5163c;

/* compiled from: ObservableCombineLatest.java */
/* renamed from: g.a.y0.e.d.u */
/* loaded from: classes2.dex */
public final class C5015u<T, R> extends AbstractC4469b0<R> {

    /* renamed from: a */
    final InterfaceC4504g0<? extends T>[] f19412a;

    /* renamed from: b */
    final Iterable<? extends InterfaceC4504g0<? extends T>> f19413b;

    /* renamed from: c */
    final InterfaceC4584o<? super Object[], ? extends R> f19414c;

    /* renamed from: d */
    final int f19415d;

    /* renamed from: e */
    final boolean f19416e;

    /* compiled from: ObservableCombineLatest.java */
    /* renamed from: g.a.y0.e.d.u$a */
    static final class a<T, R> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final b<T, R> parent;

        a(b<T, R> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.parent.innerNext(this.index, t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }
    }

    /* compiled from: ObservableCombineLatest.java */
    /* renamed from: g.a.y0.e.d.u$b */
    static final class b<T, R> extends AtomicInteger implements InterfaceC4552c {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final InterfaceC4514i0<? super R> actual;
        volatile boolean cancelled;
        final InterfaceC4584o<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final C5163c errors = new C5163c();
        Object[] latest;
        final a<T, R>[] observers;
        final C5111c<Object[]> queue;

        b(InterfaceC4514i0<? super R> interfaceC4514i0, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, int i2, int i3, boolean z) {
            this.actual = interfaceC4514i0;
            this.combiner = interfaceC4584o;
            this.delayError = z;
            this.latest = new Object[i2];
            a<T, R>[] aVarArr = new a[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                aVarArr[i4] = new a<>(this, i4);
            }
            this.observers = aVarArr;
            this.queue = new C5111c<>(i3);
        }

        void cancelSources() {
            for (a<T, R> aVar : this.observers) {
                aVar.dispose();
            }
        }

        void clear(C5111c<?> c5111c) {
            synchronized (this) {
                this.latest = null;
            }
            c5111c.clear();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear(this.queue);
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            C5111c<Object[]> c5111c = this.queue;
            InterfaceC4514i0<? super R> interfaceC4514i0 = this.actual;
            boolean z = this.delayError;
            int i2 = 1;
            while (!this.cancelled) {
                if (!z && this.errors.get() != null) {
                    cancelSources();
                    clear(c5111c);
                    interfaceC4514i0.onError(this.errors.terminate());
                    return;
                }
                boolean z2 = this.done;
                Object[] poll = c5111c.poll();
                boolean z3 = poll == null;
                if (z2 && z3) {
                    clear(c5111c);
                    Throwable terminate = this.errors.terminate();
                    if (terminate == null) {
                        interfaceC4514i0.onComplete();
                        return;
                    } else {
                        interfaceC4514i0.onError(terminate);
                        return;
                    }
                }
                if (z3) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    try {
                        interfaceC4514i0.onNext((Object) C4601b.m18284a(this.combiner.apply(poll), "The combiner returned a null value"));
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        this.errors.addThrowable(th);
                        cancelSources();
                        clear(c5111c);
                        interfaceC4514i0.onError(this.errors.terminate());
                        return;
                    }
                }
            }
            clear(c5111c);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0017, code lost:
        
            if (r2 == r0.length) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void innerComplete(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.latest     // Catch: java.lang.Throwable -> L25
                if (r0 != 0) goto L7
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                return
            L7:
                r4 = r0[r4]     // Catch: java.lang.Throwable -> L25
                r1 = 1
                if (r4 != 0) goto Le
                r4 = 1
                goto Lf
            Le:
                r4 = 0
            Lf:
                if (r4 != 0) goto L19
                int r2 = r3.complete     // Catch: java.lang.Throwable -> L25
                int r2 = r2 + r1
                r3.complete = r2     // Catch: java.lang.Throwable -> L25
                int r0 = r0.length     // Catch: java.lang.Throwable -> L25
                if (r2 != r0) goto L1b
            L19:
                r3.done = r1     // Catch: java.lang.Throwable -> L25
            L1b:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                if (r4 == 0) goto L21
                r3.cancelSources()
            L21:
                r3.drain()
                return
            L25:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p277d.C5015u.b.innerComplete(int):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
        
            if (r1 == r4.length) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void innerError(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                g.a.y0.j.c r0 = r2.errors
                boolean r0 = r0.addThrowable(r4)
                if (r0 == 0) goto L36
                boolean r4 = r2.delayError
                r0 = 1
                if (r4 == 0) goto L2c
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.latest     // Catch: java.lang.Throwable -> L29
                if (r4 != 0) goto L14
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
                return
            L14:
                r3 = r4[r3]     // Catch: java.lang.Throwable -> L29
                if (r3 != 0) goto L1a
                r3 = 1
                goto L1b
            L1a:
                r3 = 0
            L1b:
                if (r3 != 0) goto L25
                int r1 = r2.complete     // Catch: java.lang.Throwable -> L29
                int r1 = r1 + r0
                r2.complete = r1     // Catch: java.lang.Throwable -> L29
                int r4 = r4.length     // Catch: java.lang.Throwable -> L29
                if (r1 != r4) goto L27
            L25:
                r2.done = r0     // Catch: java.lang.Throwable -> L29
            L27:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
                goto L2d
            L29:
                r3 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
                throw r3
            L2c:
                r3 = 1
            L2d:
                if (r3 == 0) goto L32
                r2.cancelSources()
            L32:
                r2.drain()
                goto L39
            L36:
                p251g.p252a.p255c1.C4476a.m17152b(r4)
            L39:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p277d.C5015u.b.innerError(int, java.lang.Throwable):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        void innerNext(int i2, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr == null) {
                    return;
                }
                Object obj = objArr[i2];
                int i3 = this.active;
                if (obj == null) {
                    i3++;
                    this.active = i3;
                }
                objArr[i2] = t;
                if (i3 == objArr.length) {
                    this.queue.offer(objArr.clone());
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    drain();
                }
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr) {
            a<T, R>[] aVarArr = this.observers;
            int length = aVarArr.length;
            this.actual.onSubscribe(this);
            for (int i2 = 0; i2 < length && !this.done && !this.cancelled; i2++) {
                interfaceC4504g0Arr[i2].subscribe(aVarArr[i2]);
            }
        }
    }

    public C5015u(InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr, Iterable<? extends InterfaceC4504g0<? extends T>> iterable, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, int i2, boolean z) {
        this.f19412a = interfaceC4504g0Arr;
        this.f19413b = iterable;
        this.f19414c = interfaceC4584o;
        this.f19415d = i2;
        this.f19416e = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
        int length;
        InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr = this.f19412a;
        if (interfaceC4504g0Arr == null) {
            interfaceC4504g0Arr = new AbstractC4469b0[8];
            length = 0;
            for (InterfaceC4504g0<? extends T> interfaceC4504g0 : this.f19413b) {
                if (length == interfaceC4504g0Arr.length) {
                    InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr2 = new InterfaceC4504g0[(length >> 2) + length];
                    System.arraycopy(interfaceC4504g0Arr, 0, interfaceC4504g0Arr2, 0, length);
                    interfaceC4504g0Arr = interfaceC4504g0Arr2;
                }
                interfaceC4504g0Arr[length] = interfaceC4504g0;
                length++;
            }
        } else {
            length = interfaceC4504g0Arr.length;
        }
        int i2 = length;
        if (i2 == 0) {
            EnumC4593e.complete(interfaceC4514i0);
        } else {
            new b(interfaceC4514i0, this.f19414c, i2, this.f19415d, this.f19416e).subscribe(interfaceC4504g0Arr);
        }
    }
}
