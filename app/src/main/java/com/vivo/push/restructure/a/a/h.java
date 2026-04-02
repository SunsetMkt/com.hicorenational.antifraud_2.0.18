package com.vivo.push.restructure.a.a;

import android.content.Context;
import com.vivo.push.util.u;

/* JADX INFO: compiled from: InitNode.java */
/* JADX INFO: loaded from: classes2.dex */
final class h extends a<com.vivo.push.restructure.a.a> {
    public h(com.vivo.push.restructure.a.a aVar, i iVar) {
        super("InitNode", aVar, iVar);
    }

    @Override // com.vivo.push.restructure.a.a.a
    protected final /* synthetic */ int a(com.vivo.push.restructure.a.a aVar) {
        Context contextB = com.vivo.push.restructure.a.a().b();
        com.vivo.push.m.a().a(contextB);
        u.d("InitNode", "PushMessageReceiver " + contextB.getPackageName() + " ; requestId = " + aVar.c());
        return 0;
    }
}
