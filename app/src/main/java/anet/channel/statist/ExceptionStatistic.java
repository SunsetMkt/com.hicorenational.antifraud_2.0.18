package anet.channel.statist;

import anet.channel.util.ErrorConstant;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "NetworkError")
/* loaded from: classes.dex */
public class ExceptionStatistic extends StatObject {

    @Dimension
    public String bizId;

    @Dimension
    public String errorMsg;

    @Dimension
    public String exceptionStack;

    @Dimension
    public String exceptionType;

    @Dimension
    public String host;

    /* renamed from: ip */
    @Dimension
    public String f998ip;

    @Dimension
    public boolean isDNS;

    @Dimension
    public boolean isProxy;

    @Dimension
    public boolean isSSL;

    @Dimension
    public String netType;

    @Dimension
    public int port;

    @Dimension
    public String protocolType;

    @Dimension
    public String proxyType;

    @Dimension
    public int resultCode;

    @Dimension
    public String url;

    public ExceptionStatistic() {
    }

    public ExceptionStatistic(int i2, String str, String str2) {
        this.resultCode = i2;
        this.errorMsg = str == null ? ErrorConstant.getErrMsg(i2) : str;
        this.exceptionType = str2;
    }

    public ExceptionStatistic(int i2, String str, RequestStatistic requestStatistic, Throwable th) {
        this.exceptionType = "nw";
        this.resultCode = i2;
        this.errorMsg = str == null ? ErrorConstant.getErrMsg(i2) : str;
        this.exceptionStack = th != null ? th.toString() : "";
        if (requestStatistic != null) {
            this.host = requestStatistic.host;
            this.f998ip = requestStatistic.f1002ip;
            this.port = requestStatistic.port;
            this.isSSL = requestStatistic.isSSL;
            this.isProxy = requestStatistic.isProxy;
            this.proxyType = String.valueOf(requestStatistic.proxyType);
            this.netType = requestStatistic.netType;
            this.isDNS = requestStatistic.isDNS;
            this.protocolType = String.valueOf(requestStatistic.protocolType);
            this.bizId = requestStatistic.bizId;
        }
    }
}
