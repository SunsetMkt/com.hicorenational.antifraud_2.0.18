package p251g.p252a.p268y0.p273e.p277d;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p258f1.C4502j;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p272d.AbstractC4641w;
import p251g.p252a.p268y0.p280f.C5109a;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p286h.p309q2.p311t.C5556m0;

/* compiled from: ObservableWindowTimed.java */
/* renamed from: g.a.y0.e.d.c4 */
/* loaded from: classes2.dex */
public final class C4924c4<T> extends AbstractC4907a<T, AbstractC4469b0<T>> {

    /* renamed from: b */
    final long f18841b;

    /* renamed from: c */
    final long f18842c;

    /* renamed from: d */
    final TimeUnit f18843d;

    /* renamed from: e */
    final AbstractC4516j0 f18844e;

    /* renamed from: f */
    final long f18845f;

    /* renamed from: g */
    final int f18846g;

    /* renamed from: h */
    final boolean f18847h;

    /* compiled from: ObservableWindowTimed.java */
    /* renamed from: g.a.y0.e.d.c4$a */
    static final class a<T> extends AbstractC4641w<T, Object, AbstractC4469b0<T>> implements InterfaceC4552c {

        /* renamed from: K */
        final long f18848K;

        /* renamed from: L */
        final TimeUnit f18849L;

        /* renamed from: M */
        final AbstractC4516j0 f18850M;

        /* renamed from: N */
        final int f18851N;

        /* renamed from: O */
        final boolean f18852O;

        /* renamed from: b0 */
        final long f18853b0;

        /* renamed from: c0 */
        final AbstractC4516j0.c f18854c0;

        /* renamed from: d0 */
        long f18855d0;

        /* renamed from: e0 */
        long f18856e0;

        /* renamed from: f0 */
        InterfaceC4552c f18857f0;

        /* renamed from: g0 */
        C4502j<T> f18858g0;

        /* renamed from: h0 */
        volatile boolean f18859h0;

        /* renamed from: i0 */
        final AtomicReference<InterfaceC4552c> f18860i0;

        /* compiled from: ObservableWindowTimed.java */
        /* renamed from: g.a.y0.e.d.c4$a$a, reason: collision with other inner class name */
        static final class RunnableC7410a implements Runnable {

            /* renamed from: a */
            final long f18861a;

            /* renamed from: b */
            final a<?> f18862b;

            RunnableC7410a(long j2, a<?> aVar) {
                this.f18861a = j2;
                this.f18862b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.f18862b;
                if (((AbstractC4641w) aVar).f17593H) {
                    aVar.f18859h0 = true;
                    aVar.m18431f();
                } else {
                    ((AbstractC4641w) aVar).f17592G.offer(this);
                }
                if (aVar.mo18305b()) {
                    aVar.m18432g();
                }
            }
        }

