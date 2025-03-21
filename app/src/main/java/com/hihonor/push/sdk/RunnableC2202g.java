package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.g */
/* loaded from: classes.dex */
public class RunnableC2202g implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f6780a;

    /* renamed from: b */
    public final /* synthetic */ C2214l f6781b;

    public RunnableC2202g(C2214l c2214l, HonorPushCallback honorPushCallback) {
        this.f6781b = c2214l;
        this.f6780a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2228s c2228s = this.f6781b.f6802d;
        c2228s.m6399a(new CallableC2218n(c2228s), this.f6780a);
    }
}
