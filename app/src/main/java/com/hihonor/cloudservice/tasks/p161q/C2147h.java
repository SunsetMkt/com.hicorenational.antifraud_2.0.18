package com.hihonor.cloudservice.tasks.p161q;

import java.util.concurrent.ExecutionException;
import p031c.p075c.p076a.p090d.InterfaceC1208e;
import p031c.p075c.p076a.p090d.InterfaceC1210g;
import p031c.p075c.p076a.p090d.InterfaceC1211h;

/* compiled from: OnEventListener.java */
/* renamed from: com.hihonor.cloudservice.tasks.q.h */
/* loaded from: classes.dex */
public class C2147h<TResult> implements InterfaceC1208e, InterfaceC1210g, InterfaceC1211h<TResult> {

    /* renamed from: a */
    private final Object f6462a = new Object();

    /* renamed from: b */
    private final int f6463b;

    /* renamed from: c */
    private final C2148i<Void> f6464c;

    /* renamed from: d */
    private int f6465d;

    /* renamed from: e */
    private Exception f6466e;

    /* renamed from: f */
    private boolean f6467f;

    C2147h(int i2, C2148i<Void> c2148i) {
        this.f6463b = i2;
        this.f6464c = c2148i;
    }

    /* renamed from: a */
    private void m6076a() {
        if (this.f6465d >= this.f6463b) {
            Exception exc = this.f6466e;
            if (exc != null) {
                this.f6464c.m6079a(new ExecutionException("a task failed", exc));
            } else if (this.f6467f) {
                this.f6464c.m6081f();
            } else {
                this.f6464c.m6080a((C2148i<Void>) null);
            }
        }
    }

    @Override // p031c.p075c.p076a.p090d.InterfaceC1208e
    public void onCanceled() {
        synchronized (this.f6462a) {
            this.f6465d++;
            this.f6467f = true;
            m6076a();
        }
    }

    @Override // p031c.p075c.p076a.p090d.InterfaceC1210g
    public void onFailure(Exception exc) {
        synchronized (this.f6462a) {
            this.f6465d++;
            this.f6466e = exc;
            m6076a();
        }
    }

    @Override // p031c.p075c.p076a.p090d.InterfaceC1211h
    public void onSuccess(TResult tresult) {
        synchronized (this.f6462a) {
            this.f6465d++;
            m6076a();
        }
    }
}
