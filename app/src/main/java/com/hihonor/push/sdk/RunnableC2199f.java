package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.f */
/* loaded from: classes.dex */
public class RunnableC2199f implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f6767a;

    /* renamed from: b */
    public final /* synthetic */ boolean f6768b;

    /* renamed from: c */
    public final /* synthetic */ C2214l f6769c;

    public RunnableC2199f(C2214l c2214l, HonorPushCallback honorPushCallback, boolean z) {
        this.f6769c = c2214l;
        this.f6767a = honorPushCallback;
        this.f6768b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2228s c2228s = this.f6769c.f6802d;
        c2228s.m6399a(new CallableC2216m(c2228s, this.f6768b), this.f6767a);
    }
}
