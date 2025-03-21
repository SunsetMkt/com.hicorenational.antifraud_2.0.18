package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* renamed from: com.hihonor.push.sdk.z0 */
/* loaded from: classes.dex */
public final class RunnableC2243z0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C2219n0 f6866a;

    /* renamed from: b */
    public final /* synthetic */ Callable f6867b;

    public RunnableC2243z0(C2219n0 c2219n0, Callable callable) {
        this.f6866a = c2219n0;
        this.f6867b = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f6866a.m6397a((C2219n0) this.f6867b.call());
        } catch (Exception e2) {
            this.f6866a.m6396a(e2);
        }
    }
}
