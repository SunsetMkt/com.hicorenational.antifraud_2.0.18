package com.taobao.accs.net;

import anet.channel.entity.ConnType;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.HttpDispatcher;
import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    private int a = 0;

    /* JADX INFO: renamed from: b */
    private List<IConnStrategy> f5823b = new ArrayList();

    public h(String str) {
        HttpDispatcher.getInstance().addListener(new i(this));
        a(str);
    }

    public List<IConnStrategy> a(String str) {
        List<IConnStrategy> connStrategyListByHost;
        if ((this.a == 0 || this.f5823b.isEmpty()) && (connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str)) != null && !connStrategyListByHost.isEmpty()) {
            this.f5823b.clear();
            for (IConnStrategy iConnStrategy : connStrategyListByHost) {
                ConnType connTypeValueOf = ConnType.valueOf(iConnStrategy.getProtocol());
                if (connTypeValueOf.getTypeLevel() == ConnType.TypeLevel.SPDY && connTypeValueOf.isSSL()) {
                    this.f5823b.add(iConnStrategy);
                }
            }
        }
        return this.f5823b;
    }

    public void b() {
        this.a++;
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("HttpDnsProvider", "updateStrategyPos StrategyPos:" + this.a, new Object[0]);
        }
    }

    public int c() {
        return this.a;
    }

    public void b(String str) {
        StrategyCenter.getInstance().forceRefreshStrategy(str);
    }

    public IConnStrategy a() {
        return a(this.f5823b);
    }

    public IConnStrategy a(List<IConnStrategy> list) {
        if (list != null && !list.isEmpty()) {
            int i2 = this.a;
            if (i2 < 0 || i2 >= list.size()) {
                this.a = 0;
            }
            return list.get(this.a);
        }
        ALog.d("HttpDnsProvider", "strategys null or 0", new Object[0]);
        return null;
    }
}
