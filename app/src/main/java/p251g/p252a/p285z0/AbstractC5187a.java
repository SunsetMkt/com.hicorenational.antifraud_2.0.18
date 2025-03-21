package p251g.p252a.p285z0;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p270b.C4600a;
import p251g.p252a.p268y0.p273e.p277d.C4958i2;
import p251g.p252a.p268y0.p273e.p277d.C4965k;
import p251g.p252a.p268y0.p284j.C5167g;

/* compiled from: ConnectableObservable.java */
/* renamed from: g.a.z0.a */
/* loaded from: classes2.dex */
public abstract class AbstractC5187a<T> extends AbstractC4469b0<T> {
    @InterfaceC4546f
    /* renamed from: O */
    public AbstractC4469b0<T> m18658O() {
        return m18662i(1);
    }

    /* renamed from: P */
    public final InterfaceC4552c m18659P() {
        C5167g c5167g = new C5167g();
        mo18422k((InterfaceC4576g<? super InterfaceC4552c>) c5167g);
        return c5167g.f20028a;
    }

    @InterfaceC4546f
    /* renamed from: Q */
    public AbstractC4469b0<T> m18660Q() {
        return C4476a.m17119a(new C4958i2(this));
    }

    @InterfaceC4546f
    /* renamed from: a */
    public AbstractC4469b0<T> m18661a(int i2, @InterfaceC4546f InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g) {
        if (i2 > 0) {
            return C4476a.m17119a(new C4965k(this, i2, interfaceC4576g));
        }
        mo18422k(interfaceC4576g);
        return C4476a.m17135a((AbstractC5187a) this);
    }

    @InterfaceC4546f
    /* renamed from: i */
    public AbstractC4469b0<T> m18662i(int i2) {
        return m18661a(i2, C4600a.m18257d());
    }

    /* renamed from: k */
    public abstract void mo18422k(@InterfaceC4546f InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g);
}
