package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p267x0.InterfaceC4586q;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableDoOnLifecycle.java */
/* renamed from: g.a.y0.e.b.p0 */
/* loaded from: classes2.dex */
public final class C4777p0<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    private final InterfaceC4576g<? super InterfaceC5823d> f18193c;

    /* renamed from: d */
    private final InterfaceC4586q f18194d;

    /* renamed from: e */
    private final InterfaceC4570a f18195e;

    /* compiled from: FlowableDoOnLifecycle.java */
    /* renamed from: g.a.y0.e.b.p0$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super T> f18196a;

        /* renamed from: b */
        final InterfaceC4576g<? super InterfaceC5823d> f18197b;

        /* renamed from: c */
        final InterfaceC4586q f18198c;

        /* renamed from: d */
        final InterfaceC4570a f18199d;

        /* renamed from: e */
        InterfaceC5823d f18200e;

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4576g<? super InterfaceC5823d> interfaceC4576g, InterfaceC4586q interfaceC4586q, InterfaceC4570a interfaceC4570a) {
            this.f18196a = interfaceC5822c;
            this.f18197b = interfaceC4576g;
            this.f18199d = interfaceC4570a;
            this.f18198c = interfaceC4586q;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            try {
                this.f18199d.run();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(th);
            }
            this.f18200e.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18200e != EnumC5160j.CANCELLED) {
                this.f18196a.onComplete();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18200e != EnumC5160j.CANCELLED) {
                this.f18196a.onError(th);
            } else {
                C4476a.m17152b(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.f18196a.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            try {
                this.f18197b.accept(interfaceC5823d);
                if (EnumC5160j.validate(this.f18200e, interfaceC5823d)) {
                    this.f18200e = interfaceC5823d;
                    this.f18196a.onSubscribe(this);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                interfaceC5823d.cancel();
                this.f18200e = EnumC5160j.CANCELLED;
                EnumC5157g.error(th, this.f18196a);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            try {
                this.f18198c.mo18219a(j2);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(th);
            }
            this.f18200e.request(j2);
        }
    }

    public C4777p0(AbstractC4519l<T> abstractC4519l, InterfaceC4576g<? super InterfaceC5823d> interfaceC4576g, InterfaceC4586q interfaceC4586q, InterfaceC4570a interfaceC4570a) {
        super(abstractC4519l);
        this.f18193c = interfaceC4576g;
        this.f18194d = interfaceC4586q;
        this.f18195e = interfaceC4570a;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f18193c, this.f18194d, this.f18195e));
    }
}
