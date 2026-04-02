package anet.channel.session;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.Config;
import anet.channel.DataFrameCb;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.heartbeat.HeartbeatManager;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.security.ISecurity;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.statist.SessionMonitor;
import anet.channel.statist.SessionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.Utils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import i.f1;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: compiled from: Taobao */
    private class a extends anet.channel.session.a {

        /* JADX INFO: renamed from: b */
        private Request f1531b;

        /* JADX INFO: renamed from: c */
        private RequestCb f1532c;

        /* JADX INFO: renamed from: d */
        private int f1533d = 0;

        /* JADX INFO: renamed from: e */
        private long f1534e = 0;

        public a(Request request, RequestCb requestCb) {
            this.f1531b = request;
            this.f1532c = requestCb;
        }

        private void a(SuperviseData superviseData, int i2, String str) {
            try {
                this.f1531b.a.rspEnd = System.currentTimeMillis();
                if (this.f1531b.a.isDone.get()) {
                    return;
                }
                if (i2 > 0) {
                    this.f1531b.a.ret = 1;
                }
                this.f1531b.a.statusCode = i2;
                this.f1531b.a.msg = str;
                if (superviseData != null) {
                    this.f1531b.a.rspEnd = superviseData.responseEnd;
                    this.f1531b.a.sendBeforeTime = superviseData.sendStart - superviseData.requestStart;
                    this.f1531b.a.sendDataTime = superviseData.sendEnd - this.f1531b.a.sendStart;
                    this.f1531b.a.firstDataTime = superviseData.responseStart - superviseData.sendEnd;
                    this.f1531b.a.recDataTime = superviseData.responseEnd - superviseData.responseStart;
                    this.f1531b.a.sendDataSize = superviseData.bodySize + superviseData.compressSize;
                    this.f1531b.a.recDataSize = this.f1534e + ((long) superviseData.recvUncompressSize);
                    this.f1531b.a.reqHeadInflateSize = superviseData.uncompressSize;
                    this.f1531b.a.reqHeadDeflateSize = superviseData.compressSize;
                    this.f1531b.a.reqBodyInflateSize = superviseData.bodySize;
                    this.f1531b.a.reqBodyDeflateSize = superviseData.bodySize;
                    this.f1531b.a.rspHeadDeflateSize = superviseData.recvCompressSize;
                    this.f1531b.a.rspHeadInflateSize = superviseData.recvUncompressSize;
                    this.f1531b.a.rspBodyDeflateSize = superviseData.recvBodySize;
                    this.f1531b.a.rspBodyInflateSize = this.f1534e;
                    if (this.f1531b.a.contentLength == 0) {
                        this.f1531b.a.contentLength = superviseData.originContentLength;
                    }
                    TnetSpdySession.this.q.recvSizeCount += (long) (superviseData.recvBodySize + superviseData.recvCompressSize);
                    TnetSpdySession.this.q.sendSizeCount += (long) (superviseData.bodySize + superviseData.compressSize);
                }
            } catch (Exception unused) {
            }
        }

        @Override // anet.channel.session.a, org.android.spdy.Spdycb
        public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j2, SpdyByteArray spdyByteArray, Object obj) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", "spdyDataChunkRecvCB", this.f1531b.getSeq(), "len", Integer.valueOf(spdyByteArray.getDataLength()), "fin", Boolean.valueOf(z));
            }
            this.f1534e += (long) spdyByteArray.getDataLength();
            this.f1531b.a.recDataSize += (long) spdyByteArray.getDataLength();
            IHeartbeat iHeartbeat = TnetSpdySession.this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
            if (this.f1532c != null) {
                ByteArray byteArrayA = a.C0008a.a.a(spdyByteArray.getByteArray(), spdyByteArray.getDataLength());
                spdyByteArray.recycle();
                this.f1532c.onDataReceive(byteArrayA, z);
            }
            TnetSpdySession.this.handleCallbacks(32, null);
        }

        @Override // anet.channel.session.a, org.android.spdy.Spdycb
        public void spdyOnStreamResponse(SpdySession spdySession, long j2, Map<String, List<String>> map, Object obj) {
            this.f1531b.a.firstDataTime = System.currentTimeMillis() - this.f1531b.a.sendStart;
            this.f1533d = HttpHelper.parseStatusCode(map);
            TnetSpdySession.this.H = 0;
            ALog.i("awcn.TnetSpdySession", "", this.f1531b.getSeq(), HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(this.f1533d));
            ALog.i("awcn.TnetSpdySession", "", this.f1531b.getSeq(), "response headers", map);
            RequestCb requestCb = this.f1532c;
            if (requestCb != null) {
                requestCb.onResponseCode(this.f1533d, HttpHelper.cloneMap(map));
            }
            TnetSpdySession.this.handleCallbacks(16, null);
            this.f1531b.a.contentEncoding = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Encoding");
            this.f1531b.a.contentType = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Type");
            this.f1531b.a.contentLength = HttpHelper.parseContentLength(map);
            this.f1531b.a.serverRT = HttpHelper.parseServerRT(map);
            TnetSpdySession.this.handleResponseCode(this.f1531b, this.f1533d);
            TnetSpdySession.this.handleResponseHeaders(this.f1531b, map);
            IHeartbeat iHeartbeat = TnetSpdySession.this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
        }

        @Override // anet.channel.session.a, org.android.spdy.Spdycb
        public void spdyStreamCloseCallback(SpdySession spdySession, long j2, int i2, Object obj, SuperviseData superviseData) {
            String msg;
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", "spdyStreamCloseCallback", this.f1531b.getSeq(), "streamId", Long.valueOf(j2), Constants.KEY_ERROR_CODE, Integer.valueOf(i2));
            }
            if (i2 != 0) {
                this.f1533d = ErrorConstant.ERROR_TNET_REQUEST_FAIL;
                msg = ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_REQUEST_FAIL, String.valueOf(i2));
                if (i2 != -2005) {
                    AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_TNET_EXCEPTION, msg, this.f1531b.a, null));
                }
                ALog.e("awcn.TnetSpdySession", "spdyStreamCloseCallback error", this.f1531b.getSeq(), com.umeng.analytics.pro.d.aw, TnetSpdySession.this.p, "status code", Integer.valueOf(i2), "URL", this.f1531b.getHttpUrl().simpleUrlString());
            } else {
                msg = HttpConstant.SUCCESS;
            }
            this.f1531b.a.tnetErrorCode = i2;
            a(superviseData, this.f1533d, msg);
            RequestCb requestCb = this.f1532c;
            if (requestCb != null) {
                requestCb.onFinish(this.f1533d, msg, this.f1531b.a);
            }
            if (i2 == -2004) {
                if (!TnetSpdySession.this.y) {
                    TnetSpdySession.this.ping(true);
                }
                if (TnetSpdySession.e(TnetSpdySession.this) >= 2) {
                    ConnEvent connEvent = new ConnEvent();
                    connEvent.isSuccess = false;
                    connEvent.isAccs = TnetSpdySession.this.I;
                    StrategyCenter.getInstance().notifyConnEvent(TnetSpdySession.this.f1346d, TnetSpdySession.this.f1353k, connEvent);
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

    @Override // anet.channel.Session
    public void connect() {
        int xquicCongControl;
        int i2 = this.f1356n;
        int i3 = 1;
        if (i2 == 1 || i2 == 0 || i2 == 4) {
            return;
        }
        try {
            if (this.w == null) {
                c();
            }
            if (anet.channel.util.c.a() && anet.channel.strategy.utils.c.a(this.f1347e)) {
                try {
                    this.f1348f = anet.channel.util.c.a(this.f1347e);
                } catch (Exception unused) {
                }
            }
            String strValueOf = String.valueOf(System.currentTimeMillis());
            ALog.e("awcn.TnetSpdySession", BaseMonitor.ALARM_POINT_CONNECT, this.p, Constants.KEY_HOST, this.f1345c, "ip", this.f1348f, "port", Integer.valueOf(this.f1349g), "sessionId", strValueOf, "SpdyProtocol,", this.f1352j, "proxyIp,", this.f1350h, "proxyPort,", Integer.valueOf(this.f1351i));
            SessionInfo sessionInfo = new SessionInfo(this.f1348f, this.f1349g, this.f1345c + d.c.a.b.a.a.s1 + this.F, this.f1350h, this.f1351i, strValueOf, this, this.f1352j.getTnetConType());
            sessionInfo.setConnectionTimeoutMs((int) (((float) this.r) * Utils.getNetworkTimeFactor()));
            if (this.f1352j.isPublicKeyAuto() || this.f1352j.isH2S() || this.f1352j.isHTTP3()) {
                sessionInfo.setCertHost(this.f1355m ? this.f1347e : this.f1346d);
            } else if (this.B >= 0) {
                sessionInfo.setPubKeySeqNum(this.B);
            } else {
                this.B = this.f1352j.getTnetPublicKey(this.G != null ? this.G.isSecOff() : true);
                sessionInfo.setPubKeySeqNum(this.B);
            }
            if (this.f1352j.isHTTP3() && (xquicCongControl = AwcnConfig.getXquicCongControl()) >= 0) {
                sessionInfo.setXquicCongControl(xquicCongControl);
            }
            this.x = this.w.createSession(sessionInfo);
            if (this.x.getRefCount() > 1) {
                ALog.e("awcn.TnetSpdySession", "get session ref count > 1!!!", this.p, new Object[0]);
                notifyStatus(0, new anet.channel.entity.b(1));
                b();
                return;
            }
            notifyStatus(1, null);
            this.z = System.currentTimeMillis();
            SessionStatistic sessionStatistic = this.q;
            if (TextUtils.isEmpty(this.f1350h)) {
                i3 = 0;
            }
            sessionStatistic.isProxy = i3;
            this.q.isTunnel = b.a.u.a.f1909k;
            this.q.isBackground = GlobalAppRuntimeInfo.isAppBackground();
            this.A = 0L;
        } catch (Throwable th) {
            notifyStatus(2, null);
            ALog.e("awcn.TnetSpdySession", "connect exception ", this.p, th, new Object[0]);
        }
    }

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
            return this.G.getBytes(this.a, "accs_ssl_key2_" + domain);
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

    public void initSessionInfo(anet.channel.SessionInfo sessionInfo) {
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
        return this.f1356n == 4;
    }

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
            Context context = this.a;
            StringBuilder sb = new StringBuilder();
            sb.append("accs_ssl_key2_");
            sb.append(domain);
            return iSecurity.saveBytes(context, sb.toString(), bArr) ? 0 : -1;
        } catch (Throwable th) {
            ALog.e("awcn.TnetSpdySession", "putSSLMeta", null, th, new Object[0]);
            return -1;
        }
    }

    @Override // anet.channel.Session
    public Cancelable request(Request request, RequestCb requestCb) {
        String str;
        SpdyRequest spdyRequest;
        anet.channel.request.c cVar = anet.channel.request.c.NULL;
        RequestStatistic requestStatistic = request != null ? request.a : new RequestStatistic(this.f1346d, null);
        requestStatistic.setConnType(this.f1352j);
        if (requestStatistic.start == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            requestStatistic.reqStart = jCurrentTimeMillis;
            requestStatistic.start = jCurrentTimeMillis;
        }
        requestStatistic.setIPAndPort(this.f1348f, this.f1349g);
        requestStatistic.ipRefer = this.f1353k.getIpSource();
        requestStatistic.ipType = this.f1353k.getIpType();
        requestStatistic.unit = this.f1354l;
        if (request == null || requestCb == null) {
            if (requestCb != null) {
                requestCb.onFinish(-102, ErrorConstant.getErrMsg(-102), requestStatistic);
            }
            return cVar;
        }
        try {
            if (this.x == null || !(this.f1356n == 0 || this.f1356n == 4)) {
                requestCb.onFinish(ErrorConstant.ERROR_SESSION_INVALID, ErrorConstant.getErrMsg(ErrorConstant.ERROR_SESSION_INVALID), request.a);
                return cVar;
            }
            if (this.f1355m) {
                request.setDnsOptimize(this.f1347e, this.f1349g);
            }
            request.setUrlScheme(this.f1352j.isSSL());
            URL url = request.getUrl();
            if (ALog.isPrintLog(2)) {
                ALog.i("awcn.TnetSpdySession", "", request.getSeq(), "request URL", url.toString());
                ALog.i("awcn.TnetSpdySession", "", request.getSeq(), "request Method", request.getMethod());
                ALog.i("awcn.TnetSpdySession", "", request.getSeq(), "request headers", request.getHeaders());
            }
            if (TextUtils.isEmpty(this.f1350h) || this.f1351i <= 0) {
                str = "";
                spdyRequest = new SpdyRequest(url, request.getMethod(), RequestPriority.DEFAULT_PRIORITY, -1, request.getConnectTimeout());
            } else {
                str = "";
                spdyRequest = new SpdyRequest(url, url.getHost(), url.getPort(), this.f1350h, this.f1351i, request.getMethod(), RequestPriority.DEFAULT_PRIORITY, -1, request.getConnectTimeout(), 0);
            }
            spdyRequest.setRequestRdTimeoutMs(request.getReadTimeout());
            Map<String, String> headers = request.getHeaders();
            if (headers.containsKey("Host")) {
                HashMap map = new HashMap(request.getHeaders());
                String strRemove = map.remove("Host");
                if (this.f1355m) {
                    strRemove = this.f1347e;
                }
                map.put(":host", strRemove);
                spdyRequest.addHeaders(map);
            } else {
                spdyRequest.addHeaders(headers);
                spdyRequest.addHeader(":host", this.f1355m ? this.f1347e : request.getHost());
            }
            SpdyDataProvider spdyDataProvider = new SpdyDataProvider(request.getBodyBytes());
            request.a.sendStart = System.currentTimeMillis();
            request.a.processTime = request.a.sendStart - request.a.start;
            int iSubmitRequest = this.x.submitRequest(spdyRequest, spdyDataProvider, this, new a(request, requestCb));
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", str, request.getSeq(), "streamId", Integer.valueOf(iSubmitRequest));
            }
            anet.channel.request.c cVar2 = new anet.channel.request.c(this.x, iSubmitRequest, request.getSeq());
            try {
                this.q.requestCount++;
                this.q.stdRCount++;
                this.z = System.currentTimeMillis();
                if (this.D != null) {
                    this.D.reSchedule();
                }
                return cVar2;
            } catch (SpdyErrorException e2) {
                e = e2;
                cVar = cVar2;
                if (e.SpdyErrorGetCode() == -1104 || e.SpdyErrorGetCode() == -1103) {
                    ALog.e("awcn.TnetSpdySession", "Send request on closed session!!!", this.p, new Object[0]);
                    notifyStatus(6, new anet.channel.entity.b(2));
                }
                requestCb.onFinish(ErrorConstant.ERROR_TNET_EXCEPTION, ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_EXCEPTION, String.valueOf(e.SpdyErrorGetCode())), requestStatistic);
                return cVar;
            } catch (Exception unused) {
                cVar = cVar2;
                requestCb.onFinish(-101, ErrorConstant.getErrMsg(-101), requestStatistic);
                return cVar;
            }
        } catch (SpdyErrorException e3) {
            e = e3;
        } catch (Exception unused2) {
        }
    }

    @Override // anet.channel.Session
    public void sendCustomFrame(int i2, byte[] bArr, int i3) {
        try {
            if (this.C == null) {
                return;
            }
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.p, Constants.KEY_DATA_ID, Integer.valueOf(i2), "type", Integer.valueOf(i3));
            if (this.f1356n != 4 || this.x == null) {
                ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.p, "sendCustomFrame con invalid mStatus:" + this.f1356n);
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
                str = str + Integer.toHexString(b2 & f1.f12066c) + d.c.a.b.a.a.f10074g;
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
            ALog.i("awcn.TnetSpdySession", "ping receive", this.p, "Host", this.f1345c, "id", Long.valueOf(j2));
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
            StrategyCenter.getInstance().notifyConnEvent(this.f1346d, this.f1353k, connEvent);
        }
        notifyStatus(6, new anet.channel.entity.b(2));
        if (superviseConnectInfo != null) {
            SessionStatistic sessionStatistic = this.q;
            sessionStatistic.requestCount = superviseConnectInfo.reused_counter;
            sessionStatistic.liveTime = superviseConnectInfo.keepalive_period_second;
            try {
                if (this.f1352j.isHTTP3()) {
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
        if (this.f1352j.isHTTP3()) {
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
            ALog.d("awcn.TnetSpdySession", "ping", this.p, Constants.KEY_HOST, this.f1345c, "thread", Thread.currentThread().getName());
        }
        if (z) {
            try {
                if (this.x == null) {
                    if (this.q != null) {
                        this.q.closeReason = "session null";
                    }
                    ALog.e("awcn.TnetSpdySession", this.f1345c + " session null", this.p, new Object[0]);
                    close();
                    return;
                }
                if (this.f1356n == 0 || this.f1356n == 4) {
                    handleCallbacks(64, null);
                    if (this.y) {
                        return;
                    }
                    this.y = true;
                    this.q.ppkgCount++;
                    this.x.submitPing();
                    if (ALog.isPrintLog(1)) {
                        ALog.d("awcn.TnetSpdySession", this.f1345c + " submit ping ms:" + (System.currentTimeMillis() - this.z) + " force:" + z, this.p, new Object[0]);
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
        this.w = SpdyAgent.getInstance(this.a, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
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
