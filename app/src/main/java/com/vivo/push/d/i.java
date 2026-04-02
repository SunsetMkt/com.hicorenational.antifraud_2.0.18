package com.vivo.push.d;

import com.vivo.push.util.u;

/* JADX INFO: compiled from: SyncProfileInfoImpl.java */
/* JADX INFO: loaded from: classes2.dex */
final class i implements com.vivo.push.restructure.request.c<com.vivo.push.d.a.b> {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.restructure.request.a.a.b bVar) {
        com.vivo.push.d.a.b bVar2 = (com.vivo.push.d.a.b) bVar;
        if (this.a.a != null) {
            u.b("query success");
            this.a.a.onSuccess(bVar2.a());
        }
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i2) {
        if (this.a.a != null) {
            u.b("query err : ".concat(String.valueOf(i2)));
            this.a.a.onError(i2);
        }
    }
}
