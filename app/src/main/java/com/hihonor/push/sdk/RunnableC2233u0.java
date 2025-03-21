package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.u0 */
/* loaded from: classes.dex */
public class RunnableC2233u0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C2185a1 f6838a;

    /* renamed from: b */
    public final /* synthetic */ C2235v0 f6839b;

    public RunnableC2233u0(C2235v0 c2235v0, C2185a1 c2185a1) {
        this.f6839b = c2235v0;
        this.f6838a = c2185a1;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f6839b.f6844c) {
            InterfaceC2215l0 interfaceC2215l0 = this.f6839b.f6843b;
            if (interfaceC2215l0 != null) {
                this.f6838a.m6355b();
                ((C2241y0) interfaceC2215l0).f6855a.countDown();
            }
        }
    }
}
