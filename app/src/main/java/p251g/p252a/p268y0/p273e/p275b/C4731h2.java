package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableOnBackpressureError.java */
/* renamed from: g.a.y0.e.b.h2 */
/* loaded from: classes2.dex */
public final class C4731h2<T> extends AbstractC4686a<T, T> {

    /* compiled from: FlowableOnBackpressureError.java */
    /* renamed from: g.a.y0.e.b.h2$a */
    static final class a<T> extends AtomicLong implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = -3176480756392482682L;
        final InterfaceC5822c<? super T> actual;
        boolean done;

        /* renamed from: s */
        InterfaceC5823d f17942s;

        a(InterfaceC5822c<? super T> interfaceC5822c) {
            this.actual = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f17942s.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
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
            if (get() == 0) {
                onError(new C4562c("could not emit value due to lack of requests"));
            } else {
                this.actual.onNext(t);
                C5164d.m18610c(this, 1L);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17942s, interfaceC5823d)) {
                this.f17942s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this, j2);
            }
        }
    }

    public C4731h2(AbstractC4519l<T> abstractC4519l) {
        super(abstractC4519l);
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c));
    }
}
