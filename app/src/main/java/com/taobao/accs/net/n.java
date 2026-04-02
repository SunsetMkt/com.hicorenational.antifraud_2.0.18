package com.taobao.accs.net;

import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class n implements Runnable {
    final /* synthetic */ TaoBaseService.ConnectInfo a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ AccsConnectStateListener f5827b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ m f5828c;

    n(m mVar, TaoBaseService.ConnectInfo connectInfo, AccsConnectStateListener accsConnectStateListener) {
        this.f5828c = mVar;
        this.a = connectInfo;
        this.f5827b = accsConnectStateListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoBaseService.ConnectInfo connectInfo = this.a;
        if (connectInfo.connected) {
            this.f5827b.onConnected(connectInfo);
        } else {
            this.f5827b.onDisconnected(connectInfo);
        }
    }
}
