package com.vivo.push.p234d;

import com.vivo.push.p234d.p235a.C3865b;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.restructure.request.InterfaceC3967c;
import com.vivo.push.util.C4010u;

/* compiled from: SyncProfileInfoImpl.java */
/* renamed from: com.vivo.push.d.j */
/* loaded from: classes2.dex */
final class C3875j implements InterfaceC3967c<C3865b> {

    /* renamed from: a */
    final /* synthetic */ IPushRequestCallback f13992a;

    /* renamed from: b */
    final /* synthetic */ int f13993b;

    /* renamed from: c */
    final /* synthetic */ C3869d f13994c;

    C3875j(C3869d c3869d, IPushRequestCallback iPushRequestCallback, int i2) {
        this.f13994c = c3869d;
        this.f13992a = iPushRequestCallback;
        this.f13993b = i2;
    }

    @Override // com.vivo.push.restructure.request.InterfaceC3967c
    /* renamed from: a */
    public final void mo12938a(int i2) {
        if (this.f13992a != null) {
            C4010u.m13304b(this.f13993b + " sync err : " + i2);
            this.f13992a.onError(i2);
        }
    }

    @Override // com.vivo.push.restructure.request.InterfaceC3967c
    /* renamed from: a */
    public final /* synthetic */ void mo12939a(C3865b c3865b) {
        if (this.f13992a != null) {
            C4010u.m13304b(this.f13993b + " sync success");
            this.f13992a.onSuccess(0);
        }
    }
}
