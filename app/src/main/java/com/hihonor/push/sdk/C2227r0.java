package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* renamed from: com.hihonor.push.sdk.r0 */
/* loaded from: classes.dex */
public final class C2227r0<TResult> implements InterfaceC2211j0<TResult> {

    /* renamed from: a */
    public Executor f6820a;

    /* renamed from: b */
    public C2241y0 f6821b;

    /* renamed from: c */
    public final Object f6822c = new Object();

    public C2227r0(Executor executor, C2241y0 c2241y0) {
        this.f6821b = c2241y0;
        this.f6820a = executor;
    }

    @Override // com.hihonor.push.sdk.InterfaceC2211j0
    /* renamed from: a */
    public final void mo6390a(C2185a1<TResult> c2185a1) {
        c2185a1.m6357d();
    }
}
