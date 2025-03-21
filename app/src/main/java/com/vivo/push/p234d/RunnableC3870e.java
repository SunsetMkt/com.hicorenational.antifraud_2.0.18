package com.vivo.push.p234d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.C4010u;

/* compiled from: SyncProfileInfoImpl.java */
/* renamed from: com.vivo.push.d.e */
/* loaded from: classes2.dex */
final class RunnableC3870e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f13981a;

    /* renamed from: b */
    final /* synthetic */ IPushRequestCallback f13982b;

    /* renamed from: c */
    final /* synthetic */ C3869d f13983c;

    RunnableC3870e(C3869d c3869d, String str, IPushRequestCallback iPushRequestCallback) {
        this.f13983c = c3869d;
        this.f13981a = str;
        this.f13982b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4010u.m13304b("add profileId");
        C3869d.m12937a(this.f13983c, this.f13981a, this.f13982b, 1);
    }
}
