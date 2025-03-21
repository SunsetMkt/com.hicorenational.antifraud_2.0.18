package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.n0 */
/* loaded from: classes.dex */
public class C2219n0<TResult> {

    /* renamed from: a */
    public final C2185a1<TResult> f6809a = new C2185a1<>();

    /* renamed from: a */
    public void m6397a(TResult tresult) {
        C2185a1<TResult> c2185a1 = this.f6809a;
        synchronized (c2185a1.f6748a) {
            if (!c2185a1.f6749b) {
                c2185a1.f6749b = true;
                c2185a1.f6750c = tresult;
                c2185a1.f6748a.notifyAll();
                c2185a1.m6354a();
            }
        }
    }

    /* renamed from: a */
    public void m6396a(Exception exc) {
        C2185a1<TResult> c2185a1 = this.f6809a;
        synchronized (c2185a1.f6748a) {
            if (!c2185a1.f6749b) {
                c2185a1.f6749b = true;
                c2185a1.f6751d = exc;
                c2185a1.f6748a.notifyAll();
                c2185a1.m6354a();
            }
        }
    }
}
