package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.u */
/* loaded from: classes.dex */
public class RunnableC2232u implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f6835a;

    /* renamed from: b */
    public final /* synthetic */ int f6836b;

    /* renamed from: c */
    public final /* synthetic */ String f6837c;

    public RunnableC2232u(C2228s c2228s, HonorPushCallback honorPushCallback, int i2, String str) {
        this.f6835a = honorPushCallback;
        this.f6836b = i2;
        this.f6837c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.f6835a;
        if (honorPushCallback != null) {
            honorPushCallback.onFailure(this.f6836b, this.f6837c);
        }
    }
}
