package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ag;

/* JADX INFO: compiled from: SubscribeImpl.java */
/* JADX INFO: loaded from: classes2.dex */
final class aa implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ z f8437b;

    aa(z zVar, String str) {
        this.f8437b = zVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context contextB = com.vivo.push.restructure.a.a().b();
        if (contextB == null) {
            return;
        }
        long j2 = m.a().f() ? 488L : 341L;
        if (TextUtils.isEmpty(this.a) || !ag.a(contextB, contextB.getPackageName(), this.a, j2)) {
            return;
        }
        com.vivo.push.restructure.a.a().e().e();
        this.f8437b.f8704d = "";
    }
}
