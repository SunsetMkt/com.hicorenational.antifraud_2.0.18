package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;

/* compiled from: OpenDeviceId.java */
/* renamed from: com.umeng.analytics.pro.av */
/* loaded from: classes2.dex */
public class C3338av {

    /* renamed from: a */
    private static InterfaceC3337au f11514a = null;

    /* renamed from: b */
    private static boolean f11515b = false;

    /* renamed from: a */
    public static synchronized String m10871a(Context context) {
        synchronized (C3338av.class) {
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>>*** real call OpenDeviceId.getOaid()");
            if (context == null) {
                throw new RuntimeException("Context is null");
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            m10872b(context);
            if (f11514a != null) {
                try {
                    return f11514a.mo10870a(context);
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    /* renamed from: b */
    private static void m10872b(Context context) {
        if (f11514a != null || f11515b) {
            return;
        }
        synchronized (C3338av.class) {
            if (f11514a == null && !f11515b) {
                f11514a = C3340ax.m10881a(context);
                f11515b = true;
            }
        }
    }
}
