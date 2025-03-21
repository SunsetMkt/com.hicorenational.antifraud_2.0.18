package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5823d;

/* compiled from: MaybeDelaySubscriptionOtherPublisher.java */
/* renamed from: g.a.y0.e.c.n */
/* loaded from: classes2.dex */
public final class C4875n<T, U> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final InterfaceC5821b<U> f18656b;

    /* compiled from: MaybeDelaySubscriptionOtherPublisher.java */
    /* renamed from: g.a.y0.e.c.n$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T> {
        private static final long serialVersionUID = 706635022205076709L;
        final InterfaceC4559v<? super T> actual;

        a(InterfaceC4559v<? super T> interfaceC4559v) {
            this.actual = interfaceC4559v;
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    /* compiled from: MaybeDelaySubscriptionOtherPublisher.java */
    /* renamed from: g.a.y0.e.c.n$b */
    static final class b<T> implements InterfaceC4529q<Object>, InterfaceC4552c {

        /* renamed from: a */
        final a<T> f18657a;

        /* renamed from: b */
        InterfaceC4588y<T> f18658b;

        /* renamed from: c */
        InterfaceC5823d f18659c;

        b(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC4588y<T> interfaceC4588y) {
            this.f18657a = new a<>(interfaceC4559v);
            this.f18658b = interfaceC4588y;
        }

        /* renamed from: a */
        void m18412a() {
            InterfaceC4588y<T> interfaceC4588y = this.f18658b;
            this.f18658b = null;
            interfaceC4588y.mo18100a(this.f18657a);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18659c.cancel();
            this.f18659c = EnumC5160j.CANCELLED;
            EnumC4592d.dispose(this.f18657a);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(this.f18657a.get());
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            InterfaceC5823d interfaceC5823d = this.f18659c;
            EnumC5160j enumC5160j = EnumC5160j.CANCELLED;
            if (interfaceC5823d != enumC5160j) {
                this.f18659c = enumC5160j;
                m18412a();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            InterfaceC5823d interfaceC5823d = this.f18659c;
            EnumC5160j enumC5160j = EnumC5160j.CANCELLED;
            if (interfaceC5823d == enumC5160j) {
                C4476a.m17152b(th);
            } else {
                this.f18659c = enumC5160j;
                this.f18657a.actual.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(Object obj) {
            InterfaceC5823d interfaceC5823d = this.f18659c;
            if (interfaceC5823d != EnumC5160j.CANCELLED) {
                interfaceC5823d.cancel();
                this.f18659c = EnumC5160j.CANCELLED;
                m18412a();
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18659c, interfaceC5823d)) {
                this.f18659c = interfaceC5823d;
                this.f18657a.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4875n(InterfaceC4588y<T> interfaceC4588y, InterfaceC5821b<U> interfaceC5821b) {
        super(interfaceC4588y);
        this.f18656b = interfaceC5821b;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18656b.subscribe(new b(interfaceC4559v, this.f18548a));
    }
}
