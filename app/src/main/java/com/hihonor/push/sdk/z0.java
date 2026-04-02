package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class z0 implements Runnable {
    public final /* synthetic */ n0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callable f4300b;

    public z0(n0 n0Var, Callable callable) {
        this.a = n0Var;
        this.f4300b = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.a(this.f4300b.call());
        } catch (Exception e2) {
            this.a.a(e2);
        }
    }
}
