package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.os.Process;
import com.heytap.mcssdk.constant.C2084a;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.crashreport.common.info.C3114b;
import com.tencent.bugly.crashreport.common.strategy.C3116a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.C3126b;
import com.tencent.bugly.crashreport.crash.C3127c;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.proguard.C3142ae;
import com.tencent.bugly.proguard.C3150am;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3153ap;
import com.tencent.bugly.proguard.C3154aq;
import com.tencent.bugly.proguard.C3156as;
import com.tencent.bugly.proguard.InterfaceC3157at;
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

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.anr.b */
/* loaded from: classes2.dex */
public class C3125b implements InterfaceC3157at {

    /* renamed from: c */
    private final Context f10339c;

    /* renamed from: d */
    private final C3113a f10340d;

    /* renamed from: e */
    private final C3150am f10341e;

    /* renamed from: f */
    private final C3116a f10342f;

    /* renamed from: g */
    private final String f10343g;

    /* renamed from: h */
    private final C3126b f10344h;

    /* renamed from: i */
    private FileObserver f10345i;

    /* renamed from: k */
    private C3156as f10347k;

    /* renamed from: l */
    private int f10348l;

    /* renamed from: a */
    private AtomicInteger f10337a = new AtomicInteger(0);

    /* renamed from: b */
    private long f10338b = -1;

    /* renamed from: j */
    private boolean f10346j = true;

    public C3125b(Context context, C3116a c3116a, C3113a c3113a, C3150am c3150am, C3142ae c3142ae, C3126b c3126b, BuglyStrategy.C3070a c3070a) {
        this.f10339c = C3154aq.m9946a(context);
        this.f10343g = context.getDir("bugly", 0).getAbsolutePath();
        this.f10340d = c3113a;
        this.f10341e = c3150am;
        this.f10342f = c3116a;
        this.f10344h = c3126b;
    }

