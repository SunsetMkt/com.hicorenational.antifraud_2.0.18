package p251g.p252a.p268y0.p282h;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: SubscriberResourceWrapper.java */
/* renamed from: g.a.y0.h.u */
/* loaded from: classes2.dex */
public final class C5150u<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4529q<T>, InterfaceC4552c, InterfaceC5823d {
    private static final long serialVersionUID = -8612022020200669122L;
    final InterfaceC5822c<? super T> actual;
    final AtomicReference<InterfaceC5823d> subscription = new AtomicReference<>();

    public C5150u(InterfaceC5822c<? super T> interfaceC5822c) {
        this.actual = interfaceC5822c;
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
        dispose();
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        EnumC5160j.cancel(this.subscription);
        EnumC4592d.dispose(this);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return this.subscription.get() == EnumC5160j.CANCELLED;
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        EnumC4592d.dispose(this);
        this.actual.onComplete();
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        EnumC4592d.dispose(this);
        this.actual.onError(th);
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (EnumC5160j.setOnce(this.subscription, interfaceC5823d)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
        if (EnumC5160j.validate(j2)) {
            this.subscription.get().request(j2);
        }
    }

    public void setResource(InterfaceC4552c interfaceC4552c) {
        EnumC4592d.set(this, interfaceC4552c);
    }
}
