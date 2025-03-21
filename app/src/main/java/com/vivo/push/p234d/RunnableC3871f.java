package com.vivo.push.p234d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.C4010u;

/* compiled from: SyncProfileInfoImpl.java */
/* renamed from: com.vivo.push.d.f */
/* loaded from: classes2.dex */
final class RunnableC3871f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f13984a;

    /* renamed from: b */
    final /* synthetic */ IPushRequestCallback f13985b;

    /* renamed from: c */
    final /* synthetic */ C3869d f13986c;

    RunnableC3871f(C3869d c3869d, String str, IPushRequestCallback iPushRequestCallback) {
        this.f13986c = c3869d;
        this.f13984a = str;
        this.f13985b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4010u.m13304b("delete profileId");
        C3869d.m12937a(this.f13986c, this.f13984a, this.f13985b, 2);
    }
}
