package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* JADX INFO: compiled from: VUpsManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class a implements IPushActionListener {
    final /* synthetic */ UPSRegisterCallback a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ VUpsManager f8639b;

    a(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.f8639b = vUpsManager;
        this.a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.a.onResult(new TokenResult(i2, com.vivo.push.restructure.a.a().h().b()));
    }
}
