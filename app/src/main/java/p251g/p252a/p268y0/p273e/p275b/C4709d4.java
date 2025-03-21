package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p257e1.C4490c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableTimeInterval.java */
/* renamed from: g.a.y0.e.b.d4 */
/* loaded from: classes2.dex */
public final class C4709d4<T> extends AbstractC4686a<T, C4490c<T>> {

    /* renamed from: c */
    final AbstractC4516j0 f17833c;

    /* renamed from: d */
    final TimeUnit f17834d;

    /* compiled from: FlowableTimeInterval.java */
    /* renamed from: g.a.y0.e.b.d4$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super C4490c<T>> f17835a;

        /* renamed from: b */
        final TimeUnit f17836b;

        /* renamed from: c */
        final AbstractC4516j0 f17837c;

        /* renamed from: d */
        InterfaceC5823d f17838d;

        /* renamed from: e */
        long f17839e;

        a(InterfaceC5822c<? super C4490c<T>> interfaceC5822c, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.f17835a = interfaceC5822c;
            this.f17837c = abstractC4516j0;
            this.f17836b = timeUnit;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f17838d.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f17835a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f17835a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            long mo17276a = this.f17837c.mo17276a(this.f17836b);
            long j2 = this.f17839e;
            this.f17839e = mo17276a;
            this.f17835a.onNext(new C4490c(t, mo17276a - j2, this.f17836b));
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17838d, interfaceC5823d)) {
                this.f17839e = this.f17837c.mo17276a(this.f17836b);
                this.f17838d = interfaceC5823d;
                this.f17835a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f17838d.request(j2);
        }
    }

    public C4709d4(AbstractC4519l<T> abstractC4519l, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        super(abstractC4519l);
        this.f17833c = abstractC4516j0;
        this.f17834d = timeUnit;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super C4490c<T>> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f17834d, this.f17833c));
    }
}
