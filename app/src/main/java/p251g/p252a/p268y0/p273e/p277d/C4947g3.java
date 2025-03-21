package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4599k;

/* compiled from: ObservableSwitchIfEmpty.java */
/* renamed from: g.a.y0.e.d.g3 */
/* loaded from: classes2.dex */
public final class C4947g3<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4504g0<? extends T> f19015b;

    /* compiled from: ObservableSwitchIfEmpty.java */
    /* renamed from: g.a.y0.e.d.g3$a */
    static final class a<T> implements InterfaceC4514i0<T> {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f19016a;

        /* renamed from: b */
        final InterfaceC4504g0<? extends T> f19017b;

        /* renamed from: d */
        boolean f19019d = true;

        /* renamed from: c */
        final C4599k f19018c = new C4599k();

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4504g0<? extends T> interfaceC4504g0) {
            this.f19016a = interfaceC4514i0;
            this.f19017b = interfaceC4504g0;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (!this.f19019d) {
                this.f19016a.onComplete();
            } else {
                this.f19019d = false;
                this.f19017b.subscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19016a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19019d) {
                this.f19019d = false;
            }
            this.f19016a.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19018c.update(interfaceC4552c);
        }
    }

    public C4947g3(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02) {
        super(interfaceC4504g0);
        this.f19015b = interfaceC4504g02;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        a aVar = new a(interfaceC4514i0, this.f19015b);
        interfaceC4514i0.onSubscribe(aVar.f19018c);
        this.f18742a.subscribe(aVar);
    }
}
