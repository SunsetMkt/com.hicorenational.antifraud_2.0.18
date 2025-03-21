package p251g.p252a.p268y0.p272d;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4571b;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: BiConsumerSingleObserver.java */
/* renamed from: g.a.y0.d.d */
/* loaded from: classes2.dex */
public final class C4622d<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4524n0<T>, InterfaceC4552c {
    private static final long serialVersionUID = 4943102778943297569L;
    final InterfaceC4571b<? super T, ? super Throwable> onCallback;

    public C4622d(InterfaceC4571b<? super T, ? super Throwable> interfaceC4571b) {
        this.onCallback = interfaceC4571b;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        EnumC4592d.dispose(this);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return get() == EnumC4592d.DISPOSED;
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onError(Throwable th) {
        try {
            lazySet(EnumC4592d.DISPOSED);
            this.onCallback.mo18209a(null, th);
        } catch (Throwable th2) {
            C4561b.m18199b(th2);
            C4476a.m17152b(new C4560a(th, th2));
        }
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        EnumC4592d.setOnce(this, interfaceC4552c);
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onSuccess(T t) {
        try {
            lazySet(EnumC4592d.DISPOSED);
            this.onCallback.mo18209a(t, null);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            C4476a.m17152b(th);
        }
    }
}
