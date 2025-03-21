package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* renamed from: com.hihonor.push.sdk.v0 */
/* loaded from: classes.dex */
public final class C2235v0<TResult> implements InterfaceC2211j0<TResult> {

    /* renamed from: a */
    public Executor f6842a;

    /* renamed from: b */
    public InterfaceC2215l0 f6843b;

    /* renamed from: c */
    public final Object f6844c = new Object();

    public C2235v0(Executor executor, InterfaceC2215l0 interfaceC2215l0) {
        this.f6843b = interfaceC2215l0;
        this.f6842a = executor;
    }

    @Override // com.hihonor.push.sdk.InterfaceC2211j0
    /* renamed from: a */
    public final void mo6390a(C2185a1<TResult> c2185a1) {
        if (c2185a1.m6358e()) {
            return;
        }
        c2185a1.m6357d();
        this.f6842a.execute(new RunnableC2233u0(this, c2185a1));
    }
}
