package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class w0 implements Runnable {
    public final /* synthetic */ a1 a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ x0 f4289b;

    public w0(x0 x0Var, a1 a1Var) {
        this.f4289b = x0Var;
        this.a = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f4289b.f4291c) {
            Object obj = this.f4289b.f4290b;
            if (obj != null) {
                this.a.c();
                ((y0) obj).a.countDown();
            }
        }
    }
}
