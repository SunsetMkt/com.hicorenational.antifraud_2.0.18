package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class n0<TResult> {
    public final a1<TResult> a = new a1<>();

    public void a(TResult tresult) {
        a1<TResult> a1Var = this.a;
        synchronized (a1Var.a) {
            if (!a1Var.f4233b) {
                a1Var.f4233b = true;
                a1Var.f4234c = tresult;
                a1Var.a.notifyAll();
                a1Var.a();
            }
        }
    }

    public void a(Exception exc) {
        a1<TResult> a1Var = this.a;
        synchronized (a1Var.a) {
            if (!a1Var.f4233b) {
                a1Var.f4233b = true;
                a1Var.f4235d = exc;
                a1Var.a.notifyAll();
                a1Var.a();
            }
        }
    }
}
