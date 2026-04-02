package com.hihonor.cloudservice.tasks.q;

import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: OnEventListener.java */
/* JADX INFO: loaded from: classes.dex */
public class h<TResult> implements d.c.a.d.e, d.c.a.d.g, d.c.a.d.h<TResult> {
    private final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i<Void> f4086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Exception f4088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4089f;

    h(int i2, i<Void> iVar) {
        this.f4085b = i2;
        this.f4086c = iVar;
    }

    private void a() {
        if (this.f4087d >= this.f4085b) {
            Exception exc = this.f4088e;
            if (exc != null) {
                this.f4086c.a(new ExecutionException("a task failed", exc));
            } else if (this.f4089f) {
                this.f4086c.f();
            } else {
                this.f4086c.a((Void) null);
            }
        }
    }

    @Override // d.c.a.d.e
    public void onCanceled() {
        synchronized (this.a) {
            this.f4087d++;
            this.f4089f = true;
            a();
        }
    }

    @Override // d.c.a.d.g
    public void onFailure(Exception exc) {
        synchronized (this.a) {
            this.f4087d++;
            this.f4088e = exc;
            a();
        }
    }

    @Override // d.c.a.d.h
    public void onSuccess(TResult tresult) {
        synchronized (this.a) {
            this.f4087d++;
            a();
        }
    }
}
