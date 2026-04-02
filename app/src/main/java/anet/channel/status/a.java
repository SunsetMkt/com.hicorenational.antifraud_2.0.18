package anet.channel.status;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class a implements Runnable {
    final /* synthetic */ NetworkStatusHelper.NetworkStatus a;

    a(NetworkStatusHelper.NetworkStatus networkStatus) {
        this.a = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            for (NetworkStatusHelper.INetworkStatusChangeListener iNetworkStatusChangeListener : NetworkStatusHelper.listeners) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                iNetworkStatusChangeListener.onNetworkStatusChanged(this.a);
                if (System.currentTimeMillis() - jCurrentTimeMillis > 500) {
                    ALog.e("awcn.NetworkStatusHelper", "call back cost too much time", null, "listener", iNetworkStatusChangeListener);
                }
            }
        } catch (Exception unused) {
        }
    }
}
