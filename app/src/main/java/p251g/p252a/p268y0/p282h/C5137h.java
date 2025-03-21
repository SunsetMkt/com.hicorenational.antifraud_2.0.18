package p251g.p252a.p268y0.p282h;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ForEachWhileSubscriber.java */
/* renamed from: g.a.y0.h.h */
/* loaded from: classes2.dex */
public final class C5137h<T> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<T>, InterfaceC4552c {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final InterfaceC4570a onComplete;
    final InterfaceC4576g<? super Throwable> onError;
    final InterfaceC4587r<? super T> onNext;

    public C5137h(InterfaceC4587r<? super T> interfaceC4587r, InterfaceC4576g<? super Throwable> interfaceC4576g, InterfaceC4570a interfaceC4570a) {
        this.onNext = interfaceC4587r;
        this.onError = interfaceC4576g;
        this.onComplete = interfaceC4570a;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        EnumC5160j.cancel(this);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return EnumC5160j.isCancelled(get());
    }

    @Override // p324i.p338d.InterfaceC5822c
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

    @Override // p324i.p338d.InterfaceC5822c
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

    @Override // p324i.p338d.InterfaceC5822c
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

    @Override // p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (EnumC5160j.setOnce(this, interfaceC5823d)) {
            interfaceC5823d.request(C5556m0.f20396b);
        }
    }
}
