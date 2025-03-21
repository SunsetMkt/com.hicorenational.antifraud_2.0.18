package p000a.p001a.p013t;

import android.text.TextUtils;
import anet.channel.Config;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.NoAvailStrategyException;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.entity.C0781a;
import anet.channel.entity.C0783c;
import anet.channel.entity.ENV;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.session.C0813d;
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
import anetwork.channel.entity.C0899k;
import com.tencent.open.utils.HttpUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.p001a.p002j.InterfaceC0009a;
import p000a.p001a.p003k.C0014b;
import p000a.p001a.p007o.C0025c;
import p000a.p001a.p008p.InterfaceC0026a;
import p000a.p001a.p014u.C0052a;

/* compiled from: Taobao */
/* renamed from: a.a.t.g */
/* loaded from: classes.dex */
class C0042g implements InterfaceRunnableC0036a {

    /* renamed from: n */
    public static final String f100n = "anet.NetworkTask";

    /* renamed from: o */
    public static final int f101o = 131072;

    /* renamed from: a */
    C0047l f102a;

    /* renamed from: b */
    InterfaceC0009a f103b;

    /* renamed from: c */
    InterfaceC0009a.a f104c;

    /* renamed from: e */
    String f106e;

    /* renamed from: h */
    volatile AtomicBoolean f109h;

    /* renamed from: d */
    ByteArrayOutputStream f105d = null;

    /* renamed from: f */
    volatile Cancelable f107f = null;

    /* renamed from: g */
    volatile boolean f108g = false;

    /* renamed from: i */
    int f110i = 0;

    /* renamed from: j */
    int f111j = 0;

    /* renamed from: k */
    boolean f112k = false;

    /* renamed from: l */
    boolean f113l = false;

    /* renamed from: m */
    a f114m = null;

    C0042g(C0047l c0047l, InterfaceC0009a interfaceC0009a, InterfaceC0009a.a aVar) {
        this.f103b = null;
        this.f104c = null;
        this.f106e = DispatchConstants.OTHER;
        this.f109h = null;
        this.f102a = c0047l;
        this.f109h = c0047l.f138d;
        this.f103b = interfaceC0009a;
        this.f104c = aVar;
        this.f106e = c0047l.f135a.m834h().get(HttpConstant.F_REFER);
    }

    /* renamed from: b */
    private Session m193b() {
        Session session;
        SessionCenter m188a = m188a();
        HttpUrl m832f = this.f102a.f135a.m832f();
        boolean containsNonDefaultPort = m832f.containsNonDefaultPort();
        C0899k c0899k = this.f102a.f135a;
        RequestStatistic requestStatistic = c0899k.f1364f;
        if (c0899k.f1368j != 1 || !C0014b.m112r() || this.f102a.f135a.f1363e != 0 || containsNonDefaultPort) {
            return m187a(null, m188a, m832f, containsNonDefaultPort);
        }
        HttpUrl m190a = m190a(m832f);
        try {
            session = m188a.getThrowsException(m190a, C0783c.f843a, 0L);
        } catch (NoAvailStrategyException unused) {
            return m187a(null, m188a, m832f, containsNonDefaultPort);
        } catch (Exception unused2) {
            session = null;
        }
        if (session == null) {
            ThreadPoolExecutorFactory.submitPriorityTask(new RunnableC0044i(this, m188a, m190a, requestStatistic, m832f, containsNonDefaultPort), ThreadPoolExecutorFactory.Priority.NORMAL);
            return null;
        }
        ALog.m716i(f100n, "tryGetSession", this.f102a.f137c, "Session", session);
        requestStatistic.spdyRequestSend = true;
        return session;
    }

