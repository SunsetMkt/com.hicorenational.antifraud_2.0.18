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
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
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

/* JADX INFO: compiled from: PackageUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class x1 {

    /* JADX INFO: renamed from: b */
    private static volatile x1 f15109b = null;

    /* JADX INFO: renamed from: c */
    private static Context f15110c = null;

    /* JADX INFO: renamed from: d */
    public static final String f15111d = ".apk";
    private Drawable a;

    public x1(Context context) {
        f15110c = context;
    }

    public static x1 c(Context context) {
        if (f15109b == null) {
            synchronized (x1.class) {
                if (f15109b == null) {
                    return new x1(context);
                }
            }
        }
        return f15109b;
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
            s1.b("TAG", "\u7248\u672c\u53f7" + packageInfo.versionCode);
            return packageInfo.versionCode;
        } catch (Exception unused) {
            return com.hicorenational.antifraud.a.f3982e;
        }
    }

    public static String g() throws Exception {
        PackageInfo packageInfo = Hicore.getApp().getPackageManager().getPackageInfo(Hicore.getApp().getPackageName(), 0);
        s1.b("TAG", "\u7248\u672c\u53f7" + packageInfo.versionCode);
        s1.b("TAG", "\u7248\u672c\u540d" + packageInfo.versionName);
        return packageInfo.versionName;
    }

    public Drawable a(AppInfoBean appInfoBean) {
        PackageManager packageManager = f15110c.getPackageManager();
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
        f15110c.startActivity(f15110c.getPackageManager().getLaunchIntentForPackage(appInfoBean.getPkgName()));
    }

    public long e() {
        return d().getLastTime();
    }

    @SuppressLint({"NewApi"})
    public static boolean e(Context context) {
        boolean z;
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(100)) {
            if (runningTaskInfo.topActivity.getPackageName().equals(com.hicorenational.antifraud.a.f3979b) || runningTaskInfo.baseActivity.getPackageName().equals(com.hicorenational.antifraud.a.f3979b)) {
                z = true;
                s1.c("ActivityService isRun()", runningTaskInfo.topActivity.getPackageName() + " info.baseActivity.getPackageName()=" + runningTaskInfo.baseActivity.getPackageName());
                break;
            }
        }
        z = false;
        s1.c("ActivityService isRun()", "com.ad \u7a0b\u5e8f\u00a0 ...isAppRunning......" + z);
        return z;
    }

    public static AppSignBean d(String str, String str2) {
        return c(str, str2);
    }

    public List<AppInfoBean> b() {
        PackageInfo packageInfo;
        String string;
        PackageManager packageManager = f15110c.getPackageManager();
        PackageInfo packageInfo2 = null;
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        String str = "";
        int i2 = 0;
        while (i2 < listQueryIntentActivities.size()) {
            String str2 = listQueryIntentActivities.get(i2).activityInfo.packageName;
            try {
                packageInfo = f15110c.getApplicationContext().getPackageManager().getPackageInfo(listQueryIntentActivities.get(i2).activityInfo.packageName, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = packageInfo2;
            }
            try {
                string = packageInfo.applicationInfo.loadLabel(f15110c.getApplicationContext().getPackageManager()).toString();
                try {
                    str = packageManager.getApplicationInfo(str2, i2).sourceDir;
                } catch (PackageManager.NameNotFoundException unused2) {
                }
            } catch (PackageManager.NameNotFoundException unused3) {
                string = "";
            }
            AppInfoBean appInfoBean = new AppInfoBean(str2, listQueryIntentActivities.get(i2).activityInfo.name, string, packageInfo.versionName, listQueryIntentActivities.get(i2).activityInfo.flags, b(listQueryIntentActivities.get(i2)), false, packageInfo.lastUpdateTime);
            appInfoBean.setPkgPath(str);
            if (appInfoBean.getAppIcon() != null) {
                appInfoBean.setAppIconBase64(b1.b(k.c.a(appInfoBean.getAppIcon())));
            }
            if (!TextUtils.isEmpty(str)) {
                appInfoBean.setFileSize(new File(str).length());
            }
            arrayList.add(appInfoBean);
            i2++;
            packageInfo2 = null;
        }
        return arrayList;
    }

    public AppInfoBean d() {
        PackageManager packageManager = f15110c.getPackageManager();
        AppInfoBean appInfoBean = null;
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        for (int i2 = 0; i2 < listQueryIntentActivities.size(); i2++) {
            try {
                PackageInfo packageInfo = f15110c.getApplicationContext().getPackageManager().getPackageInfo(listQueryIntentActivities.get(i2).activityInfo.packageName, 0);
                String string = packageInfo.applicationInfo.loadLabel(f15110c.getApplicationContext().getPackageManager()).toString();
                ResolveInfo resolveInfo = listQueryIntentActivities.get(listQueryIntentActivities.size() - 1);
                try {
                    appInfoBean = new AppInfoBean(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name, string, packageInfo.versionName, resolveInfo.activityInfo.flags, this.a, false, packageInfo.lastUpdateTime);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            } catch (PackageManager.NameNotFoundException unused2) {
            }
        }
        return appInfoBean;
    }

    public List<AppInfoBean> c() {
        String string;
        int i2 = 0;
        List<ResolveInfo> listQueryIntentActivities = f15110c.getPackageManager().queryIntentActivities(new Intent("android.intent.action.CREATE_SHORTCUT"), 0);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < listQueryIntentActivities.size()) {
            PackageInfo packageInfo = null;
            try {
                packageInfo = f15110c.getApplicationContext().getPackageManager().getPackageInfo(listQueryIntentActivities.get(i3).activityInfo.packageName, i2);
                string = packageInfo.applicationInfo.loadLabel(f15110c.getApplicationContext().getPackageManager()).toString();
            } catch (PackageManager.NameNotFoundException unused) {
                string = "";
            }
            arrayList.add(new AppInfoBean(listQueryIntentActivities.get(i3).activityInfo.packageName, listQueryIntentActivities.get(i3).activityInfo.name, string, packageInfo.versionName, listQueryIntentActivities.get(i3).activityInfo.flags, b(listQueryIntentActivities.get(i3)), false, packageInfo.lastUpdateTime));
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
        f15110c.startActivity(intent);
    }

    public static AppSignBean c(String str, String str2) {
        PackageInfo packageInfo;
        try {
            if (TextUtils.isEmpty(str)) {
                packageInfo = null;
            } else {
                try {
                    packageInfo = Hicore.getApp().getPackageManager().getPackageInfo(str, 64);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    packageInfo = null;
                }
            }
            if (packageInfo == null && !TextUtils.isEmpty(str2)) {
                str2 = str2.substring(0, str2.indexOf(f15111d) + 4);
                packageInfo = Hicore.getApp().getPackageManager().getPackageArchiveInfo(str2, 64);
            }
            if (packageInfo == null) {
                return null;
            }
            String strA = a(packageInfo.signatures[0].toByteArray(), "MD5");
            String strA2 = a(packageInfo.signatures[0].toByteArray(), "SHA1");
            String strA3 = a(packageInfo.signatures[0].toByteArray(), "SHA256");
            s1.a("getSign-->" + str2 + "\nMD5-->" + strA + "\nSHA1-->" + strA2 + "\nSHA256-->" + strA3);
            return new AppSignBean(strA, strA2, strA3);
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public List<AppInfoBean> a() {
        PackageInfo packageInfo;
        String string;
        PackageManager packageManager = f15110c.getPackageManager();
        PackageInfo packageInfo2 = null;
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        String str = "";
        int i2 = 0;
        while (i2 < listQueryIntentActivities.size()) {
            String str2 = listQueryIntentActivities.get(i2).activityInfo.packageName;
            try {
                packageInfo = f15110c.getApplicationContext().getPackageManager().getPackageInfo(listQueryIntentActivities.get(i2).activityInfo.packageName, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = packageInfo2;
            }
            try {
                string = packageInfo.applicationInfo.loadLabel(f15110c.getApplicationContext().getPackageManager()).toString();
                try {
                    str = packageManager.getApplicationInfo(str2, i2).sourceDir;
                } catch (PackageManager.NameNotFoundException unused2) {
                }
            } catch (PackageManager.NameNotFoundException unused3) {
                string = "";
            }
            AppInfoBean appInfoBean = new AppInfoBean(str2, listQueryIntentActivities.get(i2).activityInfo.name, string, packageInfo.versionName, listQueryIntentActivities.get(i2).activityInfo.flags, b(listQueryIntentActivities.get(i2)), false, packageInfo.lastUpdateTime);
            appInfoBean.setPkgPath(str);
            if (!TextUtils.isEmpty(str)) {
                appInfoBean.setFileSize(new File(str).length());
                appInfoBean.setUri(g2.c(f15110c, str).toString());
            }
            if (appInfoBean.getAppIcon() != null) {
                appInfoBean.setAppIconBase64(b1.b(k.c.a(appInfoBean.getAppIcon())));
            }
            arrayList.add(appInfoBean);
            i2++;
            packageInfo2 = null;
        }
        return arrayList;
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
        return resolveInfo.activityInfo.applicationInfo.loadIcon(f15110c.getPackageManager());
    }

    public static int b(Context context, String str) {
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    public static String b(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            s1.b("", e2.getMessage());
            return "";
        }
    }

    public static ApplicationInfo c(String str) {
        String strSubstring;
        PackageInfo packageArchiveInfo;
        if (TextUtils.isEmpty(str) || (packageArchiveInfo = Hicore.getApp().getPackageManager().getPackageArchiveInfo((strSubstring = str.substring(0, str.indexOf(f15111d) + 4)), 1)) == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = strSubstring;
        applicationInfo.publicSourceDir = strSubstring;
        return applicationInfo;
    }

    public static AppInfoBean b(String str, String str2) {
        String strSubstring = str.substring(0, str.indexOf(f15111d) + 4);
        PackageManager packageManager = Hicore.getApp().getPackageManager();
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(strSubstring, 1);
        if (packageArchiveInfo == null) {
            return null;
        }
        AppInfoBean appInfoBean = new AppInfoBean();
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = strSubstring;
        applicationInfo.publicSourceDir = strSubstring;
        try {
            String string = applicationInfo.loadLabel(packageManager).toString();
            String str3 = applicationInfo.packageName;
            String str4 = packageArchiveInfo.versionName == null ? "0" : packageArchiveInfo.versionName;
            Drawable drawableLoadIcon = applicationInfo.loadIcon(packageManager);
            appInfoBean.setName(string);
            appInfoBean.setPkgName(str3);
            appInfoBean.setVersionName(str4);
            appInfoBean.setAppIcon(drawableLoadIcon);
            if (appInfoBean.getAppIcon() != null) {
                appInfoBean.setAppIconBase64(b1.b(k.c.a(appInfoBean.getAppIcon())));
            }
            appInfoBean.setPkgPath(strSubstring);
            if (!TextUtils.isEmpty(strSubstring)) {
                appInfoBean.setFileSize(new File(strSubstring).length());
                appInfoBean.setUri(g2.c(f15110c, strSubstring).toString());
            }
            appInfoBean.setLastTime(packageArchiveInfo.lastUpdateTime);
            return appInfoBean;
        } catch (OutOfMemoryError e2) {
            s1.b("ApkIconLoader", e2.toString());
            return null;
        }
    }

    public AppInfoBean a(String str) {
        PackageManager packageManager;
        PackageManager packageManager2 = f15110c.getPackageManager();
        AppInfoBean appInfoBean = null;
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        int i2 = 0;
        List<ResolveInfo> listQueryIntentActivities = packageManager2.queryIntentActivities(intent, 0);
        int i3 = 0;
        while (i3 < listQueryIntentActivities.size()) {
            if (TextUtils.equals(str, listQueryIntentActivities.get(i3).activityInfo.packageName)) {
                try {
                    PackageInfo packageInfo = f15110c.getApplicationContext().getPackageManager().getPackageInfo(listQueryIntentActivities.get(i3).activityInfo.packageName, i2);
                    String string = packageInfo.applicationInfo.loadLabel(f15110c.getApplicationContext().getPackageManager()).toString();
                    String str2 = packageManager2.getApplicationInfo(str, i3).sourceDir;
                    packageManager = packageManager2;
                    try {
                        AppInfoBean appInfoBean2 = new AppInfoBean(str, listQueryIntentActivities.get(i3).activityInfo.name, string, packageInfo.versionName, listQueryIntentActivities.get(i3).activityInfo.flags, b(listQueryIntentActivities.get(i3)), false, packageInfo.lastUpdateTime);
                        appInfoBean2.setPkgPath(str2);
                        if (!TextUtils.isEmpty(str2)) {
                            File file = new File(str2);
                            appInfoBean2.setFileSize(file.length());
                            appInfoBean2.setAppMD5(t1.a(file));
                        }
                        String str3 = "appName==" + string + " pkgName==" + str;
                        return appInfoBean2;
                    } catch (Exception unused) {
                        continue;
                    }
                } catch (Exception unused2) {
                    packageManager = packageManager2;
                }
            } else {
                packageManager = packageManager2;
            }
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
                    s1.a("hsc", "------" + str);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static Drawable b(String str) {
        ApplicationInfo applicationInfoC = c(str);
        if (applicationInfoC != null) {
            return applicationInfoC.loadIcon(Hicore.getApp().getPackageManager());
        }
        return null;
    }

    public static void a(AppVirusBean appVirusBean) {
        AppSignBean appSignBeanC = c(appVirusBean.getPkgName(), appVirusBean.getFilePath());
        if (appVirusBean == null || appSignBeanC == null) {
            return;
        }
        appVirusBean.setSignMD5(appSignBeanC.getSignMD5());
        appVirusBean.setSignSha1(appSignBeanC.getSignSha1());
        appVirusBean.setSignSha256(appSignBeanC.getSignSha256());
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

    public static List<AppInfoBean> a(String[] strArr, boolean z) {
        Cursor cursorQuery;
        Exception e2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Uri contentUri = MediaStore.Files.getContentUri("external");
        String[] strArr2 = {"_data", "title"};
        String str = "";
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (i2 != 0) {
                str = str + " OR ";
            }
            str = str + "_data LIKE '%" + strArr[i2] + "'";
        }
        try {
            cursorQuery = Hicore.getApp().getContentResolver().query(contentUri, strArr2, str, null, "date_modified");
        } catch (Exception e3) {
            cursorQuery = null;
            e2 = e3;
        }
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (cursorQuery.moveToLast()) {
                if (z) {
                    do {
                        String string = cursorQuery.getString(0);
                        AppInfoBean appInfoBeanB = b(string, (String) null);
                        if (appInfoBeanB != null) {
                            String strSubstring = string.substring(string.lastIndexOf(File.separator, string.indexOf(f15111d)));
                            if (!TextUtils.isEmpty(strSubstring) && !arrayList2.contains(strSubstring)) {
                                arrayList2.add(strSubstring);
                                arrayList.add(appInfoBeanB);
                                s1.a("tag", string);
                            }
                        } else {
                            s1.a("tag", string);
                        }
                    } while (cursorQuery.moveToPrevious());
                } else {
                    do {
                        String string2 = cursorQuery.getString(0);
                        AppInfoBean appInfoBeanA = a(string2, (String) null);
                        if (appInfoBeanA != null) {
                            String strSubstring2 = string2.substring(string2.lastIndexOf(File.separator, string2.indexOf(f15111d)));
                            if (!TextUtils.isEmpty(strSubstring2) && !arrayList2.contains(strSubstring2)) {
                                arrayList2.add(strSubstring2);
                                arrayList.add(appInfoBeanA);
                                s1.a("tag", string2);
                            }
                        } else {
                            s1.a("tag", string2);
                        }
                    } while (cursorQuery.moveToPrevious());
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            e2.printStackTrace();
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        s1.a("tag", "\u603bapk\u4e2a\u6570-->" + arrayList.size());
        return arrayList;
    }

    public static AppInfoBean a(String str, String str2) {
        String strSubstring = str.substring(0, str.indexOf(f15111d) + 4);
        PackageManager packageManager = Hicore.getApp().getPackageManager();
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(strSubstring, 1);
        if (packageArchiveInfo == null) {
            return null;
        }
        AppInfoBean appInfoBean = new AppInfoBean();
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = strSubstring;
        applicationInfo.publicSourceDir = strSubstring;
        try {
            String string = applicationInfo.loadLabel(packageManager).toString();
            String str3 = applicationInfo.packageName;
            String str4 = packageArchiveInfo.versionName == null ? "0" : packageArchiveInfo.versionName;
            Drawable drawableLoadIcon = applicationInfo.loadIcon(packageManager);
            appInfoBean.setName(string);
            appInfoBean.setPkgName(str3);
            appInfoBean.setVersionName(str4);
            appInfoBean.setAppIcon(drawableLoadIcon);
            appInfoBean.setPkgPath(strSubstring);
            if (!TextUtils.isEmpty(strSubstring)) {
                appInfoBean.setFileSize(new File(strSubstring).length());
                appInfoBean.setUri(g2.c(f15110c, strSubstring).toString());
            }
            appInfoBean.setLastTime(packageArchiveInfo.lastUpdateTime);
            return appInfoBean;
        } catch (OutOfMemoryError e2) {
            s1.b("ApkIconLoader", e2.toString());
            return null;
        }
    }
}
