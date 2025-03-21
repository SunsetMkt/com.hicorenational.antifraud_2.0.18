package p251g.p252a.p268y0.p273e.p275b;

import java.util.NoSuchElementException;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableLastSingle.java */
/* renamed from: g.a.y0.e.b.v1 */
/* loaded from: classes2.dex */
public final class C4813v1<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC5821b<T> f18453a;

    /* renamed from: b */
    final T f18454b;

    /* compiled from: FlowableLastSingle.java */
    /* renamed from: g.a.y0.e.b.v1$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super T> f18455a;

        /* renamed from: b */
        final T f18456b;

        /* renamed from: c */
        InterfaceC5823d f18457c;

        /* renamed from: d */
        T f18458d;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, T t) {
            this.f18455a = interfaceC4524n0;
            this.f18456b = t;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18457c.cancel();
            this.f18457c = EnumC5160j.CANCELLED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18457c == EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f18457c = EnumC5160j.CANCELLED;
            T t = this.f18458d;
            if (t != null) {
                this.f18458d = null;
                this.f18455a.onSuccess(t);
                return;
            }
            T t2 = this.f18456b;
            if (t2 != null) {
                this.f18455a.onSuccess(t2);
            } else {
                this.f18455a.onError(new NoSuchElementException());
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f18457c = EnumC5160j.CANCELLED;
            this.f18458d = null;
            this.f18455a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.f18458d = t;
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18457c, interfaceC5823d)) {
                this.f18457c = interfaceC5823d;
                this.f18455a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4813v1(InterfaceC5821b<T> interfaceC5821b, T t) {
        this.f18453a = interfaceC5821b;
        this.f18454b = t;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f18453a.subscribe(new a(interfaceC4524n0, this.f18454b));
    }
}
