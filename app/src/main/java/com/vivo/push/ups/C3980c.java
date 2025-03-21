package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: VUpsManager.java */
/* renamed from: com.vivo.push.ups.c */
/* loaded from: classes2.dex */
final class C3980c implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSTurnCallback f14206a;

    /* renamed from: b */
    final /* synthetic */ VUpsManager f14207b;

    C3980c(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f14207b = vUpsManager;
        this.f14206a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.f14206a.onResult(new CodeResult(i2));
    }
}
