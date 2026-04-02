package anetwork.channel.aidl.j;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import anet.channel.util.ALog;
import anetwork.channel.aidl.b;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class j implements ServiceConnection {
    j() {
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.RemoteGetter", "[onServiceConnected]ANet_Service start success. ANet run with service mode", null, new Object[0]);
        }
        synchronized (i.class) {
            i.a = b.a.a(iBinder);
            if (i.f1755d != null) {
                i.f1755d.countDown();
            }
        }
        i.f1753b = false;
        i.f1754c = false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.RemoteGetter", "ANet_Service Disconnected", null, new Object[0]);
        }
        i.a = null;
        i.f1754c = false;
        if (i.f1755d != null) {
            i.f1755d.countDown();
        }
    }
}
