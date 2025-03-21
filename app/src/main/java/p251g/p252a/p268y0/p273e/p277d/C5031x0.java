package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p001a.InterfaceC0000a;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p284j.C5163c;

/* compiled from: ObservableFlatMapMaybe.java */
/* renamed from: g.a.y0.e.d.x0 */
/* loaded from: classes2.dex */
public final class C5031x0<T, R> extends AbstractC4907a<T, R> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> f19497b;

    /* renamed from: c */
    final boolean f19498c;

    /* compiled from: ObservableFlatMapMaybe.java */
    /* renamed from: g.a.y0.e.d.x0$a */
    static final class a<T, R> extends AtomicInteger implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = 8600231336733376951L;
        final InterfaceC4514i0<? super R> actual;
        volatile boolean cancelled;

        /* renamed from: d */
        InterfaceC4552c f19499d;
        final boolean delayErrors;
        final InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> mapper;
        final C4551b set = new C4551b();
        final C5163c errors = new C5163c();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<C5111c<R>> queue = new AtomicReference<>();

        /* compiled from: ObservableFlatMapMaybe.java */
        /* renamed from: g.a.y0.e.d.x0$a$a, reason: collision with other inner class name */
        final class C7421a extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<R>, InterfaceC4552c {
            private static final long serialVersionUID = -502562646270949838L;

            C7421a() {
            }

            @Override // p251g.p252a.p264u0.InterfaceC4552c
            public void dispose() {
                EnumC4592d.dispose(this);
            }

            @Override // p251g.p252a.p264u0.InterfaceC4552c
            public boolean isDisposed() {
                return EnumC4592d.isDisposed(get());
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onComplete() {
                a.this.innerComplete(this);
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onError(Throwable th) {
                a.this.innerError(this, th);
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.setOnce(this, interfaceC4552c);
            }

            @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
            public void onSuccess(R r) {
                a.this.innerSuccess(this, r);
            }
        }

        a(InterfaceC4514i0<? super R> interfaceC4514i0, InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> interfaceC4584o, boolean z) {
            this.actual = interfaceC4514i0;
            this.mapper = interfaceC4584o;
            this.delayErrors = z;
        }

        void clear() {
            C5111c<R> c5111c = this.queue.get();
            if (c5111c != null) {
                c5111c.clear();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.cancelled = true;
            this.f19499d.dispose();
            this.set.dispose();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            InterfaceC4514i0<? super R> interfaceC4514i0 = this.actual;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<C5111c<R>> atomicReference = this.queue;
            int i2 = 1;
            while (!this.cancelled) {
                if (!this.delayErrors && this.errors.get() != null) {
                    Throwable terminate = this.errors.terminate();
                    clear();
                    interfaceC4514i0.onError(terminate);
                    return;
                }
                boolean z = atomicInteger.get() == 0;
                C5111c<R> c5111c = atomicReference.get();
                InterfaceC0000a poll = c5111c != null ? c5111c.poll() : null;
                boolean z2 = poll == null;
                if (z && z2) {
                    Throwable terminate2 = this.errors.terminate();
                    if (terminate2 != null) {
                        interfaceC4514i0.onError(terminate2);
                        return;
                    } else {
                        interfaceC4514i0.onComplete();
                        return;
                    }
                }
                if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    interfaceC4514i0.onNext(poll);
                }
            }
            clear();
        }

        C5111c<R> getOrCreateQueue() {
            C5111c<R> c5111c;
            do {
                C5111c<R> c5111c2 = this.queue.get();
                if (c5111c2 != null) {
                    return c5111c2;
                }
                c5111c = new C5111c<>(AbstractC4469b0.m16521L());
            } while (!this.queue.compareAndSet(null, c5111c));
            return c5111c;
        }

        void innerComplete(a<T, R>.C7421a c7421a) {
            this.set.mo18182c(c7421a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.active.decrementAndGet() == 0;
                    C5111c<R> c5111c = this.queue.get();
                    if (!z || (c5111c != null && !c5111c.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        drainLoop();
                        return;
                    } else {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            this.actual.onError(terminate);
                            return;
                        } else {
                            this.actual.onComplete();
                            return;
                        }
                    }
                }
            }
            this.active.decrementAndGet();
            drain();
        }

        void innerError(a<T, R>.C7421a c7421a, Throwable th) {
            this.set.mo18182c(c7421a);
            if (!this.errors.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            if (!this.delayErrors) {
                this.f19499d.dispose();
                this.set.dispose();
            }
            this.active.decrementAndGet();
            drain();
        }

        void innerSuccess(a<T, R>.C7421a c7421a, R r) {
            this.set.mo18182c(c7421a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    this.actual.onNext(r);
                    boolean z = this.active.decrementAndGet() == 0;
                    C5111c<R> c5111c = this.queue.get();
                    if (!z || (c5111c != null && !c5111c.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        drainLoop();
                    } else {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            this.actual.onError(terminate);
                            return;
                        } else {
                            this.actual.onComplete();
                            return;
                        }
                    }
                }
            }
            C5111c<R> orCreateQueue = getOrCreateQueue();
            synchronized (orCreateQueue) {
                orCreateQueue.offer(r);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
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

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            try {
                InterfaceC4588y interfaceC4588y = (InterfaceC4588y) C4601b.m18284a(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                this.active.getAndIncrement();
                C7421a c7421a = new C7421a();
                if (this.cancelled || !this.set.mo18181b(c7421a)) {
                    return;
                }
                interfaceC4588y.mo18100a(c7421a);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19499d.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19499d, interfaceC4552c)) {
                this.f19499d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }
    }

    public C5031x0(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> interfaceC4584o, boolean z) {
        super(interfaceC4504g0);
        this.f19497b = interfaceC4584o;
        this.f19498c = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19497b, this.f19498c));
    }
}
