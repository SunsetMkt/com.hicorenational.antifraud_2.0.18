package anet.channel.status;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import anet.channel.util.ALog;
import java.util.ArrayList;

/* compiled from: Taobao */
/* renamed from: anet.channel.status.c */
/* loaded from: classes.dex */
final class C0822c extends ConnectivityManager.NetworkCallback {
    C0822c() {
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network2) {
        super.onAvailable(network2);
        ALog.m716i("awcn.NetworkStatusMonitor", "network onAvailable", null, new Object[0]);
        C0821b.f1012b = true;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLinkPropertiesChanged(Network network2, LinkProperties linkProperties) {
        super.onLinkPropertiesChanged(network2, linkProperties);
        C0821b.f1022l = new ArrayList(linkProperties.getDnsServers());
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network2) {
        super.onLost(network2);
        ALog.m716i("awcn.NetworkStatusMonitor", "network onLost", null, new Object[0]);
        C0821b.f1012b = false;
    }
}
