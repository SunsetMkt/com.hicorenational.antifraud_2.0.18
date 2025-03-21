package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p268y0.p283i.C5159i;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableDelaySubscriptionOther.java */
/* renamed from: g.a.y0.e.b.h0 */
/* loaded from: classes2.dex */
public final class C4729h0<T, U> extends AbstractC4519l<T> {

    /* renamed from: b */
    final InterfaceC5821b<? extends T> f17930b;

    /* renamed from: c */
    final InterfaceC5821b<U> f17931c;

    /* compiled from: FlowableDelaySubscriptionOther.java */
    /* renamed from: g.a.y0.e.b.h0$a */
    final class a implements InterfaceC4529q<U> {

        /* renamed from: a */
        final C5159i f17932a;

        /* renamed from: b */
        final InterfaceC5822c<? super T> f17933b;

        /* renamed from: c */
        boolean f17934c;

        /* compiled from: FlowableDelaySubscriptionOther.java */
        /* renamed from: g.a.y0.e.b.h0$a$a, reason: collision with other inner class name */
        final class C7392a implements InterfaceC5823d {

            /* renamed from: a */
            private final InterfaceC5823d f17936a;

            C7392a(InterfaceC5823d interfaceC5823d) {
                this.f17936a = interfaceC5823d;
            }

            @Override // p324i.p338d.InterfaceC5823d
            public void cancel() {
                this.f17936a.cancel();
            }

            @Override // p324i.p338d.InterfaceC5823d
            public void request(long j2) {
            }
        }

        /* compiled from: FlowableDelaySubscriptionOther.java */
        /* renamed from: g.a.y0.e.b.h0$a$b */
        final class b implements InterfaceC4529q<T> {
            b() {
            }

            @Override // p324i.p338d.InterfaceC5822c
            public void onComplete() {
                a.this.f17933b.onComplete();
            }

            @Override // p324i.p338d.InterfaceC5822c
            public void onError(Throwable th) {
                a.this.f17933b.onError(th);
            }

            @Override // p324i.p338d.InterfaceC5822c
            public void onNext(T t) {
                a.this.f17933b.onNext(t);
            }

            @Override // p251g.p252a.InterfaceC4529q
            public void onSubscribe(InterfaceC5823d interfaceC5823d) {
                a.this.f17932a.setSubscription(interfaceC5823d);
            }
        }

        a(C5159i c5159i, InterfaceC5822c<? super T> interfaceC5822c) {
            this.f17932a = c5159i;
            this.f17933b = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f17934c) {
                return;
            }
            this.f17934c = true;
            C4729h0.this.f17930b.subscribe(new b());
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f17934c) {
                C4476a.m17152b(th);
            } else {
                this.f17934c = true;
                this.f17933b.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(U u) {
            onComplete();
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            this.f17932a.setSubscription(new C7392a(interfaceC5823d));
            interfaceC5823d.request(C5556m0.f20396b);
        }
    }

    public C4729h0(InterfaceC5821b<? extends T> interfaceC5821b, InterfaceC5821b<U> interfaceC5821b2) {
        this.f17930b = interfaceC5821b;
        this.f17931c = interfaceC5821b2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        C5159i c5159i = new C5159i();
        interfaceC5822c.onSubscribe(c5159i);
        this.f17931c.subscribe(new a(c5159i, interfaceC5822c));
    }
}
