package com.vivo.push;

import com.vivo.push.restructure.C3932a;

/* compiled from: PushClientManager.java */
/* renamed from: com.vivo.push.p */
/* loaded from: classes2.dex */
final class C3929p implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ C3924m f14106a;

    C3929p(C3924m c3924m) {
        this.f14106a = c3924m;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        if (i2 == 0) {
            C3932a.m13069a().m13077h().mo13012b("");
        } else {
            C3932a.m13069a().m13077h().mo13013c("");
        }
    }
}
