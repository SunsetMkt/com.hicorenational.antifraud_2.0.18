package p251g.p252a.p268y0.p273e.p277d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.AbstractC4458e;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p258f1.C4502j;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p272d.AbstractC4641w;
import p251g.p252a.p268y0.p280f.C5109a;
import p251g.p252a.p268y0.p284j.EnumC5177q;

/* compiled from: ObservableWindowBoundarySelector.java */
/* renamed from: g.a.y0.e.d.a4 */
/* loaded from: classes2.dex */
public final class C4912a4<T, B, V> extends AbstractC4907a<T, AbstractC4469b0<T>> {

    /* renamed from: b */
    final InterfaceC4504g0<B> f18758b;

    /* renamed from: c */
    final InterfaceC4584o<? super B, ? extends InterfaceC4504g0<V>> f18759c;

    /* renamed from: d */
    final int f18760d;

    /* compiled from: ObservableWindowBoundarySelector.java */
    /* renamed from: g.a.y0.e.d.a4$a */
    static final class a<T, V> extends AbstractC4458e<V> {

        /* renamed from: b */
        final c<T, ?, V> f18761b;

        /* renamed from: c */
        final C4502j<T> f18762c;

        /* renamed from: d */
        boolean f18763d;

        a(c<T, ?, V> cVar, C4502j<T> c4502j) {
            this.f18761b = cVar;
            this.f18762c = c4502j;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f18763d) {
                return;
            }
            this.f18763d = true;
            this.f18761b.m18414a((a) this);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f18763d) {
                C4476a.m17152b(th);
            } else {
                this.f18763d = true;
                this.f18761b.m18416a(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(V v) {
            if (this.f18763d) {
                return;
            }
            this.f18763d = true;
            dispose();
            this.f18761b.m18414a((a) this);
        }
    }

    /* compiled from: ObservableWindowBoundarySelector.java */
    /* renamed from: g.a.y0.e.d.a4$b */
    static final class b<T, B> extends AbstractC4458e<B> {

        /* renamed from: b */
        final c<T, B, ?> f18764b;

        b(c<T, B, ?> cVar) {
            this.f18764b = cVar;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f18764b.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f18764b.m18416a(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(B b2) {
            this.f18764b.m18415a((c<T, B, ?>) b2);
        }
    }

    /* compiled from: ObservableWindowBoundarySelector.java */
    /* renamed from: g.a.y0.e.d.a4$d */
    static final class d<T, B> {

        /* renamed from: a */
        final C4502j<T> f18773a;

        /* renamed from: b */
        final B f18774b;

        d(C4502j<T> c4502j, B b2) {
            this.f18773a = c4502j;
            this.f18774b = b2;
        }
    }

    public C4912a4(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4504g0<B> interfaceC4504g02, InterfaceC4584o<? super B, ? extends InterfaceC4504g0<V>> interfaceC4584o, int i2) {
        super(interfaceC4504g0);
        this.f18758b = interfaceC4504g02;
        this.f18759c = interfaceC4584o;
        this.f18760d = i2;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super AbstractC4469b0<T>> interfaceC4514i0) {
        this.f18742a.subscribe(new c(new C4466m(interfaceC4514i0), this.f18758b, this.f18759c, this.f18760d));
    }

    /* compiled from: ObservableWindowBoundarySelector.java */
    /* renamed from: g.a.y0.e.d.a4$c */
    static final class c<T, B, V> extends AbstractC4641w<T, Object, AbstractC4469b0<T>> implements InterfaceC4552c {

        /* renamed from: K */
        final InterfaceC4504g0<B> f18765K;

        /* renamed from: L */
        final InterfaceC4584o<? super B, ? extends InterfaceC4504g0<V>> f18766L;

        /* renamed from: M */
        final int f18767M;

        /* renamed from: N */
        final C4551b f18768N;

        /* renamed from: O */
        InterfaceC4552c f18769O;

        /* renamed from: b0 */
        final AtomicReference<InterfaceC4552c> f18770b0;

        /* renamed from: c0 */
        final List<C4502j<T>> f18771c0;

        /* renamed from: d0 */
        final AtomicLong f18772d0;

        c(InterfaceC4514i0<? super AbstractC4469b0<T>> interfaceC4514i0, InterfaceC4504g0<B> interfaceC4504g0, InterfaceC4584o<? super B, ? extends InterfaceC4504g0<V>> interfaceC4584o, int i2) {
            super(interfaceC4514i0, new C5109a());
            this.f18770b0 = new AtomicReference<>();
            this.f18772d0 = new AtomicLong();
            this.f18765K = interfaceC4504g0;
            this.f18766L = interfaceC4584o;
            this.f18767M = i2;
            this.f18768N = new C4551b();
            this.f18771c0 = new ArrayList();
            this.f18772d0.lazySet(1L);
        }

        @Override // p251g.p252a.p268y0.p272d.AbstractC4641w, p251g.p252a.p268y0.p284j.InterfaceC5178r
        /* renamed from: a */
        public void mo18302a(InterfaceC4514i0<? super AbstractC4469b0<T>> interfaceC4514i0, Object obj) {
        }

        /* renamed from: a */
        void m18416a(Throwable th) {
            this.f18769O.dispose();
            this.f18768N.dispose();
            onError(th);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17593H = true;
        }

        /* renamed from: f */
        void m18417f() {
            this.f18768N.dispose();
            EnumC4592d.dispose(this.f18770b0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: g */
        void m18418g() {
            C5109a c5109a = (C5109a) this.f17592G;
            InterfaceC4514i0<? super V> interfaceC4514i0 = this.f17591F;
            List<C4502j<T>> list = this.f18771c0;
            int i2 = 1;
            while (true) {
                boolean z = this.f17594I;
                Object poll = c5109a.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    m18417f();
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
                    list.clear();
                    return;
                }
                if (z2) {
                    i2 = mo18300a(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (poll instanceof d) {
                    d dVar = (d) poll;
                    C4502j<T> c4502j = dVar.f18773a;
                    if (c4502j != null) {
                        if (list.remove(c4502j)) {
                            dVar.f18773a.onComplete();
                            if (this.f18772d0.decrementAndGet() == 0) {
                                m18417f();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f17593H) {
                        C4502j<T> m17369i = C4502j.m17369i(this.f18767M);
                        list.add(m17369i);
                        interfaceC4514i0.onNext(m17369i);
                        try {
                            InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.f18766L.apply(dVar.f18774b), "The ObservableSource supplied is null");
                            a aVar = new a(this, m17369i);
                            if (this.f18768N.mo18181b(aVar)) {
                                this.f18772d0.getAndIncrement();
                                interfaceC4504g0.subscribe(aVar);
                            }
                        } catch (Throwable th2) {
                            C4561b.m18199b(th2);
                            this.f17593H = true;
                            interfaceC4514i0.onError(th2);
                        }
                    }
                } else {
                    Iterator<C4502j<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(EnumC5177q.getValue(poll));
                    }
                }
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17593H;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f17594I) {
                return;
            }
            this.f17594I = true;
            if (mo18305b()) {
                m18418g();
            }
            if (this.f18772d0.decrementAndGet() == 0) {
                this.f18768N.dispose();
            }
            this.f17591F.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f17594I) {
                C4476a.m17152b(th);
                return;
            }
            this.f17595J = th;
            this.f17594I = true;
            if (mo18305b()) {
                m18418g();
            }
            if (this.f18772d0.decrementAndGet() == 0) {
                this.f18768N.dispose();
            }
            this.f17591F.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (m18308e()) {
                Iterator<C4502j<T>> it = this.f18771c0.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
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
            m18418g();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18769O, interfaceC4552c)) {
                this.f18769O = interfaceC4552c;
                this.f17591F.onSubscribe(this);
                if (this.f17593H) {
                    return;
                }
                b bVar = new b(this);
                if (this.f18770b0.compareAndSet(null, bVar)) {
                    this.f18772d0.getAndIncrement();
                    this.f18765K.subscribe(bVar);
                }
            }
        }

        /* renamed from: a */
        void m18415a(B b2) {
            this.f17592G.offer(new d(null, b2));
            if (mo18305b()) {
                m18418g();
            }
        }

        /* renamed from: a */
        void m18414a(a<T, V> aVar) {
            this.f18768N.mo18182c(aVar);
            this.f17592G.offer(new d(aVar.f18762c, null));
            if (mo18305b()) {
                m18418g();
            }
        }
    }
}
