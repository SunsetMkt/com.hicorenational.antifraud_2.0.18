package com.taobao.accs.net;

import anet.channel.entity.ConnType;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.HttpDispatcher;
import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.h */
/* loaded from: classes2.dex */
public class C3008h {

    /* renamed from: a */
    private int f9555a = 0;

    /* renamed from: b */
    private List<IConnStrategy> f9556b = new ArrayList();

    public C3008h(String str) {
        HttpDispatcher.getInstance().addListener(new C3009i(this));
        m9122a(str);
    }

    /* renamed from: a */
    public List<IConnStrategy> m9122a(String str) {
        List<IConnStrategy> connStrategyListByHost;
        if ((this.f9555a == 0 || this.f9556b.isEmpty()) && (connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str)) != null && !connStrategyListByHost.isEmpty()) {
            this.f9556b.clear();
            for (IConnStrategy iConnStrategy : connStrategyListByHost) {
                ConnType valueOf = ConnType.valueOf(iConnStrategy.getProtocol());
                if (valueOf.getTypeLevel() == ConnType.TypeLevel.SPDY && valueOf.isSSL()) {
                    this.f9556b.add(iConnStrategy);
                }
            }
        }
        return this.f9556b;
    }

    /* renamed from: b */
    public void m9123b() {
        this.f9555a++;
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.m9180d("HttpDnsProvider", "updateStrategyPos StrategyPos:" + this.f9555a, new Object[0]);
        }
    }

    /* renamed from: c */
    public int m9125c() {
        return this.f9555a;
    }

    /* renamed from: b */
    public void m9124b(String str) {
        StrategyCenter.getInstance().forceRefreshStrategy(str);
    }

    /* renamed from: a */
    public IConnStrategy m9120a() {
        return m9121a(this.f9556b);
    }

    /* renamed from: a */
    public IConnStrategy m9121a(List<IConnStrategy> list) {
        if (list != null && !list.isEmpty()) {
            int i2 = this.f9555a;
            if (i2 < 0 || i2 >= list.size()) {
                this.f9555a = 0;
            }
            return list.get(this.f9555a);
        }
        ALog.m9180d("HttpDnsProvider", "strategys null or 0", new Object[0]);
        return null;
    }
}
