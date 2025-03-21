package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.t */
/* loaded from: classes.dex */
public class RunnableC2230t implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f6830a;

    /* renamed from: b */
    public final /* synthetic */ Object f6831b;

    public RunnableC2230t(C2228s c2228s, HonorPushCallback honorPushCallback, Object obj) {
        this.f6830a = honorPushCallback;
        this.f6831b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.f6830a;
        if (honorPushCallback != null) {
            honorPushCallback.onSuccess(this.f6831b);
        }
    }
}
