package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.an;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class CrashModule extends a {
    public static final int MODULE_ID = 1004;

    /* renamed from: c, reason: collision with root package name */
    private static int f8752c;

    /* renamed from: e, reason: collision with root package name */
    private static CrashModule f8753e = new CrashModule();

    /* renamed from: a, reason: collision with root package name */
    private long f8754a;

    /* renamed from: b, reason: collision with root package name */
    private BuglyStrategy.a f8755b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8756d = false;

    private synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
        if (!TextUtils.isEmpty(libBuglySOFilePath)) {
            com.tencent.bugly.crashreport.common.info.a.a(context).t = libBuglySOFilePath;
            an.a("setted libBugly.so file path :%s", libBuglySOFilePath);
        }
        if (buglyStrategy.getCrashHandleCallback() != null) {
            this.f8755b = buglyStrategy.getCrashHandleCallback();
            an.a("setted CrashHanldeCallback", new Object[0]);
        }
        if (buglyStrategy.getAppReportDelay() > 0) {
            this.f8754a = buglyStrategy.getAppReportDelay();
            an.a("setted delay: %d", Long.valueOf(this.f8754a));
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = f8753e;
        crashModule.id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.a
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.f8756d;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007a A[Catch: all -> 0x00a4, TryCatch #0 {, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0039, B:13:0x0047, B:15:0x004c, B:18:0x0053, B:20:0x0063, B:23:0x006a, B:25:0x007a, B:26:0x0081, B:31:0x0075, B:32:0x005e), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    @Override // com.tencent.bugly.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void init(android.content.Context r12, boolean r13, com.tencent.bugly.BuglyStrategy r14) {
        /*
            r11 = this;
            monitor-enter(r11)
            if (r12 == 0) goto La7
            boolean r0 = r11.f8756d     // Catch: java.lang.Throwable -> La4
            if (r0 == 0) goto L9
            goto La7
        L9:
            java.lang.String r0 = "Initializing crash module."
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> La4
            com.tencent.bugly.proguard.an.a(r0, r2)     // Catch: java.lang.Throwable -> La4
            com.tencent.bugly.proguard.ac r0 = com.tencent.bugly.proguard.ac.a()     // Catch: java.lang.Throwable -> La4
            int r2 = com.tencent.bugly.CrashModule.f8752c     // Catch: java.lang.Throwable -> La4
            r3 = 1
            int r2 = r2 + r3
            com.tencent.bugly.CrashModule.f8752c = r2     // Catch: java.lang.Throwable -> La4
            r4 = 1004(0x3ec, float:1.407E-42)
            r0.a(r4, r2)     // Catch: java.lang.Throwable -> La4
            r11.f8756d = r3     // Catch: java.lang.Throwable -> La4
            com.tencent.bugly.crashreport.CrashReport.setContext(r12)     // Catch: java.lang.Throwable -> La4
            r11.a(r12, r14)     // Catch: java.lang.Throwable -> La4
            r5 = 1004(0x3ec, float:1.407E-42)
            com.tencent.bugly.BuglyStrategy$a r8 = r11.f8755b     // Catch: java.lang.Throwable -> La4
            r9 = 0
            r10 = 0
            r6 = r12
            r7 = r13
            com.tencent.bugly.crashreport.crash.c r13 = com.tencent.bugly.crashreport.crash.c.a(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> La4
            r13.f()     // Catch: java.lang.Throwable -> La4
            if (r14 == 0) goto L47
            int r0 = r14.getCallBackType()     // Catch: java.lang.Throwable -> La4
            r13.a(r0)     // Catch: java.lang.Throwable -> La4
            boolean r0 = r14.getCloseErrorCallback()     // Catch: java.lang.Throwable -> La4
            r13.a(r0)     // Catch: java.lang.Throwable -> La4
        L47:
            r13.n()     // Catch: java.lang.Throwable -> La4
            if (r14 == 0) goto L5e
            boolean r0 = r14.isEnableNativeCrashMonitor()     // Catch: java.lang.Throwable -> La4
            if (r0 == 0) goto L53
            goto L5e
        L53:
            java.lang.String r0 = "[crash] Closed native crash monitor!"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> La4
            com.tencent.bugly.proguard.an.a(r0, r2)     // Catch: java.lang.Throwable -> La4
            r13.g()     // Catch: java.lang.Throwable -> La4
            goto L61
        L5e:
            r13.h()     // Catch: java.lang.Throwable -> La4
        L61:
            if (r14 == 0) goto L75
            boolean r0 = r14.isEnableANRCrashMonitor()     // Catch: java.lang.Throwable -> La4
            if (r0 == 0) goto L6a
            goto L75
        L6a:
            java.lang.String r0 = "[crash] Closed ANR monitor!"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> La4
            com.tencent.bugly.proguard.an.a(r0, r1)     // Catch: java.lang.Throwable -> La4
            r13.j()     // Catch: java.lang.Throwable -> La4
            goto L78
        L75:
            r13.i()     // Catch: java.lang.Throwable -> La4
        L78:
            if (r14 == 0) goto L7f
            long r0 = r14.getAppReportDelay()     // Catch: java.lang.Throwable -> La4
            goto L81
        L7f:
            r0 = 0
        L81:
            r13.a(r0)     // Catch: java.lang.Throwable -> La4
            r13.m()     // Catch: java.lang.Throwable -> La4
            com.tencent.bugly.crashreport.crash.d.a(r12)     // Catch: java.lang.Throwable -> La4
            com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver r13 = com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.getInstance()     // Catch: java.lang.Throwable -> La4
            java.lang.String r14 = "android.net.conn.CONNECTIVITY_CHANGE"
            r13.addFilter(r14)     // Catch: java.lang.Throwable -> La4
            r13.register(r12)     // Catch: java.lang.Throwable -> La4
            com.tencent.bugly.proguard.ac r12 = com.tencent.bugly.proguard.ac.a()     // Catch: java.lang.Throwable -> La4
            int r13 = com.tencent.bugly.CrashModule.f8752c     // Catch: java.lang.Throwable -> La4
            int r13 = r13 - r3
            com.tencent.bugly.CrashModule.f8752c = r13     // Catch: java.lang.Throwable -> La4
            r12.a(r4, r13)     // Catch: java.lang.Throwable -> La4
            monitor-exit(r11)
            return
        La4:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        La7:
            monitor-exit(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.CrashModule.init(android.content.Context, boolean, com.tencent.bugly.BuglyStrategy):void");
    }

    @Override // com.tencent.bugly.a
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        c a2;
        if (strategyBean == null || (a2 = c.a()) == null) {
            return;
        }
        a2.a(strategyBean);
    }
}
