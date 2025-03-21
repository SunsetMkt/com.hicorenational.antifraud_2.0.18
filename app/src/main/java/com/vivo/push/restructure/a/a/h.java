package com.vivo.push.restructure.a.a;

import android.content.Context;
import com.vivo.push.util.u;

/* compiled from: InitNode.java */
/* loaded from: classes2.dex */
final class h extends a<com.vivo.push.restructure.a.a> {
    public h(com.vivo.push.restructure.a.a aVar, i iVar) {
        super("InitNode", aVar, iVar);
    }

    @Override // com.vivo.push.restructure.a.a.a
    protected final /* synthetic */ int a(com.vivo.push.restructure.a.a aVar) {
        Context b2 = com.vivo.push.restructure.a.a().b();
        com.vivo.push.m.a().a(b2);
        u.d("InitNode", "PushMessageReceiver " + b2.getPackageName() + " ; requestId = " + aVar.c());
        return 0;
    }
}
