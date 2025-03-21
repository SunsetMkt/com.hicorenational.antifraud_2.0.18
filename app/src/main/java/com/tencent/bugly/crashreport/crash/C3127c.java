package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Build;
import com.heytap.mcssdk.constant.C2084a;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.crashreport.common.strategy.C3116a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.anr.C3125b;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.C3142ae;
import com.tencent.bugly.proguard.C3144ag;
import com.tencent.bugly.proguard.C3148ak;
import com.tencent.bugly.proguard.C3150am;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.c */
/* loaded from: classes2.dex */
public class C3127c {

    /* renamed from: a */
    public static int f10360a = 0;

    /* renamed from: b */
    public static boolean f10361b = false;

    /* renamed from: c */
    public static int f10362c = 2;

    /* renamed from: d */
    public static boolean f10363d = true;

    /* renamed from: e */
    public static int f10364e = 20480;

    /* renamed from: f */
    public static int f10365f = 20480;

    /* renamed from: g */
    public static long f10366g = 604800000;

    /* renamed from: h */
    public static String f10367h = null;

    /* renamed from: i */
    public static boolean f10368i = false;

    /* renamed from: j */
    public static String f10369j = null;

    /* renamed from: k */
    public static int f10370k = 5000;

    /* renamed from: l */
    public static boolean f10371l = true;

    /* renamed from: m */
    public static boolean f10372m = false;

    /* renamed from: n */
    public static String f10373n;

    /* renamed from: o */
    public static String f10374o;

    /* renamed from: v */
    private static C3127c f10375v;

    /* renamed from: A */
    private int f10376A = 31;

    /* renamed from: B */
    private boolean f10377B = false;

    /* renamed from: p */
    public final C3126b f10378p;

    /* renamed from: q */
    public final C3116a f10379q;

    /* renamed from: r */
    public final C3150am f10380r;

    /* renamed from: s */
    public BuglyStrategy.C3070a f10381s;

    /* renamed from: t */
    public InterfaceC3130f f10382t;

    /* renamed from: u */
    private final Context f10383u;

    /* renamed from: w */
    private final C3129e f10384w;

    /* renamed from: x */
    private final NativeCrashHandler f10385x;

    /* renamed from: y */
    private final C3125b f10386y;

    /* renamed from: z */
    private Boolean f10387z;

    protected C3127c(int i2, Context context, C3150am c3150am, boolean z, BuglyStrategy.C3070a c3070a, InterfaceC3130f interfaceC3130f, String str) {
        f10360a = i2;
        Context m9946a = C3154aq.m9946a(context);
        this.f10383u = m9946a;
        this.f10379q = C3116a.m9635a();
        this.f10380r = c3150am;
        this.f10381s = c3070a;
        this.f10382t = interfaceC3130f;
        C3148ak m9863a = C3148ak.m9863a();
        C3142ae m9817a = C3142ae.m9817a();
        this.f10378p = new C3126b(i2, m9946a, m9863a, m9817a, this.f10379q, c3070a, interfaceC3130f);
        C3113a m9531a = C3113a.m9531a(m9946a);
        this.f10384w = new C3129e(m9946a, this.f10378p, this.f10379q, m9531a);
        this.f10385x = NativeCrashHandler.getInstance(m9946a, m9531a, this.f10378p, this.f10379q, c3150am, z, str);
        m9531a.f10148O = this.f10385x;
        this.f10386y = new C3125b(m9946a, this.f10379q, m9531a, c3150am, m9817a, this.f10378p, c3070a);
    }

    /* renamed from: c */
    public synchronized void m9717c() {
        m9720f();
        m9722h();
        m9723i();
    }

    /* renamed from: d */
    public synchronized void m9718d() {
        m9719e();
        m9721g();
        m9724j();
    }

    /* renamed from: e */
    public void m9719e() {
        this.f10384w.m9751b();
    }

    /* renamed from: f */
    public void m9720f() {
        this.f10384w.m9748a();
    }

    /* renamed from: g */
    public void m9721g() {
        this.f10385x.setUserOpened(false);
    }

    /* renamed from: h */
    public void m9722h() {
        this.f10385x.setUserOpened(true);
    }

    /* renamed from: i */
    public void m9723i() {
        if (Build.VERSION.SDK_INT <= 19) {
            this.f10386y.m9673b(true);
        } else {
            this.f10386y.m9679h();
        }
    }

    /* renamed from: j */
    public void m9724j() {
        if (Build.VERSION.SDK_INT < 19) {
            this.f10386y.m9673b(false);
        } else {
            this.f10386y.m9680i();
        }
    }

    /* renamed from: k */
    public synchronized void m9725k() {
        this.f10386y.m9678g();
    }

    /* renamed from: l */
    public boolean m9726l() {
        return this.f10386y.m9668a();
    }

    /* renamed from: m */
    public void m9727m() {
        this.f10385x.checkUploadRecordCrash();
    }

