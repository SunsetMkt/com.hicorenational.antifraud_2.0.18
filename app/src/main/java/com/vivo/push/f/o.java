package com.vivo.push.f;

/* compiled from: OnDispatcherReceiveTask.java */
/* loaded from: classes2.dex */
public final class o extends aa {
    o(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.l lVar = (com.vivo.push.b.l) vVar;
        int d2 = lVar.d();
        int e2 = lVar.e();
        com.vivo.push.util.ad.b().a("key_dispatch_environment", d2);
        com.vivo.push.util.ad.b().a("key_dispatch_area", e2);
    }
}
