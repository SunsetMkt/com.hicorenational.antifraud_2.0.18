package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* renamed from: com.hihonor.push.sdk.x0 */
/* loaded from: classes.dex */
public final class C2239x0<TResult> implements InterfaceC2211j0<TResult> {

    /* renamed from: a */
    public Executor f6850a;

    /* renamed from: b */
    public InterfaceC2217m0<TResult> f6851b;

    /* renamed from: c */
    public final Object f6852c = new Object();

    public C2239x0(Executor executor, InterfaceC2217m0<TResult> interfaceC2217m0) {
        this.f6851b = interfaceC2217m0;
        this.f6850a = executor;
    }

    @Override // com.hihonor.push.sdk.InterfaceC2211j0
    /* renamed from: a */
    public final void mo6390a(C2185a1<TResult> c2185a1) {
        if (c2185a1.m6358e()) {
            c2185a1.m6357d();
            this.f6850a.execute(new RunnableC2237w0(this, c2185a1));
        }
    }
}
