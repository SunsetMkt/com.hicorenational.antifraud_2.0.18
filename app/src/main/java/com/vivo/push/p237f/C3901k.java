package com.vivo.push.p237f;

import com.vivo.push.AbstractC4016v;
import com.vivo.push.util.C3989af;
import com.vivo.push.util.C4010u;

/* compiled from: OnClearCacheReceiveTask.java */
/* renamed from: com.vivo.push.f.k */
/* loaded from: classes2.dex */
final class C3901k extends AbstractC3882aa {
    C3901k(AbstractC4016v abstractC4016v) {
        super(abstractC4016v);
    }

    @Override // com.vivo.push.AbstractRunnableC3971s
    /* renamed from: a */
    protected final void mo12952a(AbstractC4016v abstractC4016v) {
        C4010u.m13309d("OnClearCacheTask", "delete push info " + this.f14186a.getPackageName());
        C3989af.m13204b(this.f14186a).m13205a();
    }
}
