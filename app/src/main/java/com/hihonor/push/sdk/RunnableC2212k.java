package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.k */
/* loaded from: classes.dex */
public class RunnableC2212k implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f6796a;

    /* renamed from: b */
    public final /* synthetic */ C2214l f6797b;

    public RunnableC2212k(C2214l c2214l, HonorPushCallback honorPushCallback) {
        this.f6797b = c2214l;
        this.f6796a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2228s c2228s = this.f6797b.f6802d;
        HonorPushCallback honorPushCallback = this.f6796a;
        c2228s.getClass();
        if (honorPushCallback == null) {
            return;
        }
        C2185a1 m6360a = C2186b.m6360a(new CallableC2223p0(c2228s.f6823a));
        C2226r c2226r = new C2226r(c2228s, honorPushCallback);
        m6360a.getClass();
        m6360a.m6353a(new C2231t0(C2221o0.f6811c.f6812a, c2226r));
    }
}
