package com.vivo.push.p234d;

import android.content.Context;
import com.vivo.push.p234d.p235a.C3864a;
import com.vivo.push.p234d.p235a.C3865b;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.restructure.request.C3966b;
import com.vivo.push.restructure.request.C3968d;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.C4010u;
import java.util.ArrayList;

/* compiled from: SyncProfileInfoImpl.java */
/* renamed from: com.vivo.push.d.h */
/* loaded from: classes2.dex */
final class RunnableC3873h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IPushRequestCallback f13989a;

    /* renamed from: b */
    final /* synthetic */ C3869d f13990b;

    RunnableC3873h(C3869d c3869d, IPushRequestCallback iPushRequestCallback) {
        this.f13990b = c3869d;
        this.f13989a = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4010u.m13304b("query all profileIds");
        if (C3932a.m13069a().m13076g().m12892b() != 0) {
            C4010u.m13304b("core not support sync profileInfo");
            IPushRequestCallback iPushRequestCallback = this.f13989a;
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8102);
                return;
            }
        }
        Context m13071b = C3932a.m13069a().m13071b();
        C3968d.m13155a().m13159a(new C3966b(new C3864a(new C3865b(m13071b.getPackageName(), new ArrayList(), 4)), new C3874i(this), (byte) 0));
    }
}
