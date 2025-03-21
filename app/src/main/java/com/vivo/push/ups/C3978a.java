package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;
import com.vivo.push.restructure.C3932a;

/* compiled from: VUpsManager.java */
/* renamed from: com.vivo.push.ups.a */
/* loaded from: classes2.dex */
final class C3978a implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSRegisterCallback f14202a;

    /* renamed from: b */
    final /* synthetic */ VUpsManager f14203b;

    C3978a(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.f14203b = vUpsManager;
        this.f14202a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.f14202a.onResult(new TokenResult(i2, C3932a.m13069a().m13077h().mo13011b()));
    }
}
