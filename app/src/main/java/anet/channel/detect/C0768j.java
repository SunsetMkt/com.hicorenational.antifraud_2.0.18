package anet.channel.detect;

import anet.channel.strategy.C0842l;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;

/* compiled from: Taobao */
/* renamed from: anet.channel.detect.j */
/* loaded from: classes.dex */
final class C0768j implements IConnStrategy {

    /* renamed from: a */
    final /* synthetic */ C0842l.e f803a;

    /* renamed from: b */
    final /* synthetic */ ConnProtocol f804b;

    C0768j(C0842l.e eVar, ConnProtocol connProtocol) {
        this.f803a = eVar;
        this.f804b = connProtocol;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getConnectionTimeout() {
        return this.f803a.f1140b.f1111c;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getHeartbeat() {
        return 0;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public String getIp() {
        return this.f803a.f1139a;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpSource() {
        return 2;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpType() {
        return 1;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getPort() {
        return this.f803a.f1140b.f1109a;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public ConnProtocol getProtocol() {
        return this.f804b;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getReadTimeout() {
        return this.f803a.f1140b.f1112d;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getRetryTimes() {
        return 0;
    }
}
