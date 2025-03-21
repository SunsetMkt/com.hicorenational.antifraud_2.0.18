package com.tencent.open.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import cn.cloudwalk.util.LogUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.p212b.C3260b;
import com.tencent.p203a.p204a.C3069a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.k */
/* loaded from: classes2.dex */
public class C3293k {

    /* renamed from: a */
    private static ConcurrentHashMap<String, C3069a> f11318a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static String m10630a(int i2) {
        if (i2 == 10103) {
            return "shareToQQ";
        }
        if (i2 == 10104) {
            return "shareToQzone";
        }
        if (i2 == 10105) {
            return "addToQQFavorites";
        }
        if (i2 == 10106) {
            return "sendToMyComputer";
        }
        if (i2 == 10107) {
            return "shareToTroopBar";
        }
        if (i2 == 11101) {
            return "action_login";
        }
        if (i2 == 10100) {
            return "action_request";
        }
        if (i2 != 10114) {
            return null;
        }
        return "action_common_channel";
    }

    /* renamed from: a */
    public static void m10635a() {
        f11318a.clear();
    }

    /* renamed from: b */
    public static String m10641b(Context context, String str) {
        String str2 = "";
        SLog.m10506v("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(signatureArr[0].toByteArray());
            String m10674a = C3295m.m10674a(messageDigest.digest());
            messageDigest.reset();
            SLog.m10506v("openSDK_LOG.SystemUtils", "-->sign: " + m10674a);
            messageDigest.update(C3295m.m10711j(packageName + AbstractC1191a.f2606s1 + m10674a + AbstractC1191a.f2606s1 + str + ""));
            str2 = C3295m.m10674a(messageDigest.digest());
            messageDigest.reset();
            StringBuilder sb = new StringBuilder();
            sb.append("-->signEncryped: ");
            sb.append(str2);
            SLog.m10506v("openSDK_LOG.SystemUtils", sb.toString());
            return str2;
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e2);
            return str2;
        }
    }

    /* renamed from: c */
    public static int m10645c(Context context, String str) {
        return m10628a(m10634a(context, "com.tencent.mobileqq"), str);
    }

    /* renamed from: d */
    public static int m10648d(Context context, String str) {
        return m10628a(m10634a(context, Constants.PACKAGE_TIM), str);
    }

    /* renamed from: e */
    private static PackageInfo m10650e(Context context, String str) {
        if (context == null || str == null) {
            return null;
        }
        synchronized (C3293k.class) {
            if (!f11318a.containsKey(str)) {
                PackageInfo m10651f = m10651f(context, str);
                f11318a.put(str, new C3069a(str, m10651f));
                return m10651f;
            }
            C3069a c3069a = f11318a.get(str);
            if (c3069a == null) {
                SLog.m10500e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper is null");
                return null;
            }
            PackageInfo packageInfo = c3069a.f9807b;
            if (packageInfo == null) {
                SLog.m10500e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper packageInfo is null");
            }
            return packageInfo;
        }
    }

    /* renamed from: f */
    private static PackageInfo m10651f(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                SLog.m10500e("openSDK_LOG.SystemUtils", "realGetPackageInfo null. packageName= " + str);
            }
            return packageInfo;
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.SystemUtils", "realGetPackageInfo exception", e2);
            return null;
        }
    }

    /* renamed from: g */
    private static boolean m10652g(Context context, String str) {
        return (C3290h.m10610a(context, m10646c(), str) == null && m10650e(context, str) == null) ? false : true;
    }

    /* renamed from: a */
    public static void m10636a(String str) {
        if (str == null) {
            return;
        }
        f11318a.remove(str);
    }

    /* renamed from: a */
    public static String m10634a(Context context, String str) {
        String m10610a = C3290h.m10610a(context, m10646c(), str);
        if (m10610a != null && !"UNKNOWN".equals(m10610a)) {
            return m10610a;
        }
        PackageInfo m10650e = m10650e(context, str);
        if (m10650e == null) {
            SLog.m10500e("openSDK_LOG.SystemUtils", "getAppVersionName return null. package= " + str);
            return null;
        }
        return m10650e.versionName;
    }

    /* renamed from: c */
    public static boolean m10647c(Context context) {
        if (m10652g(context, "com.tencent.mobileqq")) {
            SLog.m10502i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: qq");
            return true;
        }
        if (m10652g(context, Constants.PACKAGE_TIM)) {
            SLog.m10502i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: tim");
            return true;
        }
        if (m10652g(context, Constants.PACKAGE_QQ_PAD)) {
            SLog.m10502i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: pad");
            return true;
        }
        SLog.m10502i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: disable speed");
        return false;
    }

    /* renamed from: d */
    public static boolean m10649d(Context context) {
        return context != null && context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29 && !m10642b();
    }

    /* renamed from: a */
    public static int m10628a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i2 = 0;
        while (i2 < split.length && i2 < split2.length) {
            try {
                int parseInt = Integer.parseInt(split[i2]);
                int parseInt2 = Integer.parseInt(split2[i2]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i2++;
            } catch (NumberFormatException unused) {
                return str.compareTo(str2);
            }
        }
        if (split.length > i2) {
            return 1;
        }
        return split2.length > i2 ? -1 : 0;
    }

    /* renamed from: c */
    private static String m10646c() {
        String m10444b = C3260b.m10444b();
        if (m10444b == null || m10444b.isEmpty()) {
            SLog.m10500e("openSDK_LOG.SystemUtils", "getAppId error: " + m10444b);
        }
        return m10444b;
    }

    /* renamed from: a */
    public static boolean m10638a(Context context, String str, String str2) {
        SLog.m10506v("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (C3295m.m10704g(signature.toCharsString()).equals(str2)) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m10644b(Context context, Intent intent) {
        boolean z = false;
        if (context != null && intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                SLog.m10502i("openSDK_LOG.SystemUtils", "isAgentActivityExist? component null");
                return false;
            }
            String packageName = component.getPackageName();
            String m10634a = m10634a(context, packageName);
            if (m10634a != null && !m10634a.isEmpty()) {
                z = true;
            }
            SLog.m10502i("openSDK_LOG.SystemUtils", "isAgentActivityExist? packageName = " + packageName + ", appVersionName= " + m10634a);
        }
        return z;
    }

    /* renamed from: a */
    public static String m10632a(Activity activity, String str) {
        if (activity == null) {
            SLog.m10500e("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
            return "";
        }
        try {
            byte[] m10595a = C3287e.m10595a(str);
            if (m10595a == null) {
                SLog.m10500e("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");
                return "";
            }
            byte[] bArr = new byte[8];
            System.arraycopy(m10595a, 5, bArr, 0, 8);
            byte[] bArr2 = new byte[16];
            System.arraycopy(m10595a, 8, bArr2, 0, 16);
            return C3287e.m10593a(activity.getPackageName(), C3287e.m10594a(bArr2), bArr);
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.SystemUtils", "getEncryptPkgName", e2);
            return "";
        }
    }

    /* renamed from: b */
    public static int m10640b(String str) {
        if ("shareToQQ".equals(str)) {
            return 10103;
        }
        if ("shareToQzone".equals(str)) {
            return 10104;
        }
        if ("addToQQFavorites".equals(str)) {
            return Constants.REQUEST_QQ_FAVORITES;
        }
        if ("sendToMyComputer".equals(str)) {
            return Constants.REQUEST_SEND_TO_MY_COMPUTER;
        }
        if ("shareToTroopBar".equals(str)) {
            return Constants.REQUEST_SHARE_TO_TROOP_BAR;
        }
        if ("action_login".equals(str)) {
            return 11101;
        }
        if ("action_request".equals(str)) {
            return Constants.REQUEST_API;
        }
        return -1;
    }

    /* renamed from: a */
    public static boolean m10637a(Context context, Intent intent) {
        if (context != null && intent != null) {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            boolean z = queryIntentActivities != null && queryIntentActivities.size() > 0;
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append("isActivityExist false. result=");
                sb.append(queryIntentActivities == null ? AbstractC1191a.f2571h : Integer.valueOf(queryIntentActivities.size()));
                sb.append(" Intent= ");
                sb.append(intent);
                SLog.m10500e("openSDK_LOG.SystemUtils", sb.toString());
            }
            return z;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isActivityExist params error! [");
        sb2.append(context == null);
        sb2.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append(intent == null);
        sb2.append("]");
        SLog.m10500e("openSDK_LOG.SystemUtils", sb2.toString());
        return false;
    }

    /* renamed from: b */
    public static boolean m10643b(Context context) {
        boolean m10652g = m10652g(context, "com.tencent.mobileqq");
        SLog.m10502i("openSDK_LOG.SystemUtils", "isQQInstalled " + m10652g);
        return m10652g;
    }

    /* renamed from: b */
    private static boolean m10642b() {
        try {
            return ((Boolean) Environment.class.getMethod("isExternalStorageLegacy", new Class[0]).invoke(Environment.class, new Object[0])).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static String m10633a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
            SLog.m10501e("openSDK_LOG.SystemUtils", "getAppName exception", th);
            try {
                int i2 = applicationInfo.labelRes;
                return i2 <= 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i2);
            } catch (Throwable th2) {
                SLog.m10501e("openSDK_LOG.SystemUtils", "getAppName getLabel exception", th2);
                return "";
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.SuppressLint({"SdCardPath"})
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m10639a(java.lang.String r10, java.lang.String r11, int r12) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "-->extractSecureLib, libName: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "openSDK_LOG.SystemUtils"
            com.tencent.open.log.SLog.m10502i(r1, r0)
            android.content.Context r0 = com.tencent.open.utils.C3289g.m10603a()
            r2 = 0
            if (r0 != 0) goto L23
            java.lang.String r10 = "-->extractSecureLib, global context is null. "
            com.tencent.open.log.SLog.m10502i(r1, r10)
            return r2
        L23:
            java.lang.String r3 = "secure_lib"
            android.content.SharedPreferences r3 = r0.getSharedPreferences(r3, r2)
            java.io.File r4 = new java.io.File
            java.io.File r5 = r0.getFilesDir()
            r4.<init>(r5, r11)
            boolean r5 = r4.exists()
            r6 = 1
            java.lang.String r7 = "version"
            if (r5 != 0) goto L50
            java.io.File r5 = r4.getParentFile()
            if (r5 == 0) goto L73
            boolean r5 = r5.mkdirs()
            if (r5 == 0) goto L73
            r4.createNewFile()     // Catch: java.io.IOException -> L4b
            goto L73
        L4b:
            r4 = move-exception
            r4.printStackTrace()
            goto L73
        L50:
            int r4 = r3.getInt(r7, r2)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "-->extractSecureLib, libVersion: "
            r5.append(r8)
            r5.append(r12)
            java.lang.String r8 = " | oldVersion: "
            r5.append(r8)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            com.tencent.open.log.SLog.m10502i(r1, r5)
            if (r12 != r4) goto L73
            return r6
        L73:
            r4 = 0
            android.content.res.AssetManager r5 = r0.getAssets()     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            java.io.InputStream r10 = r5.open(r10)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            java.io.FileOutputStream r4 = r0.openFileOutput(r11, r2)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            m10629a(r10, r4)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            android.content.SharedPreferences$Editor r11 = r3.edit()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r11.putInt(r7, r12)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r11.commit()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            if (r10 == 0) goto L94
            r10.close()     // Catch: java.io.IOException -> L93
            goto L94
        L93:
        L94:
            if (r4 == 0) goto L99
            r4.close()     // Catch: java.io.IOException -> L99
        L99:
            return r6
        L9a:
            r11 = move-exception
            goto Lbc
        L9c:
            r11 = move-exception
            r9 = r4
            r4 = r10
            r10 = r9
            goto La6
        La1:
            r11 = move-exception
            r10 = r4
            goto Lbc
        La4:
            r11 = move-exception
            r10 = r4
        La6:
            java.lang.String r12 = "-->extractSecureLib, when copy lib execption."
            com.tencent.open.log.SLog.m10501e(r1, r12, r11)     // Catch: java.lang.Throwable -> Lb8
            if (r4 == 0) goto Lb2
            r4.close()     // Catch: java.io.IOException -> Lb1
            goto Lb2
        Lb1:
        Lb2:
            if (r10 == 0) goto Lb7
            r10.close()     // Catch: java.io.IOException -> Lb7
        Lb7:
            return r2
        Lb8:
            r11 = move-exception
            r9 = r4
            r4 = r10
            r10 = r9
        Lbc:
            if (r10 == 0) goto Lc3
            r10.close()     // Catch: java.io.IOException -> Lc2
            goto Lc3
        Lc2:
        Lc3:
            if (r4 == 0) goto Lc8
            r4.close()     // Catch: java.io.IOException -> Lc8
        Lc8:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.C3293k.m10639a(java.lang.String, java.lang.String, int):boolean");
    }

    /* renamed from: a */
    private static long m10629a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j2 += read;
            } else {
                SLog.m10502i("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + j2);
                return j2;
            }
        }
    }

    /* renamed from: a */
    public static String m10631a(Activity activity) {
        try {
            ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getApplicationContext().getPackageName(), 128);
            SLog.m10502i("openSDK_LOG.SystemUtils", "apkPath=" + applicationInfo.sourceDir);
            return applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e2) {
            SLog.m10501e("openSDK_LOG.SystemUtils", "NameNotFoundException", e2);
            return null;
        } catch (Exception e3) {
            SLog.m10501e("openSDK_LOG.SystemUtils", LogUtils.LOG_EXCEPTION, e3);
            return null;
        }
    }
}
