package p251g.p252a.p253a1;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4597i;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p284j.C5169i;

/* compiled from: ResourceSingleObserver.java */
/* renamed from: g.a.a1.k */
/* loaded from: classes2.dex */
public abstract class AbstractC4464k<T> implements InterfaceC4524n0<T>, InterfaceC4552c {

    /* renamed from: a */
    private final AtomicReference<InterfaceC4552c> f17214a = new AtomicReference<>();

    /* renamed from: b */
    private final C4597i f17215b = new C4597i();

    /* renamed from: a */
    protected void m16506a() {
    }

    /* renamed from: a */
    public final void m16507a(@InterfaceC4546f InterfaceC4552c interfaceC4552c) {
        C4601b.m18284a(interfaceC4552c, "resource is null");
        this.f17215b.mo18181b(interfaceC4552c);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final void dispose() {
        if (EnumC4592d.dispose(this.f17214a)) {
            this.f17215b.dispose();
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final boolean isDisposed() {
        return EnumC4592d.isDisposed(this.f17214a.get());
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public final void onSubscribe(@InterfaceC4546f InterfaceC4552c interfaceC4552c) {
        if (C5169i.m18620a(this.f17214a, interfaceC4552c, (Class<?>) AbstractC4464k.class)) {
            m16506a();
        }
    }
}
