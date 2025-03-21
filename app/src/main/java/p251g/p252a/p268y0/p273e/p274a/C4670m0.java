package p251g.p252a.p268y0.p273e.p274a;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: CompletableToObservable.java */
/* renamed from: g.a.y0.e.a.m0 */
/* loaded from: classes2.dex */
public final class C4670m0<T> extends AbstractC4469b0<T> {

    /* renamed from: a */
    final InterfaceC4513i f17724a;

    /* compiled from: CompletableToObservable.java */
    /* renamed from: g.a.y0.e.a.m0$a */
    static final class a implements InterfaceC4491f {

        /* renamed from: a */
        private final InterfaceC4514i0<?> f17725a;

        a(InterfaceC4514i0<?> interfaceC4514i0) {
            this.f17725a = interfaceC4514i0;
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            this.f17725a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            this.f17725a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f17725a.onSubscribe(interfaceC4552c);
        }
    }

    public C4670m0(InterfaceC4513i interfaceC4513i) {
        this.f17724a = interfaceC4513i;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f17724a.mo17074a(new a(interfaceC4514i0));
    }
}
