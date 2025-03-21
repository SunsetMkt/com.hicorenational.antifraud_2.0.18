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

/* compiled from: FlowableElementAtSingle.java */
/* renamed from: g.a.y0.e.b.s0 */
/* loaded from: classes2.dex */
public final class C4795s0<T> extends AbstractC4518k0<T> implements InterfaceC4603b<T> {

    /* renamed from: a */
    final AbstractC4519l<T> f18378a;

    /* renamed from: b */
    final long f18379b;

    /* renamed from: c */
    final T f18380c;

    /* compiled from: FlowableElementAtSingle.java */
    /* renamed from: g.a.y0.e.b.s0$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super T> f18381a;

        /* renamed from: b */
        final long f18382b;

        /* renamed from: c */
        final T f18383c;

        /* renamed from: d */
        InterfaceC5823d f18384d;

        /* renamed from: e */
        long f18385e;

        /* renamed from: f */
        boolean f18386f;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, long j2, T t) {
            this.f18381a = interfaceC4524n0;
            this.f18382b = j2;
            this.f18383c = t;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18384d.cancel();
            this.f18384d = EnumC5160j.CANCELLED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18384d == EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f18384d = EnumC5160j.CANCELLED;
            if (this.f18386f) {
                return;
            }
            this.f18386f = true;
            T t = this.f18383c;
            if (t != null) {
                this.f18381a.onSuccess(t);
            } else {
                this.f18381a.onError(new NoSuchElementException());
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18386f) {
                C4476a.m17152b(th);
                return;
            }
            this.f18386f = true;
            this.f18384d = EnumC5160j.CANCELLED;
            this.f18381a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f18386f) {
                return;
            }
            long j2 = this.f18385e;
            if (j2 != this.f18382b) {
                this.f18385e = j2 + 1;
                return;
            }
            this.f18386f = true;
            this.f18384d.cancel();
            this.f18384d = EnumC5160j.CANCELLED;
            this.f18381a.onSuccess(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18384d, interfaceC5823d)) {
                this.f18384d = interfaceC5823d;
                this.f18381a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4795s0(AbstractC4519l<T> abstractC4519l, long j2, T t) {
        this.f18378a = abstractC4519l;
        this.f18379b = j2;
        this.f18380c = t;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f18378a.m17799a((InterfaceC4529q) new a(interfaceC4524n0, this.f18379b, this.f18380c));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4603b
    /* renamed from: b */
    public AbstractC4519l<T> mo18286b() {
        return C4476a.m17129a(new C4783q0(this.f18378a, this.f18379b, this.f18380c, true));
    }
}
