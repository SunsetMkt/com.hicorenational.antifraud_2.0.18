package anet.channel.strategy;

import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.net.InetAddress;
import java.util.Collections;
import java.util.LinkedList;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f1584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ a f1585c;

    b(a aVar, String str, Object obj) {
        this.f1585c = aVar;
        this.a = str;
        this.f1584b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                String hostAddress = InetAddress.getByName(this.a).getHostAddress();
                LinkedList linkedList = new LinkedList();
                ConnProtocol connProtocol = StrategyTemplate.getInstance().getConnProtocol(this.a);
                if (connProtocol != null) {
                    linkedList.add(IPConnStrategy.a(hostAddress, !this.f1585c.a(connProtocol) ? 80 : Constants.PORT, connProtocol, 0, 0, 1, 45000));
                }
                linkedList.add(IPConnStrategy.a(hostAddress, 80, ConnProtocol.HTTP, 0, 0, 0, 0));
                linkedList.add(IPConnStrategy.a(hostAddress, Constants.PORT, ConnProtocol.HTTPS, 0, 0, 0, 0));
                this.f1585c.a.put(this.a, linkedList);
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.LocalDnsStrategyTable", "resolve ip by local dns", null, Constants.KEY_HOST, this.a, "ip", hostAddress, "list", linkedList);
                }
                synchronized (this.f1585c.f1583b) {
                    this.f1585c.f1583b.remove(this.a);
                }
                synchronized (this.f1584b) {
                    this.f1584b.notifyAll();
                }
            } catch (Exception unused) {
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.LocalDnsStrategyTable", "resolve ip by local dns failed", null, Constants.KEY_HOST, this.a);
                }
                this.f1585c.a.put(this.a, Collections.EMPTY_LIST);
                synchronized (this.f1585c.f1583b) {
                    this.f1585c.f1583b.remove(this.a);
                    synchronized (this.f1584b) {
                        this.f1584b.notifyAll();
                    }
                }
            }
        } catch (Throwable th) {
            synchronized (this.f1585c.f1583b) {
                this.f1585c.f1583b.remove(this.a);
                synchronized (this.f1584b) {
                    this.f1584b.notifyAll();
                    throw th;
                }
            }
        }
    }
}
