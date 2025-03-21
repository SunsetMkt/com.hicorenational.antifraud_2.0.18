package p251g.p252a.p268y0.p284j;

import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: EmptyComponent.java */
/* renamed from: g.a.y0.j.h */
/* loaded from: classes2.dex */
public enum EnumC5168h implements InterfaceC4529q<Object>, InterfaceC4514i0<Object>, InterfaceC4559v<Object>, InterfaceC4524n0<Object>, InterfaceC4491f, InterfaceC5823d, InterfaceC4552c {
    INSTANCE;

    public static <T> InterfaceC4514i0<T> asObserver() {
        return INSTANCE;
    }

    public static <T> InterfaceC5822c<T> asSubscriber() {
        return INSTANCE;
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return true;
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        C4476a.m17152b(th);
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(Object obj) {
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        interfaceC4552c.dispose();
    }

    @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
    public void onSuccess(Object obj) {
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
    }

    @Override // p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        interfaceC5823d.cancel();
    }
}
