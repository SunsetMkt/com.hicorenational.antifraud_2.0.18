package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObserverResourceWrapper.java */
/* renamed from: g.a.y0.e.d.h4 */
/* loaded from: classes2.dex */
public final class C4954h4<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T>, InterfaceC4552c {
    private static final long serialVersionUID = -8612022020200669122L;
    final InterfaceC4514i0<? super T> actual;
    final AtomicReference<InterfaceC4552c> subscription = new AtomicReference<>();

    public C4954h4(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.actual = interfaceC4514i0;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        EnumC4592d.dispose(this.subscription);
        EnumC4592d.dispose(this);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return this.subscription.get() == EnumC4592d.DISPOSED;
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        dispose();
        this.actual.onComplete();
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        dispose();
        this.actual.onError(th);
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        if (EnumC4592d.setOnce(this.subscription, interfaceC4552c)) {
            this.actual.onSubscribe(this);
        }
    }

    public void setResource(InterfaceC4552c interfaceC4552c) {
        EnumC4592d.set(this, interfaceC4552c);
    }
}
