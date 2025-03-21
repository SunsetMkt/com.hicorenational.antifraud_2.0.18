package p251g.p252a.p268y0.p273e.p279f;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4576g;

/* compiled from: SingleDoOnError.java */
/* renamed from: g.a.y0.e.f.p */
/* loaded from: classes2.dex */
public final class C5091p<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19761a;

    /* renamed from: b */
    final InterfaceC4576g<? super Throwable> f19762b;

    /* compiled from: SingleDoOnError.java */
    /* renamed from: g.a.y0.e.f.p$a */
    final class a implements InterfaceC4524n0<T> {

        /* renamed from: a */
        private final InterfaceC4524n0<? super T> f19763a;

        a(InterfaceC4524n0<? super T> interfaceC4524n0) {
            this.f19763a = interfaceC4524n0;
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            try {
                C5091p.this.f19762b.accept(th);
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                th = new C4560a(th, th2);
            }
            this.f19763a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19763a.onSubscribe(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f19763a.onSuccess(t);
        }
    }

    public C5091p(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC4576g<? super Throwable> interfaceC4576g) {
        this.f19761a = interfaceC4530q0;
        this.f19762b = interfaceC4576g;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19761a.mo17490a(new a(interfaceC4524n0));
    }
}
