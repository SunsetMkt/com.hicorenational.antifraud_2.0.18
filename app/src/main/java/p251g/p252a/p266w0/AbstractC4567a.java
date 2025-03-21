package p251g.p252a.p266w0;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p270b.C4600a;
import p251g.p252a.p268y0.p273e.p275b.C4746k;
import p251g.p252a.p268y0.p273e.p275b.C4803t2;
import p251g.p252a.p268y0.p284j.C5167g;

/* compiled from: ConnectableFlowable.java */
/* renamed from: g.a.w0.a */
/* loaded from: classes2.dex */
public abstract class AbstractC4567a<T> extends AbstractC4519l<T> {
    @InterfaceC4546f
    /* renamed from: T */
    public AbstractC4519l<T> m18201T() {
        return m18206m(1);
    }

    /* renamed from: U */
    public final InterfaceC4552c m18202U() {
        C5167g c5167g = new C5167g();
        mo18205l((InterfaceC4576g<? super InterfaceC4552c>) c5167g);
        return c5167g.f20028a;
    }

    @InterfaceC4546f
    /* renamed from: V */
    public AbstractC4519l<T> m18203V() {
        return C4476a.m17129a(new C4803t2(this));
    }

    @InterfaceC4546f
    /* renamed from: a */
    public AbstractC4519l<T> m18204a(int i2, @InterfaceC4546f InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g) {
        if (i2 > 0) {
            return C4476a.m17129a(new C4746k(this, i2, interfaceC4576g));
        }
        mo18205l(interfaceC4576g);
        return C4476a.m17133a((AbstractC4567a) this);
    }

    /* renamed from: l */
    public abstract void mo18205l(@InterfaceC4546f InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g);

    @InterfaceC4546f
    /* renamed from: m */
    public AbstractC4519l<T> m18206m(int i2) {
        return m18204a(i2, C4600a.m18257d());
    }
}
