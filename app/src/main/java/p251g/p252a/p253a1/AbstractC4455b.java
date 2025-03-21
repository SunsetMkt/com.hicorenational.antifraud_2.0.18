package p251g.p252a.p253a1;

import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p284j.C5169i;

/* compiled from: DefaultObserver.java */
/* renamed from: g.a.a1.b */
/* loaded from: classes2.dex */
public abstract class AbstractC4455b<T> implements InterfaceC4514i0<T> {

    /* renamed from: a */
    private InterfaceC4552c f17203a;

    /* renamed from: a */
    protected final void m16494a() {
        InterfaceC4552c interfaceC4552c = this.f17203a;
        this.f17203a = EnumC4592d.DISPOSED;
        interfaceC4552c.dispose();
    }

    /* renamed from: b */
    protected void m16495b() {
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public final void onSubscribe(@InterfaceC4546f InterfaceC4552c interfaceC4552c) {
        if (C5169i.m18618a(this.f17203a, interfaceC4552c, getClass())) {
            this.f17203a = interfaceC4552c;
            m16495b();
        }
    }
}
