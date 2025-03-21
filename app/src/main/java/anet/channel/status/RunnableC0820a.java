package anet.channel.status;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import java.util.Iterator;

/* compiled from: Taobao */
/* renamed from: anet.channel.status.a */
/* loaded from: classes.dex */
final class RunnableC0820a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ NetworkStatusHelper.NetworkStatus f1010a;

    RunnableC0820a(NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f1010a = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Iterator<NetworkStatusHelper.INetworkStatusChangeListener> it = NetworkStatusHelper.listeners.iterator();
            while (it.hasNext()) {
                NetworkStatusHelper.INetworkStatusChangeListener next = it.next();
                long currentTimeMillis = System.currentTimeMillis();
                next.onNetworkStatusChanged(this.f1010a);
                if (System.currentTimeMillis() - currentTimeMillis > 500) {
                    ALog.m715e("awcn.NetworkStatusHelper", "call back cost too much time", null, "listener", next);
                }
            }
        } catch (Exception unused) {
        }
    }
}
