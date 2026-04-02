package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class f implements Runnable {
    public final /* synthetic */ HonorPushCallback a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f4246c;

    public f(l lVar, HonorPushCallback honorPushCallback, boolean z) {
        this.f4246c = lVar;
        this.a = honorPushCallback;
        this.f4245b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f4246c.f4266d;
        sVar.a(new m(sVar, this.f4245b), this.a);
    }
}
