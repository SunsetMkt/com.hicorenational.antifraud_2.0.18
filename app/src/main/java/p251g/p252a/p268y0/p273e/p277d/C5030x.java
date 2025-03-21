package p251g.p252a.p268y0.p273e.p277d;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4611j;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p272d.C4638t;
import p251g.p252a.p268y0.p272d.InterfaceC4639u;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.EnumC5170j;

/* compiled from: ObservableConcatMapEager.java */
/* renamed from: g.a.y0.e.d.x */
/* loaded from: classes2.dex */
public final class C5030x<T, R> extends AbstractC4907a<T, R> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> f19492b;

    /* renamed from: c */
    final EnumC5170j f19493c;

    /* renamed from: d */
    final int f19494d;

    /* renamed from: e */
    final int f19495e;

    /* compiled from: ObservableConcatMapEager.java */
    /* renamed from: g.a.y0.e.d.x$a */
    static final class a<T, R> extends AtomicInteger implements InterfaceC4514i0<T>, InterfaceC4552c, InterfaceC4639u<R> {
        private static final long serialVersionUID = 8080567949447303262L;
        int activeCount;
        final InterfaceC4514i0<? super R> actual;
        volatile boolean cancelled;
        C4638t<R> current;

        /* renamed from: d */
        InterfaceC4552c f19496d;
        volatile boolean done;
        final EnumC5170j errorMode;
        final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        InterfaceC4616o<T> queue;
        int sourceMode;
        final C5163c error = new C5163c();
        final ArrayDeque<C4638t<R>> observers = new ArrayDeque<>();

        a(InterfaceC4514i0<? super R> interfaceC4514i0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, int i2, int i3, EnumC5170j enumC5170j) {
            this.actual = interfaceC4514i0;
            this.mapper = interfaceC4584o;
            this.maxConcurrency = i2;
            this.prefetch = i3;
            this.errorMode = enumC5170j;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.cancelled = true;
            if (getAndIncrement() == 0) {
                this.queue.clear();
                disposeAll();
            }
        }

        void disposeAll() {
            C4638t<R> c4638t = this.current;
            if (c4638t != null) {
                c4638t.dispose();
            }
            while (true) {
                C4638t<R> poll = this.observers.poll();
                if (poll == null) {
                    return;
                } else {
                    poll.dispose();
                }
            }
        }

        @Override // p251g.p252a.p268y0.p272d.InterfaceC4639u
        public void drain() {
            R poll;
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC4616o<T> interfaceC4616o = this.queue;
            ArrayDeque<C4638t<R>> arrayDeque = this.observers;
            InterfaceC4514i0<? super R> interfaceC4514i0 = this.actual;
            EnumC5170j enumC5170j = this.errorMode;
            int i2 = 1;
            while (true) {
                int i3 = this.activeCount;
                while (i3 != this.maxConcurrency) {
                    if (this.cancelled) {
                        interfaceC4616o.clear();
                        disposeAll();
                        return;
                    }
                    if (enumC5170j == EnumC5170j.IMMEDIATE && this.error.get() != null) {
                        interfaceC4616o.clear();
                        disposeAll();
                        interfaceC4514i0.onError(this.error.terminate());
                        return;
                    }
                    try {
                        T poll2 = interfaceC4616o.poll();
                        if (poll2 == null) {
                            break;
                        }
                        InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.mapper.apply(poll2), "The mapper returned a null ObservableSource");
                        C4638t<R> c4638t = new C4638t<>(this, this.prefetch);
                        arrayDeque.offer(c4638t);
                        interfaceC4504g0.subscribe(c4638t);
                        i3++;
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        this.f19496d.dispose();
                        interfaceC4616o.clear();
                        disposeAll();
                        this.error.addThrowable(th);
                        interfaceC4514i0.onError(this.error.terminate());
                        return;
                    }
                }
                this.activeCount = i3;
                if (this.cancelled) {
                    interfaceC4616o.clear();
                    disposeAll();
                    return;
                }
                if (enumC5170j == EnumC5170j.IMMEDIATE && this.error.get() != null) {
                    interfaceC4616o.clear();
                    disposeAll();
                    interfaceC4514i0.onError(this.error.terminate());
                    return;
                }
                C4638t<R> c4638t2 = this.current;
                if (c4638t2 == null) {
                    if (enumC5170j == EnumC5170j.BOUNDARY && this.error.get() != null) {
                        interfaceC4616o.clear();
                        disposeAll();
                        interfaceC4514i0.onError(this.error.terminate());
                        return;
                    }
                    boolean z2 = this.done;
                    C4638t<R> poll3 = arrayDeque.poll();
                    boolean z3 = poll3 == null;
                    if (z2 && z3) {
                        if (this.error.get() == null) {
                            interfaceC4514i0.onComplete();
                            return;
                        }
                        interfaceC4616o.clear();
                        disposeAll();
                        interfaceC4514i0.onError(this.error.terminate());
                        return;
                    }
                    if (!z3) {
                        this.current = poll3;
                    }
                    c4638t2 = poll3;
                }
                if (c4638t2 != null) {
                    InterfaceC4616o<R> queue = c4638t2.queue();
                    while (!this.cancelled) {
                        boolean isDone = c4638t2.isDone();
                        if (enumC5170j == EnumC5170j.IMMEDIATE && this.error.get() != null) {
                            interfaceC4616o.clear();
                            disposeAll();
                            interfaceC4514i0.onError(this.error.terminate());
                            return;
                        }
                        try {
                            poll = queue.poll();
                            z = poll == null;
                        } catch (Throwable th2) {
                            C4561b.m18199b(th2);
                            this.error.addThrowable(th2);
                            this.current = null;
                            this.activeCount--;
                        }
                        if (isDone && z) {
                            this.current = null;
                            this.activeCount--;
                        } else if (!z) {
                            interfaceC4514i0.onNext(poll);
                        }
                    }
                    interfaceC4616o.clear();
                    disposeAll();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        @Override // p251g.p252a.p268y0.p272d.InterfaceC4639u
        public void innerComplete(C4638t<R> c4638t) {
            c4638t.setDone();
            drain();
        }

        @Override // p251g.p252a.p268y0.p272d.InterfaceC4639u
        public void innerError(C4638t<R> c4638t, Throwable th) {
            if (!this.error.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            if (this.errorMode == EnumC5170j.IMMEDIATE) {
                this.f19496d.dispose();
            }
            c4638t.setDone();
            drain();
        }

        @Override // p251g.p252a.p268y0.p272d.InterfaceC4639u
        public void innerNext(C4638t<R> c4638t, R r) {
            c4638t.queue().offer(r);
            drain();
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
            if (EnumC4592d.validate(this.f19496d, interfaceC4552c)) {
                this.f19496d = interfaceC4552c;
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
                this.queue = new C5111c(this.prefetch);
                this.actual.onSubscribe(this);
            }
        }
    }

    public C5030x(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, EnumC5170j enumC5170j, int i2, int i3) {
        super(interfaceC4504g0);
        this.f19492b = interfaceC4584o;
        this.f19493c = enumC5170j;
        this.f19494d = i2;
        this.f19495e = i3;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19492b, this.f19494d, this.f19495e, this.f19493c));
    }
}
