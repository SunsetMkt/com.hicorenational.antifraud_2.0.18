package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.i */
/* loaded from: classes.dex */
public class RunnableC2208i implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f6790a;

    /* renamed from: b */
    public final /* synthetic */ C2214l f6791b;

    public RunnableC2208i(C2214l c2214l, HonorPushCallback honorPushCallback) {
        this.f6791b = c2214l;
        this.f6790a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2228s c2228s = this.f6791b.f6802d;
        c2228s.m6399a(new CallableC2222p(c2228s), this.f6790a);
    }
}
