package p251g.p252a.p268y0.p273e.p279f;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: SingleMap.java */
/* renamed from: g.a.y0.e.f.h0 */
/* loaded from: classes2.dex */
public final class C5076h0<T, R> extends AbstractC4518k0<R> {

    /* renamed from: a */
    final InterfaceC4530q0<? extends T> f19714a;

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends R> f19715b;

    /* compiled from: SingleMap.java */
    /* renamed from: g.a.y0.e.f.h0$a */
    static final class a<T, R> implements InterfaceC4524n0<T> {

        /* renamed from: a */
        final InterfaceC4524n0<? super R> f19716a;

        /* renamed from: b */
        final InterfaceC4584o<? super T, ? extends R> f19717b;

        a(InterfaceC4524n0<? super R> interfaceC4524n0, InterfaceC4584o<? super T, ? extends R> interfaceC4584o) {
            this.f19716a = interfaceC4524n0;
            this.f19717b = interfaceC4584o;
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.f19716a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19716a.onSubscribe(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            try {
                this.f19716a.onSuccess(C4601b.m18284a(this.f19717b.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                onError(th);
            }
        }
    }

    public C5076h0(InterfaceC4530q0<? extends T> interfaceC4530q0, InterfaceC4584o<? super T, ? extends R> interfaceC4584o) {
        this.f19714a = interfaceC4530q0;
        this.f19715b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super R> interfaceC4524n0) {
        this.f19714a.mo17490a(new a(interfaceC4524n0, this.f19715b));
    }
}
