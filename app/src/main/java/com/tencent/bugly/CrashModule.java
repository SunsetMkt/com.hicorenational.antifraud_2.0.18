package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.crashreport.crash.f;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.an;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class CrashModule extends a {
    public static final int MODULE_ID = 1004;

    /* JADX INFO: renamed from: c */
    private static int f5990c;

    /* JADX INFO: renamed from: e */
    private static CrashModule f5991e = new CrashModule();
    private long a;

    /* JADX INFO: renamed from: b */
    private BuglyStrategy.a f5992b;

    /* JADX INFO: renamed from: d */
    private boolean f5993d = false;

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
            this.f5992b = buglyStrategy.getCrashHandleCallback();
            an.a("setted CrashHanldeCallback", new Object[0]);
        }
        if (buglyStrategy.getAppReportDelay() > 0) {
            this.a = buglyStrategy.getAppReportDelay();
            an.a("setted delay: %d", Long.valueOf(this.a));
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = f5991e;
        crashModule.id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.a
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.f5993d;
    }

    @Override // com.tencent.bugly.a
    public synchronized void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        if (context != null) {
            if (!this.f5993d) {
                an.a("Initializing crash module.", new Object[0]);
                ac acVarA = ac.a();
                int i2 = f5990c + 1;
                f5990c = i2;
                acVarA.a(1004, i2);
                this.f5993d = true;
                CrashReport.setContext(context);
                a(context, buglyStrategy);
                c cVarA = c.a(1004, context, z, this.f5992b, (f) null, (String) null);
                cVarA.f();
                if (buglyStrategy != null) {
                    cVarA.a(buglyStrategy.getCallBackType());
                    cVarA.a(buglyStrategy.getCloseErrorCallback());
                }
                cVarA.n();
                if (buglyStrategy == null || buglyStrategy.isEnableNativeCrashMonitor()) {
                    cVarA.h();
                } else {
                    an.a("[crash] Closed native crash monitor!", new Object[0]);
                    cVarA.g();
                }
                if (buglyStrategy == null || buglyStrategy.isEnableANRCrashMonitor()) {
                    cVarA.i();
                } else {
                    an.a("[crash] Closed ANR monitor!", new Object[0]);
                    cVarA.j();
                }
                cVarA.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
                cVarA.m();
                d.a(context);
                BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
                buglyBroadcastReceiver.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
                buglyBroadcastReceiver.register(context);
                ac acVarA2 = ac.a();
                int i3 = f5990c - 1;
                f5990c = i3;
                acVarA2.a(1004, i3);
            }
        }
    }

    @Override // com.tencent.bugly.a
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        c cVarA;
        if (strategyBean == null || (cVarA = c.a()) == null) {
            return;
        }
        cVarA.a(strategyBean);
    }
}
