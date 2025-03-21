package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableHide.java */
/* renamed from: g.a.y0.e.d.j1 */
/* loaded from: classes2.dex */
public final class C4962j1<T> extends AbstractC4907a<T, T> {

    /* compiled from: ObservableHide.java */
    /* renamed from: g.a.y0.e.d.j1$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f19087a;

        /* renamed from: b */
        InterfaceC4552c f19088b;

        a(InterfaceC4514i0<? super T> interfaceC4514i0) {
            this.f19087a = interfaceC4514i0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19088b.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19088b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f19087a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19087a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f19087a.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19088b, interfaceC4552c)) {
                this.f19088b = interfaceC4552c;
                this.f19087a.onSubscribe(this);
            }
        }
    }

    public C4962j1(InterfaceC4504g0<T> interfaceC4504g0) {
        super(interfaceC4504g0);
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0));
    }
}
