package p000a.p001a.p013t;

import android.support.v4.media.session.PlaybackStateCompat;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.entity.ConnType;
import anet.channel.flow.FlowStat;
import anet.channel.flow.NetworkAnalysis;
import anet.channel.monitor.C0796b;
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
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.p001a.p002j.C0012d;
import p000a.p001a.p002j.InterfaceC0009a;
import p000a.p001a.p003k.C0014b;
import p000a.p001a.p004l.C0015a;
import p000a.p001a.p013t.C0042g;

/* compiled from: Taobao */
/* renamed from: a.a.t.k */
/* loaded from: classes.dex */
class C0046k implements RequestCb {

    /* renamed from: a */
    final /* synthetic */ Request f132a;

    /* renamed from: b */
    final /* synthetic */ RequestStatistic f133b;

    /* renamed from: c */
    final /* synthetic */ C0042g f134c;

    C0046k(C0042g c0042g, Request request, RequestStatistic requestStatistic) {
        this.f134c = c0042g;
        this.f132a = request;
        this.f133b = requestStatistic;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
        if (this.f134c.f109h.get()) {
            return;
        }
        C0042g c0042g = this.f134c;
        if (c0042g.f111j == 0) {
            ALog.m716i(C0042g.f100n, "[onDataReceive] receive first data chunk!", c0042g.f102a.f137c, new Object[0]);
        }
        if (z) {
            ALog.m716i(C0042g.f100n, "[onDataReceive] receive last data chunk!", this.f134c.f102a.f137c, new Object[0]);
        }
        C0042g c0042g2 = this.f134c;
        c0042g2.f111j++;
        try {
            if (c0042g2.f114m != null) {
                c0042g2.f114m.f117c.add(byteArray);
                if (this.f133b.recDataSize > PlaybackStateCompat.ACTION_PREPARE_FROM_URI || z) {
                    this.f134c.f111j = this.f134c.f114m.m195a(this.f134c.f102a.f136b, this.f134c.f110i);
                    this.f134c.f112k = true;
                    this.f134c.f113l = this.f134c.f111j > 1;
                    this.f134c.f114m = null;
                }
            } else {
                c0042g2.f102a.f136b.mo150a(c0042g2.f111j, c0042g2.f110i, byteArray);
                this.f134c.f113l = true;
            }
            if (this.f134c.f105d != null) {
                this.f134c.f105d.write(byteArray.getBuffer(), 0, byteArray.getDataLength());
                if (z) {
                    String m833g = this.f134c.f102a.f135a.m833g();
                    this.f134c.f104c.data = this.f134c.f105d.toByteArray();
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f134c.f103b.put(m833g, this.f134c.f104c);
                    ALog.m716i(C0042g.f100n, "write cache", this.f134c.f102a.f137c, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "size", Integer.valueOf(this.f134c.f104c.data.length), "key", m833g);
                }
            }
        } catch (Exception e2) {
            ALog.m717w(C0042g.f100n, "[onDataReceive] error.", this.f134c.f102a.f137c, e2, new Object[0]);
        }
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        String valueOf;
        DefaultFinishEvent defaultFinishEvent;
        if (this.f134c.f109h.getAndSet(true)) {
            return;
        }
        int i3 = 3;
        if (ALog.isPrintLog(2)) {
            ALog.m716i(C0042g.f100n, "[onFinish]", this.f134c.f102a.f137c, "code", Integer.valueOf(i2), "msg", str);
        }
        if (i2 < 0) {
            try {
                if (this.f134c.f102a.f135a.m830d()) {
                    if (!this.f134c.f112k && !this.f134c.f113l) {
                        ALog.m715e(C0042g.f100n, "clear response buffer and retry", this.f134c.f102a.f137c, new Object[0]);
                        if (this.f134c.f114m != null) {
                            if (!this.f134c.f114m.f117c.isEmpty()) {
                                i3 = 4;
                            }
                            requestStatistic.roaming = i3;
                            this.f134c.f114m.m196a();
                            this.f134c.f114m = null;
                        }
                        if (this.f134c.f102a.f135a.f1363e == 0) {
                            requestStatistic.firstProtocol = requestStatistic.protocolType;
                            requestStatistic.firstErrorCode = requestStatistic.tnetErrorCode != 0 ? requestStatistic.tnetErrorCode : i2;
                        }
                        this.f134c.f102a.f135a.m837k();
                        this.f134c.f102a.f138d = new AtomicBoolean();
                        this.f134c.f102a.f139e = new C0042g(this.f134c.f102a, this.f134c.f103b, this.f134c.f104c);
                        if (requestStatistic.tnetErrorCode != 0) {
                            valueOf = i2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + requestStatistic.protocolType + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + requestStatistic.tnetErrorCode;
                            requestStatistic.tnetErrorCode = 0;
                        } else {
                            valueOf = String.valueOf(i2);
                        }
                        requestStatistic.appendErrorTrace(valueOf);
                        long currentTimeMillis = System.currentTimeMillis();
                        requestStatistic.retryCostTime += currentTimeMillis - requestStatistic.start;
                        requestStatistic.start = currentTimeMillis;
                        ThreadPoolExecutorFactory.submitPriorityTask(this.f134c.f102a.f139e, ThreadPoolExecutorFactory.Priority.HIGH);
                        return;
                    }
                    requestStatistic.msg += ":回调后触发重试";
                    if (this.f134c.f113l) {
                        requestStatistic.roaming = 2;
                    } else if (this.f134c.f112k) {
                        requestStatistic.roaming = 1;
                    }
                    ALog.m715e(C0042g.f100n, "Cannot retry request after onHeader/onDataReceived callback!", this.f134c.f102a.f137c, new Object[0]);
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (this.f134c.f114m != null) {
            this.f134c.f114m.m195a(this.f134c.f102a.f136b, this.f134c.f110i);
        }
        this.f134c.f102a.m197a();
        requestStatistic.isDone.set(true);
        if (this.f134c.f102a.f135a.m836j() && requestStatistic.contentLength != 0 && requestStatistic.contentLength != requestStatistic.rspBodyDeflateSize) {
            requestStatistic.ret = 0;
            requestStatistic.statusCode = ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH;
            str = ErrorConstant.getErrMsg(ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH);
            requestStatistic.msg = str;
            ALog.m715e(C0042g.f100n, "received data length not match with content-length", this.f134c.f102a.f137c, "content-length", Integer.valueOf(this.f134c.f110i), "recDataLength", Long.valueOf(requestStatistic.rspBodyDeflateSize));
            ExceptionStatistic exceptionStatistic = new ExceptionStatistic(ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH, str, "rt");
            exceptionStatistic.url = this.f134c.f102a.f135a.m833g();
            AppMonitor.getInstance().commitStat(exceptionStatistic);
            i2 = ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH;
        }
        if (i2 != 304 || this.f134c.f104c == null) {
            defaultFinishEvent = new DefaultFinishEvent(i2, str, this.f132a);
        } else {
            requestStatistic.protocolType = "cache";
            defaultFinishEvent = new DefaultFinishEvent(200, str, this.f132a);
        }
        this.f134c.f102a.f136b.mo151a(defaultFinishEvent);
        if (i2 >= 0) {
            C0796b.m526a().m531a(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.rspHeadDeflateSize + requestStatistic.rspBodyDeflateSize);
        } else {
            requestStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        }
        NetworkAnalysis.getInstance().commitFlow(new FlowStat(this.f134c.f106e, requestStatistic));
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        String singleHeaderFieldByKey;
        if (this.f134c.f109h.get()) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.m716i(C0042g.f100n, "onResponseCode", this.f132a.getSeq(), "code", Integer.valueOf(i2));
            ALog.m716i(C0042g.f100n, "onResponseCode", this.f132a.getSeq(), "headers", map);
        }
        if (HttpHelper.checkRedirect(this.f132a, i2) && (singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, "Location")) != null) {
            HttpUrl parse = HttpUrl.parse(singleHeaderFieldByKey);
            if (parse != null) {
                if (this.f134c.f109h.compareAndSet(false, true)) {
                    parse.lockScheme();
                    this.f134c.f102a.f135a.m827a(parse);
                    this.f134c.f102a.f138d = new AtomicBoolean();
                    C0047l c0047l = this.f134c.f102a;
                    c0047l.f139e = new C0042g(c0047l, null, null);
                    this.f133b.recordRedirect(i2, parse.simpleUrlString());
                    this.f133b.locationUrl = singleHeaderFieldByKey;
                    ThreadPoolExecutorFactory.submitPriorityTask(this.f134c.f102a.f139e, ThreadPoolExecutorFactory.Priority.HIGH);
                    return;
                }
                return;
            }
            ALog.m715e(C0042g.f100n, "redirect url is invalid!", this.f132a.getSeq(), "redirect url", singleHeaderFieldByKey);
        }
        try {
            this.f134c.f102a.m197a();
            C0015a.m118a(this.f134c.f102a.f135a.m833g(), map);
            this.f134c.f110i = HttpHelper.parseContentLength(map);
            String m833g = this.f134c.f102a.f135a.m833g();
            if (this.f134c.f104c != null && i2 == 304) {
                this.f134c.f104c.responseHeaders.putAll(map);
                InterfaceC0009a.a m62a = C0012d.m62a(map);
                if (m62a != null && m62a.ttl > this.f134c.f104c.ttl) {
                    this.f134c.f104c.ttl = m62a.ttl;
                }
                this.f134c.f102a.f136b.onResponseCode(200, this.f134c.f104c.responseHeaders);
                this.f134c.f102a.f136b.mo150a(1, this.f134c.f104c.data.length, ByteArray.wrap(this.f134c.f104c.data));
                long currentTimeMillis = System.currentTimeMillis();
                this.f134c.f103b.put(m833g, this.f134c.f104c);
                ALog.m716i(C0042g.f100n, "update cache", this.f134c.f102a.f137c, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "key", m833g);
                return;
            }
            if (this.f134c.f103b != null) {
                if ("no-store".equals(HttpHelper.getSingleHeaderFieldByKey(map, "Cache-Control"))) {
                    this.f134c.f103b.remove(m833g);
                } else {
                    C0042g c0042g = this.f134c;
                    InterfaceC0009a.a m62a2 = C0012d.m62a(map);
                    c0042g.f104c = m62a2;
                    if (m62a2 != null) {
                        HttpHelper.removeHeaderFiledByKey(map, "Cache-Control");
                        map.put("Cache-Control", Arrays.asList("no-store"));
                        this.f134c.f105d = new ByteArrayOutputStream(this.f134c.f110i != 0 ? this.f134c.f110i : 5120);
                    }
                }
            }
            map.put(HttpConstant.X_PROTOCOL, Arrays.asList(this.f133b.protocolType));
            if (!ConnType.PK_OPEN.equalsIgnoreCase(HttpHelper.getSingleHeaderFieldByKey(map, HttpConstant.STREAMING_PARSER)) && C0014b.m110p() && this.f134c.f110i <= 131072) {
                this.f134c.f114m = new C0042g.a(i2, map);
            } else {
                this.f134c.f102a.f136b.onResponseCode(i2, map);
                this.f134c.f112k = true;
            }
        } catch (Exception e2) {
            ALog.m717w(C0042g.f100n, "[onResponseCode] error.", this.f134c.f102a.f137c, e2, new Object[0]);
        }
    }
}
