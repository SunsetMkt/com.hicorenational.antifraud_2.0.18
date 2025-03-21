package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: SingleDoOnDispose.java */
/* renamed from: g.a.y0.e.f.o */
/* loaded from: classes2.dex */
public final class C5089o<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19753a;

    /* renamed from: b */
    final InterfaceC4570a f19754b;

    /* compiled from: SingleDoOnDispose.java */
    /* renamed from: g.a.y0.e.f.o$a */
    static final class a<T> extends AtomicReference<InterfaceC4570a> implements InterfaceC4524n0<T>, InterfaceC4552c {
        private static final long serialVersionUID = -8583764624474935784L;
        final InterfaceC4524n0<? super T> actual;

        /* renamed from: d */
        InterfaceC4552c f19755d;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, InterfaceC4570a interfaceC4570a) {
            this.actual = interfaceC4524n0;
            lazySet(interfaceC4570a);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            InterfaceC4570a andSet = getAndSet(null);
            if (andSet != null) {
                try {
                    andSet.run();
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    C4476a.m17152b(th);
                }
                this.f19755d.dispose();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19755d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19755d, interfaceC4552c)) {
                this.f19755d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    public C5089o(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC4570a interfaceC4570a) {
        this.f19753a = interfaceC4530q0;
        this.f19754b = interfaceC4570a;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19753a.mo17490a(new a(interfaceC4524n0, this.f19754b));
    }
}
