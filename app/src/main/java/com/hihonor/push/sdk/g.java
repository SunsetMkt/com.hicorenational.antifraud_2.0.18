package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class g implements Runnable {
    public final /* synthetic */ HonorPushCallback a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f4255b;

    public g(l lVar, HonorPushCallback honorPushCallback) {
        this.f4255b = lVar;
        this.a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f4255b.f4266d;
        sVar.a(new n(sVar), this.a);
    }
}
