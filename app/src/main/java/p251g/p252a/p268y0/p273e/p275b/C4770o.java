package p251g.p252a.p268y0.p273e.p275b;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p259g1.AbstractC4506b;
import p251g.p252a.p259g1.C4509e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p280f.C5109a;
import p251g.p252a.p268y0.p282h.AbstractC5142m;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5182v;
import p251g.p252a.p268y0.p284j.InterfaceC5181u;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableBufferBoundarySupplier.java */
/* renamed from: g.a.y0.e.b.o */
/* loaded from: classes2.dex */
public final class C4770o<T, U extends Collection<? super T>, B> extends AbstractC4686a<T, U> {

    /* renamed from: c */
    final Callable<? extends InterfaceC5821b<B>> f18142c;

    /* renamed from: d */
    final Callable<U> f18143d;

    /* compiled from: FlowableBufferBoundarySupplier.java */
    /* renamed from: g.a.y0.e.b.o$a */
    static final class a<T, U extends Collection<? super T>, B> extends AbstractC4506b<B> {

        /* renamed from: b */
        final b<T, U, B> f18144b;

        /* renamed from: c */
        boolean f18145c;

        a(b<T, U, B> bVar) {
            this.f18144b = bVar;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18145c) {
                return;
            }
            this.f18145c = true;
            this.f18144b.m18351g();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18145c) {
                C4476a.m17152b(th);
            } else {
                this.f18145c = true;
                this.f18144b.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(B b2) {
            if (this.f18145c) {
                return;
            }
            this.f18145c = true;
            m17380a();
            this.f18144b.m18351g();
        }
    }

    /* compiled from: FlowableBufferBoundarySupplier.java */
    /* renamed from: g.a.y0.e.b.o$b */
    static final class b<T, U extends Collection<? super T>, B> extends AbstractC5142m<T, U, U> implements InterfaceC4529q<T>, InterfaceC5823d, InterfaceC4552c {

        /* renamed from: m0 */
        final Callable<U> f18146m0;

        /* renamed from: n0 */
        final Callable<? extends InterfaceC5821b<B>> f18147n0;

        /* renamed from: o0 */
        InterfaceC5823d f18148o0;

        /* renamed from: p0 */
        final AtomicReference<InterfaceC4552c> f18149p0;

        /* renamed from: q0 */
        U f18150q0;

        b(InterfaceC5822c<? super U> interfaceC5822c, Callable<U> callable, Callable<? extends InterfaceC5821b<B>> callable2) {
            super(interfaceC5822c, new C5109a());
            this.f18149p0 = new AtomicReference<>();
            this.f18146m0 = callable;
            this.f18147n0 = callable2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p268y0.p282h.AbstractC5142m, p251g.p252a.p268y0.p284j.InterfaceC5181u
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo18337a(InterfaceC5822c interfaceC5822c, Object obj) {
            return m18349a((InterfaceC5822c<? super InterfaceC5822c>) interfaceC5822c, (InterfaceC5822c) obj);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.f19968j0) {
                return;
            }
            this.f19968j0 = true;
            this.f18148o0.cancel();
            m18350f();
            if (mo18596b()) {
                this.f19967i0.clear();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18148o0.cancel();
            m18350f();
        }

        /* renamed from: f */
        void m18350f() {
            EnumC4592d.dispose(this.f18149p0);
        }

        /* renamed from: g */
        void m18351g() {
            try {
                U u = (U) C4601b.m18284a(this.f18146m0.call(), "The buffer supplied is null");
                try {
                    InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.f18147n0.call(), "The boundary publisher supplied is null");
                    a aVar = new a(this);
                    if (this.f18149p0.compareAndSet(this.f18149p0.get(), aVar)) {
                        synchronized (this) {
                            U u2 = this.f18150q0;
                            if (u2 == null) {
                                return;
                            }
                            this.f18150q0 = u;
                            interfaceC5821b.subscribe(aVar);
                            m18593a(u2, false, this);
                        }
                    }
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.f19968j0 = true;
                    this.f18148o0.cancel();
                    this.f19966h0.onError(th);
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                cancel();
                this.f19966h0.onError(th2);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18149p0.get() == EnumC4592d.DISPOSED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            synchronized (this) {
                U u = this.f18150q0;
                if (u == null) {
                    return;
                }
                this.f18150q0 = null;
                this.f19967i0.offer(u);
                this.f19969k0 = true;
                if (mo18596b()) {
                    C5182v.m18648a((InterfaceC4615n) this.f19967i0, (InterfaceC5822c) this.f19966h0, false, (InterfaceC4552c) this, (InterfaceC5181u) this);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            cancel();
            this.f19966h0.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f18150q0;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18148o0, interfaceC5823d)) {
                this.f18148o0 = interfaceC5823d;
                InterfaceC5822c<? super V> interfaceC5822c = this.f19966h0;
                try {
                    this.f18150q0 = (U) C4601b.m18284a(this.f18146m0.call(), "The buffer supplied is null");
                    try {
                        InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.f18147n0.call(), "The boundary publisher supplied is null");
                        a aVar = new a(this);
                        this.f18149p0.set(aVar);
                        interfaceC5822c.onSubscribe(this);
                        if (this.f19968j0) {
                            return;
                        }
                        interfaceC5823d.request(C5556m0.f20396b);
                        interfaceC5821b.subscribe(aVar);
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        this.f19968j0 = true;
                        interfaceC5823d.cancel();
                        EnumC5157g.error(th, interfaceC5822c);
                    }
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    this.f19968j0 = true;
                    interfaceC5823d.cancel();
                    EnumC5157g.error(th2, interfaceC5822c);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            m18594b(j2);
        }

        /* renamed from: a */
        public boolean m18349a(InterfaceC5822c<? super U> interfaceC5822c, U u) {
            this.f19966h0.onNext(u);
            return true;
        }
    }

    public C4770o(AbstractC4519l<T> abstractC4519l, Callable<? extends InterfaceC5821b<B>> callable, Callable<U> callable2) {
        super(abstractC4519l);
        this.f18142c = callable;
        this.f18143d = callable2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super U> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new b(new C4509e(interfaceC5822c), this.f18143d, this.f18142c));
    }
}
