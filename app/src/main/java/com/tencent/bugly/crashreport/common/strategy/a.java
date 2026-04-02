package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.proguard.ad;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.ag;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.bj;
import com.tencent.bugly.proguard.bk;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static int a = 1000;

    /* JADX INFO: renamed from: b */
    public static long f6203b = 259200000;

    /* JADX INFO: renamed from: c */
    private static a f6204c;

    /* JADX INFO: renamed from: i */
    private static String f6205i;

    /* JADX INFO: renamed from: d */
    private final List<com.tencent.bugly.a> f6206d;

    /* JADX INFO: renamed from: h */
    private Context f6210h;

    /* JADX INFO: renamed from: g */
    private StrategyBean f6209g = null;

    /* JADX INFO: renamed from: f */
    private final StrategyBean f6208f = new StrategyBean();

    /* JADX INFO: renamed from: e */
    private final am f6207e = am.a();

    /* JADX INFO: renamed from: com.tencent.bugly.crashreport.common.strategy.a$1 */
    /* JADX INFO: compiled from: BUGLY */
    class AnonymousClass1 extends Thread {
        AnonymousClass1() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Map<String, byte[]> mapA = ae.a().a(a.a, (ad) null, true);
                if (mapA != null) {
                    byte[] bArr = mapA.get("device");
                    byte[] bArr2 = mapA.get("gateway");
                    if (bArr != null) {
                        com.tencent.bugly.crashreport.common.info.a.a(a.this.f6210h).e(new String(bArr));
                    }
                    if (bArr2 != null) {
                        com.tencent.bugly.crashreport.common.info.a.a(a.this.f6210h).d(new String(bArr2));
                    }
                }
                a.this.f6209g = a.this.d();
                if (a.this.f6209g != null) {
                    if (!aq.a(a.f6205i) && aq.c(a.f6205i)) {
                        a.this.f6209g.r = a.f6205i;
                        a.this.f6209g.s = a.f6205i;
                    } else if (com.tencent.bugly.crashreport.common.info.a.b() == null || !"oversea".equals(com.tencent.bugly.crashreport.common.info.a.b().F)) {
                        if (TextUtils.isEmpty(a.this.f6209g.r)) {
                            a.this.f6209g.r = StrategyBean.f6190b;
                        }
                        if (TextUtils.isEmpty(a.this.f6209g.s)) {
                            a.this.f6209g.s = StrategyBean.f6191c;
                        }
                    } else if ("http://android.bugly.qq.com/rqd/async".equals(a.this.f6209g.s) || "http://aexception.bugly.qq.com:8012/rqd/async".equals(a.this.f6209g.s) || TextUtils.isEmpty(a.this.f6209g.s)) {
                        a.this.f6209g.r = StrategyBean.f6190b;
                        a.this.f6209g.s = StrategyBean.f6191c;
                    }
                }
            } catch (Throwable th) {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
            }
            a aVar = a.this;
            aVar.a(aVar.f6209g, false);
        }
    }

    protected a(Context context, List<com.tencent.bugly.a> list) {
        this.f6210h = context;
        this.f6206d = list;
    }

    public StrategyBean c() {
        StrategyBean strategyBean = this.f6209g;
        if (strategyBean != null) {
            if (!aq.c(strategyBean.r)) {
                this.f6209g.r = StrategyBean.f6190b;
            }
            if (!aq.c(this.f6209g.s)) {
                this.f6209g.s = StrategyBean.f6191c;
            }
            return this.f6209g;
        }
        if (!aq.a(f6205i) && aq.c(f6205i)) {
            StrategyBean strategyBean2 = this.f6208f;
            String str = f6205i;
            strategyBean2.r = str;
            strategyBean2.s = str;
        }
        return this.f6208f;
    }

    public StrategyBean d() {
        byte[] bArr;
        List<ag> listA = ae.a().a(2);
        if (listA == null || listA.size() <= 0 || (bArr = listA.get(0).f6373g) == null) {
            return null;
        }
        return (StrategyBean) aq.a(bArr, StrategyBean.CREATOR);
    }

    public synchronized boolean b() {
        return this.f6209g != null;
    }

    public static synchronized a a(Context context, List<com.tencent.bugly.a> list) {
        if (f6204c == null) {
            f6204c = new a(context, list);
        }
        return f6204c;
    }

    public void a(long j2) {
        this.f6207e.a(new Thread() { // from class: com.tencent.bugly.crashreport.common.strategy.a.1
            AnonymousClass1() {
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Map<String, byte[]> mapA = ae.a().a(a.a, (ad) null, true);
                    if (mapA != null) {
                        byte[] bArr = mapA.get("device");
                        byte[] bArr2 = mapA.get("gateway");
                        if (bArr != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.f6210h).e(new String(bArr));
                        }
                        if (bArr2 != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.f6210h).d(new String(bArr2));
                        }
                    }
                    a.this.f6209g = a.this.d();
                    if (a.this.f6209g != null) {
                        if (!aq.a(a.f6205i) && aq.c(a.f6205i)) {
                            a.this.f6209g.r = a.f6205i;
                            a.this.f6209g.s = a.f6205i;
                        } else if (com.tencent.bugly.crashreport.common.info.a.b() == null || !"oversea".equals(com.tencent.bugly.crashreport.common.info.a.b().F)) {
                            if (TextUtils.isEmpty(a.this.f6209g.r)) {
                                a.this.f6209g.r = StrategyBean.f6190b;
                            }
                            if (TextUtils.isEmpty(a.this.f6209g.s)) {
                                a.this.f6209g.s = StrategyBean.f6191c;
                            }
                        } else if ("http://android.bugly.qq.com/rqd/async".equals(a.this.f6209g.s) || "http://aexception.bugly.qq.com:8012/rqd/async".equals(a.this.f6209g.s) || TextUtils.isEmpty(a.this.f6209g.s)) {
                            a.this.f6209g.r = StrategyBean.f6190b;
                            a.this.f6209g.s = StrategyBean.f6191c;
                        }
                    }
                } catch (Throwable th) {
                    if (!an.a(th)) {
                        th.printStackTrace();
                    }
                }
                a aVar = a.this;
                aVar.a(aVar.f6209g, false);
            }
        }, j2);
    }

    public static synchronized a a() {
        return f6204c;
    }

    protected void a(StrategyBean strategyBean, boolean z) {
        an.c("[Strategy] Notify %s", b.class.getName());
        b.a(strategyBean, z);
        for (com.tencent.bugly.a aVar : this.f6206d) {
            try {
                an.c("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (!aq.a(str) && aq.c(str)) {
            f6205i = str;
        } else {
            an.d("URL user set is invalid.", new Object[0]);
        }
    }

    public void a(bk bkVar) {
        if (bkVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f6209g;
        if (strategyBean == null || bkVar.f6496h != strategyBean.p) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f6195g = bkVar.a;
            strategyBean2.f6197i = bkVar.f6491c;
            strategyBean2.f6196h = bkVar.f6490b;
            if (aq.a(f6205i) || !aq.c(f6205i)) {
                if (aq.c(bkVar.f6492d)) {
                    an.c("[Strategy] Upload url changes to %s", bkVar.f6492d);
                    strategyBean2.r = bkVar.f6492d;
                }
                if (aq.c(bkVar.f6493e)) {
                    an.c("[Strategy] Exception upload url changes to %s", bkVar.f6493e);
                    strategyBean2.s = bkVar.f6493e;
                }
            }
            bj bjVar = bkVar.f6494f;
            if (bjVar != null && !aq.a(bjVar.a)) {
                strategyBean2.u = bkVar.f6494f.a;
            }
            long j2 = bkVar.f6496h;
            if (j2 != 0) {
                strategyBean2.p = j2;
            }
            Map<String, String> map = bkVar.f6495g;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = bkVar.f6495g;
                strategyBean2.v = map2;
                String str = map2.get("B11");
                if (str != null && str.equals("1")) {
                    strategyBean2.f6198j = true;
                } else {
                    strategyBean2.f6198j = false;
                }
                String str2 = bkVar.f6495g.get("B3");
                if (str2 != null) {
                    strategyBean2.y = Long.valueOf(str2).longValue();
                }
                int i2 = bkVar.f6500l;
                strategyBean2.q = i2;
                strategyBean2.x = i2;
                String str3 = bkVar.f6495g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int i3 = Integer.parseInt(str3);
                        if (i3 > 0) {
                            strategyBean2.w = i3;
                        }
                    } catch (Exception e2) {
                        if (!an.a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                String str4 = bkVar.f6495g.get("B25");
                if (str4 != null && str4.equals("1")) {
                    strategyBean2.f6200l = true;
                } else {
                    strategyBean2.f6200l = false;
                }
            }
            an.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f6195g), Boolean.valueOf(strategyBean2.f6197i), Boolean.valueOf(strategyBean2.f6196h), Boolean.valueOf(strategyBean2.f6198j), Boolean.valueOf(strategyBean2.f6199k), Boolean.valueOf(strategyBean2.f6202n), Boolean.valueOf(strategyBean2.o), Long.valueOf(strategyBean2.q), Boolean.valueOf(strategyBean2.f6200l), Long.valueOf(strategyBean2.p));
            this.f6209g = strategyBean2;
            if (!aq.c(bkVar.f6492d)) {
                an.c("[Strategy] download url is null", new Object[0]);
                this.f6209g.r = "";
            }
            if (!aq.c(bkVar.f6493e)) {
                an.c("[Strategy] download crashurl is null", new Object[0]);
                this.f6209g.s = "";
            }
            ae.a().b(2);
            ag agVar = new ag();
            agVar.f6368b = 2;
            agVar.a = strategyBean2.f6193e;
            agVar.f6371e = strategyBean2.f6194f;
            agVar.f6373g = aq.a(strategyBean2);
            ae.a().a(agVar);
            a(strategyBean2, true);
        }
    }
}
