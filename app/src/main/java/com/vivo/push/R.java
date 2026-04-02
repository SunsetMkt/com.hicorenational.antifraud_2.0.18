package com.vivo.push;

import com.vivo.push.m;

/* JADX INFO: compiled from: PushClientManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class r implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ m f8577b;

    r(m mVar, String str) {
        this.f8577b = mVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.a aVarB = this.f8577b.b(this.a);
        if (aVarB != null) {
            aVarB.a(1003, new Object[0]);
        }
    }
}
