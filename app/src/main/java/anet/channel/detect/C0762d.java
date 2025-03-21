package anet.channel.detect;

import android.content.Context;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.C0781a;
import anet.channel.entity.ConnType;
import anet.channel.request.Request;
import anet.channel.session.C0811b;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.HorseRaceStat;
import anet.channel.strategy.C0842l;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.utils.C0848c;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.C0864j;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import com.just.agentweb.DefaultWebClient;
import com.taobao.accs.common.Constants;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.netutil.PingResponse;
import org.android.netutil.PingTask;

/* compiled from: Taobao */
/* renamed from: anet.channel.detect.d */
/* loaded from: classes.dex */
class C0762d {

    /* renamed from: a */
    TreeMap<String, C0842l.c> f791a = new TreeMap<>();

    /* renamed from: b */
    private AtomicInteger f792b = new AtomicInteger(1);

    C0762d() {
    }

    /* renamed from: c */
    private void m475c(String str, C0842l.e eVar) {
        String str2 = "HR" + this.f792b.getAndIncrement();
        ALog.m716i("anet.HorseRaceDetector", "startTcpTask", str2, "ip", eVar.f1139a, "port", Integer.valueOf(eVar.f1140b.f1109a));
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, eVar);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Socket socket = new Socket(eVar.f1139a, eVar.f1140b.f1109a);
            socket.setSoTimeout(eVar.f1140b.f1111c == 0 ? 10000 : eVar.f1140b.f1111c);
            ALog.m716i("anet.HorseRaceDetector", "socket connect success", str2, new Object[0]);
            horseRaceStat.connRet = 1;
            horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
            socket.close();
        } catch (IOException unused) {
            horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
            horseRaceStat.connErrorCode = -404;
        }
        AppMonitor.getInstance().commitStat(horseRaceStat);
    }

    /* renamed from: a */
    void m476a() {
        ALog.m715e("anet.HorseRaceDetector", "network detect thread start", null, new Object[0]);
        while (true) {
            synchronized (this.f791a) {
                if (!AwcnConfig.isHorseRaceEnable()) {
                    this.f791a.clear();
                    return;
                }
                Map.Entry<String, C0842l.c> pollFirstEntry = this.f791a.pollFirstEntry();
                if (pollFirstEntry == null) {
                    return;
                }
                try {
                    m471a(pollFirstEntry.getValue());
                } catch (Exception e2) {
                    ALog.m714e("anet.HorseRaceDetector", "start hr task failed", null, e2, new Object[0]);
                }
            }
        }
    }

    /* renamed from: b */
    public void m477b() {
        StrategyCenter.getInstance().registerListener(new C0763e(this));
        AppLifecycle.registerLifecycleListener(new C0764f(this));
    }

    /* renamed from: b */
    private void m474b(String str, C0842l.e eVar) {
        ConnProtocol valueOf = ConnProtocol.valueOf(eVar.f1140b);
        ConnType valueOf2 = ConnType.valueOf(valueOf);
        if (valueOf2 == null) {
            return;
        }
        ALog.m716i("anet.HorseRaceDetector", "startLongLinkTask", null, Constants.KEY_HOST, str, "ip", eVar.f1139a, "port", Integer.valueOf(eVar.f1140b.f1109a), "protocol", valueOf);
        String str2 = "HR" + this.f792b.getAndIncrement();
        Context context = GlobalAppRuntimeInfo.getContext();
        StringBuilder sb = new StringBuilder();
        sb.append(valueOf2.isSSL() ? DefaultWebClient.HTTPS_SCHEME : DefaultWebClient.HTTP_SCHEME);
        sb.append(str);
        TnetSpdySession tnetSpdySession = new TnetSpdySession(context, new C0781a(sb.toString(), str2, m470a(valueOf, eVar)));
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, eVar);
        long currentTimeMillis = System.currentTimeMillis();
        tnetSpdySession.registerEventcb(257, new C0766h(this, horseRaceStat, currentTimeMillis, str2, eVar, tnetSpdySession));
        tnetSpdySession.connect();
        synchronized (horseRaceStat) {
            try {
                horseRaceStat.wait(eVar.f1140b.f1111c == 0 ? 10000 : eVar.f1140b.f1111c);
                if (horseRaceStat.connTime == 0) {
                    horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
                }
                m472a(eVar.f1139a, horseRaceStat);
                AppMonitor.getInstance().commitStat(horseRaceStat);
            } catch (InterruptedException unused) {
            }
        }
        tnetSpdySession.close(false);
    }

    /* renamed from: a */
    private void m471a(C0842l.c cVar) {
        C0842l.e[] eVarArr = cVar.f1130b;
        if (eVarArr == null || eVarArr.length == 0) {
            return;
        }
        String str = cVar.f1129a;
        int i2 = 0;
        while (true) {
            C0842l.e[] eVarArr2 = cVar.f1130b;
            if (i2 >= eVarArr2.length) {
                return;
            }
            C0842l.e eVar = eVarArr2[i2];
            String str2 = eVar.f1140b.f1110b;
            if (!str2.equalsIgnoreCase(HttpConstant.HTTP) && !str2.equalsIgnoreCase(HttpConstant.HTTPS)) {
                if (!str2.equalsIgnoreCase(ConnType.HTTP2) && !str2.equalsIgnoreCase(ConnType.SPDY) && !str2.equalsIgnoreCase(ConnType.QUIC)) {
                    if (str2.equalsIgnoreCase("tcp")) {
                        m475c(str, eVar);
                    }
                } else {
                    m474b(str, eVar);
                }
            } else {
                m473a(str, eVar);
            }
            i2++;
        }
    }

    /* renamed from: a */
    private void m473a(String str, C0842l.e eVar) {
        HttpUrl parse = HttpUrl.parse(eVar.f1140b.f1110b + HttpConstant.SCHEME_SPLIT + str + eVar.f1141c);
        if (parse == null) {
            return;
        }
        ALog.m716i("anet.HorseRaceDetector", "startShortLinkTask", null, "url", parse);
        Request build = new Request.Builder().setUrl(parse).addHeader("Connection", "close").setConnectTimeout(eVar.f1140b.f1111c).setReadTimeout(eVar.f1140b.f1112d).setRedirectEnable(false).setSslSocketFactory(new C0864j(str)).setSeq("HR" + this.f792b.getAndIncrement()).build();
        build.setDnsOptimize(eVar.f1139a, eVar.f1140b.f1109a);
        long currentTimeMillis = System.currentTimeMillis();
        C0811b.a m602a = C0811b.m602a(build, (RequestCb) null);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, eVar);
        horseRaceStat.connTime = currentTimeMillis2;
        int i2 = m602a.f981a;
        if (i2 <= 0) {
            horseRaceStat.connErrorCode = i2;
        } else {
            horseRaceStat.connRet = 1;
            horseRaceStat.reqRet = i2 == 200 ? 1 : 0;
            horseRaceStat.reqErrorCode = m602a.f981a;
            horseRaceStat.reqTime = horseRaceStat.connTime;
        }
        m472a(eVar.f1139a, horseRaceStat);
        AppMonitor.getInstance().commitStat(horseRaceStat);
    }

    /* renamed from: a */
    private static IConnStrategy m470a(ConnProtocol connProtocol, C0842l.e eVar) {
        return new C0768j(eVar, connProtocol);
    }

    /* renamed from: a */
    private void m472a(String str, HorseRaceStat horseRaceStat) {
        if (AwcnConfig.isPing6Enable() && C0848c.m708b(str)) {
            try {
                PingResponse pingResponse = (PingResponse) new PingTask(str, 1000, 3, 0, 0).launch().get();
                if (pingResponse == null) {
                    return;
                }
                horseRaceStat.pingSuccessCount = pingResponse.getSuccessCnt();
                horseRaceStat.pingTimeoutCount = 3 - horseRaceStat.pingSuccessCount;
                horseRaceStat.localIP = pingResponse.getLocalIPStr();
            } catch (Throwable th) {
                ALog.m714e("anet.HorseRaceDetector", "ping6 task fail.", null, th, new Object[0]);
            }
        }
    }
}
