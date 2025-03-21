package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.w0 */
/* loaded from: classes.dex */
public class RunnableC2237w0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C2185a1 f6847a;

    /* renamed from: b */
    public final /* synthetic */ C2239x0 f6848b;

    public RunnableC2237w0(C2239x0 c2239x0, C2185a1 c2185a1) {
        this.f6848b = c2239x0;
        this.f6847a = c2185a1;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f6848b.f6852c) {
            Object obj = this.f6848b.f6851b;
            if (obj != null) {
                this.f6847a.m6356c();
                ((C2241y0) obj).f6855a.countDown();
            }
        }
    }
}
