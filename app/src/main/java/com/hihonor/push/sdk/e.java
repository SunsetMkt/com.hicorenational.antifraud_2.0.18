package com.hihonor.push.sdk;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class e implements Runnable {
    public final /* synthetic */ v a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f4244b;

    public e(l lVar, v vVar) {
        this.f4244b = lVar;
        this.a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4244b.f4264b) {
            return;
        }
        this.f4244b.f4264b = true;
        this.f4244b.getClass();
        this.f4244b.a = new WeakReference<>(this.a.a);
        this.f4244b.f4265c = this.a.f4285b;
        this.f4244b.f4266d = new s(this.a.a);
        if (this.f4244b.f4265c) {
            l lVar = this.f4244b;
            lVar.a(new f(lVar, null, true), (HonorPushCallback<?>) null);
        }
    }
}
