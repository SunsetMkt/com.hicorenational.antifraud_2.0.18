package p251g.p252a.p268y0.p273e.p279f;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;

/* compiled from: SingleOnErrorReturn.java */
/* renamed from: g.a.y0.e.f.k0 */
/* loaded from: classes2.dex */
public final class C5082k0<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<? extends T> f19729a;

    /* renamed from: b */
    final InterfaceC4584o<? super Throwable, ? extends T> f19730b;

    /* renamed from: c */
    final T f19731c;

    /* compiled from: SingleOnErrorReturn.java */
    /* renamed from: g.a.y0.e.f.k0$a */
    final class a implements InterfaceC4524n0<T> {

        /* renamed from: a */
        private final InterfaceC4524n0<? super T> f19732a;

        a(InterfaceC4524n0<? super T> interfaceC4524n0) {
            this.f19732a = interfaceC4524n0;
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            T apply;
            C5082k0 c5082k0 = C5082k0.this;
            InterfaceC4584o<? super Throwable, ? extends T> interfaceC4584o = c5082k0.f19730b;
            if (interfaceC4584o != null) {
                try {
                    apply = interfaceC4584o.apply(th);
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    this.f19732a.onError(new C4560a(th, th2));
                    return;
                }
            } else {
                apply = c5082k0.f19731c;
            }
            if (apply != null) {
                this.f19732a.onSuccess(apply);
                return;
            }
            NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
            nullPointerException.initCause(th);
            this.f19732a.onError(nullPointerException);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19732a.onSubscribe(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f19732a.onSuccess(t);
        }
    }

    public C5082k0(InterfaceC4530q0<? extends T> interfaceC4530q0, InterfaceC4584o<? super Throwable, ? extends T> interfaceC4584o, T t) {
        this.f19729a = interfaceC4530q0;
        this.f19730b = interfaceC4584o;
        this.f19731c = t;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19729a.mo17490a(new a(interfaceC4524n0));
    }
}
