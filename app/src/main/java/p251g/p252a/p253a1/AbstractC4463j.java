package p251g.p252a.p253a1;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4597i;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p284j.C5169i;

/* compiled from: ResourceObserver.java */
/* renamed from: g.a.a1.j */
/* loaded from: classes2.dex */
public abstract class AbstractC4463j<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

    /* renamed from: a */
    private final AtomicReference<InterfaceC4552c> f17212a = new AtomicReference<>();

    /* renamed from: b */
    private final C4597i f17213b = new C4597i();

    /* renamed from: a */
    protected void m16504a() {
    }

    /* renamed from: a */
    public final void m16505a(@InterfaceC4546f InterfaceC4552c interfaceC4552c) {
        C4601b.m18284a(interfaceC4552c, "resource is null");
        this.f17213b.mo18181b(interfaceC4552c);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final void dispose() {
        if (EnumC4592d.dispose(this.f17212a)) {
            this.f17213b.dispose();
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final boolean isDisposed() {
        return EnumC4592d.isDisposed(this.f17212a.get());
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public final void onSubscribe(InterfaceC4552c interfaceC4552c) {
        if (C5169i.m18620a(this.f17212a, interfaceC4552c, (Class<?>) AbstractC4463j.class)) {
            m16504a();
        }
    }
}
