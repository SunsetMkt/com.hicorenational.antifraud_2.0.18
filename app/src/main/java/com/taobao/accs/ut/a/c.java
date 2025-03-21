package com.taobao.accs.ut.a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f8582a;

    /* renamed from: b, reason: collision with root package name */
    public int f8583b;

    /* renamed from: f, reason: collision with root package name */
    public String f8587f;

    /* renamed from: g, reason: collision with root package name */
    public String f8588g;

    /* renamed from: h, reason: collision with root package name */
    public long f8589h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8590i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8591j;

    /* renamed from: k, reason: collision with root package name */
    private long f8592k = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8584c = false;

    /* renamed from: d, reason: collision with root package name */
    public int f8585d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f8586e = 0;

    public void a() {
        String str;
        String str2;
        String str3;
        long currentTimeMillis = System.currentTimeMillis();
        if (ALog.isPrintLog()) {
            ALog.d("MonitorStatistic", "commitUT interval:" + (currentTimeMillis - this.f8592k) + " interval1:" + (currentTimeMillis - this.f8589h), new Object[0]);
        }
        if (currentTimeMillis - this.f8592k <= 1200000 || currentTimeMillis - this.f8589h <= com.heytap.mcssdk.constant.a.f5800d) {
            return;
        }
        HashMap hashMap = new HashMap();
        String str4 = null;
        try {
            str2 = String.valueOf(this.f8585d);
            try {
                String valueOf = String.valueOf(this.f8586e);
                try {
                    str = String.valueOf(221);
                    try {
                        hashMap.put("connStatus", String.valueOf(this.f8582a));
                        hashMap.put("connType", String.valueOf(this.f8583b));
                        hashMap.put("tcpConnected", String.valueOf(this.f8584c));
                        hashMap.put("proxy", String.valueOf(this.f8587f));
                        hashMap.put("startServiceTime", String.valueOf(this.f8589h));
                        hashMap.put("commitTime", String.valueOf(currentTimeMillis));
                        hashMap.put("networkAvailable", String.valueOf(this.f8590i));
                        hashMap.put("threadIsalive", String.valueOf(this.f8591j));
                        hashMap.put("url", this.f8588g);
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            try {
                                ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, str2, valueOf, str, hashMap), new Object[0]);
                            } catch (Throwable th) {
                                th = th;
                                str4 = valueOf;
                                ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, str2, str4, str, hashMap) + c.c.a.b.a.a.f3100g + th.toString(), new Object[0]);
                            }
                        }
                        str3 = valueOf;
                        try {
                            UTMini.getInstance().commitEvent(66001, "MONITOR", str2, valueOf, str, hashMap);
                            this.f8592k = currentTimeMillis;
                        } catch (Throwable th2) {
                            th = th2;
                            str = str;
                            str4 = str3;
                            ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, str2, str4, str, hashMap) + c.c.a.b.a.a.f3100g + th.toString(), new Object[0]);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str3 = valueOf;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str3 = valueOf;
                    str = null;
                }
            } catch (Throwable th5) {
                th = th5;
                str = null;
            }
        } catch (Throwable th6) {
            th = th6;
            str = null;
            str2 = null;
        }
    }
}
