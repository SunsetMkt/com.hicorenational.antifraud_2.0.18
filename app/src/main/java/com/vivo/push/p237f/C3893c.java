package com.vivo.push.p237f;

import com.vivo.push.AbstractC4016v;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.util.C4010u;

/* compiled from: InitTask.java */
/* renamed from: com.vivo.push.f.c */
/* loaded from: classes2.dex */
final class C3893c extends AbstractRunnableC3971s {
    C3893c(AbstractC4016v abstractC4016v) {
        super(abstractC4016v);
    }

    @Override // com.vivo.push.AbstractRunnableC3971s
    /* renamed from: a */
    protected final void mo12952a(AbstractC4016v abstractC4016v) {
        C4010u.m13299a(ClientConfigManagerImpl.getInstance(this.f14186a).isDebug());
    }
}
