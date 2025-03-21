package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableCount.java */
/* renamed from: g.a.y0.e.d.y */
/* loaded from: classes2.dex */
public final class C5035y<T> extends AbstractC4907a<T, Long> {

    /* compiled from: ObservableCount.java */
    /* renamed from: g.a.y0.e.d.y$a */
    static final class a implements InterfaceC4514i0<Object>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super Long> f19506a;

        /* renamed from: b */
        InterfaceC4552c f19507b;

        /* renamed from: c */
        long f19508c;

        a(InterfaceC4514i0<? super Long> interfaceC4514i0) {
            this.f19506a = interfaceC4514i0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19507b.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19507b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f19506a.onNext(Long.valueOf(this.f19508c));
            this.f19506a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19506a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(Object obj) {
            this.f19508c++;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19507b, interfaceC4552c)) {
                this.f19507b = interfaceC4552c;
                this.f19506a.onSubscribe(this);
            }
        }
    }

    public C5035y(InterfaceC4504g0<T> interfaceC4504g0) {
        super(interfaceC4504g0);
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super Long> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0));
    }
}
