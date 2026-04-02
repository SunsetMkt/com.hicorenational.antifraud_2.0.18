package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static final String[] a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f6186b = {"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f6187c = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f6188d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f6189e = null;

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (an.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String a(Context context) {
        return d.c.a.b.a.a.f10075h;
    }

    public static String b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (an.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String b(Context context) {
        return d.c.a.b.a.a.f10075h;
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (an.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String d() {
        try {
            return Build.SERIAL;
        } catch (Throwable unused) {
            an.a("Failed to get hardware serial number.", new Object[0]);
            return "fail";
        }
    }

    public static String d(Context context) {
        return d.c.a.b.a.a.f10075h;
    }

    public static String e(Context context) {
        String simSerialNumber = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "fail";
            }
            simSerialNumber = telephonyManager.getSimSerialNumber();
            return simSerialNumber == null ? d.c.a.b.a.a.f10075h : simSerialNumber;
        } catch (Throwable unused) {
            an.a("Failed to get SIM serial number.", new Object[0]);
            return simSerialNumber;
        }
    }

    public static long f() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long g() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long h() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            fileReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            String line = bufferedReader.readLine();
            if (line == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    if (!an.a(e2)) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e3) {
                    if (!an.a(e3)) {
                        e3.printStackTrace();
                    }
                }
                return -1L;
            }
            long j2 = Long.parseLong(line.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                if (!an.a(e4)) {
                    e4.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e5) {
                if (!an.a(e5)) {
                    e5.printStackTrace();
                }
            }
            return j2;
        } catch (Throwable th4) {
            th = th4;
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        if (!an.a(e6)) {
                            e6.printStackTrace();
                        }
                    }
                }
                if (fileReader == null) {
                    return -2L;
                }
                try {
                    fileReader.close();
                    return -2L;
                } catch (IOException e7) {
                    if (an.a(e7)) {
                        return -2L;
                    }
                    e7.printStackTrace();
                    return -2L;
                }
            } catch (Throwable th5) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                        if (!an.a(e8)) {
                            e8.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e9) {
                        if (!an.a(e9)) {
                            e9.printStackTrace();
                        }
                    }
                }
                throw th5;
            }
        }
    }

    public static long i() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            fileReader = null;
        }
        try {
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            if (line == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    if (!an.a(e2)) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e3) {
                    if (!an.a(e3)) {
                        e3.printStackTrace();
                    }
                }
                return -1L;
            }
            long j2 = (Long.parseLong(line.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024) + 0;
            String line2 = bufferedReader.readLine();
            if (line2 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    if (!an.a(e4)) {
                        e4.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e5) {
                    if (!an.a(e5)) {
                        e5.printStackTrace();
                    }
                }
                return -1L;
            }
            long j3 = Long.parseLong(line2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
            Long.signum(j3);
            long j4 = j2 + (j3 * 1024);
            String line3 = bufferedReader.readLine();
            if (line3 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    if (!an.a(e6)) {
                        e6.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e7) {
                    if (!an.a(e7)) {
                        e7.printStackTrace();
                    }
                }
                return -1L;
            }
            long j5 = j4 + (Long.parseLong(line3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024);
            try {
                bufferedReader.close();
            } catch (IOException e8) {
                if (!an.a(e8)) {
                    e8.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e9) {
                if (!an.a(e9)) {
                    e9.printStackTrace();
                }
            }
            return j5;
        } catch (Throwable th3) {
            th = th3;
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e10) {
                        if (!an.a(e10)) {
                            e10.printStackTrace();
                        }
                    }
                }
                if (fileReader == null) {
                    return -2L;
                }
                try {
                    fileReader.close();
                    return -2L;
                } catch (IOException e11) {
                    if (an.a(e11)) {
                        return -2L;
                    }
                    e11.printStackTrace();
                    return -2L;
                }
            } catch (Throwable th4) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e12) {
                        if (!an.a(e12)) {
                            e12.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e13) {
                        if (!an.a(e13)) {
                            e13.printStackTrace();
                        }
                    }
                }
                throw th4;
            }
        }
    }

    public static long j() {
        if (!e()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (an.a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static long k() {
        if (!e()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (an.a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static String l() {
        try {
            return Locale.getDefault().getCountry();
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    public static String m() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    public static boolean n() {
        boolean z;
        String[] strArr = a;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            if (new File(strArr[i2]).exists()) {
                z = true;
                break;
            }
            i2++;
        }
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || z;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String o() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        try {
            StringBuilder sb = new StringBuilder();
            if (new File("/sys/block/mmcblk0/device/type").exists()) {
                bufferedReader2 = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/type"));
                try {
                    String line = bufferedReader2.readLine();
                    if (line != null) {
                        sb.append(line);
                    }
                    bufferedReader2.close();
                } catch (Throwable unused) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    return null;
                }
            } else {
                bufferedReader2 = null;
            }
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (new File("/sys/block/mmcblk0/device/name").exists()) {
                bufferedReader = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/name"));
                try {
                    String line2 = bufferedReader.readLine();
                    if (line2 != null) {
                        sb.append(line2);
                    }
                    bufferedReader.close();
                } catch (Throwable unused2) {
                    if (bufferedReader != null) {
                    }
                    return null;
                }
            } else {
                bufferedReader = bufferedReader2;
            }
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (new File("/sys/block/mmcblk0/device/cid").exists()) {
                bufferedReader3 = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/cid"));
                try {
                    String line3 = bufferedReader3.readLine();
                    if (line3 != null) {
                        sb.append(line3);
                    }
                } catch (Throwable unused3) {
                    bufferedReader = bufferedReader3;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            an.a(e2);
                        }
                    }
                    return null;
                }
            } else {
                bufferedReader3 = bufferedReader;
            }
            String string = sb.toString();
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (IOException e3) {
                    an.a(e3);
                }
            }
            return string;
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    public static String p() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            String[] strArr = f6187c;
            if (i2 >= strArr.length) {
                break;
            }
            if (i2 == 0) {
                if (!new File(strArr[i2]).exists()) {
                    arrayList.add(Integer.valueOf(i2));
                }
            } else if (new File(strArr[i2]).exists()) {
                arrayList.add(Integer.valueOf(i2));
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    public static int q() {
        try {
            Method method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
            method.setAccessible(true);
            return method.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy") ? 256 : 0;
        } catch (Exception unused) {
            return 256;
        }
    }

    public static int r() {
        try {
            throw new Exception("detect hook");
        } catch (Exception e2) {
            int i2 = 0;
            int i3 = 0;
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("main")) {
                    i2 |= 4;
                }
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    i2 |= 8;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    i2 |= 16;
                }
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") && (i3 = i3 + 1) == 2) {
                    i2 |= 32;
                }
            }
            return i2;
        }
    }

    public static int s() throws Throwable {
        BufferedReader bufferedReader;
        IOException e2;
        UnsupportedEncodingException e3;
        FileNotFoundException e4;
        HashSet hashSet;
        int i2 = 0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    hashSet = new HashSet();
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/maps"), "utf-8"));
                } catch (FileNotFoundException e5) {
                    bufferedReader = null;
                    e4 = e5;
                } catch (UnsupportedEncodingException e6) {
                    bufferedReader = null;
                    e3 = e6;
                } catch (IOException e7) {
                    bufferedReader = null;
                    e2 = e7;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e9) {
                e9.printStackTrace();
            }
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.endsWith(".so") || line.endsWith(".jar")) {
                        hashSet.add(line.substring(line.lastIndexOf(d.c.a.b.a.a.f10074g) + 1));
                    }
                } catch (FileNotFoundException e10) {
                    e4 = e10;
                    e4.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return i2;
                } catch (UnsupportedEncodingException e11) {
                    e3 = e11;
                    e3.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return i2;
                } catch (IOException e12) {
                    e2 = e12;
                    e2.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return i2;
                }
                return i2;
            }
            for (Object obj : hashSet) {
                if (((String) obj).toLowerCase().contains("xposed")) {
                    i2 |= 64;
                }
                if (((String) obj).contains("com.saurik.substrate")) {
                    i2 |= 128;
                }
            }
            bufferedReader.close();
            return i2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(Context context, boolean z) {
        String property = null;
        if (z) {
            try {
                String strB = aq.b(context, "ro.product.cpu.abilist");
                if (aq.a(strB) || strB.equals("fail")) {
                    strB = aq.b(context, "ro.product.cpu.abi");
                }
                if (!aq.a(strB) && !strB.equals("fail")) {
                    an.b(b.class, "ABI list: " + strB, new Object[0]);
                    property = strB.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0];
                }
            } catch (Throwable th) {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                return "fail";
            }
        }
        if (property == null) {
            property = System.getProperty("os.arch");
        }
        return "" + property;
    }

    public static String c(Context context) {
        String string = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            string = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
            return string == null ? d.c.a.b.a.a.f10075h : string.toLowerCase();
        } catch (Throwable th) {
            if (!an.a(th)) {
                an.a("Failed to get Android ID.", new Object[0]);
            }
            return string;
        }
    }

    public static boolean e() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (an.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public static String l(Context context) {
        StringBuilder sb = new StringBuilder();
        String strB = aq.b(context, "gsm.sim.state");
        if (strB != null) {
            sb.append("gsm.sim.state");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(strB);
        }
        sb.append("\n");
        String strB2 = aq.b(context, "gsm.sim.state2");
        if (strB2 != null) {
            sb.append("gsm.sim.state2");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(strB2);
        }
        return sb.toString();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0030 -> B:34:0x0041). Please report as a decompilation issue!!! */
    public static long m(Context context) {
        BufferedReader bufferedReader;
        float fCurrentTimeMillis = 0.0f;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/uptime"));
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        fCurrentTimeMillis = (System.currentTimeMillis() / 1000) - Float.parseFloat(line.split(d.c.a.b.a.a.f10074g)[0]);
                    }
                    bufferedReader.close();
                } catch (Throwable unused) {
                    try {
                        an.a("Failed to get boot time of device.", new Object[0]);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return (long) fCurrentTimeMillis;
                    } catch (Throwable th) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                an.a(e2);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable unused2) {
                bufferedReader = null;
            }
        } catch (IOException e3) {
            an.a(e3);
        }
        return (long) fCurrentTimeMillis;
    }

    public static boolean n(Context context) {
        return (o(context) == null && p() == null) ? false : true;
    }

    public static int q(Context context) {
        int i2;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
            i2 = 1;
        } catch (Exception unused) {
            i2 = 0;
        }
        try {
            packageManager.getInstallerPackageName("com.saurik.substrate");
            return i2 | 2;
        } catch (Exception unused2) {
            return i2;
        }
    }

    public static String f(Context context) {
        TelephonyManager telephonyManager;
        String str;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() != 1) {
                if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    int networkType = telephonyManager.getNetworkType();
                    switch (networkType) {
                        case 1:
                            str = "GPRS";
                            break;
                        case 2:
                            str = "EDGE";
                            break;
                        case 3:
                            str = "UMTS";
                            break;
                        case 4:
                            str = "CDMA";
                            break;
                        case 5:
                            str = "EVDO_0";
                            break;
                        case 6:
                            str = "EVDO_A";
                            break;
                        case 7:
                            str = "1xRTT";
                            break;
                        case 8:
                            str = "HSDPA";
                            break;
                        case 9:
                            str = "HSUPA";
                            break;
                        case 10:
                            str = "HSPA";
                            break;
                        case 11:
                            str = "iDen";
                            break;
                        case 12:
                            str = "EVDO_B";
                            break;
                        case 13:
                            str = "LTE";
                            break;
                        case 14:
                            str = "eHRPD";
                            break;
                        case 15:
                            str = "HSPA+";
                            break;
                        default:
                            str = "MOBILE(" + networkType + ")";
                            break;
                    }
                } else {
                    return "unknown";
                }
            } else {
                str = "WIFI";
            }
            return str;
        } catch (Exception e2) {
            if (an.a(e2)) {
                return "unknown";
            }
            e2.printStackTrace();
            return "unknown";
        }
    }

    public static String g(Context context) {
        String strB = aq.b(context, "ro.miui.ui.version.name");
        if (!aq.a(strB) && !strB.equals("fail")) {
            return "XiaoMi/MIUI/" + strB;
        }
        String strB2 = aq.b(context, "ro.build.version.emui");
        if (!aq.a(strB2) && !strB2.equals("fail")) {
            return "HuaWei/EMOTION/" + strB2;
        }
        String strB3 = aq.b(context, "ro.lenovo.series");
        if (!aq.a(strB3) && !strB3.equals("fail")) {
            return "Lenovo/VIBE/" + aq.b(context, "ro.build.version.incremental");
        }
        String strB4 = aq.b(context, "ro.build.nubia.rom.name");
        if (!aq.a(strB4) && !strB4.equals("fail")) {
            return "Zte/NUBIA/" + strB4 + d.c.a.b.a.a.s1 + aq.b(context, "ro.build.nubia.rom.code");
        }
        String strB5 = aq.b(context, "ro.meizu.product.model");
        if (!aq.a(strB5) && !strB5.equals("fail")) {
            return "Meizu/FLYME/" + aq.b(context, "ro.build.display.id");
        }
        String strB6 = aq.b(context, "ro.build.version.opporom");
        if (!aq.a(strB6) && !strB6.equals("fail")) {
            return "Oppo/COLOROS/" + strB6;
        }
        String strB7 = aq.b(context, "ro.vivo.os.build.display.id");
        if (!aq.a(strB7) && !strB7.equals("fail")) {
            return "vivo/FUNTOUCH/" + strB7;
        }
        String strB8 = aq.b(context, "ro.aa.romver");
        if (!aq.a(strB8) && !strB8.equals("fail")) {
            return "htc/" + strB8 + "/" + aq.b(context, "ro.build.description");
        }
        String strB9 = aq.b(context, "ro.lewa.version");
        if (!aq.a(strB9) && !strB9.equals("fail")) {
            return "tcl/" + strB9 + "/" + aq.b(context, "ro.build.display.id");
        }
        String strB10 = aq.b(context, "ro.gn.gnromvernumber");
        if (!aq.a(strB10) && !strB10.equals("fail")) {
            return "amigo/" + strB10 + "/" + aq.b(context, "ro.build.display.id");
        }
        String strB11 = aq.b(context, "ro.build.tyd.kbstyle_version");
        if (!aq.a(strB11) && !strB11.equals("fail")) {
            return "dido/" + strB11;
        }
        return aq.b(context, "ro.build.fingerprint") + "/" + aq.b(context, "ro.build.rom.id");
    }

    public static String j(Context context) {
        BufferedReader bufferedReader;
        Throwable th;
        String line;
        StringBuilder sb = new StringBuilder();
        if (f6188d == null) {
            f6188d = aq.b(context, "ro.secure");
        }
        if (f6188d != null) {
            sb.append("ro.secure");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(f6188d);
            sb.append("\n");
        }
        if (f6189e == null) {
            f6189e = aq.b(context, "ro.debuggable");
        }
        if (f6189e != null) {
            sb.append("ro.debuggable");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(f6189e);
            sb.append("\n");
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/self/status"));
            do {
                try {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        an.a(th);
                        return sb.toString();
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                an.a(e2);
                            }
                        }
                    }
                }
            } while (!line.startsWith("TracerPid:"));
            if (line != null) {
                String strTrim = line.substring(10).trim();
                sb.append("tracer_pid");
                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                sb.append(strTrim);
            }
            String string = sb.toString();
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                an.a(e3);
            }
            return string;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c A[Catch: all -> 0x00a4, TRY_LEAVE, TryCatch #0 {all -> 0x00a4, blocks: (B:3:0x000e, B:6:0x001b, B:13:0x003e, B:15:0x004c, B:22:0x006e, B:24:0x007c), top: B:42:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e A[Catch: all -> 0x00a4, PHI: r4
  0x006e: PHI (r4v4 java.io.BufferedReader) = (r4v3 java.io.BufferedReader), (r4v7 java.io.BufferedReader) binds: [B:14:0x004a, B:20:0x006a] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x00a4, blocks: (B:3:0x000e, B:6:0x001b, B:13:0x003e, B:15:0x004c, B:22:0x006e, B:24:0x007c), top: B:42:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c A[Catch: all -> 0x00a4, TRY_LEAVE, TryCatch #0 {all -> 0x00a4, blocks: (B:3:0x000e, B:6:0x001b, B:13:0x003e, B:15:0x004c, B:22:0x006e, B:24:0x007c), top: B:42:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0 A[Catch: IOException -> 0x00ab, TRY_ENTER, TryCatch #4 {IOException -> 0x00ab, blocks: (B:36:0x00a7, B:33:0x00a0), top: B:51:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7 A[Catch: IOException -> 0x00ab, TRY_LEAVE, TryCatch #4 {IOException -> 0x00ab, blocks: (B:36:0x00a7, B:33:0x00a0), top: B:51:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String k(Context context) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            if (new File("/sys/class/power_supply/ac/online").exists()) {
                BufferedReader bufferedReader3 = new BufferedReader(new FileReader("/sys/class/power_supply/ac/online"));
                try {
                    String line = bufferedReader3.readLine();
                    if (line != null) {
                        sb.append("ac_online");
                        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                        sb.append(line);
                    }
                    bufferedReader3.close();
                    bufferedReader2 = bufferedReader3;
                    sb.append("\n");
                } catch (Throwable unused) {
                    bufferedReader2 = bufferedReader3;
                    if (bufferedReader2 != null) {
                    }
                    return sb.toString();
                }
                if (!new File("/sys/class/power_supply/usb/online").exists()) {
                    BufferedReader bufferedReader4 = new BufferedReader(new FileReader("/sys/class/power_supply/usb/online"));
                    try {
                        String line2 = bufferedReader4.readLine();
                        if (line2 != null) {
                            sb.append("usb_online");
                            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                            sb.append(line2);
                        }
                        bufferedReader4.close();
                        bufferedReader2 = bufferedReader4;
                        sb.append("\n");
                        if (new File("/sys/class/power_supply/battery/capacity").exists()) {
                            bufferedReader = bufferedReader2;
                        } else {
                            bufferedReader = new BufferedReader(new FileReader("/sys/class/power_supply/battery/capacity"));
                            try {
                                String line3 = bufferedReader.readLine();
                                if (line3 != null) {
                                    sb.append("battery_capacity");
                                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                    sb.append(line3);
                                }
                                bufferedReader.close();
                            } catch (Throwable unused2) {
                                bufferedReader2 = bufferedReader;
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                                return sb.toString();
                            }
                        }
                    } catch (Throwable unused3) {
                        bufferedReader2 = bufferedReader4;
                        if (bufferedReader2 != null) {
                        }
                        return sb.toString();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } else {
                    sb.append("\n");
                    if (new File("/sys/class/power_supply/battery/capacity").exists()) {
                    }
                    if (bufferedReader != null) {
                    }
                }
            } else {
                sb.append("\n");
                if (!new File("/sys/class/power_supply/usb/online").exists()) {
                }
            }
        } catch (IOException e2) {
            an.a(e2);
        }
        return sb.toString();
    }

    public static boolean p(Context context) {
        return (((q(context) | r()) | s()) | q()) > 0;
    }

    public static String o(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            String[] strArr = f6186b;
            if (i2 >= strArr.length) {
                break;
            }
            try {
                packageManager.getPackageInfo(strArr[i2], 1);
                arrayList.add(Integer.valueOf(i2));
            } catch (PackageManager.NameNotFoundException unused) {
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    public static String h(Context context) {
        return aq.b(context, "ro.board.platform");
    }

    public static String i(Context context) {
        StringBuilder sb = new StringBuilder();
        String strB = aq.b(context, "ro.genymotion.version");
        if (strB != null) {
            sb.append("ro.genymotion.version");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(strB);
            sb.append("\n");
        }
        String strB2 = aq.b(context, "androVM.vbox_dpi");
        if (strB2 != null) {
            sb.append("androVM.vbox_dpi");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(strB2);
            sb.append("\n");
        }
        String strB3 = aq.b(context, "qemu.sf.fake_camera");
        if (strB3 != null) {
            sb.append("qemu.sf.fake_camera");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(strB3);
        }
        return sb.toString();
    }
}
