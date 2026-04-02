package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class h implements Runnable {
    public final /* synthetic */ HonorPushCallback a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f4258b;

    public h(l lVar, HonorPushCallback honorPushCallback) {
        this.f4258b = lVar;
        this.a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f4258b.f4266d;
        sVar.a(new o(sVar), this.a);
    }
}
