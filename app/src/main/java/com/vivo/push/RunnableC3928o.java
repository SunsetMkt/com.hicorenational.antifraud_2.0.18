package com.vivo.push;

import com.vivo.push.p232b.C3830b;

/* compiled from: PushClientManager.java */
/* renamed from: com.vivo.push.o */
/* loaded from: classes2.dex */
final class RunnableC3928o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3830b f14103a;

    /* renamed from: b */
    final /* synthetic */ String f14104b;

    /* renamed from: c */
    final /* synthetic */ C3924m f14105c;

    RunnableC3928o(C3924m c3924m, C3830b c3830b, String str) {
        this.f14105c = c3924m;
        this.f14103a = c3830b;
        this.f14104b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f14105c.m13032a(this.f14103a);
        this.f14105c.m13027c(this.f14104b);
    }
}
