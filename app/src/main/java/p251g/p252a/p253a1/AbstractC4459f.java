package p251g.p252a.p253a1;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p284j.C5169i;

/* compiled from: DisposableSingleObserver.java */
/* renamed from: g.a.a1.f */
/* loaded from: classes2.dex */
public abstract class AbstractC4459f<T> implements InterfaceC4524n0<T>, InterfaceC4552c {

    /* renamed from: a */
    final AtomicReference<InterfaceC4552c> f17207a = new AtomicReference<>();

    /* renamed from: a */
    protected void m16499a() {
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final void dispose() {
        EnumC4592d.dispose(this.f17207a);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final boolean isDisposed() {
        return this.f17207a.get() == EnumC4592d.DISPOSED;
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public final void onSubscribe(@InterfaceC4546f InterfaceC4552c interfaceC4552c) {
        if (C5169i.m18620a(this.f17207a, interfaceC4552c, (Class<?>) AbstractC4459f.class)) {
            m16499a();
        }
    }
}
