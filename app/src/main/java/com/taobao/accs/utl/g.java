package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class g implements Runnable {
    final /* synthetic */ AccsDataListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f5922b;

    g(AccsDataListener accsDataListener, boolean z) {
        this.a = accsDataListener;
        this.f5922b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.onAntiBrush(this.f5922b, null);
    }
}
