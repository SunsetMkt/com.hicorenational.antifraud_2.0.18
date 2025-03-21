package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.C3470a;
import com.umeng.commonsdk.internal.C3471b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;

/* compiled from: BatteryUtils.java */
/* renamed from: com.umeng.commonsdk.internal.utils.c */
/* loaded from: classes2.dex */
public class C3477c {

    /* renamed from: a */
    private static final String f12645a = "BatteryUtils";

    /* renamed from: b */
    private static boolean f12646b = false;

    /* renamed from: c */
    private static Context f12647c;

    /* renamed from: d */
    private BroadcastReceiver f12648d;

    /* compiled from: BatteryUtils.java */
    /* renamed from: com.umeng.commonsdk.internal.utils.c$a */
    private static class a {

        /* renamed from: a */
        private static final C3477c f12650a = new C3477c();

        private a() {
        }
    }

    /* renamed from: a */
    public static C3477c m11646a(Context context) {
        if (f12647c == null && context != null) {
            f12647c = context.getApplicationContext();
        }
        return a.f12650a;
    }

    /* renamed from: b */
    public synchronized void m11649b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f12647c.registerReceiver(this.f12648d, intentFilter);
            f12646b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f12647c, th);
        }
    }

    /* renamed from: c */
    public synchronized void m11650c() {
        try {
            f12647c.unregisterReceiver(this.f12648d);
            f12646b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f12647c, th);
        }
    }

    private C3477c() {
        this.f12648d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.c.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED：battery info cc.");
                        int i2 = 0;
                        int intExtra = intent.getIntExtra("level", 0);
                        int intExtra2 = intent.getIntExtra("voltage", 0);
                        int intExtra3 = intent.getIntExtra("temperature", 0);
                        int intExtra4 = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, 0);
                        int i3 = -1;
                        if (intExtra4 != 1) {
                            if (intExtra4 == 2) {
                                i3 = 1;
                            } else if (intExtra4 != 3) {
                                if (intExtra4 == 4) {
                                    i3 = 0;
                                } else if (intExtra4 == 5) {
                                    i3 = 2;
                                }
                            }
                        }
                        int intExtra5 = intent.getIntExtra("plugged", 0);
                        if (intExtra5 == 1) {
                            i2 = 1;
                        } else if (intExtra5 == 2) {
                            i2 = 2;
                        }
                        C3476b c3476b = new C3476b();
                        c3476b.f12639a = intExtra;
                        c3476b.f12640b = intExtra2;
                        c3476b.f12642d = i3;
                        c3476b.f12641c = intExtra3;
                        c3476b.f12643e = i2;
                        c3476b.f12644f = System.currentTimeMillis();
                        UMWorkDispatch.sendEvent(context, C3470a.f12594h, C3471b.m11589a(C3477c.f12647c).m11590a(), c3476b);
                        C3477c.this.m11650c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(C3477c.f12647c, th);
                }
            }
        };
    }

    /* renamed from: a */
    public synchronized boolean m11648a() {
        return f12646b;
    }
}
