package com.taobao.accs.net;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.strategy.IConnStrategy;
import anet.channel.util.HttpConstant;
import com.heytap.mcssdk.constant.C2084a;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.just.agentweb.DefaultWebClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.C2986d;
import com.taobao.accs.data.Message;
import com.taobao.accs.p199ut.monitor.SessionMonitor;
import com.taobao.accs.p199ut.monitor.TrafficsMonitor;
import com.taobao.accs.p199ut.p200a.C3028c;
import com.taobao.accs.p199ut.p200a.C3029d;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C3043k;
import com.taobao.accs.utl.C3049q;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.Spdycb;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p286h.C5230f1;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.v */
/* loaded from: classes2.dex */
public class C3022v extends AbstractC3001a implements SessionCb, Spdycb {

    /* renamed from: A */
    private SpdySession f9593A;

    /* renamed from: B */
    private Object f9594B;

    /* renamed from: C */
    private long f9595C;

    /* renamed from: D */
    private long f9596D;

    /* renamed from: E */
    private long f9597E;

    /* renamed from: F */
    private long f9598F;

    /* renamed from: G */
    private int f9599G;

    /* renamed from: H */
    private String f9600H;

    /* renamed from: I */
    private SessionMonitor f9601I;

    /* renamed from: J */
    private C3028c f9602J;

    /* renamed from: K */
    private boolean f9603K;

    /* renamed from: L */
    private String f9604L;

    /* renamed from: M */
    private boolean f9605M;

    /* renamed from: N */
    private C3008h f9606N;

    /* renamed from: O */
    private String f9607O;

    /* renamed from: o */
    protected ScheduledFuture<?> f9608o;

    /* renamed from: p */
    protected String f9609p;

    /* renamed from: q */
    protected int f9610q;

    /* renamed from: r */
    protected String f9611r;

    /* renamed from: s */
    protected int f9612s;

    /* renamed from: t */
    private int f9613t;

    /* renamed from: u */
    private LinkedList<Message> f9614u;

    /* renamed from: v */
    private a f9615v;

    /* renamed from: w */
    private boolean f9616w;

    /* renamed from: x */
    private String f9617x;

    /* renamed from: y */
    private String f9618y;

    /* renamed from: z */
    private SpdyAgent f9619z;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.accs.net.v$a */
    private class a extends Thread {

        /* renamed from: a */
        public int f9620a;

        /* renamed from: b */
        long f9621b;

        /* renamed from: d */
        private final String f9623d;

        public a(String str) {
            super(str);
            this.f9623d = getName();
            this.f9620a = 0;
        }

