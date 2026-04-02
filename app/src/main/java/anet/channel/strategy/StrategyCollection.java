package anet.channel.strategy;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.PolicyVersionStat;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class StrategyCollection implements Serializable {
    String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile long f1560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile String f1561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f1562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1563e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private StrategyList f1564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient long f1565g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient boolean f1566h;

    public StrategyCollection() {
        this.f1564f = null;
        this.f1560b = 0L;
        this.f1561c = null;
        this.f1562d = false;
        this.f1563e = 0;
        this.f1565g = 0L;
        this.f1566h = true;
    }

    public synchronized void checkInit() {
        if (System.currentTimeMillis() - this.f1560b > 172800000) {
            this.f1564f = null;
        } else {
            if (this.f1564f != null) {
                this.f1564f.checkInit();
            }
        }
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.f1560b;
    }

    public synchronized void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (this.f1564f != null) {
            this.f1564f.notifyConnEvent(iConnStrategy, connEvent);
            if (!connEvent.isSuccess && this.f1564f.shouldRefresh()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f1565g > com.heytap.mcssdk.constant.a.f3868d) {
                    StrategyCenter.getInstance().forceRefreshStrategy(this.a);
                    this.f1565g = jCurrentTimeMillis;
                }
            }
        }
    }

    public synchronized List<IConnStrategy> queryStrategyList() {
        if (this.f1564f == null) {
            return Collections.EMPTY_LIST;
        }
        if (this.f1566h) {
            this.f1566h = false;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.a, this.f1563e);
            policyVersionStat.reportType = 0;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        return this.f1564f.getStrategyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("\nStrategyList = ");
        sb.append(this.f1560b);
        StrategyList strategyList = this.f1564f;
        if (strategyList != null) {
            sb.append(strategyList.toString());
        } else if (this.f1561c != null) {
            sb.append('[');
            sb.append(this.a);
            sb.append("=>");
            sb.append(this.f1561c);
            sb.append(']');
        } else {
            sb.append("[]");
        }
        return sb.toString();
    }

    public synchronized void update(l.b bVar) {
        this.f1560b = System.currentTimeMillis() + (((long) bVar.f1613b) * 1000);
        if (!bVar.a.equalsIgnoreCase(this.a)) {
            ALog.e("StrategyCollection", "update error!", null, Constants.KEY_HOST, this.a, "dnsInfo.host", bVar.a);
            return;
        }
        if (this.f1563e != bVar.f1623l) {
            this.f1563e = bVar.f1623l;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.a, this.f1563e);
            policyVersionStat.reportType = 1;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        this.f1561c = bVar.f1615d;
        if ((bVar.f1617f != null && bVar.f1617f.length != 0 && bVar.f1619h != null && bVar.f1619h.length != 0) || (bVar.f1620i != null && bVar.f1620i.length != 0)) {
            if (this.f1564f == null) {
                this.f1564f = new StrategyList();
            }
            this.f1564f.update(bVar);
            return;
        }
        this.f1564f = null;
    }

    protected StrategyCollection(String str) {
        this.f1564f = null;
        this.f1560b = 0L;
        this.f1561c = null;
        this.f1562d = false;
        this.f1563e = 0;
        this.f1565g = 0L;
        this.f1566h = true;
        this.a = str;
        this.f1562d = DispatchConstants.isAmdcServerDomain(str);
    }
}
