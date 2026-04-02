package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* JADX INFO: compiled from: SyncProfileInfoImpl.java */
/* JADX INFO: loaded from: classes2.dex */
final class g implements Runnable {
    final /* synthetic */ IPushRequestCallback a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f8491b;

    g(d dVar, IPushRequestCallback iPushRequestCallback) {
        this.f8491b = dVar;
        this.a = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.b("delete all profileIds");
        d.a(this.f8491b, "", this.a, 3);
    }
}
