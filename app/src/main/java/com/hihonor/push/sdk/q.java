package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class q implements Callable<Void> {
    public final /* synthetic */ s a;

    public q(s sVar) {
        this.a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.a.f4275b.a(false);
        return null;
    }
}
