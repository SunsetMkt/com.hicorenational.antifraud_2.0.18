package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableIgnoreElements.java */
/* renamed from: g.a.y0.e.b.n1 */
/* loaded from: classes2.dex */
public final class C4766n1<T> extends AbstractC4686a<T, T> {

    /* compiled from: FlowableIgnoreElements.java */
    /* renamed from: g.a.y0.e.b.n1$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC4613l<T> {

        /* renamed from: a */
        final InterfaceC5822c<? super T> f18118a;

        /* renamed from: b */
        InterfaceC5823d f18119b;

        a(InterfaceC5822c<? super T> interfaceC5822c) {
            this.f18118a = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f18119b.cancel();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return true;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f18118a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f18118a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18119b, interfaceC5823d)) {
                this.f18119b = interfaceC5823d;
                this.f18118a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() {
            return null;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return i2 & 2;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    public C4766n1(AbstractC4519l<T> abstractC4519l) {
        super(abstractC4519l);
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c));
    }
}
