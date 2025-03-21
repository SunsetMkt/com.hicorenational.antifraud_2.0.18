package com.vivo.push.p234d;

import com.vivo.push.p234d.p235a.C3865b;
import com.vivo.push.restructure.request.InterfaceC3967c;
import com.vivo.push.util.C4010u;

/* compiled from: SyncProfileInfoImpl.java */
/* renamed from: com.vivo.push.d.i */
/* loaded from: classes2.dex */
final class C3874i implements InterfaceC3967c<C3865b> {

    /* renamed from: a */
    final /* synthetic */ RunnableC3873h f13991a;

    C3874i(RunnableC3873h runnableC3873h) {
        this.f13991a = runnableC3873h;
    }

    @Override // com.vivo.push.restructure.request.InterfaceC3967c
    /* renamed from: a */
    public final /* synthetic */ void mo12939a(C3865b c3865b) {
        C3865b c3865b2 = c3865b;
        if (this.f13991a.f13989a != null) {
            C4010u.m13304b("query success");
            this.f13991a.f13989a.onSuccess(c3865b2.m12929a());
        }
    }

    @Override // com.vivo.push.restructure.request.InterfaceC3967c
    /* renamed from: a */
    public final void mo12938a(int i2) {
        if (this.f13991a.f13989a != null) {
            C4010u.m13304b("query err : ".concat(String.valueOf(i2)));
            this.f13991a.f13989a.onError(i2);
        }
    }
}
