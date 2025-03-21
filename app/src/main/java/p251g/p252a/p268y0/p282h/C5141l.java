package p251g.p252a.p268y0.p282h;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p253a1.InterfaceC4460g;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p270b.C4600a;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5823d;

/* compiled from: LambdaSubscriber.java */
/* renamed from: g.a.y0.h.l */
/* loaded from: classes2.dex */
public final class C5141l<T> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<T>, InterfaceC5823d, InterfaceC4552c, InterfaceC4460g {
    private static final long serialVersionUID = -7251123623727029452L;
    final InterfaceC4570a onComplete;
    final InterfaceC4576g<? super Throwable> onError;
    final InterfaceC4576g<? super T> onNext;
    final InterfaceC4576g<? super InterfaceC5823d> onSubscribe;

    public C5141l(InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2, InterfaceC4570a interfaceC4570a, InterfaceC4576g<? super InterfaceC5823d> interfaceC4576g3) {
        this.onNext = interfaceC4576g;
        this.onError = interfaceC4576g2;
        this.onComplete = interfaceC4570a;
        this.onSubscribe = interfaceC4576g3;
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
        EnumC5160j.cancel(this);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        cancel();
    }

    @Override // p251g.p252a.p253a1.InterfaceC4460g
    public boolean hasCustomOnError() {
        return this.onError != C4600a.f17518f;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return get() == EnumC5160j.CANCELLED;
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        InterfaceC5823d interfaceC5823d = get();
        EnumC5160j enumC5160j = EnumC5160j.CANCELLED;
        if (interfaceC5823d != enumC5160j) {
            lazySet(enumC5160j);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(th);
            }
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        InterfaceC5823d interfaceC5823d = get();
        EnumC5160j enumC5160j = EnumC5160j.CANCELLED;
        if (interfaceC5823d == enumC5160j) {
            C4476a.m17152b(th);
            return;
        }
        lazySet(enumC5160j);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            C4561b.m18199b(th2);
            C4476a.m17152b(new C4560a(th, th2));
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            get().cancel();
            onError(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (EnumC5160j.setOnce(this, interfaceC5823d)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                interfaceC5823d.cancel();
                onError(th);
            }
        }
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
        get().request(j2);
    }
}
