package anet.channel.p021e;

import anet.channel.entity.ConnType;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;

/* compiled from: Taobao */
/* renamed from: anet.channel.e.g */
/* loaded from: classes.dex */
final class C0780g implements IConnStrategy {

    /* renamed from: a */
    final /* synthetic */ IConnStrategy f834a;

    C0780g(IConnStrategy iConnStrategy) {
        this.f834a = iConnStrategy;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getConnectionTimeout() {
        return this.f834a.getConnectionTimeout();
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getHeartbeat() {
        return this.f834a.getHeartbeat();
    }

    @Override // anet.channel.strategy.IConnStrategy
    public String getIp() {
        return this.f834a.getIp();
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpSource() {
        return this.f834a.getIpSource();
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpType() {
        return this.f834a.getIpType();
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getPort() {
        return this.f834a.getPort();
    }

    @Override // anet.channel.strategy.IConnStrategy
    public ConnProtocol getProtocol() {
        this.f834a.getProtocol();
        return ConnProtocol.valueOf(ConnType.HTTP3_1RTT, null, null);
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getReadTimeout() {
        return this.f834a.getReadTimeout();
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getRetryTimes() {
        return this.f834a.getRetryTimes();
    }
}
