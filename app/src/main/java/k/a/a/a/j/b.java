package k.a.a.a.j;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import cn.cloudwalk.util.LogUtils;
import java.io.File;
import java.io.IOException;

/* compiled from: ILogX.java */
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f17035a = "";

    public static String a() {
        return f17035a;
    }

    abstract void a(String str, String str2);

    abstract void b(String str, String str2);

    abstract void c(String str, String str2);

    /* compiled from: ILogX.java */
    static class a {
        private static boolean a() {
            return "mounted".equals(Environment.getExternalStorageState()) || !b();
        }

        static String b(Context context) {
            String str = c(context) + "/Log/";
            File file = new File(str);
            if (file.exists() || file.mkdirs()) {
                return str;
            }
            return null;
        }

        private static String c(Context context) {
            try {
                return context.getFilesDir().getCanonicalPath();
            } catch (IOException unused) {
                e.b("ILogX", "getCanonicalPath is IOException", true);
                return null;
            }
        }

        static String d(Context context) {
            String str = e(context) + "/Log/";
            File file = new File(str);
            if (file.exists() || file.mkdirs()) {
                return str;
            }
            return null;
        }

        private static String e(Context context) {
            File externalFilesDir;
            if (a() && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
                try {
                    return externalFilesDir.getCanonicalPath();
                } catch (IOException unused) {
                    e.b("ILogX", LogUtils.LOG_EXCEPTION, true);
                }
            }
            return null;
        }

        public static void a(Context context) {
            String d2 = d(context);
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            e.b("ILogX", "deleteOldLogFiles File", true);
            File file = new File(d2);
            if (file.exists() && file.isDirectory()) {
                a(file);
            }
        }

        @TargetApi(9)
        private static boolean b() {
            if (Build.VERSION.SDK_INT >= 9) {
                return Environment.isExternalStorageRemovable();
            }
            return true;
        }

        private static void a(File file) {
            if (file == null) {
                e.b("ILogX", "deleteDirInnerPicFileDir == null", true);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String a(android.content.Context r2) {
        /*
            if (r2 == 0) goto L53
            k.a.a.a.e r0 = k.a.a.a.e.a(r2)
            java.lang.String r0 = r0.a()
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
        throw new UnsupportedOperationException("Method not decompiled: k.a.a.a.j.b.a(android.content.Context):java.lang.String");
    }
}
