package anet.channel.status;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import anet.channel.util.ALog;
import java.util.ArrayList;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class c extends ConnectivityManager.NetworkCallback {
    c() {
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network2) {
        super.onAvailable(network2);
        ALog.i("awcn.NetworkStatusMonitor", "network onAvailable", null, new Object[0]);
        b.f1543b = true;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLinkPropertiesChanged(Network network2, LinkProperties linkProperties) {
        super.onLinkPropertiesChanged(network2, linkProperties);
        b.f1553l = new ArrayList(linkProperties.getDnsServers());
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network2) {
        super.onLost(network2);
        ALog.i("awcn.NetworkStatusMonitor", "network onLost", null, new Object[0]);
        b.f1543b = false;
    }
}
