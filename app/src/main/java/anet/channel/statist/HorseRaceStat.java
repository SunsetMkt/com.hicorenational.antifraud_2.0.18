package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.C0842l;
import anet.channel.strategy.ConnProtocol;
import anet.channel.util.C0857c;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "horseRace")
/* loaded from: classes.dex */
public class HorseRaceStat extends StatObject {

    @Dimension
    public volatile int connErrorCode;

    @Measure
    public volatile long connTime;

    @Dimension
    public volatile String host;

    /* renamed from: ip */
    @Dimension
    public volatile String f999ip;

    @Dimension
    public volatile int ipStackType;

    @Dimension
    public volatile String localIP;

    @Dimension
    public volatile String path;

    @Dimension
    public volatile int pingSuccessCount;

    @Dimension
    public volatile int pingTimeoutCount;

    @Dimension
    public volatile int port;

    @Dimension
    public volatile String protocol;

    @Dimension
    public volatile int reqErrorCode;

    @Measure
    public volatile long reqTime;

    @Dimension
    public volatile int connRet = 0;

    @Dimension
    public volatile int reqRet = 0;

    @Dimension
    public volatile String nettype = NetworkStatusHelper.getNetworkSubType();

    @Dimension
    public volatile String mnc = NetworkStatusHelper.getSimOp();

    @Dimension
    public volatile String bssid = NetworkStatusHelper.getWifiBSSID();

    public HorseRaceStat(String str, C0842l.e eVar) {
        this.host = str;
        this.f999ip = eVar.f1139a;
        C0842l.a aVar = eVar.f1140b;
        this.port = aVar.f1109a;
        this.protocol = ConnProtocol.valueOf(aVar).name;
        this.path = eVar.f1141c;
        this.ipStackType = C0857c.m727c();
    }
}
