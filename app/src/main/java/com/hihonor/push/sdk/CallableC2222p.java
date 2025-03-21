package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* renamed from: com.hihonor.push.sdk.p */
/* loaded from: classes.dex */
public class CallableC2222p implements Callable<Void> {

    /* renamed from: a */
    public final /* synthetic */ C2228s f6814a;

    public CallableC2222p(C2228s c2228s) {
        this.f6814a = c2228s;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.f6814a.f6824b.m6352a(true);
        return null;
    }
}
