package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableReduceMaybe.java */
/* renamed from: g.a.y0.e.d.f2 */
/* loaded from: classes2.dex */
public final class C4940f2<T> extends AbstractC4533s<T> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f18968a;

    /* renamed from: b */
    final InterfaceC4572c<T, T, T> f18969b;

    /* compiled from: ObservableReduceMaybe.java */
    /* renamed from: g.a.y0.e.d.f2$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18970a;

        /* renamed from: b */
        final InterfaceC4572c<T, T, T> f18971b;

        /* renamed from: c */
        boolean f18972c;

        /* renamed from: d */
        T f18973d;

        /* renamed from: e */
        InterfaceC4552c f18974e;

        a(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC4572c<T, T, T> interfaceC4572c) {
            this.f18970a = interfaceC4559v;
            this.f18971b = interfaceC4572c;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18974e.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18974e.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f18972c) {
                return;
            }
            this.f18972c = true;
            T t = this.f18973d;
            this.f18973d = null;
            if (t != null) {
                this.f18970a.onSuccess(t);
            } else {
                this.f18970a.onComplete();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f18972c) {
                C4476a.m17152b(th);
                return;
            }
            this.f18972c = true;
            this.f18973d = null;
            this.f18970a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f18972c) {
                return;
            }
            T t2 = this.f18973d;
            if (t2 == null) {
                this.f18973d = t;
                return;
            }
            try {
                this.f18973d = (T) C4601b.m18284a((Object) this.f18971b.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18974e.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18974e, interfaceC4552c)) {
                this.f18974e = interfaceC4552c;
                this.f18970a.onSubscribe(this);
            }
        }
    }

    public C4940f2(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4572c<T, T, T> interfaceC4572c) {
        this.f18968a = interfaceC4504g0;
        this.f18969b = interfaceC4572c;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18968a.subscribe(new a(interfaceC4559v, this.f18969b));
    }
}
