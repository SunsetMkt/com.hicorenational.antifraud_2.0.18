package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.h */
/* loaded from: classes.dex */
public class RunnableC2205h implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f6785a;

    /* renamed from: b */
    public final /* synthetic */ C2214l f6786b;

    public RunnableC2205h(C2214l c2214l, HonorPushCallback honorPushCallback) {
        this.f6786b = c2214l;
        this.f6785a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2228s c2228s = this.f6786b.f6802d;
        c2228s.m6399a(new CallableC2220o(c2228s), this.f6785a);
    }
}
