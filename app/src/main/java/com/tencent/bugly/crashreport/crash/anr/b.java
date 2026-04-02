package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.os.Process;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.as;
import com.tencent.bugly.proguard.at;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class b implements at {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f6247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f6248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final am f6249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.strategy.a f6250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f6251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.crash.b f6252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private FileObserver f6253i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private as f6255k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f6256l;
    private AtomicInteger a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6246b = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6254j = true;

    public b(Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2, am amVar, ae aeVar, com.tencent.bugly.crashreport.crash.b bVar, BuglyStrategy.a aVar3) {
        this.f6247c = aq.a(context);
        this.f6251g = context.getDir("bugly", 0).getAbsolutePath();
        this.f6248d = aVar2;
        this.f6249e = amVar;
        this.f6250f = aVar;
        this.f6252h = bVar;
    }

    protected ActivityManager.ProcessErrorStateInfo a(Context context, long j2) {
        if (j2 < 0) {
            j2 = 0;
        }
        try {
            an.c("to find!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            long j3 = j2 / 500;
            int i2 = 0;
            while (true) {
                an.c("waiting!", new Object[0]);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            an.c("found!", new Object[0]);
                            return processErrorStateInfo;
                        }
                    }
                }
                aq.b(500L);
                int i3 = i2 + 1;
                if (i2 >= j3) {
                    an.c("end!", new Object[0]);
                    return null;
                }
                i2 = i3;
            }
        } catch (Exception e2) {
            an.b(e2);
            return null;
        }
    }

    protected synchronized void b() {
        if (d()) {
            an.d("start when started!", new Object[0]);
            return;
        }
        this.f6253i = new FileObserver("/data/anr/", 8) { // from class: com.tencent.bugly.crashreport.crash.anr.b.1
            @Override // android.os.FileObserver
            public void onEvent(int i2, String str) {
                if (str == null) {
                    return;
                }
                String str2 = "/data/anr/" + str;
                if (str2.contains(AgooConstants.MESSAGE_TRACE)) {
                    b.this.a(str2);
                } else {
                    an.d("not anr file %s", str2);
                }
            }
        };
        try {
            this.f6253i.startWatching();
            an.a("start anr monitor!", new Object[0]);
            this.f6249e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.f();
                }
            });
        } catch (Throwable th) {
            this.f6253i = null;
            an.d("start anr monitor failed!", new Object[0]);
            if (!an.a(th)) {
                th.printStackTrace();
            }
        }
    }

    protected synchronized void c() {
        if (!d()) {
            an.d("close when closed!", new Object[0]);
            return;
        }
        try {
            this.f6253i.stopWatching();
            this.f6253i = null;
            an.d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            an.d("stop anr monitor failed!", new Object[0]);
            if (!an.a(th)) {
                th.printStackTrace();
            }
        }
    }

    protected synchronized boolean d() {
        return this.f6253i != null;
    }

    public synchronized boolean e() {
        return this.f6254j;
    }

    protected void f() {
        int iIndexOf;
        long jB = aq.b() - c.f6269g;
        File file = new File(this.f6251g);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    int i2 = 0;
                    for (File file2 : fileArrListFiles) {
                        String name = file2.getName();
                        if (name.startsWith("bugly_trace_")) {
                            try {
                                iIndexOf = name.indexOf(".txt");
                            } catch (Throwable unused) {
                                an.c("Trace file that has invalid format: " + name, new Object[0]);
                            }
                            if (iIndexOf <= 0 || Long.parseLong(name.substring(12, iIndexOf)) < jB) {
                                if (file2.delete()) {
                                    i2++;
                                }
                            }
                        }
                    }
                    an.c("Number of overdue trace files that has deleted: " + i2, new Object[0]);
                }
            } catch (Throwable th) {
                an.a(th);
            }
        }
    }

    public void g() {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= 30) {
                return;
            }
            try {
                an.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i3));
                aq.b(com.heytap.mcssdk.constant.a.r);
                i2 = i3;
            } catch (Throwable th) {
                if (an.a(th)) {
                    return;
                }
                th.printStackTrace();
                return;
            }
        }
    }

    public boolean h() {
        as asVar = this.f6255k;
        if (asVar != null && asVar.isAlive()) {
            return false;
        }
        this.f6255k = new as();
        as asVar2 = this.f6255k;
        StringBuilder sb = new StringBuilder();
        sb.append("Bugly-ThreadMonitor");
        int i2 = this.f6256l;
        this.f6256l = i2 + 1;
        sb.append(i2);
        asVar2.setName(sb.toString());
        this.f6255k.a();
        this.f6255k.a(this);
        return this.f6255k.d();
    }

    public boolean i() {
        as asVar = this.f6255k;
        if (asVar == null) {
            return false;
        }
        boolean zC = asVar.c();
        this.f6255k.b();
        this.f6255k.b(this);
        this.f6255k = null;
        return zC;
    }

    private synchronized void c(boolean z) {
        if (this.f6254j != z) {
            an.a("user change anr %b", Boolean.valueOf(z));
            this.f6254j = z;
        }
    }

    protected a a(Context context, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j2, Map<String, String> map) {
        File file = new File(context.getFilesDir(), "bugly/bugly_trace_" + j2 + ".txt");
        a aVar = new a();
        aVar.f6241c = j2;
        aVar.f6242d = file.getAbsolutePath();
        aVar.a = processErrorStateInfo != null ? processErrorStateInfo.processName : "";
        aVar.f6244f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : "";
        aVar.f6243e = processErrorStateInfo != null ? processErrorStateInfo.longMsg : "";
        aVar.f6240b = map;
        if (map != null) {
            for (String str : map.keySet()) {
                if (str.startsWith("main(")) {
                    aVar.f6245g = map.get(str);
                }
            }
        }
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(aVar.f6241c);
        objArr[1] = aVar.f6242d;
        objArr[2] = aVar.a;
        objArr[3] = aVar.f6244f;
        objArr[4] = aVar.f6243e;
        Map<String, String> map2 = aVar.f6240b;
        objArr[5] = Integer.valueOf(map2 != null ? map2.size() : 0);
        an.c("anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        return aVar;
    }

    public void b(boolean z) {
        c(z);
        boolean zE = e();
        com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (aVarA != null) {
            zE = zE && aVarA.c().f6195g;
        }
        if (zE != d()) {
            an.a("anr changed to %b", Boolean.valueOf(zE));
            a(zE);
        }
    }

    protected CrashDetailBean a(a aVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.k();
            crashDetailBean.F = this.f6248d.p();
            crashDetailBean.G = this.f6248d.o();
            crashDetailBean.H = this.f6248d.q();
            crashDetailBean.w = aq.a(this.f6247c, c.f6267e, c.f6270h);
            crashDetailBean.f6216b = 3;
            crashDetailBean.f6219e = this.f6248d.h();
            crashDetailBean.f6220f = this.f6248d.p;
            crashDetailBean.f6221g = this.f6248d.w();
            crashDetailBean.f6227m = this.f6248d.g();
            crashDetailBean.f6228n = "ANR_EXCEPTION";
            crashDetailBean.o = aVar.f6244f;
            crashDetailBean.q = aVar.f6245g;
            crashDetailBean.P = new HashMap();
            crashDetailBean.P.put("BUGLY_CR_01", aVar.f6243e);
            int iIndexOf = crashDetailBean.q != null ? crashDetailBean.q.indexOf("\n") : -1;
            crashDetailBean.p = iIndexOf > 0 ? crashDetailBean.q.substring(0, iIndexOf) : "GET_FAIL";
            crashDetailBean.r = aVar.f6241c;
            if (crashDetailBean.q != null) {
                crashDetailBean.u = aq.b(crashDetailBean.q.getBytes());
            }
            crashDetailBean.z = aVar.f6240b;
            crashDetailBean.A = aVar.a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.I = this.f6248d.y();
            crashDetailBean.f6222h = this.f6248d.v();
            crashDetailBean.f6223i = this.f6248d.J();
            crashDetailBean.v = aVar.f6242d;
            crashDetailBean.M = this.f6248d.u;
            crashDetailBean.N = this.f6248d.a;
            crashDetailBean.O = this.f6248d.a();
            crashDetailBean.Q = this.f6248d.H();
            crashDetailBean.R = this.f6248d.I();
            crashDetailBean.S = this.f6248d.B();
            crashDetailBean.T = this.f6248d.G();
            this.f6252h.c(crashDetailBean);
            crashDetailBean.y = ap.a();
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    protected boolean a(String str, String str2, String str3) throws Throwable {
        Map<String, String[]> map;
        BufferedWriter bufferedWriter;
        TraceFileHelper.a targetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (targetDumpInfo != null && (map = targetDumpInfo.f6239d) != null && map.size() > 0) {
            File file = new File(str2);
            try {
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                if (file.exists() && file.canWrite()) {
                    BufferedWriter bufferedWriter2 = null;
                    try {
                        try {
                            bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                            try {
                                String[] strArr = targetDumpInfo.f6239d.get("main");
                                int i2 = 3;
                                if (strArr != null && strArr.length >= 3) {
                                    String str4 = strArr[0];
                                    String str5 = strArr[1];
                                    bufferedWriter.write("\"main\" tid=" + strArr[2] + " :\n" + str4 + "\n" + str5 + "\n\n");
                                    bufferedWriter.flush();
                                }
                                for (Map.Entry<String, String[]> entry : targetDumpInfo.f6239d.entrySet()) {
                                    if (!entry.getKey().equals("main")) {
                                        if (entry.getValue() != null && entry.getValue().length >= i2) {
                                            String str6 = entry.getValue()[0];
                                            String str7 = entry.getValue()[1];
                                            bufferedWriter.write("\"" + entry.getKey() + "\" tid=" + entry.getValue()[2] + " :\n" + str6 + "\n" + str7 + "\n\n");
                                            bufferedWriter.flush();
                                        }
                                        i2 = 3;
                                    }
                                }
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e2) {
                                    if (!an.a(e2)) {
                                        e2.printStackTrace();
                                    }
                                }
                                return true;
                            } catch (IOException e3) {
                                e = e3;
                                bufferedWriter2 = bufferedWriter;
                                if (!an.a(e)) {
                                    e.printStackTrace();
                                }
                                an.e("dump trace fail %s", e.getClass().getName() + Constants.COLON_SEPARATOR + e.getMessage());
                                if (bufferedWriter2 != null) {
                                    try {
                                        bufferedWriter2.close();
                                    } catch (IOException e4) {
                                        if (!an.a(e4)) {
                                            e4.printStackTrace();
                                        }
                                    }
                                }
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                Throwable th2 = th;
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                        throw th2;
                                    } catch (IOException e5) {
                                        if (!an.a(e5)) {
                                            e5.printStackTrace();
                                            throw th2;
                                        }
                                        throw th2;
                                    }
                                }
                                throw th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedWriter = bufferedWriter2;
                        }
                    } catch (IOException e6) {
                        e = e6;
                    }
                } else {
                    an.e("backup file create fail %s", str2);
                    return false;
                }
            } catch (Exception e7) {
                if (!an.a(e7)) {
                    e7.printStackTrace();
                }
                an.e("backup file create error! %s  %s", e7.getClass().getName() + Constants.COLON_SEPARATOR + e7.getMessage(), str2);
                return false;
            }
        } else {
            an.e("not found trace dump for %s", str3);
            return false;
        }
    }

    public boolean a() {
        return this.a.get() != 0;
    }

    public boolean a(Context context, String str, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j2, Map<String, String> map) {
        a aVarA = a(context, processErrorStateInfo, j2, map);
        if (!this.f6250f.b()) {
            an.e("crash report sync remote fail, will not upload to Bugly , print local for helpful!", new Object[0]);
            com.tencent.bugly.crashreport.crash.b.a("ANR", aq.a(), aVarA.a, "main", aVarA.f6243e, null);
            return false;
        }
        if (!this.f6250f.c().f6198j) {
            an.d("ANR Report is closed!", new Object[0]);
            return false;
        }
        an.a("found visiable anr , start to upload!", new Object[0]);
        CrashDetailBean crashDetailBeanA = a(aVarA);
        if (crashDetailBeanA == null) {
            an.e("pack anr fail!", new Object[0]);
            return false;
        }
        c.a().a(crashDetailBeanA);
        if (crashDetailBeanA.a >= 0) {
            an.a("backup anr record success!", new Object[0]);
        } else {
            an.d("backup anr record fail!", new Object[0]);
        }
        if (str != null && new File(str).exists()) {
            this.a.set(3);
            if (a(str, aVarA.f6242d, aVarA.a)) {
                an.a("backup trace success", new Object[0]);
            }
        }
        com.tencent.bugly.crashreport.crash.b.a("ANR", aq.a(), aVarA.a, "main", aVarA.f6243e, crashDetailBeanA);
        if (!this.f6252h.a(crashDetailBeanA)) {
            this.f6252h.a(crashDetailBeanA, 3000L, true);
        }
        this.f6252h.b(crashDetailBeanA);
        return true;
    }

    public final void a(String str) {
        long j2;
        synchronized (this) {
            if (this.a.get() != 0) {
                an.c("trace started return ", new Object[0]);
                return;
            }
            this.a.set(1);
            try {
                an.c("read trace first dump for create time!", new Object[0]);
                TraceFileHelper.a firstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                long jCurrentTimeMillis = firstDumpInfo != null ? firstDumpInfo.f6238c : -1L;
                if (jCurrentTimeMillis == -1) {
                    an.d("trace dump fail could not get time!", new Object[0]);
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
                j2 = jCurrentTimeMillis;
            } finally {
                try {
                } finally {
                }
            }
            if (Math.abs(j2 - this.f6246b) < com.heytap.mcssdk.constant.a.q) {
                an.d("should not process ANR too Fre in %d", 10000);
            } else {
                this.f6246b = j2;
                this.a.set(1);
                try {
                    Map<String, String> mapA = aq.a(c.f6268f, false);
                    if (mapA != null && mapA.size() > 0) {
                        ActivityManager.ProcessErrorStateInfo processErrorStateInfoA = a(this.f6247c, com.heytap.mcssdk.constant.a.q);
                        if (processErrorStateInfoA == null) {
                            an.c("proc state is unvisiable!", new Object[0]);
                        } else {
                            if (processErrorStateInfoA.pid == Process.myPid()) {
                                an.a("found visiable anr , start to process!", new Object[0]);
                                a(this.f6247c, str, processErrorStateInfoA, j2, mapA);
                                return;
                            }
                            an.c("not mind proc!", processErrorStateInfoA.processName);
                        }
                    } else {
                        an.d("can't get all thread skip this anr", new Object[0]);
                    }
                } catch (Throwable th) {
                    an.a(th);
                    an.e("get all thread stack fail!", new Object[0]);
                }
            }
        }
    }

    protected synchronized void a(boolean z) {
        if (z) {
            b();
        } else {
            c();
        }
    }

    public synchronized void a(StrategyBean strategyBean) {
        if (strategyBean == null) {
            return;
        }
        if (strategyBean.f6198j != d()) {
            an.d("server anr changed to %b", Boolean.valueOf(strategyBean.f6198j));
        }
        if (Build.VERSION.SDK_INT <= 19) {
            boolean z = strategyBean.f6198j && e();
            if (z != d()) {
                an.a("anr changed to %b", Boolean.valueOf(z));
                a(z);
            }
        } else if (strategyBean.f6198j) {
            h();
        } else {
            i();
        }
    }

    @Override // com.tencent.bugly.proguard.at
    public boolean a(Thread thread) {
        new HashMap();
        if (thread.getName().contains("main")) {
            ActivityManager.ProcessErrorStateInfo processErrorStateInfoA = a(this.f6247c, com.heytap.mcssdk.constant.a.q);
            if (processErrorStateInfoA == null) {
                an.c("anr handler onThreadBlock proc state is unvisiable!", new Object[0]);
                return false;
            }
            if (processErrorStateInfoA.pid != Process.myPid()) {
                an.c("onThreadBlock not mind proc!", processErrorStateInfoA.processName);
                return false;
            }
            try {
                Map<String, String> mapA = aq.a(200000, false);
                an.a("onThreadBlock found visiable anr , start to process!", new Object[0]);
                a(this.f6247c, "", processErrorStateInfoA, System.currentTimeMillis(), mapA);
            } catch (Throwable unused) {
                return false;
            }
        } else {
            an.c("anr handler onThreadBlock only care main thread", new Object[0]);
        }
        return true;
    }
}
