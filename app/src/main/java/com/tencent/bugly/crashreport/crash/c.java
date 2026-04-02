package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Build;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.ag;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static int a = 0;

    /* JADX INFO: renamed from: b */
    public static boolean f6264b = false;

    /* JADX INFO: renamed from: c */
    public static int f6265c = 2;

    /* JADX INFO: renamed from: d */
    public static boolean f6266d = true;

    /* JADX INFO: renamed from: e */
    public static int f6267e = 20480;

    /* JADX INFO: renamed from: f */
    public static int f6268f = 20480;

    /* JADX INFO: renamed from: g */
    public static long f6269g = 604800000;

    /* JADX INFO: renamed from: h */
    public static String f6270h = null;

    /* JADX INFO: renamed from: i */
    public static boolean f6271i = false;

    /* JADX INFO: renamed from: j */
    public static String f6272j = null;

    /* JADX INFO: renamed from: k */
    public static int f6273k = 5000;

    /* JADX INFO: renamed from: l */
    public static boolean f6274l = true;

    /* JADX INFO: renamed from: m */
    public static boolean f6275m = false;

    /* JADX INFO: renamed from: n */
    public static String f6276n;
    public static String o;
    private static c v;
    private int A = 31;
    private boolean B = false;
    public final b p;
    public final com.tencent.bugly.crashreport.common.strategy.a q;
    public final am r;
    public BuglyStrategy.a s;
    public f t;
    private final Context u;
    private final e w;
    private final NativeCrashHandler x;
    private final com.tencent.bugly.crashreport.crash.anr.b y;
    private Boolean z;

    /* JADX INFO: renamed from: com.tencent.bugly.crashreport.crash.c$1 */
    /* JADX INFO: compiled from: BUGLY */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Thread f6277b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ Throwable f6278c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ String f6279d;

        /* JADX INFO: renamed from: e */
        final /* synthetic */ byte[] f6280e;

        /* JADX INFO: renamed from: f */
        final /* synthetic */ boolean f6281f;

        AnonymousClass1(boolean z, Thread thread, Throwable th, String str, byte[] bArr, boolean z2) {
            z = z;
            thread = thread;
            th = th;
            str = str;
            bArr = bArr;
            z = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                an.c("post a throwable %b", Boolean.valueOf(z));
                c.this.w.b(thread, th, false, str, bArr);
                if (z) {
                    an.a("clear user datas", new Object[0]);
                    com.tencent.bugly.crashreport.common.info.a.a(c.this.u).C();
                }
            } catch (Throwable th) {
                if (!an.b(th)) {
                    th.printStackTrace();
                }
                an.e("java catch error: %s", th.toString());
            }
        }
    }

    /* JADX INFO: renamed from: com.tencent.bugly.crashreport.crash.c$2 */
    /* JADX INFO: compiled from: BUGLY */
    class AnonymousClass2 extends Thread {
        AnonymousClass2() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            List<CrashDetailBean> list;
            if (aq.a(c.this.u, "local_crash_lock", com.heytap.mcssdk.constant.a.q)) {
                List<CrashDetailBean> listA = c.this.p.a();
                if (listA != null && listA.size() > 0) {
                    an.c("Size of crash list: %s", Integer.valueOf(listA.size()));
                    int size = listA.size();
                    if (size > 20) {
                        ArrayList arrayList = new ArrayList();
                        Collections.sort(listA);
                        for (int i2 = 0; i2 < 20; i2++) {
                            arrayList.add(listA.get((size - 1) - i2));
                        }
                        list = arrayList;
                    } else {
                        list = listA;
                    }
                    c.this.p.a(list, 0L, false, false, false);
                }
                aq.c(c.this.u, "local_crash_lock");
            }
        }
    }

    protected c(int i2, Context context, am amVar, boolean z, BuglyStrategy.a aVar, f fVar, String str) {
        a = i2;
        Context contextA = aq.a(context);
        this.u = contextA;
        this.q = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.r = amVar;
        this.s = aVar;
        this.t = fVar;
        ak akVarA = ak.a();
        ae aeVarA = ae.a();
        this.p = new b(i2, contextA, akVarA, aeVarA, this.q, aVar, fVar);
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(contextA);
        this.w = new e(contextA, this.p, this.q, aVarA);
        this.x = NativeCrashHandler.getInstance(contextA, aVarA, this.p, this.q, amVar, z, str);
        aVarA.O = this.x;
        this.y = new com.tencent.bugly.crashreport.crash.anr.b(contextA, this.q, aVarA, amVar, aeVarA, this.p, aVar);
    }

    public synchronized void c() {
        f();
        h();
        i();
    }

    public synchronized void d() {
        e();
        g();
        j();
    }

    public void e() {
        this.w.b();
    }

    public void f() {
        this.w.a();
    }

    public void g() {
        this.x.setUserOpened(false);
    }

    public void h() {
        this.x.setUserOpened(true);
    }

    public void i() {
        if (Build.VERSION.SDK_INT <= 19) {
            this.y.b(true);
        } else {
            this.y.h();
        }
    }

    public void j() {
        if (Build.VERSION.SDK_INT < 19) {
            this.y.b(false);
        } else {
            this.y.i();
        }
    }

    public synchronized void k() {
        this.y.g();
    }

    public boolean l() {
        return this.y.a();
    }

    public void m() {
        this.x.checkUploadRecordCrash();
    }

    public void n() {
        if (com.tencent.bugly.crashreport.common.info.a.b().f6176e.equals(AppInfo.a(this.u))) {
            this.x.removeEmptyNativeRecordFiles();
        }
    }

    public boolean o() {
        return this.B;
    }

    public boolean p() {
        return (this.A & 16) > 0;
    }

    public boolean q() {
        return (this.A & 8) > 0;
    }

    public boolean r() {
        return (this.A & 4) > 0;
    }

    public boolean s() {
        return (this.A & 2) > 0;
    }

    public boolean t() {
        return (this.A & 1) > 0;
    }

    public static synchronized c a(int i2, Context context, boolean z, BuglyStrategy.a aVar, f fVar, String str) {
        if (v == null) {
            v = new c(i2, context, am.a(), z, aVar, fVar, str);
        }
        return v;
    }

    public boolean b() {
        Boolean bool = this.z;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = com.tencent.bugly.crashreport.common.info.a.b().f6176e;
        List<ag> listA = ae.a().a(1);
        ArrayList arrayList = new ArrayList();
        if (listA == null || listA.size() <= 0) {
            this.z = false;
            return false;
        }
        for (ag agVar : listA) {
            if (str.equals(agVar.f6369c)) {
                this.z = true;
                arrayList.add(agVar);
            }
        }
        if (arrayList.size() > 0) {
            ae.a().a(arrayList);
        }
        return true;
    }

    public static synchronized c a() {
        return v;
    }

    public void a(StrategyBean strategyBean) {
        this.w.a(strategyBean);
        this.x.onStrategyChanged(strategyBean);
        this.y.a(strategyBean);
        a(3000L);
    }

    public synchronized void a(boolean z, boolean z2, boolean z3) {
        this.x.testNativeCrash(z, z2, z3);
    }

    public void a(Thread thread, Throwable th, boolean z, String str, byte[] bArr, boolean z2) {
        this.r.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.c.1
            final /* synthetic */ boolean a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ Thread f6277b;

            /* JADX INFO: renamed from: c */
            final /* synthetic */ Throwable f6278c;

            /* JADX INFO: renamed from: d */
            final /* synthetic */ String f6279d;

            /* JADX INFO: renamed from: e */
            final /* synthetic */ byte[] f6280e;

            /* JADX INFO: renamed from: f */
            final /* synthetic */ boolean f6281f;

            AnonymousClass1(boolean z3, Thread thread2, Throwable th2, String str2, byte[] bArr2, boolean z22) {
                z = z3;
                thread = thread2;
                th = th2;
                str = str2;
                bArr = bArr2;
                z = z22;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    an.c("post a throwable %b", Boolean.valueOf(z));
                    c.this.w.b(thread, th, false, str, bArr);
                    if (z) {
                        an.a("clear user datas", new Object[0]);
                        com.tencent.bugly.crashreport.common.info.a.a(c.this.u).C();
                    }
                } catch (Throwable th2) {
                    if (!an.b(th2)) {
                        th2.printStackTrace();
                    }
                    an.e("java catch error: %s", th.toString());
                }
            }
        });
    }

    public void a(CrashDetailBean crashDetailBean) {
        this.p.e(crashDetailBean);
    }

    public void a(long j2) {
        am.a().a(new Thread() { // from class: com.tencent.bugly.crashreport.crash.c.2
            AnonymousClass2() {
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                List<CrashDetailBean> list;
                if (aq.a(c.this.u, "local_crash_lock", com.heytap.mcssdk.constant.a.q)) {
                    List<CrashDetailBean> listA = c.this.p.a();
                    if (listA != null && listA.size() > 0) {
                        an.c("Size of crash list: %s", Integer.valueOf(listA.size()));
                        int size = listA.size();
                        if (size > 20) {
                            ArrayList arrayList = new ArrayList();
                            Collections.sort(listA);
                            for (int i2 = 0; i2 < 20; i2++) {
                                arrayList.add(listA.get((size - 1) - i2));
                            }
                            list = arrayList;
                        } else {
                            list = listA;
                        }
                        c.this.p.a(list, 0L, false, false, false);
                    }
                    aq.c(c.this.u, "local_crash_lock");
                }
            }
        }, j2);
    }

    public void a(int i2) {
        this.A = i2;
    }

    public void a(boolean z) {
        this.B = z;
    }
}
