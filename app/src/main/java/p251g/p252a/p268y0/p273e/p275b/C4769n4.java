package p251g.p252a.p268y0.p273e.p275b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p256d1.C4485g;
import p251g.p252a.p259g1.AbstractC4506b;
import p251g.p252a.p259g1.C4509e;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5109a;
import p251g.p252a.p268y0.p282h.AbstractC5142m;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableWindowBoundarySelector.java */
/* renamed from: g.a.y0.e.b.n4 */
/* loaded from: classes2.dex */
public final class C4769n4<T, B, V> extends AbstractC4686a<T, AbstractC4519l<T>> {

    /* renamed from: c */
    final InterfaceC5821b<B> f18124c;

    /* renamed from: d */
    final InterfaceC4584o<? super B, ? extends InterfaceC5821b<V>> f18125d;

    /* renamed from: e */
    final int f18126e;

    /* compiled from: FlowableWindowBoundarySelector.java */
    /* renamed from: g.a.y0.e.b.n4$a */
    static final class a<T, V> extends AbstractC4506b<V> {

        /* renamed from: b */
        final c<T, ?, V> f18127b;

        /* renamed from: c */
        final C4485g<T> f18128c;

        /* renamed from: d */
        boolean f18129d;

        a(c<T, ?, V> cVar, C4485g<T> c4485g) {
            this.f18127b = cVar;
            this.f18128c = c4485g;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18129d) {
                return;
            }
            this.f18129d = true;
            this.f18127b.m18345a((a) this);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18129d) {
                C4476a.m17152b(th);
            } else {
                this.f18129d = true;
                this.f18127b.m18347a(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(V v) {
            if (this.f18129d) {
                return;
            }
            this.f18129d = true;
            m17380a();
            this.f18127b.m18345a((a) this);
        }
    }

    /* compiled from: FlowableWindowBoundarySelector.java */
    /* renamed from: g.a.y0.e.b.n4$b */
    static final class b<T, B> extends AbstractC4506b<B> {

        /* renamed from: b */
        final c<T, B, ?> f18130b;

        /* renamed from: c */
        boolean f18131c;

        b(c<T, B, ?> cVar) {
            this.f18130b = cVar;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18131c) {
                return;
            }
            this.f18131c = true;
            this.f18130b.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18131c) {
                C4476a.m17152b(th);
            } else {
                this.f18131c = true;
                this.f18130b.m18347a(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(B b2) {
            if (this.f18131c) {
                return;
            }
            this.f18130b.m18346a((c<T, B, ?>) b2);
        }
    }

    /* compiled from: FlowableWindowBoundarySelector.java */
    /* renamed from: g.a.y0.e.b.n4$d */
    static final class d<T, B> {

        /* renamed from: a */
        final C4485g<T> f18140a;

        /* renamed from: b */
        final B f18141b;

        d(C4485g<T> c4485g, B b2) {
            this.f18140a = c4485g;
            this.f18141b = b2;
        }
    }

    public C4769n4(AbstractC4519l<T> abstractC4519l, InterfaceC5821b<B> interfaceC5821b, InterfaceC4584o<? super B, ? extends InterfaceC5821b<V>> interfaceC4584o, int i2) {
        super(abstractC4519l);
        this.f18124c = interfaceC5821b;
        this.f18125d = interfaceC4584o;
        this.f18126e = i2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super AbstractC4519l<T>> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new c(new C4509e(interfaceC5822c), this.f18124c, this.f18125d, this.f18126e));
    }

    /* compiled from: FlowableWindowBoundarySelector.java */
    /* renamed from: g.a.y0.e.b.n4$c */
    static final class c<T, B, V> extends AbstractC5142m<T, Object, AbstractC4519l<T>> implements InterfaceC5823d {

        /* renamed from: m0 */
        final InterfaceC5821b<B> f18132m0;

        /* renamed from: n0 */
        final InterfaceC4584o<? super B, ? extends InterfaceC5821b<V>> f18133n0;

        /* renamed from: o0 */
        final int f18134o0;

        /* renamed from: p0 */
        final C4551b f18135p0;

        /* renamed from: q0 */
        InterfaceC5823d f18136q0;

        /* renamed from: r0 */
        final AtomicReference<InterfaceC4552c> f18137r0;

        /* renamed from: s0 */
        final List<C4485g<T>> f18138s0;

        /* renamed from: t0 */
        final AtomicLong f18139t0;

        c(InterfaceC5822c<? super AbstractC4519l<T>> interfaceC5822c, InterfaceC5821b<B> interfaceC5821b, InterfaceC4584o<? super B, ? extends InterfaceC5821b<V>> interfaceC4584o, int i2) {
            super(interfaceC5822c, new C5109a());
            this.f18137r0 = new AtomicReference<>();
            this.f18139t0 = new AtomicLong();
            this.f18132m0 = interfaceC5821b;
            this.f18133n0 = interfaceC4584o;
            this.f18134o0 = i2;
            this.f18135p0 = new C4551b();
            this.f18138s0 = new ArrayList();
            this.f18139t0.lazySet(1L);
        }

        /* renamed from: a */
        void m18347a(Throwable th) {
            this.f18136q0.cancel();
            this.f18135p0.dispose();
            EnumC4592d.dispose(this.f18137r0);
            this.f19966h0.onError(th);
        }

        @Override // p251g.p252a.p268y0.p282h.AbstractC5142m, p251g.p252a.p268y0.p284j.InterfaceC5181u
        /* renamed from: a */
        public boolean mo18337a(InterfaceC5822c<? super AbstractC4519l<T>> interfaceC5822c, Object obj) {
            return false;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f19968j0 = true;
        }

        void dispose() {
            this.f18135p0.dispose();
            EnumC4592d.dispose(this.f18137r0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: f */
        void m18348f() {
            InterfaceC4616o interfaceC4616o = this.f19967i0;
            InterfaceC5822c<? super V> interfaceC5822c = this.f19966h0;
            List<C4485g<T>> list = this.f18138s0;
            int i2 = 1;
            while (true) {
                boolean z = this.f19969k0;
                Object poll = interfaceC4616o.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    dispose();
                    Throwable th = this.f19970l0;
                    if (th != null) {
                        Iterator<C4485g<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<C4485g<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z2) {
                    i2 = mo18590a(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (poll instanceof d) {
                    d dVar = (d) poll;
                    C4485g<T> c4485g = dVar.f18140a;
                    if (c4485g != null) {
                        if (list.remove(c4485g)) {
                            dVar.f18140a.onComplete();
                            if (this.f18139t0.decrementAndGet() == 0) {
                                dispose();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f19968j0) {
                        C4485g<T> m17260m = C4485g.m17260m(this.f18134o0);
                        long requested = requested();
                        if (requested != 0) {
                            list.add(m17260m);
                            interfaceC5822c.onNext(m17260m);
                            if (requested != C5556m0.f20396b) {
                                mo18591a(1L);
                            }
                            try {
                                InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.f18133n0.apply(dVar.f18141b), "The publisher supplied is null");
                                a aVar = new a(this, m17260m);
                                if (this.f18135p0.mo18181b(aVar)) {
                                    this.f18139t0.getAndIncrement();
                                    interfaceC5821b.subscribe(aVar);
                                }
                            } catch (Throwable th2) {
                                this.f19968j0 = true;
                                interfaceC5822c.onError(th2);
                            }
                        } else {
                            this.f19968j0 = true;
                            interfaceC5822c.onError(new C4562c("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator<C4485g<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(EnumC5177q.getValue(poll));
                    }
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19969k0) {
                return;
            }
            this.f19969k0 = true;
            if (mo18596b()) {
                m18348f();
            }
            if (this.f18139t0.decrementAndGet() == 0) {
                this.f18135p0.dispose();
            }
            this.f19966h0.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19969k0) {
                C4476a.m17152b(th);
                return;
            }
            this.f19970l0 = th;
            this.f19969k0 = true;
            if (mo18596b()) {
                m18348f();
            }
            if (this.f18139t0.decrementAndGet() == 0) {
                this.f18135p0.dispose();
            }
            this.f19966h0.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f19969k0) {
                return;
            }
            if (m18599e()) {
                Iterator<C4485g<T>> it = this.f18138s0.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (mo18590a(-1) == 0) {
                    return;
                }
            } else {
                this.f19967i0.offer(EnumC5177q.next(t));
                if (!mo18596b()) {
                    return;
                }
            }
            m18348f();
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18136q0, interfaceC5823d)) {
                this.f18136q0 = interfaceC5823d;
                this.f19966h0.onSubscribe(this);
                if (this.f19968j0) {
                    return;
                }
                b bVar = new b(this);
                if (this.f18137r0.compareAndSet(null, bVar)) {
                    this.f18139t0.getAndIncrement();
                    interfaceC5823d.request(C5556m0.f20396b);
                    this.f18132m0.subscribe(bVar);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            m18594b(j2);
        }

        /* renamed from: a */
        void m18346a(B b2) {
            this.f19967i0.offer(new d(null, b2));
            if (mo18596b()) {
                m18348f();
            }
        }

        /* renamed from: a */
        void m18345a(a<T, V> aVar) {
            this.f18135p0.mo18182c(aVar);
            this.f19967i0.offer(new d(aVar.f18128c, null));
            if (mo18596b()) {
                m18348f();
            }
        }
    }
}
