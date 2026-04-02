package b.a.t;

import android.support.v4.media.session.PlaybackStateCompat;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.entity.ConnType;
import anet.channel.flow.FlowStat;
import anet.channel.flow.NetworkAnalysis;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.HttpUrl;
import anetwork.channel.aidl.DefaultFinishEvent;
import b.a.j.a;
import b.a.t.g;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class k implements RequestCb {
    final /* synthetic */ Request a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f1890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ g f1891c;

    k(g gVar, Request request, RequestStatistic requestStatistic) {
        this.f1891c = gVar;
        this.a = request;
        this.f1890b = requestStatistic;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
        if (this.f1891c.f1871h.get()) {
            return;
        }
        g gVar = this.f1891c;
        if (gVar.f1873j == 0) {
            ALog.i(g.f1864n, "[onDataReceive] receive first data chunk!", gVar.a.f1893c, new Object[0]);
        }
        if (z) {
            ALog.i(g.f1864n, "[onDataReceive] receive last data chunk!", this.f1891c.a.f1893c, new Object[0]);
        }
        g gVar2 = this.f1891c;
        gVar2.f1873j++;
        try {
            if (gVar2.f1876m != null) {
                gVar2.f1876m.f1878c.add(byteArray);
                if (this.f1890b.recDataSize > PlaybackStateCompat.ACTION_PREPARE_FROM_URI || z) {
                    this.f1891c.f1873j = this.f1891c.f1876m.a(this.f1891c.a.f1892b, this.f1891c.f1872i);
                    this.f1891c.f1874k = true;
                    this.f1891c.f1875l = this.f1891c.f1873j > 1;
                    this.f1891c.f1876m = null;
                }
            } else {
                gVar2.a.f1892b.a(gVar2.f1873j, gVar2.f1872i, byteArray);
                this.f1891c.f1875l = true;
            }
            if (this.f1891c.f1867d != null) {
                this.f1891c.f1867d.write(byteArray.getBuffer(), 0, byteArray.getDataLength());
                if (z) {
                    String strG = this.f1891c.a.a.g();
                    this.f1891c.f1866c.data = this.f1891c.f1867d.toByteArray();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    this.f1891c.f1865b.put(strG, this.f1891c.f1866c);
                    ALog.i(g.f1864n, "write cache", this.f1891c.a.f1893c, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "size", Integer.valueOf(this.f1891c.f1866c.data.length), "key", strG);
                }
            }
        } catch (Exception e2) {
            ALog.w(g.f1864n, "[onDataReceive] error.", this.f1891c.a.f1893c, e2, new Object[0]);
        }
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        String strValueOf;
        DefaultFinishEvent defaultFinishEvent;
        if (this.f1891c.f1871h.getAndSet(true)) {
            return;
        }
        int i3 = 3;
        if (ALog.isPrintLog(2)) {
            ALog.i(g.f1864n, "[onFinish]", this.f1891c.a.f1893c, "code", Integer.valueOf(i2), "msg", str);
        }
        if (i2 < 0) {
            try {
                if (this.f1891c.a.a.d()) {
                    if (!this.f1891c.f1874k && !this.f1891c.f1875l) {
                        ALog.e(g.f1864n, "clear response buffer and retry", this.f1891c.a.f1893c, new Object[0]);
                        if (this.f1891c.f1876m != null) {
                            if (!this.f1891c.f1876m.f1878c.isEmpty()) {
                                i3 = 4;
                            }
                            requestStatistic.roaming = i3;
                            this.f1891c.f1876m.a();
                            this.f1891c.f1876m = null;
                        }
                        if (this.f1891c.a.a.f1790e == 0) {
                            requestStatistic.firstProtocol = requestStatistic.protocolType;
                            requestStatistic.firstErrorCode = requestStatistic.tnetErrorCode != 0 ? requestStatistic.tnetErrorCode : i2;
                        }
                        this.f1891c.a.a.k();
                        this.f1891c.a.f1894d = new AtomicBoolean();
                        this.f1891c.a.f1895e = new g(this.f1891c.a, this.f1891c.f1865b, this.f1891c.f1866c);
                        if (requestStatistic.tnetErrorCode != 0) {
                            strValueOf = i2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + requestStatistic.protocolType + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + requestStatistic.tnetErrorCode;
                            requestStatistic.tnetErrorCode = 0;
                        } else {
                            strValueOf = String.valueOf(i2);
                        }
                        requestStatistic.appendErrorTrace(strValueOf);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        requestStatistic.retryCostTime += jCurrentTimeMillis - requestStatistic.start;
                        requestStatistic.start = jCurrentTimeMillis;
                        ThreadPoolExecutorFactory.submitPriorityTask(this.f1891c.a.f1895e, ThreadPoolExecutorFactory.Priority.HIGH);
                        return;
                    }
                    requestStatistic.msg += ":\u56de\u8c03\u540e\u89e6\u53d1\u91cd\u8bd5";
                    if (this.f1891c.f1875l) {
                        requestStatistic.roaming = 2;
                    } else if (this.f1891c.f1874k) {
                        requestStatistic.roaming = 1;
                    }
                    ALog.e(g.f1864n, "Cannot retry request after onHeader/onDataReceived callback!", this.f1891c.a.f1893c, new Object[0]);
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (this.f1891c.f1876m != null) {
            this.f1891c.f1876m.a(this.f1891c.a.f1892b, this.f1891c.f1872i);
        }
        this.f1891c.a.a();
        requestStatistic.isDone.set(true);
        if (this.f1891c.a.a.j() && requestStatistic.contentLength != 0 && requestStatistic.contentLength != requestStatistic.rspBodyDeflateSize) {
            requestStatistic.ret = 0;
            requestStatistic.statusCode = ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH;
            str = ErrorConstant.getErrMsg(ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH);
            requestStatistic.msg = str;
            ALog.e(g.f1864n, "received data length not match with content-length", this.f1891c.a.f1893c, "content-length", Integer.valueOf(this.f1891c.f1872i), "recDataLength", Long.valueOf(requestStatistic.rspBodyDeflateSize));
            ExceptionStatistic exceptionStatistic = new ExceptionStatistic(ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH, str, "rt");
            exceptionStatistic.url = this.f1891c.a.a.g();
            AppMonitor.getInstance().commitStat(exceptionStatistic);
            i2 = ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH;
        }
        if (i2 != 304 || this.f1891c.f1866c == null) {
            defaultFinishEvent = new DefaultFinishEvent(i2, str, this.a);
        } else {
            requestStatistic.protocolType = "cache";
            defaultFinishEvent = new DefaultFinishEvent(200, str, this.a);
        }
        this.f1891c.a.f1892b.a(defaultFinishEvent);
        if (i2 >= 0) {
            anet.channel.monitor.b.a().a(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.rspHeadDeflateSize + requestStatistic.rspBodyDeflateSize);
        } else {
            requestStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        }
        NetworkAnalysis.getInstance().commitFlow(new FlowStat(this.f1891c.f1868e, requestStatistic));
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        String singleHeaderFieldByKey;
        if (this.f1891c.f1871h.get()) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i(g.f1864n, "onResponseCode", this.a.getSeq(), "code", Integer.valueOf(i2));
            ALog.i(g.f1864n, "onResponseCode", this.a.getSeq(), "headers", map);
        }
        if (HttpHelper.checkRedirect(this.a, i2) && (singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, "Location")) != null) {
            HttpUrl httpUrl = HttpUrl.parse(singleHeaderFieldByKey);
            if (httpUrl != null) {
                if (this.f1891c.f1871h.compareAndSet(false, true)) {
                    httpUrl.lockScheme();
                    this.f1891c.a.a.a(httpUrl);
                    this.f1891c.a.f1894d = new AtomicBoolean();
                    l lVar = this.f1891c.a;
                    lVar.f1895e = new g(lVar, null, null);
                    this.f1890b.recordRedirect(i2, httpUrl.simpleUrlString());
                    this.f1890b.locationUrl = singleHeaderFieldByKey;
                    ThreadPoolExecutorFactory.submitPriorityTask(this.f1891c.a.f1895e, ThreadPoolExecutorFactory.Priority.HIGH);
                    return;
                }
                return;
            }
            ALog.e(g.f1864n, "redirect url is invalid!", this.a.getSeq(), "redirect url", singleHeaderFieldByKey);
        }
        try {
            this.f1891c.a.a();
            b.a.l.a.a(this.f1891c.a.a.g(), map);
            this.f1891c.f1872i = HttpHelper.parseContentLength(map);
            String strG = this.f1891c.a.a.g();
            if (this.f1891c.f1866c != null && i2 == 304) {
                this.f1891c.f1866c.responseHeaders.putAll(map);
                a.C0022a c0022aA = b.a.j.d.a(map);
                if (c0022aA != null && c0022aA.ttl > this.f1891c.f1866c.ttl) {
                    this.f1891c.f1866c.ttl = c0022aA.ttl;
                }
                this.f1891c.a.f1892b.onResponseCode(200, this.f1891c.f1866c.responseHeaders);
                this.f1891c.a.f1892b.a(1, this.f1891c.f1866c.data.length, ByteArray.wrap(this.f1891c.f1866c.data));
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.f1891c.f1865b.put(strG, this.f1891c.f1866c);
                ALog.i(g.f1864n, "update cache", this.f1891c.a.f1893c, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "key", strG);
                return;
            }
            if (this.f1891c.f1865b != null) {
                if ("no-store".equals(HttpHelper.getSingleHeaderFieldByKey(map, "Cache-Control"))) {
                    this.f1891c.f1865b.remove(strG);
                } else {
                    g gVar = this.f1891c;
                    a.C0022a c0022aA2 = b.a.j.d.a(map);
                    gVar.f1866c = c0022aA2;
                    if (c0022aA2 != null) {
                        HttpHelper.removeHeaderFiledByKey(map, "Cache-Control");
                        map.put("Cache-Control", Arrays.asList("no-store"));
                        this.f1891c.f1867d = new ByteArrayOutputStream(this.f1891c.f1872i != 0 ? this.f1891c.f1872i : 5120);
                    }
                }
            }
            map.put(HttpConstant.X_PROTOCOL, Arrays.asList(this.f1890b.protocolType));
            if (!ConnType.PK_OPEN.equalsIgnoreCase(HttpHelper.getSingleHeaderFieldByKey(map, HttpConstant.STREAMING_PARSER)) && b.a.k.b.p() && this.f1891c.f1872i <= 131072) {
                this.f1891c.f1876m = new g.a(i2, map);
            } else {
                this.f1891c.a.f1892b.onResponseCode(i2, map);
                this.f1891c.f1874k = true;
            }
        } catch (Exception e2) {
            ALog.w(g.f1864n, "[onResponseCode] error.", this.f1891c.a.f1893c, e2, new Object[0]);
        }
    }
}
