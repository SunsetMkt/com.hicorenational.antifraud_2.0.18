package p251g.p252a.p268y0.p272d;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.p253a1.InterfaceC4460g;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4563d;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: CallbackCompletableObserver.java */
/* renamed from: g.a.y0.d.j */
/* loaded from: classes2.dex */
public final class C4628j extends AtomicReference<InterfaceC4552c> implements InterfaceC4491f, InterfaceC4552c, InterfaceC4576g<Throwable>, InterfaceC4460g {
    private static final long serialVersionUID = -4361286194466301354L;
    final InterfaceC4570a onComplete;
    final InterfaceC4576g<? super Throwable> onError;

    public C4628j(InterfaceC4570a interfaceC4570a) {
        this.onError = this;
        this.onComplete = interfaceC4570a;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        EnumC4592d.dispose(this);
    }

    @Override // p251g.p252a.p253a1.InterfaceC4460g
    public boolean hasCustomOnError() {
        return this.onError != this;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return get() == EnumC4592d.DISPOSED;
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            C4476a.m17152b(th);
        }
        lazySet(EnumC4592d.DISPOSED);
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            C4561b.m18199b(th2);
            C4476a.m17152b(th2);
        }
        lazySet(EnumC4592d.DISPOSED);
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        EnumC4592d.setOnce(this, interfaceC4552c);
    }

    @Override // p251g.p252a.p267x0.InterfaceC4576g
    public void accept(Throwable th) {
        C4476a.m17152b(new C4563d(th));
    }

    public C4628j(InterfaceC4576g<? super Throwable> interfaceC4576g, InterfaceC4570a interfaceC4570a) {
        this.onError = interfaceC4576g;
        this.onComplete = interfaceC4570a;
    }
}
