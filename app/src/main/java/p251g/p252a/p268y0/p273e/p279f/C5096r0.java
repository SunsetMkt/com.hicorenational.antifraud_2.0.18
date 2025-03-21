package p251g.p252a.p268y0.p273e.p279f;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: SingleToObservable.java */
/* renamed from: g.a.y0.e.f.r0 */
/* loaded from: classes2.dex */
public final class C5096r0<T> extends AbstractC4469b0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<? extends T> f19779a;

    /* compiled from: SingleToObservable.java */
    /* renamed from: g.a.y0.e.f.r0$a */
    static final class a<T> implements InterfaceC4524n0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f19780a;

        /* renamed from: b */
        InterfaceC4552c f19781b;

        a(InterfaceC4514i0<? super T> interfaceC4514i0) {
            this.f19780a = interfaceC4514i0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19781b.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19781b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.f19780a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19781b, interfaceC4552c)) {
                this.f19781b = interfaceC4552c;
                this.f19780a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f19780a.onNext(t);
            this.f19780a.onComplete();
        }
    }

    public C5096r0(InterfaceC4530q0<? extends T> interfaceC4530q0) {
        this.f19779a = interfaceC4530q0;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f19779a.mo17490a(new a(interfaceC4514i0));
    }
}
