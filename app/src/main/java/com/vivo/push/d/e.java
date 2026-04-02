package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* JADX INFO: compiled from: SyncProfileInfoImpl.java */
/* JADX INFO: loaded from: classes2.dex */
final class e implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f8487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f8488c;

    e(d dVar, String str, IPushRequestCallback iPushRequestCallback) {
        this.f8488c = dVar;
        this.a = str;
        this.f8487b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.b("add profileId");
        d.a(this.f8488c, this.a, this.f8487b, 1);
    }
}
