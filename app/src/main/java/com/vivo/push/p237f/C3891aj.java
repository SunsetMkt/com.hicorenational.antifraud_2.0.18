package com.vivo.push.p237f;

import com.vivo.push.AbstractC4016v;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.C3924m;
import com.vivo.push.model.C3926b;
import com.vivo.push.p231a.C3825a;
import com.vivo.push.p232b.C3831c;
import com.vivo.push.p232b.C3833e;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.util.C3984aa;
import com.vivo.push.util.C4014y;

/* compiled from: UnbindAppSendCommandTask.java */
/* renamed from: com.vivo.push.f.aj */
/* loaded from: classes2.dex */
final class C3891aj extends AbstractRunnableC3971s {
    C3891aj(AbstractC4016v abstractC4016v) {
        super(abstractC4016v);
    }

    @Override // com.vivo.push.AbstractRunnableC3971s
    /* renamed from: a */
    protected final void mo12952a(AbstractC4016v abstractC4016v) {
        C3831c c3831c = (C3831c) abstractC4016v;
        C3926b m13179a = C3984aa.m13179a(this.f14186a, C3932a.m13069a().m13075f());
        if (m13179a == null) {
            C3924m.m13016a().m13035a(c3831c.m12843f(), 1005, new Object[0]);
            return;
        }
        String m13060a = m13179a.m13060a();
        if (m13179a.m13067c()) {
            C3924m.m13016a().m13035a(c3831c.m12843f(), 1004, new Object[0]);
            abstractC4016v = new C3833e();
        } else {
            int m13316a = C4014y.m13316a(c3831c);
            if (m13316a != 0) {
                C3924m.m13016a().m13035a(c3831c.m12843f(), m13316a, new Object[0]);
                return;
            }
        }
        C3825a.m12828a(this.f14186a, m13060a, abstractC4016v);
    }
}
