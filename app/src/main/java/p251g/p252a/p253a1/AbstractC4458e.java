package p251g.p252a.p253a1;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p284j.C5169i;

/* compiled from: DisposableObserver.java */
/* renamed from: g.a.a1.e */
/* loaded from: classes2.dex */
public abstract class AbstractC4458e<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

    /* renamed from: a */
    final AtomicReference<InterfaceC4552c> f17206a = new AtomicReference<>();

    /* renamed from: a */
    protected void m16498a() {
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final void dispose() {
        EnumC4592d.dispose(this.f17206a);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final boolean isDisposed() {
        return this.f17206a.get() == EnumC4592d.DISPOSED;
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public final void onSubscribe(@InterfaceC4546f InterfaceC4552c interfaceC4552c) {
        if (C5169i.m18620a(this.f17206a, interfaceC4552c, getClass())) {
            m16498a();
        }
    }
}
