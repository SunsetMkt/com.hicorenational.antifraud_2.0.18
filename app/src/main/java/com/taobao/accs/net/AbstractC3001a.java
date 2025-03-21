package com.taobao.accs.net;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.Config;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import com.heytap.mcssdk.constant.C2084a;
import com.just.agentweb.DefaultWebClient;
import com.luozm.captcha.C2741b;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.client.C2979b;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.C2986d;
import com.taobao.accs.data.Message;
import com.taobao.accs.p199ut.p200a.C3028c;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C3043k;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.PushAgent;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.a */
/* loaded from: classes2.dex */
public abstract class AbstractC3001a {
    public static final int ACCS_RECEIVE_TIMEOUT = 40000;
    public static final int INAPP = 1;
    public static final int SERVICE = 0;

    /* renamed from: n */
    protected static int f9520n;

    /* renamed from: b */
    public String f9522b;

    /* renamed from: c */
    protected int f9523c;

    /* renamed from: d */
    protected Context f9524d;

    /* renamed from: e */
    protected C2986d f9525e;

    /* renamed from: h */
    public C2979b f9528h;

    /* renamed from: i */
    public AccsClientConfig f9529i;

    /* renamed from: j */
    protected String f9530j;

    /* renamed from: m */
    public String f9533m;

    /* renamed from: r */
    private Runnable f9537r;

    /* renamed from: s */
    private ScheduledFuture<?> f9538s;

    /* renamed from: a */
    public String f9521a = "android@umeng";

    /* renamed from: f */
    protected int f9526f = 0;

    /* renamed from: o */
    private long f9534o = 0;

    /* renamed from: g */
    protected volatile boolean f9527g = false;

    /* renamed from: k */
    protected String f9531k = null;

    /* renamed from: p */
    private boolean f9535p = false;

