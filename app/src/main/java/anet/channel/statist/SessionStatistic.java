package anet.channel.statist;

import anet.channel.AwcnConfig;
import anet.channel.entity.C0781a;
import anet.channel.fulltrace.C0785a;
import anet.channel.fulltrace.C0786b;
import anet.channel.p021e.C0774a;
import anet.channel.strategy.IConnStrategy;
import com.umeng.analytics.pro.C3397d;
import org.json.JSONObject;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = C3397d.f11932aw)
/* loaded from: classes.dex */
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

    /* renamed from: ip */
    @Dimension
    public String f1004ip;

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

    public SessionStatistic(C0781a c0781a) {
        this.ipRefer = 0;
        this.ipType = 1;
        if (c0781a == null) {
            return;
        }
        this.f1004ip = c0781a.m508a();
        this.port = c0781a.m509b();
        IConnStrategy iConnStrategy = c0781a.f835a;
        if (iConnStrategy != null) {
            this.ipRefer = iConnStrategy.getIpSource();
            this.ipType = c0781a.f835a.getIpType();
        }
        this.pRate = c0781a.m514g();
        this.conntype = c0781a.m510c().toString();
        this.retryTimes = c0781a.f836b;
        maxRetryTime = c0781a.f837c;
        C0786b sceneInfo = C0785a.m516a().getSceneInfo();
        String str = sceneInfo != null ? sceneInfo.f857f : null;
        boolean m497b = C0774a.m497b();
        this.xqcConnEnv = AwcnConfig.isHttp3OrangeEnable() + AbstractC1191a.f2606s1 + m497b + AbstractC1191a.f2606s1 + str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        if (r3 != (-2601)) goto L14;
     */
    @Override // anet.channel.statist.StatObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean beforeCommit() {
        /*
            r7 = this;
            int r0 = r7.ret
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L52
            long r3 = r7.retryTimes
            int r0 = anet.channel.statist.SessionStatistic.maxRetryTime
            long r5 = (long) r0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L1d
            long r3 = r7.errorCode
            r5 = -2613(0xfffffffffffff5cb, double:NaN)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L1d
            r5 = -2601(0xfffffffffffff5d7, double:NaN)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L52
        L1d:
            boolean r0 = anet.channel.util.ALog.isPrintLog(r2)
            if (r0 == 0) goto L51
            r0 = 0
            r3 = 5
            java.lang.Object[] r3 = new java.lang.Object[r3]
            long r4 = r7.retryTimes
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r3[r1] = r4
            java.lang.String r4 = "maxRetryTime"
            r3[r2] = r4
            r2 = 2
            int r4 = anet.channel.statist.SessionStatistic.maxRetryTime
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r2] = r4
            r2 = 3
            java.lang.String r4 = "errorCode"
            r3[r2] = r4
            r2 = 4
            long r4 = r7.errorCode
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r3[r2] = r4
            java.lang.String r2 = "SessionStat no need commit"
            java.lang.String r4 = "retry:"
            anet.channel.util.ALog.m713d(r2, r0, r4, r3)
        L51:
            return r1
        L52:
            boolean r0 = r7.isCommitted
            if (r0 == 0) goto L57
            return r1
        L57:
            r7.isCommitted = r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.statist.SessionStatistic.beforeCommit():boolean");
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
