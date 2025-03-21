package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.AbstractC3071a;
import com.tencent.bugly.crashreport.biz.C3111b;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.proguard.C3142ae;
import com.tencent.bugly.proguard.C3144ag;
import com.tencent.bugly.proguard.C3150am;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;
import com.tencent.bugly.proguard.C3174bj;
import com.tencent.bugly.proguard.C3175bk;
import com.tencent.bugly.proguard.InterfaceC3141ad;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.common.strategy.a */
/* loaded from: classes2.dex */
public class C3116a {

    /* renamed from: a */
    public static int f10249a = 1000;

    /* renamed from: b */
    public static long f10250b = 259200000;

    /* renamed from: c */
    private static C3116a f10251c;

    /* renamed from: i */
    private static String f10252i;

    /* renamed from: d */
    private final List<AbstractC3071a> f10253d;

    /* renamed from: h */
    private Context f10257h;

    /* renamed from: g */
    private StrategyBean f10256g = null;

    /* renamed from: f */
    private final StrategyBean f10255f = new StrategyBean();

    /* renamed from: e */
    private final C3150am f10254e = C3150am.m9906a();

    protected C3116a(Context context, List<AbstractC3071a> list) {
        this.f10257h = context;
        this.f10253d = list;
    }

    /* renamed from: c */
    public StrategyBean m9644c() {
        StrategyBean strategyBean = this.f10256g;
        if (strategyBean != null) {
            if (!C3154aq.m9995c(strategyBean.f10241r)) {
                this.f10256g.f10241r = StrategyBean.f10225b;
            }
            if (!C3154aq.m9995c(this.f10256g.f10242s)) {
                this.f10256g.f10242s = StrategyBean.f10226c;
            }
            return this.f10256g;
        }
        if (!C3154aq.m9970a(f10252i) && C3154aq.m9995c(f10252i)) {
            StrategyBean strategyBean2 = this.f10255f;
            String str = f10252i;
            strategyBean2.f10241r = str;
            strategyBean2.f10242s = str;
        }
        return this.f10255f;
    }

    /* renamed from: d */
    public StrategyBean m9645d() {
        byte[] bArr;
        List<C3144ag> m9832a = C3142ae.m9817a().m9832a(2);
        if (m9832a == null || m9832a.size() <= 0 || (bArr = m9832a.get(0).f10511g) == null) {
            return null;
        }
        return (StrategyBean) C3154aq.m9951a(bArr, StrategyBean.CREATOR);
    }

    /* renamed from: b */
    public synchronized boolean m9643b() {
        return this.f10256g != null;
    }

    /* renamed from: a */
    public static synchronized C3116a m9636a(Context context, List<AbstractC3071a> list) {
        C3116a c3116a;
        synchronized (C3116a.class) {
            if (f10251c == null) {
                f10251c = new C3116a(context, list);
            }
            c3116a = f10251c;
        }
        return c3116a;
    }

