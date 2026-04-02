package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;

/* JADX INFO: compiled from: OpenDeviceId.java */
/* JADX INFO: loaded from: classes2.dex */
public class av {
    private static au a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f7029b = false;

    public static synchronized String a(Context context) {
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** real call OpenDeviceId.getOaid()");
        if (context == null) {
            throw new RuntimeException("Context is null");
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        b(context);
        if (a != null) {
            try {
                return a.a(context);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static void b(Context context) {
        if (a != null || f7029b) {
            return;
        }
        synchronized (av.class) {
            if (a == null && !f7029b) {
                a = ax.a(context);
                f7029b = true;
            }
        }
    }
}
