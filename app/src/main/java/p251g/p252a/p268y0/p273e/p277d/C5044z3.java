package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.AbstractC4458e;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p258f1.C4502j;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p272d.AbstractC4641w;
import p251g.p252a.p268y0.p280f.C5109a;
import p251g.p252a.p268y0.p284j.EnumC5177q;

/* compiled from: ObservableWindowBoundary.java */
/* renamed from: g.a.y0.e.d.z3 */
/* loaded from: classes2.dex */
public final class C5044z3<T, B> extends AbstractC4907a<T, AbstractC4469b0<T>> {

    /* renamed from: b */
    final InterfaceC4504g0<B> f19549b;

    /* renamed from: c */
    final int f19550c;

    /* compiled from: ObservableWindowBoundary.java */
    /* renamed from: g.a.y0.e.d.z3$a */
    static final class a<T, B> extends AbstractC4458e<B> {

        /* renamed from: b */
        final b<T, B> f19551b;

        /* renamed from: c */
        boolean f19552c;

        a(b<T, B> bVar) {
            this.f19551b = bVar;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19552c) {
                return;
            }
            this.f19552c = true;
            this.f19551b.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19552c) {
                C4476a.m17152b(th);
            } else {
                this.f19552c = true;
                this.f19551b.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(B b2) {
            if (this.f19552c) {
                return;
            }
            this.f19551b.m18522g();
        }
    }

    /* compiled from: ObservableWindowBoundary.java */
    /* renamed from: g.a.y0.e.d.z3$b */
    static final class b<T, B> extends AbstractC4641w<T, Object, AbstractC4469b0<T>> implements InterfaceC4552c {

        /* renamed from: c0 */
        static final Object f19553c0 = new Object();

        /* renamed from: K */
        final InterfaceC4504g0<B> f19554K;

        /* renamed from: L */
        final int f19555L;

        /* renamed from: M */
        InterfaceC4552c f19556M;

        /* renamed from: N */
        final AtomicReference<InterfaceC4552c> f19557N;

        /* renamed from: O */
        C4502j<T> f19558O;

        /* renamed from: b0 */
        final AtomicLong f19559b0;

        b(InterfaceC4514i0<? super AbstractC4469b0<T>> interfaceC4514i0, InterfaceC4504g0<B> interfaceC4504g0, int i2) {
            super(interfaceC4514i0, new C5109a());
            this.f19557N = new AtomicReference<>();
            this.f19559b0 = new AtomicLong();
            this.f19554K = interfaceC4504g0;
            this.f19555L = i2;
            this.f19559b0.lazySet(1L);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17593H = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [g.a.f1.j<T>] */
        /* renamed from: f */
        void m18521f() {
            C5109a c5109a = (C5109a) this.f17592G;
            InterfaceC4514i0<? super V> interfaceC4514i0 = this.f17591F;
            C4502j<T> c4502j = this.f19558O;
            int i2 = 1;
            while (true) {
                boolean z = this.f17594I;
                Object poll = c5109a.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    EnumC4592d.dispose(this.f19557N);
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
                } else if (poll == f19553c0) {
                    c4502j.onComplete();
                    if (this.f19559b0.decrementAndGet() == 0) {
                        EnumC4592d.dispose(this.f19557N);
                        return;
                    } else if (!this.f17593H) {
                        c4502j = (C4502j<T>) C4502j.m17369i(this.f19555L);
                        this.f19559b0.getAndIncrement();
                        this.f19558O = c4502j;
                        interfaceC4514i0.onNext(c4502j);
                    }
                } else {
                    c4502j.onNext(EnumC5177q.getValue(poll));
                }
            }
        }

        /* renamed from: g */
        void m18522g() {
            this.f17592G.offer(f19553c0);
            if (mo18305b()) {
                m18521f();
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
                m18521f();
            }
            if (this.f19559b0.decrementAndGet() == 0) {
                EnumC4592d.dispose(this.f19557N);
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
                m18521f();
            }
            if (this.f19559b0.decrementAndGet() == 0) {
                EnumC4592d.dispose(this.f19557N);
            }
            this.f17591F.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (m18308e()) {
                this.f19558O.onNext(t);
                if (mo18300a(-1) == 0) {
                    return;
                }
            } else {
                this.f17592G.offer(EnumC5177q.next(t));
                if (!mo18305b()) {
                    return;
                }
            }
            m18521f();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19556M, interfaceC4552c)) {
                this.f19556M = interfaceC4552c;
                InterfaceC4514i0<? super V> interfaceC4514i0 = this.f17591F;
                interfaceC4514i0.onSubscribe(this);
                if (this.f17593H) {
                    return;
                }
                C4502j<T> m17369i = C4502j.m17369i(this.f19555L);
                this.f19558O = m17369i;
                interfaceC4514i0.onNext(m17369i);
                a aVar = new a(this);
                if (this.f19557N.compareAndSet(null, aVar)) {
                    this.f19559b0.getAndIncrement();
                    this.f19554K.subscribe(aVar);
                }
            }
        }
    }

    public C5044z3(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4504g0<B> interfaceC4504g02, int i2) {
        super(interfaceC4504g0);
        this.f19549b = interfaceC4504g02;
        this.f19550c = i2;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super AbstractC4469b0<T>> interfaceC4514i0) {
        this.f18742a.subscribe(new b(new C4466m(interfaceC4514i0), this.f19549b, this.f19550c));
    }
}
