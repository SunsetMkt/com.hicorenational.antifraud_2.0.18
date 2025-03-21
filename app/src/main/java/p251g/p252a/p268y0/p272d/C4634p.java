package p251g.p252a.p268y0.p272d;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ForEachWhileObserver.java */
/* renamed from: g.a.y0.d.p */
/* loaded from: classes2.dex */
public final class C4634p<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T>, InterfaceC4552c {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final InterfaceC4570a onComplete;
    final InterfaceC4576g<? super Throwable> onError;
    final InterfaceC4587r<? super T> onNext;

    public C4634p(InterfaceC4587r<? super T> interfaceC4587r, InterfaceC4576g<? super Throwable> interfaceC4576g, InterfaceC4570a interfaceC4570a) {
        this.onNext = interfaceC4587r;
        this.onError = interfaceC4576g;
        this.onComplete = interfaceC4570a;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        EnumC4592d.dispose(this);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return EnumC4592d.isDisposed(get());
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            C4476a.m17152b(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        if (this.done) {
            C4476a.m17152b(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            C4561b.m18199b(th2);
            C4476a.m17152b(new C4560a(th, th2));
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            if (this.onNext.test(t)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            dispose();
            onError(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        EnumC4592d.setOnce(this, interfaceC4552c);
    }
}