    /* renamed from: n */
    public void m9728n() {
        if (C3113a.m9532b().f10197e.equals(AppInfo.m9516a(this.f10383u))) {
            this.f10385x.removeEmptyNativeRecordFiles();
        }
    }

    /* renamed from: o */
    public boolean m9729o() {
        return this.f10377B;
    }

    /* renamed from: p */
    public boolean m9730p() {
        return (this.f10376A & 16) > 0;
    }

    /* renamed from: q */
    public boolean m9731q() {
        return (this.f10376A & 8) > 0;
    }

    /* renamed from: r */
    public boolean m9732r() {
        return (this.f10376A & 4) > 0;
    }

    /* renamed from: s */
    public boolean m9733s() {
        return (this.f10376A & 2) > 0;
    }

    /* renamed from: t */
    public boolean m9734t() {
        return (this.f10376A & 1) > 0;
    }

    /* renamed from: a */
    public static synchronized C3127c m9706a(int i2, Context context, boolean z, BuglyStrategy.C3070a c3070a, InterfaceC3130f interfaceC3130f, String str) {
        C3127c c3127c;
        synchronized (C3127c.class) {
            if (f10375v == null) {
                f10375v = new C3127c(i2, context, C3150am.m9906a(), z, c3070a, interfaceC3130f, str);
            }
            c3127c = f10375v;
        }
        return c3127c;
    }

    /* renamed from: b */
    public boolean m9716b() {
        Boolean bool = this.f10387z;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = C3113a.m9532b().f10197e;
        List<C3144ag> m9832a = C3142ae.m9817a().m9832a(1);
        ArrayList arrayList = new ArrayList();
        if (m9832a == null || m9832a.size() <= 0) {
            this.f10387z = false;
            return false;
        }
        for (C3144ag c3144ag : m9832a) {
            if (str.equals(c3144ag.f10507c)) {
                this.f10387z = true;
                arrayList.add(c3144ag);
            }
        }
        if (arrayList.size() > 0) {
            C3142ae.m9817a().m9834a(arrayList);
        }
        return true;
    }

    /* renamed from: a */
    public static synchronized C3127c m9705a() {
        C3127c c3127c;
        synchronized (C3127c.class) {
            c3127c = f10375v;
        }
        return c3127c;
    }

    /* renamed from: a */
    public void m9711a(StrategyBean strategyBean) {
        this.f10384w.m9749a(strategyBean);
        this.f10385x.onStrategyChanged(strategyBean);
        this.f10386y.m9665a(strategyBean);
        m9710a(3000L);
    }

    /* renamed from: a */
    public synchronized void m9715a(boolean z, boolean z2, boolean z3) {
        this.f10385x.testNativeCrash(z, z2, z3);
    }

    /* renamed from: a */
    public void m9713a(final Thread thread, final Throwable th, final boolean z, final String str, final byte[] bArr, final boolean z2) {
        this.f10380r.m9908a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C3151an.m9921c("post a throwable %b", Boolean.valueOf(z));
                    C3127c.this.f10384w.m9752b(thread, th, false, str, bArr);
                    if (z2) {
                        C3151an.m9915a("clear user datas", new Object[0]);
                        C3113a.m9531a(C3127c.this.f10383u).m9537C();
                    }
                } catch (Throwable th2) {
                    if (!C3151an.m9919b(th2)) {
                        th2.printStackTrace();
                    }
                    C3151an.m9923e("java catch error: %s", th.toString());
                }
            }
        });
    }

    /* renamed from: a */
    public void m9712a(CrashDetailBean crashDetailBean) {
        this.f10378p.m9704e(crashDetailBean);
    }

    /* renamed from: a */
    public void m9710a(long j2) {
        C3150am.m9906a().m9909a(new Thread() { // from class: com.tencent.bugly.crashreport.crash.c.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                List<CrashDetailBean> list;
                if (C3154aq.m9967a(C3127c.this.f10383u, "local_crash_lock", C2084a.f6135q)) {
                    List<CrashDetailBean> m9688a = C3127c.this.f10378p.m9688a();
                    if (m9688a != null && m9688a.size() > 0) {
                        C3151an.m9921c("Size of crash list: %s", Integer.valueOf(m9688a.size()));
                        int size = m9688a.size();
                        if (size > 20) {
                            ArrayList arrayList = new ArrayList();
                            Collections.sort(m9688a);
                            for (int i2 = 0; i2 < 20; i2++) {
                                arrayList.add(m9688a.get((size - 1) - i2));
                            }
                            list = arrayList;
                        } else {
                            list = m9688a;
                        }
                        C3127c.this.f10378p.m9692a(list, 0L, false, false, false);
                    }
                    C3154aq.m9994c(C3127c.this.f10383u, "local_crash_lock");
                }
            }
        }, j2);
    }

    /* renamed from: a */
    public void m9709a(int i2) {
        this.f10376A = i2;
    }

    /* renamed from: a */
    public void m9714a(boolean z) {
        this.f10377B = z;
    }
}
