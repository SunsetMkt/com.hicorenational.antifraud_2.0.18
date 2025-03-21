package com.vivo.push;

import com.vivo.push.C3924m;

/* compiled from: PushClientManager.java */
/* renamed from: com.vivo.push.r */
/* loaded from: classes2.dex */
final class RunnableC3931r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f14110a;

    /* renamed from: b */
    final /* synthetic */ C3924m f14111b;

    RunnableC3931r(C3924m c3924m, String str) {
        this.f14111b = c3924m;
        this.f14110a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3924m.a m13024b;
        m13024b = this.f14111b.m13024b(this.f14110a);
        if (m13024b != null) {
            m13024b.m13054a(1003, new Object[0]);
        }
    }
}
