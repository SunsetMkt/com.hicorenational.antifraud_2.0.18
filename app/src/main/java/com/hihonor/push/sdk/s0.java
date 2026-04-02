package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class s0 implements Runnable {
    public final /* synthetic */ a1 a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ t0 f4278b;

    public s0(t0 t0Var, a1 a1Var) {
        this.f4278b = t0Var;
        this.a = a1Var;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f4278b.f4281c) {
            k0<TResult> k0Var = this.f4278b.f4280b;
            if (k0Var != 0) {
                k0Var.a((a1<TResult>) this.a);
            }
        }
    }
}
