package com.vivo.push.p234d.p235a;

import com.vivo.push.restructure.request.p243a.p244a.C3960a;
import com.vivo.push.restructure.request.p243a.p244a.InterfaceC3961b;
import com.vivo.push.util.C4010u;

/* compiled from: SyncProfileInfoInputDS.java */
/* renamed from: com.vivo.push.d.a.c */
/* loaded from: classes2.dex */
final class C3866c implements InterfaceC3961b.a<C3865b> {
    C3866c() {
    }

    /* renamed from: b */
    private static C3865b m12931b(C3960a c3960a) {
        try {
            return new C3865b(c3960a);
        } catch (Exception e2) {
            C4010u.m13296a(8101, e2.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.request.p243a.p244a.InterfaceC3961b.a
    /* renamed from: a */
    public final /* synthetic */ C3865b mo12932a(C3960a c3960a) {
        return m12931b(c3960a);
    }
}
