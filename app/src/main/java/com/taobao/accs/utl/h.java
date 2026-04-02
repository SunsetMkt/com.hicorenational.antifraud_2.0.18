package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class h implements Runnable {
    final /* synthetic */ AccsDataListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f5923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f5924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f5925d;

    h(AccsDataListener accsDataListener, String str, boolean z, boolean z2) {
        this.a = accsDataListener;
        this.f5923b = str;
        this.f5924c = z;
        this.f5925d = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.onConnected(new TaoBaseService.ConnectInfo(this.f5923b, this.f5924c, this.f5925d));
    }
}
