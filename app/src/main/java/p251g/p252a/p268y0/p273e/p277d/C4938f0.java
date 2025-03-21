package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4599k;

/* compiled from: ObservableDelaySubscriptionOther.java */
/* renamed from: g.a.y0.e.d.f0 */
/* loaded from: classes2.dex */
public final class C4938f0<T, U> extends AbstractC4469b0<T> {

    /* renamed from: a */
    final InterfaceC4504g0<? extends T> f18960a;

    /* renamed from: b */
    final InterfaceC4504g0<U> f18961b;

    /* compiled from: ObservableDelaySubscriptionOther.java */
    /* renamed from: g.a.y0.e.d.f0$a */
    final class a implements InterfaceC4514i0<U> {

        /* renamed from: a */
        final C4599k f18962a;

        /* renamed from: b */
        final InterfaceC4514i0<? super T> f18963b;

        /* renamed from: c */
        boolean f18964c;

        /* compiled from: ObservableDelaySubscriptionOther.java */
        /* renamed from: g.a.y0.e.d.f0$a$a, reason: collision with other inner class name */
        final class C7413a implements InterfaceC4514i0<T> {
            C7413a() {
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onComplete() {
                a.this.f18963b.onComplete();
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onError(Throwable th) {
                a.this.f18963b.onError(th);
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onNext(T t) {
                a.this.f18963b.onNext(t);
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                a.this.f18962a.update(interfaceC4552c);
            }
        }

        a(C4599k c4599k, InterfaceC4514i0<? super T> interfaceC4514i0) {
            this.f18962a = c4599k;
            this.f18963b = interfaceC4514i0;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f18964c) {
                return;
            }
            this.f18964c = true;
            C4938f0.this.f18960a.subscribe(new C7413a());
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f18964c) {
                C4476a.m17152b(th);
            } else {
                this.f18964c = true;
                this.f18963b.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(U u) {
            onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f18962a.update(interfaceC4552c);
        }
    }

    public C4938f0(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<U> interfaceC4504g02) {
        this.f18960a = interfaceC4504g0;
        this.f18961b = interfaceC4504g02;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C4599k c4599k = new C4599k();
        interfaceC4514i0.onSubscribe(c4599k);
        this.f18961b.subscribe(new a(c4599k, interfaceC4514i0));
    }
}
