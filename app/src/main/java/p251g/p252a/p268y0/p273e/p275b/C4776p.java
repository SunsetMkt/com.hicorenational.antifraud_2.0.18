package p251g.p252a.p268y0.p273e.p275b;

import java.util.Collection;
import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p259g1.AbstractC4506b;
import p251g.p252a.p259g1.C4509e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
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

/* compiled from: FlowableBufferExactBoundary.java */
/* renamed from: g.a.y0.e.b.p */
/* loaded from: classes2.dex */
public final class C4776p<T, U extends Collection<? super T>, B> extends AbstractC4686a<T, U> {

    /* renamed from: c */
    final InterfaceC5821b<B> f18185c;

    /* renamed from: d */
    final Callable<U> f18186d;

    /* compiled from: FlowableBufferExactBoundary.java */
    /* renamed from: g.a.y0.e.b.p$a */
    static final class a<T, U extends Collection<? super T>, B> extends AbstractC4506b<B> {

        /* renamed from: b */
        final b<T, U, B> f18187b;

        a(b<T, U, B> bVar) {
            this.f18187b = bVar;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f18187b.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f18187b.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(B b2) {
            this.f18187b.m18355f();
        }
    }

    /* compiled from: FlowableBufferExactBoundary.java */
    /* renamed from: g.a.y0.e.b.p$b */
    static final class b<T, U extends Collection<? super T>, B> extends AbstractC5142m<T, U, U> implements InterfaceC4529q<T>, InterfaceC5823d, InterfaceC4552c {

        /* renamed from: m0 */
        final Callable<U> f18188m0;

        /* renamed from: n0 */
        final InterfaceC5821b<B> f18189n0;

        /* renamed from: o0 */
        InterfaceC5823d f18190o0;

        /* renamed from: p0 */
        InterfaceC4552c f18191p0;

        /* renamed from: q0 */
        U f18192q0;

        b(InterfaceC5822c<? super U> interfaceC5822c, Callable<U> callable, InterfaceC5821b<B> interfaceC5821b) {
            super(interfaceC5822c, new C5109a());
            this.f18188m0 = callable;
            this.f18189n0 = interfaceC5821b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p268y0.p282h.AbstractC5142m, p251g.p252a.p268y0.p284j.InterfaceC5181u
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo18337a(InterfaceC5822c interfaceC5822c, Object obj) {
            return m18354a((InterfaceC5822c<? super InterfaceC5822c>) interfaceC5822c, (InterfaceC5822c) obj);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.f19968j0) {
                return;
            }
            this.f19968j0 = true;
            this.f18191p0.dispose();
            this.f18190o0.cancel();
            if (mo18596b()) {
                this.f19967i0.clear();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            cancel();
        }

        /* renamed from: f */
        void m18355f() {
            try {
                U u = (U) C4601b.m18284a(this.f18188m0.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.f18192q0;
                    if (u2 == null) {
                        return;
                    }
                    this.f18192q0 = u;
                    m18593a(u2, false, this);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                cancel();
                this.f19966h0.onError(th);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19968j0;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            synchronized (this) {
                U u = this.f18192q0;
                if (u == null) {
                    return;
                }
                this.f18192q0 = null;
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
                U u = this.f18192q0;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18190o0, interfaceC5823d)) {
                this.f18190o0 = interfaceC5823d;
                try {
                    this.f18192q0 = (U) C4601b.m18284a(this.f18188m0.call(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.f18191p0 = aVar;
                    this.f19966h0.onSubscribe(this);
                    if (this.f19968j0) {
                        return;
                    }
                    interfaceC5823d.request(C5556m0.f20396b);
                    this.f18189n0.subscribe(aVar);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.f19968j0 = true;
                    interfaceC5823d.cancel();
                    EnumC5157g.error(th, this.f19966h0);
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            m18594b(j2);
        }

        /* renamed from: a */
        public boolean m18354a(InterfaceC5822c<? super U> interfaceC5822c, U u) {
            this.f19966h0.onNext(u);
            return true;
        }
    }

    public C4776p(AbstractC4519l<T> abstractC4519l, InterfaceC5821b<B> interfaceC5821b, Callable<U> callable) {
        super(abstractC4519l);
        this.f18185c = interfaceC5821b;
        this.f18186d = callable;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super U> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new b(new C4509e(interfaceC5822c), this.f18186d, this.f18185c));
    }
}
