package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p253a1.InterfaceC4460g;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4600a;

/* compiled from: MaybeCallbackObserver.java */
/* renamed from: g.a.y0.e.c.d */
/* loaded from: classes2.dex */
public final class C4845d<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T>, InterfaceC4552c, InterfaceC4460g {
    private static final long serialVersionUID = -6076952298809384986L;
    final InterfaceC4570a onComplete;
    final InterfaceC4576g<? super Throwable> onError;
    final InterfaceC4576g<? super T> onSuccess;

    public C4845d(InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2, InterfaceC4570a interfaceC4570a) {
        this.onSuccess = interfaceC4576g;
        this.onError = interfaceC4576g2;
        this.onComplete = interfaceC4570a;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        EnumC4592d.dispose(this);
    }

    @Override // p251g.p252a.p253a1.InterfaceC4460g
    public boolean hasCustomOnError() {
        return this.onError != C4600a.f17518f;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return EnumC4592d.isDisposed(get());
    }

    @Override // p251g.p252a.InterfaceC4559v
    public void onComplete() {
        lazySet(EnumC4592d.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            C4476a.m17152b(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4559v
    public void onError(Throwable th) {
        lazySet(EnumC4592d.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            C4561b.m18199b(th2);
            C4476a.m17152b(new C4560a(th, th2));
        }
    }

    @Override // p251g.p252a.InterfaceC4559v
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        EnumC4592d.setOnce(this, interfaceC4552c);
    }

    @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
    public void onSuccess(T t) {
        lazySet(EnumC4592d.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            C4476a.m17152b(th);
        }
    }
}
