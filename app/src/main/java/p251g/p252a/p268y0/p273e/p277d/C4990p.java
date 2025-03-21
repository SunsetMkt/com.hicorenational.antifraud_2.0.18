package p251g.p252a.p268y0.p273e.p277d;

import java.util.Collection;
import java.util.concurrent.Callable;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.AbstractC4458e;
import p251g.p252a.p253a1.C4466m;
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

/* compiled from: ObservableBufferExactBoundary.java */
/* renamed from: g.a.y0.e.d.p */
/* loaded from: classes2.dex */
public final class C4990p<T, U extends Collection<? super T>, B> extends AbstractC4907a<T, U> {

    /* renamed from: b */
    final InterfaceC4504g0<B> f19256b;

    /* renamed from: c */
    final Callable<U> f19257c;

    /* compiled from: ObservableBufferExactBoundary.java */
    /* renamed from: g.a.y0.e.d.p$a */
    static final class a<T, U extends Collection<? super T>, B> extends AbstractC4458e<B> {

        /* renamed from: b */
        final b<T, U, B> f19258b;

        a(b<T, U, B> bVar) {
            this.f19258b = bVar;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f19258b.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19258b.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(B b2) {
            this.f19258b.m18504f();
        }
    }

    /* compiled from: ObservableBufferExactBoundary.java */
    /* renamed from: g.a.y0.e.d.p$b */
    static final class b<T, U extends Collection<? super T>, B> extends AbstractC4641w<T, U, U> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: K */
        final Callable<U> f19259K;

        /* renamed from: L */
        final InterfaceC4504g0<B> f19260L;

        /* renamed from: M */
        InterfaceC4552c f19261M;

        /* renamed from: N */
        InterfaceC4552c f19262N;

        /* renamed from: O */
        U f19263O;

        b(InterfaceC4514i0<? super U> interfaceC4514i0, Callable<U> callable, InterfaceC4504g0<B> interfaceC4504g0) {
            super(interfaceC4514i0, new C5109a());
            this.f19259K = callable;
            this.f19260L = interfaceC4504g0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p268y0.p272d.AbstractC4641w, p251g.p252a.p268y0.p284j.InterfaceC5178r
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo18302a(InterfaceC4514i0 interfaceC4514i0, Object obj) {
            m18503a((InterfaceC4514i0<? super InterfaceC4514i0>) interfaceC4514i0, (InterfaceC4514i0) obj);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.f17593H) {
                return;
            }
            this.f17593H = true;
            this.f19262N.dispose();
            this.f19261M.dispose();
            if (mo18305b()) {
                this.f17592G.clear();
            }
        }

        /* renamed from: f */
        void m18504f() {
            try {
                U u = (U) C4601b.m18284a(this.f19259K.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.f19263O;
                    if (u2 == null) {
                        return;
                    }
                    this.f19263O = u;
                    m18303a(u2, false, this);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                dispose();
                this.f17591F.onError(th);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17593H;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            synchronized (this) {
                U u = this.f19263O;
                if (u == null) {
                    return;
                }
                this.f19263O = null;
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
                U u = this.f19263O;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19261M, interfaceC4552c)) {
                this.f19261M = interfaceC4552c;
                try {
                    this.f19263O = (U) C4601b.m18284a(this.f19259K.call(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.f19262N = aVar;
                    this.f17591F.onSubscribe(this);
                    if (this.f17593H) {
                        return;
                    }
                    this.f19260L.subscribe(aVar);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.f17593H = true;
                    interfaceC4552c.dispose();
                    EnumC4593e.error(th, this.f17591F);
                }
            }
        }

        /* renamed from: a */
        public void m18503a(InterfaceC4514i0<? super U> interfaceC4514i0, U u) {
            this.f17591F.onNext(u);
        }
    }

    public C4990p(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4504g0<B> interfaceC4504g02, Callable<U> callable) {
        super(interfaceC4504g0);
        this.f19256b = interfaceC4504g02;
        this.f19257c = callable;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super U> interfaceC4514i0) {
        this.f18742a.subscribe(new b(new C4466m(interfaceC4514i0), this.f19257c, this.f19256b));
    }
}
