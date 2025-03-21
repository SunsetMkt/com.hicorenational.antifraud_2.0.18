package com.vivo.push.p234d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.C4010u;

/* compiled from: SyncProfileInfoImpl.java */
/* renamed from: com.vivo.push.d.g */
/* loaded from: classes2.dex */
final class RunnableC3872g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IPushRequestCallback f13987a;

    /* renamed from: b */
    final /* synthetic */ C3869d f13988b;

    RunnableC3872g(C3869d c3869d, IPushRequestCallback iPushRequestCallback) {
        this.f13988b = c3869d;
        this.f13987a = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4010u.m13304b("delete all profileIds");
        C3869d.m12937a(this.f13988b, "", this.f13987a, 3);
    }
}