    /* renamed from: l */
    protected LinkedHashMap<Integer, Message> f9532l = new LinkedHashMap<Integer, Message>() { // from class: com.taobao.accs.net.BaseConnection$1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Integer, Message> entry) {
            return size() > 10;
        }
    };

    /* renamed from: q */
    private final ArrayList<AccsConnectStateListener> f9536q = new ArrayList<>();

    protected AbstractC3001a(Context context, int i2, String str) {
        this.f9522b = "";
        this.f9523c = i2;
        this.f9524d = context.getApplicationContext();
        this.f9529i = AccsClientConfig.getConfigByTag(str);
        if (this.f9529i == null) {
            ALog.m9182e(mo9100d(), "BaseConnection config null!!", new Object[0]);
            try {
                PushAgent pushAgent = PushAgent.getInstance(context);
                pushAgent.register(pushAgent.getRegisterCallback());
                this.f9529i = AccsClientConfig.getConfigByTag(str);
            } catch (Throwable th) {
                ALog.m9181e(mo9100d(), "BaseConnection build config", th, new Object[0]);
            }
        }
        AccsClientConfig accsClientConfig = this.f9529i;
        if (accsClientConfig != null) {
            this.f9533m = accsClientConfig.getTag();
            this.f9522b = this.f9529i.getAppKey();
        }
        this.f9525e = new C2986d(context, this);
        this.f9525e.f9468b = this.f9523c;
        ALog.m9180d(mo9100d(), "new connection", new Object[0]);
    }

    /* renamed from: a */
    protected String m9081a(int i2) {
        return i2 != 1 ? i2 != 2 ? (i2 == 3 || i2 != 4) ? "DISCONNECTED" : "DISCONNECTING" : "CONNECTING" : "CONNECTED";
    }

    /* renamed from: a */
    public abstract void mo9082a();

    /* renamed from: a */
    public abstract void mo9085a(Message message, boolean z);

    /* renamed from: a */
    protected void mo9086a(String str, boolean z, long j2) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new RunnableC3002b(this, str, z), j2, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public abstract void mo9087a(String str, boolean z, String str2);

    /* renamed from: a */
    public abstract void mo9088a(boolean z, boolean z2);

    /* renamed from: a */
    public abstract boolean mo9090a(String str);

    /* renamed from: b */
    public abstract void mo9092b();

    /* renamed from: b */
    public void m9096b(Message message, boolean z) {
        if (!message.isAck && !UtilityImpl.m9227i(this.f9524d)) {
            ALog.m9182e(mo9100d(), "sendMessage ready no network", Constants.KEY_DATA_ID, message.dataId);
            this.f9525e.m9026a(message, -13);
            return;
        }
        long m9056a = message.getType() != 2 ? this.f9525e.f9470d.m9056a(message.serviceId, message.bizId) : 0L;
        if (m9056a == -1) {
            ALog.m9182e(mo9100d(), "sendMessage ready server limit high", Constants.KEY_DATA_ID, message.dataId);
            this.f9525e.m9026a(message, ErrorCode.SERVIER_HIGH_LIMIT);
            return;
        }
        if (m9056a == -1000) {
            ALog.m9182e(mo9100d(), "sendMessage ready server limit high for brush", Constants.KEY_DATA_ID, message.dataId);
            this.f9525e.m9026a(message, ErrorCode.SERVIER_HIGH_LIMIT_BRUSH);
            return;
        }
        if (m9056a > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.f9534o;
            if (currentTimeMillis > j2) {
                message.delyTime = m9056a;
            } else {
                message.delyTime = (j2 + m9056a) - System.currentTimeMillis();
            }
            this.f9534o = System.currentTimeMillis() + message.delyTime;
            ALog.m9182e(mo9100d(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
        } else if ("accs".equals(message.serviceId)) {
            ALog.m9182e(mo9100d(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
        } else if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.m9180d(mo9100d(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
        }
        try {
            if (TextUtils.isEmpty(this.f9530j)) {
                this.f9530j = UtilityImpl.m9228j(this.f9524d);
            }
            if (message.isTimeOut()) {
                this.f9525e.m9026a(message, -9);
            } else {
                mo9085a(message, z);
            }
        } catch (RejectedExecutionException unused) {
            this.f9525e.m9026a(message, ErrorCode.MESSAGE_QUEUE_FULL);
            ALog.m9182e(mo9100d(), "sendMessage ready queue full", "size", Integer.valueOf(ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size()));
        }
    }

    /* renamed from: c */
    public abstract C3028c mo9097c();

    /* renamed from: c */
    protected String m9098c(String str) {
        String str2;
        String m9228j = UtilityImpl.m9228j(this.f9524d);
        try {
            str2 = URLEncoder.encode(m9228j);
        } catch (Throwable th) {
            ALog.m9181e(mo9100d(), "buildAuthUrl", th, new Object[0]);
            str2 = m9228j;
        }
        String m9197a = UtilityImpl.m9197a(m9105i(), this.f9529i.getAppSecret(), m9228j);
        StringBuilder sb = new StringBuilder(256);
        sb.append(str);
        sb.append("auth?1=");
        sb.append(str2);
        sb.append("&2=");
        sb.append(m9197a);
        sb.append("&3=");
        sb.append(m9105i());
        if (this.f9531k != null) {
            sb.append("&4=");
            sb.append(this.f9531k);
        }
        sb.append("&5=");
        sb.append(this.f9523c);
        sb.append("&6=");
        sb.append(UtilityImpl.m9223g(this.f9524d));
        sb.append("&7=");
        sb.append(UtilityImpl.m9215d());
        sb.append("&8=");
        sb.append(this.f9523c == 1 ? C2741b.f8474g : 221);
        sb.append("&9=");
        sb.append(System.currentTimeMillis());
        sb.append("&10=");
        sb.append(1);
        sb.append("&11=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("&12=");
        sb.append(this.f9524d.getPackageName());
        sb.append("&13=");
        sb.append(UtilityImpl.m9230l(this.f9524d));
        sb.append("&14=");
        sb.append(this.f9521a);
        sb.append("&15=");
        sb.append(UtilityImpl.m9209b(Build.MODEL));
        sb.append("&16=");
        sb.append(UtilityImpl.m9209b(Build.BRAND));
        sb.append("&17=");
        sb.append("221");
        sb.append("&19=");
        sb.append(!m9108l() ? 1 : 0);
        sb.append("&20=");
        sb.append(this.f9529i.getStoreId());
        return sb.toString();
    }

    /* renamed from: d */
    public abstract String mo9100d();

    /* renamed from: e */
    public void mo9101e() {
    }

    /* renamed from: f */
    protected void m9102f() {
        if (this.f9537r == null) {
            this.f9537r = new RunnableC3003c(this);
        }
        m9103g();
        this.f9538s = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.f9537r, 40000L, TimeUnit.MILLISECONDS);
    }

    /* renamed from: g */
    protected void m9103g() {
        ScheduledFuture<?> scheduledFuture = this.f9538s;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    /* renamed from: h */
    protected boolean mo9104h() {
        return true;
    }

    /* renamed from: i */
    public String m9105i() {
        return this.f9522b;
    }

    /* renamed from: j */
    public C2979b m9106j() {
        if (this.f9528h == null) {
            ALog.m9180d(mo9100d(), "new ClientManager", Constants.KEY_CONFIG_TAG, this.f9533m);
            this.f9528h = new C2979b(this.f9524d, this.f9533m);
        }
        return this.f9528h;
    }

    /* renamed from: k */
    public void m9107k() {
        try {
            ThreadPoolExecutorFactory.schedule(new RunnableC3004d(this), C2084a.f6135q, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            ALog.m9185w(mo9100d(), "startChannelService", th, new Object[0]);
        }
    }

    /* renamed from: l */
    public boolean m9108l() {
        return 2 == this.f9529i.getSecurity();
    }

    /* renamed from: m */
    public boolean mo9109m() {
        return false;
    }

    /* renamed from: n */
    protected ArrayList<AccsConnectStateListener> m9110n() {
        return this.f9536q;
    }

    /* renamed from: a */
    protected boolean m9089a(Message message, int i2) {
        boolean z = true;
        try {
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        if (message.retryTimes > 3) {
            return false;
        }
        message.retryTimes++;
        message.delyTime = i2;
        ALog.m9182e(mo9100d(), "reSend dataid:" + message.dataId + " retryTimes:" + message.retryTimes, new Object[0]);
        m9096b(message, true);
        try {
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().take_date = 0L;
                message.getNetPermanceMonitor().to_tnet_date = 0L;
                message.getNetPermanceMonitor().retry_times = message.retryTimes;
                if (message.retryTimes == 1) {
                    C3043k.m9250a("accs", BaseMonitor.COUNT_POINT_RESEND, "total", 0.0d);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            this.f9525e.m9026a(message, -8);
            ALog.m9181e(mo9100d(), "reSend error", th, new Object[0]);
            return z;
        }
        return z;
    }

    /* renamed from: a */
    protected void mo9083a(Context context) {
        try {
            ENV env = ENV.ONLINE;
            if (AccsClientConfig.mEnv == 2) {
                env = ENV.TEST;
                SessionCenter.switchEnvironment(env);
            } else if (AccsClientConfig.mEnv == 1) {
                env = ENV.PREPARE;
                SessionCenter.switchEnvironment(env);
            }
            SessionCenter.init(context, new Config.Builder().setAppkey(this.f9522b).setAppSecret(this.f9529i.getAppSecret()).setAuthCode(this.f9529i.getAuthCode()).setEnv(env).setTag(this.f9529i.getAppKey()).build());
            String str = ConnType.PK_ACS;
            if (this.f9529i.getInappPubKey() == 10 || this.f9529i.getInappPubKey() == 11) {
                str = ConnType.PK_OPEN;
            }
            ALog.m9183i(mo9100d(), "init awcn register new conn protocol host:", this.f9529i.getInappHost());
            StrategyTemplate.getInstance().registerConnProtocol(this.f9529i.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, str, false));
        } catch (Throwable th) {
            ALog.m9181e(mo9100d(), "initAwcn", th, new Object[0]);
        }
    }

    /* renamed from: b */
    protected void m9093b(int i2) {
        if (i2 < 0) {
            ALog.m9182e(mo9100d(), "reSendAck", Constants.KEY_DATA_ID, Integer.valueOf(i2));
            Message message = this.f9532l.get(Integer.valueOf(i2));
            if (message != null) {
                m9089a(message, 5000);
                C3043k.m9250a("accs", BaseMonitor.COUNT_POINT_RESEND, BaseMonitor.COUNT_ACK, 0.0d);
            }
        }
    }

    /* renamed from: c */
    public void mo9099c(int i2) {
        f9520n = i2 != 1 ? 0 : 1;
    }

    /* renamed from: b */
    public String mo9091b(String str) {
        String inappHost = this.f9529i.getInappHost();
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultWebClient.HTTPS_SCHEME);
        sb.append(TextUtils.isEmpty(str) ? "" : str);
        sb.append(inappHost);
        String sb2 = sb.toString();
        try {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(DefaultWebClient.HTTPS_SCHEME);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb3.append(str);
            sb3.append(inappHost);
            return sb3.toString();
        } catch (Throwable th) {
            ALog.m9181e("InAppConnection", "getHost", th, new Object[0]);
            return sb2;
        }
    }

    /* renamed from: a */
    public void m9084a(AccsConnectStateListener accsConnectStateListener) {
        synchronized (this.f9536q) {
            this.f9536q.add(accsConnectStateListener);
        }
    }

    /* renamed from: b */
    public void m9095b(Message message, int i2) {
        this.f9525e.m9026a(message, i2);
    }

    /* renamed from: b */
    public void m9094b(AccsConnectStateListener accsConnectStateListener) {
        synchronized (this.f9536q) {
            this.f9536q.remove(accsConnectStateListener);
        }
    }
}
