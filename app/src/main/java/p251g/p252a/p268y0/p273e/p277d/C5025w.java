package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4611j;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5111c;

/* compiled from: ObservableConcatMapCompletable.java */
/* renamed from: g.a.y0.e.d.w */
/* loaded from: classes2.dex */
public final class C5025w<T> extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4504g0<T> f19468a;

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4513i> f19469b;

    /* renamed from: c */
    final int f19470c;

    /* compiled from: ObservableConcatMapCompletable.java */
    /* renamed from: g.a.y0.e.d.w$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = 6893587405571511048L;
        volatile boolean active;
        final InterfaceC4491f actual;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        final C7418a inner;
        final InterfaceC4584o<? super T, ? extends InterfaceC4513i> mapper;
        InterfaceC4616o<T> queue;

        /* renamed from: s */
        InterfaceC4552c f19471s;
        int sourceMode;

        /* compiled from: ObservableConcatMapCompletable.java */
        /* renamed from: g.a.y0.e.d.w$a$a, reason: collision with other inner class name */
        static final class C7418a extends AtomicReference<InterfaceC4552c> implements InterfaceC4491f {
            private static final long serialVersionUID = -5987419458390772447L;
            final InterfaceC4491f actual;
            final a<?> parent;

            C7418a(InterfaceC4491f interfaceC4491f, a<?> aVar) {
                this.actual = interfaceC4491f;
                this.parent = aVar;
            }

            void dispose() {
                EnumC4592d.dispose(this);
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onError(Throwable th) {
                this.parent.dispose();
                this.actual.onError(th);
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.set(this, interfaceC4552c);
            }
        }

        a(InterfaceC4491f interfaceC4491f, InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o, int i2) {
            this.actual = interfaceC4491f;
            this.mapper = interfaceC4584o;
            this.bufferSize = i2;
            this.inner = new C7418a(interfaceC4491f, this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.disposed = true;
            this.inner.dispose();
            this.f19471s.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.disposed) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        T poll = this.queue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.disposed = true;
                            this.actual.onComplete();
                            return;
                        } else if (!z2) {
                            try {
                                InterfaceC4513i interfaceC4513i = (InterfaceC4513i) C4601b.m18284a(this.mapper.apply(poll), "The mapper returned a null CompletableSource");
                                this.active = true;
                                interfaceC4513i.mo17074a(this.inner);
                            } catch (Throwable th) {
                                C4561b.m18199b(th);
                                dispose();
                                this.queue.clear();
                                this.actual.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        C4561b.m18199b(th2);
                        dispose();
                        this.queue.clear();
                        this.actual.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.done = true;
            dispose();
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19471s, interfaceC4552c)) {
                this.f19471s = interfaceC4552c;
                if (interfaceC4552c instanceof InterfaceC4611j) {
                    InterfaceC4611j interfaceC4611j = (InterfaceC4611j) interfaceC4552c;
                    int requestFusion = interfaceC4611j.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = interfaceC4611j;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
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
    }

    public C5025w(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o, int i2) {
        this.f19468a = interfaceC4504g0;
        this.f19469b = interfaceC4584o;
        this.f19470c = Math.max(8, i2);
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    public void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f19468a.subscribe(new a(interfaceC4491f, this.f19469b, this.f19470c));
    }
}
