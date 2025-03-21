package com.vivo.push.p237f;

import android.content.Context;
import com.vivo.push.AbstractC4016v;
import com.vivo.push.util.C3984aa;

/* compiled from: OnNotificationClickTask.java */
/* renamed from: com.vivo.push.f.x */
/* loaded from: classes2.dex */
final class C3914x extends AbstractC3882aa {
    C3914x(AbstractC4016v abstractC4016v) {
        super(abstractC4016v);
    }

    @Override // com.vivo.push.AbstractRunnableC3971s
    /* renamed from: a */
    protected final void mo12952a(AbstractC4016v abstractC4016v) {
        Context context = this.f14186a;
        if (C3984aa.m13187c(context, context.getPackageName())) {
            C3895e c3895e = new C3895e(abstractC4016v);
            c3895e.m12955a(((AbstractC3882aa) this).f14009b);
            c3895e.mo12952a(abstractC4016v);
        } else {
            C3894d c3894d = new C3894d(abstractC4016v);
            c3894d.m12955a(((AbstractC3882aa) this).f14009b);
            c3894d.mo12952a(abstractC4016v);
        }
    }
}
