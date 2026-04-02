package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* JADX INFO: compiled from: VUpsManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class c implements IPushActionListener {
    final /* synthetic */ UPSTurnCallback a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ VUpsManager f8641b;

    c(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f8641b = vUpsManager;
        this.a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.a.onResult(new CodeResult(i2));
    }
}
