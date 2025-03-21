package p251g.p252a.p268y0.p273e.p279f;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p283i.C5156f;
import p324i.p338d.InterfaceC5822c;

/* compiled from: SingleToFlowable.java */
/* renamed from: g.a.y0.e.f.q0 */
/* loaded from: classes2.dex */
public final class C5094q0<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final InterfaceC4530q0<? extends T> f19772b;

    /* compiled from: SingleToFlowable.java */
    /* renamed from: g.a.y0.e.f.q0$a */
    static final class a<T> extends C5156f<T> implements InterfaceC4524n0<T> {
        private static final long serialVersionUID = 187782011903685568L;

        /* renamed from: d */
        InterfaceC4552c f19773d;

        a(InterfaceC5822c<? super T> interfaceC5822c) {
            super(interfaceC5822c);
        }

        @Override // p251g.p252a.p268y0.p283i.C5156f, p324i.p338d.InterfaceC5823d
        public void cancel() {
            super.cancel();
            this.f19773d.dispose();
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19773d, interfaceC4552c)) {
                this.f19773d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public C5094q0(InterfaceC4530q0<? extends T> interfaceC4530q0) {
        this.f19772b = interfaceC4530q0;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f19772b.mo17490a(new a(interfaceC5822c));
    }
}
