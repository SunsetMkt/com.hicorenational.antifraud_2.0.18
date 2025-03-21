package p251g.p252a.p268y0.p273e.p279f;

import java.util.NoSuchElementException;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5823d;

/* compiled from: SingleFromPublisher.java */
/* renamed from: g.a.y0.e.f.b0 */
/* loaded from: classes2.dex */
public final class C5064b0<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC5821b<? extends T> f19673a;

    /* compiled from: SingleFromPublisher.java */
    /* renamed from: g.a.y0.e.f.b0$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super T> f19674a;

        /* renamed from: b */
        InterfaceC5823d f19675b;

        /* renamed from: c */
        T f19676c;

        /* renamed from: d */
        boolean f19677d;

        /* renamed from: e */
        volatile boolean f19678e;

        a(InterfaceC4524n0<? super T> interfaceC4524n0) {
            this.f19674a = interfaceC4524n0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19678e = true;
            this.f19675b.cancel();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19678e;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19677d) {
                return;
            }
            this.f19677d = true;
            T t = this.f19676c;
            this.f19676c = null;
            if (t == null) {
                this.f19674a.onError(new NoSuchElementException("The source Publisher is empty"));
            } else {
                this.f19674a.onSuccess(t);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19677d) {
                C4476a.m17152b(th);
                return;
            }
            this.f19677d = true;
            this.f19676c = null;
            this.f19674a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f19677d) {
                return;
            }
            if (this.f19676c == null) {
                this.f19676c = t;
                return;
            }
            this.f19675b.cancel();
            this.f19677d = true;
            this.f19676c = null;
            this.f19674a.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f19675b, interfaceC5823d)) {
                this.f19675b = interfaceC5823d;
                this.f19674a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C5064b0(InterfaceC5821b<? extends T> interfaceC5821b) {
        this.f19673a = interfaceC5821b;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19673a.subscribe(new a(interfaceC4524n0));
    }
}
