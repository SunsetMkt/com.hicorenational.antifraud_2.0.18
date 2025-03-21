package com.taobao.accs.net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.ISessionListener;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.SessionInfo;
import anet.channel.entity.ConnType;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import com.heytap.mcssdk.constant.C2084a;
import com.just.agentweb.DefaultWebClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.p199ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.p199ut.p200a.C3028c;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3052t;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.k */
/* loaded from: classes2.dex */
public class C3011k extends AbstractC3001a implements DataFrameCb {

    /* renamed from: o */
    private boolean f9559o;

    /* renamed from: p */
    private long f9560p;

    /* renamed from: q */
    private ScheduledFuture f9561q;

    /* renamed from: r */
    private Handler f9562r;

    /* renamed from: s */
    private Runnable f9563s;

    /* renamed from: t */
    private ISessionListener f9564t;

    /* renamed from: u */
    private Runnable f9565u;

    /* renamed from: v */
    private Set<String> f9566v;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.accs.net.k$a */
    public static class a implements IAuth {

        /* renamed from: a */
        private String f9567a;

        /* renamed from: b */
        private int f9568b;

        /* renamed from: c */
        private String f9569c;

        /* renamed from: d */
        private AbstractC3001a f9570d;

        public a(AbstractC3001a abstractC3001a, String str) {
            this.f9569c = abstractC3001a.mo9100d();
            this.f9567a = abstractC3001a.m9098c(DefaultWebClient.HTTPS_SCHEME + str + "/accs/");
            this.f9568b = abstractC3001a.f9523c;
            this.f9570d = abstractC3001a;
        }

        @Override // anet.channel.IAuth
        public void auth(Session session, IAuth.AuthCallback authCallback) {
            ALog.m9182e(this.f9569c, "auth", "URL", this.f9567a);
            session.request(new Request.Builder().setUrl(this.f9567a).build(), new C3021u(this, authCallback));
        }
    }

