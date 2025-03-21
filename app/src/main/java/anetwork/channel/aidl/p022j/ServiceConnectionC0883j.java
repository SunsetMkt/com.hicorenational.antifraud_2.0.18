package anetwork.channel.aidl.p022j;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import anet.channel.util.ALog;
import anetwork.channel.aidl.InterfaceC0866b;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.j.j */
/* loaded from: classes.dex */
final class ServiceConnectionC0883j implements ServiceConnection {
    ServiceConnectionC0883j() {
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (ALog.isPrintLog(2)) {
            ALog.m716i("anet.RemoteGetter", "[onServiceConnected]ANet_Service start success. ANet run with service mode", null, new Object[0]);
        }
        synchronized (C0882i.class) {
            C0882i.f1314a = InterfaceC0866b.a.m766a(iBinder);
            if (C0882i.f1317d != null) {
                C0882i.f1317d.countDown();
            }
        }
        C0882i.f1315b = false;
        C0882i.f1316c = false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (ALog.isPrintLog(2)) {
            ALog.m716i("anet.RemoteGetter", "ANet_Service Disconnected", null, new Object[0]);
        }
        C0882i.f1314a = null;
        C0882i.f1316c = false;
        if (C0882i.f1317d != null) {
            C0882i.f1317d.countDown();
        }
    }
}
