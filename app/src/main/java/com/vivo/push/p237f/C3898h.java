package com.vivo.push.p237f;

import com.vivo.push.AbstractC4016v;
import com.vivo.push.C3924m;
import com.vivo.push.C3975t;
import com.vivo.push.p232b.C3837i;
import com.vivo.push.util.C4010u;

/* compiled from: OnBindAppReceiveTask.java */
/* renamed from: com.vivo.push.f.h */
/* loaded from: classes2.dex */
final class C3898h extends AbstractC3882aa {
    C3898h(AbstractC4016v abstractC4016v) {
        super(abstractC4016v);
    }

    @Override // com.vivo.push.AbstractRunnableC3971s
    /* renamed from: a */
    protected final void mo12952a(AbstractC4016v abstractC4016v) {
        C3837i c3837i = (C3837i) abstractC4016v;
        String m12847e = c3837i.m12847e();
        C4010u.m13309d("OnBindTask", "doTask,订阅APP结果 = " + c3837i.m12877i() + " clientToken= " + m12847e);
        C3924m.m13016a().m13035a(c3837i.m12876h(), c3837i.m12877i(), m12847e);
        C3975t.m13170b(new RunnableC3899i(this, m12847e, c3837i));
    }
}
