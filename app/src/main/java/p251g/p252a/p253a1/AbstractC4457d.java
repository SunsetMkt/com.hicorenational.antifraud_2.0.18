package p251g.p252a.p253a1;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p284j.C5169i;

/* compiled from: DisposableMaybeObserver.java */
/* renamed from: g.a.a1.d */
/* loaded from: classes2.dex */
public abstract class AbstractC4457d<T> implements InterfaceC4559v<T>, InterfaceC4552c {

    /* renamed from: a */
    final AtomicReference<InterfaceC4552c> f17205a = new AtomicReference<>();

    /* renamed from: a */
    protected void m16497a() {
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final void dispose() {
        EnumC4592d.dispose(this.f17205a);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final boolean isDisposed() {
        return this.f17205a.get() == EnumC4592d.DISPOSED;
    }

    @Override // p251g.p252a.InterfaceC4559v
    public final void onSubscribe(@InterfaceC4546f InterfaceC4552c interfaceC4552c) {
        if (C5169i.m18620a(this.f17205a, interfaceC4552c, (Class<?>) AbstractC4457d.class)) {
            m16497a();
        }
    }
}
