package com.taobao.accs.net;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.strategy.IConnStrategy;
import anet.channel.util.HttpConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.just.agentweb.DefaultWebClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.SessionMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import i.f1;
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

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class v extends com.taobao.accs.net.a implements SessionCb, Spdycb {
    private SpdySession A;
    private Object B;
    private long C;
    private long D;
    private long E;
    private long F;
    private int G;
    private String H;
    private SessionMonitor I;
    private com.taobao.accs.ut.a.c J;
    private boolean K;
    private String L;
    private boolean M;
    private h N;
    private String O;
    protected ScheduledFuture<?> o;
    protected String p;
    protected int q;
    protected String r;
    protected int s;
    private int t;
    private LinkedList<Message> u;
    private a v;
    private boolean w;
    private String x;
    private String y;
    private SpdyAgent z;

    /* JADX INFO: compiled from: Taobao */
    private class a extends Thread {
        public int a;

        /* JADX INFO: renamed from: b */
        long f5839b;

        /* JADX INFO: renamed from: d */
        private final String f5841d;

        public a(String str) {
            super(str);
            this.f5841d = getName();
            this.a = 0;
        }

        private void a(boolean z) {
            if (v.this.t == 1) {
                if (v.this.t != 1 || System.currentTimeMillis() - this.f5839b <= com.heytap.mcssdk.constant.a.r) {
                    return;
                }
                this.a = 0;
                return;
            }
            ALog.d(v.this.d(), "tryConnect", "force", Boolean.valueOf(z));
            if (!UtilityImpl.i(v.this.f5801d)) {
                ALog.e(this.f5841d, "Network not available", new Object[0]);
                return;
            }
            if (z) {
                this.a = 0;
            }
            ALog.i(this.f5841d, "tryConnect", "force", Boolean.valueOf(z), "failTimes", Integer.valueOf(this.a));
            if (v.this.t != 1 && this.a >= 4) {
                v.this.K = true;
                ALog.e(this.f5841d, "tryConnect fail", "maxTimes", 4);
                return;
            }
            if (v.this.t != 1) {
                if (v.this.f5800c == 1 && this.a == 0) {
                    ALog.i(this.f5841d, "tryConnect in app, no sleep", new Object[0]);
                } else {
                    ALog.i(this.f5841d, "tryConnect, need sleep", new Object[0]);
                    try {
                        Thread.sleep(com.heytap.mcssdk.constant.a.r);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                v.this.L = "";
                if (this.a == 3) {
                    v.this.N.b(v.this.p());
                }
                v.this.d((String) null);
                v.this.I.setRetryTimes(this.a);
                if (v.this.t == 1) {
                    this.f5839b = System.currentTimeMillis();
                    return;
                }
                this.a++;
                ALog.e(this.f5841d, "try connect fail, ready for reconnect", new Object[0]);
                a(false);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:279:0x0062 A[Catch: all -> 0x0507, TryCatch #2 {, blocks: (B:269:0x0027, B:271:0x0033, B:277:0x004d, B:279:0x0062, B:281:0x0074, B:283:0x007c, B:274:0x0047, B:275:0x004a), top: B:470:0x0027, inners: #0 }] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Message message;
            boolean z;
            ALog.i(this.f5841d, "NetworkThread run", new Object[0]);
            this.a = 0;
            Message message2 = null;
            while (v.this.w) {
                ALog.d(this.f5841d, "ready to get message", new Object[0]);
                synchronized (v.this.u) {
                    if (v.this.u.size() == 0) {
                        try {
                            ALog.d(this.f5841d, "no message, wait", new Object[0]);
                            v.this.u.wait();
                            ALog.d(this.f5841d, "try get message", new Object[0]);
                            if (v.this.u.size() != 0) {
                                message2 = (Message) v.this.u.getFirst();
                                if (message2.getNetPermanceMonitor() != null) {
                                    message2.getNetPermanceMonitor().onTakeFromQueue();
                                }
                            }
                            message = message2;
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        ALog.d(this.f5841d, "try get message", new Object[0]);
                        if (v.this.u.size() != 0) {
                        }
                        message = message2;
                    }
                }
                if (!v.this.w) {
                    break;
                }
                if (message != null) {
                    ALog.d(this.f5841d, "sendMessage not null", new Object[0]);
                    try {
                        int type = message.getType();
                        ALog.i(this.f5841d, "sendMessage", "type", Message.MsgType.name(type), NotificationCompat.CATEGORY_STATUS, Integer.valueOf(v.this.t));
                        if (type != 2) {
                            if (type == 1) {
                                a(true);
                                if (v.this.t == 1 && v.this.A != null) {
                                    byte[] bArrBuild = message.build(v.this.f5801d, v.this.f5800c);
                                    message.setSendTime(System.currentTimeMillis());
                                    if (bArrBuild.length <= 49152 || message.command.intValue() == 102) {
                                        int id = message.isAck ? -message.getMsgId().getId() : message.getMsgId().getId();
                                        v.this.A.sendCustomControlFrame(id, 200, 0, bArrBuild == null ? 0 : bArrBuild.length, bArrBuild);
                                        String str = this.f5841d;
                                        Object[] objArr = new Object[6];
                                        objArr[0] = "length";
                                        objArr[1] = Integer.valueOf(bArrBuild == null ? 0 : bArrBuild.length);
                                        objArr[2] = Constants.KEY_DATA_ID;
                                        objArr[3] = message.getDataId();
                                        objArr[4] = "utdid";
                                        objArr[5] = v.this.f5807j;
                                        ALog.e(str, "send data", objArr);
                                        v.this.f5802e.a(message);
                                        if (message.isAck) {
                                            ALog.e(this.f5841d, "sendCFrame end ack", Constants.KEY_DATA_ID, Integer.valueOf(id));
                                            v.this.f5809l.put(Integer.valueOf(id), message);
                                        }
                                        if (message.getNetPermanceMonitor() != null) {
                                            message.getNetPermanceMonitor().onSendData();
                                        }
                                        v.this.a(message.getDataId(), v.this.f5806i.isQuickReconnect(), message.timeout);
                                        v.this.f5802e.a(new TrafficsMonitor.a(message.serviceId, GlobalAppRuntimeInfo.isAppBackground(), v.this.p(), bArrBuild.length));
                                    } else {
                                        v.this.f5802e.a(message, -4);
                                    }
                                }
                                z = false;
                            } else {
                                a(false);
                                ALog.e(this.f5841d, "skip msg", "type", Integer.valueOf(type));
                            }
                            z = true;
                        } else if (v.this.f5800c == 1) {
                            ALog.d(this.f5841d, "sendMessage INAPP ping, skip", new Object[0]);
                            try {
                                ALog.d(this.f5841d, "send succ, remove it", new Object[0]);
                                synchronized (v.this.u) {
                                    v.this.u.remove(message);
                                }
                            } catch (Throwable th) {
                                ALog.e(this.f5841d, " run finally error", th, new Object[0]);
                            }
                        } else {
                            if (System.currentTimeMillis() - v.this.C >= (g.a(v.this.f5801d).b() - 1) * 1000 || message.force) {
                                ALog.d(this.f5841d, "sendMessage", "force", Boolean.valueOf(message.force), "last ping", Long.valueOf(System.currentTimeMillis() - v.this.C));
                                a(true);
                                if (v.this.A != null && v.this.t == 1) {
                                    if (System.currentTimeMillis() - v.this.C >= (g.a(v.this.f5801d).b() - 1) * 1000) {
                                        ALog.i(this.f5841d, "sendMessage onSendPing", new Object[0]);
                                        v.this.f5802e.a();
                                        v.this.A.submitPing();
                                        v.this.I.onSendPing();
                                        v.this.C = System.currentTimeMillis();
                                        v.this.D = System.nanoTime();
                                        v.this.f();
                                    }
                                }
                                z = false;
                            } else {
                                a(false);
                            }
                            z = true;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z = true;
                    }
                    try {
                        v.this.t();
                        if (z) {
                            ALog.d(this.f5841d, "send succ, remove it", new Object[0]);
                            synchronized (v.this.u) {
                                v.this.u.remove(message);
                            }
                        } else {
                            try {
                                v.this.o();
                                if (v.this.I != null) {
                                    v.this.I.setCloseReason("send fail");
                                }
                                synchronized (v.this.u) {
                                    for (int size = v.this.u.size() - 1; size >= 0; size--) {
                                        Message message3 = (Message) v.this.u.get(size);
                                        if (message3 != null && message3.command != null && (message3.command.intValue() == 100 || message3.command.intValue() == 201)) {
                                            v.this.f5802e.a(message3, -1);
                                            v.this.u.remove(size);
                                        }
                                    }
                                    ALog.e(this.f5841d, "network disconnected, wait", new Object[0]);
                                    v.this.u.wait();
                                }
                            } catch (Throwable th3) {
                                ALog.e(this.f5841d, " run finally error", th3, new Object[0]);
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, message.serviceId, "1", v.this.f5800c + th.toString());
                            th.printStackTrace();
                            ALog.e(this.f5841d, "service connection run", th, new Object[0]);
                            if (z) {
                                ALog.d(this.f5841d, "send succ, remove it", new Object[0]);
                                synchronized (v.this.u) {
                                    v.this.u.remove(message);
                                }
                            } else {
                                try {
                                    v.this.o();
                                    if (v.this.I != null) {
                                        v.this.I.setCloseReason("send fail");
                                    }
                                    synchronized (v.this.u) {
                                        for (int size2 = v.this.u.size() - 1; size2 >= 0; size2--) {
                                            Message message4 = (Message) v.this.u.get(size2);
                                            if (message4 != null && message4.command != null && (message4.command.intValue() == 100 || message4.command.intValue() == 201)) {
                                                v.this.f5802e.a(message4, -1);
                                                v.this.u.remove(size2);
                                            }
                                        }
                                        ALog.e(this.f5841d, "network disconnected, wait", new Object[0]);
                                        v.this.u.wait();
                                    }
                                } catch (Throwable th5) {
                                    ALog.e(this.f5841d, " run finally error", th5, new Object[0]);
                                }
                            }
                        } catch (Throwable th6) {
                            try {
                                if (z) {
                                    ALog.d(this.f5841d, "send succ, remove it", new Object[0]);
                                    synchronized (v.this.u) {
                                        v.this.u.remove(message);
                                        throw th6;
                                    }
                                }
                                v.this.o();
                                if (v.this.I != null) {
                                    v.this.I.setCloseReason("send fail");
                                }
                                synchronized (v.this.u) {
                                    for (int size3 = v.this.u.size() - 1; size3 >= 0; size3--) {
                                        Message message5 = (Message) v.this.u.get(size3);
                                        if (message5 != null && message5.command != null && (message5.command.intValue() == 100 || message5.command.intValue() == 201)) {
                                            v.this.f5802e.a(message5, -1);
                                            v.this.u.remove(size3);
                                        }
                                    }
                                    ALog.e(this.f5841d, "network disconnected, wait", new Object[0]);
                                    v.this.u.wait();
                                    throw th6;
                                }
                            } catch (Throwable th7) {
                                ALog.e(this.f5841d, " run finally error", th7, new Object[0]);
                                throw th6;
                            }
                            ALog.e(this.f5841d, " run finally error", th7, new Object[0]);
                            throw th6;
                        }
                    }
                }
                message2 = message;
            }
            v.this.o();
        }
    }

    public v(Context context, int i2, String str) {
        super(context, i2, str);
        this.t = 3;
        this.u = new LinkedList<>();
        this.w = true;
        this.z = null;
        this.A = null;
        this.B = new Object();
        this.G = -1;
        this.H = null;
        this.K = false;
        this.L = "";
        this.M = false;
        this.N = new h(p());
        u();
    }

    private int r() {
        boolean zL = l();
        if (AccsClientConfig.mEnv == 2) {
            return 0;
        }
        int channelPubKey = this.f5806i.getChannelPubKey();
        if (channelPubKey <= 0) {
            return zL ? 4 : 3;
        }
        ALog.i(d(), "getPublicKeyType use custom pub key", "pubKey", Integer.valueOf(channelPubKey));
        return channelPubKey;
    }

    private void s() {
        if (this.A == null) {
            d(3);
            return;
        }
        try {
            String strEncode = URLEncoder.encode(UtilityImpl.j(this.f5801d));
            String strA = UtilityImpl.a(i(), this.f5806i.getAppSecret(), UtilityImpl.j(this.f5801d));
            String strC = c(this.x);
            ALog.e(d(), "auth", "url", strC);
            this.y = strC;
            if (!a(strEncode, i(), strA)) {
                ALog.e(d(), "auth param error!", new Object[0]);
                e(-6);
            } else {
                SpdyRequest spdyRequest = new SpdyRequest(new URL(strC), "GET", RequestPriority.DEFAULT_PRIORITY, 80000, com.taobao.accs.net.a.ACCS_RECEIVE_TIMEOUT);
                spdyRequest.setDomain(p());
                this.A.submitRequest(spdyRequest, new SpdyDataProvider((byte[]) null), p(), this);
            }
        } catch (Throwable th) {
            ALog.e(d(), "auth exception ", th, new Object[0]);
            e(-7);
        }
    }

    public synchronized void t() {
        if (this.f5800c == 1) {
            return;
        }
        this.C = System.currentTimeMillis();
        this.D = System.nanoTime();
        g.a(this.f5801d).a();
    }

    private void u() {
        try {
            SpdyAgent.enableDebug = ALog.isPrintLog();
            this.z = SpdyAgent.getInstance(this.f5801d, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
            if (SpdyAgent.checkLoadSucc()) {
                com.taobao.accs.utl.q.a();
            } else {
                ALog.e(d(), "initClient", new Object[0]);
                this.z = null;
                com.taobao.accs.utl.q.b();
            }
        } catch (Throwable th) {
            ALog.e(d(), "initClient", th, new Object[0]);
        }
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i2) {
        ALog.w(d(), "bioPingRecvCallback uniId:" + i2, new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        spdySession.getDomain();
        return UtilityImpl.c();
    }

    @Override // com.taobao.accs.net.a
    protected boolean h() {
        return false;
    }

    public void o() {
        ALog.e(d(), " force close!", new Object[0]);
        try {
            this.A.closeSession();
            this.I.setCloseType(1);
        } catch (Exception unused) {
        }
        d(3);
    }

    public String p() {
        String channelHost = this.f5806i.getChannelHost();
        ALog.i(d(), "getChannelHost", Constants.KEY_HOST, channelHost);
        return channelHost == null ? "" : channelHost;
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        spdySession.getDomain();
        return UtilityImpl.b();
    }

    public boolean q() {
        return this.w;
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i2, int i3) {
        b(i2);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i2, int i3, int i4, int i5, byte[] bArr) {
        t();
        ALog.e(d(), "onFrame", "type", Integer.valueOf(i3), "len", Integer.valueOf(bArr.length));
        StringBuilder sb = new StringBuilder();
        if (ALog.isPrintLog(ALog.Level.D) && bArr.length < 512) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (byte b2 : bArr) {
                sb.append(Integer.toHexString(b2 & f1.f12066c));
                sb.append(d.c.a.b.a.a.f10074g);
            }
            ALog.d(d(), ((Object) sb) + " log time:" + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
        }
        if (i3 == 200) {
            try {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                this.f5802e.a(bArr);
                com.taobao.accs.ut.a.d dVarG = this.f5802e.g();
                if (dVarG != null) {
                    dVarG.f5867c = String.valueOf(jCurrentTimeMillis2);
                    dVarG.f5871g = this.f5800c == 0 ? "service" : "inapp";
                    dVarG.a();
                }
            } catch (Throwable th) {
                ALog.e(d(), "onDataReceive ", th, new Object[0]);
                UTMini.getInstance().commitEvent(66001, "SERVICE_DATA_RECEIVE", UtilityImpl.a(th));
            }
            ALog.d(d(), "try handle msg", new Object[0]);
            g();
        } else {
            ALog.e(d(), "drop frame", "len", Integer.valueOf(bArr.length));
        }
        ALog.d(d(), "spdyCustomControlFrameRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j2, SpdyByteArray spdyByteArray, Object obj) {
        ALog.d(d(), "spdyDataChunkRecvCB", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataRecvCallback(SpdySession spdySession, boolean z, long j2, int i2, Object obj) {
        ALog.d(d(), "spdyDataRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataSendCallback(SpdySession spdySession, boolean z, long j2, int i2, Object obj) {
        ALog.d(d(), "spdyDataSendCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyOnStreamResponse(SpdySession spdySession, long j2, Map<String, List<String>> map, Object obj) {
        this.C = System.currentTimeMillis();
        this.D = System.nanoTime();
        try {
            Map<String, String> mapA = UtilityImpl.a(map);
            ALog.d("SilenceConn_", "spdyOnStreamResponse", "header", map);
            int i2 = Integer.parseInt(mapA.get(HttpConstant.STATUS));
            ALog.e(d(), "spdyOnStreamResponse", "httpStatusCode", Integer.valueOf(i2));
            if (i2 == 200) {
                d(1);
                String str = mapA.get("x-at");
                if (!TextUtils.isEmpty(str)) {
                    this.f5808k = str;
                }
                this.I.auth_time = this.I.connection_stop_date > 0 ? System.currentTimeMillis() - this.I.connection_stop_date : 0L;
                String str2 = this.f5800c == 0 ? "service" : "inapp";
                UTMini.getInstance().commitEvent(66001, "CONNECTED 200 " + str2, (Object) this.y, (Object) this.L, (Object) 221, "0");
                com.taobao.accs.utl.k.a("accs", "auth", "");
            } else {
                e(i2);
            }
        } catch (Exception e2) {
            ALog.e(d(), e2.toString(), new Object[0]);
            o();
            this.I.setCloseReason("exception");
        }
        ALog.d(d(), "spdyOnStreamResponse", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j2, Object obj) {
        ALog.d(d(), "spdyPingRecvCallback uniId:" + j2, new Object[0]);
        if (j2 < 0) {
            return;
        }
        this.f5802e.b();
        g.a(this.f5801d).e();
        g.a(this.f5801d).a();
        this.I.onPingCBReceive();
        if (this.I.ping_rec_times % 2 == 0) {
            UtilityImpl.a(this.f5801d, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
        }
    }

    @Override // org.android.spdy.Spdycb
    public void spdyRequestRecvCallback(SpdySession spdySession, long j2, Object obj) {
        ALog.d(d(), "spdyRequestRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i2) {
        ALog.e(d(), "spdySessionCloseCallback", Constants.KEY_ERROR_CODE, Integer.valueOf(i2));
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.e(d(), "session cleanUp has exception: " + e2, new Object[0]);
            }
        }
        d(3);
        this.I.onCloseConnect();
        if (this.I.getConCloseDate() > 0 && this.I.getConStopDate() > 0) {
            this.I.getConCloseDate();
            this.I.getConStopDate();
        }
        this.I.setCloseReason(this.I.getCloseReason() + "tnet error:" + i2);
        if (superviseConnectInfo != null) {
            this.I.live_time = superviseConnectInfo.keepalive_period_second;
        }
        AppMonitor.getInstance().commitStat(this.I);
        for (Message message : this.f5802e.e()) {
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().setRet(false);
                message.getNetPermanceMonitor().setFailReason("session close");
                AppMonitor.getInstance().commitStat(message.getNetPermanceMonitor());
            }
        }
        String str = this.f5800c == 0 ? "service" : "inapp";
        ALog.d(d(), "spdySessionCloseCallback, conKeepTime:" + this.I.live_time + " connectType:" + str, new Object[0]);
        UTMini uTMini = UTMini.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("DISCONNECT CLOSE ");
        sb.append(str);
        uTMini.commitEvent(66001, sb.toString(), (Object) Integer.valueOf(i2), (Object) Long.valueOf(this.I.live_time), (Object) 221, this.y, this.L);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        this.G = superviseConnectInfo.connectTime;
        int i2 = superviseConnectInfo.handshakeTime;
        ALog.e(d(), "spdySessionConnectCB", "sessionConnectInterval", Integer.valueOf(this.G), "sslTime", Integer.valueOf(i2), "reuse", Integer.valueOf(superviseConnectInfo.sessionTicketReused));
        s();
        this.I.setRet(true);
        this.I.onConnectStop();
        SessionMonitor sessionMonitor = this.I;
        sessionMonitor.tcp_time = this.G;
        sessionMonitor.ssl_time = i2;
        String str = this.f5800c == 0 ? "service" : "inapp";
        UTMini.getInstance().commitEvent(66001, "CONNECTED " + str + d.c.a.b.a.a.f10074g + superviseConnectInfo.sessionTicketReused, (Object) String.valueOf(this.G), (Object) String.valueOf(i2), (Object) 221, String.valueOf(superviseConnectInfo.sessionTicketReused), this.y, this.L);
        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_CONNECT, "");
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i2, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.e(d(), "session cleanUp has exception: " + e2, new Object[0]);
            }
        }
        a aVar = this.v;
        int i3 = aVar != null ? aVar.a : 0;
        ALog.e(d(), "spdySessionFailedError", "retryTimes", Integer.valueOf(i3), "errorId", Integer.valueOf(i2));
        this.K = false;
        this.M = true;
        d(3);
        this.I.setFailReason(i2);
        this.I.onConnectStop();
        String str = this.f5800c == 0 ? "service" : "inapp";
        UTMini.getInstance().commitEvent(66001, "DISCONNECT " + str, (Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3), (Object) 221, this.y, this.L);
        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_CONNECT, "retrytimes:" + i3, i2 + "", "");
    }

    @Override // org.android.spdy.Spdycb
    public void spdyStreamCloseCallback(SpdySession spdySession, long j2, int i2, Object obj, SuperviseData superviseData) {
        ALog.d(d(), "spdyStreamCloseCallback", new Object[0]);
        if (i2 != 0) {
            ALog.e(d(), "spdyStreamCloseCallback", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i2));
            e(i2);
        }
    }

    public void d(String str) {
        SessionInfo sessionInfo;
        int i2 = this.t;
        if (i2 == 2 || i2 == 1) {
            return;
        }
        if (this.N == null) {
            this.N = new h(p());
        }
        List<IConnStrategy> listA = this.N.a(p());
        int port = Constants.PORT;
        if (listA == null || listA.size() <= 0) {
            if (str != null) {
                this.p = str;
            } else {
                this.p = p();
            }
            if (System.currentTimeMillis() % 2 == 0) {
                port = 80;
            }
            this.q = port;
            com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_DNS, "localdns", 0.0d);
            ALog.i(d(), "connect get ip from amdc fail!!", new Object[0]);
        } else {
            for (IConnStrategy iConnStrategy : listA) {
                if (iConnStrategy != null) {
                    ALog.e(d(), BaseMonitor.ALARM_POINT_CONNECT, "ip", iConnStrategy.getIp(), "port", Integer.valueOf(iConnStrategy.getPort()));
                }
            }
            if (this.M) {
                this.N.b();
                this.M = false;
            }
            IConnStrategy iConnStrategyA = this.N.a();
            this.p = iConnStrategyA == null ? p() : iConnStrategyA.getIp();
            if (iConnStrategyA != null) {
                port = iConnStrategyA.getPort();
            }
            this.q = port;
            com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_DNS, "httpdns", 0.0d);
            ALog.e(d(), "connect from amdc succ", "ip", this.p, "port", Integer.valueOf(this.q), "originPos", Integer.valueOf(this.N.c()));
        }
        this.x = DefaultWebClient.HTTPS_SCHEME + this.p + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.q + "/accs/";
        ALog.e(d(), BaseMonitor.ALARM_POINT_CONNECT, "URL", this.x);
        this.O = String.valueOf(System.currentTimeMillis());
        if (this.I != null) {
            AppMonitor.getInstance().commitStat(this.I);
        }
        this.I = new SessionMonitor();
        this.I.setConnectType(this.f5800c == 0 ? "service" : "inapp");
        if (this.z != null) {
            try {
                this.E = System.currentTimeMillis();
                this.F = System.nanoTime();
                this.r = UtilityImpl.a(this.f5801d);
                this.s = UtilityImpl.b(this.f5801d);
                this.C = System.currentTimeMillis();
                this.I.onStartConnect();
                d(2);
                synchronized (this.B) {
                    try {
                        try {
                            if (TextUtils.isEmpty(this.r) || this.s < 0 || !this.K) {
                                ALog.e(d(), "connect normal", new Object[0]);
                                sessionInfo = new SessionInfo(this.p, this.q, p() + d.c.a.b.a.a.s1 + this.f5799b, null, 0, this.O, this, 4226);
                                this.L = "";
                            } else {
                                ALog.e(d(), BaseMonitor.ALARM_POINT_CONNECT, "proxy", this.r, "port", Integer.valueOf(this.s));
                                sessionInfo = new SessionInfo(this.p, this.q, p() + d.c.a.b.a.a.s1 + this.f5799b, this.r, this.s, this.O, this, 4226);
                                this.L = this.r + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.s;
                            }
                            sessionInfo.setPubKeySeqNum(r());
                            sessionInfo.setConnectionTimeoutMs(com.taobao.accs.net.a.ACCS_RECEIVE_TIMEOUT);
                            this.A = this.z.createSession(sessionInfo);
                            this.I.connection_stop_date = 0L;
                            this.B.wait();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            this.K = false;
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

    @Override // com.taobao.accs.net.a
    public com.taobao.accs.ut.a.c c() {
        if (this.J == null) {
            this.J = new com.taobao.accs.ut.a.c();
        }
        com.taobao.accs.ut.a.c cVar = this.J;
        cVar.f5856b = this.f5800c;
        cVar.f5858d = this.u.size();
        this.J.f5863i = UtilityImpl.i(this.f5801d);
        com.taobao.accs.ut.a.c cVar2 = this.J;
        cVar2.f5860f = this.L;
        cVar2.a = this.t;
        SessionMonitor sessionMonitor = this.I;
        cVar2.f5857c = sessionMonitor != null && sessionMonitor.getRet();
        this.J.f5864j = q();
        com.taobao.accs.ut.a.c cVar3 = this.J;
        com.taobao.accs.data.d dVar = this.f5802e;
        cVar3.f5859e = dVar != null ? dVar.d() : 0;
        com.taobao.accs.ut.a.c cVar4 = this.J;
        cVar4.f5861g = this.y;
        return cVar4;
    }

    @Override // com.taobao.accs.net.a
    public void e() {
        super.e();
        this.w = false;
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new x(this));
        ALog.e(d(), "shut down", new Object[0]);
    }

    @Override // com.taobao.accs.net.a
    public void b() {
        this.K = false;
        this.f5803f = 0;
    }

    private void e(int i2) {
        this.f5808k = null;
        o();
        a aVar = this.v;
        int i3 = aVar != null ? aVar.a : 0;
        this.I.setCloseReason("code not 200 is" + i2);
        this.M = true;
        String str = this.f5800c == 0 ? "service" : "inapp";
        UTMini.getInstance().commitEvent(66001, "CONNECTED NO 200 " + str, (Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3), (Object) 221, this.y, this.L);
        com.taobao.accs.utl.k.a("accs", "auth", "", i2 + "", "");
    }

    @Override // com.taobao.accs.net.a
    public void a() {
        this.w = true;
        ALog.d(d(), "start", new Object[0]);
        a(this.f5801d);
        if (this.v == null) {
            ALog.i(d(), "start thread", new Object[0]);
            this.v = new a("NetworkThread_" + this.f5810m);
            this.v.setPriority(2);
            this.v.start();
        }
        a(false, false);
    }

    @Override // com.taobao.accs.net.a
    public String b(String str) {
        return DefaultWebClient.HTTPS_SCHEME + this.f5806i.getChannelHost();
    }

    @Override // com.taobao.accs.net.a
    public void a(Message message, boolean z) {
        if (this.w && message != null) {
            try {
                if (ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size() <= 1000) {
                    ScheduledFuture<?> scheduledFutureSchedule = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new w(this, message, z), message.delyTime, TimeUnit.MILLISECONDS);
                    if (message.getType() == 1 && message.cunstomDataId != null) {
                        if (message.isControlFrame()) {
                            a(message.cunstomDataId);
                        }
                        this.f5802e.a.put(message.cunstomDataId, scheduledFutureSchedule);
                    }
                    if (message.getNetPermanceMonitor() != null) {
                        message.getNetPermanceMonitor().setDeviceId(UtilityImpl.j(this.f5801d));
                        message.getNetPermanceMonitor().setConnType(this.f5800c);
                        message.getNetPermanceMonitor().onEnterQueueData();
                        return;
                    }
                    return;
                }
                throw new RejectedExecutionException("accs");
            } catch (RejectedExecutionException unused) {
                this.f5802e.a(message, ErrorCode.MESSAGE_QUEUE_FULL);
                ALog.e(d(), "send queue full count:" + ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size(), new Object[0]);
                return;
            } catch (Throwable th) {
                this.f5802e.a(message, -8);
                ALog.e(d(), "send error", th, new Object[0]);
                return;
            }
        }
        ALog.e(d(), "not running or msg null! " + this.w, new Object[0]);
    }

    @Override // com.taobao.accs.net.a
    public void a(boolean z, boolean z2) {
        ALog.d(d(), "try ping, force:" + z, new Object[0]);
        if (this.f5800c == 1) {
            ALog.d(d(), "INAPP, skip", new Object[0]);
            return;
        }
        Message messageBuildPing = Message.BuildPing(z, (int) (z2 ? Math.random() * 10.0d * 1000.0d : 0.0d));
        int pingTimeout = this.f5806i.getPingTimeout();
        if (pingTimeout > 0) {
            messageBuildPing.timeout = pingTimeout;
        }
        b(messageBuildPing, z);
    }

    public void a(Message message) {
        if (message.command == null || this.u.size() == 0) {
            return;
        }
        for (int size = this.u.size() - 1; size >= 0; size--) {
            Message message2 = this.u.get(size);
            if (message2 != null && message2.command != null && message2.getPackageName().equals(message.getPackageName())) {
                switch (message.command.intValue()) {
                    case 1:
                    case 2:
                        if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                            this.u.remove(size);
                        }
                        break;
                    case 3:
                    case 4:
                        if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                            this.u.remove(size);
                        }
                        break;
                    case 5:
                    case 6:
                        if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                            this.u.remove(size);
                        }
                        break;
                }
                ALog.d(d(), "clearRepeatControlCommand message:" + message2.command + "/" + message2.getPackageName(), new Object[0]);
            }
        }
        com.taobao.accs.data.d dVar = this.f5802e;
        if (dVar != null) {
            dVar.b(message);
        }
    }

    private synchronized void d(int i2) {
        ALog.e(d(), "notifyStatus start", NotificationCompat.CATEGORY_STATUS, a(i2));
        if (i2 == this.t) {
            ALog.i(d(), "ignore notifyStatus", new Object[0]);
            return;
        }
        this.t = i2;
        if (i2 == 1) {
            g.a(this.f5801d).f();
            t();
            if (this.o != null) {
                this.o.cancel(true);
            }
            synchronized (this.B) {
                try {
                    this.B.notifyAll();
                } catch (Exception unused) {
                }
            }
            synchronized (this.u) {
                try {
                    this.u.notifyAll();
                } catch (Exception unused2) {
                }
            }
            ALog.i(d(), "notifyStatus end", NotificationCompat.CATEGORY_STATUS, a(i2));
        }
        if (i2 == 2) {
            if (this.o != null) {
                this.o.cancel(true);
            }
            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new y(this, this.O), 120000L, TimeUnit.MILLISECONDS);
        } else if (i2 == 3) {
            t();
            g.a(this.f5801d).d();
            synchronized (this.B) {
                try {
                    this.B.notifyAll();
                } catch (Exception unused3) {
                }
            }
            this.f5802e.a(-10);
            a(false, true);
        }
        ALog.i(d(), "notifyStatus end", NotificationCompat.CATEGORY_STATUS, a(i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(String str, String str2, String str3) {
        if (com.taobao.accs.utl.v.b(this.f5801d) == 2) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            return true;
        }
        int i2 = 3;
        d(3);
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                i2 = 2;
            } else if (!TextUtils.isEmpty(str3)) {
                i2 = 1;
            }
        }
        this.I.setFailReason(i2);
        this.I.onConnectStop();
        String str4 = this.f5800c == 0 ? "service" : "inapp";
        a aVar = this.v;
        int i3 = aVar != null ? aVar.a : 0;
        UTMini.getInstance().commitEvent(66001, "DISCONNECT " + str4, (Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3), (Object) 221, this.y, this.L);
        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_CONNECT, "retrytimes:" + i3, i2 + "", "");
        return false;
    }

    @Override // com.taobao.accs.net.a
    public void a(String str, boolean z, String str2) {
        try {
            d(4);
            o();
            this.I.setCloseReason(str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.taobao.accs.net.a
    public boolean a(String str) {
        boolean z;
        synchronized (this.u) {
            z = true;
            int size = this.u.size() - 1;
            while (true) {
                if (size >= 0) {
                    Message message = this.u.get(size);
                    if (message != null && message.getType() == 1 && message.cunstomDataId != null && message.cunstomDataId.equals(str)) {
                        this.u.remove(size);
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

    @Override // com.taobao.accs.net.a
    public String d() {
        return "SilenceConn_" + this.f5810m;
    }

    @Override // com.taobao.accs.net.a
    protected void a(Context context) {
        if (this.f5804g) {
            return;
        }
        super.a(context);
        GlobalAppRuntimeInfo.setBackground(false);
        this.f5804g = true;
        ALog.i(d(), "init awcn success!", new Object[0]);
    }
}
