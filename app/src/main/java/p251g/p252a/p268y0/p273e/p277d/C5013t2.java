package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableScan.java */
/* renamed from: g.a.y0.e.d.t2 */
/* loaded from: classes2.dex */
public final class C5013t2<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4572c<T, T, T> f19403b;

    /* compiled from: ObservableScan.java */
    /* renamed from: g.a.y0.e.d.t2$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f19404a;

        /* renamed from: b */
        final InterfaceC4572c<T, T, T> f19405b;

        /* renamed from: c */
        InterfaceC4552c f19406c;

        /* renamed from: d */
        T f19407d;

        /* renamed from: e */
        boolean f19408e;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4572c<T, T, T> interfaceC4572c) {
            this.f19404a = interfaceC4514i0;
            this.f19405b = interfaceC4572c;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19406c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19406c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19408e) {
                return;
            }
            this.f19408e = true;
            this.f19404a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19408e) {
                C4476a.m17152b(th);
            } else {
                this.f19408e = true;
                this.f19404a.onError(th);
            }
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19408e) {
                return;
            }
            InterfaceC4514i0<? super T> interfaceC4514i0 = this.f19404a;
            T t2 = this.f19407d;
            if (t2 == null) {
                this.f19407d = t;
                interfaceC4514i0.onNext(t);
                return;
            }
            try {
                ?? r4 = (T) C4601b.m18284a((Object) this.f19405b.apply(t2, t), "The value returned by the accumulator is null");
                this.f19407d = r4;
                interfaceC4514i0.onNext(r4);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19406c.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19406c, interfaceC4552c)) {
                this.f19406c = interfaceC4552c;
                this.f19404a.onSubscribe(this);
            }
        }
    }

    public C5013t2(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4572c<T, T, T> interfaceC4572c) {
        super(interfaceC4504g0);
        this.f19403b = interfaceC4572c;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19403b));
    }
}
