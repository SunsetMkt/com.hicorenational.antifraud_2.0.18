package com.taobao.accs.p199ut.p200a;

import com.heytap.mcssdk.constant.C2084a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.ut.a.c */
/* loaded from: classes2.dex */
public class C3028c {

    /* renamed from: a */
    public int f9643a;

    /* renamed from: b */
    public int f9644b;

    /* renamed from: f */
    public String f9648f;

    /* renamed from: g */
    public String f9649g;

    /* renamed from: h */
    public long f9650h;

    /* renamed from: i */
    public boolean f9651i;

    /* renamed from: j */
    public boolean f9652j;

    /* renamed from: k */
    private long f9653k = 0;

    /* renamed from: c */
    public boolean f9645c = false;

    /* renamed from: d */
    public int f9646d = 0;

    /* renamed from: e */
    public int f9647e = 0;

    /* renamed from: a */
    public void m9172a() {
        String str;
        String str2;
        String str3;
        long currentTimeMillis = System.currentTimeMillis();
        if (ALog.isPrintLog()) {
            ALog.m9180d("MonitorStatistic", "commitUT interval:" + (currentTimeMillis - this.f9653k) + " interval1:" + (currentTimeMillis - this.f9650h), new Object[0]);
        }
        if (currentTimeMillis - this.f9653k <= 1200000 || currentTimeMillis - this.f9650h <= C2084a.f6122d) {
            return;
        }
        HashMap hashMap = new HashMap();
        String str4 = null;
        try {
            str2 = String.valueOf(this.f9646d);
            try {
                String valueOf = String.valueOf(this.f9647e);
                try {
                    str = String.valueOf(221);
                    try {
                        hashMap.put("connStatus", String.valueOf(this.f9643a));
                        hashMap.put("connType", String.valueOf(this.f9644b));
                        hashMap.put("tcpConnected", String.valueOf(this.f9645c));
                        hashMap.put("proxy", String.valueOf(this.f9648f));
                        hashMap.put("startServiceTime", String.valueOf(this.f9650h));
                        hashMap.put("commitTime", String.valueOf(currentTimeMillis));
                        hashMap.put("networkAvailable", String.valueOf(this.f9651i));
                        hashMap.put("threadIsalive", String.valueOf(this.f9652j));
                        hashMap.put("url", this.f9649g);
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            try {
                                ALog.m9180d("MonitorStatistic", UTMini.getCommitInfo(66001, str2, valueOf, str, hashMap), new Object[0]);
                            } catch (Throwable th) {
                                th = th;
                                str4 = valueOf;
                                ALog.m9180d("MonitorStatistic", UTMini.getCommitInfo(66001, str2, str4, str, hashMap) + AbstractC1191a.f2568g + th.toString(), new Object[0]);
                            }
                        }
                        str3 = valueOf;
                        try {
                            UTMini.getInstance().commitEvent(66001, "MONITOR", str2, valueOf, str, hashMap);
                            this.f9653k = currentTimeMillis;
                        } catch (Throwable th2) {
                            th = th2;
                            str = str;
                            str4 = str3;
                            ALog.m9180d("MonitorStatistic", UTMini.getCommitInfo(66001, str2, str4, str, hashMap) + AbstractC1191a.f2568g + th.toString(), new Object[0]);
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
