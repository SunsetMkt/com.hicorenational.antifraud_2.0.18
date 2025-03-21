package p251g.p252a.p268y0.p273e.p275b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p259g1.AbstractC4506b;
import p251g.p252a.p259g1.C4509e;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p280f.C5109a;
import p251g.p252a.p268y0.p282h.AbstractC5142m;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5182v;
import p251g.p252a.p268y0.p284j.InterfaceC5181u;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableBufferBoundary.java */
/* renamed from: g.a.y0.e.b.n */
/* loaded from: classes2.dex */
public final class C4764n<T, U extends Collection<? super T>, Open, Close> extends AbstractC4686a<T, U> {

    /* renamed from: c */
    final Callable<U> f18098c;

    /* renamed from: d */
    final InterfaceC5821b<? extends Open> f18099d;

    /* renamed from: e */
    final InterfaceC4584o<? super Open, ? extends InterfaceC5821b<? extends Close>> f18100e;

    /* compiled from: FlowableBufferBoundary.java */
    /* renamed from: g.a.y0.e.b.n$a */
    static final class a<T, U extends Collection<? super T>, Open, Close> extends AbstractC5142m<T, U, U> implements InterfaceC5823d, InterfaceC4552c {

        /* renamed from: m0 */
        final InterfaceC5821b<? extends Open> f18101m0;

        /* renamed from: n0 */
        final InterfaceC4584o<? super Open, ? extends InterfaceC5821b<? extends Close>> f18102n0;

        /* renamed from: o0 */
        final Callable<U> f18103o0;

        /* renamed from: p0 */
        final C4551b f18104p0;

        /* renamed from: q0 */
        InterfaceC5823d f18105q0;

        /* renamed from: r0 */
        final List<U> f18106r0;

        /* renamed from: s0 */
        final AtomicInteger f18107s0;

        a(InterfaceC5822c<? super U> interfaceC5822c, InterfaceC5821b<? extends Open> interfaceC5821b, InterfaceC4584o<? super Open, ? extends InterfaceC5821b<? extends Close>> interfaceC4584o, Callable<U> callable) {
            super(interfaceC5822c, new C5109a());
            this.f18107s0 = new AtomicInteger();
            this.f18101m0 = interfaceC5821b;
            this.f18102n0 = interfaceC4584o;
            this.f18103o0 = callable;
            this.f18106r0 = new LinkedList();
            this.f18104p0 = new C4551b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p268y0.p282h.AbstractC5142m, p251g.p252a.p268y0.p284j.InterfaceC5181u
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo18337a(InterfaceC5822c interfaceC5822c, Object obj) {
            return m18343a((InterfaceC5822c<? super InterfaceC5822c>) interfaceC5822c, (InterfaceC5822c) obj);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.f19968j0) {
                return;
            }
            this.f19968j0 = true;
            dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18104p0.dispose();
        }

