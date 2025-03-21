package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p256d1.C4485g;
import p251g.p252a.p259g1.AbstractC4506b;
import p251g.p252a.p259g1.C4509e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5109a;
import p251g.p252a.p268y0.p282h.AbstractC5142m;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableWindowBoundary.java */
/* renamed from: g.a.y0.e.b.m4 */
/* loaded from: classes2.dex */
public final class C4763m4<T, B> extends AbstractC4686a<T, AbstractC4519l<T>> {

    /* renamed from: c */
    final InterfaceC5821b<B> f18087c;

    /* renamed from: d */
    final int f18088d;

    /* compiled from: FlowableWindowBoundary.java */
    /* renamed from: g.a.y0.e.b.m4$a */
    static final class a<T, B> extends AbstractC4506b<B> {

        /* renamed from: b */
        final b<T, B> f18089b;

        /* renamed from: c */
        boolean f18090c;

        a(b<T, B> bVar) {
            this.f18089b = bVar;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18090c) {
                return;
            }
            this.f18090c = true;
            this.f18089b.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18090c) {
                C4476a.m17152b(th);
            } else {
                this.f18090c = true;
                this.f18089b.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(B b2) {
            if (this.f18090c) {
                return;
            }
            this.f18089b.m18339g();
        }
    }

    /* compiled from: FlowableWindowBoundary.java */
    /* renamed from: g.a.y0.e.b.m4$b */
    static final class b<T, B> extends AbstractC5142m<T, Object, AbstractC4519l<T>> implements InterfaceC5823d {

        /* renamed from: s0 */
        static final Object f18091s0 = new Object();

        /* renamed from: m0 */
        final InterfaceC5821b<B> f18092m0;

        /* renamed from: n0 */
        final int f18093n0;

        /* renamed from: o0 */
        InterfaceC5823d f18094o0;

        /* renamed from: p0 */
        final AtomicReference<InterfaceC4552c> f18095p0;

        /* renamed from: q0 */
        C4485g<T> f18096q0;

        /* renamed from: r0 */
        final AtomicLong f18097r0;

        b(InterfaceC5822c<? super AbstractC4519l<T>> interfaceC5822c, InterfaceC5821b<B> interfaceC5821b, int i2) {
            super(interfaceC5822c, new C5109a());
            this.f18095p0 = new AtomicReference<>();
            this.f18097r0 = new AtomicLong();
            this.f18092m0 = interfaceC5821b;
            this.f18093n0 = i2;
            this.f18097r0.lazySet(1L);
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

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [g.a.d1.g<T>] */
        /* renamed from: f */
        void m18338f() {
            InterfaceC4616o interfaceC4616o = this.f19967i0;
            InterfaceC5822c<? super V> interfaceC5822c = this.f19966h0;
            C4485g<T> c4485g = this.f18096q0;
            int i2 = 1;
            while (true) {
                boolean z = this.f19969k0;
                Object poll = interfaceC4616o.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    EnumC4592d.dispose(this.f18095p0);
                    Throwable th = this.f19970l0;
                    if (th != null) {
                        c4485g.onError(th);
                        return;
                    } else {
                        c4485g.onComplete();
                        return;
                    }
                }
                if (z2) {
                    i2 = mo18590a(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (poll == f18091s0) {
                    c4485g.onComplete();
                    if (this.f18097r0.decrementAndGet() == 0) {
                        EnumC4592d.dispose(this.f18095p0);
                        return;
                    }
                    if (!this.f19968j0) {
                        c4485g = (C4485g<T>) C4485g.m17260m(this.f18093n0);
                        long requested = requested();
                        if (requested != 0) {
                            this.f18097r0.getAndIncrement();
                            interfaceC5822c.onNext(c4485g);
                            if (requested != C5556m0.f20396b) {
                                mo18591a(1L);
                            }
                            this.f18096q0 = c4485g;
                        } else {
                            this.f19968j0 = true;
                            interfaceC5822c.onError(new C4562c("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    c4485g.onNext(EnumC5177q.getValue(poll));
                }
            }
        }

        /* renamed from: g */
        void m18339g() {
            this.f19967i0.offer(f18091s0);
            if (mo18596b()) {
                m18338f();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19969k0) {
                return;
            }
            this.f19969k0 = true;
            if (mo18596b()) {
                m18338f();
            }
            if (this.f18097r0.decrementAndGet() == 0) {
                EnumC4592d.dispose(this.f18095p0);
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
                m18338f();
            }
            if (this.f18097r0.decrementAndGet() == 0) {
                EnumC4592d.dispose(this.f18095p0);
            }
            this.f19966h0.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (m18599e()) {
                this.f18096q0.onNext(t);
                if (mo18590a(-1) == 0) {
                    return;
                }
            } else {
                this.f19967i0.offer(EnumC5177q.next(t));
                if (!mo18596b()) {
                    return;
                }
            }
            m18338f();
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18094o0, interfaceC5823d)) {
                this.f18094o0 = interfaceC5823d;
                InterfaceC5822c<? super V> interfaceC5822c = this.f19966h0;
                interfaceC5822c.onSubscribe(this);
                if (this.f19968j0) {
                    return;
                }
                C4485g<T> m17260m = C4485g.m17260m(this.f18093n0);
                long requested = requested();
                if (requested == 0) {
                    interfaceC5822c.onError(new C4562c("Could not deliver first window due to lack of requests"));
                    return;
                }
                interfaceC5822c.onNext(m17260m);
                if (requested != C5556m0.f20396b) {
                    mo18591a(1L);
                }
                this.f18096q0 = m17260m;
                a aVar = new a(this);
                if (this.f18095p0.compareAndSet(null, aVar)) {
                    this.f18097r0.getAndIncrement();
                    interfaceC5823d.request(C5556m0.f20396b);
                    this.f18092m0.subscribe(aVar);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            m18594b(j2);
        }
    }

    public C4763m4(AbstractC4519l<T> abstractC4519l, InterfaceC5821b<B> interfaceC5821b, int i2) {
        super(abstractC4519l);
        this.f18087c = interfaceC5821b;
        this.f18088d = i2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super AbstractC4519l<T>> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new b(new C4509e(interfaceC5822c), this.f18087c, this.f18088d));
    }
}
