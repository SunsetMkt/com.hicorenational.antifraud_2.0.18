package com.vivo.push.p234d;

import com.vivo.push.restructure.request.p243a.p244a.C3960a;
import com.vivo.push.restructure.request.p243a.p244a.InterfaceC3962c;
import com.vivo.push.util.C4010u;

/* compiled from: ProfileInfoDS.java */
/* renamed from: com.vivo.push.d.c */
/* loaded from: classes2.dex */
final class C3868c implements InterfaceC3962c.a<C3867b> {
    C3868c() {
    }

    /* renamed from: b */
    private static C3867b m12935b(String str) {
        try {
            return new C3867b(new C3960a(str));
        } catch (Exception e2) {
            C4010u.m13296a(8101, e2.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.request.p243a.p244a.InterfaceC3962c.a
    /* renamed from: a */
    public final /* synthetic */ C3867b mo12936a(String str) {
        return m12935b(str);
    }
}