    /* renamed from: c */
    private void m194c() {
        SessionCenter m188a = m188a();
        HttpUrl m832f = this.f102a.f135a.m832f();
        boolean containsNonDefaultPort = m832f.containsNonDefaultPort();
        C0899k c0899k = this.f102a.f135a;
        RequestStatistic requestStatistic = c0899k.f1364f;
        Request m824a = c0899k.m824a();
        if (this.f102a.f135a.f1368j != 1 || !C0014b.m112r() || this.f102a.f135a.f1363e != 0 || containsNonDefaultPort) {
            m192a(m187a(null, m188a, m832f, containsNonDefaultPort), m824a);
            return;
        }
        m188a.asyncGet(m190a(m832f), C0783c.f843a, 3000L, new C0045j(this, requestStatistic, System.currentTimeMillis(), m824a, m188a, m832f, containsNonDefaultPort));
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f108g = true;
        if (this.f107f != null) {
            this.f107f.cancel();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f108g) {
            return;
        }
        RequestStatistic requestStatistic = this.f102a.f135a.f1364f;
        requestStatistic.f_refer = this.f106e;
        if (!NetworkStatusHelper.isConnected()) {
            if (C0014b.m108o() && requestStatistic.statusCode != -200) {
                requestStatistic.statusCode = ErrorConstant.ERROR_NO_NETWORK;
                ThreadPoolExecutorFactory.submitScheduledTask(new RunnableC0043h(this), 1000L, TimeUnit.MILLISECONDS);
                return;
            }
            if (ALog.isPrintLog(2)) {
                ALog.m716i(f100n, HttpUtils.NetworkUnavailableException.ERROR_INFO, this.f102a.f137c, "NetworkStatus", NetworkStatusHelper.getStatus());
            }
            this.f109h.set(true);
            this.f102a.m197a();
            requestStatistic.isDone.set(true);
            requestStatistic.statusCode = ErrorConstant.ERROR_NO_NETWORK;
            requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_NO_NETWORK);
            requestStatistic.rspEnd = System.currentTimeMillis();
            C0047l c0047l = this.f102a;
            c0047l.f136b.mo151a(new DefaultFinishEvent(ErrorConstant.ERROR_NO_NETWORK, (String) null, c0047l.f135a.m824a()));
            return;
        }
        if (!C0014b.m92g() || !GlobalAppRuntimeInfo.isAppBackground() || AppLifecycle.lastEnterBackgroundTime <= 0 || AppLifecycle.isGoingForeground || System.currentTimeMillis() - AppLifecycle.lastEnterBackgroundTime <= C0014b.m65a() || C0014b.m77b(this.f102a.f135a.m832f()) || C0014b.m72a(this.f102a.f135a.m824a().getBizId()) || this.f102a.f135a.m824a().isAllowRequestInBg()) {
            if (ALog.isPrintLog(2)) {
                C0047l c0047l2 = this.f102a;
                ALog.m716i(f100n, "exec request", c0047l2.f137c, "retryTimes", Integer.valueOf(c0047l2.f135a.f1363e));
            }
            if (C0014b.m100k()) {
                m194c();
                return;
            }
            try {
                Session m193b = m193b();
                if (m193b == null) {
                    return;
                }
                m192a(m193b, this.f102a.f135a.m824a());
                return;
            } catch (Exception e2) {
                ALog.m714e(f100n, "send request failed.", this.f102a.f137c, e2, new Object[0]);
                return;
            }
        }
        this.f109h.set(true);
        this.f102a.m197a();
        if (ALog.isPrintLog(2)) {
            C0047l c0047l3 = this.f102a;
            ALog.m716i(f100n, "request forbidden in background", c0047l3.f137c, "url", c0047l3.f135a.m832f());
        }
        requestStatistic.isDone.set(true);
        requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG;
        requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG);
        requestStatistic.rspEnd = System.currentTimeMillis();
        C0047l c0047l4 = this.f102a;
        c0047l4.f136b.mo151a(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG, (String) null, c0047l4.f135a.m824a()));
        ExceptionStatistic exceptionStatistic = new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG, null, "rt");
        exceptionStatistic.host = this.f102a.f135a.m832f().host();
        exceptionStatistic.url = this.f102a.f135a.m833g();
        AppMonitor.getInstance().commitStat(exceptionStatistic);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: a.a.t.g$a */
    static class a {

        /* renamed from: a */
        int f115a;

        /* renamed from: b */
        Map<String, List<String>> f116b;

        /* renamed from: c */
        List<ByteArray> f117c = new ArrayList();

        a(int i2, Map<String, List<String>> map) {
            this.f115a = i2;
            this.f116b = map;
        }

        /* renamed from: a */
        void m196a() {
            Iterator<ByteArray> it = this.f117c.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
        }

        /* renamed from: a */
        int m195a(InterfaceC0026a interfaceC0026a, int i2) {
            interfaceC0026a.onResponseCode(this.f115a, this.f116b);
            Iterator<ByteArray> it = this.f117c.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                interfaceC0026a.mo150a(i3, i2, it.next());
                i3++;
            }
            return i3;
        }
    }

    /* renamed from: a */
    private HttpUrl m190a(HttpUrl httpUrl) {
        HttpUrl parse;
        String str = this.f102a.f135a.m834h().get(HttpConstant.X_HOST_CNAME);
        return (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(httpUrl.urlString().replaceFirst(httpUrl.host(), str))) == null) ? httpUrl : parse;
    }

    /* renamed from: a */
    private SessionCenter m188a() {
        String m825a = this.f102a.f135a.m825a(C0052a.f149a);
        if (TextUtils.isEmpty(m825a)) {
            return SessionCenter.getInstance();
        }
        ENV env = ENV.ONLINE;
        String m825a2 = this.f102a.f135a.m825a(C0052a.f150b);
        if (C0052a.f161m.equalsIgnoreCase(m825a2)) {
            env = ENV.PREPARE;
        } else if (C0052a.f162n.equalsIgnoreCase(m825a2)) {
            env = ENV.TEST;
        }
        if (env != C0025c.CURRENT_ENV) {
            C0025c.CURRENT_ENV = env;
            SessionCenter.switchEnvironment(env);
        }
        Config config = Config.getConfig(m825a, env);
        if (config == null) {
            config = new Config.Builder().setAppkey(m825a).setEnv(env).setAuthCode(this.f102a.f135a.m825a(C0052a.f151c)).build();
        }
        return SessionCenter.getInstance(config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Session m187a(Session session, SessionCenter sessionCenter, HttpUrl httpUrl, boolean z) {
        C0899k c0899k = this.f102a.f135a;
        RequestStatistic requestStatistic = c0899k.f1364f;
        if (session == null && c0899k.m831e() && !z && !NetworkStatusHelper.isProxy()) {
            session = sessionCenter.get(httpUrl, C0783c.f844b, 0L);
        }
        if (session == null) {
            ALog.m716i(f100n, "create HttpSession with local DNS", this.f102a.f137c, new Object[0]);
            session = new C0813d(GlobalAppRuntimeInfo.getContext(), new C0781a(StringUtils.concatString(httpUrl.scheme(), HttpConstant.SCHEME_SPLIT, httpUrl.host()), this.f102a.f137c, null));
        }
        if (requestStatistic.spdyRequestSend) {
            requestStatistic.degraded = 1;
        }
        ALog.m716i(f100n, "tryGetHttpSession", this.f102a.f137c, "Session", session);
        return session;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private anet.channel.request.Request m189a(anet.channel.request.Request r7) {
        /*
            r6 = this;
            a.a.t.l r0 = r6.f102a
            anetwork.channel.entity.k r0 = r0.f135a
            boolean r0 = r0.m835i()
            if (r0 == 0) goto L3c
            a.a.t.l r0 = r6.f102a
            anetwork.channel.entity.k r0 = r0.f135a
            java.lang.String r0 = r0.m833g()
            java.lang.String r0 = p000a.p001a.p004l.C0015a.m120b(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L3c
            anet.channel.request.Request$Builder r1 = r7.newBuilder()
            java.util.Map r2 = r7.getHeaders()
            java.lang.String r3 = "Cookie"
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L38
            java.lang.String r4 = "; "
            java.lang.String r0 = anet.channel.util.StringUtils.concatString(r2, r4, r0)
        L38:
            r1.addHeader(r3, r0)
            goto L3d
        L3c:
            r1 = 0
        L3d:
            a.a.j.a$a r0 = r6.f104c
            if (r0 == 0) goto L65
            if (r1 != 0) goto L47
            anet.channel.request.Request$Builder r1 = r7.newBuilder()
        L47:
            a.a.j.a$a r0 = r6.f104c
            java.lang.String r0 = r0.etag
            if (r0 == 0) goto L52
            java.lang.String r2 = "If-None-Match"
            r1.addHeader(r2, r0)
        L52:
            a.a.j.a$a r0 = r6.f104c
            long r2 = r0.lastModified
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L65
            java.lang.String r0 = p000a.p001a.p002j.C0012d.m63a(r2)
            java.lang.String r2 = "If-Modified-Since"
            r1.addHeader(r2, r0)
        L65:
            a.a.t.l r0 = r6.f102a
            anetwork.channel.entity.k r0 = r0.f135a
            int r0 = r0.f1363e
            if (r0 != 0) goto L84
            java.lang.String r0 = r6.f106e
            java.lang.String r2 = "weex"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L84
            if (r1 != 0) goto L7f
            anet.channel.request.Request$Builder r0 = r7.newBuilder()
            r1 = r0
        L7f:
            r0 = 3000(0xbb8, float:4.204E-42)
            r1.setReadTimeout(r0)
        L84:
            if (r1 != 0) goto L87
            goto L8b
        L87:
            anet.channel.request.Request r7 = r1.build()
        L8b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p013t.C0042g.m189a(anet.channel.request.Request):anet.channel.request.Request");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m192a(Session session, Request request) {
        if (session == null || this.f108g) {
            return;
        }
        Request m189a = m189a(request);
        RequestStatistic requestStatistic = this.f102a.f135a.f1364f;
        requestStatistic.reqStart = System.currentTimeMillis();
        this.f107f = session.request(m189a, new C0046k(this, m189a, requestStatistic));
    }
}
