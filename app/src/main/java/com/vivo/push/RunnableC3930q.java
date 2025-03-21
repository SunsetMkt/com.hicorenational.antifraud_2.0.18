package com.vivo.push;

import com.vivo.push.p232b.C3830b;

/* compiled from: PushClientManager.java */
/* renamed from: com.vivo.push.q */
/* loaded from: classes2.dex */
final class RunnableC3930q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3830b f14107a;

    /* renamed from: b */
    final /* synthetic */ String f14108b;

    /* renamed from: c */
    final /* synthetic */ C3924m f14109c;

    RunnableC3930q(C3924m c3924m, C3830b c3830b, String str) {
        this.f14109c = c3924m;
        this.f14107a = c3830b;
        this.f14108b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f14109c.m13032a(this.f14107a);
        this.f14109c.m13027c(this.f14108b);
    }
}
