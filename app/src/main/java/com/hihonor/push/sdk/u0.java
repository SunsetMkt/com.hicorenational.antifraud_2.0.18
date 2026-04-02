package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class u0 implements Runnable {
    public final /* synthetic */ a1 a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ v0 f4284b;

    public u0(v0 v0Var, a1 a1Var) {
        this.f4284b = v0Var;
        this.a = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f4284b.f4287c) {
            l0 l0Var = this.f4284b.f4286b;
            if (l0Var != null) {
                this.a.b();
                ((y0) l0Var).a.countDown();
            }
        }
    }
}
