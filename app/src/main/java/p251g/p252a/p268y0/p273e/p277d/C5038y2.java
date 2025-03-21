package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableSingleMaybe.java */
/* renamed from: g.a.y0.e.d.y2 */
/* loaded from: classes2.dex */
public final class C5038y2<T> extends AbstractC4533s<T> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f19516a;

    /* compiled from: ObservableSingleMaybe.java */
    /* renamed from: g.a.y0.e.d.y2$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f19517a;

        /* renamed from: b */
        InterfaceC4552c f19518b;

        /* renamed from: c */
        T f19519c;

        /* renamed from: d */
        boolean f19520d;

        a(InterfaceC4559v<? super T> interfaceC4559v) {
            this.f19517a = interfaceC4559v;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19518b.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19518b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19520d) {
                return;
            }
            this.f19520d = true;
            T t = this.f19519c;
            this.f19519c = null;
            if (t == null) {
                this.f19517a.onComplete();
            } else {
                this.f19517a.onSuccess(t);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19520d) {
                C4476a.m17152b(th);
            } else {
                this.f19520d = true;
                this.f19517a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19520d) {
                return;
            }
            if (this.f19519c == null) {
                this.f19519c = t;
                return;
            }
            this.f19520d = true;
            this.f19518b.dispose();
            this.f19517a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19518b, interfaceC4552c)) {
                this.f19518b = interfaceC4552c;
                this.f19517a.onSubscribe(this);
            }
        }
    }

    public C5038y2(InterfaceC4504g0<T> interfaceC4504g0) {
        this.f19516a = interfaceC4504g0;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    public void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f19516a.subscribe(new a(interfaceC4559v));
    }
}
