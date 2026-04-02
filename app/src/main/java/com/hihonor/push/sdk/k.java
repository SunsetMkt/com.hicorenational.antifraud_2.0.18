package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class k implements Runnable {
    public final /* synthetic */ HonorPushCallback a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ l f4262b;

    public k(l lVar, HonorPushCallback honorPushCallback) {
        this.f4262b = lVar;
        this.a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f4262b.f4266d;
        HonorPushCallback honorPushCallback = this.a;
        sVar.getClass();
        if (honorPushCallback == null) {
            return;
        }
        a1 a1VarA = b.a(new p0(sVar.a));
        r rVar = new r(sVar, honorPushCallback);
        a1VarA.getClass();
        a1VarA.a(new t0(o0.f4270c.a, rVar));
    }
}
