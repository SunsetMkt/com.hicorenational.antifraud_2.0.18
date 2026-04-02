package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class u implements Runnable {
    public final /* synthetic */ HonorPushCallback a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4283c;

    public u(s sVar, HonorPushCallback honorPushCallback, int i2, String str) {
        this.a = honorPushCallback;
        this.f4282b = i2;
        this.f4283c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.a;
        if (honorPushCallback != null) {
            honorPushCallback.onFailure(this.f4282b, this.f4283c);
        }
    }
}
