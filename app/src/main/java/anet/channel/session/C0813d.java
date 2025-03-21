package anet.channel.session;

import android.content.Context;
import anet.channel.AwcnConfig;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.entity.C0781a;
import anet.channel.entity.C0782b;
import anet.channel.entity.ConnType;
import anet.channel.request.C0803b;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.utils.C0848c;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.C0857c;
import anet.channel.util.C0862h;
import anet.channel.util.C0864j;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.Utils;
import com.taobao.accs.common.Constants;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
/* renamed from: anet.channel.session.d */
/* loaded from: classes.dex */
public class C0813d extends Session {

    /* renamed from: w */
    private SSLSocketFactory f987w;

    public C0813d(Context context, C0781a c0781a) {
        super(context, c0781a);
        if (this.f693k == null) {
            String str = this.f685c;
            this.f692j = (str == null || !str.startsWith(HttpConstant.HTTPS)) ? ConnType.HTTP : ConnType.HTTPS;
        } else if (AwcnConfig.isHttpsSniEnable() && this.f692j.equals(ConnType.HTTPS)) {
            this.f987w = new C0864j(this.f686d);
        }
    }

    @Override // anet.channel.Session
    public void close() {
        notifyStatus(6, null);
    }

    @Override // anet.channel.Session
    public void connect() {
        try {
            if (this.f693k != null && this.f693k.getIpSource() == 1) {
                notifyStatus(4, new C0782b(1));
                return;
            }
            Request.Builder redirectEnable = new Request.Builder().setUrl(this.f685c).setSeq(this.f698p).setConnectTimeout((int) (this.f700r * Utils.getNetworkTimeFactor())).setReadTimeout((int) (this.f701s * Utils.getNetworkTimeFactor())).setRedirectEnable(false);
            if (this.f987w != null) {
                redirectEnable.setSslSocketFactory(this.f987w);
            }
            if (this.f695m) {
                redirectEnable.addHeader("Host", this.f687e);
            }
            if (C0857c.m723a() && C0848c.m707a(this.f687e)) {
                try {
                    this.f688f = C0857c.m721a(this.f687e);
                } catch (Exception unused) {
                }
            }
            ALog.m716i("awcn.HttpSession", "HttpSession connect", null, Constants.KEY_HOST, this.f685c, "ip", this.f688f, "port", Integer.valueOf(this.f689g));
            Request build = redirectEnable.build();
            build.setDnsOptimize(this.f688f, this.f689g);
            ThreadPoolExecutorFactory.submitPriorityTask(new RunnableC0814e(this, build), ThreadPoolExecutorFactory.Priority.LOW);
        } catch (Throwable th) {
            ALog.m714e("awcn.HttpSession", "HTTP connect fail.", null, th, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // anet.channel.Session
    public Runnable getRecvTimeOutRunnable() {
        return null;
    }

    @Override // anet.channel.Session
    public boolean isAvailable() {
        return this.f696n == 4;
    }

    @Override // anet.channel.Session
    public Cancelable request(Request request, RequestCb requestCb) {
        C0803b c0803b = C0803b.NULL;
        Request.Builder builder = null;
        RequestStatistic requestStatistic = request != null ? request.f916a : new RequestStatistic(this.f686d, null);
        requestStatistic.setConnType(this.f692j);
        if (requestStatistic.start == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            requestStatistic.reqStart = currentTimeMillis;
            requestStatistic.start = currentTimeMillis;
        }
        if (request == null || requestCb == null) {
            if (requestCb != null) {
                requestCb.onFinish(-102, ErrorConstant.getErrMsg(-102), requestStatistic);
            }
            return c0803b;
        }
        try {
            if (request.getSslSocketFactory() == null && this.f987w != null) {
                builder = request.newBuilder().setSslSocketFactory(this.f987w);
            }
            if (this.f695m) {
                if (builder == null) {
                    builder = request.newBuilder();
                }
                builder.addHeader("Host", this.f687e);
            }
            if (builder != null) {
                request = builder.build();
            }
            if (this.f688f == null) {
                String host = request.getHttpUrl().host();
                if (C0857c.m723a() && C0848c.m707a(host)) {
                    try {
                        this.f688f = C0857c.m721a(host);
                    } catch (Exception unused) {
                    }
                }
            }
            request.setDnsOptimize(this.f688f, this.f689g);
            request.setUrlScheme(this.f692j.isSSL());
            if (this.f693k != null) {
                request.f916a.setIpInfo(this.f693k.getIpSource(), this.f693k.getIpType());
            } else {
                request.f916a.setIpInfo(1, 1);
            }
            request.f916a.unit = this.f694l;
            return new C0803b(ThreadPoolExecutorFactory.submitPriorityTask(new RunnableC0815f(this, request, requestCb, requestStatistic), C0862h.m739a(request)), request.getSeq());
        } catch (Throwable th) {
            if (requestCb == null) {
                return c0803b;
            }
            requestCb.onFinish(-101, ErrorConstant.formatMsg(-101, th.toString()), requestStatistic);
            return c0803b;
        }
    }

    @Override // anet.channel.Session
    public void close(boolean z) {
        this.f702t = false;
        close();
    }
}
