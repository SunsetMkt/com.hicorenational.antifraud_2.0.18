package anet.channel.session;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.Config;
import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.SessionInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.C0752a;
import anet.channel.entity.C0781a;
import anet.channel.entity.C0782b;
import anet.channel.heartbeat.HeartbeatManager;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.heartbeat.RunnableC0791c;
import anet.channel.request.Request;
import anet.channel.security.ISecurity;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.SessionMonitor;
import anet.channel.statist.SessionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.utils.C0848c;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.C3397d;
import java.util.List;
import java.util.Map;
import org.android.spdy.SessionCb;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p286h.C5230f1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TnetSpdySession extends Session implements SessionCb {

    /* renamed from: A */
    protected long f963A;

    /* renamed from: B */
    protected int f964B;

    /* renamed from: C */
    protected DataFrameCb f965C;

    /* renamed from: D */
    protected IHeartbeat f966D;

    /* renamed from: E */
    protected IAuth f967E;

    /* renamed from: F */
    protected String f968F;

    /* renamed from: G */
    protected ISecurity f969G;

    /* renamed from: H */
    private int f970H;

    /* renamed from: I */
    private boolean f971I;

    /* renamed from: w */
    protected SpdyAgent f972w;

    /* renamed from: x */
    protected SpdySession f973x;

    /* renamed from: y */
    protected volatile boolean f974y;

    /* renamed from: z */
    protected long f975z;

    /* compiled from: Taobao */
    /* renamed from: anet.channel.session.TnetSpdySession$a */
    private class C0809a extends C0810a {

        /* renamed from: b */
        private Request f977b;

        /* renamed from: c */
        private RequestCb f978c;

        /* renamed from: d */
        private int f979d = 0;

        /* renamed from: e */
        private long f980e = 0;

        public C0809a(Request request, RequestCb requestCb) {
            this.f977b = request;
            this.f978c = requestCb;
        }

        /* renamed from: a */
        private void m600a(SuperviseData superviseData, int i2, String str) {
            try {
                this.f977b.f916a.rspEnd = System.currentTimeMillis();
                if (this.f977b.f916a.isDone.get()) {
                    return;
                }
                if (i2 > 0) {
                    this.f977b.f916a.ret = 1;
                }
                this.f977b.f916a.statusCode = i2;
                this.f977b.f916a.msg = str;
                if (superviseData != null) {
                    this.f977b.f916a.rspEnd = superviseData.responseEnd;
                    this.f977b.f916a.sendBeforeTime = superviseData.sendStart - superviseData.requestStart;
                    this.f977b.f916a.sendDataTime = superviseData.sendEnd - this.f977b.f916a.sendStart;
                    this.f977b.f916a.firstDataTime = superviseData.responseStart - superviseData.sendEnd;
                    this.f977b.f916a.recDataTime = superviseData.responseEnd - superviseData.responseStart;
                    this.f977b.f916a.sendDataSize = superviseData.bodySize + superviseData.compressSize;
                    this.f977b.f916a.recDataSize = this.f980e + superviseData.recvUncompressSize;
                    this.f977b.f916a.reqHeadInflateSize = superviseData.uncompressSize;
                    this.f977b.f916a.reqHeadDeflateSize = superviseData.compressSize;
                    this.f977b.f916a.reqBodyInflateSize = superviseData.bodySize;
                    this.f977b.f916a.reqBodyDeflateSize = superviseData.bodySize;
                    this.f977b.f916a.rspHeadDeflateSize = superviseData.recvCompressSize;
                    this.f977b.f916a.rspHeadInflateSize = superviseData.recvUncompressSize;
                    this.f977b.f916a.rspBodyDeflateSize = superviseData.recvBodySize;
                    this.f977b.f916a.rspBodyInflateSize = this.f980e;
                    if (this.f977b.f916a.contentLength == 0) {
                        this.f977b.f916a.contentLength = superviseData.originContentLength;
                    }
                    TnetSpdySession.this.f699q.recvSizeCount += superviseData.recvBodySize + superviseData.recvCompressSize;
                    TnetSpdySession.this.f699q.sendSizeCount += superviseData.bodySize + superviseData.compressSize;
                }
            } catch (Exception unused) {
            }
        }

        @Override // anet.channel.session.C0810a, org.android.spdy.Spdycb
        public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j2, SpdyByteArray spdyByteArray, Object obj) {
            if (ALog.isPrintLog(1)) {
                ALog.m713d("awcn.TnetSpdySession", "spdyDataChunkRecvCB", this.f977b.getSeq(), "len", Integer.valueOf(spdyByteArray.getDataLength()), "fin", Boolean.valueOf(z));
            }
            this.f980e += spdyByteArray.getDataLength();
            this.f977b.f916a.recDataSize += spdyByteArray.getDataLength();
            IHeartbeat iHeartbeat = TnetSpdySession.this.f966D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
            if (this.f978c != null) {
                ByteArray m447a = C0752a.a.f765a.m447a(spdyByteArray.getByteArray(), spdyByteArray.getDataLength());
                spdyByteArray.recycle();
                this.f978c.onDataReceive(m447a, z);
            }
            TnetSpdySession.this.handleCallbacks(32, null);
        }

        @Override // anet.channel.session.C0810a, org.android.spdy.Spdycb
        public void spdyOnStreamResponse(SpdySession spdySession, long j2, Map<String, List<String>> map, Object obj) {
            this.f977b.f916a.firstDataTime = System.currentTimeMillis() - this.f977b.f916a.sendStart;
            this.f979d = HttpHelper.parseStatusCode(map);
            TnetSpdySession.this.f970H = 0;
            ALog.m716i("awcn.TnetSpdySession", "", this.f977b.getSeq(), HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(this.f979d));
            ALog.m716i("awcn.TnetSpdySession", "", this.f977b.getSeq(), "response headers", map);
            RequestCb requestCb = this.f978c;
            if (requestCb != null) {
                requestCb.onResponseCode(this.f979d, HttpHelper.cloneMap(map));
            }
            TnetSpdySession.this.handleCallbacks(16, null);
            this.f977b.f916a.contentEncoding = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Encoding");
            this.f977b.f916a.contentType = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Type");
            this.f977b.f916a.contentLength = HttpHelper.parseContentLength(map);
            this.f977b.f916a.serverRT = HttpHelper.parseServerRT(map);
            TnetSpdySession.this.handleResponseCode(this.f977b, this.f979d);
            TnetSpdySession.this.handleResponseHeaders(this.f977b, map);
            IHeartbeat iHeartbeat = TnetSpdySession.this.f966D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
        }

        @Override // anet.channel.session.C0810a, org.android.spdy.Spdycb
        public void spdyStreamCloseCallback(SpdySession spdySession, long j2, int i2, Object obj, SuperviseData superviseData) {
            String str;
            if (ALog.isPrintLog(1)) {
                ALog.m713d("awcn.TnetSpdySession", "spdyStreamCloseCallback", this.f977b.getSeq(), "streamId", Long.valueOf(j2), Constants.KEY_ERROR_CODE, Integer.valueOf(i2));
            }
            if (i2 != 0) {
                this.f979d = ErrorConstant.ERROR_TNET_REQUEST_FAIL;
                str = ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_REQUEST_FAIL, String.valueOf(i2));
                if (i2 != -2005) {
                    AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_TNET_EXCEPTION, str, this.f977b.f916a, null));
                }
                ALog.m715e("awcn.TnetSpdySession", "spdyStreamCloseCallback error", this.f977b.getSeq(), C3397d.f11932aw, TnetSpdySession.this.f698p, "status code", Integer.valueOf(i2), "URL", this.f977b.getHttpUrl().simpleUrlString());
            } else {
                str = HttpConstant.SUCCESS;
            }
            this.f977b.f916a.tnetErrorCode = i2;
            m600a(superviseData, this.f979d, str);
            RequestCb requestCb = this.f978c;
            if (requestCb != null) {
                requestCb.onFinish(this.f979d, str, this.f977b.f916a);
            }
            if (i2 == -2004) {
                if (!TnetSpdySession.this.f974y) {
                    TnetSpdySession.this.ping(true);
                }
                if (TnetSpdySession.m595e(TnetSpdySession.this) >= 2) {
                    ConnEvent connEvent = new ConnEvent();
                    connEvent.isSuccess = false;
                    connEvent.isAccs = TnetSpdySession.this.f971I;
                    StrategyCenter.getInstance().notifyConnEvent(TnetSpdySession.this.f686d, TnetSpdySession.this.f693k, connEvent);
                    TnetSpdySession.this.close(true);
                }
            }
        }
    }

    public TnetSpdySession(Context context, C0781a c0781a) {
        super(context, c0781a);
        this.f974y = false;
        this.f963A = 0L;
        this.f970H = 0;
        this.f964B = -1;
        this.f965C = null;
        this.f966D = null;
        this.f967E = null;
        this.f968F = null;
        this.f969G = null;
        this.f971I = false;
    }

    /* renamed from: e */
    static /* synthetic */ int m595e(TnetSpdySession tnetSpdySession) {
        int i2 = tnetSpdySession.f970H + 1;
        tnetSpdySession.f970H = i2;
        return i2;
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i2) {
    }

    @Override // anet.channel.Session
    public void close() {
        ALog.m715e("awcn.TnetSpdySession", "force close!", this.f698p, C3397d.f11932aw, this);
        notifyStatus(7, null);
        try {
            if (this.f966D != null) {
                this.f966D.stop();
                this.f966D = null;
            }
            if (this.f973x != null) {
                this.f973x.closeSession();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0136 A[Catch: all -> 0x0175, TryCatch #1 {all -> 0x0175, blocks: (B:8:0x0013, B:10:0x0017, B:11:0x001a, B:13:0x0020, B:16:0x0028, B:19:0x0030, B:21:0x00d4, B:23:0x00dc, B:26:0x00e5, B:28:0x00e9, B:29:0x0115, B:31:0x011d, B:33:0x0123, B:34:0x0126, B:36:0x0136, B:39:0x014b, B:42:0x0160, B:45:0x00ef, B:47:0x00f5, B:48:0x00fd, B:50:0x0109, B:52:0x010d, B:53:0x0112, B:54:0x0110), top: B:7:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014b A[Catch: all -> 0x0175, TryCatch #1 {all -> 0x0175, blocks: (B:8:0x0013, B:10:0x0017, B:11:0x001a, B:13:0x0020, B:16:0x0028, B:19:0x0030, B:21:0x00d4, B:23:0x00dc, B:26:0x00e5, B:28:0x00e9, B:29:0x0115, B:31:0x011d, B:33:0x0123, B:34:0x0126, B:36:0x0136, B:39:0x014b, B:42:0x0160, B:45:0x00ef, B:47:0x00f5, B:48:0x00fd, B:50:0x0109, B:52:0x010d, B:53:0x0112, B:54:0x0110), top: B:7:0x0013 }] */
    @Override // anet.channel.Session
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void connect() {
        /*
            Method dump skipped, instructions count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.TnetSpdySession.connect():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // anet.channel.Session
    public Runnable getRecvTimeOutRunnable() {
        return new RunnableC0817h(this);
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            ALog.m716i("awcn.TnetSpdySession", "get sslticket host is null", null, new Object[0]);
            return null;
        }
        try {
            if (this.f969G == null) {
                return null;
            }
            return this.f969G.getBytes(this.f683a, "accs_ssl_key2_" + domain);
        } catch (Throwable th) {
            ALog.m714e("awcn.TnetSpdySession", "getSSLMeta", null, th, new Object[0]);
            return null;
        }
    }

    public void initConfig(Config config) {
        if (config != null) {
            this.f968F = config.getAppkey();
            this.f969G = config.getSecurity();
        }
    }

    public void initSessionInfo(SessionInfo sessionInfo) {
        if (sessionInfo != null) {
            this.f965C = sessionInfo.dataFrameCb;
            this.f967E = sessionInfo.auth;
            if (sessionInfo.isKeepAlive) {
                this.f699q.isKL = 1L;
                this.f702t = true;
                this.f966D = sessionInfo.heartbeat;
                boolean z = sessionInfo.isAccs;
                this.f971I = z;
                if (this.f966D == null) {
                    if (!z || AwcnConfig.isAccsSessionCreateForbiddenInBg()) {
                        this.f966D = HeartbeatManager.getDefaultHeartbeat();
                    } else {
                        this.f966D = HeartbeatManager.getDefaultBackgroundAccsHeartbeat();
                    }
                }
            }
        }
        if (AwcnConfig.isIdleSessionCloseEnable() && this.f966D == null) {
            this.f966D = new RunnableC0791c();
        }
    }

    @Override // anet.channel.Session
    public boolean isAvailable() {
        return this.f696n == 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // anet.channel.Session
    public void onDisconnect() {
        this.f974y = false;
    }

    @Override // anet.channel.Session
    public void ping(boolean z) {
        ping(z, this.f701s);
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            return -1;
        }
        try {
            if (this.f969G == null) {
                return -1;
            }
            ISecurity iSecurity = this.f969G;
            Context context = this.f683a;
            StringBuilder sb = new StringBuilder();
            sb.append("accs_ssl_key2_");
            sb.append(domain);
            return iSecurity.saveBytes(context, sb.toString(), bArr) ? 0 : -1;
        } catch (Throwable th) {
            ALog.m714e("awcn.TnetSpdySession", "putSSLMeta", null, th, new Object[0]);
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0113 A[Catch: Exception -> 0x01c1, SpdyErrorException -> 0x01cb, TRY_ENTER, TryCatch #3 {SpdyErrorException -> 0x01cb, Exception -> 0x01c1, blocks: (B:12:0x0051, B:14:0x0055, B:16:0x0059, B:18:0x005e, B:20:0x0062, B:21:0x0069, B:24:0x0080, B:25:0x00b9, B:27:0x00c1, B:30:0x00c6, B:31:0x0100, B:34:0x0113, B:36:0x011a, B:37:0x0121, B:38:0x0140, B:40:0x016f, B:41:0x0184, B:62:0x011d, B:63:0x0125, B:65:0x0138, B:66:0x013a, B:67:0x00ed, B:69:0x01b7), top: B:11:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x016f A[Catch: Exception -> 0x01c1, SpdyErrorException -> 0x01cb, TryCatch #3 {SpdyErrorException -> 0x01cb, Exception -> 0x01c1, blocks: (B:12:0x0051, B:14:0x0055, B:16:0x0059, B:18:0x005e, B:20:0x0062, B:21:0x0069, B:24:0x0080, B:25:0x00b9, B:27:0x00c1, B:30:0x00c6, B:31:0x0100, B:34:0x0113, B:36:0x011a, B:37:0x0121, B:38:0x0140, B:40:0x016f, B:41:0x0184, B:62:0x011d, B:63:0x0125, B:65:0x0138, B:66:0x013a, B:67:0x00ed, B:69:0x01b7), top: B:11:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a9 A[Catch: Exception -> 0x01b0, SpdyErrorException -> 0x01b2, TRY_LEAVE, TryCatch #4 {SpdyErrorException -> 0x01b2, Exception -> 0x01b0, blocks: (B:43:0x018f, B:45:0x01a9), top: B:42:0x018f }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0125 A[Catch: Exception -> 0x01c1, SpdyErrorException -> 0x01cb, TryCatch #3 {SpdyErrorException -> 0x01cb, Exception -> 0x01c1, blocks: (B:12:0x0051, B:14:0x0055, B:16:0x0059, B:18:0x005e, B:20:0x0062, B:21:0x0069, B:24:0x0080, B:25:0x00b9, B:27:0x00c1, B:30:0x00c6, B:31:0x0100, B:34:0x0113, B:36:0x011a, B:37:0x0121, B:38:0x0140, B:40:0x016f, B:41:0x0184, B:62:0x011d, B:63:0x0125, B:65:0x0138, B:66:0x013a, B:67:0x00ed, B:69:0x01b7), top: B:11:0x0051 }] */
    @Override // anet.channel.Session
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public anet.channel.request.Cancelable request(anet.channel.request.Request r25, anet.channel.RequestCb r26) {
        /*
            Method dump skipped, instructions count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.TnetSpdySession.request(anet.channel.request.Request, anet.channel.RequestCb):anet.channel.request.Cancelable");
    }

    @Override // anet.channel.Session
    public void sendCustomFrame(int i2, byte[] bArr, int i3) {
        try {
            if (this.f965C == null) {
                return;
            }
            ALog.m715e("awcn.TnetSpdySession", "sendCustomFrame", this.f698p, Constants.KEY_DATA_ID, Integer.valueOf(i2), "type", Integer.valueOf(i3));
            if (this.f696n != 4 || this.f973x == null) {
                ALog.m715e("awcn.TnetSpdySession", "sendCustomFrame", this.f698p, "sendCustomFrame con invalid mStatus:" + this.f696n);
                m583a(i2, ErrorConstant.ERROR_SESSION_INVALID, true, "session invalid");
                return;
            }
            if (bArr != null && bArr.length > 16384) {
                m583a(i2, ErrorConstant.ERROR_DATA_TOO_LARGE, false, null);
                return;
            }
            this.f973x.sendCustomControlFrame(i2, i3, 0, bArr == null ? 0 : bArr.length, bArr);
            this.f699q.requestCount++;
            this.f699q.cfRCount++;
            this.f975z = System.currentTimeMillis();
            if (this.f966D != null) {
                this.f966D.reSchedule();
            }
        } catch (SpdyErrorException e2) {
            ALog.m714e("awcn.TnetSpdySession", "sendCustomFrame error", this.f698p, e2, new Object[0]);
            m583a(i2, ErrorConstant.ERROR_TNET_EXCEPTION, true, "SpdyErrorException: " + e2.toString());
        } catch (Exception e3) {
            ALog.m714e("awcn.TnetSpdySession", "sendCustomFrame error", this.f698p, e3, new Object[0]);
            m583a(i2, -101, true, e3.toString());
        }
    }

    public void setTnetPublicKey(int i2) {
        this.f964B = i2;
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i2, int i3) {
        ALog.m715e("awcn.TnetSpdySession", "spdyCustomControlFrameFailCallback", this.f698p, Constants.KEY_DATA_ID, Integer.valueOf(i2));
        m583a(i2, i3, true, "tnet error");
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i2, int i3, int i4, int i5, byte[] bArr) {
        ALog.m715e("awcn.TnetSpdySession", "[spdyCustomControlFrameRecvCallback]", this.f698p, "len", Integer.valueOf(i5), "frameCb", this.f965C);
        if (ALog.isPrintLog(1) && i5 < 512) {
            String str = "";
            for (byte b2 : bArr) {
                str = str + Integer.toHexString(b2 & C5230f1.f20085c) + AbstractC1191a.f2568g;
            }
            ALog.m715e("awcn.TnetSpdySession", null, this.f698p, "str", str);
        }
        DataFrameCb dataFrameCb = this.f965C;
        if (dataFrameCb != null) {
            dataFrameCb.onDataReceive(this, bArr, i2, i3);
        } else {
            ALog.m715e("awcn.TnetSpdySession", "AccsFrameCb is null", this.f698p, new Object[0]);
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(-105, null, "rt"));
        }
        this.f699q.inceptCount++;
        IHeartbeat iHeartbeat = this.f966D;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j2, Object obj) {
        if (ALog.isPrintLog(2)) {
            ALog.m716i("awcn.TnetSpdySession", "ping receive", this.f698p, "Host", this.f685c, "id", Long.valueOf(j2));
        }
        if (j2 < 0) {
            return;
        }
        this.f974y = false;
        this.f970H = 0;
        IHeartbeat iHeartbeat = this.f966D;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
        handleCallbacks(128, null);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i2) {
        ALog.m715e("awcn.TnetSpdySession", "spdySessionCloseCallback", this.f698p, " errorCode:", Integer.valueOf(i2));
        IHeartbeat iHeartbeat = this.f966D;
        if (iHeartbeat != null) {
            iHeartbeat.stop();
            this.f966D = null;
        }
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.m714e("awcn.TnetSpdySession", "session clean up failed!", null, e2, new Object[0]);
            }
        }
        if (i2 == -3516) {
            ConnEvent connEvent = new ConnEvent();
            connEvent.isSuccess = false;
            StrategyCenter.getInstance().notifyConnEvent(this.f686d, this.f693k, connEvent);
        }
        notifyStatus(6, new C0782b(2));
        if (superviseConnectInfo != null) {
            SessionStatistic sessionStatistic = this.f699q;
            sessionStatistic.requestCount = superviseConnectInfo.reused_counter;
            sessionStatistic.liveTime = superviseConnectInfo.keepalive_period_second;
            try {
                if (this.f692j.isHTTP3()) {
                    if (spdySession != null) {
                        ALog.m715e("awcn.TnetSpdySession", "[HTTP3 spdySessionCloseCallback]", this.f698p, "connectInfo", spdySession.getConnectInfoOnDisConnected());
                    }
                    this.f699q.xqc0RttStatus = superviseConnectInfo.xqc0RttStatus;
                    this.f699q.retransmissionRate = superviseConnectInfo.retransmissionRate;
                    this.f699q.lossRate = superviseConnectInfo.lossRate;
                    this.f699q.tlpCount = superviseConnectInfo.tlpCount;
                    this.f699q.rtoCount = superviseConnectInfo.rtoCount;
                    this.f699q.srtt = superviseConnectInfo.srtt;
                }
            } catch (Exception unused) {
            }
        }
        SessionStatistic sessionStatistic2 = this.f699q;
        if (sessionStatistic2.errorCode == 0) {
            sessionStatistic2.errorCode = i2;
        }
        this.f699q.lastPingInterval = (int) (System.currentTimeMillis() - this.f975z);
        AppMonitor.getInstance().commitStat(this.f699q);
        if (C0848c.m708b(this.f699q.f1004ip)) {
            AppMonitor.getInstance().commitStat(new SessionMonitor(this.f699q));
        }
        AppMonitor.getInstance().commitAlarm(this.f699q.getAlarmObject());
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        SessionStatistic sessionStatistic = this.f699q;
        sessionStatistic.connectionTime = superviseConnectInfo.connectTime;
        sessionStatistic.sslTime = superviseConnectInfo.handshakeTime;
        sessionStatistic.sslCalTime = superviseConnectInfo.doHandshakeTime;
        sessionStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        this.f963A = System.currentTimeMillis();
        notifyStatus(0, new C0782b(1));
        m599b();
        ALog.m715e("awcn.TnetSpdySession", "spdySessionConnectCB connect", this.f698p, "connectTime", Integer.valueOf(superviseConnectInfo.connectTime), "sslTime", Integer.valueOf(superviseConnectInfo.handshakeTime));
        if (this.f692j.isHTTP3()) {
            this.f699q.scid = superviseConnectInfo.scid;
            this.f699q.dcid = superviseConnectInfo.dcid;
            this.f699q.congControlKind = superviseConnectInfo.congControlKind;
            ALog.m715e("awcn.TnetSpdySession", "[HTTP3 spdySessionConnectCB]", this.f698p, "connectInfo", spdySession.getConnectInfoOnConnected());
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i2, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.m714e("awcn.TnetSpdySession", "[spdySessionFailedError]session clean up failed!", null, e2, new Object[0]);
            }
        }
        notifyStatus(2, new C0782b(256, i2, "tnet connect fail"));
        ALog.m715e("awcn.TnetSpdySession", null, this.f698p, " errorId:", Integer.valueOf(i2));
        SessionStatistic sessionStatistic = this.f699q;
        sessionStatistic.errorCode = i2;
        sessionStatistic.ret = 0;
        sessionStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        AppMonitor.getInstance().commitStat(this.f699q);
        if (C0848c.m708b(this.f699q.f1004ip)) {
            AppMonitor.getInstance().commitStat(new SessionMonitor(this.f699q));
        }
        AppMonitor.getInstance().commitAlarm(this.f699q.getAlarmObject());
    }

    @Override // anet.channel.Session
    public void ping(boolean z, int i2) {
        if (ALog.isPrintLog(1)) {
            ALog.m713d("awcn.TnetSpdySession", "ping", this.f698p, Constants.KEY_HOST, this.f685c, "thread", Thread.currentThread().getName());
        }
        if (z) {
            try {
                if (this.f973x == null) {
                    if (this.f699q != null) {
                        this.f699q.closeReason = "session null";
                    }
                    ALog.m715e("awcn.TnetSpdySession", this.f685c + " session null", this.f698p, new Object[0]);
                    close();
                    return;
                }
                if (this.f696n == 0 || this.f696n == 4) {
                    handleCallbacks(64, null);
                    if (this.f974y) {
                        return;
                    }
                    this.f974y = true;
                    this.f699q.ppkgCount++;
                    this.f973x.submitPing();
                    if (ALog.isPrintLog(1)) {
                        ALog.m713d("awcn.TnetSpdySession", this.f685c + " submit ping ms:" + (System.currentTimeMillis() - this.f975z) + " force:" + z, this.f698p, new Object[0]);
                    }
                    setPingTimeout(i2);
                    this.f975z = System.currentTimeMillis();
                    if (this.f966D != null) {
                        this.f966D.reSchedule();
                    }
                }
            } catch (SpdyErrorException e2) {
                if (e2.SpdyErrorGetCode() == -1104 || e2.SpdyErrorGetCode() == -1103) {
                    ALog.m715e("awcn.TnetSpdySession", "Send request on closed session!!!", this.f698p, new Object[0]);
                    notifyStatus(6, new C0782b(2));
                }
                ALog.m714e("awcn.TnetSpdySession", "ping", this.f698p, e2, new Object[0]);
            } catch (Exception e3) {
                ALog.m714e("awcn.TnetSpdySession", "ping", this.f698p, e3, new Object[0]);
            }
        }
    }

    /* renamed from: c */
    private void m591c() {
        SpdyAgent.enableDebug = false;
        this.f972w = SpdyAgent.getInstance(this.f683a, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        ISecurity iSecurity = this.f969G;
        if (iSecurity != null && !iSecurity.isSecOff()) {
            this.f972w.setAccsSslCallback(new C0819j(this));
        }
        if (AwcnConfig.isTnetHeaderCacheEnable()) {
            return;
        }
        try {
            this.f972w.getClass().getDeclaredMethod("disableHeaderCache", new Class[0]).invoke(this.f972w, new Object[0]);
            ALog.m716i("awcn.TnetSpdySession", "tnet disableHeaderCache", null, new Object[0]);
        } catch (Exception e2) {
            ALog.m714e("awcn.TnetSpdySession", "tnet disableHeaderCache", null, e2, new Object[0]);
        }
    }

    /* renamed from: b */
    protected void m599b() {
        IAuth iAuth = this.f967E;
        if (iAuth != null) {
            iAuth.auth(this, new C0818i(this));
            return;
        }
        notifyStatus(4, null);
        this.f699q.ret = 1;
        IHeartbeat iHeartbeat = this.f966D;
        if (iHeartbeat != null) {
            iHeartbeat.start(this);
        }
    }

    /* renamed from: a */
    private void m583a(int i2, int i3, boolean z, String str) {
        DataFrameCb dataFrameCb = this.f965C;
        if (dataFrameCb != null) {
            dataFrameCb.onException(i2, i3, z, str);
        }
    }
}
