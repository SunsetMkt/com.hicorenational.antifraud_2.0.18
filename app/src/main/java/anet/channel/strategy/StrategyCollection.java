package anet.channel.strategy;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.PolicyVersionStat;
import anet.channel.strategy.C0842l;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import com.heytap.mcssdk.constant.C2084a;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class StrategyCollection implements Serializable {

    /* renamed from: a */
    String f1040a;

    /* renamed from: b */
    volatile long f1041b;

    /* renamed from: c */
    volatile String f1042c;

    /* renamed from: d */
    boolean f1043d;

    /* renamed from: e */
    int f1044e;

    /* renamed from: f */
    private StrategyList f1045f;

    /* renamed from: g */
    private transient long f1046g;

    /* renamed from: h */
    private transient boolean f1047h;

    public StrategyCollection() {
        this.f1045f = null;
        this.f1041b = 0L;
        this.f1042c = null;
        this.f1043d = false;
        this.f1044e = 0;
        this.f1046g = 0L;
        this.f1047h = true;
    }

    public synchronized void checkInit() {
        if (System.currentTimeMillis() - this.f1041b > 172800000) {
            this.f1045f = null;
        } else {
            if (this.f1045f != null) {
                this.f1045f.checkInit();
            }
        }
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.f1041b;
    }

    public synchronized void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (this.f1045f != null) {
            this.f1045f.notifyConnEvent(iConnStrategy, connEvent);
            if (!connEvent.isSuccess && this.f1045f.shouldRefresh()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f1046g > C2084a.f6122d) {
                    StrategyCenter.getInstance().forceRefreshStrategy(this.f1040a);
                    this.f1046g = currentTimeMillis;
                }
            }
        }
    }

    public synchronized List<IConnStrategy> queryStrategyList() {
        if (this.f1045f == null) {
            return Collections.EMPTY_LIST;
        }
        if (this.f1047h) {
            this.f1047h = false;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.f1040a, this.f1044e);
            policyVersionStat.reportType = 0;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        return this.f1045f.getStrategyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("\nStrategyList = ");
        sb.append(this.f1041b);
        StrategyList strategyList = this.f1045f;
        if (strategyList != null) {
            sb.append(strategyList.toString());
        } else if (this.f1042c != null) {
            sb.append('[');
            sb.append(this.f1040a);
            sb.append("=>");
            sb.append(this.f1042c);
            sb.append(']');
        } else {
            sb.append("[]");
        }
        return sb.toString();
    }

    public synchronized void update(C0842l.b bVar) {
        this.f1041b = System.currentTimeMillis() + (bVar.f1118b * 1000);
        if (!bVar.f1117a.equalsIgnoreCase(this.f1040a)) {
            ALog.m715e("StrategyCollection", "update error!", null, Constants.KEY_HOST, this.f1040a, "dnsInfo.host", bVar.f1117a);
            return;
        }
        if (this.f1044e != bVar.f1128l) {
            this.f1044e = bVar.f1128l;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.f1040a, this.f1044e);
            policyVersionStat.reportType = 1;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        this.f1042c = bVar.f1120d;
        if ((bVar.f1122f != null && bVar.f1122f.length != 0 && bVar.f1124h != null && bVar.f1124h.length != 0) || (bVar.f1125i != null && bVar.f1125i.length != 0)) {
            if (this.f1045f == null) {
                this.f1045f = new StrategyList();
            }
            this.f1045f.update(bVar);
            return;
        }
        this.f1045f = null;
    }

    protected StrategyCollection(String str) {
        this.f1045f = null;
        this.f1041b = 0L;
        this.f1042c = null;
        this.f1043d = false;
        this.f1044e = 0;
        this.f1046g = 0L;
        this.f1047h = true;
        this.f1040a = str;
        this.f1043d = DispatchConstants.isAmdcServerDomain(str);
    }
}
