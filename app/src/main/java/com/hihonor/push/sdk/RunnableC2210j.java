package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.j */
/* loaded from: classes.dex */
public class RunnableC2210j implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f6794a;

    /* renamed from: b */
    public final /* synthetic */ C2214l f6795b;

    public RunnableC2210j(C2214l c2214l, HonorPushCallback honorPushCallback) {
        this.f6795b = c2214l;
        this.f6794a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2228s c2228s = this.f6795b.f6802d;
        c2228s.m6399a(new CallableC2224q(c2228s), this.f6794a);
    }
}
