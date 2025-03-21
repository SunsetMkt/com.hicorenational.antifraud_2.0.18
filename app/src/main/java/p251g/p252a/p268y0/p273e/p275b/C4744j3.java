package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p268y0.p283i.C5156f;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableSingle.java */
/* renamed from: g.a.y0.e.b.j3 */
/* loaded from: classes2.dex */
public final class C4744j3<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final T f17982c;

    /* compiled from: FlowableSingle.java */
    /* renamed from: g.a.y0.e.b.j3$a */
    static final class a<T> extends C5156f<T> implements InterfaceC4529q<T> {
        private static final long serialVersionUID = -5526049321428043809L;
        final T defaultValue;
        boolean done;

        /* renamed from: s */
        InterfaceC5823d f17983s;

        a(InterfaceC5822c<? super T> interfaceC5822c, T t) {
            super(interfaceC5822c);
            this.defaultValue = t;
        }

        @Override // p251g.p252a.p268y0.p283i.C5156f, p324i.p338d.InterfaceC5823d
        public void cancel() {
            super.cancel();
            this.f17983s.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            T t = this.value;
            this.value = null;
            if (t == null) {
                t = this.defaultValue;
            }
            if (t == null) {
                this.actual.onComplete();
            } else {
                complete(t);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.value == null) {
                this.value = t;
                return;
            }
            this.done = true;
            this.f17983s.cancel();
            this.actual.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17983s, interfaceC5823d)) {
                this.f17983s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4744j3(AbstractC4519l<T> abstractC4519l, T t) {
        super(abstractC4519l);
        this.f17982c = t;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f17982c));
    }
}
