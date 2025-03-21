package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: VUpsManager.java */
/* renamed from: com.vivo.push.ups.b */
/* loaded from: classes2.dex */
final class C3979b implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSRegisterCallback f14204a;

    /* renamed from: b */
    final /* synthetic */ VUpsManager f14205b;

    C3979b(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.f14205b = vUpsManager;
        this.f14204a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.f14204a.onResult(new TokenResult(i2, ""));
    }
}
