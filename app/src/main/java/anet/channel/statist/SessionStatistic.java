package anet.channel.statist;

import anet.channel.AwcnConfig;
import anet.channel.entity.a;
import anet.channel.fulltrace.b;
import anet.channel.strategy.IConnStrategy;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.d;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
@Monitor(module = "networkPrefer", monitorPoint = d.aw)
public class SessionStatistic extends StatObject {
    public static int maxRetryTime;

    @Measure
    public long ackTime;

    @Measure(max = 15000.0d)
    public long authTime;

    @Measure
    public long cfRCount;

    @Dimension
    public String closeReason;

    @Dimension
    public int congControlKind;

    @Measure(max = 15000.0d, name = "connTime")
    public long connectionTime;

    @Dimension(name = "protocolType")
    public String conntype;

    @Dimension
    public String dcid;

    @Dimension
    public long errorCode;

    @Dimension
    public String host;

    @Measure
    public long inceptCount;

    @Dimension
    public String ip;

    @Dimension
    public int ipRefer;

    @Dimension
    public int ipType;

    @Dimension
    public boolean isBackground;

    @Dimension
    public long isKL;

    @Dimension
    public String isTunnel;

    @Measure
    public int lastPingInterval;

    @Measure
    public double lossRate;

    @Dimension
    public String netType;

    @Measure
    public long pRate;

    @Dimension
    public int port;

    @Measure
    public long ppkgCount;

    @Measure
    public long recvSizeCount;

    @Dimension
    public int ret;

    @Measure
    public double retransmissionRate;

    @Dimension
    public long retryTimes;

    @Measure
    public int rtoCount;

    @Dimension
    public String scid;

    @Dimension
    public int sdkv;

    @Measure
    public long sendSizeCount;

    @Measure
    public long srtt;

    @Measure(max = 15000.0d)
    public long sslCalTime;

    @Measure(max = 15000.0d)
    public long sslTime;

    @Measure
    public int tlpCount;

    @Dimension
    public int xqc0RttStatus;

    @Dimension
    public String xqcConnEnv;

    @Dimension
    public int isProxy = 0;

    @Dimension
    public JSONObject extra = null;

    @Measure(max = 86400.0d)
    public long liveTime = 0;

    @Measure(constantValue = 1.0d)
    public long requestCount = 1;

    @Measure(constantValue = 0.0d)
    public long stdRCount = 1;
    public boolean isCommitted = false;

    public SessionStatistic(a aVar) {
        this.ipRefer = 0;
        this.ipType = 1;
        if (aVar == null) {
            return;
        }
        this.ip = aVar.a();
        this.port = aVar.b();
        IConnStrategy iConnStrategy = aVar.a;
        if (iConnStrategy != null) {
            this.ipRefer = iConnStrategy.getIpSource();
            this.ipType = aVar.a.getIpType();
        }
        this.pRate = aVar.g();
        this.conntype = aVar.c().toString();
        this.retryTimes = aVar.f1440b;
        maxRetryTime = aVar.f1441c;
        b sceneInfo = anet.channel.fulltrace.a.a().getSceneInfo();
        String str = sceneInfo != null ? sceneInfo.f1455f : null;
        boolean zB = anet.channel.e.a.b();
        this.xqcConnEnv = AwcnConfig.isHttp3OrangeEnable() + d.c.a.b.a.a.s1 + zB + d.c.a.b.a.a.s1 + str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (r3 != (-2601)) goto L14;
     */
    @Override // anet.channel.statist.StatObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean beforeCommit() {
        if (this.ret == 0) {
            if (this.retryTimes == maxRetryTime) {
                long j2 = this.errorCode;
                if (j2 != -2613) {
                }
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("SessionStat no need commit", null, "retry:", Long.valueOf(this.retryTimes), "maxRetryTime", Integer.valueOf(maxRetryTime), Constants.KEY_ERROR_CODE, Long.valueOf(this.errorCode));
            }
            return false;
        }
        if (this.isCommitted) {
            return false;
        }
        this.isCommitted = true;
        return true;
    }

    public AlarmObject getAlarmObject() {
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = "networkPrefer";
        alarmObject.modulePoint = "connect_succ_rate";
        alarmObject.isSuccess = this.ret != 0;
        if (alarmObject.isSuccess) {
            alarmObject.arg = this.closeReason;
        } else {
            alarmObject.errorCode = String.valueOf(this.errorCode);
        }
        return alarmObject;
    }
}
