package com.vivo.push;

import com.vivo.push.listener.IPushQueryActionListener;
import com.vivo.push.restructure.C3932a;

/* compiled from: BasePushClient.java */
/* renamed from: com.vivo.push.b */
/* loaded from: classes2.dex */
final class RunnableC3828b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IPushQueryActionListener f13904a;

    /* renamed from: b */
    final /* synthetic */ C3824a f13905b;

    RunnableC3828b(C3824a c3824a, IPushQueryActionListener iPushQueryActionListener) {
        this.f13905b = c3824a;
        this.f13904a = iPushQueryActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String mo13011b = C3932a.m13069a().m13077h().mo13011b();
        IPushQueryActionListener iPushQueryActionListener = this.f13904a;
        if (iPushQueryActionListener != null) {
            iPushQueryActionListener.onSuccess(mo13011b);
        }
    }
}
