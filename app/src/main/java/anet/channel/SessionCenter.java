package anet.channel;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import anet.channel.Config;
import anet.channel.detect.C0772n;
import anet.channel.entity.C0783c;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.p021e.C0774a;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.C0842l;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.C0863i;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import anet.channel.util.Utils;
import com.heytap.mcssdk.constant.C2084a;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3397d;
import java.net.ConnectException;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import p000a.p001a.p014u.C0052a;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SessionCenter {
    public static final String TAG = "awcn.SessionCenter";

    /* renamed from: a */
    static Map<Config, SessionCenter> f709a = new HashMap();

    /* renamed from: j */
    private static boolean f710j = false;

    /* renamed from: c */
    String f712c;

    /* renamed from: d */
    Config f713d;

    /* renamed from: h */
    final AccsSessionManager f717h;

    /* renamed from: e */
    final C0773e f714e = new C0773e();

    /* renamed from: f */
    final LruCache<String, SessionRequest> f715f = new LruCache<>(32);

    /* renamed from: g */
    final C0753c f716g = new C0753c();

    /* renamed from: i */
    final C0738a f718i = new C0738a(this, null);

    /* renamed from: b */
    Context f711b = GlobalAppRuntimeInfo.getContext();

    private SessionCenter(Config config) {
        this.f713d = config;
        this.f712c = config.getAppkey();
        this.f718i.m420a();
        this.f717h = new AccsSessionManager(this);
        if (config.getAppkey().equals("[default]")) {
            return;
        }
        AmdcRuntimeInfo.setSign(new C0756d(this, config.getAppkey(), config.getSecurity()));
    }

    public static void checkAndStartAccsSession() {
        Iterator<SessionCenter> it = f709a.values().iterator();
        while (it.hasNext()) {
            it.next().f717h.checkAndStartSession();
        }
    }

    public static synchronized SessionCenter getInstance(String str) {
        SessionCenter sessionCenter;
        synchronized (SessionCenter.class) {
            Config configByTag = Config.getConfigByTag(str);
            if (configByTag == null) {
                throw new RuntimeException("tag not exist!");
            }
            sessionCenter = getInstance(configByTag);
        }
        return sessionCenter;
    }

    public static synchronized void init(Context context) {
        synchronized (SessionCenter.class) {
            if (context == null) {
                ALog.m715e(TAG, "context is null!", null, new Object[0]);
                throw new NullPointerException("init failed. context is null");
            }
            GlobalAppRuntimeInfo.setContext(context.getApplicationContext());
            if (!f710j) {
                f709a.put(Config.DEFAULT_CONFIG, new SessionCenter(Config.DEFAULT_CONFIG));
                AppLifecycle.initialize();
                NetworkStatusHelper.startListener(context);
                if (!AwcnConfig.isTbNextLaunch()) {
                    StrategyCenter.getInstance().initialize(GlobalAppRuntimeInfo.getContext());
                }
                if (GlobalAppRuntimeInfo.isTargetProcess()) {
                    C0772n.m482a();
                    C0774a.m492a();
                }
                f710j = true;
            }
        }
    }

    public static synchronized void switchEnvironment(ENV env) {
        synchronized (SessionCenter.class) {
            try {
                if (GlobalAppRuntimeInfo.getEnv() != env) {
                    ALog.m716i(TAG, "switch env", null, "old", GlobalAppRuntimeInfo.getEnv(), "new", env);
                    GlobalAppRuntimeInfo.setEnv(env);
                    StrategyCenter.getInstance().switchEnv();
                    SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).switchAccsServer(env == ENV.TEST ? 0 : 1);
                }
                Iterator<Map.Entry<Config, SessionCenter>> it = f709a.entrySet().iterator();
                while (it.hasNext()) {
                    SessionCenter value = it.next().getValue();
                    if (value.f713d.getEnv() != env) {
                        ALog.m716i(TAG, "remove instance", value.f712c, C0052a.f150b, value.f713d.getEnv());
                        value.f717h.forceCloseSession(false);
                        value.f718i.m421b();
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                ALog.m714e(TAG, "switch env error.", null, th, new Object[0]);
            }
        }
    }

    public void asyncGet(HttpUrl httpUrl, int i2, long j2, SessionGetCallback sessionGetCallback) {
        if (sessionGetCallback == null) {
            throw new NullPointerException("cb is null");
        }
        if (j2 <= 0) {
            throw new InvalidParameterException("timeout must > 0");
        }
        try {
            m419b(httpUrl, i2, j2, sessionGetCallback);
        } catch (Exception unused) {
            sessionGetCallback.onSessionGetFail();
        }
    }

    /* renamed from: b */
    protected void m419b(HttpUrl httpUrl, int i2, long j2, SessionGetCallback sessionGetCallback) throws Exception {
        SessionInfo m453b;
        if (!f710j) {
            ALog.m715e(TAG, "getInternal not inited!", this.f712c, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        }
        if (httpUrl == null) {
            throw new InvalidParameterException("httpUrl is null");
        }
        if (sessionGetCallback == null) {
            throw new InvalidParameterException("sessionGetCallback is null");
        }
        String str = this.f712c;
        Object[] objArr = new Object[6];
        objArr[0] = C3351bh.f11586aK;
        objArr[1] = httpUrl.urlString();
        objArr[2] = "sessionType";
        objArr[3] = i2 == C0783c.f843a ? "LongLink" : "ShortLink";
        objArr[4] = "timeout";
        objArr[5] = Long.valueOf(j2);
        ALog.m713d(TAG, "getInternal", str, objArr);
        SessionRequest m411a = m411a(httpUrl);
        Session m484a = this.f714e.m484a(m411a, i2);
        if (m484a != null) {
            ALog.m713d(TAG, "get internal hit cache session", this.f712c, C3397d.f11932aw, m484a);
            sessionGetCallback.onSessionGetSuccess(m484a);
            return;
        }
        if (this.f713d == Config.DEFAULT_CONFIG && i2 != C0783c.f844b) {
            sessionGetCallback.onSessionGetFail();
            return;
        }
        if (GlobalAppRuntimeInfo.isAppBackground() && i2 == C0783c.f843a && AwcnConfig.isAccsSessionCreateForbiddenInBg() && (m453b = this.f716g.m453b(httpUrl.host())) != null && m453b.isAccs) {
            ALog.m718w(TAG, "app background, forbid to create accs session", this.f712c, new Object[0]);
            throw new ConnectException("accs session connecting forbidden in background");
        }
        m411a.m438b(this.f711b, i2, C0863i.m740a(this.f712c), sessionGetCallback, j2);
    }

    @Deprecated
    public void enterBackground() {
        AppLifecycle.onBackground();
    }

    @Deprecated
    public void enterForeground() {
        AppLifecycle.onForeground();
    }

    public void forceRecreateAccsSession() {
        this.f717h.forceCloseSession(true);
    }

    public Session get(String str, long j2) {
        return get(HttpUrl.parse(str), C0783c.f845c, j2);
    }

    public Session getThrowsException(String str, long j2) throws Exception {
        return m417a(HttpUrl.parse(str), C0783c.f845c, j2, null);
    }

    public void registerAccsSessionListener(ISessionListener iSessionListener) {
        this.f717h.registerListener(iSessionListener);
    }

    public void registerPublicKey(String str, int i2) {
        this.f716g.m452a(str, i2);
    }

    public void registerSessionInfo(SessionInfo sessionInfo) {
        this.f716g.m451a(sessionInfo);
        if (sessionInfo.isKeepAlive) {
            this.f717h.checkAndStartSession();
        }
    }

    @Deprecated
    public synchronized void switchEnv(ENV env) {
        switchEnvironment(env);
    }

    public void unregisterAccsSessionListener(ISessionListener iSessionListener) {
        this.f717h.unregisterListener(iSessionListener);
    }

    public void unregisterSessionInfo(String str) {
        SessionInfo m449a = this.f716g.m449a(str);
        if (m449a == null || !m449a.isKeepAlive) {
            return;
        }
        this.f717h.checkAndStartSession();
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.SessionCenter$a */
    private class C0738a implements NetworkStatusHelper.INetworkStatusChangeListener, IStrategyListener, AppLifecycle.AppLifecycleListener {

        /* renamed from: a */
        boolean f719a;

        private C0738a() {
            this.f719a = false;
        }

        /* renamed from: a */
        void m420a() {
            AppLifecycle.registerLifecycleListener(this);
            NetworkStatusHelper.addStatusChangeListener(this);
            StrategyCenter.getInstance().registerListener(this);
        }

        /* renamed from: b */
        void m421b() {
            StrategyCenter.getInstance().unregisterListener(this);
            AppLifecycle.unregisterLifecycleListener(this);
            NetworkStatusHelper.removeStatusChangeListener(this);
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void background() {
            ALog.m716i(SessionCenter.TAG, "[background]", SessionCenter.this.f712c, new Object[0]);
            if (!SessionCenter.f710j) {
                ALog.m715e(SessionCenter.TAG, "background not inited!", SessionCenter.this.f712c, new Object[0]);
                return;
            }
            try {
                StrategyCenter.getInstance().saveData();
                if (AwcnConfig.isAccsSessionCreateForbiddenInBg() && "OPPO".equalsIgnoreCase(Build.BRAND)) {
                    ALog.m716i(SessionCenter.TAG, "close session for OPPO", SessionCenter.this.f712c, new Object[0]);
                    SessionCenter.this.f717h.forceCloseSession(false);
                }
            } catch (Exception unused) {
            }
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void forground() {
            ALog.m716i(SessionCenter.TAG, "[forground]", SessionCenter.this.f712c, new Object[0]);
            if (SessionCenter.this.f711b == null || this.f719a) {
                return;
            }
            this.f719a = true;
            try {
                if (!SessionCenter.f710j) {
                    ALog.m715e(SessionCenter.TAG, "forground not inited!", SessionCenter.this.f712c, new Object[0]);
                    return;
                }
                try {
                    if (AppLifecycle.lastEnterBackgroundTime == 0 || System.currentTimeMillis() - AppLifecycle.lastEnterBackgroundTime <= C2084a.f6122d) {
                        SessionCenter.this.f717h.checkAndStartSession();
                    } else {
                        SessionCenter.this.f717h.forceCloseSession(true);
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.f719a = false;
                    throw th;
                }
                this.f719a = false;
            } catch (Exception unused2) {
            }
        }

        @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
        public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
            ALog.m715e(SessionCenter.TAG, "onNetworkStatusChanged.", SessionCenter.this.f712c, "networkStatus", networkStatus);
            List<SessionRequest> m485a = SessionCenter.this.f714e.m485a();
            if (!m485a.isEmpty()) {
                for (SessionRequest sessionRequest : m485a) {
                    ALog.m713d(SessionCenter.TAG, "network change, try recreate session", SessionCenter.this.f712c, new Object[0]);
                    sessionRequest.m435a((String) null);
                }
            }
            SessionCenter.this.f717h.checkAndStartSession();
        }

        @Override // anet.channel.strategy.IStrategyListener
        public void onStrategyUpdated(C0842l.d dVar) {
            SessionCenter.this.m414a(dVar);
            SessionCenter.this.f717h.checkAndStartSession();
        }

        /* synthetic */ C0738a(SessionCenter sessionCenter, C0756d c0756d) {
            this();
        }
    }

    @Deprecated
    public Session get(String str, ConnType.TypeLevel typeLevel, long j2) {
        return get(HttpUrl.parse(str), typeLevel == ConnType.TypeLevel.SPDY ? C0783c.f843a : C0783c.f844b, j2);
    }

    @Deprecated
    public Session getThrowsException(String str, ConnType.TypeLevel typeLevel, long j2) throws Exception {
        return m417a(HttpUrl.parse(str), typeLevel == ConnType.TypeLevel.SPDY ? C0783c.f843a : C0783c.f844b, j2, null);
    }

    /* renamed from: a */
    private SessionRequest m411a(HttpUrl httpUrl) {
        String cNameByHost = StrategyCenter.getInstance().getCNameByHost(httpUrl.host());
        if (cNameByHost == null) {
            cNameByHost = httpUrl.host();
        }
        String scheme = httpUrl.scheme();
        if (!httpUrl.isSchemeLocked()) {
            scheme = StrategyCenter.getInstance().getSchemeByHost(cNameByHost, scheme);
        }
        return m418a(StringUtils.concatString(scheme, HttpConstant.SCHEME_SPLIT, cNameByHost));
    }

    @Deprecated
    public Session get(HttpUrl httpUrl, ConnType.TypeLevel typeLevel, long j2) {
        return get(httpUrl, typeLevel == ConnType.TypeLevel.SPDY ? C0783c.f843a : C0783c.f844b, j2);
    }

    public Session getThrowsException(HttpUrl httpUrl, int i2, long j2) throws Exception {
        return m417a(httpUrl, i2, j2, null);
    }

    public static synchronized SessionCenter getInstance(Config config) {
        SessionCenter sessionCenter;
        Context appContext;
        synchronized (SessionCenter.class) {
            if (config != null) {
                if (!f710j && (appContext = Utils.getAppContext()) != null) {
                    init(appContext);
                }
                sessionCenter = f709a.get(config);
                if (sessionCenter == null) {
                    sessionCenter = new SessionCenter(config);
                    f709a.put(config, sessionCenter);
                }
            } else {
                throw new NullPointerException("config is null!");
            }
        }
        return sessionCenter;
    }

    public Session get(HttpUrl httpUrl, int i2, long j2) {
        try {
            return m417a(httpUrl, i2, j2, null);
        } catch (NoAvailStrategyException e2) {
            ALog.m716i(TAG, "[Get]" + e2.getMessage(), this.f712c, null, "url", httpUrl.urlString());
            return null;
        } catch (ConnectException e3) {
            ALog.m715e(TAG, "[Get]connect exception", this.f712c, "errMsg", e3.getMessage(), "url", httpUrl.urlString());
            return null;
        } catch (InvalidParameterException e4) {
            ALog.m714e(TAG, "[Get]param url is invalid", this.f712c, e4, "url", httpUrl);
            return null;
        } catch (TimeoutException e5) {
            ALog.m714e(TAG, "[Get]timeout exception", this.f712c, e5, "url", httpUrl.urlString());
            return null;
        } catch (Exception e6) {
            ALog.m714e(TAG, "[Get]" + e6.getMessage(), this.f712c, null, "url", httpUrl.urlString());
            return null;
        }
    }

    @Deprecated
    public Session getThrowsException(HttpUrl httpUrl, ConnType.TypeLevel typeLevel, long j2) throws Exception {
        return m417a(httpUrl, typeLevel == ConnType.TypeLevel.SPDY ? C0783c.f843a : C0783c.f844b, j2, null);
    }

    /* renamed from: a */
    protected Session m417a(HttpUrl httpUrl, int i2, long j2, SessionGetCallback sessionGetCallback) throws Exception {
        SessionInfo m453b;
        if (!f710j) {
            ALog.m715e(TAG, "getInternal not inited!", this.f712c, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        }
        if (httpUrl != null) {
            String str = this.f712c;
            Object[] objArr = new Object[6];
            objArr[0] = C3351bh.f11586aK;
            objArr[1] = httpUrl.urlString();
            objArr[2] = "sessionType";
            objArr[3] = i2 == C0783c.f843a ? "LongLink" : "ShortLink";
            objArr[4] = "timeout";
            objArr[5] = Long.valueOf(j2);
            ALog.m713d(TAG, "getInternal", str, objArr);
            SessionRequest m411a = m411a(httpUrl);
            Session m484a = this.f714e.m484a(m411a, i2);
            if (m484a != null) {
                ALog.m713d(TAG, "get internal hit cache session", this.f712c, C3397d.f11932aw, m484a);
            } else {
                if (this.f713d == Config.DEFAULT_CONFIG && i2 != C0783c.f844b) {
                    if (sessionGetCallback == null) {
                        return null;
                    }
                    sessionGetCallback.onSessionGetFail();
                    return null;
                }
                if (GlobalAppRuntimeInfo.isAppBackground() && i2 == C0783c.f843a && AwcnConfig.isAccsSessionCreateForbiddenInBg() && (m453b = this.f716g.m453b(httpUrl.host())) != null && m453b.isAccs) {
                    ALog.m718w(TAG, "app background, forbid to create accs session", this.f712c, new Object[0]);
                    throw new ConnectException("accs session connecting forbidden in background");
                }
                m411a.m431a(this.f711b, i2, C0863i.m740a(this.f712c), sessionGetCallback, j2);
                if (sessionGetCallback == null && j2 > 0 && (i2 == C0783c.f845c || m411a.m437b() == i2)) {
                    m411a.m430a(j2);
                    m484a = this.f714e.m484a(m411a, i2);
                    if (m484a == null) {
                        throw new ConnectException("session connecting failed or timeout");
                    }
                }
            }
            return m484a;
        }
        throw new InvalidParameterException("httpUrl is null");
    }

    @Deprecated
    public static synchronized SessionCenter getInstance() {
        Context appContext;
        synchronized (SessionCenter.class) {
            if (!f710j && (appContext = Utils.getAppContext()) != null) {
                init(appContext);
            }
            SessionCenter sessionCenter = null;
            for (Map.Entry<Config, SessionCenter> entry : f709a.entrySet()) {
                SessionCenter value = entry.getValue();
                if (entry.getKey() != Config.DEFAULT_CONFIG) {
                    return value;
                }
                sessionCenter = value;
            }
            return sessionCenter;
        }
    }

    @Deprecated
    public static synchronized void init(Context context, String str) {
        synchronized (SessionCenter.class) {
            init(context, str, GlobalAppRuntimeInfo.getEnv());
        }
    }

    public static synchronized void init(Context context, String str, ENV env) {
        synchronized (SessionCenter.class) {
            if (context != null) {
                Config config = Config.getConfig(str, env);
                if (config == null) {
                    config = new Config.Builder().setAppkey(str).setEnv(env).build();
                }
                init(context, config);
            } else {
                ALog.m715e(TAG, "context is null!", null, new Object[0]);
                throw new NullPointerException("init failed. context is null");
            }
        }
    }

    /* renamed from: b */
    private void m416b(C0842l.b bVar) {
        boolean z;
        boolean z2;
        ALog.m716i(TAG, "find effectNow", this.f712c, Constants.KEY_HOST, bVar.f1117a);
        C0842l.a[] aVarArr = bVar.f1124h;
        String[] strArr = bVar.f1122f;
        for (Session session : this.f714e.m486a(m418a(StringUtils.buildKey(bVar.f1119c, bVar.f1117a)))) {
            if (!session.getConnType().isHttpType()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= strArr.length) {
                        z = false;
                        break;
                    } else {
                        if (session.getIp().equals(strArr[i2])) {
                            z = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (z) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= aVarArr.length) {
                            z2 = false;
                            break;
                        } else {
                            if (session.getPort() == aVarArr[i3].f1109a && session.getConnType().equals(ConnType.valueOf(ConnProtocol.valueOf(aVarArr[i3])))) {
                                z2 = true;
                                break;
                            }
                            i3++;
                        }
                    }
                    if (!z2) {
                        if (ALog.isPrintLog(2)) {
                            ALog.m716i(TAG, "aisle not match", session.f698p, "port", Integer.valueOf(session.getPort()), "connType", session.getConnType(), "aisle", Arrays.toString(aVarArr));
                        }
                        session.close(true);
                    }
                } else {
                    if (ALog.isPrintLog(2)) {
                        ALog.m716i(TAG, "ip not match", session.f698p, "session ip", session.getIp(), "ips", Arrays.toString(strArr));
                    }
                    session.close(true);
                }
            }
        }
    }

    public static synchronized void init(Context context, Config config) {
        synchronized (SessionCenter.class) {
            if (context == null) {
                ALog.m715e(TAG, "context is null!", null, new Object[0]);
                throw new NullPointerException("init failed. context is null");
            }
            if (config != null) {
                init(context);
                if (!f709a.containsKey(config)) {
                    f709a.put(config, new SessionCenter(config));
                }
            } else {
                ALog.m715e(TAG, "paramter config is null!", null, new Object[0]);
                throw new NullPointerException("init failed. config is null");
            }
        }
    }

    /* renamed from: a */
    public void m414a(C0842l.d dVar) {
        try {
            for (C0842l.b bVar : dVar.f1132b) {
                if (bVar.f1127k) {
                    m416b(bVar);
                }
                if (bVar.f1121e != null) {
                    m413a(bVar);
                }
            }
        } catch (Exception e2) {
            ALog.m714e(TAG, "checkStrategy failed", this.f712c, e2, new Object[0]);
        }
    }

    /* renamed from: a */
    private void m413a(C0842l.b bVar) {
        for (Session session : this.f714e.m486a(m418a(StringUtils.buildKey(bVar.f1119c, bVar.f1117a)))) {
            if (!StringUtils.isStringEqual(session.f694l, bVar.f1121e)) {
                ALog.m716i(TAG, "unit change", session.f698p, "session unit", session.f694l, "unit", bVar.f1121e);
                session.close(true);
            }
        }
    }

    /* renamed from: a */
    protected SessionRequest m418a(String str) {
        SessionRequest sessionRequest;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f715f) {
            sessionRequest = this.f715f.get(str);
            if (sessionRequest == null) {
                sessionRequest = new SessionRequest(str, this);
                this.f715f.put(str, sessionRequest);
            }
        }
        return sessionRequest;
    }
}
