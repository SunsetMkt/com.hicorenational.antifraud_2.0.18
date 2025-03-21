package com.vivo.push.p237f;

import com.vivo.push.AbstractC4016v;
import com.vivo.push.C3924m;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.p232b.C3836h;
import com.vivo.push.p232b.C3843o;
import com.vivo.push.util.C3990ag;
import com.vivo.push.util.C4010u;

/* compiled from: OnMessageReceiveTask.java */
/* renamed from: com.vivo.push.f.t */
/* loaded from: classes2.dex */
final class C3910t extends AbstractC3882aa {
    C3910t(AbstractC4016v abstractC4016v) {
        super(abstractC4016v);
    }

    @Override // com.vivo.push.AbstractRunnableC3971s
    /* renamed from: a */
    protected final void mo12952a(AbstractC4016v abstractC4016v) {
        C3843o c3843o = (C3843o) abstractC4016v;
        C3924m.m13016a().m13032a(new C3836h(String.valueOf(c3843o.m12882f())));
        if (!ClientConfigManagerImpl.getInstance(this.f14186a).isEnablePush()) {
            C4010u.m13309d("OnMessageTask", "command  " + abstractC4016v + " is ignore by disable push ");
            super.m12954a(1020);
            return;
        }
        if (C3924m.m13016a().m13048g() && !m12956a(C3990ag.m13221c(this.f14186a), c3843o.m12859d(), c3843o.m12883g())) {
            super.m12954a(1021);
            return;
        }
        UnvarnishedMessage m12860e = c3843o.m12860e();
        if (m12860e == null) {
            super.m12954a(2807);
            C4010u.m13292a("OnMessageTask", " message is null");
            return;
        }
        C4010u.m13309d("OnMessageTask", "tragetType is " + m12860e.getTargetType() + " ; messageId is " + m12860e.getMsgId());
        ((AbstractC3882aa) this).f14009b.onTransmissionMessage(this.f14186a, m12860e);
        super.m12954a(0);
    }
}
