package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class p implements Callable<Void> {
    public final /* synthetic */ s a;

    public p(s sVar) {
        this.a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.a.f4275b.a(true);
        return null;
    }
}
