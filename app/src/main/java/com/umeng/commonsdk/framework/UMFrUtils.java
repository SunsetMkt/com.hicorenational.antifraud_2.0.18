package com.umeng.commonsdk.framework;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3336at;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.C3513a;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class UMFrUtils {
    private static final String KEY_LAST_INSTANT_SUCC_BUILD_TIME = "last_instant_build_time";
    private static final String KEY_LAST_SUCC_BUILD_TIME = "last_successful_build_time";
    private static Object mEnvelopeBuildTimeLock = new Object();
    private static String mDefaultEnvelopeDir = C3336at.m10865b().m10868b(C3336at.f11487a);
    private static String mDefaultEnvelopeDirPath = null;
    private static Object mEnvelopeFileLock = new Object();
    private static String sCurrentProcessName = "";

    private static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(applicationContext, th);
                return false;
            }
        } else {
            try {
                if (applicationContext.getPackageManager().checkPermission(str, applicationContext.getPackageName()) != 0) {
                    return false;
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(applicationContext, th2);
                return false;
            }
        }
        return true;
    }

    public static int envelopeFileNumber(Context context) {
        String[] list;
        if (context != null) {
            try {
                File file = new File(getEnvelopeDirPath(context));
                synchronized (mEnvelopeFileLock) {
                    if (file.isDirectory() && (list = file.list()) != null) {
                        return list.length;
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
        return 0;
    }

    public static String getCurrentProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (TextUtils.isEmpty(sCurrentProcessName)) {
            try {
                String processName = Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
                if (TextUtils.isEmpty(processName)) {
                    int myPid = Process.myPid();
                    String processName2 = getProcessName(myPid);
                    if (TextUtils.isEmpty(processName2)) {
                        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() > 0) {
                            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ActivityManager.RunningAppProcessInfo next = it.next();
                                if (next.pid == myPid) {
                                    sCurrentProcessName = next.processName;
                                    break;
                                }
                            }
                        }
                    } else {
                        sCurrentProcessName = processName2;
                    }
                } else {
                    sCurrentProcessName = processName;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context.getApplicationContext(), th);
            }
        }
        return sCurrentProcessName;
    }

    private static long getDistanceDays(long j2, long j3) {
        return (j2 < j3 ? j3 - j2 : j2 - j3) / 86400000;
    }

    public static String getEnvelopeDirPath(Context context) {
        synchronized (mEnvelopeFileLock) {
            try {
                if (mDefaultEnvelopeDirPath == null) {
                    mDefaultEnvelopeDirPath = context.getFilesDir().getAbsolutePath() + File.separator + "." + mDefaultEnvelopeDir;
                }
                File file = new File(mDefaultEnvelopeDirPath);
                if (!file.exists() && !file.mkdir()) {
                    ULog.m11768d("--->>> Create Envelope Directory failed!!!");
                }
            } finally {
                return mDefaultEnvelopeDirPath;
            }
        }
        return mDefaultEnvelopeDirPath;
    }

    public static File getEnvelopeFile(Context context) {
        if (context == null) {
            return null;
        }
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.2
                    @Override // java.util.Comparator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long lastModified = file2.lastModified() - file3.lastModified();
                        if (lastModified > 0) {
                            return 1;
                        }
                        return lastModified == 0 ? 0 : -1;
                    }
                });
                return listFiles[0];
            }
            return null;
        }
    }

    public static long getLastInstantBuildTime(Context context) {
        long j2;
        synchronized (mEnvelopeBuildTimeLock) {
            j2 = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, 0L);
        }
        return j2;
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        long j2;
        synchronized (mEnvelopeBuildTimeLock) {
            j2 = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_SUCC_BUILD_TIME, 0L);
        }
        return j2;
    }

    public static String getLegacyEnvelopeDir(Context context) {
        try {
            String currentProcessName = getCurrentProcessName(context);
            if (!TextUtils.isEmpty(currentProcessName)) {
                String m10868b = C3336at.m10865b().m10868b(C3336at.f11483B);
                String replace = currentProcessName.replace(':', '_');
                ULog.m11768d("--->>> getEnvelopeDir: use current process name as envelope directory.");
                return m10868b + replace;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        return mDefaultEnvelopeDir;
    }

    private static String getProcessName(int i2) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i2 + "/cmdline"));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader.close();
                } catch (Throwable unused) {
                }
                return readLine;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    public static String getSubProcessName(Context context) {
        String str;
        str = "";
        try {
            String currentProcessName = getCurrentProcessName(context);
            int indexOf = currentProcessName.indexOf(Constants.COLON_SEPARATOR);
            str = indexOf >= 0 ? currentProcessName.substring(indexOf + 1) : "";
            if (indexOf < 0) {
                String packageName = context.getPackageName();
                if (currentProcessName.length() > packageName.length()) {
                    currentProcessName = currentProcessName.substring(packageName.length() + 1, currentProcessName.length());
                }
            } else {
                currentProcessName = str;
            }
            return currentProcessName;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
            return str;
        }
    }

    public static boolean hasEnvelopeFile(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        File[] listFiles;
        String str = uMBusinessType == UMLogDataProtocol.UMBusinessType.U_INTERNAL ? C3351bh.f11581aF : "a";
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_ZeroEnv) {
            str = C3351bh.f11582aG;
        }
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_Silent) {
            str = C3351bh.f11585aJ;
        }
        String envelopeDirPath = getEnvelopeDirPath(context);
        if (envelopeDirPath == null) {
            return false;
        }
        File file = new File(envelopeDirPath);
        synchronized (mEnvelopeFileLock) {
            try {
                listFiles = file.listFiles();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    if (file2.getName().startsWith(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
            return false;
        }
    }

    public static boolean removeEnvelopeFile(File file) {
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        return file.delete();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(appContext, th);
                }
            }
            return true;
        }
    }

    public static void removeRedundantEnvelopeFiles(Context context, int i2) {
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > i2) {
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.1
                    @Override // java.util.Comparator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long lastModified = file2.lastModified() - file3.lastModified();
                        if (lastModified > 0) {
                            return 1;
                        }
                        return lastModified == 0 ? 0 : -1;
                    }
                });
                if (listFiles.length > i2) {
                    for (int i3 = 0; i3 < listFiles.length - i2; i3++) {
                        try {
                            if (!listFiles[i3].delete()) {
                                ULog.m11768d("--->>> remove [" + i3 + "] file fail.");
                            }
                        } catch (Throwable th) {
                            UMCrashManager.reportCrash(context, th);
                        }
                    }
                }
            }
        }
    }

    public static int saveEnvelopeFile(Context context, String str, byte[] bArr) {
        if (bArr == null) {
            return 101;
        }
        File file = new File(getEnvelopeDirPath(context) + File.separator + str);
        synchronized (mEnvelopeFileLock) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.close();
                        boolean m11881a = C3513a.m11877a(context).m11881a(str);
                        boolean m11883b = C3513a.m11877a(context).m11883b(str);
                        if (m11881a) {
                            updateLastSuccessfulBuildTime(context);
                        }
                        if (m11883b) {
                            updateLastInstantBuildTime(context);
                        }
                        return 0;
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        UMCrashManager.reportCrash(context, e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th) {
                                UMCrashManager.reportCrash(context, th);
                            }
                        }
                        return 101;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                UMCrashManager.reportCrash(context, th3);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public static void syncLegacyEnvelopeIfNeeded(Context context) {
        String legacyEnvelopeDir;
        if (context == null) {
            return;
        }
        try {
            legacyEnvelopeDir = getLegacyEnvelopeDir(context);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        if (TextUtils.isEmpty(legacyEnvelopeDir) || legacyEnvelopeDir.equals(mDefaultEnvelopeDir)) {
            return;
        }
        File file = new File(context.getFilesDir().getAbsolutePath() + "/." + legacyEnvelopeDir);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                try {
                    if (file.isDirectory()) {
                        file.delete();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    UMCrashManager.reportCrash(context, th2);
                    return;
                }
            }
            try {
                String envelopeDirPath = getEnvelopeDirPath(context);
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    listFiles[i2].renameTo(new File(envelopeDirPath + File.separator + listFiles[i2].getName()));
                }
                if (file.isDirectory()) {
                    file.delete();
                    return;
                }
                return;
            } catch (Throwable th3) {
                UMCrashManager.reportCrash(context, th3);
                return;
            }
            UMCrashManager.reportCrash(context, th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v3 */
    public static byte[] toByteArray(String str) throws IOException {
        Throwable th;
        IOException e2;
        FileChannel channel;
        byte[] bArr;
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            try {
                try {
                    channel = new RandomAccessFile(str, "r").getChannel();
                } catch (IOException e3) {
                    e2 = e3;
                } catch (Throwable th2) {
                    th = th2;
                    str = 0;
                    try {
                        str.close();
                    } catch (Throwable th3) {
                        UMCrashManager.reportCrash(appContext, th3);
                    }
                    throw th;
                }
                try {
                    MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).load();
                    bArr = new byte[(int) channel.size()];
                    if (load.remaining() > 0) {
                        load.get(bArr, 0, load.remaining());
                    }
                    try {
                        channel.close();
                    } catch (Throwable th4) {
                        UMCrashManager.reportCrash(appContext, th4);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    UMCrashManager.reportCrash(appContext, e2);
                    throw e2;
                }
            } catch (Throwable th5) {
                th = th5;
                str.close();
                throw th;
            }
        }
        return bArr;
    }

    private static void updateLastInstantBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }

    private static void updateLastSuccessfulBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }
}
