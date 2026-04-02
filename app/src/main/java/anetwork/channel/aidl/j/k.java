package anetwork.channel.aidl.j;

import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class k implements Runnable {
    k() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (i.f1754c) {
            i.f1754c = false;
            ALog.e("anet.RemoteGetter", "binding service timeout. reset status!", null, new Object[0]);
        }
    }
}
