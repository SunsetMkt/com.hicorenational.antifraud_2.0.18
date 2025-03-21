package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.C4453a0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableMaterialize.java */
/* renamed from: g.a.y0.e.d.w1 */
/* loaded from: classes2.dex */
public final class C5027w1<T> extends AbstractC4907a<T, C4453a0<T>> {

    /* compiled from: ObservableMaterialize.java */
    /* renamed from: g.a.y0.e.d.w1$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super C4453a0<T>> f19476a;

        /* renamed from: b */
        InterfaceC4552c f19477b;

        a(InterfaceC4514i0<? super C4453a0<T>> interfaceC4514i0) {
            this.f19476a = interfaceC4514i0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19477b.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19477b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f19476a.onNext(C4453a0.m16437f());
            this.f19476a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19476a.onNext(C4453a0.m16436a(th));
            this.f19476a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f19476a.onNext(C4453a0.m16435a(t));
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19477b, interfaceC4552c)) {
                this.f19477b = interfaceC4552c;
                this.f19476a.onSubscribe(this);
            }
        }
    }

    public C5027w1(InterfaceC4504g0<T> interfaceC4504g0) {
        super(interfaceC4504g0);
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super C4453a0<T>> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0));
    }
}
