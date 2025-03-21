package anet.channel.detect;

import android.content.Context;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ConnType;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.session.b;
import anet.channel.statist.HorseRaceStat;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
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
/* loaded from: classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    TreeMap<String, l.c> f1717a = new TreeMap<>();

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f1718b = new AtomicInteger(1);

    d() {
    }

    private void c(String str, l.e eVar) {
        String str2 = "HR" + this.f1718b.getAndIncrement();
        ALog.i("anet.HorseRaceDetector", "startTcpTask", str2, "ip", eVar.f2019a, "port", Integer.valueOf(eVar.f2020b.f1989a));
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, eVar);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Socket socket = new Socket(eVar.f2019a, eVar.f2020b.f1989a);
            socket.setSoTimeout(eVar.f2020b.f1991c == 0 ? 10000 : eVar.f2020b.f1991c);
            ALog.i("anet.HorseRaceDetector", "socket connect success", str2, new Object[0]);
            horseRaceStat.connRet = 1;
            horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
            socket.close();
        } catch (IOException unused) {
            horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
            horseRaceStat.connErrorCode = -404;
        }
        AppMonitor.getInstance().commitStat(horseRaceStat);
    }

    void a() {
        ALog.e("anet.HorseRaceDetector", "network detect thread start", null, new Object[0]);
        while (true) {
            synchronized (this.f1717a) {
                if (!AwcnConfig.isHorseRaceEnable()) {
                    this.f1717a.clear();
                    return;
                }
                Map.Entry<String, l.c> pollFirstEntry = this.f1717a.pollFirstEntry();
                if (pollFirstEntry == null) {
                    return;
                }
                try {
                    a(pollFirstEntry.getValue());
                } catch (Exception e2) {
                    ALog.e("anet.HorseRaceDetector", "start hr task failed", null, e2, new Object[0]);
                }
            }
        }
    }

    public void b() {
        StrategyCenter.getInstance().registerListener(new e(this));
        AppLifecycle.registerLifecycleListener(new f(this));
    }

    private void b(String str, l.e eVar) {
        ConnProtocol valueOf = ConnProtocol.valueOf(eVar.f2020b);
        ConnType valueOf2 = ConnType.valueOf(valueOf);
        if (valueOf2 == null) {
            return;
        }
        ALog.i("anet.HorseRaceDetector", "startLongLinkTask", null, Constants.KEY_HOST, str, "ip", eVar.f2019a, "port", Integer.valueOf(eVar.f2020b.f1989a), "protocol", valueOf);
        String str2 = "HR" + this.f1718b.getAndIncrement();
        Context context = GlobalAppRuntimeInfo.getContext();
        StringBuilder sb = new StringBuilder();
        sb.append(valueOf2.isSSL() ? DefaultWebClient.HTTPS_SCHEME : DefaultWebClient.HTTP_SCHEME);
        sb.append(str);
        TnetSpdySession tnetSpdySession = new TnetSpdySession(context, new anet.channel.entity.a(sb.toString(), str2, a(valueOf, eVar)));
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, eVar);
        long currentTimeMillis = System.currentTimeMillis();
        tnetSpdySession.registerEventcb(257, new h(this, horseRaceStat, currentTimeMillis, str2, eVar, tnetSpdySession));
        tnetSpdySession.connect();
        synchronized (horseRaceStat) {
            try {
                horseRaceStat.wait(eVar.f2020b.f1991c == 0 ? 10000 : eVar.f2020b.f1991c);
                if (horseRaceStat.connTime == 0) {
                    horseRaceStat.connTime = System.currentTimeMillis() - currentTimeMillis;
                }
                a(eVar.f2019a, horseRaceStat);
                AppMonitor.getInstance().commitStat(horseRaceStat);
            } catch (InterruptedException unused) {
            }
        }
        tnetSpdySession.close(false);
    }

    private void a(l.c cVar) {
        l.e[] eVarArr = cVar.f2010b;
        if (eVarArr == null || eVarArr.length == 0) {
            return;
        }
        String str = cVar.f2009a;
        int i2 = 0;
        while (true) {
            l.e[] eVarArr2 = cVar.f2010b;
            if (i2 >= eVarArr2.length) {
                return;
            }
            l.e eVar = eVarArr2[i2];
            String str2 = eVar.f2020b.f1990b;
            if (!str2.equalsIgnoreCase(HttpConstant.HTTP) && !str2.equalsIgnoreCase(HttpConstant.HTTPS)) {
                if (!str2.equalsIgnoreCase(ConnType.HTTP2) && !str2.equalsIgnoreCase(ConnType.SPDY) && !str2.equalsIgnoreCase(ConnType.QUIC)) {
                    if (str2.equalsIgnoreCase("tcp")) {
                        c(str, eVar);
                    }
                } else {
                    b(str, eVar);
                }
            } else {
                a(str, eVar);
            }
            i2++;
        }
    }

    private void a(String str, l.e eVar) {
        HttpUrl parse = HttpUrl.parse(eVar.f2020b.f1990b + HttpConstant.SCHEME_SPLIT + str + eVar.f2021c);
        if (parse == null) {
            return;
        }
        ALog.i("anet.HorseRaceDetector", "startShortLinkTask", null, "url", parse);
        Request build = new Request.Builder().setUrl(parse).addHeader("Connection", "close").setConnectTimeout(eVar.f2020b.f1991c).setReadTimeout(eVar.f2020b.f1992d).setRedirectEnable(false).setSslSocketFactory(new anet.channel.util.j(str)).setSeq("HR" + this.f1718b.getAndIncrement()).build();
        build.setDnsOptimize(eVar.f2019a, eVar.f2020b.f1989a);
        long currentTimeMillis = System.currentTimeMillis();
        b.a a2 = anet.channel.session.b.a(build, (RequestCb) null);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, eVar);
        horseRaceStat.connTime = currentTimeMillis2;
        int i2 = a2.f1883a;
        if (i2 <= 0) {
            horseRaceStat.connErrorCode = i2;
        } else {
            horseRaceStat.connRet = 1;
            horseRaceStat.reqRet = i2 == 200 ? 1 : 0;
            horseRaceStat.reqErrorCode = a2.f1883a;
            horseRaceStat.reqTime = horseRaceStat.connTime;
        }
        a(eVar.f2019a, horseRaceStat);
        AppMonitor.getInstance().commitStat(horseRaceStat);
    }

    private static IConnStrategy a(ConnProtocol connProtocol, l.e eVar) {
        return new j(eVar, connProtocol);
    }

    private void a(String str, HorseRaceStat horseRaceStat) {
        if (AwcnConfig.isPing6Enable() && anet.channel.strategy.utils.c.b(str)) {
            try {
                PingResponse pingResponse = (PingResponse) new PingTask(str, 1000, 3, 0, 0).launch().get();
                if (pingResponse == null) {
                    return;
                }
                horseRaceStat.pingSuccessCount = pingResponse.getSuccessCnt();
                horseRaceStat.pingTimeoutCount = 3 - horseRaceStat.pingSuccessCount;
                horseRaceStat.localIP = pingResponse.getLocalIPStr();
            } catch (Throwable th) {
                ALog.e("anet.HorseRaceDetector", "ping6 task fail.", null, th, new Object[0]);
            }
        }
    }
}
