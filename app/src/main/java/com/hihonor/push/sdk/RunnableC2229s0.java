package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.s0 */
/* loaded from: classes.dex */
public class RunnableC2229s0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C2185a1 f6828a;

    /* renamed from: b */
    public final /* synthetic */ C2231t0 f6829b;

    public RunnableC2229s0(C2231t0 c2231t0, C2185a1 c2185a1) {
        this.f6829b = c2231t0;
        this.f6828a = c2185a1;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f6829b.f6834c) {
            InterfaceC2213k0<TResult> interfaceC2213k0 = this.f6829b.f6833b;
            if (interfaceC2213k0 != 0) {
                interfaceC2213k0.mo6351a(this.f6828a);
            }
        }
    }
}
