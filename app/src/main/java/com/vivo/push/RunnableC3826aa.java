package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.util.C3990ag;

/* compiled from: SubscribeImpl.java */
/* renamed from: com.vivo.push.aa */
/* loaded from: classes2.dex */
final class RunnableC3826aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f13898a;

    /* renamed from: b */
    final /* synthetic */ C4020z f13899b;

    RunnableC3826aa(C4020z c4020z, String str) {
        this.f13899b = c4020z;
        this.f13898a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context m13071b = C3932a.m13069a().m13071b();
        if (m13071b == null) {
            return;
        }
        long j2 = C3924m.m13016a().m13047f() ? 488L : 341L;
        if (TextUtils.isEmpty(this.f13898a) || !C3990ag.m13215a(m13071b, m13071b.getPackageName(), this.f13898a, j2)) {
            return;
        }
        C3932a.m13069a().m13074e().mo13122e();
        this.f13899b.f14295d = "";
    }
}