        /* renamed from: a */
        private void m9163a(boolean z) {
            if (C3022v.this.f9613t == 1) {
                if (C3022v.this.f9613t != 1 || System.currentTimeMillis() - this.f9621b <= C2084a.f6136r) {
                    return;
                }
                this.f9620a = 0;
                return;
            }
            ALog.m9180d(C3022v.this.mo9100d(), "tryConnect", "force", Boolean.valueOf(z));
            if (!UtilityImpl.m9227i(C3022v.this.f9524d)) {
                ALog.m9182e(this.f9623d, "Network not available", new Object[0]);
                return;
            }
            if (z) {
                this.f9620a = 0;
            }
            ALog.m9183i(this.f9623d, "tryConnect", "force", Boolean.valueOf(z), "failTimes", Integer.valueOf(this.f9620a));
            if (C3022v.this.f9613t != 1 && this.f9620a >= 4) {
                C3022v.this.f9603K = true;
                ALog.m9182e(this.f9623d, "tryConnect fail", "maxTimes", 4);
                return;
            }
            if (C3022v.this.f9613t != 1) {
                if (C3022v.this.f9523c == 1 && this.f9620a == 0) {
                    ALog.m9183i(this.f9623d, "tryConnect in app, no sleep", new Object[0]);
                } else {
                    ALog.m9183i(this.f9623d, "tryConnect, need sleep", new Object[0]);
                    try {
                        Thread.sleep(C2084a.f6136r);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                C3022v.this.f9604L = "";
                if (this.f9620a == 3) {
                    C3022v.this.f9606N.m9124b(C3022v.this.m9161p());
                }
                C3022v.this.m9149d((String) null);
                C3022v.this.f9601I.setRetryTimes(this.f9620a);
                if (C3022v.this.f9613t == 1) {
                    this.f9621b = System.currentTimeMillis();
                    return;
                }
                this.f9620a++;
                ALog.m9182e(this.f9623d, "try connect fail, ready for reconnect", new Object[0]);
                m9163a(false);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Message message;
            boolean z;
            ALog.m9183i(this.f9623d, "NetworkThread run", new Object[0]);
            this.f9620a = 0;
            Message message2 = null;
            while (C3022v.this.f9616w) {
                ALog.m9180d(this.f9623d, "ready to get message", new Object[0]);
                synchronized (C3022v.this.f9614u) {
                    if (C3022v.this.f9614u.size() == 0) {
                        try {
                            ALog.m9180d(this.f9623d, "no message, wait", new Object[0]);
                            C3022v.this.f9614u.wait();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                    ALog.m9180d(this.f9623d, "try get message", new Object[0]);
                    if (C3022v.this.f9614u.size() != 0) {
                        message2 = (Message) C3022v.this.f9614u.getFirst();
                        if (message2.getNetPermanceMonitor() != null) {
                            message2.getNetPermanceMonitor().onTakeFromQueue();
                        }
                    }
                    message = message2;
                }
                if (!C3022v.this.f9616w) {
                    break;
                }
                if (message != null) {
                    ALog.m9180d(this.f9623d, "sendMessage not null", new Object[0]);
                    try {
                        int type = message.getType();
                        ALog.m9183i(this.f9623d, "sendMessage", "type", Message.MsgType.name(type), NotificationCompat.CATEGORY_STATUS, Integer.valueOf(C3022v.this.f9613t));
                        if (type != 2) {
                            if (type == 1) {
                                m9163a(true);
                                if (C3022v.this.f9613t == 1 && C3022v.this.f9593A != null) {
                                    byte[] build = message.build(C3022v.this.f9524d, C3022v.this.f9523c);
                                    message.setSendTime(System.currentTimeMillis());
                                    if (build.length <= 49152 || message.command.intValue() == 102) {
                                        int id = message.isAck ? -message.getMsgId().getId() : message.getMsgId().getId();
                                        C3022v.this.f9593A.sendCustomControlFrame(id, 200, 0, build == null ? 0 : build.length, build);
                                        String str = this.f9623d;
                                        Object[] objArr = new Object[6];
                                        objArr[0] = "length";
                                        objArr[1] = Integer.valueOf(build == null ? 0 : build.length);
                                        objArr[2] = Constants.KEY_DATA_ID;
                                        objArr[3] = message.getDataId();
                                        objArr[4] = "utdid";
                                        objArr[5] = C3022v.this.f9530j;
                                        ALog.m9182e(str, "send data", objArr);
                                        C3022v.this.f9525e.m9025a(message);
                                        if (message.isAck) {
                                            ALog.m9182e(this.f9623d, "sendCFrame end ack", Constants.KEY_DATA_ID, Integer.valueOf(id));
                                            C3022v.this.f9532l.put(Integer.valueOf(id), message);
                                        }
                                        if (message.getNetPermanceMonitor() != null) {
                                            message.getNetPermanceMonitor().onSendData();
                                        }
                                        C3022v.this.mo9086a(message.getDataId(), C3022v.this.f9529i.isQuickReconnect(), message.timeout);
                                        C3022v.this.f9525e.m9029a(new TrafficsMonitor.C3032a(message.serviceId, GlobalAppRuntimeInfo.isAppBackground(), C3022v.this.m9161p(), build.length));
                                    } else {
                                        C3022v.this.f9525e.m9026a(message, -4);
                                    }
                                }
                                z = false;
                            } else {
                                m9163a(false);
                                ALog.m9182e(this.f9623d, "skip msg", "type", Integer.valueOf(type));
                            }
                            z = true;
                        } else if (C3022v.this.f9523c == 1) {
                            ALog.m9180d(this.f9623d, "sendMessage INAPP ping, skip", new Object[0]);
                            try {
                                ALog.m9180d(this.f9623d, "send succ, remove it", new Object[0]);
                                synchronized (C3022v.this.f9614u) {
                                    C3022v.this.f9614u.remove(message);
                                }
                            } catch (Throwable th) {
                                ALog.m9181e(this.f9623d, " run finally error", th, new Object[0]);
                            }
                        } else {
                            if (System.currentTimeMillis() - C3022v.this.f9595C < (AbstractC3007g.m9112a(C3022v.this.f9524d).m9115b() - 1) * 1000 && !message.force) {
                                m9163a(false);
                                z = true;
                            }
                            ALog.m9180d(this.f9623d, "sendMessage", "force", Boolean.valueOf(message.force), "last ping", Long.valueOf(System.currentTimeMillis() - C3022v.this.f9595C));
                            m9163a(true);
                            if (C3022v.this.f9593A != null && C3022v.this.f9613t == 1) {
                                if (System.currentTimeMillis() - C3022v.this.f9595C >= (AbstractC3007g.m9112a(C3022v.this.f9524d).m9115b() - 1) * 1000) {
                                    ALog.m9183i(this.f9623d, "sendMessage onSendPing", new Object[0]);
                                    C3022v.this.f9525e.m9023a();
                                    C3022v.this.f9593A.submitPing();
                                    C3022v.this.f9601I.onSendPing();
                                    C3022v.this.f9595C = System.currentTimeMillis();
                                    C3022v.this.f9596D = System.nanoTime();
                                    C3022v.this.m9102f();
                                }
                                z = true;
                            }
                            z = false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z = true;
                    }
                    try {
                        C3022v.this.m9158t();
                        if (z) {
                            ALog.m9180d(this.f9623d, "send succ, remove it", new Object[0]);
                            synchronized (C3022v.this.f9614u) {
                                C3022v.this.f9614u.remove(message);
                            }
                        } else {
                            try {
                                C3022v.this.m9160o();
                                if (C3022v.this.f9601I != null) {
                                    C3022v.this.f9601I.setCloseReason("send fail");
                                }
                                synchronized (C3022v.this.f9614u) {
                                    for (int size = C3022v.this.f9614u.size() - 1; size >= 0; size--) {
                                        Message message3 = (Message) C3022v.this.f9614u.get(size);
                                        if (message3 != null && message3.command != null && (message3.command.intValue() == 100 || message3.command.intValue() == 201)) {
                                            C3022v.this.f9525e.m9026a(message3, -1);
                                            C3022v.this.f9614u.remove(size);
                                        }
                                    }
                                    ALog.m9182e(this.f9623d, "network disconnected, wait", new Object[0]);
                                    C3022v.this.f9614u.wait();
                                }
                            } catch (Throwable th3) {
                                ALog.m9181e(this.f9623d, " run finally error", th3, new Object[0]);
                            }
                        }
                        ALog.m9181e(this.f9623d, " run finally error", th3, new Object[0]);
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, message.serviceId, "1", C3022v.this.f9523c + th.toString());
                            th.printStackTrace();
                            ALog.m9181e(this.f9623d, "service connection run", th, new Object[0]);
                            if (z) {
                                ALog.m9180d(this.f9623d, "send succ, remove it", new Object[0]);
                                synchronized (C3022v.this.f9614u) {
                                    C3022v.this.f9614u.remove(message);
                                }
                                message2 = message;
                            } else {
                                try {
                                    C3022v.this.m9160o();
                                    if (C3022v.this.f9601I != null) {
                                        C3022v.this.f9601I.setCloseReason("send fail");
                                    }
                                    synchronized (C3022v.this.f9614u) {
                                        for (int size2 = C3022v.this.f9614u.size() - 1; size2 >= 0; size2--) {
                                            Message message4 = (Message) C3022v.this.f9614u.get(size2);
                                            if (message4 != null && message4.command != null && (message4.command.intValue() == 100 || message4.command.intValue() == 201)) {
                                                C3022v.this.f9525e.m9026a(message4, -1);
                                                C3022v.this.f9614u.remove(size2);
                                            }
                                        }
                                        ALog.m9182e(this.f9623d, "network disconnected, wait", new Object[0]);
                                        C3022v.this.f9614u.wait();
                                    }
                                } catch (Throwable th5) {
                                    ALog.m9181e(this.f9623d, " run finally error", th5, new Object[0]);
                                }
                                message2 = message;
                            }
                            ALog.m9181e(this.f9623d, " run finally error", th5, new Object[0]);
                            message2 = message;
                        } catch (Throwable th6) {
                            try {
                                if (z) {
                                    ALog.m9180d(this.f9623d, "send succ, remove it", new Object[0]);
                                    synchronized (C3022v.this.f9614u) {
                                        C3022v.this.f9614u.remove(message);
                                        throw th6;
                                    }
                                }
                                C3022v.this.m9160o();
                                if (C3022v.this.f9601I != null) {
                                    C3022v.this.f9601I.setCloseReason("send fail");
                                }
                                synchronized (C3022v.this.f9614u) {
                                    for (int size3 = C3022v.this.f9614u.size() - 1; size3 >= 0; size3--) {
                                        Message message5 = (Message) C3022v.this.f9614u.get(size3);
                                        if (message5 != null && message5.command != null && (message5.command.intValue() == 100 || message5.command.intValue() == 201)) {
                                            C3022v.this.f9525e.m9026a(message5, -1);
                                            C3022v.this.f9614u.remove(size3);
                                        }
                                    }
                                    ALog.m9182e(this.f9623d, "network disconnected, wait", new Object[0]);
                                    C3022v.this.f9614u.wait();
                                    throw th6;
                                }
                            } catch (Throwable th7) {
                                ALog.m9181e(this.f9623d, " run finally error", th7, new Object[0]);
                                throw th6;
                            }
                            ALog.m9181e(this.f9623d, " run finally error", th7, new Object[0]);
                            throw th6;
                        }
                    }
                }
                message2 = message;
            }
            C3022v.this.m9160o();
        }
    }

    public C3022v(Context context, int i2, String str) {
        super(context, i2, str);
        this.f9613t = 3;
        this.f9614u = new LinkedList<>();
        this.f9616w = true;
        this.f9619z = null;
        this.f9593A = null;
        this.f9594B = new Object();
        this.f9599G = -1;
        this.f9600H = null;
        this.f9603K = false;
        this.f9604L = "";
        this.f9605M = false;
        this.f9606N = new C3008h(m9161p());
        m9159u();
    }

    /* renamed from: r */
    private int m9156r() {
        boolean m9108l = m9108l();
        if (AccsClientConfig.mEnv == 2) {
            return 0;
        }
        int channelPubKey = this.f9529i.getChannelPubKey();
        if (channelPubKey <= 0) {
            return m9108l ? 4 : 3;
        }
        ALog.m9183i(mo9100d(), "getPublicKeyType use custom pub key", "pubKey", Integer.valueOf(channelPubKey));
        return channelPubKey;
    }

    /* renamed from: s */
    private void m9157s() {
        if (this.f9593A == null) {
            m9148d(3);
            return;
        }
        try {
            String encode = URLEncoder.encode(UtilityImpl.m9228j(this.f9524d));
            String m9197a = UtilityImpl.m9197a(m9105i(), this.f9529i.getAppSecret(), UtilityImpl.m9228j(this.f9524d));
            String m9098c = m9098c(this.f9617x);
            ALog.m9182e(mo9100d(), "auth", "url", m9098c);
            this.f9618y = m9098c;
            if (!m9141a(encode, m9105i(), m9197a)) {
                ALog.m9182e(mo9100d(), "auth param error!", new Object[0]);
                m9151e(-6);
            } else {
                SpdyRequest spdyRequest = new SpdyRequest(new URL(m9098c), "GET", RequestPriority.DEFAULT_PRIORITY, 80000, AbstractC3001a.ACCS_RECEIVE_TIMEOUT);
                spdyRequest.setDomain(m9161p());
                this.f9593A.submitRequest(spdyRequest, new SpdyDataProvider((byte[]) null), m9161p(), this);
            }
        } catch (Throwable th) {
            ALog.m9181e(mo9100d(), "auth exception ", th, new Object[0]);
            m9151e(-7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public synchronized void m9158t() {
        if (this.f9523c == 1) {
            return;
        }
        this.f9595C = System.currentTimeMillis();
        this.f9596D = System.nanoTime();
        AbstractC3007g.m9112a(this.f9524d).m9114a();
    }

    /* renamed from: u */
    private void m9159u() {
        try {
            SpdyAgent.enableDebug = ALog.isPrintLog();
            this.f9619z = SpdyAgent.getInstance(this.f9524d, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
            if (SpdyAgent.checkLoadSucc()) {
                C3049q.m9264a();
            } else {
                ALog.m9182e(mo9100d(), "initClient", new Object[0]);
                this.f9619z = null;
                C3049q.m9265b();
            }
        } catch (Throwable th) {
            ALog.m9181e(mo9100d(), "initClient", th, new Object[0]);
        }
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i2) {
        ALog.m9186w(mo9100d(), "bioPingRecvCallback uniId:" + i2, new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        spdySession.getDomain();
        return UtilityImpl.m9214c();
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: h */
    protected boolean mo9104h() {
        return false;
    }

    /* renamed from: o */
    public void m9160o() {
        ALog.m9182e(mo9100d(), " force close!", new Object[0]);
        try {
            this.f9593A.closeSession();
            this.f9601I.setCloseType(1);
        } catch (Exception unused) {
        }
        m9148d(3);
    }

    /* renamed from: p */
    public String m9161p() {
        String channelHost = this.f9529i.getChannelHost();
        ALog.m9183i(mo9100d(), "getChannelHost", Constants.KEY_HOST, channelHost);
        return channelHost == null ? "" : channelHost;
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        spdySession.getDomain();
        return UtilityImpl.m9207b();
    }

    /* renamed from: q */
    public boolean m9162q() {
        return this.f9616w;
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i2, int i3) {
        m9093b(i2);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i2, int i3, int i4, int i5, byte[] bArr) {
        m9158t();
        ALog.m9182e(mo9100d(), "onFrame", "type", Integer.valueOf(i3), "len", Integer.valueOf(bArr.length));
        StringBuilder sb = new StringBuilder();
        if (ALog.isPrintLog(ALog.Level.D) && bArr.length < 512) {
            long currentTimeMillis = System.currentTimeMillis();
            for (byte b2 : bArr) {
                sb.append(Integer.toHexString(b2 & C5230f1.f20085c));
                sb.append(AbstractC1191a.f2568g);
            }
            ALog.m9180d(mo9100d(), ((Object) sb) + " log time:" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        }
        if (i3 == 200) {
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                this.f9525e.m9030a(bArr);
                C3029d m9039g = this.f9525e.m9039g();
                if (m9039g != null) {
                    m9039g.f9656c = String.valueOf(currentTimeMillis2);
                    m9039g.f9660g = this.f9523c == 0 ? "service" : "inapp";
                    m9039g.m9173a();
                }
            } catch (Throwable th) {
                ALog.m9181e(mo9100d(), "onDataReceive ", th, new Object[0]);
                UTMini.getInstance().commitEvent(66001, "SERVICE_DATA_RECEIVE", UtilityImpl.m9198a(th));
            }
            ALog.m9180d(mo9100d(), "try handle msg", new Object[0]);
            m9103g();
        } else {
            ALog.m9182e(mo9100d(), "drop frame", "len", Integer.valueOf(bArr.length));
        }
        ALog.m9180d(mo9100d(), "spdyCustomControlFrameRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j2, SpdyByteArray spdyByteArray, Object obj) {
        ALog.m9180d(mo9100d(), "spdyDataChunkRecvCB", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataRecvCallback(SpdySession spdySession, boolean z, long j2, int i2, Object obj) {
        ALog.m9180d(mo9100d(), "spdyDataRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataSendCallback(SpdySession spdySession, boolean z, long j2, int i2, Object obj) {
        ALog.m9180d(mo9100d(), "spdyDataSendCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyOnStreamResponse(SpdySession spdySession, long j2, Map<String, List<String>> map, Object obj) {
        this.f9595C = System.currentTimeMillis();
        this.f9596D = System.nanoTime();
        try {
            Map<String, String> m9200a = UtilityImpl.m9200a(map);
            ALog.m9180d("SilenceConn_", "spdyOnStreamResponse", "header", map);
            int parseInt = Integer.parseInt(m9200a.get(HttpConstant.STATUS));
            ALog.m9182e(mo9100d(), "spdyOnStreamResponse", "httpStatusCode", Integer.valueOf(parseInt));
            if (parseInt == 200) {
                m9148d(1);
                String str = m9200a.get("x-at");
                if (!TextUtils.isEmpty(str)) {
                    this.f9531k = str;
                }
                this.f9601I.auth_time = this.f9601I.connection_stop_date > 0 ? System.currentTimeMillis() - this.f9601I.connection_stop_date : 0L;
                String str2 = this.f9523c == 0 ? "service" : "inapp";
                UTMini.getInstance().commitEvent(66001, "CONNECTED 200 " + str2, (Object) this.f9618y, (Object) this.f9604L, (Object) 221, "0");
                C3043k.m9249a("accs", "auth", "");
            } else {
                m9151e(parseInt);
            }
        } catch (Exception e2) {
            ALog.m9182e(mo9100d(), e2.toString(), new Object[0]);
            m9160o();
            this.f9601I.setCloseReason("exception");
        }
        ALog.m9180d(mo9100d(), "spdyOnStreamResponse", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j2, Object obj) {
        ALog.m9180d(mo9100d(), "spdyPingRecvCallback uniId:" + j2, new Object[0]);
        if (j2 < 0) {
            return;
        }
        this.f9525e.m9033b();
        AbstractC3007g.m9112a(this.f9524d).m9118e();
        AbstractC3007g.m9112a(this.f9524d).m9114a();
        this.f9601I.onPingCBReceive();
        if (this.f9601I.ping_rec_times % 2 == 0) {
            UtilityImpl.m9201a(this.f9524d, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
        }
    }

    @Override // org.android.spdy.Spdycb
    public void spdyRequestRecvCallback(SpdySession spdySession, long j2, Object obj) {
        ALog.m9180d(mo9100d(), "spdyRequestRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i2) {
        ALog.m9182e(mo9100d(), "spdySessionCloseCallback", Constants.KEY_ERROR_CODE, Integer.valueOf(i2));
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.m9182e(mo9100d(), "session cleanUp has exception: " + e2, new Object[0]);
            }
        }
        m9148d(3);
        this.f9601I.onCloseConnect();
        if (this.f9601I.getConCloseDate() > 0 && this.f9601I.getConStopDate() > 0) {
            this.f9601I.getConCloseDate();
            this.f9601I.getConStopDate();
        }
        this.f9601I.setCloseReason(this.f9601I.getCloseReason() + "tnet error:" + i2);
        if (superviseConnectInfo != null) {
            this.f9601I.live_time = superviseConnectInfo.keepalive_period_second;
        }
        AppMonitor.getInstance().commitStat(this.f9601I);
        for (Message message : this.f9525e.m9037e()) {
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().setRet(false);
                message.getNetPermanceMonitor().setFailReason("session close");
                AppMonitor.getInstance().commitStat(message.getNetPermanceMonitor());
            }
        }
        String str = this.f9523c == 0 ? "service" : "inapp";
        ALog.m9180d(mo9100d(), "spdySessionCloseCallback, conKeepTime:" + this.f9601I.live_time + " connectType:" + str, new Object[0]);
        UTMini uTMini = UTMini.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("DISCONNECT CLOSE ");
        sb.append(str);
        uTMini.commitEvent(66001, sb.toString(), (Object) Integer.valueOf(i2), (Object) Long.valueOf(this.f9601I.live_time), (Object) 221, this.f9618y, this.f9604L);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        this.f9599G = superviseConnectInfo.connectTime;
        int i2 = superviseConnectInfo.handshakeTime;
        ALog.m9182e(mo9100d(), "spdySessionConnectCB", "sessionConnectInterval", Integer.valueOf(this.f9599G), "sslTime", Integer.valueOf(i2), "reuse", Integer.valueOf(superviseConnectInfo.sessionTicketReused));
        m9157s();
        this.f9601I.setRet(true);
        this.f9601I.onConnectStop();
        SessionMonitor sessionMonitor = this.f9601I;
        sessionMonitor.tcp_time = this.f9599G;
        sessionMonitor.ssl_time = i2;
        String str = this.f9523c == 0 ? "service" : "inapp";
        UTMini.getInstance().commitEvent(66001, "CONNECTED " + str + AbstractC1191a.f2568g + superviseConnectInfo.sessionTicketReused, (Object) String.valueOf(this.f9599G), (Object) String.valueOf(i2), (Object) 221, String.valueOf(superviseConnectInfo.sessionTicketReused), this.f9618y, this.f9604L);
        C3043k.m9249a("accs", BaseMonitor.ALARM_POINT_CONNECT, "");
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i2, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.m9182e(mo9100d(), "session cleanUp has exception: " + e2, new Object[0]);
            }
        }
        a aVar = this.f9615v;
        int i3 = aVar != null ? aVar.f9620a : 0;
        ALog.m9182e(mo9100d(), "spdySessionFailedError", "retryTimes", Integer.valueOf(i3), "errorId", Integer.valueOf(i2));
        this.f9603K = false;
        this.f9605M = true;
        m9148d(3);
        this.f9601I.setFailReason(i2);
        this.f9601I.onConnectStop();
        String str = this.f9523c == 0 ? "service" : "inapp";
        UTMini.getInstance().commitEvent(66001, "DISCONNECT " + str, (Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3), (Object) 221, this.f9618y, this.f9604L);
        C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_CONNECT, "retrytimes:" + i3, i2 + "", "");
    }

    @Override // org.android.spdy.Spdycb
    public void spdyStreamCloseCallback(SpdySession spdySession, long j2, int i2, Object obj, SuperviseData superviseData) {
        ALog.m9180d(mo9100d(), "spdyStreamCloseCallback", new Object[0]);
        if (i2 != 0) {
            ALog.m9182e(mo9100d(), "spdyStreamCloseCallback", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i2));
            m9151e(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m9149d(String str) {
        SessionInfo sessionInfo;
        int i2 = this.f9613t;
        if (i2 == 2 || i2 == 1) {
            return;
        }
        if (this.f9606N == null) {
            this.f9606N = new C3008h(m9161p());
        }
        List<IConnStrategy> m9122a = this.f9606N.m9122a(m9161p());
        int i3 = Constants.PORT;
        if (m9122a == null || m9122a.size() <= 0) {
            if (str != null) {
                this.f9609p = str;
            } else {
                this.f9609p = m9161p();
            }
            if (System.currentTimeMillis() % 2 == 0) {
                i3 = 80;
            }
            this.f9610q = i3;
            C3043k.m9250a("accs", BaseMonitor.COUNT_POINT_DNS, "localdns", 0.0d);
            ALog.m9183i(mo9100d(), "connect get ip from amdc fail!!", new Object[0]);
        } else {
            for (IConnStrategy iConnStrategy : m9122a) {
                if (iConnStrategy != null) {
                    ALog.m9182e(mo9100d(), BaseMonitor.ALARM_POINT_CONNECT, "ip", iConnStrategy.getIp(), "port", Integer.valueOf(iConnStrategy.getPort()));
                }
            }
            if (this.f9605M) {
                this.f9606N.m9123b();
                this.f9605M = false;
            }
            IConnStrategy m9120a = this.f9606N.m9120a();
            this.f9609p = m9120a == null ? m9161p() : m9120a.getIp();
            if (m9120a != null) {
                i3 = m9120a.getPort();
            }
            this.f9610q = i3;
            C3043k.m9250a("accs", BaseMonitor.COUNT_POINT_DNS, "httpdns", 0.0d);
            ALog.m9182e(mo9100d(), "connect from amdc succ", "ip", this.f9609p, "port", Integer.valueOf(this.f9610q), "originPos", Integer.valueOf(this.f9606N.m9125c()));
        }
        this.f9617x = DefaultWebClient.HTTPS_SCHEME + this.f9609p + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.f9610q + "/accs/";
        ALog.m9182e(mo9100d(), BaseMonitor.ALARM_POINT_CONNECT, "URL", this.f9617x);
        this.f9607O = String.valueOf(System.currentTimeMillis());
        if (this.f9601I != null) {
            AppMonitor.getInstance().commitStat(this.f9601I);
        }
        this.f9601I = new SessionMonitor();
        this.f9601I.setConnectType(this.f9523c == 0 ? "service" : "inapp");
        if (this.f9619z != null) {
            try {
                this.f9597E = System.currentTimeMillis();
                this.f9598F = System.nanoTime();
                this.f9611r = UtilityImpl.m9196a(this.f9524d);
                this.f9612s = UtilityImpl.m9208b(this.f9524d);
                this.f9595C = System.currentTimeMillis();
                this.f9601I.onStartConnect();
                m9148d(2);
                synchronized (this.f9594B) {
                    try {
                        try {
                            if (TextUtils.isEmpty(this.f9611r) || this.f9612s < 0 || !this.f9603K) {
                                ALog.m9182e(mo9100d(), "connect normal", new Object[0]);
                                sessionInfo = new SessionInfo(this.f9609p, this.f9610q, m9161p() + AbstractC1191a.f2606s1 + this.f9522b, null, 0, this.f9607O, this, 4226);
                                this.f9604L = "";
                            } else {
                                ALog.m9182e(mo9100d(), BaseMonitor.ALARM_POINT_CONNECT, "proxy", this.f9611r, "port", Integer.valueOf(this.f9612s));
                                sessionInfo = new SessionInfo(this.f9609p, this.f9610q, m9161p() + AbstractC1191a.f2606s1 + this.f9522b, this.f9611r, this.f9612s, this.f9607O, this, 4226);
                                this.f9604L = this.f9611r + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.f9612s;
                            }
                            sessionInfo.setPubKeySeqNum(m9156r());
                            sessionInfo.setConnectionTimeoutMs(AbstractC3001a.ACCS_RECEIVE_TIMEOUT);
                            this.f9593A = this.f9619z.createSession(sessionInfo);
                            this.f9601I.connection_stop_date = 0L;
                            this.f9594B.wait();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            this.f9603K = false;
                        }
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: c */
    public C3028c mo9097c() {
        if (this.f9602J == null) {
            this.f9602J = new C3028c();
        }
        C3028c c3028c = this.f9602J;
        c3028c.f9644b = this.f9523c;
        c3028c.f9646d = this.f9614u.size();
        this.f9602J.f9651i = UtilityImpl.m9227i(this.f9524d);
        C3028c c3028c2 = this.f9602J;
        c3028c2.f9648f = this.f9604L;
        c3028c2.f9643a = this.f9613t;
        SessionMonitor sessionMonitor = this.f9601I;
        c3028c2.f9645c = sessionMonitor != null && sessionMonitor.getRet();
        this.f9602J.f9652j = m9162q();
        C3028c c3028c3 = this.f9602J;
        C2986d c2986d = this.f9525e;
        c3028c3.f9647e = c2986d != null ? c2986d.m9036d() : 0;
        C3028c c3028c4 = this.f9602J;
        c3028c4.f9649g = this.f9618y;
        return c3028c4;
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: e */
    public void mo9101e() {
        super.mo9101e();
        this.f9616w = false;
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new RunnableC3024x(this));
        ALog.m9182e(mo9100d(), "shut down", new Object[0]);
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: b */
    public void mo9092b() {
        this.f9603K = false;
        this.f9526f = 0;
    }

    /* renamed from: e */
    private void m9151e(int i2) {
        this.f9531k = null;
        m9160o();
        a aVar = this.f9615v;
        int i3 = aVar != null ? aVar.f9620a : 0;
        this.f9601I.setCloseReason("code not 200 is" + i2);
        this.f9605M = true;
        String str = this.f9523c == 0 ? "service" : "inapp";
        UTMini.getInstance().commitEvent(66001, "CONNECTED NO 200 " + str, (Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3), (Object) 221, this.f9618y, this.f9604L);
        C3043k.m9251a("accs", "auth", "", i2 + "", "");
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: a */
    public void mo9082a() {
        this.f9616w = true;
        ALog.m9180d(mo9100d(), "start", new Object[0]);
        mo9083a(this.f9524d);
        if (this.f9615v == null) {
            ALog.m9183i(mo9100d(), "start thread", new Object[0]);
            this.f9615v = new a("NetworkThread_" + this.f9533m);
            this.f9615v.setPriority(2);
            this.f9615v.start();
        }
        mo9088a(false, false);
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: b */
    public String mo9091b(String str) {
        return DefaultWebClient.HTTPS_SCHEME + this.f9529i.getChannelHost();
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: a */
    public void mo9085a(Message message, boolean z) {
        if (this.f9616w && message != null) {
            try {
                if (ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size() <= 1000) {
                    ScheduledFuture<?> schedule = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new RunnableC3023w(this, message, z), message.delyTime, TimeUnit.MILLISECONDS);
                    if (message.getType() == 1 && message.cunstomDataId != null) {
                        if (message.isControlFrame()) {
                            mo9090a(message.cunstomDataId);
                        }
                        this.f9525e.f9467a.put(message.cunstomDataId, schedule);
                    }
                    if (message.getNetPermanceMonitor() != null) {
                        message.getNetPermanceMonitor().setDeviceId(UtilityImpl.m9228j(this.f9524d));
                        message.getNetPermanceMonitor().setConnType(this.f9523c);
                        message.getNetPermanceMonitor().onEnterQueueData();
                        return;
                    }
                    return;
                }
                throw new RejectedExecutionException("accs");
            } catch (RejectedExecutionException unused) {
                this.f9525e.m9026a(message, ErrorCode.MESSAGE_QUEUE_FULL);
                ALog.m9182e(mo9100d(), "send queue full count:" + ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size(), new Object[0]);
                return;
            } catch (Throwable th) {
                this.f9525e.m9026a(message, -8);
                ALog.m9181e(mo9100d(), "send error", th, new Object[0]);
                return;
            }
        }
        ALog.m9182e(mo9100d(), "not running or msg null! " + this.f9616w, new Object[0]);
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: a */
    public void mo9088a(boolean z, boolean z2) {
        ALog.m9180d(mo9100d(), "try ping, force:" + z, new Object[0]);
        if (this.f9523c == 1) {
            ALog.m9180d(mo9100d(), "INAPP, skip", new Object[0]);
            return;
        }
        Message BuildPing = Message.BuildPing(z, (int) (z2 ? Math.random() * 10.0d * 1000.0d : 0.0d));
        int pingTimeout = this.f9529i.getPingTimeout();
        if (pingTimeout > 0) {
            BuildPing.timeout = pingTimeout;
        }
        m9096b(BuildPing, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9138a(Message message) {
        if (message.command == null || this.f9614u.size() == 0) {
            return;
        }
        for (int size = this.f9614u.size() - 1; size >= 0; size--) {
            Message message2 = this.f9614u.get(size);
            if (message2 != null && message2.command != null && message2.getPackageName().equals(message.getPackageName())) {
                switch (message.command.intValue()) {
                    case 1:
                    case 2:
                        if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                            this.f9614u.remove(size);
                            break;
                        }
                        break;
                    case 3:
                    case 4:
                        if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                            this.f9614u.remove(size);
                            break;
                        }
                        break;
                    case 5:
                    case 6:
                        if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                            this.f9614u.remove(size);
                            break;
                        }
                        break;
                }
                ALog.m9180d(mo9100d(), "clearRepeatControlCommand message:" + message2.command + "/" + message2.getPackageName(), new Object[0]);
            }
        }
        C2986d c2986d = this.f9525e;
        if (c2986d != null) {
            c2986d.m9034b(message);
        }
    }

    /* renamed from: d */
    private synchronized void m9148d(int i2) {
        ALog.m9182e(mo9100d(), "notifyStatus start", NotificationCompat.CATEGORY_STATUS, m9081a(i2));
        if (i2 == this.f9613t) {
            ALog.m9183i(mo9100d(), "ignore notifyStatus", new Object[0]);
            return;
        }
        this.f9613t = i2;
        if (i2 == 1) {
            AbstractC3007g.m9112a(this.f9524d).m9119f();
            m9158t();
            if (this.f9608o != null) {
                this.f9608o.cancel(true);
            }
            synchronized (this.f9594B) {
                try {
                    this.f9594B.notifyAll();
                } catch (Exception unused) {
                }
            }
            synchronized (this.f9614u) {
                try {
                    this.f9614u.notifyAll();
                } catch (Exception unused2) {
                }
            }
            ALog.m9183i(mo9100d(), "notifyStatus end", NotificationCompat.CATEGORY_STATUS, m9081a(i2));
        }
        if (i2 == 2) {
            if (this.f9608o != null) {
                this.f9608o.cancel(true);
            }
            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new RunnableC3025y(this, this.f9607O), 120000L, TimeUnit.MILLISECONDS);
        } else if (i2 == 3) {
            m9158t();
            AbstractC3007g.m9112a(this.f9524d).m9117d();
            synchronized (this.f9594B) {
                try {
                    this.f9594B.notifyAll();
                } catch (Exception unused3) {
                }
            }
            this.f9525e.m9024a(-10);
            mo9088a(false, true);
        }
        ALog.m9183i(mo9100d(), "notifyStatus end", NotificationCompat.CATEGORY_STATUS, m9081a(i2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0036, code lost:
    
        if (android.text.TextUtils.isEmpty(r14) != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m9141a(java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r11 = this;
            android.content.Context r0 = r11.f9524d
            int r0 = com.taobao.accs.utl.C3054v.m9286b(r0)
            r1 = 2
            r2 = 1
            if (r0 != r1) goto Lb
            return r2
        Lb:
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            r3 = 0
            if (r0 != 0) goto L1e
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            if (r0 != 0) goto L1e
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 == 0) goto Lb0
        L1e:
            r0 = 3
            r11.m9148d(r0)
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L2a
        L28:
            r0 = 1
            goto L38
        L2a:
            boolean r12 = android.text.TextUtils.isEmpty(r13)
            if (r12 == 0) goto L32
            r0 = 2
            goto L38
        L32:
            boolean r12 = android.text.TextUtils.isEmpty(r14)
            if (r12 == 0) goto L28
        L38:
            com.taobao.accs.ut.monitor.SessionMonitor r12 = r11.f9601I
            r12.setFailReason(r0)
            com.taobao.accs.ut.monitor.SessionMonitor r12 = r11.f9601I
            r12.onConnectStop()
            int r12 = r11.f9523c
            if (r12 != 0) goto L49
            java.lang.String r12 = "service"
            goto L4b
        L49:
            java.lang.String r12 = "inapp"
        L4b:
            com.taobao.accs.net.v$a r13 = r11.f9615v
            if (r13 == 0) goto L52
            int r13 = r13.f9620a
            goto L53
        L52:
            r13 = 0
        L53:
            com.taobao.accs.utl.UTMini r4 = com.taobao.accs.utl.UTMini.getInstance()
            r5 = 66001(0x101d1, float:9.2487E-41)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r6 = "DISCONNECT "
            r14.append(r6)
            r14.append(r12)
            java.lang.String r6 = r14.toString()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r13)
            r12 = 221(0xdd, float:3.1E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)
            java.lang.String[] r10 = new java.lang.String[r1]
            java.lang.String r12 = r11.f9618y
            r10[r3] = r12
            java.lang.String r12 = r11.f9604L
            r10[r2] = r12
            r4.commitEvent(r5, r6, r7, r8, r9, r10)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "retrytimes:"
            r12.append(r14)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r0)
            java.lang.String r14 = ""
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.String r0 = "accs"
            java.lang.String r1 = "connect"
            com.taobao.accs.utl.C3043k.m9251a(r0, r1, r12, r13, r14)
            r2 = 0
        Lb0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.C3022v.m9141a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: a */
    public void mo9087a(String str, boolean z, String str2) {
        try {
            m9148d(4);
            m9160o();
            this.f9601I.setCloseReason(str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: a */
    public boolean mo9090a(String str) {
        boolean z;
        synchronized (this.f9614u) {
            z = true;
            int size = this.f9614u.size() - 1;
            while (true) {
                if (size >= 0) {
                    Message message = this.f9614u.get(size);
                    if (message != null && message.getType() == 1 && message.cunstomDataId != null && message.cunstomDataId.equals(str)) {
                        this.f9614u.remove(size);
                        break;
                    }
                    size--;
                } else {
                    z = false;
                    break;
                }
            }
        }
        return z;
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: d */
    public String mo9100d() {
        return "SilenceConn_" + this.f9533m;
    }

    @Override // com.taobao.accs.net.AbstractC3001a
    /* renamed from: a */
    protected void mo9083a(Context context) {
        if (this.f9527g) {
            return;
        }
        super.mo9083a(context);
        GlobalAppRuntimeInfo.setBackground(false);
        this.f9527g = true;
        ALog.m9183i(mo9100d(), "init awcn success!", new Object[0]);
    }
}
