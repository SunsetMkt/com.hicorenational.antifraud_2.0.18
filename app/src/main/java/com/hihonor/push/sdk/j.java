package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class j implements Runnable {
    public final /* synthetic */ HonorPushCallback a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f4261b;

    public j(l lVar, HonorPushCallback honorPushCallback) {
        this.f4261b = lVar;
        this.a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f4261b.f4266d;
        sVar.a(new q(sVar), this.a);
    }
}