        a(InterfaceC4514i0<? super AbstractC4469b0<T>> interfaceC4514i0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2, long j3, boolean z) {
            super(interfaceC4514i0, new C5109a());
            this.f18860i0 = new AtomicReference<>();
            this.f18848K = j2;
            this.f18849L = timeUnit;
            this.f18850M = abstractC4516j0;
            this.f18851N = i2;
            this.f18853b0 = j3;
            this.f18852O = z;
            if (z) {
                this.f18854c0 = abstractC4516j0.mo17277a();
            } else {
                this.f18854c0 = null;
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17593H = true;
        }

        /* renamed from: f */
        void m18431f() {
            EnumC4592d.dispose(this.f18860i0);
            AbstractC4516j0.c cVar = this.f18854c0;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [g.a.i0, g.a.i0<? super V>] */
        /* JADX WARN: Type inference failed for: r4v8, types: [g.a.f1.j] */
        /* renamed from: g */
        void m18432g() {
            C5109a c5109a = (C5109a) this.f17592G;
            ?? r1 = this.f17591F;
            C4502j c4502j = this.f18858g0;
            int i2 = 1;
            while (!this.f18859h0) {
                boolean z = this.f17594I;
                Object poll = c5109a.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof RunnableC7410a;
                if (z && (z2 || z3)) {
                    this.f18858g0 = null;
                    c5109a.clear();
                    m18431f();
                    Throwable th = this.f17595J;
                    if (th != null) {
                        c4502j.onError(th);
                        return;
                    } else {
                        c4502j.onComplete();
                        return;
                    }
                }
                if (z2) {
                    i2 = mo18300a(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (z3) {
                    RunnableC7410a runnableC7410a = (RunnableC7410a) poll;
                    if (this.f18852O || this.f18856e0 == runnableC7410a.f18861a) {
                        c4502j.onComplete();
                        this.f18855d0 = 0L;
                        c4502j = (C4502j<T>) C4502j.m17369i(this.f18851N);
                        this.f18858g0 = c4502j;
                        r1.onNext(c4502j);
                    }
                } else {
                    c4502j.onNext(EnumC5177q.getValue(poll));
                    long j2 = this.f18855d0 + 1;
                    if (j2 >= this.f18853b0) {
                        this.f18856e0++;
                        this.f18855d0 = 0L;
                        c4502j.onComplete();
                        c4502j = (C4502j<T>) C4502j.m17369i(this.f18851N);
                        this.f18858g0 = c4502j;
                        this.f17591F.onNext(c4502j);
                        if (this.f18852O) {
                            InterfaceC4552c interfaceC4552c = this.f18860i0.get();
                            interfaceC4552c.dispose();
                            AbstractC4516j0.c cVar = this.f18854c0;
                            RunnableC7410a runnableC7410a2 = new RunnableC7410a(this.f18856e0, this);
                            long j3 = this.f18848K;
                            InterfaceC4552c mo17412a = cVar.mo17412a(runnableC7410a2, j3, j3, this.f18849L);
                            if (!this.f18860i0.compareAndSet(interfaceC4552c, mo17412a)) {
                                mo17412a.dispose();
                            }
                        }
                    } else {
                        this.f18855d0 = j2;
                    }
                }
            }
            this.f18857f0.dispose();
            c5109a.clear();
            m18431f();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17593H;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f17594I = true;
            if (mo18305b()) {
                m18432g();
            }
            this.f17591F.onComplete();
            m18431f();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f17595J = th;
            this.f17594I = true;
            if (mo18305b()) {
                m18432g();
            }
            this.f17591F.onError(th);
            m18431f();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f18859h0) {
                return;
            }
            if (m18308e()) {
                C4502j<T> c4502j = this.f18858g0;
                c4502j.onNext(t);
                long j2 = this.f18855d0 + 1;
                if (j2 >= this.f18853b0) {
                    this.f18856e0++;
                    this.f18855d0 = 0L;
                    c4502j.onComplete();
                    C4502j<T> m17369i = C4502j.m17369i(this.f18851N);
                    this.f18858g0 = m17369i;
                    this.f17591F.onNext(m17369i);
                    if (this.f18852O) {
                        this.f18860i0.get().dispose();
                        AbstractC4516j0.c cVar = this.f18854c0;
                        RunnableC7410a runnableC7410a = new RunnableC7410a(this.f18856e0, this);
                        long j3 = this.f18848K;
                        EnumC4592d.replace(this.f18860i0, cVar.mo17412a(runnableC7410a, j3, j3, this.f18849L));
                    }
                } else {
                    this.f18855d0 = j2;
                }
                if (mo18300a(-1) == 0) {
                    return;
                }
            } else {
                this.f17592G.offer(EnumC5177q.next(t));
                if (!mo18305b()) {
                    return;
                }
            }
            m18432g();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            InterfaceC4552c mo17408a;
            if (EnumC4592d.validate(this.f18857f0, interfaceC4552c)) {
                this.f18857f0 = interfaceC4552c;
                InterfaceC4514i0<? super V> interfaceC4514i0 = this.f17591F;
                interfaceC4514i0.onSubscribe(this);
                if (this.f17593H) {
                    return;
                }
                C4502j<T> m17369i = C4502j.m17369i(this.f18851N);
                this.f18858g0 = m17369i;
                interfaceC4514i0.onNext(m17369i);
                RunnableC7410a runnableC7410a = new RunnableC7410a(this.f18856e0, this);
                if (this.f18852O) {
                    AbstractC4516j0.c cVar = this.f18854c0;
                    long j2 = this.f18848K;
                    mo17408a = cVar.mo17412a(runnableC7410a, j2, j2, this.f18849L);
                } else {
                    AbstractC4516j0 abstractC4516j0 = this.f18850M;
                    long j3 = this.f18848K;
                    mo17408a = abstractC4516j0.mo17408a(runnableC7410a, j3, j3, this.f18849L);
                }
                EnumC4592d.replace(this.f18860i0, mo17408a);
            }
        }
    }

    /* compiled from: ObservableWindowTimed.java */
    /* renamed from: g.a.y0.e.d.c4$b */
    static final class b<T> extends AbstractC4641w<T, Object, AbstractC4469b0<T>> implements InterfaceC4514i0<T>, InterfaceC4552c, Runnable {

        /* renamed from: e0 */
        static final Object f18863e0 = new Object();

        /* renamed from: K */
        final long f18864K;

        /* renamed from: L */
        final TimeUnit f18865L;

        /* renamed from: M */
        final AbstractC4516j0 f18866M;

        /* renamed from: N */
        final int f18867N;

        /* renamed from: O */
        InterfaceC4552c f18868O;

        /* renamed from: b0 */
        C4502j<T> f18869b0;

        /* renamed from: c0 */
        final AtomicReference<InterfaceC4552c> f18870c0;

        /* renamed from: d0 */
        volatile boolean f18871d0;

        b(InterfaceC4514i0<? super AbstractC4469b0<T>> interfaceC4514i0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2) {
            super(interfaceC4514i0, new C5109a());
            this.f18870c0 = new AtomicReference<>();
            this.f18864K = j2;
            this.f18865L = timeUnit;
            this.f18866M = abstractC4516j0;
            this.f18867N = i2;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17593H = true;
        }

        /* renamed from: f */
        void m18433f() {
            EnumC4592d.dispose(this.f18870c0);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            r7.f18869b0 = null;
            r0.clear();
            m18433f();
            r0 = r7.f17595J;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [g.a.f1.j<T>] */
        /* renamed from: g */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void m18434g() {
            /*
                r7 = this;
                g.a.y0.c.n<U> r0 = r7.f17592G
                g.a.y0.f.a r0 = (p251g.p252a.p268y0.p280f.C5109a) r0
                g.a.i0<? super V> r1 = r7.f17591F
                g.a.f1.j<T> r2 = r7.f18869b0
                r3 = 1
            L9:
                boolean r4 = r7.f18871d0
                boolean r5 = r7.f17594I
                java.lang.Object r6 = r0.poll()
                if (r5 == 0) goto L2e
                if (r6 == 0) goto L19
                java.lang.Object r5 = p251g.p252a.p268y0.p273e.p277d.C4924c4.b.f18863e0
                if (r6 != r5) goto L2e
            L19:
                r1 = 0
                r7.f18869b0 = r1
                r0.clear()
                r7.m18433f()
                java.lang.Throwable r0 = r7.f17595J
                if (r0 == 0) goto L2a
                r2.onError(r0)
                goto L2d
            L2a:
                r2.onComplete()
            L2d:
                return
            L2e:
                if (r6 != 0) goto L38
                int r3 = -r3
                int r3 = r7.mo18300a(r3)
                if (r3 != 0) goto L9
                return
            L38:
                java.lang.Object r5 = p251g.p252a.p268y0.p273e.p277d.C4924c4.b.f18863e0
                if (r6 != r5) goto L53
                r2.onComplete()
                if (r4 != 0) goto L4d
                int r2 = r7.f18867N
                g.a.f1.j r2 = p251g.p252a.p258f1.C4502j.m17369i(r2)
                r7.f18869b0 = r2
                r1.onNext(r2)
                goto L9
            L4d:
                g.a.u0.c r4 = r7.f18868O
                r4.dispose()
                goto L9
            L53:
                java.lang.Object r4 = p251g.p252a.p268y0.p284j.EnumC5177q.getValue(r6)
                r2.onNext(r4)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p277d.C4924c4.b.m18434g():void");
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17593H;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f17594I = true;
            if (mo18305b()) {
                m18434g();
            }
            m18433f();
            this.f17591F.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f17595J = th;
            this.f17594I = true;
            if (mo18305b()) {
                m18434g();
            }
            m18433f();
            this.f17591F.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f18871d0) {
                return;
            }
            if (m18308e()) {
                this.f18869b0.onNext(t);
                if (mo18300a(-1) == 0) {
                    return;
                }
            } else {
                this.f17592G.offer(EnumC5177q.next(t));
                if (!mo18305b()) {
                    return;
                }
            }
            m18434g();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18868O, interfaceC4552c)) {
                this.f18868O = interfaceC4552c;
                this.f18869b0 = C4502j.m17369i(this.f18867N);
                InterfaceC4514i0<? super V> interfaceC4514i0 = this.f17591F;
                interfaceC4514i0.onSubscribe(this);
                interfaceC4514i0.onNext(this.f18869b0);
                if (this.f17593H) {
                    return;
                }
                AbstractC4516j0 abstractC4516j0 = this.f18866M;
                long j2 = this.f18864K;
                EnumC4592d.replace(this.f18870c0, abstractC4516j0.mo17408a(this, j2, j2, this.f18865L));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17593H) {
                this.f18871d0 = true;
                m18433f();
            }
            this.f17592G.offer(f18863e0);
            if (mo18305b()) {
                m18434g();
            }
        }
    }

    /* compiled from: ObservableWindowTimed.java */
    /* renamed from: g.a.y0.e.d.c4$c */
    static final class c<T> extends AbstractC4641w<T, Object, AbstractC4469b0<T>> implements InterfaceC4552c, Runnable {

        /* renamed from: K */
        final long f18872K;

        /* renamed from: L */
        final long f18873L;

        /* renamed from: M */
        final TimeUnit f18874M;

        /* renamed from: N */
        final AbstractC4516j0.c f18875N;

        /* renamed from: O */
        final int f18876O;

        /* renamed from: b0 */
        final List<C4502j<T>> f18877b0;

        /* renamed from: c0 */
        InterfaceC4552c f18878c0;

        /* renamed from: d0 */
        volatile boolean f18879d0;

        /* compiled from: ObservableWindowTimed.java */
        /* renamed from: g.a.y0.e.d.c4$c$a */
        final class a implements Runnable {

            /* renamed from: a */
            private final C4502j<T> f18880a;

            a(C4502j<T> c4502j) {
                this.f18880a = c4502j;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.m18435a(this.f18880a);
            }
        }

        /* compiled from: ObservableWindowTimed.java */
        /* renamed from: g.a.y0.e.d.c4$c$b */
        static final class b<T> {

            /* renamed from: a */
            final C4502j<T> f18882a;

            /* renamed from: b */
            final boolean f18883b;

            b(C4502j<T> c4502j, boolean z) {
                this.f18882a = c4502j;
                this.f18883b = z;
            }
        }

        c(InterfaceC4514i0<? super AbstractC4469b0<T>> interfaceC4514i0, long j2, long j3, TimeUnit timeUnit, AbstractC4516j0.c cVar, int i2) {
            super(interfaceC4514i0, new C5109a());
            this.f18872K = j2;
            this.f18873L = j3;
            this.f18874M = timeUnit;
            this.f18875N = cVar;
            this.f18876O = i2;
            this.f18877b0 = new LinkedList();
        }

        /* renamed from: a */
        void m18435a(C4502j<T> c4502j) {
            this.f17592G.offer(new b(c4502j, false));
            if (mo18305b()) {
                m18437g();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17593H = true;
        }

        /* renamed from: f */
        void m18436f() {
            this.f18875N.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: g */
        void m18437g() {
            C5109a c5109a = (C5109a) this.f17592G;
            InterfaceC4514i0<? super V> interfaceC4514i0 = this.f17591F;
            List<C4502j<T>> list = this.f18877b0;
            int i2 = 1;
            while (!this.f18879d0) {
                boolean z = this.f17594I;
                Object poll = c5109a.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof b;
                if (z && (z2 || z3)) {
                    c5109a.clear();
                    Throwable th = this.f17595J;
                    if (th != null) {
                        Iterator<C4502j<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<C4502j<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    m18436f();
                    list.clear();
                    return;
                }
                if (z2) {
                    i2 = mo18300a(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (z3) {
                    b bVar = (b) poll;
                    if (!bVar.f18883b) {
                        list.remove(bVar.f18882a);
                        bVar.f18882a.onComplete();
                        if (list.isEmpty() && this.f17593H) {
                            this.f18879d0 = true;
                        }
                    } else if (!this.f17593H) {
                        C4502j<T> m17369i = C4502j.m17369i(this.f18876O);
                        list.add(m17369i);
                        interfaceC4514i0.onNext(m17369i);
                        this.f18875N.mo17283a(new a(m17369i), this.f18872K, this.f18874M);
                    }
                } else {
                    Iterator<C4502j<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(poll);
                    }
                }
            }
            this.f18878c0.dispose();
            m18436f();
            c5109a.clear();
            list.clear();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17593H;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f17594I = true;
            if (mo18305b()) {
                m18437g();
            }
            this.f17591F.onComplete();
            m18436f();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f17595J = th;
            this.f17594I = true;
            if (mo18305b()) {
                m18437g();
            }
            this.f17591F.onError(th);
            m18436f();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (m18308e()) {
                Iterator<C4502j<T>> it = this.f18877b0.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (mo18300a(-1) == 0) {
                    return;
                }
            } else {
                this.f17592G.offer(t);
                if (!mo18305b()) {
                    return;
                }
            }
            m18437g();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18878c0, interfaceC4552c)) {
                this.f18878c0 = interfaceC4552c;
                this.f17591F.onSubscribe(this);
                if (this.f17593H) {
                    return;
                }
                C4502j<T> m17369i = C4502j.m17369i(this.f18876O);
                this.f18877b0.add(m17369i);
                this.f17591F.onNext(m17369i);
                this.f18875N.mo17283a(new a(m17369i), this.f18872K, this.f18874M);
                AbstractC4516j0.c cVar = this.f18875N;
                long j2 = this.f18873L;
                cVar.mo17412a(this, j2, j2, this.f18874M);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = new b(C4502j.m17369i(this.f18876O), true);
            if (!this.f17593H) {
                this.f17592G.offer(bVar);
            }
            if (mo18305b()) {
                m18437g();
            }
        }
    }

    public C4924c4(InterfaceC4504g0<T> interfaceC4504g0, long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, long j4, int i2, boolean z) {
        super(interfaceC4504g0);
        this.f18841b = j2;
        this.f18842c = j3;
        this.f18843d = timeUnit;
        this.f18844e = abstractC4516j0;
        this.f18845f = j4;
        this.f18846g = i2;
        this.f18847h = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super AbstractC4469b0<T>> interfaceC4514i0) {
        C4466m c4466m = new C4466m(interfaceC4514i0);
        long j2 = this.f18841b;
        long j3 = this.f18842c;
        if (j2 != j3) {
            this.f18742a.subscribe(new c(c4466m, j2, j3, this.f18843d, this.f18844e.mo17277a(), this.f18846g));
            return;
        }
        long j4 = this.f18845f;
        if (j4 == C5556m0.f20396b) {
            this.f18742a.subscribe(new b(c4466m, j2, this.f18843d, this.f18844e, this.f18846g));
        } else {
            this.f18742a.subscribe(new a(c4466m, j2, this.f18843d, this.f18844e, this.f18846g, j4, this.f18847h));
        }
    }
}
