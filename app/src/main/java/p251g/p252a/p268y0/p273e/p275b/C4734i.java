package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p283i.C5156f;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableAny.java */
/* renamed from: g.a.y0.e.b.i */
/* loaded from: classes2.dex */
public final class C4734i<T> extends AbstractC4686a<T, Boolean> {

    /* renamed from: c */
    final InterfaceC4587r<? super T> f17951c;

    /* compiled from: FlowableAny.java */
    /* renamed from: g.a.y0.e.b.i$a */
    static final class a<T> extends C5156f<Boolean> implements InterfaceC4529q<T> {
        private static final long serialVersionUID = -2311252482644620661L;
        boolean done;
        final InterfaceC4587r<? super T> predicate;

        /* renamed from: s */
        InterfaceC5823d f17952s;

        a(InterfaceC5822c<? super Boolean> interfaceC5822c, InterfaceC4587r<? super T> interfaceC4587r) {
            super(interfaceC5822c);
            this.predicate = interfaceC4587r;
        }

        @Override // p251g.p252a.p268y0.p283i.C5156f, p324i.p338d.InterfaceC5823d
        public void cancel() {
            super.cancel();
            this.f17952s.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            complete(false);
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
            try {
                if (this.predicate.test(t)) {
                    this.done = true;
                    this.f17952s.cancel();
                    complete(true);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f17952s.cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17952s, interfaceC5823d)) {
                this.f17952s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4734i(AbstractC4519l<T> abstractC4519l, InterfaceC4587r<? super T> interfaceC4587r) {
        super(abstractC4519l);
        this.f17951c = interfaceC4587r;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super Boolean> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f17951c));
    }
}
