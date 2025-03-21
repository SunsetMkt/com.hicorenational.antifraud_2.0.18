package com.taobao.accs.data;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.data.k */
/* loaded from: classes2.dex */
class ServiceConnectionC2993k implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ MsgDistributeService f9495a;

    ServiceConnectionC2993k(MsgDistributeService msgDistributeService) {
        this.f9495a = msgDistributeService;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
