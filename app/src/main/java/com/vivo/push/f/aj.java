package com.vivo.push.f;

/* compiled from: UnbindAppSendCommandTask.java */
/* loaded from: classes2.dex */
final class aj extends com.vivo.push.s {
    aj(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.c cVar = (com.vivo.push.b.c) vVar;
        com.vivo.push.model.b a2 = com.vivo.push.util.aa.a(this.f12207a, com.vivo.push.restructure.a.a().f());
        if (a2 == null) {
            com.vivo.push.m.a().a(cVar.f(), 1005, new Object[0]);
            return;
        }
        String a3 = a2.a();
        if (a2.c()) {
            com.vivo.push.m.a().a(cVar.f(), 1004, new Object[0]);
            vVar = new com.vivo.push.b.e();
        } else {
            int a4 = com.vivo.push.util.y.a(cVar);
            if (a4 != 0) {
                com.vivo.push.m.a().a(cVar.f(), a4, new Object[0]);
                return;
            }
        }
        com.vivo.push.a.a.a(this.f12207a, a3, vVar);
    }
}
