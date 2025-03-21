package p251g.p252a;

import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p267x0.InterfaceC4575f;

/* compiled from: CompletableEmitter.java */
/* renamed from: g.a.e */
/* loaded from: classes2.dex */
public interface InterfaceC4486e {
    boolean isDisposed();

    void onComplete();

    void onError(@InterfaceC4546f Throwable th);

    void setCancellable(@InterfaceC4547g InterfaceC4575f interfaceC4575f);

    void setDisposable(@InterfaceC4547g InterfaceC4552c interfaceC4552c);

    @InterfaceC4545e
    boolean tryOnError(@InterfaceC4546f Throwable th);
}
