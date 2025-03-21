package p251g.p252a.p268y0.p273e.p277d;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.AbstractC4458e;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p272d.AbstractC4641w;
import p251g.p252a.p268y0.p280f.C5109a;
import p251g.p252a.p268y0.p284j.C5182v;
import p251g.p252a.p268y0.p284j.InterfaceC5178r;

/* compiled from: ObservableBufferBoundarySupplier.java */
/* renamed from: g.a.y0.e.d.o */
/* loaded from: classes2.dex */
public final class C4985o<T, U extends Collection<? super T>, B> extends AbstractC4907a<T, U> {

    /* renamed from: b */
    final Callable<? extends InterfaceC4504g0<B>> f19223b;

    /* renamed from: c */
    final Callable<U> f19224c;

    /* compiled from: ObservableBufferBoundarySupplier.java */
    /* renamed from: g.a.y0.e.d.o$a */
    static final class a<T, U extends Collection<? super T>, B> extends AbstractC4458e<B> {

        /* renamed from: b */
        final b<T, U, B> f19225b;

        /* renamed from: c */
        boolean f19226c;

        a(b<T, U, B> bVar) {
            this.f19225b = bVar;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19226c) {
                return;
            }
            this.f19226c = true;
            this.f19225b.m18502g();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19226c) {
                C4476a.m17152b(th);
            } else {
                this.f19226c = true;
                this.f19225b.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(B b2) {
            if (this.f19226c) {
                return;
            }
            this.f19226c = true;
            dispose();
            this.f19225b.m18502g();
        }
    }

    /* compiled from: ObservableBufferBoundarySupplier.java */
    /* renamed from: g.a.y0.e.d.o$b */
    static final class b<T, U extends Collection<? super T>, B> extends AbstractC4641w<T, U, U> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: K */
        final Callable<U> f19227K;

        /* renamed from: L */
        final Callable<? extends InterfaceC4504g0<B>> f19228L;

        /* renamed from: M */
        InterfaceC4552c f19229M;

        /* renamed from: N */
        final AtomicReference<InterfaceC4552c> f19230N;

        /* renamed from: O */
        U f19231O;

        b(InterfaceC4514i0<? super U> interfaceC4514i0, Callable<U> callable, Callable<? extends InterfaceC4504g0<B>> callable2) {
            super(interfaceC4514i0, new C5109a());
            this.f19230N = new AtomicReference<>();
            this.f19227K = callable;
            this.f19228L = callable2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p268y0.p272d.AbstractC4641w, p251g.p252a.p268y0.p284j.InterfaceC5178r
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo18302a(InterfaceC4514i0 interfaceC4514i0, Object obj) {
            m18500a((InterfaceC4514i0<? super InterfaceC4514i0>) interfaceC4514i0, (InterfaceC4514i0) obj);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.f17593H) {
                return;
            }
            this.f17593H = true;
            this.f19229M.dispose();
            m18501f();
            if (mo18305b()) {
                this.f17592G.clear();
            }
        }

        /* renamed from: f */
        void m18501f() {
            EnumC4592d.dispose(this.f19230N);
        }

        /* renamed from: g */
        void m18502g() {
            try {
                U u = (U) C4601b.m18284a(this.f19227K.call(), "The buffer supplied is null");
                try {
                    InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.f19228L.call(), "The boundary ObservableSource supplied is null");
                    a aVar = new a(this);
                    if (this.f19230N.compareAndSet(this.f19230N.get(), aVar)) {
                        synchronized (this) {
                            U u2 = this.f19231O;
                            if (u2 == null) {
                                return;
                            }
                            this.f19231O = u;
                            interfaceC4504g0.subscribe(aVar);
                            m18303a(u2, false, this);
                        }
                    }
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.f17593H = true;
                    this.f19229M.dispose();
                    this.f17591F.onError(th);
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                dispose();
                this.f17591F.onError(th2);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17593H;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            synchronized (this) {
                U u = this.f19231O;
                if (u == null) {
                    return;
                }
                this.f19231O = null;
                this.f17592G.offer(u);
                this.f17594I = true;
                if (mo18305b()) {
                    C5182v.m18647a((InterfaceC4615n) this.f17592G, (InterfaceC4514i0) this.f17591F, false, (InterfaceC4552c) this, (InterfaceC5178r) this);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            dispose();
            this.f17591F.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f19231O;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19229M, interfaceC4552c)) {
                this.f19229M = interfaceC4552c;
                InterfaceC4514i0<? super V> interfaceC4514i0 = this.f17591F;
                try {
                    this.f19231O = (U) C4601b.m18284a(this.f19227K.call(), "The buffer supplied is null");
                    try {
                        InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.f19228L.call(), "The boundary ObservableSource supplied is null");
                        a aVar = new a(this);
                        this.f19230N.set(aVar);
                        interfaceC4514i0.onSubscribe(this);
                        if (this.f17593H) {
                            return;
                        }
                        interfaceC4504g0.subscribe(aVar);
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        this.f17593H = true;
                        interfaceC4552c.dispose();
                        EnumC4593e.error(th, interfaceC4514i0);
                    }
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    this.f17593H = true;
                    interfaceC4552c.dispose();
                    EnumC4593e.error(th2, interfaceC4514i0);
                }
            }
        }

        /* renamed from: a */
        public void m18500a(InterfaceC4514i0<? super U> interfaceC4514i0, U u) {
            this.f17591F.onNext(u);
        }
    }

    public C4985o(InterfaceC4504g0<T> interfaceC4504g0, Callable<? extends InterfaceC4504g0<B>> callable, Callable<U> callable2) {
        super(interfaceC4504g0);
        this.f19223b = callable;
        this.f19224c = callable2;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super U> interfaceC4514i0) {
        this.f18742a.subscribe(new b(new C4466m(interfaceC4514i0), this.f19224c, this.f19223b));
    }
}
