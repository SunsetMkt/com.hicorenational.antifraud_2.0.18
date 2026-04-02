package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class r0<TResult> implements j0<TResult> {
    public Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y0 f4273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4274c = new Object();

    public r0(Executor executor, y0 y0Var) {
        this.f4273b = y0Var;
        this.a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1<TResult> a1Var) {
        a1Var.d();
    }
}
