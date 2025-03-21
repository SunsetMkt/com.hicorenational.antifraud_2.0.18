package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p001a.InterfaceC0000a;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4611j;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.EnumC5170j;

/* compiled from: ObservableConcatMap.java */
/* renamed from: g.a.y0.e.d.v */
/* loaded from: classes2.dex */
public final class C5020v<T, U> extends AbstractC4907a<T, U> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> f19436b;

    /* renamed from: c */
    final int f19437c;

    /* renamed from: d */
    final EnumC5170j f19438d;

    /* compiled from: ObservableConcatMap.java */
    /* renamed from: g.a.y0.e.d.v$a */
    static final class a<T, R> extends AtomicInteger implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final InterfaceC4514i0<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;

        /* renamed from: d */
        InterfaceC4552c f19439d;
        volatile boolean done;
        final C5163c error = new C5163c();
        final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> mapper;
        final C7416a<R> observer;
        InterfaceC4616o<T> queue;
        int sourceMode;
        final boolean tillTheEnd;

        /* compiled from: ObservableConcatMap.java */
        /* renamed from: g.a.y0.e.d.v$a$a, reason: collision with other inner class name */
        static final class C7416a<R> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final InterfaceC4514i0<? super R> actual;
            final a<?, R> parent;

            C7416a(InterfaceC4514i0<? super R> interfaceC4514i0, a<?, R> aVar) {
                this.actual = interfaceC4514i0;
                this.parent = aVar;
            }

            void dispose() {
                EnumC4592d.dispose(this);
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onComplete() {
                a<?, R> aVar = this.parent;
                aVar.active = false;
                aVar.drain();
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onError(Throwable th) {
                a<?, R> aVar = this.parent;
                if (!aVar.error.addThrowable(th)) {
                    C4476a.m17152b(th);
                    return;
                }
                if (!aVar.tillTheEnd) {
                    aVar.f19439d.dispose();
                }
                aVar.active = false;
                aVar.drain();
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onNext(R r) {
                this.actual.onNext(r);
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.replace(this, interfaceC4552c);
            }
        }

        a(InterfaceC4514i0<? super R> interfaceC4514i0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, int i2, boolean z) {
            this.actual = interfaceC4514i0;
            this.mapper = interfaceC4584o;
            this.bufferSize = i2;
            this.tillTheEnd = z;
            this.observer = new C7416a<>(interfaceC4514i0, this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.cancelled = true;
            this.f19439d.dispose();
            this.observer.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC4514i0<? super R> interfaceC4514i0 = this.actual;
            InterfaceC4616o<T> interfaceC4616o = this.queue;
            C5163c c5163c = this.error;
            while (true) {
                if (!this.active) {
                    if (this.cancelled) {
                        interfaceC4616o.clear();
                        return;
                    }
                    if (!this.tillTheEnd && c5163c.get() != null) {
                        interfaceC4616o.clear();
                        this.cancelled = true;
                        interfaceC4514i0.onError(c5163c.terminate());
                        return;
                    }
                    boolean z = this.done;
                    try {
                        T poll = interfaceC4616o.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.cancelled = true;
                            Throwable terminate = c5163c.terminate();
                            if (terminate != null) {
                                interfaceC4514i0.onError(terminate);
                                return;
                            } else {
                                interfaceC4514i0.onComplete();
                                return;
                            }
                        }
                        if (!z2) {
                            try {
                                InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                if (interfaceC4504g0 instanceof Callable) {
                                    try {
                                        InterfaceC0000a interfaceC0000a = (Object) ((Callable) interfaceC4504g0).call();
                                        if (interfaceC0000a != null && !this.cancelled) {
                                            interfaceC4514i0.onNext(interfaceC0000a);
                                        }
                                    } catch (Throwable th) {
                                        C4561b.m18199b(th);
                                        c5163c.addThrowable(th);
                                    }
                                } else {
                                    this.active = true;
                                    interfaceC4504g0.subscribe(this.observer);
                                }
                            } catch (Throwable th2) {
                                C4561b.m18199b(th2);
                                this.cancelled = true;
                                this.f19439d.dispose();
                                interfaceC4616o.clear();
                                c5163c.addThrowable(th2);
                                interfaceC4514i0.onError(c5163c.terminate());
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        C4561b.m18199b(th3);
                        this.cancelled = true;
                        this.f19439d.dispose();
                        c5163c.addThrowable(th3);
                        interfaceC4514i0.onError(c5163c.terminate());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (!this.error.addThrowable(th)) {
                C4476a.m17152b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19439d, interfaceC4552c)) {
                this.f19439d = interfaceC4552c;
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

    /* compiled from: ObservableConcatMap.java */
    /* renamed from: g.a.y0.e.d.v$b */
    static final class b<T, U> extends AtomicInteger implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final InterfaceC4514i0<? super U> actual;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        int fusionMode;
        final a<U> inner;
        final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> mapper;
        InterfaceC4616o<T> queue;

        /* renamed from: s */
        InterfaceC4552c f19440s;

        /* compiled from: ObservableConcatMap.java */
        /* renamed from: g.a.y0.e.d.v$b$a */
        static final class a<U> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final InterfaceC4514i0<? super U> actual;
            final b<?, ?> parent;

            a(InterfaceC4514i0<? super U> interfaceC4514i0, b<?, ?> bVar) {
                this.actual = interfaceC4514i0;
                this.parent = bVar;
            }

            void dispose() {
                EnumC4592d.dispose(this);
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onError(Throwable th) {
                this.parent.dispose();
                this.actual.onError(th);
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onNext(U u) {
                this.actual.onNext(u);
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.set(this, interfaceC4552c);
            }
        }

        b(InterfaceC4514i0<? super U> interfaceC4514i0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> interfaceC4584o, int i2) {
            this.actual = interfaceC4514i0;
            this.mapper = interfaceC4584o;
            this.bufferSize = i2;
            this.inner = new a<>(interfaceC4514i0, this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.disposed = true;
            this.inner.dispose();
            this.f19440s.dispose();
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
                                InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                this.active = true;
                                interfaceC4504g0.subscribe(this.inner);
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
            if (this.fusionMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19440s, interfaceC4552c)) {
                this.f19440s = interfaceC4552c;
                if (interfaceC4552c instanceof InterfaceC4611j) {
                    InterfaceC4611j interfaceC4611j = (InterfaceC4611j) interfaceC4552c;
                    int requestFusion = interfaceC4611j.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = interfaceC4611j;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
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

    public C5020v(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> interfaceC4584o, int i2, EnumC5170j enumC5170j) {
        super(interfaceC4504g0);
        this.f19436b = interfaceC4584o;
        this.f19438d = enumC5170j;
        this.f19437c = Math.max(8, i2);
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super U> interfaceC4514i0) {
        if (C5008s2.m18520a(this.f18742a, interfaceC4514i0, this.f19436b)) {
            return;
        }
        EnumC5170j enumC5170j = this.f19438d;
        if (enumC5170j == EnumC5170j.IMMEDIATE) {
            this.f18742a.subscribe(new b(new C4466m(interfaceC4514i0), this.f19436b, this.f19437c));
        } else {
            this.f18742a.subscribe(new a(interfaceC4514i0, this.f19436b, this.f19437c, enumC5170j == EnumC5170j.END));
        }
    }
}