        /* renamed from: f */
        void m18344f() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.f18106r0);
                this.f18106r0.clear();
            }
            InterfaceC4615n<U> interfaceC4615n = this.f19967i0;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                interfaceC4615n.offer((Collection) it.next());
            }
            this.f19969k0 = true;
            if (mo18596b()) {
                C5182v.m18648a((InterfaceC4615n) interfaceC4615n, (InterfaceC5822c) this.f19966h0, false, (InterfaceC4552c) this, (InterfaceC5181u) this);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18104p0.isDisposed();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18107s0.decrementAndGet() == 0) {
                m18344f();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            cancel();
            this.f19968j0 = true;
            synchronized (this) {
                this.f18106r0.clear();
            }
            this.f19966h0.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.f18106r0.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18105q0, interfaceC5823d)) {
                this.f18105q0 = interfaceC5823d;
                c cVar = new c(this);
                this.f18104p0.mo18181b(cVar);
                this.f19966h0.onSubscribe(this);
                this.f18107s0.lazySet(1);
                this.f18101m0.subscribe(cVar);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            m18594b(j2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public boolean m18343a(InterfaceC5822c<? super U> interfaceC5822c, U u) {
            interfaceC5822c.onNext(u);
            return true;
        }

        /* renamed from: a */
        void m18341a(Open open) {
            if (this.f19968j0) {
                return;
            }
            try {
                Collection collection = (Collection) C4601b.m18284a(this.f18103o0.call(), "The buffer supplied is null");
                try {
                    InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.f18102n0.apply(open), "The buffer closing publisher is null");
                    if (this.f19968j0) {
                        return;
                    }
                    synchronized (this) {
                        if (this.f19968j0) {
                            return;
                        }
                        this.f18106r0.add(collection);
                        b bVar = new b(collection, this);
                        this.f18104p0.mo18181b(bVar);
                        this.f18107s0.getAndIncrement();
                        interfaceC5821b.subscribe(bVar);
                    }
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    onError(th);
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                onError(th2);
            }
        }

        /* renamed from: a */
        void m18340a(InterfaceC4552c interfaceC4552c) {
            if (this.f18104p0.mo18178a(interfaceC4552c) && this.f18107s0.decrementAndGet() == 0) {
                m18344f();
            }
        }

        /* renamed from: a */
        void m18342a(U u, InterfaceC4552c interfaceC4552c) {
            boolean remove;
            synchronized (this) {
                remove = this.f18106r0.remove(u);
            }
            if (remove) {
                m18595b(u, false, this);
            }
            if (this.f18104p0.mo18178a(interfaceC4552c) && this.f18107s0.decrementAndGet() == 0) {
                m18344f();
            }
        }
    }

    /* compiled from: FlowableBufferBoundary.java */
    /* renamed from: g.a.y0.e.b.n$b */
    static final class b<T, U extends Collection<? super T>, Open, Close> extends AbstractC4506b<Close> {

        /* renamed from: b */
        final a<T, U, Open, Close> f18108b;

        /* renamed from: c */
        final U f18109c;

        /* renamed from: d */
        boolean f18110d;

        b(U u, a<T, U, Open, Close> aVar) {
            this.f18108b = aVar;
            this.f18109c = u;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18110d) {
                return;
            }
            this.f18110d = true;
            this.f18108b.m18342a((a<T, U, Open, Close>) this.f18109c, (InterfaceC4552c) this);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18110d) {
                C4476a.m17152b(th);
            } else {
                this.f18108b.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(Close close) {
            onComplete();
        }
    }

    /* compiled from: FlowableBufferBoundary.java */
    /* renamed from: g.a.y0.e.b.n$c */
    static final class c<T, U extends Collection<? super T>, Open, Close> extends AbstractC4506b<Open> {

        /* renamed from: b */
        final a<T, U, Open, Close> f18111b;

        /* renamed from: c */
        boolean f18112c;

        c(a<T, U, Open, Close> aVar) {
            this.f18111b = aVar;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18112c) {
                return;
            }
            this.f18112c = true;
            this.f18111b.m18340a((InterfaceC4552c) this);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18112c) {
                C4476a.m17152b(th);
            } else {
                this.f18112c = true;
                this.f18111b.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(Open open) {
            if (this.f18112c) {
                return;
            }
            this.f18111b.m18341a((a<T, U, Open, Close>) open);
        }
    }

    public C4764n(AbstractC4519l<T> abstractC4519l, InterfaceC5821b<? extends Open> interfaceC5821b, InterfaceC4584o<? super Open, ? extends InterfaceC5821b<? extends Close>> interfaceC4584o, Callable<U> callable) {
        super(abstractC4519l);
        this.f18099d = interfaceC5821b;
        this.f18100e = interfaceC4584o;
        this.f18098c = callable;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super U> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(new C4509e(interfaceC5822c), this.f18099d, this.f18100e, this.f18098c));
    }
}