    /* renamed from: a */
    public void m9640a(long j2) {
        this.f10254e.m9909a(new Thread() { // from class: com.tencent.bugly.crashreport.common.strategy.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Map<String, byte[]> m9833a = C3142ae.m9817a().m9833a(C3116a.f10249a, (InterfaceC3141ad) null, true);
                    if (m9833a != null) {
                        byte[] bArr = m9833a.get("device");
                        byte[] bArr2 = m9833a.get("gateway");
                        if (bArr != null) {
                            C3113a.m9531a(C3116a.this.f10257h).m9570e(new String(bArr));
                        }
                        if (bArr2 != null) {
                            C3113a.m9531a(C3116a.this.f10257h).m9568d(new String(bArr2));
                        }
                    }
                    C3116a.this.f10256g = C3116a.this.m9645d();
                    if (C3116a.this.f10256g != null) {
                        if (!C3154aq.m9970a(C3116a.f10252i) && C3154aq.m9995c(C3116a.f10252i)) {
                            C3116a.this.f10256g.f10241r = C3116a.f10252i;
                            C3116a.this.f10256g.f10242s = C3116a.f10252i;
                        } else if (C3113a.m9532b() == null || !"oversea".equals(C3113a.m9532b().f10139F)) {
                            if (TextUtils.isEmpty(C3116a.this.f10256g.f10241r)) {
                                C3116a.this.f10256g.f10241r = StrategyBean.f10225b;
                            }
                            if (TextUtils.isEmpty(C3116a.this.f10256g.f10242s)) {
                                C3116a.this.f10256g.f10242s = StrategyBean.f10226c;
                            }
                        } else if ("http://android.bugly.qq.com/rqd/async".equals(C3116a.this.f10256g.f10242s) || "http://aexception.bugly.qq.com:8012/rqd/async".equals(C3116a.this.f10256g.f10242s) || TextUtils.isEmpty(C3116a.this.f10256g.f10242s)) {
                            C3116a.this.f10256g.f10241r = StrategyBean.f10225b;
                            C3116a.this.f10256g.f10242s = StrategyBean.f10226c;
                        }
                    }
                } catch (Throwable th) {
                    if (!C3151an.m9916a(th)) {
                        th.printStackTrace();
                    }
                }
                C3116a c3116a = C3116a.this;
                c3116a.m9641a(c3116a.f10256g, false);
            }
        }, j2);
    }

    /* renamed from: a */
    public static synchronized C3116a m9635a() {
        C3116a c3116a;
        synchronized (C3116a.class) {
            c3116a = f10251c;
        }
        return c3116a;
    }

    /* renamed from: a */
    protected void m9641a(StrategyBean strategyBean, boolean z) {
        C3151an.m9921c("[Strategy] Notify %s", C3111b.class.getName());
        C3111b.m9494a(strategyBean, z);
        for (AbstractC3071a abstractC3071a : this.f10253d) {
            try {
                C3151an.m9921c("[Strategy] Notify %s", abstractC3071a.getClass().getName());
                abstractC3071a.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!C3151an.m9916a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m9637a(String str) {
        if (!C3154aq.m9970a(str) && C3154aq.m9995c(str)) {
            f10252i = str;
        } else {
            C3151an.m9922d("URL user set is invalid.", new Object[0]);
        }
    }

    /* renamed from: a */
    public void m9642a(C3175bk c3175bk) {
        if (c3175bk == null) {
            return;
        }
        StrategyBean strategyBean = this.f10256g;
        if (strategyBean == null || c3175bk.f10707h != strategyBean.f10239p) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f10230g = c3175bk.f10700a;
            strategyBean2.f10232i = c3175bk.f10702c;
            strategyBean2.f10231h = c3175bk.f10701b;
            if (C3154aq.m9970a(f10252i) || !C3154aq.m9995c(f10252i)) {
                if (C3154aq.m9995c(c3175bk.f10703d)) {
                    C3151an.m9921c("[Strategy] Upload url changes to %s", c3175bk.f10703d);
                    strategyBean2.f10241r = c3175bk.f10703d;
                }
                if (C3154aq.m9995c(c3175bk.f10704e)) {
                    C3151an.m9921c("[Strategy] Exception upload url changes to %s", c3175bk.f10704e);
                    strategyBean2.f10242s = c3175bk.f10704e;
                }
            }
            C3174bj c3174bj = c3175bk.f10705f;
            if (c3174bj != null && !C3154aq.m9970a(c3174bj.f10695a)) {
                strategyBean2.f10244u = c3175bk.f10705f.f10695a;
            }
            long j2 = c3175bk.f10707h;
            if (j2 != 0) {
                strategyBean2.f10239p = j2;
            }
            Map<String, String> map = c3175bk.f10706g;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = c3175bk.f10706g;
                strategyBean2.f10245v = map2;
                String str = map2.get("B11");
                if (str != null && str.equals("1")) {
                    strategyBean2.f10233j = true;
                } else {
                    strategyBean2.f10233j = false;
                }
                String str2 = c3175bk.f10706g.get("B3");
                if (str2 != null) {
                    strategyBean2.f10248y = Long.valueOf(str2).longValue();
                }
                int i2 = c3175bk.f10711l;
                strategyBean2.f10240q = i2;
                strategyBean2.f10247x = i2;
                String str3 = c3175bk.f10706g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean2.f10246w = parseInt;
                        }
                    } catch (Exception e2) {
                        if (!C3151an.m9916a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                String str4 = c3175bk.f10706g.get("B25");
                if (str4 != null && str4.equals("1")) {
                    strategyBean2.f10235l = true;
                } else {
                    strategyBean2.f10235l = false;
                }
            }
            C3151an.m9915a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f10230g), Boolean.valueOf(strategyBean2.f10232i), Boolean.valueOf(strategyBean2.f10231h), Boolean.valueOf(strategyBean2.f10233j), Boolean.valueOf(strategyBean2.f10234k), Boolean.valueOf(strategyBean2.f10237n), Boolean.valueOf(strategyBean2.f10238o), Long.valueOf(strategyBean2.f10240q), Boolean.valueOf(strategyBean2.f10235l), Long.valueOf(strategyBean2.f10239p));
            this.f10256g = strategyBean2;
            if (!C3154aq.m9995c(c3175bk.f10703d)) {
                C3151an.m9921c("[Strategy] download url is null", new Object[0]);
                this.f10256g.f10241r = "";
            }
            if (!C3154aq.m9995c(c3175bk.f10704e)) {
                C3151an.m9921c("[Strategy] download crashurl is null", new Object[0]);
                this.f10256g.f10242s = "";
            }
            C3142ae.m9817a().m9840b(2);
            C3144ag c3144ag = new C3144ag();
            c3144ag.f10506b = 2;
            c3144ag.f10505a = strategyBean2.f10228e;
            c3144ag.f10509e = strategyBean2.f10229f;
            c3144ag.f10511g = C3154aq.m9973a(strategyBean2);
            C3142ae.m9817a().m9837a(c3144ag);
            m9641a(strategyBean2, true);
        }
    }
}
