package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: SingleDoFinally.java */
@InterfaceC4545e
/* renamed from: g.a.y0.e.f.n */
/* loaded from: classes2.dex */
public final class C5087n<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19748a;

    /* renamed from: b */
    final InterfaceC4570a f19749b;

    /* compiled from: SingleDoFinally.java */
    /* renamed from: g.a.y0.e.f.n$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4524n0<T>, InterfaceC4552c {
        private static final long serialVersionUID = 4109457741734051389L;
        final InterfaceC4524n0<? super T> actual;

        /* renamed from: d */
        InterfaceC4552c f19750d;
        final InterfaceC4570a onFinally;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, InterfaceC4570a interfaceC4570a) {
            this.actual = interfaceC4524n0;
            this.onFinally = interfaceC4570a;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19750d.dispose();
            runFinally();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19750d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19750d, interfaceC4552c)) {
                this.f19750d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
            runFinally();
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    C4476a.m17152b(th);
                }
            }
        }
    }

    public C5087n(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC4570a interfaceC4570a) {
        this.f19748a = interfaceC4530q0;
        this.f19749b = interfaceC4570a;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19748a.mo17490a(new a(interfaceC4524n0, this.f19749b));
    }
}
