package com.umeng.commonsdk.internal.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3336at;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* compiled from: UMProbe.java */
@SuppressLint({"NewApi"})
/* renamed from: com.umeng.commonsdk.internal.utils.k */
/* loaded from: classes2.dex */
public class C3485k {

    /* renamed from: b */
    public static final String f12672b = "_dsk_s";

    /* renamed from: c */
    public static final String f12673c = "_thm_z";

    /* renamed from: d */
    public static final String f12674d = "_gdf_r";

    /* renamed from: a */
    public static final String f12671a = C3336at.m10865b().m10868b(C3336at.f11505s);

    /* renamed from: e */
    private static Object f12675e = new Object();

    /* renamed from: b */
    public static void m11671b(final Context context) {
        if (m11674c(context)) {
            return;
        }
        final String[] strArr = {"unknown", "unknown", "unknown"};
        new Thread() { // from class: com.umeng.commonsdk.internal.utils.k.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    strArr[0] = C3485k.m11673c();
                    strArr[1] = C3485k.m11667a();
                    strArr[2] = C3485k.m11670b();
                    ULog.m11780i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                    C3485k.m11672b(context, strArr);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }.start();
    }

    /* renamed from: c */
    public static boolean m11674c(Context context) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f12671a, 0)) == null || TextUtils.isEmpty(sharedPreferences.getString(f12672b, ""))) ? false : true;
    }

    /* renamed from: a */
    public static String m11668a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f12671a, 0);
            if (sharedPreferences == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            synchronized (f12675e) {
                jSONObject.put(f12672b, sharedPreferences.getString(f12672b, ""));
                jSONObject.put(f12673c, sharedPreferences.getString(f12673c, ""));
                jSONObject.put(f12674d, sharedPreferences.getString(f12674d, ""));
            }
            return jSONObject.toString();
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m11672b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f12671a, 0)) == null) {
            return;
        }
        synchronized (f12675e) {
            sharedPreferences.edit().putString(f12672b, strArr[0]).putString(f12673c, strArr[1]).putString(f12674d, strArr[2]).commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m11673c() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L33
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = "/proc/diskstats"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L33
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L33
        Ld:
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L34
            java.lang.String r2 = "mtd"
            java.lang.String r3 = "sda"
            java.lang.String r4 = "mmcblk"
            if (r0 == 0) goto L30
            boolean r5 = r0.contains(r4)     // Catch: java.lang.Throwable -> L34
            if (r5 == 0) goto L21
            r2 = r4
            goto L36
        L21:
            boolean r4 = r0.contains(r3)     // Catch: java.lang.Throwable -> L34
            if (r4 == 0) goto L29
            r2 = r3
            goto L36
        L29:
            boolean r0 = r0.contains(r2)     // Catch: java.lang.Throwable -> L34
            if (r0 == 0) goto Ld
            goto L36
        L30:
            java.lang.String r2 = "unknown"
            goto L36
        L33:
            r1 = r0
        L34:
            java.lang.String r2 = "noper"
        L36:
            if (r1 == 0) goto L3b
            r1.close()     // Catch: java.lang.Throwable -> L3b
        L3b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.C3485k.m11673c():java.lang.String");
    }

    /* renamed from: b */
    public static String m11670b() {
        int i2;
        try {
            i2 = m11666a("ls /", "goldfish");
        } catch (Throwable unused) {
            i2 = -1;
        }
        return i2 > 0 ? "goldfish" : i2 < 0 ? "noper" : "unknown";
    }

    /* renamed from: a */
    public static int m11666a(String str, String str2) throws IOException {
        int i2;
        if (Build.VERSION.SDK_INT > 28) {
            return -1;
        }
        Process exec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                i2 = -1;
                break;
            }
            if (readLine.contains(str2)) {
                i2 = 1;
                break;
            }
        }
        try {
            if (exec.waitFor() != 0) {
                return -1;
            }
            return i2;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public static String m11667a() {
        int i2;
        try {
            i2 = m11666a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable unused) {
            i2 = -1;
        }
        return i2 > 0 ? "thermal_zone" : i2 < 0 ? "noper" : "unknown";
    }
}
