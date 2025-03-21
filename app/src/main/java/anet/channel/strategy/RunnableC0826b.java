package anet.channel.strategy;

import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.net.InetAddress;
import java.util.Collections;
import java.util.LinkedList;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.b */
/* loaded from: classes.dex */
class RunnableC0826b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f1071a;

    /* renamed from: b */
    final /* synthetic */ Object f1072b;

    /* renamed from: c */
    final /* synthetic */ C0825a f1073c;

    RunnableC0826b(C0825a c0825a, String str, Object obj) {
        this.f1073c = c0825a;
        this.f1071a = str;
        this.f1072b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                String hostAddress = InetAddress.getByName(this.f1071a).getHostAddress();
                LinkedList linkedList = new LinkedList();
                ConnProtocol connProtocol = StrategyTemplate.getInstance().getConnProtocol(this.f1071a);
                if (connProtocol != null) {
                    linkedList.add(IPConnStrategy.m631a(hostAddress, !this.f1073c.m666a(connProtocol) ? 80 : Constants.PORT, connProtocol, 0, 0, 1, 45000));
                }
                linkedList.add(IPConnStrategy.m631a(hostAddress, 80, ConnProtocol.HTTP, 0, 0, 0, 0));
                linkedList.add(IPConnStrategy.m631a(hostAddress, Constants.PORT, ConnProtocol.HTTPS, 0, 0, 0, 0));
                this.f1073c.f1069a.put(this.f1071a, linkedList);
                if (ALog.isPrintLog(1)) {
                    ALog.m713d("awcn.LocalDnsStrategyTable", "resolve ip by local dns", null, Constants.KEY_HOST, this.f1071a, "ip", hostAddress, "list", linkedList);
                }
                synchronized (this.f1073c.f1070b) {
                    this.f1073c.f1070b.remove(this.f1071a);
                }
                synchronized (this.f1072b) {
                    this.f1072b.notifyAll();
                }
            } catch (Exception unused) {
                if (ALog.isPrintLog(1)) {
                    ALog.m713d("awcn.LocalDnsStrategyTable", "resolve ip by local dns failed", null, Constants.KEY_HOST, this.f1071a);
                }
                this.f1073c.f1069a.put(this.f1071a, Collections.EMPTY_LIST);
                synchronized (this.f1073c.f1070b) {
                    this.f1073c.f1070b.remove(this.f1071a);
                    synchronized (this.f1072b) {
                        this.f1072b.notifyAll();
                    }
                }
            }
        } catch (Throwable th) {
            synchronized (this.f1073c.f1070b) {
                this.f1073c.f1070b.remove(this.f1071a);
                synchronized (this.f1072b) {
                    this.f1072b.notifyAll();
                    throw th;
                }
            }
        }
    }
}
