package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.C5156f;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableReduce.java */
/* renamed from: g.a.y0.e.b.p2 */
/* loaded from: classes2.dex */
public final class C4779p2<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4572c<T, T, T> f18228c;

    /* compiled from: FlowableReduce.java */
    /* renamed from: g.a.y0.e.b.p2$a */
    static final class a<T> extends C5156f<T> implements InterfaceC4529q<T> {
        private static final long serialVersionUID = -4663883003264602070L;
        final InterfaceC4572c<T, T, T> reducer;

        /* renamed from: s */
        InterfaceC5823d f18229s;

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4572c<T, T, T> interfaceC4572c) {
            super(interfaceC5822c);
            this.reducer = interfaceC4572c;
        }

        @Override // p251g.p252a.p268y0.p283i.C5156f, p324i.p338d.InterfaceC5823d
        public void cancel() {
            super.cancel();
            this.f18229s.cancel();
            this.f18229s = EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            InterfaceC5823d interfaceC5823d = this.f18229s;
            EnumC5160j enumC5160j = EnumC5160j.CANCELLED;
            if (interfaceC5823d == enumC5160j) {
                return;
            }
            this.f18229s = enumC5160j;
            T t = this.value;
            if (t != null) {
                complete(t);
            } else {
                this.actual.onComplete();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            InterfaceC5823d interfaceC5823d = this.f18229s;
            EnumC5160j enumC5160j = EnumC5160j.CANCELLED;
            if (interfaceC5823d == enumC5160j) {
                C4476a.m17152b(th);
            } else {
                this.f18229s = enumC5160j;
                this.actual.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f18229s == EnumC5160j.CANCELLED) {
                return;
            }
            T t2 = this.value;
            if (t2 == null) {
                this.value = t;
                return;
            }
            try {
                this.value = (T) C4601b.m18284a((Object) this.reducer.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18229s.cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18229s, interfaceC5823d)) {
                this.f18229s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4779p2(AbstractC4519l<T> abstractC4519l, InterfaceC4572c<T, T, T> interfaceC4572c) {
        super(abstractC4519l);
        this.f18228c = interfaceC4572c;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f18228c));
    }
}
