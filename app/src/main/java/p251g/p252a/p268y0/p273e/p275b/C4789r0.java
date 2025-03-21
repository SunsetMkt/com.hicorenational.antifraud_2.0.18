package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p271c.InterfaceC4603b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableElementAtMaybe.java */
/* renamed from: g.a.y0.e.b.r0 */
/* loaded from: classes2.dex */
public final class C4789r0<T> extends AbstractC4533s<T> implements InterfaceC4603b<T> {

    /* renamed from: a */
    final AbstractC4519l<T> f18344a;

    /* renamed from: b */
    final long f18345b;

    /* compiled from: FlowableElementAtMaybe.java */
    /* renamed from: g.a.y0.e.b.r0$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18346a;

        /* renamed from: b */
        final long f18347b;

        /* renamed from: c */
        InterfaceC5823d f18348c;

        /* renamed from: d */
        long f18349d;

        /* renamed from: e */
        boolean f18350e;

        a(InterfaceC4559v<? super T> interfaceC4559v, long j2) {
            this.f18346a = interfaceC4559v;
            this.f18347b = j2;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18348c.cancel();
            this.f18348c = EnumC5160j.CANCELLED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18348c == EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f18348c = EnumC5160j.CANCELLED;
            if (this.f18350e) {
                return;
            }
            this.f18350e = true;
            this.f18346a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18350e) {
                C4476a.m17152b(th);
                return;
            }
            this.f18350e = true;
            this.f18348c = EnumC5160j.CANCELLED;
            this.f18346a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f18350e) {
                return;
            }
            long j2 = this.f18349d;
            if (j2 != this.f18347b) {
                this.f18349d = j2 + 1;
                return;
            }
            this.f18350e = true;
            this.f18348c.cancel();
            this.f18348c = EnumC5160j.CANCELLED;
            this.f18346a.onSuccess(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18348c, interfaceC5823d)) {
                this.f18348c = interfaceC5823d;
                this.f18346a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4789r0(AbstractC4519l<T> abstractC4519l, long j2) {
        this.f18344a = abstractC4519l;
        this.f18345b = j2;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18344a.m17799a((InterfaceC4529q) new a(interfaceC4559v, this.f18345b));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4603b
    /* renamed from: b */
    public AbstractC4519l<T> mo18286b() {
        return C4476a.m17129a(new C4783q0(this.f18344a, this.f18345b, null, false));
    }
}