    /* renamed from: a */
    protected ActivityManager.ProcessErrorStateInfo m9662a(Context context, long j2) {
        if (j2 < 0) {
            j2 = 0;
        }
        try {
            C3151an.m9921c("to find!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            long j3 = j2 / 500;
            int i2 = 0;
            while (true) {
                C3151an.m9921c("waiting!", new Object[0]);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            C3151an.m9921c("found!", new Object[0]);
                            return processErrorStateInfo;
                        }
                    }
                }
                C3154aq.m9983b(500L);
                int i3 = i2 + 1;
                if (i2 >= j3) {
                    C3151an.m9921c("end!", new Object[0]);
                    return null;
                }
                i2 = i3;
            }
        } catch (Exception e2) {
            C3151an.m9919b(e2);
            return null;
        }
    }

    /* renamed from: b */
    protected synchronized void m9672b() {
        if (m9675d()) {
            C3151an.m9922d("start when started!", new Object[0]);
            return;
        }
        this.f10345i = new FileObserver("/data/anr/", 8) { // from class: com.tencent.bugly.crashreport.crash.anr.b.1
            @Override // android.os.FileObserver
            public void onEvent(int i2, String str) {
                if (str == null) {
                    return;
                }
                String str2 = "/data/anr/" + str;
                if (str2.contains(AgooConstants.MESSAGE_TRACE)) {
                    C3125b.this.m9666a(str2);
                } else {
                    C3151an.m9922d("not anr file %s", str2);
                }
            }
        };
        try {
            this.f10345i.startWatching();
            C3151an.m9915a("start anr monitor!", new Object[0]);
            this.f10341e.m9908a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.2
                @Override // java.lang.Runnable
                public void run() {
                    C3125b.this.m9677f();
                }
            });
        } catch (Throwable th) {
            this.f10345i = null;
            C3151an.m9922d("start anr monitor failed!", new Object[0]);
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    protected synchronized void m9674c() {
        if (!m9675d()) {
            C3151an.m9922d("close when closed!", new Object[0]);
            return;
        }
        try {
            this.f10345i.stopWatching();
            this.f10345i = null;
            C3151an.m9922d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            C3151an.m9922d("stop anr monitor failed!", new Object[0]);
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    protected synchronized boolean m9675d() {
        return this.f10345i != null;
    }

    /* renamed from: e */
    public synchronized boolean m9676e() {
        return this.f10346j;
    }

    /* renamed from: f */
    protected void m9677f() {
        long m9978b = C3154aq.m9978b() - C3127c.f10366g;
        File file = new File(this.f10343g);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i2 = 0;
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        if (name.startsWith("bugly_trace_")) {
                            try {
                                int indexOf = name.indexOf(".txt");
                                if (indexOf > 0 && Long.parseLong(name.substring(12, indexOf)) >= m9978b) {
                                }
                            } catch (Throwable unused) {
                                C3151an.m9921c("Trace file that has invalid format: " + name, new Object[0]);
                            }
                            if (file2.delete()) {
                                i2++;
                            }
                        }
                    }
                    C3151an.m9921c("Number of overdue trace files that has deleted: " + i2, new Object[0]);
                }
            } catch (Throwable th) {
                C3151an.m9916a(th);
            }
        }
    }

    /* renamed from: g */
    public void m9678g() {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= 30) {
                return;
            }
            try {
                C3151an.m9915a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i3));
                C3154aq.m9983b(C2084a.f6136r);
                i2 = i3;
            } catch (Throwable th) {
                if (C3151an.m9916a(th)) {
                    return;
                }
                th.printStackTrace();
                return;
            }
        }
    }

    /* renamed from: h */
    public boolean m9679h() {
        C3156as c3156as = this.f10347k;
        if (c3156as != null && c3156as.isAlive()) {
            return false;
        }
        this.f10347k = new C3156as();
        C3156as c3156as2 = this.f10347k;
        StringBuilder sb = new StringBuilder();
        sb.append("Bugly-ThreadMonitor");
        int i2 = this.f10348l;
        this.f10348l = i2 + 1;
        sb.append(i2);
        c3156as2.setName(sb.toString());
        this.f10347k.m10007a();
        this.f10347k.m10010a(this);
        return this.f10347k.m10015d();
    }

    /* renamed from: i */
    public boolean m9680i() {
        C3156as c3156as = this.f10347k;
        if (c3156as == null) {
            return false;
        }
        boolean m10014c = c3156as.m10014c();
        this.f10347k.m10011b();
        this.f10347k.m10013b(this);
        this.f10347k = null;
        return m10014c;
    }

    /* renamed from: c */
    private synchronized void m9661c(boolean z) {
        if (this.f10346j != z) {
            C3151an.m9915a("user change anr %b", Boolean.valueOf(z));
            this.f10346j = z;
        }
    }

    /* renamed from: a */
    protected C3124a m9664a(Context context, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j2, Map<String, String> map) {
        File file = new File(context.getFilesDir(), "bugly/bugly_trace_" + j2 + ".txt");
        C3124a c3124a = new C3124a();
        c3124a.f10332c = j2;
        c3124a.f10333d = file.getAbsolutePath();
        c3124a.f10330a = processErrorStateInfo != null ? processErrorStateInfo.processName : "";
        c3124a.f10335f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : "";
        c3124a.f10334e = processErrorStateInfo != null ? processErrorStateInfo.longMsg : "";
        c3124a.f10331b = map;
        if (map != null) {
            for (String str : map.keySet()) {
                if (str.startsWith("main(")) {
                    c3124a.f10336g = map.get(str);
                }
            }
        }
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(c3124a.f10332c);
        objArr[1] = c3124a.f10333d;
        objArr[2] = c3124a.f10330a;
        objArr[3] = c3124a.f10335f;
        objArr[4] = c3124a.f10334e;
        Map<String, String> map2 = c3124a.f10331b;
        objArr[5] = Integer.valueOf(map2 != null ? map2.size() : 0);
        C3151an.m9921c("anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        return c3124a;
    }

    /* renamed from: b */
    public void m9673b(boolean z) {
        m9661c(z);
        boolean m9676e = m9676e();
        C3116a m9635a = C3116a.m9635a();
        if (m9635a != null) {
            m9676e = m9676e && m9635a.m9644c().f10230g;
        }
        if (m9676e != m9675d()) {
            C3151an.m9915a("anr changed to %b", Boolean.valueOf(m9676e));
            m9667a(m9676e);
        }
    }

    /* renamed from: a */
    protected CrashDetailBean m9663a(C3124a c3124a) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.f10268C = C3114b.m9611i();
            crashDetailBean.f10269D = C3114b.m9607g();
            crashDetailBean.f10270E = C3114b.m9615k();
            crashDetailBean.f10271F = this.f10340d.m9583p();
            crashDetailBean.f10272G = this.f10340d.m9582o();
            crashDetailBean.f10273H = this.f10340d.m9584q();
            crashDetailBean.f10311w = C3154aq.m9954a(this.f10339c, C3127c.f10364e, C3127c.f10367h);
            crashDetailBean.f10290b = 3;
            crashDetailBean.f10293e = this.f10340d.m9575h();
            crashDetailBean.f10294f = this.f10340d.f10208p;
            crashDetailBean.f10295g = this.f10340d.m9590w();
            crashDetailBean.f10301m = this.f10340d.m9573g();
            crashDetailBean.f10302n = "ANR_EXCEPTION";
            crashDetailBean.f10303o = c3124a.f10335f;
            crashDetailBean.f10305q = c3124a.f10336g;
            crashDetailBean.f10281P = new HashMap();
            crashDetailBean.f10281P.put("BUGLY_CR_01", c3124a.f10334e);
            int indexOf = crashDetailBean.f10305q != null ? crashDetailBean.f10305q.indexOf("\n") : -1;
            crashDetailBean.f10304p = indexOf > 0 ? crashDetailBean.f10305q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.f10306r = c3124a.f10332c;
            if (crashDetailBean.f10305q != null) {
                crashDetailBean.f10309u = C3154aq.m9981b(crashDetailBean.f10305q.getBytes());
            }
            crashDetailBean.f10314z = c3124a.f10331b;
            crashDetailBean.f10266A = c3124a.f10330a;
            crashDetailBean.f10267B = "main(1)";
            crashDetailBean.f10274I = this.f10340d.m9592y();
            crashDetailBean.f10296h = this.f10340d.m9589v();
            crashDetailBean.f10297i = this.f10340d.m9544J();
            crashDetailBean.f10310v = c3124a.f10333d;
            crashDetailBean.f10278M = this.f10340d.f10213u;
            crashDetailBean.f10279N = this.f10340d.f10160a;
            crashDetailBean.f10280O = this.f10340d.m9559a();
            crashDetailBean.f10282Q = this.f10340d.m9542H();
            crashDetailBean.f10283R = this.f10340d.m9543I();
            crashDetailBean.f10284S = this.f10340d.m9536B();
            crashDetailBean.f10285T = this.f10340d.m9541G();
            this.f10344h.m9700c(crashDetailBean);
            crashDetailBean.f10313y = C3153ap.m9934a();
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    /* renamed from: a */
    protected boolean m9670a(String str, String str2, String str3) {
        Map<String, String[]> map;
        BufferedWriter bufferedWriter;
        TraceFileHelper.C3122a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo != null && (map = readTargetDumpInfo.f10329d) != null && map.size() > 0) {
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
                                String[] strArr = readTargetDumpInfo.f10329d.get("main");
                                int i2 = 3;
                                if (strArr != null && strArr.length >= 3) {
                                    String str4 = strArr[0];
                                    String str5 = strArr[1];
                                    bufferedWriter.write("\"main\" tid=" + strArr[2] + " :\n" + str4 + "\n" + str5 + "\n\n");
                                    bufferedWriter.flush();
                                }
                                for (Map.Entry<String, String[]> entry : readTargetDumpInfo.f10329d.entrySet()) {
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
                                    if (!C3151an.m9916a(e2)) {
                                        e2.printStackTrace();
                                    }
                                }
                                return true;
                            } catch (IOException e3) {
                                e = e3;
                                bufferedWriter2 = bufferedWriter;
                                if (!C3151an.m9916a(e)) {
                                    e.printStackTrace();
                                }
                                C3151an.m9923e("dump trace fail %s", e.getClass().getName() + Constants.COLON_SEPARATOR + e.getMessage());
                                if (bufferedWriter2 != null) {
                                    try {
                                        bufferedWriter2.close();
                                    } catch (IOException e4) {
                                        if (!C3151an.m9916a(e4)) {
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
                                        if (!C3151an.m9916a(e5)) {
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
                    C3151an.m9923e("backup file create fail %s", str2);
                    return false;
                }
            } catch (Exception e7) {
                if (!C3151an.m9916a(e7)) {
                    e7.printStackTrace();
                }
                C3151an.m9923e("backup file create error! %s  %s", e7.getClass().getName() + Constants.COLON_SEPARATOR + e7.getMessage(), str2);
                return false;
            }
        } else {
            C3151an.m9923e("not found trace dump for %s", str3);
            return false;
        }
    }

    /* renamed from: a */
    public boolean m9668a() {
        return this.f10337a.get() != 0;
    }

    /* renamed from: a */
    public boolean m9669a(Context context, String str, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j2, Map<String, String> map) {
        C3124a m9664a = m9664a(context, processErrorStateInfo, j2, map);
        if (!this.f10342f.m9643b()) {
            C3151an.m9923e("crash report sync remote fail, will not upload to Bugly , print local for helpful!", new Object[0]);
            C3126b.m9684a("ANR", C3154aq.m9952a(), m9664a.f10330a, "main", m9664a.f10334e, null);
            return false;
        }
        if (!this.f10342f.m9644c().f10233j) {
            C3151an.m9922d("ANR Report is closed!", new Object[0]);
            return false;
        }
        C3151an.m9915a("found visiable anr , start to upload!", new Object[0]);
        CrashDetailBean m9663a = m9663a(m9664a);
        if (m9663a == null) {
            C3151an.m9923e("pack anr fail!", new Object[0]);
            return false;
        }
        C3127c.m9705a().m9712a(m9663a);
        if (m9663a.f10289a >= 0) {
            C3151an.m9915a("backup anr record success!", new Object[0]);
        } else {
            C3151an.m9922d("backup anr record fail!", new Object[0]);
        }
        if (str != null && new File(str).exists()) {
            this.f10337a.set(3);
            if (m9670a(str, m9664a.f10333d, m9664a.f10330a)) {
                C3151an.m9915a("backup trace success", new Object[0]);
            }
        }
        C3126b.m9684a("ANR", C3154aq.m9952a(), m9664a.f10330a, "main", m9664a.f10334e, m9663a);
        if (!this.f10344h.m9694a(m9663a)) {
            this.f10344h.m9691a(m9663a, 3000L, true);
        }
        this.f10344h.m9699b(m9663a);
        return true;
    }

    /* renamed from: a */
    public final void m9666a(String str) {
        long j2;
        synchronized (this) {
            if (this.f10337a.get() != 0) {
                C3151an.m9921c("trace started return ", new Object[0]);
                return;
            }
            this.f10337a.set(1);
            try {
                C3151an.m9921c("read trace first dump for create time!", new Object[0]);
                TraceFileHelper.C3122a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                long j3 = readFirstDumpInfo != null ? readFirstDumpInfo.f10328c : -1L;
                if (j3 == -1) {
                    C3151an.m9922d("trace dump fail could not get time!", new Object[0]);
                    j3 = System.currentTimeMillis();
                }
                j2 = j3;
            } finally {
                try {
                } finally {
                }
            }
            if (Math.abs(j2 - this.f10338b) < C2084a.f6135q) {
                C3151an.m9922d("should not process ANR too Fre in %d", 10000);
            } else {
                this.f10338b = j2;
                this.f10337a.set(1);
                try {
                    Map<String, String> m9962a = C3154aq.m9962a(C3127c.f10365f, false);
                    if (m9962a != null && m9962a.size() > 0) {
                        ActivityManager.ProcessErrorStateInfo m9662a = m9662a(this.f10339c, C2084a.f6135q);
                        if (m9662a == null) {
                            C3151an.m9921c("proc state is unvisiable!", new Object[0]);
                        } else {
                            if (m9662a.pid == Process.myPid()) {
                                C3151an.m9915a("found visiable anr , start to process!", new Object[0]);
                                m9669a(this.f10339c, str, m9662a, j2, m9962a);
                                return;
                            }
                            C3151an.m9921c("not mind proc!", m9662a.processName);
                        }
                    }
                    C3151an.m9922d("can't get all thread skip this anr", new Object[0]);
                } catch (Throwable th) {
                    C3151an.m9916a(th);
                    C3151an.m9923e("get all thread stack fail!", new Object[0]);
                }
            }
        }
    }

    /* renamed from: a */
    protected synchronized void m9667a(boolean z) {
        if (z) {
            m9672b();
        } else {
            m9674c();
        }
    }

    /* renamed from: a */
    public synchronized void m9665a(StrategyBean strategyBean) {
        if (strategyBean == null) {
            return;
        }
        if (strategyBean.f10233j != m9675d()) {
            C3151an.m9922d("server anr changed to %b", Boolean.valueOf(strategyBean.f10233j));
        }
        if (Build.VERSION.SDK_INT <= 19) {
            boolean z = strategyBean.f10233j && m9676e();
            if (z != m9675d()) {
                C3151an.m9915a("anr changed to %b", Boolean.valueOf(z));
                m9667a(z);
            }
        } else if (strategyBean.f10233j) {
            m9679h();
        } else {
            m9680i();
        }
    }

    @Override // com.tencent.bugly.proguard.InterfaceC3157at
    /* renamed from: a */
    public boolean mo9671a(Thread thread) {
        new HashMap();
        if (thread.getName().contains("main")) {
            ActivityManager.ProcessErrorStateInfo m9662a = m9662a(this.f10339c, C2084a.f6135q);
            if (m9662a == null) {
                C3151an.m9921c("anr handler onThreadBlock proc state is unvisiable!", new Object[0]);
                return false;
            }
            if (m9662a.pid != Process.myPid()) {
                C3151an.m9921c("onThreadBlock not mind proc!", m9662a.processName);
                return false;
            }
            try {
                Map<String, String> m9962a = C3154aq.m9962a(200000, false);
                C3151an.m9915a("onThreadBlock found visiable anr , start to process!", new Object[0]);
                m9669a(this.f10339c, "", m9662a, System.currentTimeMillis(), m9962a);
            } catch (Throwable unused) {
                return false;
            }
        } else {
            C3151an.m9921c("anr handler onThreadBlock only care main thread", new Object[0]);
        }
        return true;
    }
}
