package p251g.p252a.p268y0.p272d;

import p251g.p252a.InterfaceC4491f;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: SubscriberCompletableObserver.java */
/* renamed from: g.a.y0.d.b0 */
/* loaded from: classes2.dex */
public final class C4620b0<T> implements InterfaceC4491f, InterfaceC5823d {

    /* renamed from: a */
    final InterfaceC5822c<? super T> f17568a;

    /* renamed from: b */
    InterfaceC4552c f17569b;

    public C4620b0(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17568a = interfaceC5822c;
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
        this.f17569b.dispose();
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onComplete() {
        this.f17568a.onComplete();
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onError(Throwable th) {
        this.f17568a.onError(th);
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        if (EnumC4592d.validate(this.f17569b, interfaceC4552c)) {
            this.f17569b = interfaceC4552c;
            this.f17568a.onSubscribe(this);
        }
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
    }
}
