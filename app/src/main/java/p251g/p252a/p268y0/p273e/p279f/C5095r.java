package p251g.p252a.p268y0.p273e.p279f;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: SingleDoOnSubscribe.java */
/* renamed from: g.a.y0.e.f.r */
/* loaded from: classes2.dex */
public final class C5095r<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19774a;

    /* renamed from: b */
    final InterfaceC4576g<? super InterfaceC4552c> f19775b;

    /* compiled from: SingleDoOnSubscribe.java */
    /* renamed from: g.a.y0.e.f.r$a */
    static final class a<T> implements InterfaceC4524n0<T> {

        /* renamed from: a */
        final InterfaceC4524n0<? super T> f19776a;

        /* renamed from: b */
        final InterfaceC4576g<? super InterfaceC4552c> f19777b;

        /* renamed from: c */
        boolean f19778c;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g) {
            this.f19776a = interfaceC4524n0;
            this.f19777b = interfaceC4576g;
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            if (this.f19778c) {
                C4476a.m17152b(th);
            } else {
                this.f19776a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            try {
                this.f19777b.accept(interfaceC4552c);
                this.f19776a.onSubscribe(interfaceC4552c);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19778c = true;
                interfaceC4552c.dispose();
                EnumC4593e.error(th, this.f19776a);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            if (this.f19778c) {
                return;
            }
            this.f19776a.onSuccess(t);
        }
    }

    public C5095r(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g) {
        this.f19774a = interfaceC4530q0;
        this.f19775b = interfaceC4576g;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19774a.mo17490a(new a(interfaceC4524n0, this.f19775b));
    }
}
