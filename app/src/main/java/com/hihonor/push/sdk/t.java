package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class t implements Runnable {
    public final /* synthetic */ HonorPushCallback a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4279b;

    public t(s sVar, HonorPushCallback honorPushCallback, Object obj) {
        this.a = honorPushCallback;
        this.f4279b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.a;
        if (honorPushCallback != null) {
            honorPushCallback.onSuccess(this.f4279b);
        }
    }
}
