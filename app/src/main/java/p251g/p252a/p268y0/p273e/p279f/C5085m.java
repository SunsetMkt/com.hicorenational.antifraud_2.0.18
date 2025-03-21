package p251g.p252a.p268y0.p273e.p279f;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: SingleDoAfterTerminate.java */
/* renamed from: g.a.y0.e.f.m */
/* loaded from: classes2.dex */
public final class C5085m<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19741a;

    /* renamed from: b */
    final InterfaceC4570a f19742b;

    /* compiled from: SingleDoAfterTerminate.java */
    /* renamed from: g.a.y0.e.f.m$a */
    static final class a<T> implements InterfaceC4524n0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super T> f19743a;

        /* renamed from: b */
        final InterfaceC4570a f19744b;

        /* renamed from: c */
        InterfaceC4552c f19745c;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, InterfaceC4570a interfaceC4570a) {
            this.f19743a = interfaceC4524n0;
            this.f19744b = interfaceC4570a;
        }

        /* renamed from: a */
        private void m18531a() {
            try {
                this.f19744b.run();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(th);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19745c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19745c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.f19743a.onError(th);
            m18531a();
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19745c, interfaceC4552c)) {
                this.f19745c = interfaceC4552c;
                this.f19743a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f19743a.onSuccess(t);
            m18531a();
        }
    }

    public C5085m(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC4570a interfaceC4570a) {
        this.f19741a = interfaceC4530q0;
        this.f19742b = interfaceC4570a;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19741a.mo17490a(new a(interfaceC4524n0, this.f19742b));
    }
}
