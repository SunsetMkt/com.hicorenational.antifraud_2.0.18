package com.vivo.push;

import com.vivo.push.restructure.C3932a;

/* compiled from: BasePushClient.java */
/* renamed from: com.vivo.push.c */
/* loaded from: classes2.dex */
final class RunnableC3855c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IPushActionListener f13961a;

    /* renamed from: b */
    final /* synthetic */ C3824a f13962b;

    RunnableC3855c(C3824a c3824a, IPushActionListener iPushActionListener) {
        this.f13962b = c3824a;
        this.f13961a = iPushActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int mo13007a = C3932a.m13069a().m13077h().mo13007a();
        IPushActionListener iPushActionListener = this.f13961a;
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(mo13007a);
        }
    }
}
