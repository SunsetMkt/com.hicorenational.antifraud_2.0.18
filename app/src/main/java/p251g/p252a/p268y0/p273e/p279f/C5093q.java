package p251g.p252a.p268y0.p273e.p279f;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4571b;

/* compiled from: SingleDoOnEvent.java */
/* renamed from: g.a.y0.e.f.q */
/* loaded from: classes2.dex */
public final class C5093q<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19768a;

    /* renamed from: b */
    final InterfaceC4571b<? super T, ? super Throwable> f19769b;

    /* compiled from: SingleDoOnEvent.java */
    /* renamed from: g.a.y0.e.f.q$a */
    final class a implements InterfaceC4524n0<T> {

        /* renamed from: a */
        private final InterfaceC4524n0<? super T> f19770a;

        a(InterfaceC4524n0<? super T> interfaceC4524n0) {
            this.f19770a = interfaceC4524n0;
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            try {
                C5093q.this.f19769b.mo18209a(null, th);
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                th = new C4560a(th, th2);
            }
            this.f19770a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19770a.onSubscribe(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            try {
                C5093q.this.f19769b.mo18209a(t, null);
                this.f19770a.onSuccess(t);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19770a.onError(th);
            }
        }
    }

    public C5093q(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC4571b<? super T, ? super Throwable> interfaceC4571b) {
        this.f19768a = interfaceC4530q0;
        this.f19769b = interfaceC4571b;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19768a.mo17490a(new a(interfaceC4524n0));
    }
}
