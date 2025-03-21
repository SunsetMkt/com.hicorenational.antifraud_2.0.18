package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p283i.C5159i;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.EnumC5170j;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableConcatMap.java */
/* renamed from: g.a.y0.e.b.w */
/* loaded from: classes2.dex */
public final class C4816w<T, R> extends AbstractC4686a<T, R> {

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> f18463c;

    /* renamed from: d */
    final int f18464d;

    /* renamed from: e */
    final EnumC5170j f18465e;

    /* compiled from: FlowableConcatMap.java */
    /* renamed from: g.a.y0.e.b.w$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f18466a = new int[EnumC5170j.values().length];

        static {
            try {
                f18466a[EnumC5170j.BOUNDARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18466a[EnumC5170j.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: FlowableConcatMap.java */
    /* renamed from: g.a.y0.e.b.w$b */
    static abstract class b<T, R> extends AtomicInteger implements InterfaceC4529q<T>, f<R>, InterfaceC5823d {
        private static final long serialVersionUID = -3511336836796789179L;
        volatile boolean active;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final int limit;
        final InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> mapper;
        final int prefetch;
        InterfaceC4616o<T> queue;

        /* renamed from: s */
        InterfaceC5823d f18467s;
        int sourceMode;
        final e<R> inner = new e<>(this);
        final C5163c errors = new C5163c();

