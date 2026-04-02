package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;

/* JADX INFO: compiled from: BatteryUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static final String a = "BatteryUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f7612b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f7613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f7614d;

    /* JADX INFO: compiled from: BatteryUtils.java */
    private static class a {
        private static final c a = new c();

        private a() {
        }
    }

    public static c a(Context context) {
        if (f7613c == null && context != null) {
            f7613c = context.getApplicationContext();
        }
        return a.a;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f7613c.registerReceiver(this.f7614d, intentFilter);
            f7612b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f7613c, th);
        }
    }

    public synchronized void c() {
        try {
            f7613c.unregisterReceiver(this.f7614d);
            f7612b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f7613c, th);
        }
    }

    private c() {
        this.f7614d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.c.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED\uff1abattery info cc.");
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
                        b bVar = new b();
                        bVar.a = intExtra;
                        bVar.f7607b = intExtra2;
                        bVar.f7609d = i3;
                        bVar.f7608c = intExtra3;
                        bVar.f7610e = i2;
                        bVar.f7611f = System.currentTimeMillis();
                        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f7583h, com.umeng.commonsdk.internal.b.a(c.f7613c).a(), bVar);
                        c.this.c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(c.f7613c, th);
                }
            }
        };
    }

    public synchronized boolean a() {
        return f7612b;
    }
}