    public C3011k(Context context, int i2, String str) {
        super(context, i2, str);
        this.f9559o = true;
        this.f9560p = C2084a.f6123e;
        this.f9562r = new Handler(Looper.getMainLooper());
        this.f9563s = new RunnableC3012l(this);
        this.f9564t = new C3013m(this);
        this.f9565u = new RunnableC3020t(this);
        this.f9566v = Collections.synchronizedSet(new HashSet());
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.f9565u, 120000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m9129o() {
        if (this.f9529i.isAccsHeartbeatEnable()) {
            ALog.m9182e(mo9100d(), "startAccsHeartBeat", new Object[0]);
            ScheduledFuture scheduledFuture = this.f9561q;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            ScheduledThreadPoolExecutor scheduledExecutor = ThreadPoolExecutorFactory.getScheduledExecutor();
            Runnable runnable = this.f9563s;
            long j2 = this.f9560p;
            this.f9561q = scheduledExecutor.scheduleAtFixedRate(runnable, j2, j2, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: c */
    public C3028c mo9097c() {
        return null;
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: d */
    public String mo9100d() {
        return "InAppConn_" + this.f9533m;
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: e */
    public void mo9101e() {
        ALog.m9182e(mo9100d(), "shut down", new Object[0]);
        this.f9559o = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[Catch: Exception -> 0x0047, TRY_LEAVE, TryCatch #0 {Exception -> 0x0047, blocks: (B:5:0x0006, B:7:0x002a, B:11:0x0034, B:13:0x003f), top: B:4:0x0006 }] */
    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo9109m() {
        /*
            r7 = this;
            boolean r0 = r7.f9527g
            r1 = 0
            if (r0 == 0) goto L48
            r0 = 1
            com.taobao.accs.AccsClientConfig r2 = r7.f9529i     // Catch: java.lang.Exception -> L47
            java.lang.String r2 = r2.getAppKey()     // Catch: java.lang.Exception -> L47
            anet.channel.SessionCenter r2 = anet.channel.SessionCenter.getInstance(r2)     // Catch: java.lang.Exception -> L47
            r3 = 0
            java.lang.String r3 = r7.mo9091b(r3)     // Catch: java.lang.Exception -> L47
            anet.channel.entity.ConnType$TypeLevel r4 = anet.channel.entity.ConnType.TypeLevel.SPDY     // Catch: java.lang.Exception -> L47
            r5 = 0
            anet.channel.Session r2 = r2.get(r3, r4, r5)     // Catch: java.lang.Exception -> L47
            java.lang.String r3 = "InAppConn_"
            java.lang.String r4 = "isConnected"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L47
            java.lang.String r6 = "state"
            r5[r1] = r6     // Catch: java.lang.Exception -> L47
            if (r2 == 0) goto L33
            boolean r6 = r2.isAvailable()     // Catch: java.lang.Exception -> L47
            if (r6 == 0) goto L31
            goto L33
        L31:
            r6 = 0
            goto L34
        L33:
            r6 = 1
        L34:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch: java.lang.Exception -> L47
            r5[r0] = r6     // Catch: java.lang.Exception -> L47
            com.taobao.accs.utl.ALog.m9182e(r3, r4, r5)     // Catch: java.lang.Exception -> L47
            if (r2 == 0) goto L46
            boolean r2 = r2.isAvailable()     // Catch: java.lang.Exception -> L47
            if (r2 == 0) goto L46
            goto L47
        L46:
            r0 = 0
        L47:
            return r0
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.C3011k.mo9109m():boolean");
    }

    @Override // anet.channel.DataFrameCb
    public void onDataReceive(TnetSpdySession tnetSpdySession, byte[] bArr, int i2, int i3) {
        if (ALog.isPrintLog(ALog.Level.E)) {
            ALog.m9182e(mo9100d(), "onDataReceive", "type", Integer.valueOf(i3), "dataid", Integer.valueOf(i2));
        }
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new RunnableC3018r(this, i3, bArr, tnetSpdySession));
    }

    @Override // anet.channel.DataFrameCb
    public void onException(int i2, int i3, boolean z, String str) {
        ALog.m9182e(mo9100d(), "errorId:" + i3 + "detail:" + str + " dataId:" + i2 + " needRetry:" + z, new Object[0]);
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new RunnableC3019s(this, i2, z, i3));
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: a */
    public synchronized void mo9082a() {
        ALog.m9180d(mo9100d(), "start", new Object[0]);
        this.f9559o = true;
        mo9083a(this.f9524d);
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: b */
    public void mo9092b() {
        this.f9526f = 0;
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: c */
    public void mo9099c(int i2) {
        super.mo9099c(i2);
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: a */
    public void mo9085a(Message message, boolean z) {
        if (this.f9559o && message != null) {
            try {
                if (ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size() <= 1000) {
                    ScheduledFuture<?> schedule = ThreadPoolExecutorFactory.getSendScheduledExecutor().schedule(new RunnableC3015o(this, message), message.delyTime, TimeUnit.MILLISECONDS);
                    if (message.getType() == 1 && message.cunstomDataId != null) {
                        if (message.isControlFrame() && mo9090a(message.cunstomDataId)) {
                            this.f9525e.m9034b(message);
                        }
                        this.f9525e.f9467a.put(message.cunstomDataId, schedule);
                    }
                    NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
                    if (netPermanceMonitor != null) {
                        netPermanceMonitor.setDeviceId(UtilityImpl.m9228j(this.f9524d));
                        netPermanceMonitor.setConnType(this.f9523c);
                        netPermanceMonitor.onEnterQueueData();
                        return;
                    }
                    return;
                }
                throw new RejectedExecutionException("accs");
            } catch (RejectedExecutionException unused) {
                this.f9525e.m9026a(message, ErrorCode.MESSAGE_QUEUE_FULL);
                ALog.m9182e(mo9100d(), "send queue full count:" + ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size(), new Object[0]);
                return;
            } catch (Throwable th) {
                this.f9525e.m9026a(message, -8);
                ALog.m9181e(mo9100d(), "send error", th, new Object[0]);
                return;
            }
        }
        ALog.m9182e(mo9100d(), "not running or msg null! " + this.f9559o, new Object[0]);
    }

    public C3011k(Context context, int i2, String str, int i3) {
        super(context, i2, str);
        this.f9559o = true;
        this.f9560p = C2084a.f6123e;
        this.f9562r = new Handler(Looper.getMainLooper());
        this.f9563s = new RunnableC3012l(this);
        this.f9564t = new C3013m(this);
        this.f9565u = new RunnableC3020t(this);
        this.f9566v = Collections.synchronizedSet(new HashSet());
        mo9099c(i3);
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.f9565u, 120000L, TimeUnit.MILLISECONDS);
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: a */
    protected void mo9086a(String str, boolean z, long j2) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new RunnableC3016p(this, str, z), j2, TimeUnit.MILLISECONDS);
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: a */
    public void mo9088a(boolean z, boolean z2) {
        ThreadPoolExecutorFactory.getSendScheduledExecutor().execute(new RunnableC3017q(this));
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: a */
    public void mo9087a(String str, boolean z, String str2) {
        Session session;
        try {
            Message m9032b = this.f9525e.m9032b(str);
            if (m9032b != null && m9032b.host != null && (session = SessionCenter.getInstance(this.f9529i.getAppKey()).get(m9032b.host.toString(), 0L)) != null) {
                if (z) {
                    ALog.m9182e(mo9100d(), "close session by time out", new Object[0]);
                    session.close(true);
                } else {
                    session.ping(true);
                }
            }
        } catch (Exception e2) {
            ALog.m9181e(mo9100d(), "onTimeOut", e2, new Object[0]);
        }
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: a */
    public boolean mo9090a(String str) {
        if (str == null) {
            return false;
        }
        ScheduledFuture<?> scheduledFuture = this.f9525e.f9467a.get(str);
        boolean cancel = scheduledFuture != null ? scheduledFuture.cancel(false) : false;
        if (cancel) {
            ALog.m9182e(mo9100d(), CommonNetImpl.CANCEL, "customDataId", str);
        }
        return cancel;
    }

    /* renamed from: a */
    public void m9132a(JSONObject jSONObject) {
        if (jSONObject == null) {
            ALog.m9182e(mo9100d(), "onReceiveAccsHeartbeatResp response data is null", new Object[0]);
            return;
        }
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.m9183i(mo9100d(), "onReceiveAccsHeartbeatResp", "data", jSONObject);
        }
        try {
            int i2 = jSONObject.getInt("timeInterval");
            if (i2 == -1) {
                if (this.f9561q != null) {
                    this.f9561q.cancel(true);
                    return;
                }
                return;
            }
            long j2 = i2 * 1000;
            if (this.f9560p != j2) {
                if (i2 == 0) {
                    j2 = C2084a.f6123e;
                }
                this.f9560p = j2;
                if (this.f9561q != null) {
                    this.f9561q.cancel(true);
                }
                this.f9561q = ThreadPoolExecutorFactory.getScheduledExecutor().scheduleAtFixedRate(this.f9563s, this.f9560p, this.f9560p, TimeUnit.MILLISECONDS);
            }
        } catch (JSONException e2) {
            ALog.m9182e(mo9100d(), "onReceiveAccsHeartbeatResp", "e", e2.getMessage());
        }
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: a */
    protected void mo9083a(Context context) {
        boolean z;
        try {
            if (this.f9527g) {
                return;
            }
            super.mo9083a(context);
            if (C3052t.m9278c()) {
                SessionCenter.getInstance(this.f9529i.getAppKey()).registerAccsSessionListener(this.f9564t);
            }
            String inappHost = this.f9529i.getInappHost();
            if (mo9104h() && this.f9529i.isKeepalive()) {
                z = true;
            } else {
                ALog.m9180d(mo9100d(), "initAwcn close keepalive", new Object[0]);
                z = false;
            }
            m9130a(SessionCenter.getInstance(this.f9529i.getAppKey()), inappHost, z);
            this.f9527g = true;
            ALog.m9183i(mo9100d(), "initAwcn success!", new Object[0]);
        } catch (Throwable th) {
            ALog.m9181e(mo9100d(), "initAwcn", th, new Object[0]);
        }
    }

    /* renamed from: a */
    public void m9130a(SessionCenter sessionCenter, String str, boolean z) {
        if (this.f9566v.contains(str)) {
            return;
        }
        sessionCenter.registerSessionInfo(SessionInfo.create(str, z, true, new a(this, str), null, this));
        sessionCenter.registerPublicKey(str, this.f9529i.getInappPubKey());
        this.f9566v.add(str);
        ALog.m9183i(mo9100d(), "registerSessionInfo", Constants.KEY_HOST, str);
    }

    /* renamed from: a */
    public void m9131a(AccsClientConfig accsClientConfig) {
        if (accsClientConfig == null) {
            ALog.m9183i(mo9100d(), "updateConfig null", new Object[0]);
            return;
        }
        if (accsClientConfig.equals(this.f9529i)) {
            ALog.m9186w(mo9100d(), "updateConfig not any changed", new Object[0]);
            return;
        }
        if (!this.f9527g) {
            if (UtilityImpl.isMainProcess(this.f9524d)) {
                this.f9529i = accsClientConfig;
                mo9083a(this.f9524d);
                return;
            }
            return;
        }
        try {
            boolean z = true;
            ALog.m9186w(mo9100d(), "updateConfig", "old", this.f9529i, "new", accsClientConfig);
            String inappHost = this.f9529i.getInappHost();
            String inappHost2 = accsClientConfig.getInappHost();
            SessionCenter sessionCenter = SessionCenter.getInstance(this.f9529i.getAppKey());
            if (sessionCenter == null) {
                ALog.m9186w(mo9100d(), "updateConfig not need update", new Object[0]);
                return;
            }
            sessionCenter.unregisterSessionInfo(inappHost);
            ALog.m9186w(mo9100d(), "updateConfig unregisterSessionInfo", Constants.KEY_HOST, inappHost);
            if (this.f9566v.contains(inappHost)) {
                this.f9566v.remove(inappHost);
                ALog.m9186w(mo9100d(), "updateConfig removeSessionRegistered", "oldHost", inappHost);
            }
            this.f9529i = accsClientConfig;
            this.f9522b = this.f9529i.getAppKey();
            this.f9533m = this.f9529i.getTag();
            String str = ConnType.PK_ACS;
            if (this.f9529i.getInappPubKey() == 10 || this.f9529i.getInappPubKey() == 11) {
                str = ConnType.PK_OPEN;
            }
            ALog.m9183i(mo9100d(), "update config register new conn protocol host:", this.f9529i.getInappHost());
            StrategyTemplate.getInstance().registerConnProtocol(this.f9529i.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, str, false));
            if (!mo9104h() || !this.f9529i.isKeepalive()) {
                ALog.m9183i(mo9100d(), "updateConfig close keepalive", new Object[0]);
                z = false;
            }
            m9130a(sessionCenter, inappHost2, z);
        } catch (Throwable th) {
            ALog.m9181e(mo9100d(), "updateConfig", th, new Object[0]);
        }
    }
}
