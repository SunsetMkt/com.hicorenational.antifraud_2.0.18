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
import com.just.agentweb.DefaultWebClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.PushAgent;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final int ACCS_RECEIVE_TIMEOUT = 40000;
    public static final int INAPP = 1;
    public static final int SERVICE = 0;

    /* JADX INFO: renamed from: n */
    protected static int f5798n;

    /* JADX INFO: renamed from: b */
    public String f5799b;

    /* JADX INFO: renamed from: c */
    protected int f5800c;

    /* JADX INFO: renamed from: d */
    protected Context f5801d;

    /* JADX INFO: renamed from: e */
    protected com.taobao.accs.data.d f5802e;

    /* JADX INFO: renamed from: h */
    public com.taobao.accs.client.b f5805h;

    /* JADX INFO: renamed from: i */
    public AccsClientConfig f5806i;

    /* JADX INFO: renamed from: j */
    protected String f5807j;

    /* JADX INFO: renamed from: m */
    public String f5810m;
    private Runnable r;
    private ScheduledFuture<?> s;
    public String a = "android@umeng";

    /* JADX INFO: renamed from: f */
    protected int f5803f = 0;
    private long o = 0;

    /* JADX INFO: renamed from: g */
    protected volatile boolean f5804g = false;

    /* JADX INFO: renamed from: k */
    protected String f5808k = null;
    private boolean p = false;

    /* JADX INFO: renamed from: l */
    protected LinkedHashMap<Integer, Message> f5809l = new LinkedHashMap<Integer, Message>() { // from class: com.taobao.accs.net.BaseConnection$1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Integer, Message> entry) {
            return size() > 10;
        }
    };
    private final ArrayList<AccsConnectStateListener> q = new ArrayList<>();

    protected a(Context context, int i2, String str) {
        this.f5799b = "";
        this.f5800c = i2;
        this.f5801d = context.getApplicationContext();
        this.f5806i = AccsClientConfig.getConfigByTag(str);
        if (this.f5806i == null) {
            ALog.e(d(), "BaseConnection config null!!", new Object[0]);
            try {
                PushAgent pushAgent = PushAgent.getInstance(context);
                pushAgent.register(pushAgent.getRegisterCallback());
                this.f5806i = AccsClientConfig.getConfigByTag(str);
            } catch (Throwable th) {
                ALog.e(d(), "BaseConnection build config", th, new Object[0]);
            }
        }
        AccsClientConfig accsClientConfig = this.f5806i;
        if (accsClientConfig != null) {
            this.f5810m = accsClientConfig.getTag();
            this.f5799b = this.f5806i.getAppKey();
        }
        this.f5802e = new com.taobao.accs.data.d(context, this);
        this.f5802e.f5764b = this.f5800c;
        ALog.d(d(), "new connection", new Object[0]);
    }

    protected String a(int i2) {
        return i2 != 1 ? i2 != 2 ? (i2 == 3 || i2 != 4) ? "DISCONNECTED" : "DISCONNECTING" : "CONNECTING" : "CONNECTED";
    }

    public abstract void a();

    public abstract void a(Message message, boolean z);

    protected void a(String str, boolean z, long j2) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new b(this, str, z), j2, TimeUnit.MILLISECONDS);
    }

    public abstract void a(String str, boolean z, String str2);

    public abstract void a(boolean z, boolean z2);

    public abstract boolean a(String str);

    public abstract void b();

    public void b(Message message, boolean z) {
        if (!message.isAck && !UtilityImpl.i(this.f5801d)) {
            ALog.e(d(), "sendMessage ready no network", Constants.KEY_DATA_ID, message.dataId);
            this.f5802e.a(message, -13);
            return;
        }
        long jA = message.getType() != 2 ? this.f5802e.f5766d.a(message.serviceId, message.bizId) : 0L;
        if (jA == -1) {
            ALog.e(d(), "sendMessage ready server limit high", Constants.KEY_DATA_ID, message.dataId);
            this.f5802e.a(message, ErrorCode.SERVIER_HIGH_LIMIT);
            return;
        }
        if (jA == -1000) {
            ALog.e(d(), "sendMessage ready server limit high for brush", Constants.KEY_DATA_ID, message.dataId);
            this.f5802e.a(message, ErrorCode.SERVIER_HIGH_LIMIT_BRUSH);
            return;
        }
        if (jA > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = this.o;
            if (jCurrentTimeMillis > j2) {
                message.delyTime = jA;
            } else {
                message.delyTime = (j2 + jA) - System.currentTimeMillis();
            }
            this.o = System.currentTimeMillis() + message.delyTime;
            ALog.e(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
        } else if ("accs".equals(message.serviceId)) {
            ALog.e(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
        } else if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
        }
        try {
            if (TextUtils.isEmpty(this.f5807j)) {
                this.f5807j = UtilityImpl.j(this.f5801d);
            }
            if (message.isTimeOut()) {
                this.f5802e.a(message, -9);
            } else {
                a(message, z);
            }
        } catch (RejectedExecutionException unused) {
            this.f5802e.a(message, ErrorCode.MESSAGE_QUEUE_FULL);
            ALog.e(d(), "sendMessage ready queue full", "size", Integer.valueOf(ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size()));
        }
    }

    public abstract com.taobao.accs.ut.a.c c();

    protected String c(String str) {
        String strEncode;
        String strJ = UtilityImpl.j(this.f5801d);
        try {
            strEncode = URLEncoder.encode(strJ);
        } catch (Throwable th) {
            ALog.e(d(), "buildAuthUrl", th, new Object[0]);
            strEncode = strJ;
        }
        String strA = UtilityImpl.a(i(), this.f5806i.getAppSecret(), strJ);
        StringBuilder sb = new StringBuilder(256);
        sb.append(str);
        sb.append("auth?1=");
        sb.append(strEncode);
        sb.append("&2=");
        sb.append(strA);
        sb.append("&3=");
        sb.append(i());
        if (this.f5808k != null) {
            sb.append("&4=");
            sb.append(this.f5808k);
        }
        sb.append("&5=");
        sb.append(this.f5800c);
        sb.append("&6=");
        sb.append(UtilityImpl.g(this.f5801d));
        sb.append("&7=");
        sb.append(UtilityImpl.d());
        sb.append("&8=");
        sb.append(this.f5800c == 1 ? com.luozm.captcha.b.f5337g : 221);
        sb.append("&9=");
        sb.append(System.currentTimeMillis());
        sb.append("&10=");
        sb.append(1);
        sb.append("&11=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("&12=");
        sb.append(this.f5801d.getPackageName());
        sb.append("&13=");
        sb.append(UtilityImpl.l(this.f5801d));
        sb.append("&14=");
        sb.append(this.a);
        sb.append("&15=");
        sb.append(UtilityImpl.b(Build.MODEL));
        sb.append("&16=");
        sb.append(UtilityImpl.b(Build.BRAND));
        sb.append("&17=");
        sb.append("221");
        sb.append("&19=");
        sb.append(!l() ? 1 : 0);
        sb.append("&20=");
        sb.append(this.f5806i.getStoreId());
        return sb.toString();
    }

    public abstract String d();

    public void e() {
    }

    protected void f() {
        if (this.r == null) {
            this.r = new c(this);
        }
        g();
        this.s = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.r, 40000L, TimeUnit.MILLISECONDS);
    }

    protected void g() {
        ScheduledFuture<?> scheduledFuture = this.s;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    protected boolean h() {
        return true;
    }

    public String i() {
        return this.f5799b;
    }

    public com.taobao.accs.client.b j() {
        if (this.f5805h == null) {
            ALog.d(d(), "new ClientManager", Constants.KEY_CONFIG_TAG, this.f5810m);
            this.f5805h = new com.taobao.accs.client.b(this.f5801d, this.f5810m);
        }
        return this.f5805h;
    }

    public void k() {
        try {
            ThreadPoolExecutorFactory.schedule(new d(this), com.heytap.mcssdk.constant.a.q, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            ALog.w(d(), "startChannelService", th, new Object[0]);
        }
    }

    public boolean l() {
        return 2 == this.f5806i.getSecurity();
    }

    public boolean m() {
        return false;
    }

    protected ArrayList<AccsConnectStateListener> n() {
        return this.q;
    }

    protected boolean a(Message message, int i2) {
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
        ALog.e(d(), "reSend dataid:" + message.dataId + " retryTimes:" + message.retryTimes, new Object[0]);
        b(message, true);
        try {
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().take_date = 0L;
                message.getNetPermanceMonitor().to_tnet_date = 0L;
                message.getNetPermanceMonitor().retry_times = message.retryTimes;
                if (message.retryTimes == 1) {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "total", 0.0d);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            this.f5802e.a(message, -8);
            ALog.e(d(), "reSend error", th, new Object[0]);
        }
        return z;
        this.f5802e.a(message, -8);
        ALog.e(d(), "reSend error", th, new Object[0]);
        return z;
    }

    protected void a(Context context) {
        try {
            ENV env = ENV.ONLINE;
            if (AccsClientConfig.mEnv == 2) {
                env = ENV.TEST;
                SessionCenter.switchEnvironment(env);
            } else if (AccsClientConfig.mEnv == 1) {
                env = ENV.PREPARE;
                SessionCenter.switchEnvironment(env);
            }
            SessionCenter.init(context, new Config.Builder().setAppkey(this.f5799b).setAppSecret(this.f5806i.getAppSecret()).setAuthCode(this.f5806i.getAuthCode()).setEnv(env).setTag(this.f5806i.getAppKey()).build());
            String str = ConnType.PK_ACS;
            if (this.f5806i.getInappPubKey() == 10 || this.f5806i.getInappPubKey() == 11) {
                str = ConnType.PK_OPEN;
            }
            ALog.i(d(), "init awcn register new conn protocol host:", this.f5806i.getInappHost());
            StrategyTemplate.getInstance().registerConnProtocol(this.f5806i.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, str, false));
        } catch (Throwable th) {
            ALog.e(d(), "initAwcn", th, new Object[0]);
        }
    }

    protected void b(int i2) {
        if (i2 < 0) {
            ALog.e(d(), "reSendAck", Constants.KEY_DATA_ID, Integer.valueOf(i2));
            Message message = this.f5809l.get(Integer.valueOf(i2));
            if (message != null) {
                a(message, 5000);
                com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, BaseMonitor.COUNT_ACK, 0.0d);
            }
        }
    }

    public void c(int i2) {
        f5798n = i2 != 1 ? 0 : 1;
    }

    public String b(String str) {
        String inappHost = this.f5806i.getInappHost();
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultWebClient.HTTPS_SCHEME);
        sb.append(TextUtils.isEmpty(str) ? "" : str);
        sb.append(inappHost);
        String string = sb.toString();
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(DefaultWebClient.HTTPS_SCHEME);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb2.append(str);
            sb2.append(inappHost);
            return sb2.toString();
        } catch (Throwable th) {
            ALog.e("InAppConnection", "getHost", th, new Object[0]);
            return string;
        }
    }

    public void a(AccsConnectStateListener accsConnectStateListener) {
        synchronized (this.q) {
            this.q.add(accsConnectStateListener);
        }
    }

    public void b(Message message, int i2) {
        this.f5802e.a(message, i2);
    }

    public void b(AccsConnectStateListener accsConnectStateListener) {
        synchronized (this.q) {
            this.q.remove(accsConnectStateListener);
        }
    }
}
