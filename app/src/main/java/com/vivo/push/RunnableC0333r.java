package com.vivo.push;

import com.vivo.push.m;

/* compiled from: PushClientManager.java */
/* renamed from: com.vivo.push.r, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC0333r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f12131a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ m f12132b;

    RunnableC0333r(m mVar, String str) {
        this.f12132b = mVar;
        this.f12131a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.a b2;
        b2 = this.f12132b.b(this.f12131a);
        if (b2 != null) {
            b2.a(1003, new Object[0]);
        }
    }
}
