package anet.channel.status;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ NetworkStatusMonitor$2 a;

    d(NetworkStatusMonitor$2 networkStatusMonitor$2) {
        this.a = networkStatusMonitor$2;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.d();
    }
}
