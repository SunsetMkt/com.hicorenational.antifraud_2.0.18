package com.hihonor.push.sdk;

import java.lang.ref.WeakReference;

/* renamed from: com.hihonor.push.sdk.e */
/* loaded from: classes.dex */
public class RunnableC2196e implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C2234v f6764a;

    /* renamed from: b */
    public final /* synthetic */ C2214l f6765b;

    public RunnableC2196e(C2214l c2214l, C2234v c2234v) {
        this.f6765b = c2214l;
        this.f6764a = c2234v;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6765b.f6800b) {
            return;
        }
        this.f6765b.f6800b = true;
        this.f6765b.getClass();
        this.f6765b.f6799a = new WeakReference<>(this.f6764a.f6840a);
        this.f6765b.f6801c = this.f6764a.f6841b;
        this.f6765b.f6802d = new C2228s(this.f6764a.f6840a);
        if (this.f6765b.f6801c) {
            C2214l c2214l = this.f6765b;
            c2214l.m6394a(new RunnableC2199f(c2214l, null, true), (HonorPushCallback<?>) null);
        }
    }
}
