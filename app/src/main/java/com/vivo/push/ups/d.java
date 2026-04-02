package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* JADX INFO: compiled from: VUpsManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class d implements IPushActionListener {
    final /* synthetic */ UPSTurnCallback a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f8642b;

    d(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f8642b = vUpsManager;
        this.a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.a.onResult(new CodeResult(i2));
    }
}
