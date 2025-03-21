package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.C4453a0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableDematerialize.java */
/* renamed from: g.a.y0.e.b.i0 */
/* loaded from: classes2.dex */
public final class C4735i0<T> extends AbstractC4686a<C4453a0<T>, T> {

    /* compiled from: FlowableDematerialize.java */
    /* renamed from: g.a.y0.e.b.i0$a */
    static final class a<T> implements InterfaceC4529q<C4453a0<T>>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super T> f17953a;

        /* renamed from: b */
        boolean f17954b;

        /* renamed from: c */
        InterfaceC5823d f17955c;

        a(InterfaceC5822c<? super T> interfaceC5822c) {
            this.f17953a = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5822c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(C4453a0<T> c4453a0) {
            if (this.f17954b) {
                if (c4453a0.m16441d()) {
                    C4476a.m17152b(c4453a0.m16438a());
                }
            } else if (c4453a0.m16441d()) {
                this.f17955c.cancel();
                onError(c4453a0.m16438a());
            } else if (!c4453a0.m16440c()) {
                this.f17953a.onNext(c4453a0.m16439b());
            } else {
                this.f17955c.cancel();
                onComplete();
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f17955c.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f17954b) {
                return;
            }
            this.f17954b = true;
            this.f17953a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f17954b) {
                C4476a.m17152b(th);
            } else {
                this.f17954b = true;
                this.f17953a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17955c, interfaceC5823d)) {
                this.f17955c = interfaceC5823d;
                this.f17953a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f17955c.request(j2);
        }
    }

    public C4735i0(AbstractC4519l<C4453a0<T>> abstractC4519l) {
        super(abstractC4519l);
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c));
    }
}
