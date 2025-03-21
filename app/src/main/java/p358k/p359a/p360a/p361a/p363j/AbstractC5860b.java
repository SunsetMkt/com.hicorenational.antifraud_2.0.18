package p358k.p359a.p360a.p361a.p363j;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import cn.cloudwalk.util.LogUtils;
import java.io.File;
import java.io.IOException;

/* compiled from: ILogX.java */
/* renamed from: k.a.a.a.j.b */
/* loaded from: classes2.dex */
public abstract class AbstractC5860b {

    /* renamed from: a */
    private static String f21144a = "";

    /* renamed from: a */
    public static String m24665a() {
        return f21144a;
    }

    /* renamed from: a */
    abstract void mo24667a(String str, String str2);

    /* renamed from: b */
    abstract void mo24668b(String str, String str2);

    /* renamed from: c */
    abstract void mo24669c(String str, String str2);

    /* compiled from: ILogX.java */
    /* renamed from: k.a.a.a.j.b$a */
    static class a {
        /* renamed from: a */
        private static boolean m24672a() {
            return "mounted".equals(Environment.getExternalStorageState()) || !m24674b();
        }

        /* renamed from: b */
        static String m24673b(Context context) {
            String str = m24675c(context) + "/Log/";
            File file = new File(str);
            if (file.exists() || file.mkdirs()) {
                return str;
            }
            return null;
        }

        /* renamed from: c */
        private static String m24675c(Context context) {
            try {
                return context.getFilesDir().getCanonicalPath();
            } catch (IOException unused) {
                C5863e.m24692b("ILogX", "getCanonicalPath is IOException", true);
                return null;
            }
        }

        /* renamed from: d */
        static String m24676d(Context context) {
            String str = m24677e(context) + "/Log/";
            File file = new File(str);
            if (file.exists() || file.mkdirs()) {
                return str;
            }
            return null;
        }

        /* renamed from: e */
        private static String m24677e(Context context) {
            File externalFilesDir;
            if (m24672a() && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
                try {
                    return externalFilesDir.getCanonicalPath();
                } catch (IOException unused) {
                    C5863e.m24692b("ILogX", LogUtils.LOG_EXCEPTION, true);
                }
            }
            return null;
        }

        /* renamed from: a */
        public static void m24670a(Context context) {
            String m24676d = m24676d(context);
            if (TextUtils.isEmpty(m24676d)) {
                return;
            }
            C5863e.m24692b("ILogX", "deleteOldLogFiles File", true);
            File file = new File(m24676d);
            if (file.exists() && file.isDirectory()) {
                m24671a(file);
            }
        }

        @TargetApi(9)
        /* renamed from: b */
        private static boolean m24674b() {
            if (Build.VERSION.SDK_INT >= 9) {
                return Environment.isExternalStorageRemovable();
            }
            return true;
        }

        /* renamed from: a */
        private static void m24671a(File file) {
            if (file == null) {
                C5863e.m24692b("ILogX", "deleteDirInnerPicFileDir == null", true);
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                if (file2.getName().contains("apphnid.txt") || file2.getName().contains("apphnid.txt.bak") || file2.getName().contains("honorid_advanced_log.txt")) {
                    file2.delete();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005b A[ORIG_RETURN, RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String m24666a(android.content.Context r2) {
        /*
            if (r2 == 0) goto L53
            k.a.a.a.e r0 = p358k.p359a.p360a.p361a.C5851e.m24637a(r2)
            java.lang.String r0 = r0.m24638a()
            java.lang.String r1 = r2.getPackageName()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L53
            android.content.pm.PackageManager r0 = r2.getPackageManager()
            java.lang.String r2 = r2.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a
            r1 = 0
            android.content.pm.PackageInfo r2 = r0.getPackageInfo(r2, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a
            r0.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a
            java.lang.String r1 = "HONORID_APK_log["
            r0.append(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a
            java.lang.String r2 = r2.versionName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a
            r0.append(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a
            java.lang.String r2 = "]:"
            r0.append(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a
            java.lang.String r2 = r0.toString()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L3a
            goto L55
        L3a:
            r2 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getVersionTag error"
            r0.append(r1)
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r0.append(r2)
            r0.toString()
        L53:
            java.lang.String r2 = ""
        L55:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L5d
            java.lang.String r2 = "HonorID_openSDK_log[6.0.3.004]"
        L5d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p358k.p359a.p360a.p361a.p363j.AbstractC5860b.m24666a(android.content.Context):java.lang.String");
    }
}
