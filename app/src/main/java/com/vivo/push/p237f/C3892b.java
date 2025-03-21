package com.vivo.push.p237f;

import com.vivo.push.AbstractC4016v;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.model.C3926b;
import com.vivo.push.p231a.C3825a;
import com.vivo.push.p232b.C3832d;
import com.vivo.push.p232b.C3834f;
import com.vivo.push.p232b.C3853y;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.util.C3984aa;

/* compiled from: ChangeNetPermissionTask.java */
/* renamed from: com.vivo.push.f.b */
/* loaded from: classes2.dex */
final class C3892b extends AbstractRunnableC3971s {
    C3892b(AbstractC4016v abstractC4016v) {
        super(abstractC4016v);
    }

    @Override // com.vivo.push.AbstractRunnableC3971s
    /* renamed from: a */
    protected final void mo12952a(AbstractC4016v abstractC4016v) {
        C3926b m13179a = C3984aa.m13179a(this.f14186a, C3932a.m13069a().m13075f());
        try {
            if (((C3832d) abstractC4016v).m12844d() ? C3900j.m12970a(this.f14186a) : C3900j.m12971b(this.f14186a)) {
                C3926b m13179a2 = C3984aa.m13179a(this.f14186a, C3932a.m13069a().m13075f());
                if (m13179a == null || m13179a2 == null || m13179a2.m13060a() == null || !m13179a2.m13060a().equals(m13179a.m13060a())) {
                    if (m13179a != null && m13179a.m13060a() != null) {
                        C3825a.m12828a(this.f14186a, m13179a.m13060a(), new C3853y(m13179a.m13060a()));
                    }
                    if (m13179a2 == null || m13179a2.m13060a() == null) {
                        return;
                    }
                    C3834f c3834f = new C3834f();
                    C3932a.m13069a();
                    c3834f.m12845d();
                    C3825a.m12828a(this.f14186a, m13179a2.m13060a(), c3834f);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
