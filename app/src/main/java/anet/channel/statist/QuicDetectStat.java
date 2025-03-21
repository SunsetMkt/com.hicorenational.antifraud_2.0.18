package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "quic_detect")
/* loaded from: classes.dex */
public class QuicDetectStat extends StatObject {

    @Dimension
    public String host;

    /* renamed from: ip */
    @Dimension
    public String f1001ip;

    @Dimension
    public volatile String netType;

    @Dimension
    public String protocol;

    @Dimension
    public int ret;

    public QuicDetectStat(String str, IConnStrategy iConnStrategy) {
        this.host = str;
        if (iConnStrategy != null) {
            this.f1001ip = iConnStrategy.getIp();
            this.protocol = iConnStrategy.getProtocol().protocol;
        }
        this.netType = NetworkStatusHelper.getNetworkSubType();
    }
}
