package util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import bean.AppInfoBean;
import bean.AppSignBean;
import bean.AppVirusBean;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ui.Hicore;

/* compiled from: PackageUtils.java */
/* loaded from: classes2.dex */
public class r1 {

    /* renamed from: b, reason: collision with root package name */
    private static volatile r1 f20956b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Context f20957c = null;

    /* renamed from: d, reason: collision with root package name */
    public static final String f20958d = ".apk";

    /* renamed from: a, reason: collision with root package name */
    private Drawable f20959a;

    public r1(Context context) {
        f20957c = context;
    }

    public static r1 c(Context context) {
        if (f20956b == null) {
            synchronized (r1.class) {
                if (f20956b == null) {
                    return new r1(context);
                }
            }
        }
        return f20956b;
    }

    public static boolean d(String str) {
        try {
            Hicore.getApp().getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static int f() {
        try {
            PackageInfo packageInfo = Hicore.getApp().getPackageManager().getPackageInfo(Hicore.getApp().getPackageName(), 0);
            n1.b("TAG", "版本号" + packageInfo.versionCode);
            return packageInfo.versionCode;
        } catch (Exception unused) {
            return com.hicorenational.antifraud.a.f5936e;
        }
    }

    public static String g() throws Exception {
        PackageInfo packageInfo = Hicore.getApp().getPackageManager().getPackageInfo(Hicore.getApp().getPackageName(), 0);
        n1.b("TAG", "版本号" + packageInfo.versionCode);
        n1.b("TAG", "版本名" + packageInfo.versionName);
        return packageInfo.versionName;
    }

    public Drawable a(AppInfoBean appInfoBean) {
        PackageManager packageManager = f20957c.getPackageManager();
        String pkgName = appInfoBean.getPkgName();
        String activityName = appInfoBean.getActivityName();
        int flag = appInfoBean.getFlag();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClassName(pkgName, activityName);
        intent.addFlags(flag);
        try {
            return packageManager.getActivityIcon(intent);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void b(AppInfoBean appInfoBean) {
        f20957c.startActivity(f20957c.getPackageManager().getLaunchIntentForPackage(appInfoBean.getPkgName()));
    }

    public long e() {
        return d().getLastTime();
    }

    @SuppressLint({"NewApi"})
    public static boolean e(Context context) {
        boolean z;
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(100)) {
            if (runningTaskInfo.topActivity.getPackageName().equals(com.hicorenational.antifraud.a.f5933b) || runningTaskInfo.baseActivity.getPackageName().equals(com.hicorenational.antifraud.a.f5933b)) {
                z = true;
                n1.c("ActivityService isRun()", runningTaskInfo.topActivity.getPackageName() + " info.baseActivity.getPackageName()=" + runningTaskInfo.baseActivity.getPackageName());
                break;
            }
        }
        z = false;
        n1.c("ActivityService isRun()", "com.ad 程序  ...isAppRunning......" + z);
        return z;
    }

    public static AppSignBean d(String str, String str2) {
        return c(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<bean.AppInfoBean> b() {
        /*
            r21 = this;
            android.content.Context r0 = util.r1.f20957c
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            android.content.Intent r1 = new android.content.Intent
            r2 = 0
            java.lang.String r3 = "android.intent.action.MAIN"
            r1.<init>(r3, r2)
            java.lang.String r3 = "android.intent.category.LAUNCHER"
            r1.addCategory(r3)
            r3 = 0
            java.util.List r1 = r0.queryIntentActivities(r1, r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.lang.String r5 = ""
            r7 = r5
            r6 = 0
        L21:
            int r8 = r1.size()
            if (r6 >= r8) goto Lce
            java.lang.Object r8 = r1.get(r6)
            android.content.pm.ResolveInfo r8 = (android.content.pm.ResolveInfo) r8
            android.content.pm.ActivityInfo r8 = r8.activityInfo
            java.lang.String r10 = r8.packageName
            android.content.Context r8 = util.r1.f20957c     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            android.content.Context r8 = r8.getApplicationContext()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            android.content.pm.PackageManager r8 = r8.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            java.lang.Object r9 = r1.get(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            android.content.pm.ResolveInfo r9 = (android.content.pm.ResolveInfo) r9     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            android.content.pm.ActivityInfo r9 = r9.activityInfo     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            java.lang.String r9 = r9.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            android.content.pm.PackageInfo r8 = r8.getPackageInfo(r9, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            android.content.pm.ApplicationInfo r9 = r8.applicationInfo     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L65
            android.content.Context r11 = util.r1.f20957c     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L65
            android.content.Context r11 = r11.getApplicationContext()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L65
            android.content.pm.PackageManager r11 = r11.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L65
            java.lang.CharSequence r9 = r9.loadLabel(r11)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L65
            java.lang.String r9 = r9.toString()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L65
            android.content.pm.ApplicationInfo r11 = r0.getApplicationInfo(r10, r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L66
            java.lang.String r7 = r11.sourceDir     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L66
            goto L66
        L64:
            r8 = r2
        L65:
            r9 = r5
        L66:
            r12 = r9
            bean.AppInfoBean r15 = new bean.AppInfoBean
            java.lang.Object r9 = r1.get(r6)
            android.content.pm.ResolveInfo r9 = (android.content.pm.ResolveInfo) r9
            android.content.pm.ActivityInfo r9 = r9.activityInfo
            java.lang.String r11 = r9.name
            java.lang.String r13 = r8.versionName
            java.lang.Object r9 = r1.get(r6)
            android.content.pm.ResolveInfo r9 = (android.content.pm.ResolveInfo) r9
            android.content.pm.ActivityInfo r9 = r9.activityInfo
            int r14 = r9.flags
            java.lang.Object r9 = r1.get(r6)
            android.content.pm.ResolveInfo r9 = (android.content.pm.ResolveInfo) r9
            r2 = r21
            android.graphics.drawable.Drawable r16 = r2.b(r9)
            r17 = 0
            long r8 = r8.lastUpdateTime
            r19 = r8
            r9 = r15
            r8 = r15
            r15 = r16
            r16 = r17
            r17 = r19
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
            r8.setPkgPath(r7)
            android.graphics.drawable.Drawable r9 = r8.getAppIcon()
            if (r9 == 0) goto Lb4
            android.graphics.drawable.Drawable r9 = r8.getAppIcon()
            android.graphics.Bitmap r9 = j.c.a(r9)
            java.lang.String r9 = util.x0.b(r9)
            r8.setAppIconBase64(r9)
        Lb4:
            boolean r9 = android.text.TextUtils.isEmpty(r7)
            if (r9 != 0) goto Lc6
            java.io.File r9 = new java.io.File
            r9.<init>(r7)
            long r9 = r9.length()
            r8.setFileSize(r9)
        Lc6:
            r4.add(r8)
            int r6 = r6 + 1
            r2 = 0
            goto L21
        Lce:
            r2 = r21
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: util.r1.b():java.util.List");
    }

    public AppInfoBean d() {
        PackageManager packageManager = f20957c.getPackageManager();
        AppInfoBean appInfoBean = null;
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        for (int i2 = 0; i2 < queryIntentActivities.size(); i2++) {
            try {
                PackageInfo packageInfo = f20957c.getApplicationContext().getPackageManager().getPackageInfo(queryIntentActivities.get(i2).activityInfo.packageName, 0);
                String charSequence = packageInfo.applicationInfo.loadLabel(f20957c.getApplicationContext().getPackageManager()).toString();
                ResolveInfo resolveInfo = queryIntentActivities.get(queryIntentActivities.size() - 1);
                try {
                    appInfoBean = new AppInfoBean(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name, charSequence, packageInfo.versionName, resolveInfo.activityInfo.flags, this.f20959a, false, packageInfo.lastUpdateTime);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            } catch (PackageManager.NameNotFoundException unused2) {
            }
        }
        return appInfoBean;
    }

    public List<AppInfoBean> c() {
        String str;
        int i2 = 0;
        List<ResolveInfo> queryIntentActivities = f20957c.getPackageManager().queryIntentActivities(new Intent("android.intent.action.CREATE_SHORTCUT"), 0);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < queryIntentActivities.size()) {
            PackageInfo packageInfo = null;
            try {
                packageInfo = f20957c.getApplicationContext().getPackageManager().getPackageInfo(queryIntentActivities.get(i3).activityInfo.packageName, i2);
                str = packageInfo.applicationInfo.loadLabel(f20957c.getApplicationContext().getPackageManager()).toString();
            } catch (PackageManager.NameNotFoundException unused) {
                str = "";
            }
            arrayList.add(new AppInfoBean(queryIntentActivities.get(i3).activityInfo.packageName, queryIntentActivities.get(i3).activityInfo.name, str, packageInfo.versionName, queryIntentActivities.get(i3).activityInfo.flags, b(queryIntentActivities.get(i3)), false, packageInfo.lastUpdateTime));
            i3++;
            i2 = 0;
        }
        return arrayList;
    }

    public void a(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        String str = activityInfo.applicationInfo.packageName;
        String str2 = activityInfo.name;
        int i2 = activityInfo.flags;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClassName(str, str2);
        intent.addFlags(i2);
        f20957c.startActivity(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e A[Catch: Exception -> 0x009b, TRY_LEAVE, TryCatch #0 {Exception -> 0x009b, blocks: (B:3:0x0001, B:9:0x001e, B:11:0x0024, B:13:0x003e, B:23:0x0017, B:20:0x0009), top: B:2:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static bean.AppSignBean c(java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L9b
            r2 = 64
            if (r1 != 0) goto L1a
            ui.Hicore r1 = ui.Hicore.getApp()     // Catch: java.lang.Exception -> L16
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch: java.lang.Exception -> L16
            android.content.pm.PackageInfo r5 = r1.getPackageInfo(r5, r2)     // Catch: java.lang.Exception -> L16
            goto L1b
        L16:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Exception -> L9b
        L1a:
            r5 = r0
        L1b:
            r1 = 0
            if (r5 != 0) goto L3c
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> L9b
            if (r3 != 0) goto L3c
            java.lang.String r5 = ".apk"
            int r5 = r6.indexOf(r5)     // Catch: java.lang.Exception -> L9b
            int r5 = r5 + 4
            java.lang.String r6 = r6.substring(r1, r5)     // Catch: java.lang.Exception -> L9b
            ui.Hicore r5 = ui.Hicore.getApp()     // Catch: java.lang.Exception -> L9b
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.lang.Exception -> L9b
            android.content.pm.PackageInfo r5 = r5.getPackageArchiveInfo(r6, r2)     // Catch: java.lang.Exception -> L9b
        L3c:
            if (r5 == 0) goto L9f
            android.content.pm.Signature[] r2 = r5.signatures     // Catch: java.lang.Exception -> L9b
            r2 = r2[r1]     // Catch: java.lang.Exception -> L9b
            byte[] r2 = r2.toByteArray()     // Catch: java.lang.Exception -> L9b
            java.lang.String r3 = "MD5"
            java.lang.String r2 = a(r2, r3)     // Catch: java.lang.Exception -> L9b
            android.content.pm.Signature[] r3 = r5.signatures     // Catch: java.lang.Exception -> L9b
            r3 = r3[r1]     // Catch: java.lang.Exception -> L9b
            byte[] r3 = r3.toByteArray()     // Catch: java.lang.Exception -> L9b
            java.lang.String r4 = "SHA1"
            java.lang.String r3 = a(r3, r4)     // Catch: java.lang.Exception -> L9b
            android.content.pm.Signature[] r5 = r5.signatures     // Catch: java.lang.Exception -> L9b
            r5 = r5[r1]     // Catch: java.lang.Exception -> L9b
            byte[] r5 = r5.toByteArray()     // Catch: java.lang.Exception -> L9b
            java.lang.String r1 = "SHA256"
            java.lang.String r5 = a(r5, r1)     // Catch: java.lang.Exception -> L9b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9b
            r1.<init>()     // Catch: java.lang.Exception -> L9b
            java.lang.String r4 = "getSign-->"
            r1.append(r4)     // Catch: java.lang.Exception -> L9b
            r1.append(r6)     // Catch: java.lang.Exception -> L9b
            java.lang.String r6 = "\nMD5-->"
            r1.append(r6)     // Catch: java.lang.Exception -> L9b
            r1.append(r2)     // Catch: java.lang.Exception -> L9b
            java.lang.String r6 = "\nSHA1-->"
            r1.append(r6)     // Catch: java.lang.Exception -> L9b
            r1.append(r3)     // Catch: java.lang.Exception -> L9b
            java.lang.String r6 = "\nSHA256-->"
            r1.append(r6)     // Catch: java.lang.Exception -> L9b
            r1.append(r5)     // Catch: java.lang.Exception -> L9b
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Exception -> L9b
            util.n1.a(r6)     // Catch: java.lang.Exception -> L9b
            bean.AppSignBean r6 = new bean.AppSignBean     // Catch: java.lang.Exception -> L9b
            r6.<init>(r2, r3, r5)     // Catch: java.lang.Exception -> L9b
            r0 = r6
            goto L9f
        L9b:
            r5 = move-exception
            r5.printStackTrace()
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: util.r1.c(java.lang.String, java.lang.String):bean.AppSignBean");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<bean.AppInfoBean> a() {
        /*
            r21 = this;
            android.content.Context r0 = util.r1.f20957c
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            android.content.Intent r1 = new android.content.Intent
            r2 = 0
            java.lang.String r3 = "android.intent.action.MAIN"
            r1.<init>(r3, r2)
            java.lang.String r3 = "android.intent.category.LAUNCHER"
            r1.addCategory(r3)
            r3 = 0
            java.util.List r1 = r0.queryIntentActivities(r1, r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.lang.String r5 = ""
            r7 = r5
            r6 = 0
        L21:
            int r8 = r1.size()
            if (r6 >= r8) goto Ldb
            java.lang.Object r8 = r1.get(r6)
            android.content.pm.ResolveInfo r8 = (android.content.pm.ResolveInfo) r8
            android.content.pm.ActivityInfo r8 = r8.activityInfo
            java.lang.String r10 = r8.packageName
            android.content.Context r8 = util.r1.f20957c     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            android.content.Context r8 = r8.getApplicationContext()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            android.content.pm.PackageManager r8 = r8.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            java.lang.Object r9 = r1.get(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            android.content.pm.ResolveInfo r9 = (android.content.pm.ResolveInfo) r9     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            android.content.pm.ActivityInfo r9 = r9.activityInfo     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            java.lang.String r9 = r9.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            android.content.pm.PackageInfo r8 = r8.getPackageInfo(r9, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            android.content.pm.ApplicationInfo r9 = r8.applicationInfo     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L65
            android.content.Context r11 = util.r1.f20957c     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L65
            android.content.Context r11 = r11.getApplicationContext()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L65
            android.content.pm.PackageManager r11 = r11.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L65
            java.lang.CharSequence r9 = r9.loadLabel(r11)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L65
            java.lang.String r9 = r9.toString()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L65
            android.content.pm.ApplicationInfo r11 = r0.getApplicationInfo(r10, r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L66
            java.lang.String r7 = r11.sourceDir     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L66
            goto L66
        L64:
            r8 = r2
        L65:
            r9 = r5
        L66:
            r12 = r9
            bean.AppInfoBean r15 = new bean.AppInfoBean
            java.lang.Object r9 = r1.get(r6)
            android.content.pm.ResolveInfo r9 = (android.content.pm.ResolveInfo) r9
            android.content.pm.ActivityInfo r9 = r9.activityInfo
            java.lang.String r11 = r9.name
            java.lang.String r13 = r8.versionName
            java.lang.Object r9 = r1.get(r6)
            android.content.pm.ResolveInfo r9 = (android.content.pm.ResolveInfo) r9
            android.content.pm.ActivityInfo r9 = r9.activityInfo
            int r14 = r9.flags
            java.lang.Object r9 = r1.get(r6)
            android.content.pm.ResolveInfo r9 = (android.content.pm.ResolveInfo) r9
            r2 = r21
            android.graphics.drawable.Drawable r16 = r2.b(r9)
            r17 = 0
            long r8 = r8.lastUpdateTime
            r19 = r8
            r9 = r15
            r8 = r15
            r15 = r16
            r16 = r17
            r17 = r19
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
            r8.setPkgPath(r7)
            boolean r9 = android.text.TextUtils.isEmpty(r7)
            if (r9 != 0) goto Lbe
            java.io.File r9 = new java.io.File
            r9.<init>(r7)
            long r9 = r9.length()
            r8.setFileSize(r9)
            android.content.Context r9 = util.r1.f20957c
            android.net.Uri r9 = util.y1.c(r9, r7)
            java.lang.String r9 = r9.toString()
            r8.setUri(r9)
        Lbe:
            android.graphics.drawable.Drawable r9 = r8.getAppIcon()
            if (r9 == 0) goto Ld3
            android.graphics.drawable.Drawable r9 = r8.getAppIcon()
            android.graphics.Bitmap r9 = j.c.a(r9)
            java.lang.String r9 = util.x0.b(r9)
            r8.setAppIconBase64(r9)
        Ld3:
            r4.add(r8)
            int r6 = r6 + 1
            r2 = 0
            goto L21
        Ldb:
            r2 = r21
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: util.r1.a():java.util.List");
    }

    public static boolean d(Context context) {
        Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.processName.equals(context.getPackageName())) {
                if (next.importance != 100) {
                    return true;
                }
            }
        }
        return false;
    }

    private Drawable b(ResolveInfo resolveInfo) {
        return resolveInfo.activityInfo.applicationInfo.loadIcon(f20957c.getPackageManager());
    }

    public static int b(Context context, String str) {
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    public static String b(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            n1.b("", e2.getMessage());
            return "";
        }
    }

    public static ApplicationInfo c(String str) {
        String substring;
        PackageInfo packageArchiveInfo;
        if (TextUtils.isEmpty(str) || (packageArchiveInfo = Hicore.getApp().getPackageManager().getPackageArchiveInfo((substring = str.substring(0, str.indexOf(f20958d) + 4)), 1)) == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = substring;
        applicationInfo.publicSourceDir = substring;
        return applicationInfo;
    }

    public static AppInfoBean b(String str, String str2) {
        String substring = str.substring(0, str.indexOf(f20958d) + 4);
        PackageManager packageManager = Hicore.getApp().getPackageManager();
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(substring, 1);
        if (packageArchiveInfo == null) {
            return null;
        }
        AppInfoBean appInfoBean = new AppInfoBean();
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = substring;
        applicationInfo.publicSourceDir = substring;
        try {
            String charSequence = applicationInfo.loadLabel(packageManager).toString();
            String str3 = applicationInfo.packageName;
            String str4 = packageArchiveInfo.versionName == null ? "0" : packageArchiveInfo.versionName;
            Drawable loadIcon = applicationInfo.loadIcon(packageManager);
            appInfoBean.setName(charSequence);
            appInfoBean.setPkgName(str3);
            appInfoBean.setVersionName(str4);
            appInfoBean.setAppIcon(loadIcon);
            if (appInfoBean.getAppIcon() != null) {
                appInfoBean.setAppIconBase64(x0.b(j.c.a(appInfoBean.getAppIcon())));
            }
            appInfoBean.setPkgPath(substring);
            if (!TextUtils.isEmpty(substring)) {
                appInfoBean.setFileSize(new File(substring).length());
                appInfoBean.setUri(y1.c(f20957c, substring).toString());
            }
            appInfoBean.setLastTime(packageArchiveInfo.lastUpdateTime);
            return appInfoBean;
        } catch (OutOfMemoryError e2) {
            n1.b("ApkIconLoader", e2.toString());
            return null;
        }
    }

    public AppInfoBean a(String str) {
        PackageManager packageManager;
        PackageManager packageManager2 = f20957c.getPackageManager();
        AppInfoBean appInfoBean = null;
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        int i2 = 0;
        List<ResolveInfo> queryIntentActivities = packageManager2.queryIntentActivities(intent, 0);
        int i3 = 0;
        while (i3 < queryIntentActivities.size()) {
            if (TextUtils.equals(str, queryIntentActivities.get(i3).activityInfo.packageName)) {
                try {
                    PackageInfo packageInfo = f20957c.getApplicationContext().getPackageManager().getPackageInfo(queryIntentActivities.get(i3).activityInfo.packageName, i2);
                    String charSequence = packageInfo.applicationInfo.loadLabel(f20957c.getApplicationContext().getPackageManager()).toString();
                    String str2 = packageManager2.getApplicationInfo(str, i3).sourceDir;
                    packageManager = packageManager2;
                    try {
                        AppInfoBean appInfoBean2 = new AppInfoBean(str, queryIntentActivities.get(i3).activityInfo.name, charSequence, packageInfo.versionName, queryIntentActivities.get(i3).activityInfo.flags, b(queryIntentActivities.get(i3)), false, packageInfo.lastUpdateTime);
                        appInfoBean2.setPkgPath(str2);
                        if (!TextUtils.isEmpty(str2)) {
                            File file = new File(str2);
                            appInfoBean2.setFileSize(file.length());
                            appInfoBean2.setAppMD5(o1.a(file));
                        }
                        String str3 = "appName==" + charSequence + " pkgName==" + str;
                        return appInfoBean2;
                    } catch (Exception unused) {
                        continue;
                    }
                } catch (Exception unused2) {
                }
            }
            packageManager = packageManager2;
            i3++;
            packageManager2 = packageManager;
            appInfoBean = null;
            i2 = 0;
        }
        return appInfoBean;
    }

    public void a(Context context) {
        try {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                PackageInfo packageInfo = installedPackages.get(i2);
                String str = packageInfo.packageName.split(Constants.COLON_SEPARATOR)[0];
                if ((packageInfo.applicationInfo.flags & 1) == 0 && (packageInfo.applicationInfo.flags & 128) == 0 && (packageInfo.applicationInfo.flags & 2097152) == 0) {
                    n1.a("hsc", "------" + str);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static Drawable b(String str) {
        ApplicationInfo c2 = c(str);
        if (c2 != null) {
            return c2.loadIcon(Hicore.getApp().getPackageManager());
        }
        return null;
    }

    public static void a(AppVirusBean appVirusBean) {
        AppSignBean c2 = c(appVirusBean.getPkgName(), appVirusBean.getFilePath());
        if (appVirusBean == null || c2 == null) {
            return;
        }
        appVirusBean.setSignMD5(c2.getSignMD5());
        appVirusBean.setSignSha1(c2.getSignSha1());
        appVirusBean.setSignSha256(c2.getSignSha256());
    }

    private static String a(byte[] bArr, String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(bArr);
        return DataHelper.toHexString(messageDigest.digest());
    }

    public static boolean a(Context context, String str) {
        Iterator<PackageInfo> it = context.getApplicationContext().getPackageManager().getInstalledPackages(0).iterator();
        while (it.hasNext()) {
            if (it.next().packageName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static List<AppInfoBean> a(String[] strArr) {
        return a(strArr, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<bean.AppInfoBean> a(java.lang.String[] r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: util.r1.a(java.lang.String[], boolean):java.util.List");
    }

    public static AppInfoBean a(String str, String str2) {
        String substring = str.substring(0, str.indexOf(f20958d) + 4);
        PackageManager packageManager = Hicore.getApp().getPackageManager();
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(substring, 1);
        if (packageArchiveInfo == null) {
            return null;
        }
        AppInfoBean appInfoBean = new AppInfoBean();
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = substring;
        applicationInfo.publicSourceDir = substring;
        try {
            String charSequence = applicationInfo.loadLabel(packageManager).toString();
            String str3 = applicationInfo.packageName;
            String str4 = packageArchiveInfo.versionName == null ? "0" : packageArchiveInfo.versionName;
            Drawable loadIcon = applicationInfo.loadIcon(packageManager);
            appInfoBean.setName(charSequence);
            appInfoBean.setPkgName(str3);
            appInfoBean.setVersionName(str4);
            appInfoBean.setAppIcon(loadIcon);
            appInfoBean.setPkgPath(substring);
            if (!TextUtils.isEmpty(substring)) {
                appInfoBean.setFileSize(new File(substring).length());
                appInfoBean.setUri(y1.c(f20957c, substring).toString());
            }
            appInfoBean.setLastTime(packageArchiveInfo.lastUpdateTime);
            return appInfoBean;
        } catch (OutOfMemoryError e2) {
            n1.b("ApkIconLoader", e2.toString());
            return null;
        }
    }
}
