package anet.channel.detect;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ NetworkStatusHelper.NetworkStatus a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ l f1421b;

    m(l lVar, NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f1421b = lVar;
        this.a = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.a != NetworkStatusHelper.NetworkStatus.NO && this.a != NetworkStatusHelper.NetworkStatus.NONE) {
                this.f1421b.a.a(NetworkStatusHelper.getUniqueId(this.a));
            }
        } catch (Throwable th) {
            ALog.e("anet.MTUDetector", "MTU detecet fail.", null, th, new Object[0]);
        }
    }
}
