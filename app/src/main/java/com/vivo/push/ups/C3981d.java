package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: VUpsManager.java */
/* renamed from: com.vivo.push.ups.d */
/* loaded from: classes2.dex */
final class C3981d implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSTurnCallback f14208a;

    /* renamed from: b */
    final /* synthetic */ VUpsManager f14209b;

    C3981d(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f14209b = vUpsManager;
        this.f14208a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.f14208a.onResult(new CodeResult(i2));
    }
}
