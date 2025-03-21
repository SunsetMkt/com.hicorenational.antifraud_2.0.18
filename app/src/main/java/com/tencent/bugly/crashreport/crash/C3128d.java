package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.crashreport.common.info.C3114b;
import com.tencent.bugly.crashreport.common.strategy.C3116a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C3150am;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3153ap;
import com.tencent.bugly.proguard.C3154aq;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.d */
/* loaded from: classes2.dex */
public class C3128d {

    /* renamed from: a */
    private static C3128d f10396a;

    /* renamed from: b */
    private C3116a f10397b;

    /* renamed from: c */
    private C3113a f10398c;

    /* renamed from: d */
    private C3126b f10399d;

    /* renamed from: e */
    private Context f10400e;

    private C3128d(Context context) {
        C3127c m9705a = C3127c.m9705a();
        if (m9705a == null) {
            return;
        }
        this.f10397b = C3116a.m9635a();
        this.f10398c = C3113a.m9531a(context);
        this.f10399d = m9705a.f10378p;
        this.f10400e = context;
        C3150am.m9906a().m9908a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.1
            @Override // java.lang.Runnable
            public void run() {
                C3128d.this.m9741b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m9741b() {
        C3151an.m9921c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.proguard.o");
            this.f10398c.getClass();
            C3154aq.m9966a(cls, "sdkPackageName", "com.tencent.bugly", (Object) null);
            C3151an.m9921c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            C3151an.m9915a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m9742c(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        String str4;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i2 == 4) {
            str4 = "Unity";
        } else if (i2 == 5 || i2 == 6) {
            str4 = "Cocos";
        } else {
            if (i2 != 8) {
                C3151an.m9922d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i2));
                return;
            }
            str4 = "H5";
        }
        String str5 = str4;
        C3151an.m9923e("[ExtraCrashManager] %s Crash Happen", str5);
        try {
            if (!this.f10397b.m9643b()) {
                C3151an.m9922d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean m9644c = this.f10397b.m9644c();
            if (!m9644c.f10230g && this.f10397b.m9643b()) {
                C3151an.m9923e("[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                C3126b.m9684a(str5, C3154aq.m9952a(), this.f10398c.f10197e, currentThread.getName(), str + "\n" + str2 + "\n" + str3, null);
                C3151an.m9923e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i2 != 4) {
                if (i2 == 5 || i2 == 6) {
                    if (!m9644c.f10235l) {
                        C3151an.m9923e("[ExtraCrashManager] %s report is disabled.", str5);
                        C3151an.m9923e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                        return;
                    }
                } else if (i2 == 8 && !m9644c.f10236m) {
                    C3151an.m9923e("[ExtraCrashManager] %s report is disabled.", str5);
                    C3151an.m9923e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            }
            CrashDetailBean m9740b = m9740b(currentThread, i2 == 8 ? 5 : i2, str, str2, str3, map);
            if (m9740b == null) {
                C3151an.m9923e("[ExtraCrashManager] Failed to package crash data.", new Object[0]);
                C3151an.m9923e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            C3126b.m9684a(str5, C3154aq.m9952a(), this.f10398c.f10197e, currentThread.getName(), str + "\n" + str2 + "\n" + str3, m9740b);
            if (!this.f10399d.m9694a(m9740b)) {
                this.f10399d.m9691a(m9740b, 3000L, false);
            }
            C3151an.m9923e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!C3151an.m9916a(th)) {
                    th.printStackTrace();
                }
                C3151an.m9923e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                C3151an.m9923e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static C3128d m9736a(Context context) {
        if (f10396a == null) {
            f10396a = new C3128d(context);
        }
        return f10396a;
    }

    /* renamed from: a */
    public static void m9739a(final Thread thread, final int i2, final String str, final String str2, final String str3, final Map<String, String> map) {
        C3150am.m9906a().m9908a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (C3128d.f10396a == null) {
                        C3151an.m9923e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    } else {
                        C3128d.f10396a.m9742c(thread, i2, str, str2, str3, map);
                    }
                } catch (Throwable th) {
                    if (!C3151an.m9919b(th)) {
                        th.printStackTrace();
                    }
                    C3151an.m9923e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }

    /* renamed from: b */
    private CrashDetailBean m9740b(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f10268C = C3114b.m9611i();
        crashDetailBean.f10269D = C3114b.m9607g();
        crashDetailBean.f10270E = C3114b.m9615k();
        crashDetailBean.f10271F = this.f10398c.m9583p();
        crashDetailBean.f10272G = this.f10398c.m9582o();
        crashDetailBean.f10273H = this.f10398c.m9584q();
        crashDetailBean.f10311w = C3154aq.m9954a(this.f10400e, C3127c.f10364e, C3127c.f10367h);
        crashDetailBean.f10290b = i2;
        crashDetailBean.f10293e = this.f10398c.m9575h();
        C3113a c3113a = this.f10398c;
        crashDetailBean.f10294f = c3113a.f10208p;
        crashDetailBean.f10295g = c3113a.m9590w();
        crashDetailBean.f10301m = this.f10398c.m9573g();
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        sb.append("");
        sb.append(str);
        crashDetailBean.f10302n = sb.toString();
        crashDetailBean.f10303o = "" + str2;
        if (str3 != null) {
            String[] split = str3.split("\n");
            if (split.length > 0) {
                str4 = split[0];
            }
        } else {
            str3 = "";
        }
        crashDetailBean.f10304p = str4;
        crashDetailBean.f10305q = str3;
        crashDetailBean.f10306r = System.currentTimeMillis();
        crashDetailBean.f10309u = C3154aq.m9981b(crashDetailBean.f10305q.getBytes());
        crashDetailBean.f10314z = C3154aq.m9962a(C3127c.f10365f, false);
        crashDetailBean.f10266A = this.f10398c.f10197e;
        crashDetailBean.f10267B = thread.getName() + "(" + thread.getId() + ")";
        crashDetailBean.f10274I = this.f10398c.m9592y();
        crashDetailBean.f10296h = this.f10398c.m9589v();
        C3113a c3113a2 = this.f10398c;
        crashDetailBean.f10279N = c3113a2.f10160a;
        crashDetailBean.f10280O = c3113a2.m9559a();
        crashDetailBean.f10282Q = this.f10398c.m9542H();
        crashDetailBean.f10283R = this.f10398c.m9543I();
        crashDetailBean.f10284S = this.f10398c.m9536B();
        crashDetailBean.f10285T = this.f10398c.m9541G();
        if (!C3127c.m9705a().m9729o()) {
            this.f10399d.m9700c(crashDetailBean);
        }
        crashDetailBean.f10313y = C3153ap.m9934a();
        if (crashDetailBean.f10281P == null) {
            crashDetailBean.f10281P = new LinkedHashMap();
        }
        if (map != null) {
            crashDetailBean.f10281P.putAll(map);
        }
        return crashDetailBean;
    }
}
