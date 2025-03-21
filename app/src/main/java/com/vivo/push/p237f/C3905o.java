package com.vivo.push.p237f;

import com.vivo.push.AbstractC4016v;
import com.vivo.push.p232b.C3840l;
import com.vivo.push.util.C3987ad;

/* compiled from: OnDispatcherReceiveTask.java */
/* renamed from: com.vivo.push.f.o */
/* loaded from: classes2.dex */
public final class C3905o extends AbstractC3882aa {
    C3905o(AbstractC4016v abstractC4016v) {
        super(abstractC4016v);
    }

    @Override // com.vivo.push.AbstractRunnableC3971s
    /* renamed from: a */
    protected final void mo12952a(AbstractC4016v abstractC4016v) {
        C3840l c3840l = (C3840l) abstractC4016v;
        int m12850d = c3840l.m12850d();
        int m12851e = c3840l.m12851e();
        C3987ad.m13198b().m13241a("key_dispatch_environment", m12850d);
        C3987ad.m13198b().m13241a("key_dispatch_area", m12851e);
    }
}
