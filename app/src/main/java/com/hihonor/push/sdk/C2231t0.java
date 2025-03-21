package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* renamed from: com.hihonor.push.sdk.t0 */
/* loaded from: classes.dex */
public final class C2231t0<TResult> implements InterfaceC2211j0<TResult> {

    /* renamed from: a */
    public Executor f6832a;

    /* renamed from: b */
    public InterfaceC2213k0<TResult> f6833b;

    /* renamed from: c */
    public final Object f6834c = new Object();

    public C2231t0(Executor executor, InterfaceC2213k0<TResult> interfaceC2213k0) {
        this.f6833b = interfaceC2213k0;
        this.f6832a = executor;
    }

    @Override // com.hihonor.push.sdk.InterfaceC2211j0
    /* renamed from: a */
    public final void mo6390a(C2185a1<TResult> c2185a1) {
        this.f6832a.execute(new RunnableC2229s0(this, c2185a1));
    }
}
