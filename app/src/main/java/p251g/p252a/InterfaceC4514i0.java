package p251g.p252a;

import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: Observer.java */
/* renamed from: g.a.i0 */
/* loaded from: classes2.dex */
public interface InterfaceC4514i0<T> {
    void onComplete();

    void onError(@InterfaceC4546f Throwable th);

    void onNext(@InterfaceC4546f T t);

    void onSubscribe(@InterfaceC4546f InterfaceC4552c interfaceC4552c);
}
