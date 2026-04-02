package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;
import java.util.ArrayList;

/* JADX INFO: compiled from: SyncProfileInfoImpl.java */
/* JADX INFO: loaded from: classes2.dex */
final class h implements Runnable {
    final /* synthetic */ IPushRequestCallback a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ d f8492b;

    h(d dVar, IPushRequestCallback iPushRequestCallback) {
        this.f8492b = dVar;
        this.a = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.b("query all profileIds");
        if (com.vivo.push.restructure.a.a().g().b() != 0) {
            u.b("core not support sync profileInfo");
            IPushRequestCallback iPushRequestCallback = this.a;
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8102);
                return;
            }
        }
        Context contextB = com.vivo.push.restructure.a.a().b();
        com.vivo.push.restructure.request.d.a().a(new com.vivo.push.restructure.request.b(new com.vivo.push.d.a.a(new com.vivo.push.d.a.b(contextB.getPackageName(), new ArrayList(), 4)), new i(this), (byte) 0));
    }
}
