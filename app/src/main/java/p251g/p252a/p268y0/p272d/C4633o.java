package p251g.p252a.p268y0.p272d;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.p253a1.InterfaceC4460g;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4563d;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: EmptyCompletableObserver.java */
/* renamed from: g.a.y0.d.o */
/* loaded from: classes2.dex */
public final class C4633o extends AtomicReference<InterfaceC4552c> implements InterfaceC4491f, InterfaceC4552c, InterfaceC4460g {
    private static final long serialVersionUID = -7545121636549663526L;

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        EnumC4592d.dispose(this);
    }

    @Override // p251g.p252a.p253a1.InterfaceC4460g
    public boolean hasCustomOnError() {
        return false;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return get() == EnumC4592d.DISPOSED;
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onComplete() {
        lazySet(EnumC4592d.DISPOSED);
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onError(Throwable th) {
        lazySet(EnumC4592d.DISPOSED);
        C4476a.m17152b(new C4563d(th));
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        EnumC4592d.setOnce(this, interfaceC4552c);
    }
}