        b(InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, int i2) {
            this.mapper = interfaceC4584o;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        abstract void drain();

        @Override // p251g.p252a.p268y0.p273e.p275b.C4816w.f
        public final void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public final void onComplete() {
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public final void onNext(T t) {
            if (this.sourceMode == 2 || this.queue.offer(t)) {
                drain();
            } else {
                this.f18467s.cancel();
                onError(new IllegalStateException("Queue full?!"));
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public final void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18467s, interfaceC5823d)) {
                this.f18467s = interfaceC5823d;
                if (interfaceC5823d instanceof InterfaceC4613l) {
                    InterfaceC4613l interfaceC4613l = (InterfaceC4613l) interfaceC5823d;
                    int requestFusion = interfaceC4613l.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = interfaceC4613l;
                        this.done = true;
                        subscribeActual();
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = interfaceC4613l;
                        subscribeActual();
                        interfaceC5823d.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new C5110b(this.prefetch);
                subscribeActual();
                interfaceC5823d.request(this.prefetch);
            }
        }

        abstract void subscribeActual();
    }

    /* compiled from: FlowableConcatMap.java */
    /* renamed from: g.a.y0.e.b.w$c */
    static final class c<T, R> extends b<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;
        final InterfaceC5822c<? super R> actual;
        final boolean veryEnd;

        c(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, int i2, boolean z) {
            super(interfaceC4584o, i2);
            this.actual = interfaceC5822c;
            this.veryEnd = z;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.f18467s.cancel();
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4816w.b
        void drain() {
            if (getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z = this.done;
                        if (z && !this.veryEnd && this.errors.get() != null) {
                            this.actual.onError(this.errors.terminate());
                            return;
                        }
                        try {
                            T poll = this.queue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable terminate = this.errors.terminate();
                                if (terminate != null) {
                                    this.actual.onError(terminate);
                                    return;
                                } else {
                                    this.actual.onComplete();
                                    return;
                                }
                            }
                            if (!z2) {
                                try {
                                    InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.mapper.apply(poll), "The mapper returned a null Publisher");
                                    if (this.sourceMode != 1) {
                                        int i2 = this.consumed + 1;
                                        if (i2 == this.limit) {
                                            this.consumed = 0;
                                            this.f18467s.request(i2);
                                        } else {
                                            this.consumed = i2;
                                        }
                                    }
                                    if (interfaceC5821b instanceof Callable) {
                                        try {
                                            Object call = ((Callable) interfaceC5821b).call();
                                            if (call == null) {
                                                continue;
                                            } else if (this.inner.isUnbounded()) {
                                                this.actual.onNext(call);
                                            } else {
                                                this.active = true;
                                                e<R> eVar = this.inner;
                                                eVar.setSubscription(new g(call, eVar));
                                            }
                                        } catch (Throwable th) {
                                            C4561b.m18199b(th);
                                            this.f18467s.cancel();
                                            this.errors.addThrowable(th);
                                            this.actual.onError(this.errors.terminate());
                                            return;
                                        }
                                    } else {
                                        this.active = true;
                                        interfaceC5821b.subscribe(this.inner);
                                    }
                                } catch (Throwable th2) {
                                    C4561b.m18199b(th2);
                                    this.f18467s.cancel();
                                    this.errors.addThrowable(th2);
                                    this.actual.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            C4561b.m18199b(th3);
                            this.f18467s.cancel();
                            this.errors.addThrowable(th3);
                            this.actual.onError(this.errors.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4816w.f
        public void innerError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            if (!this.veryEnd) {
                this.f18467s.cancel();
                this.done = true;
            }
            this.active = false;
            drain();
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4816w.f
        public void innerNext(R r) {
            this.actual.onNext(r);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                C4476a.m17152b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.inner.request(j2);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4816w.b
        void subscribeActual() {
            this.actual.onSubscribe(this);
        }
    }

    /* compiled from: FlowableConcatMap.java */
    /* renamed from: g.a.y0.e.b.w$d */
    static final class d<T, R> extends b<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;
        final InterfaceC5822c<? super R> actual;
        final AtomicInteger wip;

        d(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, int i2) {
            super(interfaceC4584o, i2);
            this.actual = interfaceC5822c;
            this.wip = new AtomicInteger();
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.f18467s.cancel();
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4816w.b
        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z = this.done;
                        try {
                            T poll = this.queue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.actual.onComplete();
                                return;
                            }
                            if (!z2) {
                                try {
                                    InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.mapper.apply(poll), "The mapper returned a null Publisher");
                                    if (this.sourceMode != 1) {
                                        int i2 = this.consumed + 1;
                                        if (i2 == this.limit) {
                                            this.consumed = 0;
                                            this.f18467s.request(i2);
                                        } else {
                                            this.consumed = i2;
                                        }
                                    }
                                    if (interfaceC5821b instanceof Callable) {
                                        try {
                                            Object call = ((Callable) interfaceC5821b).call();
                                            if (call == null) {
                                                continue;
                                            } else if (!this.inner.isUnbounded()) {
                                                this.active = true;
                                                e<R> eVar = this.inner;
                                                eVar.setSubscription(new g(call, eVar));
                                            } else if (get() == 0 && compareAndSet(0, 1)) {
                                                this.actual.onNext(call);
                                                if (!compareAndSet(1, 0)) {
                                                    this.actual.onError(this.errors.terminate());
                                                    return;
                                                }
                                            }
                                        } catch (Throwable th) {
                                            C4561b.m18199b(th);
                                            this.f18467s.cancel();
                                            this.errors.addThrowable(th);
                                            this.actual.onError(this.errors.terminate());
                                            return;
                                        }
                                    } else {
                                        this.active = true;
                                        interfaceC5821b.subscribe(this.inner);
                                    }
                                } catch (Throwable th2) {
                                    C4561b.m18199b(th2);
                                    this.f18467s.cancel();
                                    this.errors.addThrowable(th2);
                                    this.actual.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            C4561b.m18199b(th3);
                            this.f18467s.cancel();
                            this.errors.addThrowable(th3);
                            this.actual.onError(this.errors.terminate());
                            return;
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4816w.f
        public void innerError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            this.f18467s.cancel();
            if (getAndIncrement() == 0) {
                this.actual.onError(this.errors.terminate());
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4816w.f
        public void innerNext(R r) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.actual.onNext(r);
                if (compareAndSet(1, 0)) {
                    return;
                }
                this.actual.onError(this.errors.terminate());
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            this.inner.cancel();
            if (getAndIncrement() == 0) {
                this.actual.onError(this.errors.terminate());
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.inner.request(j2);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4816w.b
        void subscribeActual() {
            this.actual.onSubscribe(this);
        }
    }

    /* compiled from: FlowableConcatMap.java */
    /* renamed from: g.a.y0.e.b.w$e */
    static final class e<R> extends C5159i implements InterfaceC4529q<R> {
        private static final long serialVersionUID = 897683679971470653L;
        final f<R> parent;
        long produced;

        e(f<R> fVar) {
            this.parent = fVar;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            long j2 = this.produced;
            if (j2 != 0) {
                this.produced = 0L;
                produced(j2);
            }
            this.parent.innerComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            long j2 = this.produced;
            if (j2 != 0) {
                this.produced = 0L;
                produced(j2);
            }
            this.parent.innerError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(R r) {
            this.produced++;
            this.parent.innerNext(r);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            setSubscription(interfaceC5823d);
        }
    }

    /* compiled from: FlowableConcatMap.java */
    /* renamed from: g.a.y0.e.b.w$f */
    interface f<T> {
        void innerComplete();

        void innerError(Throwable th);

        void innerNext(T t);
    }

    /* compiled from: FlowableConcatMap.java */
    /* renamed from: g.a.y0.e.b.w$g */
    static final class g<T> implements InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super T> f18468a;

        /* renamed from: b */
        final T f18469b;

        /* renamed from: c */
        boolean f18470c;

        g(T t, InterfaceC5822c<? super T> interfaceC5822c) {
            this.f18469b = t;
            this.f18468a = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (j2 <= 0 || this.f18470c) {
                return;
            }
            this.f18470c = true;
            InterfaceC5822c<? super T> interfaceC5822c = this.f18468a;
            interfaceC5822c.onNext(this.f18469b);
            interfaceC5822c.onComplete();
        }
    }

    public C4816w(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, int i2, EnumC5170j enumC5170j) {
        super(abstractC4519l);
        this.f18463c = interfaceC4584o;
        this.f18464d = i2;
        this.f18465e = enumC5170j;
    }

    /* renamed from: a */
    public static <T, R> InterfaceC5822c<T> m18397a(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, int i2, EnumC5170j enumC5170j) {
        int i3 = a.f18466a[enumC5170j.ordinal()];
        return i3 != 1 ? i3 != 2 ? new d(interfaceC5822c, interfaceC4584o, i2) : new c(interfaceC5822c, interfaceC4584o, i2, true) : new c(interfaceC5822c, interfaceC4584o, i2, false);
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        if (C4708d3.m18317a(this.f17759b, interfaceC5822c, this.f18463c)) {
            return;
        }
        this.f17759b.subscribe(m18397a(interfaceC5822c, this.f18463c, this.f18464d, this.f18465e));
    }
}
