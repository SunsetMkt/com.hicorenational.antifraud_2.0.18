package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableLastMaybe.java */
/* renamed from: g.a.y0.e.d.r1 */
/* loaded from: classes2.dex */
public final class C5002r1<T> extends AbstractC4533s<T> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f19349a;

    /* compiled from: ObservableLastMaybe.java */
    /* renamed from: g.a.y0.e.d.r1$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f19350a;

        /* renamed from: b */
        InterfaceC4552c f19351b;

        /* renamed from: c */
        T f19352c;

        a(InterfaceC4559v<? super T> interfaceC4559v) {
            this.f19350a = interfaceC4559v;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19351b.dispose();
            this.f19351b = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19351b == EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f19351b = EnumC4592d.DISPOSED;
            T t = this.f19352c;
            if (t == null) {
                this.f19350a.onComplete();
            } else {
                this.f19352c = null;
                this.f19350a.onSuccess(t);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19351b = EnumC4592d.DISPOSED;
            this.f19352c = null;
            this.f19350a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f19352c = t;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19351b, interfaceC4552c)) {
                this.f19351b = interfaceC4552c;
                this.f19350a.onSubscribe(this);
            }
        }
    }

    public C5002r1(InterfaceC4504g0<T> interfaceC4504g0) {
        this.f19349a = interfaceC4504g0;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f19349a.subscribe(new a(interfaceC4559v));
    }
}
