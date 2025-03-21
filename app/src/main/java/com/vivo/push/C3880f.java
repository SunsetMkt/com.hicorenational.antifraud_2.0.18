package com.vivo.push;

import com.vivo.push.restructure.request.p243a.p244a.C3960a;
import com.vivo.push.restructure.request.p243a.p244a.InterfaceC3962c;
import com.vivo.push.util.C4010u;

/* compiled from: ClientSdkQueryParemeterDS.java */
/* renamed from: com.vivo.push.f */
/* loaded from: classes2.dex */
final class C3880f implements InterfaceC3962c.a<C3876e> {
    C3880f() {
    }

    /* renamed from: b */
    private static C3876e m12951b(String str) {
        try {
            return new C3876e(new C3960a(str));
        } catch (Exception e2) {
            C4010u.m13296a(8101, e2.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.request.p243a.p244a.InterfaceC3962c.a
    /* renamed from: a */
    public final /* synthetic */ C3876e mo12936a(String str) {
        return m12951b(str);
    }
}
