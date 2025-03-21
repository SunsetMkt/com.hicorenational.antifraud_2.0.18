package p251g.p252a.p268y0.p272d;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.InterfaceC4460g;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4600a;

/* compiled from: LambdaObserver.java */
/* renamed from: g.a.y0.d.v */
/* loaded from: classes2.dex */
public final class C4640v<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T>, InterfaceC4552c, InterfaceC4460g {
    private static final long serialVersionUID = -7251123623727029452L;
    final InterfaceC4570a onComplete;
    final InterfaceC4576g<? super Throwable> onError;
    final InterfaceC4576g<? super T> onNext;
    final InterfaceC4576g<? super InterfaceC4552c> onSubscribe;

    public C4640v(InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2, InterfaceC4570a interfaceC4570a, InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g3) {
        this.onNext = interfaceC4576g;
        this.onError = interfaceC4576g2;
        this.onComplete = interfaceC4570a;
        this.onSubscribe = interfaceC4576g3;
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
        return get() == EnumC4592d.DISPOSED;
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(EnumC4592d.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            C4476a.m17152b(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        if (isDisposed()) {
            return;
        }
        lazySet(EnumC4592d.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            C4561b.m18199b(th2);
            C4476a.m17152b(new C4560a(th, th2));
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        if (EnumC4592d.setOnce(this, interfaceC4552c)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                interfaceC4552c.dispose();
                onError(th);
            }
        }
    }
}
