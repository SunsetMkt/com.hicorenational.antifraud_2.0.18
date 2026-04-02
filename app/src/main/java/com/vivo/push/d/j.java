package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* JADX INFO: compiled from: SyncProfileInfoImpl.java */
/* JADX INFO: loaded from: classes2.dex */
final class j implements com.vivo.push.restructure.request.c<com.vivo.push.d.a.b> {
    final /* synthetic */ IPushRequestCallback a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ int f8493b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ d f8494c;

    j(d dVar, IPushRequestCallback iPushRequestCallback, int i2) {
        this.f8494c = dVar;
        this.a = iPushRequestCallback;
        this.f8493b = i2;
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i2) {
        if (this.a != null) {
            u.b(this.f8493b + " sync err : " + i2);
            this.a.onError(i2);
        }
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.restructure.request.a.a.b bVar) {
        if (this.a != null) {
            u.b(this.f8493b + " sync success");
            this.a.onSuccess(0);
        }
    }
}
