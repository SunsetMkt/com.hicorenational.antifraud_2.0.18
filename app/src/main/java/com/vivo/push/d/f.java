package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* JADX INFO: compiled from: SyncProfileInfoImpl.java */
/* JADX INFO: loaded from: classes2.dex */
final class f implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f8489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f8490c;

    f(d dVar, String str, IPushRequestCallback iPushRequestCallback) {
        this.f8490c = dVar;
        this.a = str;
        this.f8489b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.b("delete profileId");
        d.a(this.f8490c, this.a, this.f8489b, 2);
    }
}
