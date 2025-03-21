package p251g.p252a.p268y0.p273e.p277d;

import bean.module.ModuelConfig;
import java.util.concurrent.Callable;
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
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p272d.AbstractC4641w;
import p251g.p252a.p268y0.p280f.C5109a;
import p251g.p252a.p268y0.p284j.EnumC5177q;

/* compiled from: ObservableWindowBoundarySupplier.java */
/* renamed from: g.a.y0.e.d.b4 */
/* loaded from: classes2.dex */
public final class C4918b4<T, B> extends AbstractC4907a<T, AbstractC4469b0<T>> {

    /* renamed from: b */
    final Callable<? extends InterfaceC4504g0<B>> f18802b;

    /* renamed from: c */
    final int f18803c;

    /* compiled from: ObservableWindowBoundarySupplier.java */
    /* renamed from: g.a.y0.e.d.b4$a */
    static final class a<T, B> extends AbstractC4458e<B> {

        /* renamed from: b */
        final b<T, B> f18804b;

        /* renamed from: c */
        boolean f18805c;

        a(b<T, B> bVar) {
            this.f18804b = bVar;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f18805c) {
                return;
            }
            this.f18805c = true;
            this.f18804b.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f18805c) {
                C4476a.m17152b(th);
            } else {
                this.f18805c = true;
                this.f18804b.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(B b2) {
            if (this.f18805c) {
                return;
            }
            this.f18805c = true;
            dispose();
            this.f18804b.m18426g();
        }
    }

    /* compiled from: ObservableWindowBoundarySupplier.java */
    /* renamed from: g.a.y0.e.d.b4$b */
    static final class b<T, B> extends AbstractC4641w<T, Object, AbstractC4469b0<T>> implements InterfaceC4552c {

        /* renamed from: c0 */
        static final Object f18806c0 = new Object();

        /* renamed from: K */
        final Callable<? extends InterfaceC4504g0<B>> f18807K;

        /* renamed from: L */
        final int f18808L;

        /* renamed from: M */
        InterfaceC4552c f18809M;

        /* renamed from: N */
        final AtomicReference<InterfaceC4552c> f18810N;

        /* renamed from: O */
        C4502j<T> f18811O;

        /* renamed from: b0 */
        final AtomicLong f18812b0;

        b(InterfaceC4514i0<? super AbstractC4469b0<T>> interfaceC4514i0, Callable<? extends InterfaceC4504g0<B>> callable, int i2) {
            super(interfaceC4514i0, new C5109a());
            this.f18810N = new AtomicReference<>();
            this.f18812b0 = new AtomicLong();
            this.f18807K = callable;
            this.f18808L = i2;
            this.f18812b0.lazySet(1L);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17593H = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: f */
        void m18425f() {
            C5109a c5109a = (C5109a) this.f17592G;
            InterfaceC4514i0<? super V> interfaceC4514i0 = this.f17591F;
            C4502j<T> c4502j = this.f18811O;
            int i2 = 1;
            while (true) {
                boolean z = this.f17594I;
                Object poll = c5109a.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    EnumC4592d.dispose(this.f18810N);
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
                } else if (poll == f18806c0) {
                    c4502j.onComplete();
                    if (this.f18812b0.decrementAndGet() == 0) {
                        EnumC4592d.dispose(this.f18810N);
                        return;
                    }
                    if (this.f17593H) {
                        continue;
                    } else {
                        try {
                            InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.f18807K.call(), "The ObservableSource supplied is null");
                            C4502j<T> m17369i = C4502j.m17369i(this.f18808L);
                            this.f18812b0.getAndIncrement();
                            this.f18811O = m17369i;
                            interfaceC4514i0.onNext(m17369i);
                            a aVar = new a(this);
                            AtomicReference<InterfaceC4552c> atomicReference = this.f18810N;
                            if (atomicReference.compareAndSet(atomicReference.get(), aVar)) {
                                interfaceC4504g0.subscribe(aVar);
                            }
                            c4502j = m17369i;
                        } catch (Throwable th2) {
                            C4561b.m18199b(th2);
                            EnumC4592d.dispose(this.f18810N);
                            interfaceC4514i0.onError(th2);
                            return;
                        }
                    }
                } else {
                    c4502j.onNext((ModuelConfig.C09401) EnumC5177q.getValue(poll));
                }
            }
        }

        /* renamed from: g */
        void m18426g() {
            this.f17592G.offer(f18806c0);
            if (mo18305b()) {
                m18425f();
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
                m18425f();
            }
            if (this.f18812b0.decrementAndGet() == 0) {
                EnumC4592d.dispose(this.f18810N);
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
                m18425f();
            }
            if (this.f18812b0.decrementAndGet() == 0) {
                EnumC4592d.dispose(this.f18810N);
            }
            this.f17591F.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (m18308e()) {
                this.f18811O.onNext(t);
                if (mo18300a(-1) == 0) {
                    return;
                }
            } else {
                this.f17592G.offer(EnumC5177q.next(t));
                if (!mo18305b()) {
                    return;
                }
            }
            m18425f();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18809M, interfaceC4552c)) {
                this.f18809M = interfaceC4552c;
                InterfaceC4514i0<? super V> interfaceC4514i0 = this.f17591F;
                interfaceC4514i0.onSubscribe(this);
                if (this.f17593H) {
                    return;
                }
                try {
                    InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.f18807K.call(), "The first window ObservableSource supplied is null");
                    C4502j<T> m17369i = C4502j.m17369i(this.f18808L);
                    this.f18811O = m17369i;
                    interfaceC4514i0.onNext(m17369i);
                    a aVar = new a(this);
                    if (this.f18810N.compareAndSet(null, aVar)) {
                        this.f18812b0.getAndIncrement();
                        interfaceC4504g0.subscribe(aVar);
                    }
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    interfaceC4552c.dispose();
                    interfaceC4514i0.onError(th);
                }
            }
        }
    }

    public C4918b4(InterfaceC4504g0<T> interfaceC4504g0, Callable<? extends InterfaceC4504g0<B>> callable, int i2) {
        super(interfaceC4504g0);
        this.f18802b = callable;
        this.f18803c = i2;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super AbstractC4469b0<T>> interfaceC4514i0) {
        this.f18742a.subscribe(new b(new C4466m(interfaceC4514i0), this.f18802b, this.f18803c));
    }
}
