package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p284j.EnumC5168h;

/* compiled from: ObservableDetach.java */
/* renamed from: g.a.y0.e.d.h0 */
/* loaded from: classes2.dex */
public final class C4950h0<T> extends AbstractC4907a<T, T> {

    /* compiled from: ObservableDetach.java */
    /* renamed from: g.a.y0.e.d.h0$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        InterfaceC4514i0<? super T> f19033a;

        /* renamed from: b */
        InterfaceC4552c f19034b;

        a(InterfaceC4514i0<? super T> interfaceC4514i0) {
            this.f19033a = interfaceC4514i0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            InterfaceC4552c interfaceC4552c = this.f19034b;
            this.f19034b = EnumC5168h.INSTANCE;
            this.f19033a = EnumC5168h.asObserver();
            interfaceC4552c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19034b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            InterfaceC4514i0<? super T> interfaceC4514i0 = this.f19033a;
            this.f19034b = EnumC5168h.INSTANCE;
            this.f19033a = EnumC5168h.asObserver();
            interfaceC4514i0.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            InterfaceC4514i0<? super T> interfaceC4514i0 = this.f19033a;
            this.f19034b = EnumC5168h.INSTANCE;
            this.f19033a = EnumC5168h.asObserver();
            interfaceC4514i0.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f19033a.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19034b, interfaceC4552c)) {
                this.f19034b = interfaceC4552c;
                this.f19033a.onSubscribe(this);
            }
        }
    }

    public C4950h0(InterfaceC4504g0<T> interfaceC4504g0) {
        super(interfaceC4504g0);
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0));
    }
}
