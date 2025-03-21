package com.vivo.push.f;

import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.UnvarnishedMessage;

/* compiled from: OnMessageReceiveTask.java */
/* loaded from: classes2.dex */
final class t extends aa {
    t(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.o oVar = (com.vivo.push.b.o) vVar;
        com.vivo.push.m.a().a(new com.vivo.push.b.h(String.valueOf(oVar.f())));
        if (!ClientConfigManagerImpl.getInstance(this.f12207a).isEnablePush()) {
            com.vivo.push.util.u.d("OnMessageTask", "command  " + vVar + " is ignore by disable push ");
            super.a(1020);
            return;
        }
        if (com.vivo.push.m.a().g() && !a(com.vivo.push.util.ag.c(this.f12207a), oVar.d(), oVar.g())) {
            super.a(1021);
            return;
        }
        UnvarnishedMessage e2 = oVar.e();
        if (e2 == null) {
            super.a(2807);
            com.vivo.push.util.u.a("OnMessageTask", " message is null");
            return;
        }
        com.vivo.push.util.u.d("OnMessageTask", "tragetType is " + e2.getTargetType() + " ; messageId is " + e2.getMsgId());
        ((aa) this).f12034b.onTransmissionMessage(this.f12207a, e2);
        super.a(0);
    }
}
