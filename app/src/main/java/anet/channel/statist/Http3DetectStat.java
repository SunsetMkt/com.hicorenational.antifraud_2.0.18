package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "http3_detect")
/* loaded from: classes.dex */
public class Http3DetectStat extends StatObject {

    @Dimension
    public String host;

    /* renamed from: ip */
    @Dimension
    public String f1000ip;

    @Dimension
    public volatile String netType;

    @Dimension
    public String protocol;

    @Dimension
    public int ret;

    public Http3DetectStat(String str, IConnStrategy iConnStrategy) {
        this.host = str;
        if (iConnStrategy != null) {
            this.f1000ip = iConnStrategy.getIp();
            this.protocol = iConnStrategy.getProtocol().protocol;
        }
        this.netType = NetworkStatusHelper.getNetworkSubType();
    }
}
