package b.a.t;

import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import anet.channel.Config;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.NoAvailStrategyException;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.entity.ENV;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import anetwork.channel.aidl.DefaultFinishEvent;
import b.a.j.a;
import com.tencent.open.utils.HttpUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class g implements b.a.t.a {

    /* JADX INFO: renamed from: n */
    public static final String f1864n = "anet.NetworkTask";
    public static final int o = 131072;
    l a;

    /* JADX INFO: renamed from: b */
    b.a.j.a f1865b;

    /* JADX INFO: renamed from: c */
    a.C0022a f1866c;

    /* JADX INFO: renamed from: e */
    String f1868e;

    /* JADX INFO: renamed from: h */
    volatile AtomicBoolean f1871h;

    /* JADX INFO: renamed from: d */
    ByteArrayOutputStream f1867d = null;

    /* JADX INFO: renamed from: f */
    volatile Cancelable f1869f = null;

    /* JADX INFO: renamed from: g */
    volatile boolean f1870g = false;

    /* JADX INFO: renamed from: i */
    int f1872i = 0;

    /* JADX INFO: renamed from: j */
    int f1873j = 0;

    /* JADX INFO: renamed from: k */
    boolean f1874k = false;

    /* JADX INFO: renamed from: l */
    boolean f1875l = false;

    /* JADX INFO: renamed from: m */
    a f1876m = null;

    g(l lVar, b.a.j.a aVar, a.C0022a c0022a) {
        this.f1865b = null;
        this.f1866c = null;
        this.f1868e = DispatchConstants.OTHER;
        this.f1871h = null;
        this.a = lVar;
        this.f1871h = lVar.f1894d;
        this.f1865b = aVar;
        this.f1866c = c0022a;
        this.f1868e = lVar.a.h().get(HttpConstant.F_REFER);
    }

    private Session b() {
        Session throwsException;
        SessionCenter sessionCenterA = a();
        HttpUrl httpUrlF = this.a.a.f();
        boolean zContainsNonDefaultPort = httpUrlF.containsNonDefaultPort();
        anetwork.channel.entity.k kVar = this.a.a;
        RequestStatistic requestStatistic = kVar.f1791f;
        if (kVar.f1795j != 1 || !b.a.k.b.r() || this.a.a.f1790e != 0 || zContainsNonDefaultPort) {
            return a(null, sessionCenterA, httpUrlF, zContainsNonDefaultPort);
        }
        HttpUrl httpUrlA = a(httpUrlF);
        try {
            throwsException = sessionCenterA.getThrowsException(httpUrlA, anet.channel.entity.c.a, 0L);
        } catch (NoAvailStrategyException unused) {
            return a(null, sessionCenterA, httpUrlF, zContainsNonDefaultPort);
        } catch (Exception unused2) {
            throwsException = null;
        }
        if (throwsException == null) {
            ThreadPoolExecutorFactory.submitPriorityTask(new i(this, sessionCenterA, httpUrlA, requestStatistic, httpUrlF, zContainsNonDefaultPort), ThreadPoolExecutorFactory.Priority.NORMAL);
            return null;
        }
        ALog.i(f1864n, "tryGetSession", this.a.f1893c, "Session", throwsException);
        requestStatistic.spdyRequestSend = true;
        return throwsException;
    }

    private void c() {
        SessionCenter sessionCenterA = a();
        HttpUrl httpUrlF = this.a.a.f();
        boolean zContainsNonDefaultPort = httpUrlF.containsNonDefaultPort();
        anetwork.channel.entity.k kVar = this.a.a;
        RequestStatistic requestStatistic = kVar.f1791f;
        Request requestA = kVar.a();
        if (this.a.a.f1795j != 1 || !b.a.k.b.r() || this.a.a.f1790e != 0 || zContainsNonDefaultPort) {
            a(a(null, sessionCenterA, httpUrlF, zContainsNonDefaultPort), requestA);
            return;
        }
        sessionCenterA.asyncGet(a(httpUrlF), anet.channel.entity.c.a, 3000L, new j(this, requestStatistic, System.currentTimeMillis(), requestA, sessionCenterA, httpUrlF, zContainsNonDefaultPort));
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f1870g = true;
        if (this.f1869f != null) {
            this.f1869f.cancel();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1870g) {
            return;
        }
        RequestStatistic requestStatistic = this.a.a.f1791f;
        requestStatistic.f_refer = this.f1868e;
        if (!NetworkStatusHelper.isConnected()) {
            if (b.a.k.b.o() && requestStatistic.statusCode != -200) {
                requestStatistic.statusCode = ErrorConstant.ERROR_NO_NETWORK;
                ThreadPoolExecutorFactory.submitScheduledTask(new h(this), 1000L, TimeUnit.MILLISECONDS);
                return;
            }
            if (ALog.isPrintLog(2)) {
                ALog.i(f1864n, HttpUtils.NetworkUnavailableException.ERROR_INFO, this.a.f1893c, "NetworkStatus", NetworkStatusHelper.getStatus());
            }
            this.f1871h.set(true);
            this.a.a();
            requestStatistic.isDone.set(true);
            requestStatistic.statusCode = ErrorConstant.ERROR_NO_NETWORK;
            requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_NO_NETWORK);
            requestStatistic.rspEnd = System.currentTimeMillis();
            l lVar = this.a;
            lVar.f1892b.a(new DefaultFinishEvent(ErrorConstant.ERROR_NO_NETWORK, (String) null, lVar.a.a()));
            return;
        }
        if (!b.a.k.b.g() || !GlobalAppRuntimeInfo.isAppBackground() || AppLifecycle.lastEnterBackgroundTime <= 0 || AppLifecycle.isGoingForeground || System.currentTimeMillis() - AppLifecycle.lastEnterBackgroundTime <= b.a.k.b.a() || b.a.k.b.b(this.a.a.f()) || b.a.k.b.a(this.a.a.a().getBizId()) || this.a.a.a().isAllowRequestInBg()) {
            if (ALog.isPrintLog(2)) {
                l lVar2 = this.a;
                ALog.i(f1864n, "exec request", lVar2.f1893c, "retryTimes", Integer.valueOf(lVar2.a.f1790e));
            }
            if (b.a.k.b.k()) {
                c();
                return;
            }
            try {
                Session sessionB = b();
                if (sessionB == null) {
                    return;
                }
                a(sessionB, this.a.a.a());
                return;
            } catch (Exception e2) {
                ALog.e(f1864n, "send request failed.", this.a.f1893c, e2, new Object[0]);
                return;
            }
        }
        this.f1871h.set(true);
        this.a.a();
        if (ALog.isPrintLog(2)) {
            l lVar3 = this.a;
            ALog.i(f1864n, "request forbidden in background", lVar3.f1893c, "url", lVar3.a.f());
        }
        requestStatistic.isDone.set(true);
        requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG;
        requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG);
        requestStatistic.rspEnd = System.currentTimeMillis();
        l lVar4 = this.a;
        lVar4.f1892b.a(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG, (String) null, lVar4.a.a()));
        ExceptionStatistic exceptionStatistic = new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG, null, "rt");
        exceptionStatistic.host = this.a.a.f().host();
        exceptionStatistic.url = this.a.a.g();
        AppMonitor.getInstance().commitStat(exceptionStatistic);
    }

    /* JADX INFO: compiled from: Taobao */
    static class a {
        int a;

        /* JADX INFO: renamed from: b */
        Map<String, List<String>> f1877b;

        /* JADX INFO: renamed from: c */
        List<ByteArray> f1878c = new ArrayList();

        a(int i2, Map<String, List<String>> map) {
            this.a = i2;
            this.f1877b = map;
        }

        void a() {
            Iterator<ByteArray> it = this.f1878c.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
        }

        int a(b.a.p.a aVar, int i2) {
            aVar.onResponseCode(this.a, this.f1877b);
            Iterator<ByteArray> it = this.f1878c.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                aVar.a(i3, i2, it.next());
                i3++;
            }
            return i3;
        }
    }

    private HttpUrl a(HttpUrl httpUrl) {
        HttpUrl httpUrl2;
        String str = this.a.a.h().get(HttpConstant.X_HOST_CNAME);
        return (TextUtils.isEmpty(str) || (httpUrl2 = HttpUrl.parse(httpUrl.urlString().replaceFirst(httpUrl.host(), str))) == null) ? httpUrl : httpUrl2;
    }

    private SessionCenter a() {
        String strA = this.a.a.a(b.a.u.a.a);
        if (TextUtils.isEmpty(strA)) {
            return SessionCenter.getInstance();
        }
        ENV env = ENV.ONLINE;
        String strA2 = this.a.a.a(b.a.u.a.f1900b);
        if (b.a.u.a.f1911m.equalsIgnoreCase(strA2)) {
            env = ENV.PREPARE;
        } else if (b.a.u.a.f1912n.equalsIgnoreCase(strA2)) {
            env = ENV.TEST;
        }
        if (env != b.a.o.c.CURRENT_ENV) {
            b.a.o.c.CURRENT_ENV = env;
            SessionCenter.switchEnvironment(env);
        }
        Config config = Config.getConfig(strA, env);
        if (config == null) {
            config = new Config.Builder().setAppkey(strA).setEnv(env).setAuthCode(this.a.a.a(b.a.u.a.f1901c)).build();
        }
        return SessionCenter.getInstance(config);
    }

    public Session a(Session session, SessionCenter sessionCenter, HttpUrl httpUrl, boolean z) {
        anetwork.channel.entity.k kVar = this.a.a;
        RequestStatistic requestStatistic = kVar.f1791f;
        if (session == null && kVar.e() && !z && !NetworkStatusHelper.isProxy()) {
            session = sessionCenter.get(httpUrl, anet.channel.entity.c.f1446b, 0L);
        }
        if (session == null) {
            ALog.i(f1864n, "create HttpSession with local DNS", this.a.f1893c, new Object[0]);
            session = new anet.channel.session.d(GlobalAppRuntimeInfo.getContext(), new anet.channel.entity.a(StringUtils.concatString(httpUrl.scheme(), HttpConstant.SCHEME_SPLIT, httpUrl.host()), this.a.f1893c, null));
        }
        if (requestStatistic.spdyRequestSend) {
            requestStatistic.degraded = 1;
        }
        ALog.i(f1864n, "tryGetHttpSession", this.a.f1893c, "Session", session);
        return session;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Request a(Request request) {
        Request.Builder builderNewBuilder;
        if (this.a.a.i()) {
            String strB = b.a.l.a.b(this.a.a.g());
            if (TextUtils.isEmpty(strB)) {
                builderNewBuilder = null;
            } else {
                builderNewBuilder = request.newBuilder();
                String str = request.getHeaders().get("Cookie");
                if (!TextUtils.isEmpty(str)) {
                    strB = StringUtils.concatString(str, "; ", strB);
                }
                builderNewBuilder.addHeader("Cookie", strB);
            }
        }
        if (this.f1866c != null) {
            if (builderNewBuilder == null) {
                builderNewBuilder = request.newBuilder();
            }
            String str2 = this.f1866c.etag;
            if (str2 != null) {
                builderNewBuilder.addHeader("If-None-Match", str2);
            }
            long j2 = this.f1866c.lastModified;
            if (j2 > 0) {
                builderNewBuilder.addHeader("If-Modified-Since", b.a.j.d.a(j2));
            }
        }
        if (this.a.a.f1790e == 0 && "weex".equalsIgnoreCase(this.f1868e)) {
            if (builderNewBuilder == null) {
                builderNewBuilder = request.newBuilder();
            }
            builderNewBuilder.setReadTimeout(PathInterpolatorCompat.MAX_NUM_POINTS);
        }
        return builderNewBuilder == null ? request : builderNewBuilder.build();
    }

    public void a(Session session, Request request) {
        if (session == null || this.f1870g) {
            return;
        }
        Request requestA = a(request);
        RequestStatistic requestStatistic = this.a.a.f1791f;
        requestStatistic.reqStart = System.currentTimeMillis();
        this.f1869f = session.request(requestA, new k(this, requestA, requestStatistic));
    }
}
