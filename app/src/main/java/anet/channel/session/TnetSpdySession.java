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
import anet.channel.bytes.a;
import anet.channel.heartbeat.HeartbeatManager;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.request.Request;
import anet.channel.security.ISecurity;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.SessionMonitor;
import anet.channel.statist.SessionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.common.Constants;
import h.f1;
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

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TnetSpdySession extends Session implements SessionCb {
    protected long A;
    protected int B;
    protected DataFrameCb C;
    protected IHeartbeat D;
    protected IAuth E;
    protected String F;
    protected ISecurity G;
    private int H;
    private boolean I;
    protected SpdyAgent w;
    protected SpdySession x;
    protected volatile boolean y;
    protected long z;

    /* compiled from: Taobao */
    private class a extends anet.channel.session.a {

        /* renamed from: b, reason: collision with root package name */
        private Request f1879b;

        /* renamed from: c, reason: collision with root package name */
        private RequestCb f1880c;

        /* renamed from: d, reason: collision with root package name */
        private int f1881d = 0;

        /* renamed from: e, reason: collision with root package name */
        private long f1882e = 0;

        public a(Request request, RequestCb requestCb) {
            this.f1879b = request;
            this.f1880c = requestCb;
        }

        private void a(SuperviseData superviseData, int i2, String str) {
            try {
                this.f1879b.f1841a.rspEnd = System.currentTimeMillis();
                if (this.f1879b.f1841a.isDone.get()) {
                    return;
                }
                if (i2 > 0) {
                    this.f1879b.f1841a.ret = 1;
                }
                this.f1879b.f1841a.statusCode = i2;
                this.f1879b.f1841a.msg = str;
                if (superviseData != null) {
                    this.f1879b.f1841a.rspEnd = superviseData.responseEnd;
                    this.f1879b.f1841a.sendBeforeTime = superviseData.sendStart - superviseData.requestStart;
                    this.f1879b.f1841a.sendDataTime = superviseData.sendEnd - this.f1879b.f1841a.sendStart;
                    this.f1879b.f1841a.firstDataTime = superviseData.responseStart - superviseData.sendEnd;
                    this.f1879b.f1841a.recDataTime = superviseData.responseEnd - superviseData.responseStart;
                    this.f1879b.f1841a.sendDataSize = superviseData.bodySize + superviseData.compressSize;
                    this.f1879b.f1841a.recDataSize = this.f1882e + superviseData.recvUncompressSize;
                    this.f1879b.f1841a.reqHeadInflateSize = superviseData.uncompressSize;
                    this.f1879b.f1841a.reqHeadDeflateSize = superviseData.compressSize;
                    this.f1879b.f1841a.reqBodyInflateSize = superviseData.bodySize;
                    this.f1879b.f1841a.reqBodyDeflateSize = superviseData.bodySize;
                    this.f1879b.f1841a.rspHeadDeflateSize = superviseData.recvCompressSize;
                    this.f1879b.f1841a.rspHeadInflateSize = superviseData.recvUncompressSize;
                    this.f1879b.f1841a.rspBodyDeflateSize = superviseData.recvBodySize;
                    this.f1879b.f1841a.rspBodyInflateSize = this.f1882e;
                    if (this.f1879b.f1841a.contentLength == 0) {
                        this.f1879b.f1841a.contentLength = superviseData.originContentLength;
                    }
                    TnetSpdySession.this.q.recvSizeCount += superviseData.recvBodySize + superviseData.recvCompressSize;
                    TnetSpdySession.this.q.sendSizeCount += superviseData.bodySize + superviseData.compressSize;
                }
            } catch (Exception unused) {
            }
        }

        @Override // anet.channel.session.a, org.android.spdy.Spdycb
        public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j2, SpdyByteArray spdyByteArray, Object obj) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", "spdyDataChunkRecvCB", this.f1879b.getSeq(), "len", Integer.valueOf(spdyByteArray.getDataLength()), "fin", Boolean.valueOf(z));
            }
            this.f1882e += spdyByteArray.getDataLength();
            this.f1879b.f1841a.recDataSize += spdyByteArray.getDataLength();
            IHeartbeat iHeartbeat = TnetSpdySession.this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
            if (this.f1880c != null) {
                ByteArray a2 = a.C0012a.f1691a.a(spdyByteArray.getByteArray(), spdyByteArray.getDataLength());
                spdyByteArray.recycle();
                this.f1880c.onDataReceive(a2, z);
            }
            TnetSpdySession.this.handleCallbacks(32, null);
        }

        @Override // anet.channel.session.a, org.android.spdy.Spdycb
        public void spdyOnStreamResponse(SpdySession spdySession, long j2, Map<String, List<String>> map, Object obj) {
            this.f1879b.f1841a.firstDataTime = System.currentTimeMillis() - this.f1879b.f1841a.sendStart;
            this.f1881d = HttpHelper.parseStatusCode(map);
            TnetSpdySession.this.H = 0;
            ALog.i("awcn.TnetSpdySession", "", this.f1879b.getSeq(), HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(this.f1881d));
            ALog.i("awcn.TnetSpdySession", "", this.f1879b.getSeq(), "response headers", map);
            RequestCb requestCb = this.f1880c;
            if (requestCb != null) {
                requestCb.onResponseCode(this.f1881d, HttpHelper.cloneMap(map));
            }
            TnetSpdySession.this.handleCallbacks(16, null);
            this.f1879b.f1841a.contentEncoding = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Encoding");
            this.f1879b.f1841a.contentType = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Type");
            this.f1879b.f1841a.contentLength = HttpHelper.parseContentLength(map);
            this.f1879b.f1841a.serverRT = HttpHelper.parseServerRT(map);
            TnetSpdySession.this.handleResponseCode(this.f1879b, this.f1881d);
            TnetSpdySession.this.handleResponseHeaders(this.f1879b, map);
            IHeartbeat iHeartbeat = TnetSpdySession.this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
        }

        @Override // anet.channel.session.a, org.android.spdy.Spdycb
        public void spdyStreamCloseCallback(SpdySession spdySession, long j2, int i2, Object obj, SuperviseData superviseData) {
            String str;
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", "spdyStreamCloseCallback", this.f1879b.getSeq(), "streamId", Long.valueOf(j2), Constants.KEY_ERROR_CODE, Integer.valueOf(i2));
            }
            if (i2 != 0) {
                this.f1881d = ErrorConstant.ERROR_TNET_REQUEST_FAIL;
                str = ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_REQUEST_FAIL, String.valueOf(i2));
                if (i2 != -2005) {
                    AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_TNET_EXCEPTION, str, this.f1879b.f1841a, null));
                }
                ALog.e("awcn.TnetSpdySession", "spdyStreamCloseCallback error", this.f1879b.getSeq(), com.umeng.analytics.pro.d.aw, TnetSpdySession.this.p, "status code", Integer.valueOf(i2), "URL", this.f1879b.getHttpUrl().simpleUrlString());
            } else {
                str = HttpConstant.SUCCESS;
            }
            this.f1879b.f1841a.tnetErrorCode = i2;
            a(superviseData, this.f1881d, str);
            RequestCb requestCb = this.f1880c;
            if (requestCb != null) {
                requestCb.onFinish(this.f1881d, str, this.f1879b.f1841a);
            }
            if (i2 == -2004) {
                if (!TnetSpdySession.this.y) {
                    TnetSpdySession.this.ping(true);
                }
                if (TnetSpdySession.e(TnetSpdySession.this) >= 2) {
                    ConnEvent connEvent = new ConnEvent();
                    connEvent.isSuccess = false;
                    connEvent.isAccs = TnetSpdySession.this.I;
                    StrategyCenter.getInstance().notifyConnEvent(TnetSpdySession.this.f1624d, TnetSpdySession.this.f1631k, connEvent);
                    TnetSpdySession.this.close(true);
                }
            }
        }
    }

    public TnetSpdySession(Context context, anet.channel.entity.a aVar) {
        super(context, aVar);
        this.y = false;
        this.A = 0L;
        this.H = 0;
        this.B = -1;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.I = false;
    }

    static /* synthetic */ int e(TnetSpdySession tnetSpdySession) {
        int i2 = tnetSpdySession.H + 1;
        tnetSpdySession.H = i2;
        return i2;
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i2) {
    }

    @Override // anet.channel.Session
    public void close() {
        ALog.e("awcn.TnetSpdySession", "force close!", this.p, com.umeng.analytics.pro.d.aw, this);
        notifyStatus(7, null);
        try {
            if (this.D != null) {
                this.D.stop();
                this.D = null;
            }
            if (this.x != null) {
                this.x.closeSession();
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
        return new h(this);
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            ALog.i("awcn.TnetSpdySession", "get sslticket host is null", null, new Object[0]);
            return null;
        }
        try {
            if (this.G == null) {
                return null;
            }
            return this.G.getBytes(this.f1621a, "accs_ssl_key2_" + domain);
        } catch (Throwable th) {
            ALog.e("awcn.TnetSpdySession", "getSSLMeta", null, th, new Object[0]);
            return null;
        }
    }

    public void initConfig(Config config) {
        if (config != null) {
            this.F = config.getAppkey();
            this.G = config.getSecurity();
        }
    }

    public void initSessionInfo(SessionInfo sessionInfo) {
        if (sessionInfo != null) {
            this.C = sessionInfo.dataFrameCb;
            this.E = sessionInfo.auth;
            if (sessionInfo.isKeepAlive) {
                this.q.isKL = 1L;
                this.t = true;
                this.D = sessionInfo.heartbeat;
                boolean z = sessionInfo.isAccs;
                this.I = z;
                if (this.D == null) {
                    if (!z || AwcnConfig.isAccsSessionCreateForbiddenInBg()) {
                        this.D = HeartbeatManager.getDefaultHeartbeat();
                    } else {
                        this.D = HeartbeatManager.getDefaultBackgroundAccsHeartbeat();
                    }
                }
            }
        }
        if (AwcnConfig.isIdleSessionCloseEnable() && this.D == null) {
            this.D = new anet.channel.heartbeat.c();
        }
    }

    @Override // anet.channel.Session
    public boolean isAvailable() {
        return this.n == 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // anet.channel.Session
    public void onDisconnect() {
        this.y = false;
    }

    @Override // anet.channel.Session
    public void ping(boolean z) {
        ping(z, this.s);
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            return -1;
        }
        try {
            if (this.G == null) {
                return -1;
            }
            ISecurity iSecurity = this.G;
            Context context = this.f1621a;
            StringBuilder sb = new StringBuilder();
            sb.append("accs_ssl_key2_");
            sb.append(domain);
            return iSecurity.saveBytes(context, sb.toString(), bArr) ? 0 : -1;
        } catch (Throwable th) {
            ALog.e("awcn.TnetSpdySession", "putSSLMeta", null, th, new Object[0]);
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
            if (this.C == null) {
                return;
            }
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.p, Constants.KEY_DATA_ID, Integer.valueOf(i2), "type", Integer.valueOf(i3));
            if (this.n != 4 || this.x == null) {
                ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.p, "sendCustomFrame con invalid mStatus:" + this.n);
                a(i2, ErrorConstant.ERROR_SESSION_INVALID, true, "session invalid");
                return;
            }
            if (bArr != null && bArr.length > 16384) {
                a(i2, ErrorConstant.ERROR_DATA_TOO_LARGE, false, null);
                return;
            }
            this.x.sendCustomControlFrame(i2, i3, 0, bArr == null ? 0 : bArr.length, bArr);
            this.q.requestCount++;
            this.q.cfRCount++;
            this.z = System.currentTimeMillis();
            if (this.D != null) {
                this.D.reSchedule();
            }
        } catch (SpdyErrorException e2) {
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame error", this.p, e2, new Object[0]);
            a(i2, ErrorConstant.ERROR_TNET_EXCEPTION, true, "SpdyErrorException: " + e2.toString());
        } catch (Exception e3) {
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame error", this.p, e3, new Object[0]);
            a(i2, -101, true, e3.toString());
        }
    }

    public void setTnetPublicKey(int i2) {
        this.B = i2;
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i2, int i3) {
        ALog.e("awcn.TnetSpdySession", "spdyCustomControlFrameFailCallback", this.p, Constants.KEY_DATA_ID, Integer.valueOf(i2));
        a(i2, i3, true, "tnet error");
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i2, int i3, int i4, int i5, byte[] bArr) {
        ALog.e("awcn.TnetSpdySession", "[spdyCustomControlFrameRecvCallback]", this.p, "len", Integer.valueOf(i5), "frameCb", this.C);
        if (ALog.isPrintLog(1) && i5 < 512) {
            String str = "";
            for (byte b2 : bArr) {
                str = str + Integer.toHexString(b2 & f1.f16099c) + c.c.a.b.a.a.f3100g;
            }
            ALog.e("awcn.TnetSpdySession", null, this.p, "str", str);
        }
        DataFrameCb dataFrameCb = this.C;
        if (dataFrameCb != null) {
            dataFrameCb.onDataReceive(this, bArr, i2, i3);
        } else {
            ALog.e("awcn.TnetSpdySession", "AccsFrameCb is null", this.p, new Object[0]);
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(-105, null, "rt"));
        }
        this.q.inceptCount++;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j2, Object obj) {
        if (ALog.isPrintLog(2)) {
            ALog.i("awcn.TnetSpdySession", "ping receive", this.p, "Host", this.f1623c, "id", Long.valueOf(j2));
        }
        if (j2 < 0) {
            return;
        }
        this.y = false;
        this.H = 0;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
        handleCallbacks(128, null);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i2) {
        ALog.e("awcn.TnetSpdySession", "spdySessionCloseCallback", this.p, " errorCode:", Integer.valueOf(i2));
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.stop();
            this.D = null;
        }
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.e("awcn.TnetSpdySession", "session clean up failed!", null, e2, new Object[0]);
            }
        }
        if (i2 == -3516) {
            ConnEvent connEvent = new ConnEvent();
            connEvent.isSuccess = false;
            StrategyCenter.getInstance().notifyConnEvent(this.f1624d, this.f1631k, connEvent);
        }
        notifyStatus(6, new anet.channel.entity.b(2));
        if (superviseConnectInfo != null) {
            SessionStatistic sessionStatistic = this.q;
            sessionStatistic.requestCount = superviseConnectInfo.reused_counter;
            sessionStatistic.liveTime = superviseConnectInfo.keepalive_period_second;
            try {
                if (this.f1630j.isHTTP3()) {
                    if (spdySession != null) {
                        ALog.e("awcn.TnetSpdySession", "[HTTP3 spdySessionCloseCallback]", this.p, "connectInfo", spdySession.getConnectInfoOnDisConnected());
                    }
                    this.q.xqc0RttStatus = superviseConnectInfo.xqc0RttStatus;
                    this.q.retransmissionRate = superviseConnectInfo.retransmissionRate;
                    this.q.lossRate = superviseConnectInfo.lossRate;
                    this.q.tlpCount = superviseConnectInfo.tlpCount;
                    this.q.rtoCount = superviseConnectInfo.rtoCount;
                    this.q.srtt = superviseConnectInfo.srtt;
                }
            } catch (Exception unused) {
            }
        }
        SessionStatistic sessionStatistic2 = this.q;
        if (sessionStatistic2.errorCode == 0) {
            sessionStatistic2.errorCode = i2;
        }
        this.q.lastPingInterval = (int) (System.currentTimeMillis() - this.z);
        AppMonitor.getInstance().commitStat(this.q);
        if (anet.channel.strategy.utils.c.b(this.q.ip)) {
            AppMonitor.getInstance().commitStat(new SessionMonitor(this.q));
        }
        AppMonitor.getInstance().commitAlarm(this.q.getAlarmObject());
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        SessionStatistic sessionStatistic = this.q;
        sessionStatistic.connectionTime = superviseConnectInfo.connectTime;
        sessionStatistic.sslTime = superviseConnectInfo.handshakeTime;
        sessionStatistic.sslCalTime = superviseConnectInfo.doHandshakeTime;
        sessionStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        this.A = System.currentTimeMillis();
        notifyStatus(0, new anet.channel.entity.b(1));
        b();
        ALog.e("awcn.TnetSpdySession", "spdySessionConnectCB connect", this.p, "connectTime", Integer.valueOf(superviseConnectInfo.connectTime), "sslTime", Integer.valueOf(superviseConnectInfo.handshakeTime));
        if (this.f1630j.isHTTP3()) {
            this.q.scid = superviseConnectInfo.scid;
            this.q.dcid = superviseConnectInfo.dcid;
            this.q.congControlKind = superviseConnectInfo.congControlKind;
            ALog.e("awcn.TnetSpdySession", "[HTTP3 spdySessionConnectCB]", this.p, "connectInfo", spdySession.getConnectInfoOnConnected());
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i2, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.e("awcn.TnetSpdySession", "[spdySessionFailedError]session clean up failed!", null, e2, new Object[0]);
            }
        }
        notifyStatus(2, new anet.channel.entity.b(256, i2, "tnet connect fail"));
        ALog.e("awcn.TnetSpdySession", null, this.p, " errorId:", Integer.valueOf(i2));
        SessionStatistic sessionStatistic = this.q;
        sessionStatistic.errorCode = i2;
        sessionStatistic.ret = 0;
        sessionStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        AppMonitor.getInstance().commitStat(this.q);
        if (anet.channel.strategy.utils.c.b(this.q.ip)) {
            AppMonitor.getInstance().commitStat(new SessionMonitor(this.q));
        }
        AppMonitor.getInstance().commitAlarm(this.q.getAlarmObject());
    }

    @Override // anet.channel.Session
    public void ping(boolean z, int i2) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.TnetSpdySession", "ping", this.p, Constants.KEY_HOST, this.f1623c, "thread", Thread.currentThread().getName());
        }
        if (z) {
            try {
                if (this.x == null) {
                    if (this.q != null) {
                        this.q.closeReason = "session null";
                    }
                    ALog.e("awcn.TnetSpdySession", this.f1623c + " session null", this.p, new Object[0]);
                    close();
                    return;
                }
                if (this.n == 0 || this.n == 4) {
                    handleCallbacks(64, null);
                    if (this.y) {
                        return;
                    }
                    this.y = true;
                    this.q.ppkgCount++;
                    this.x.submitPing();
                    if (ALog.isPrintLog(1)) {
                        ALog.d("awcn.TnetSpdySession", this.f1623c + " submit ping ms:" + (System.currentTimeMillis() - this.z) + " force:" + z, this.p, new Object[0]);
                    }
                    setPingTimeout(i2);
                    this.z = System.currentTimeMillis();
                    if (this.D != null) {
                        this.D.reSchedule();
                    }
                }
            } catch (SpdyErrorException e2) {
                if (e2.SpdyErrorGetCode() == -1104 || e2.SpdyErrorGetCode() == -1103) {
                    ALog.e("awcn.TnetSpdySession", "Send request on closed session!!!", this.p, new Object[0]);
                    notifyStatus(6, new anet.channel.entity.b(2));
                }
                ALog.e("awcn.TnetSpdySession", "ping", this.p, e2, new Object[0]);
            } catch (Exception e3) {
                ALog.e("awcn.TnetSpdySession", "ping", this.p, e3, new Object[0]);
            }
        }
    }

    private void c() {
        SpdyAgent.enableDebug = false;
        this.w = SpdyAgent.getInstance(this.f1621a, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        ISecurity iSecurity = this.G;
        if (iSecurity != null && !iSecurity.isSecOff()) {
            this.w.setAccsSslCallback(new j(this));
        }
        if (AwcnConfig.isTnetHeaderCacheEnable()) {
            return;
        }
        try {
            this.w.getClass().getDeclaredMethod("disableHeaderCache", new Class[0]).invoke(this.w, new Object[0]);
            ALog.i("awcn.TnetSpdySession", "tnet disableHeaderCache", null, new Object[0]);
        } catch (Exception e2) {
            ALog.e("awcn.TnetSpdySession", "tnet disableHeaderCache", null, e2, new Object[0]);
        }
    }

    protected void b() {
        IAuth iAuth = this.E;
        if (iAuth != null) {
            iAuth.auth(this, new i(this));
            return;
        }
        notifyStatus(4, null);
        this.q.ret = 1;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.start(this);
        }
    }

    private void a(int i2, int i3, boolean z, String str) {
        DataFrameCb dataFrameCb = this.C;
        if (dataFrameCb != null) {
            dataFrameCb.onException(i2, i3, z, str);
        }
    }
}
