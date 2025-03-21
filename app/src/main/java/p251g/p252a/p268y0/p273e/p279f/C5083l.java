package p251g.p252a.p268y0.p273e.p279f;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: SingleDoAfterSuccess.java */
@InterfaceC4545e
/* renamed from: g.a.y0.e.f.l */
/* loaded from: classes2.dex */
public final class C5083l<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19734a;

    /* renamed from: b */
    final InterfaceC4576g<? super T> f19735b;

    /* compiled from: SingleDoAfterSuccess.java */
    /* renamed from: g.a.y0.e.f.l$a */
    static final class a<T> implements InterfaceC4524n0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super T> f19736a;

        /* renamed from: b */
        final InterfaceC4576g<? super T> f19737b;

        /* renamed from: c */
        InterfaceC4552c f19738c;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, InterfaceC4576g<? super T> interfaceC4576g) {
            this.f19736a = interfaceC4524n0;
            this.f19737b = interfaceC4576g;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19738c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19738c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.f19736a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19738c, interfaceC4552c)) {
                this.f19738c = interfaceC4552c;
                this.f19736a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f19736a.onSuccess(t);
            try {
                this.f19737b.accept(t);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(th);
            }
        }
    }

    public C5083l(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC4576g<? super T> interfaceC4576g) {
        this.f19734a = interfaceC4530q0;
        this.f19735b = interfaceC4576g;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19734a.mo17490a(new a(interfaceC4524n0, this.f19735b));
    }
}
