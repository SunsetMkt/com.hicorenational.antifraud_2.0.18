package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4603b;
import p251g.p252a.p268y0.p271c.InterfaceC4609h;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableReduceMaybe.java */
/* renamed from: g.a.y0.e.b.q2 */
/* loaded from: classes2.dex */
public final class C4785q2<T> extends AbstractC4533s<T> implements InterfaceC4609h<T>, InterfaceC4603b<T> {

    /* renamed from: a */
    final AbstractC4519l<T> f18317a;

    /* renamed from: b */
    final InterfaceC4572c<T, T, T> f18318b;

    /* compiled from: FlowableReduceMaybe.java */
    /* renamed from: g.a.y0.e.b.q2$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18319a;

        /* renamed from: b */
        final InterfaceC4572c<T, T, T> f18320b;

        /* renamed from: c */
        T f18321c;

        /* renamed from: d */
        InterfaceC5823d f18322d;

        /* renamed from: e */
        boolean f18323e;

        a(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC4572c<T, T, T> interfaceC4572c) {
            this.f18319a = interfaceC4559v;
            this.f18320b = interfaceC4572c;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18322d.cancel();
            this.f18323e = true;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18323e;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18323e) {
                return;
            }
            this.f18323e = true;
            T t = this.f18321c;
            if (t != null) {
                this.f18319a.onSuccess(t);
            } else {
                this.f18319a.onComplete();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18323e) {
                C4476a.m17152b(th);
            } else {
                this.f18323e = true;
                this.f18319a.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f18323e) {
                return;
            }
            T t2 = this.f18321c;
            if (t2 == null) {
                this.f18321c = t;
                return;
            }
            try {
                this.f18321c = (T) C4601b.m18284a((Object) this.f18320b.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18322d.cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18322d, interfaceC5823d)) {
                this.f18322d = interfaceC5823d;
                this.f18319a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4785q2(AbstractC4519l<T> abstractC4519l, InterfaceC4572c<T, T, T> interfaceC4572c) {
        this.f18317a = abstractC4519l;
        this.f18318b = interfaceC4572c;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4603b
    /* renamed from: b */
    public AbstractC4519l<T> mo18286b() {
        return C4476a.m17129a(new C4779p2(this.f18317a, this.f18318b));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4609h
    public InterfaceC5821b<T> source() {
        return this.f18317a;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18317a.m17799a((InterfaceC4529q) new a(interfaceC4559v, this.f18318b));
    }
}
