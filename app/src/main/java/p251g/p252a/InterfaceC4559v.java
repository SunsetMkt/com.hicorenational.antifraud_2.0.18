package p251g.p252a;

import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: MaybeObserver.java */
/* renamed from: g.a.v */
/* loaded from: classes2.dex */
public interface InterfaceC4559v<T> {
    void onComplete();

    void onError(@InterfaceC4546f Throwable th);

    void onSubscribe(@InterfaceC4546f InterfaceC4552c interfaceC4552c);

    void onSuccess(@InterfaceC4546f T t);
}
