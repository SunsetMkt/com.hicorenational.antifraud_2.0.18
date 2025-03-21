package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.C4453a0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableDematerialize.java */
/* renamed from: g.a.y0.e.d.g0 */
/* loaded from: classes2.dex */
public final class C4944g0<T> extends AbstractC4907a<C4453a0<T>, T> {

    /* compiled from: ObservableDematerialize.java */
    /* renamed from: g.a.y0.e.d.g0$a */
    static final class a<T> implements InterfaceC4514i0<C4453a0<T>>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f18995a;

        /* renamed from: b */
        boolean f18996b;

        /* renamed from: c */
        InterfaceC4552c f18997c;

        a(InterfaceC4514i0<? super T> interfaceC4514i0) {
            this.f18995a = interfaceC4514i0;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(C4453a0<T> c4453a0) {
            if (this.f18996b) {
                if (c4453a0.m16441d()) {
                    C4476a.m17152b(c4453a0.m16438a());
                }
            } else if (c4453a0.m16441d()) {
                this.f18997c.dispose();
                onError(c4453a0.m16438a());
            } else if (!c4453a0.m16440c()) {
                this.f18995a.onNext(c4453a0.m16439b());
            } else {
                this.f18997c.dispose();
                onComplete();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18997c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18997c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f18996b) {
                return;
            }
            this.f18996b = true;
            this.f18995a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f18996b) {
                C4476a.m17152b(th);
            } else {
                this.f18996b = true;
                this.f18995a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18997c, interfaceC4552c)) {
                this.f18997c = interfaceC4552c;
                this.f18995a.onSubscribe(this);
            }
        }
    }

    public C4944g0(InterfaceC4504g0<C4453a0<T>> interfaceC4504g0) {
        super(interfaceC4504g0);
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0));
    }
}
