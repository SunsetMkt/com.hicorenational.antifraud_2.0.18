package com.taobao.accs.net;

import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.n */
/* loaded from: classes2.dex */
class RunnableC3014n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ TaoBaseService.ConnectInfo f9573a;

    /* renamed from: b */
    final /* synthetic */ AccsConnectStateListener f9574b;

    /* renamed from: c */
    final /* synthetic */ C3013m f9575c;

    RunnableC3014n(C3013m c3013m, TaoBaseService.ConnectInfo connectInfo, AccsConnectStateListener accsConnectStateListener) {
        this.f9575c = c3013m;
        this.f9573a = connectInfo;
        this.f9574b = accsConnectStateListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoBaseService.ConnectInfo connectInfo = this.f9573a;
        if (connectInfo.connected) {
            this.f9574b.onConnected(connectInfo);
        } else {
            this.f9574b.onDisconnected(connectInfo);
        }
    }
}
