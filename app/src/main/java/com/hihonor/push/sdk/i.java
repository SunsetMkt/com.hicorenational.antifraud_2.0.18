package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class i implements Runnable {
    public final /* synthetic */ HonorPushCallback a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f4260b;

    public i(l lVar, HonorPushCallback honorPushCallback) {
        this.f4260b = lVar;
        this.a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f4260b.f4266d;
        sVar.a(new p(sVar), this.a);
    }
}
