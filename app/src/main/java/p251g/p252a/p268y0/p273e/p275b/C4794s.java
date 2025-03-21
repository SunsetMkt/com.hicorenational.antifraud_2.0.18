package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4571b;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.C5156f;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableCollect.java */
/* renamed from: g.a.y0.e.b.s */
/* loaded from: classes2.dex */
public final class C4794s<T, U> extends AbstractC4686a<T, U> {

    /* renamed from: c */
    final Callable<? extends U> f18374c;

    /* renamed from: d */
    final InterfaceC4571b<? super U, ? super T> f18375d;

    /* compiled from: FlowableCollect.java */
    /* renamed from: g.a.y0.e.b.s$a */
    static final class a<T, U> extends C5156f<U> implements InterfaceC4529q<T> {
        private static final long serialVersionUID = -3589550218733891694L;
        final InterfaceC4571b<? super U, ? super T> collector;
        boolean done;

        /* renamed from: s */
        InterfaceC5823d f18376s;

        /* renamed from: u */
        final U f18377u;

        a(InterfaceC5822c<? super U> interfaceC5822c, U u, InterfaceC4571b<? super U, ? super T> interfaceC4571b) {
            super(interfaceC5822c);
            this.collector = interfaceC4571b;
            this.f18377u = u;
        }

        @Override // p251g.p252a.p268y0.p283i.C5156f, p324i.p338d.InterfaceC5823d
        public void cancel() {
            super.cancel();
            this.f18376s.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            complete(this.f18377u);
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
                this.collector.mo18209a(this.f18377u, t);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18376s.cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18376s, interfaceC5823d)) {
                this.f18376s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4794s(AbstractC4519l<T> abstractC4519l, Callable<? extends U> callable, InterfaceC4571b<? super U, ? super T> interfaceC4571b) {
        super(abstractC4519l);
        this.f18374c = callable;
        this.f18375d = interfaceC4571b;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super U> interfaceC5822c) {
        try {
            this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, C4601b.m18284a(this.f18374c.call(), "The initial value supplied is null"), this.f18375d));
        } catch (Throwable th) {
            EnumC5157g.error(th, interfaceC5822c);
        }
    }
}
