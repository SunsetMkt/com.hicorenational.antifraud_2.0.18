package com.taobao.accs.ut.a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5856b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f5862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f5865k = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5857c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5858d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5859e = 0;

    public void a() {
        String strValueOf;
        String strValueOf2;
        String str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (ALog.isPrintLog()) {
            ALog.d("MonitorStatistic", "commitUT interval:" + (jCurrentTimeMillis - this.f5865k) + " interval1:" + (jCurrentTimeMillis - this.f5862h), new Object[0]);
        }
        if (jCurrentTimeMillis - this.f5865k <= 1200000 || jCurrentTimeMillis - this.f5862h <= com.heytap.mcssdk.constant.a.f3868d) {
            return;
        }
        HashMap map = new HashMap();
        String str2 = null;
        try {
            strValueOf2 = String.valueOf(this.f5858d);
            try {
                String strValueOf3 = String.valueOf(this.f5859e);
                try {
                    strValueOf = String.valueOf(221);
                    try {
                        map.put("connStatus", String.valueOf(this.a));
                        map.put("connType", String.valueOf(this.f5856b));
                        map.put("tcpConnected", String.valueOf(this.f5857c));
                        map.put("proxy", String.valueOf(this.f5860f));
                        map.put("startServiceTime", String.valueOf(this.f5862h));
                        map.put("commitTime", String.valueOf(jCurrentTimeMillis));
                        map.put("networkAvailable", String.valueOf(this.f5863i));
                        map.put("threadIsalive", String.valueOf(this.f5864j));
                        map.put("url", this.f5861g);
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            try {
                                ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, strValueOf2, strValueOf3, strValueOf, map), new Object[0]);
                            } catch (Throwable th) {
                                th = th;
                                str2 = strValueOf3;
                                ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, strValueOf2, str2, strValueOf, map) + d.c.a.b.a.a.f10074g + th.toString(), new Object[0]);
                            }
                        }
                        str = strValueOf3;
                        try {
                            UTMini.getInstance().commitEvent(66001, "MONITOR", strValueOf2, strValueOf3, strValueOf, map);
                            this.f5865k = jCurrentTimeMillis;
                        } catch (Throwable th2) {
                            th = th2;
                            strValueOf = strValueOf;
                            str2 = str;
                            ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, strValueOf2, str2, strValueOf, map) + d.c.a.b.a.a.f10074g + th.toString(), new Object[0]);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str = strValueOf3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str = strValueOf3;
                    strValueOf = null;
                }
            } catch (Throwable th5) {
                th = th5;
                strValueOf = null;
            }
        } catch (Throwable th6) {
            th = th6;
            strValueOf = null;
            strValueOf2 = null;
        }
    }
}
