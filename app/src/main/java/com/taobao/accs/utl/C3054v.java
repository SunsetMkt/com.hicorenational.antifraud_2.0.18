package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.common.Constants;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.v */
/* loaded from: classes2.dex */
public class C3054v {
    public static final String SP_AGOO_BIND_FILE_NAME = "AGOO_BIND";

    /* renamed from: a */
    static int f9766a = -1;

    /* renamed from: b */
    private static final byte[] f9767b = new byte[0];

    /* renamed from: c */
    private static int f9768c = -1;

    /* renamed from: a */
    public static boolean m9284a(Context context) {
        if (context == null) {
            return false;
        }
        if (f9768c == -1) {
            f9768c = context.getApplicationInfo().targetSdkVersion;
        }
        return f9768c >= 26 && Build.VERSION.SDK_INT >= 26;
    }

    /* renamed from: b */
    public static int m9286b(Context context) {
        int i2;
        int i3 = f9766a;
        if (i3 != -1) {
            return i3;
        }
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            context = null;
        }
        synchronized (f9767b) {
            try {
                i2 = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getInt(Constants.SP_KEY_DEBUG_MODE, 0);
                return i2;
            } catch (Throwable th3) {
                th = th3;
                context = null;
                try {
                    throw th;
                } catch (Throwable th4) {
                    th = th4;
                    ALog.m9181e("Utils", "getMode", th, new Object[0]);
                    i2 = context;
                    return i2;
                }
            }
        }
    }

    /* renamed from: c */
    public static void m9287c(Context context) {
        try {
            synchronized (f9767b) {
                SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.clear();
                edit.apply();
            }
        } catch (Throwable th) {
            ALog.m9181e("Utils", "clearAllSharePreferences", th, new Object[0]);
        }
    }

    /* renamed from: d */
    public static void m9288d(Context context) {
        try {
            UtilityImpl.killService(context);
        } catch (Throwable th) {
            ALog.m9181e("Utils", "killService", th, new Object[0]);
        }
    }

    /* renamed from: e */
    public static boolean m9289e(Context context) {
        boolean z;
        try {
            z = UtilityImpl.isMainProcess(context);
        } catch (Throwable th) {
            ALog.m9181e("Utils", "killservice", th, new Object[0]);
            th.printStackTrace();
            z = true;
        }
        ALog.m9183i("Utils", "isMainProcess", "result", Boolean.valueOf(z));
        return z;
    }

    /* renamed from: f */
    public static void m9290f(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("AGOO_BIND", 0).edit();
            edit.clear();
            edit.apply();
        } catch (Exception e2) {
            ALog.m9181e("Utils", "clearAgooBindCache", e2, new Object[0]);
        }
    }

    /* renamed from: a */
    public static void m9283a(Context context, int i2) {
        try {
            synchronized (f9767b) {
                f9766a = i2;
                SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.putInt(Constants.SP_KEY_DEBUG_MODE, i2);
                edit.apply();
            }
        } catch (Throwable th) {
            ALog.m9181e("Utils", "setMode", th, new Object[0]);
        }
    }

    @Deprecated
    /* renamed from: a */
    public static void m9282a() {
        try {
            AccsConfig.build();
        } catch (Throwable th) {
            ALog.m9181e("Utils", "initConfig", th, new Object[0]);
            th.printStackTrace();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:27:0x0037
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* renamed from: a */
    public static java.lang.String m9281a(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 0
            r1 = 0
            byte[] r2 = com.taobao.accs.utl.C3054v.f9767b     // Catch: java.lang.Throwable -> L3a
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = "ACCS_SDK"
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r3, r1)     // Catch: java.lang.Throwable -> L37
            java.lang.String r4 = r4.getString(r5, r0)     // Catch: java.lang.Throwable -> L37
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = "Utils"
            java.lang.String r0 = "getSpValue"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = "value"
            r2[r1] = r3     // Catch: java.lang.Throwable -> L32
            r3 = 1
            r2[r3] = r4     // Catch: java.lang.Throwable -> L32
            com.taobao.accs.utl.ALog.m9183i(r5, r0, r2)     // Catch: java.lang.Throwable -> L32
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L45
            java.lang.String r5 = "Utils"
            java.lang.String r0 = "getSpValue use default!"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L32
            com.taobao.accs.utl.ALog.m9182e(r5, r0, r2)     // Catch: java.lang.Throwable -> L32
            r4 = r6
            goto L45
        L32:
            r5 = move-exception
            goto L3c
        L34:
            r5 = move-exception
            r0 = r4
            goto L38
        L37:
            r5 = move-exception
        L38:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L37
            throw r5     // Catch: java.lang.Throwable -> L3a
        L3a:
            r5 = move-exception
            r4 = r0
        L3c:
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r0 = "Utils"
            java.lang.String r1 = "getSpValue fail"
            com.taobao.accs.utl.ALog.m9181e(r0, r1, r5, r6)
        L45:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.C3054v.m9281a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static boolean m9285a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
