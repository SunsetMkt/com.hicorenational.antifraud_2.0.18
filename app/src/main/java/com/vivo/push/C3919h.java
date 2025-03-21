package com.vivo.push;

import com.vivo.push.restructure.request.p243a.p244a.C3960a;
import com.vivo.push.restructure.request.p243a.p244a.InterfaceC3962c;
import com.vivo.push.util.C4010u;

/* compiled from: ClientSdkQueryResultDS.java */
/* renamed from: com.vivo.push.h */
/* loaded from: classes2.dex */
final class C3919h implements InterfaceC3962c.a<C3917g> {
    C3919h() {
    }

    /* renamed from: b */
    private static C3917g m12994b(String str) {
        try {
            return new C3917g(new C3960a(str));
        } catch (Exception e2) {
            C4010u.m13296a(8101, e2.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.request.p243a.p244a.InterfaceC3962c.a
    /* renamed from: a */
    public final /* synthetic */ C3917g mo12936a(String str) {
        return m12994b(str);
    }
}
