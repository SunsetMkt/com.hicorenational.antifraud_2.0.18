package p251g.p252a.p268y0.p273e.p275b;

import java.util.NoSuchElementException;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p271c.InterfaceC4603b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableSingleSingle.java */
/* renamed from: g.a.y0.e.b.l3 */
/* loaded from: classes2.dex */
public final class C4756l3<T> extends AbstractC4518k0<T> implements InterfaceC4603b<T> {

    /* renamed from: a */
    final AbstractC4519l<T> f18034a;

    /* renamed from: b */
    final T f18035b;

    /* compiled from: FlowableSingleSingle.java */
    /* renamed from: g.a.y0.e.b.l3$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super T> f18036a;

        /* renamed from: b */
        final T f18037b;

        /* renamed from: c */
        InterfaceC5823d f18038c;

        /* renamed from: d */
        boolean f18039d;

        /* renamed from: e */
        T f18040e;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, T t) {
            this.f18036a = interfaceC4524n0;
            this.f18037b = t;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18038c.cancel();
            this.f18038c = EnumC5160j.CANCELLED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18038c == EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18039d) {
                return;
            }
            this.f18039d = true;
            this.f18038c = EnumC5160j.CANCELLED;
            T t = this.f18040e;
            this.f18040e = null;
            if (t == null) {
                t = this.f18037b;
            }
            if (t != null) {
                this.f18036a.onSuccess(t);
            } else {
                this.f18036a.onError(new NoSuchElementException());
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18039d) {
                C4476a.m17152b(th);
                return;
            }
            this.f18039d = true;
            this.f18038c = EnumC5160j.CANCELLED;
            this.f18036a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f18039d) {
                return;
            }
            if (this.f18040e == null) {
                this.f18040e = t;
                return;
            }
            this.f18039d = true;
            this.f18038c.cancel();
            this.f18038c = EnumC5160j.CANCELLED;
            this.f18036a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18038c, interfaceC5823d)) {
                this.f18038c = interfaceC5823d;
                this.f18036a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4756l3(AbstractC4519l<T> abstractC4519l, T t) {
        this.f18034a = abstractC4519l;
        this.f18035b = t;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f18034a.m17799a((InterfaceC4529q) new a(interfaceC4524n0, this.f18035b));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4603b
    /* renamed from: b */
    public AbstractC4519l<T> mo18286b() {
        return C4476a.m17129a(new C4744j3(this.f18034a, this.f18035b));
    }
}
