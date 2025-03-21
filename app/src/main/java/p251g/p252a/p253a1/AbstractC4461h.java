package p251g.p252a.p253a1;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4597i;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p284j.C5169i;

/* compiled from: ResourceCompletableObserver.java */
/* renamed from: g.a.a1.h */
/* loaded from: classes2.dex */
public abstract class AbstractC4461h implements InterfaceC4491f, InterfaceC4552c {

    /* renamed from: a */
    private final AtomicReference<InterfaceC4552c> f17208a = new AtomicReference<>();

    /* renamed from: b */
    private final C4597i f17209b = new C4597i();

    /* renamed from: a */
    protected void m16500a() {
    }

    /* renamed from: a */
    public final void m16501a(@InterfaceC4546f InterfaceC4552c interfaceC4552c) {
        C4601b.m18284a(interfaceC4552c, "resource is null");
        this.f17209b.mo18181b(interfaceC4552c);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final void dispose() {
        if (EnumC4592d.dispose(this.f17208a)) {
            this.f17209b.dispose();
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final boolean isDisposed() {
        return EnumC4592d.isDisposed(this.f17208a.get());
    }

    @Override // p251g.p252a.InterfaceC4491f
    public final void onSubscribe(@InterfaceC4546f InterfaceC4552c interfaceC4552c) {
        if (C5169i.m18620a(this.f17208a, interfaceC4552c, (Class<?>) AbstractC4461h.class)) {
            m16500a();
        }
    }
}
