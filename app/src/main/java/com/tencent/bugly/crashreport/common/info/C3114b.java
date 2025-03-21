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
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
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
import java.util.Iterator;
import java.util.Locale;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.common.info.b */
/* loaded from: classes2.dex */
public class C3114b {

    /* renamed from: a */
    private static final String[] f10219a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* renamed from: b */
    private static final String[] f10220b = {"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* renamed from: c */
    private static final String[] f10221c = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    /* renamed from: d */
    private static String f10222d = null;

    /* renamed from: e */
    private static String f10223e = null;

    /* renamed from: a */
    public static String m9594a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    /* renamed from: a */
    public static String m9595a(Context context) {
        return AbstractC1191a.f2571h;
    }

    /* renamed from: b */
    public static String m9597b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    /* renamed from: b */
    public static String m9598b(Context context) {
        return AbstractC1191a.f2571h;
    }

    /* renamed from: c */
    public static int m9599c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: d */
    public static String m9601d() {
        try {
            return Build.SERIAL;
        } catch (Throwable unused) {
            C3151an.m9915a("Failed to get hardware serial number.", new Object[0]);
            return "fail";
        }
    }

    /* renamed from: d */
    public static String m9602d(Context context) {
        return AbstractC1191a.f2571h;
    }

    /* renamed from: e */
    public static String m9603e(Context context) {
        String str = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "fail";
            }
            str = telephonyManager.getSimSerialNumber();
            return str == null ? AbstractC1191a.f2571h : str;
        } catch (Throwable unused) {
            C3151an.m9915a("Failed to get SIM serial number.", new Object[0]);
            return str;
        }
    }

    /* renamed from: f */
    public static long m9605f() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    /* renamed from: g */
    public static long m9607g() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    /* renamed from: h */
    public static long m9609h() {
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
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    if (!C3151an.m9916a(e2)) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e3) {
                    if (!C3151an.m9916a(e3)) {
                        e3.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                if (!C3151an.m9916a(e4)) {
                    e4.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e5) {
                if (!C3151an.m9916a(e5)) {
                    e5.printStackTrace();
                }
            }
            return parseLong;
        } catch (Throwable th4) {
            th = th4;
            try {
                if (!C3151an.m9916a(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        if (!C3151an.m9916a(e6)) {
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
                    if (C3151an.m9916a(e7)) {
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
                        if (!C3151an.m9916a(e8)) {
                            e8.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e9) {
                        if (!C3151an.m9916a(e9)) {
                            e9.printStackTrace();
                        }
                    }
                }
                throw th5;
            }
        }
    }

    /* renamed from: i */
    public static long m9611i() {
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
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    if (!C3151an.m9916a(e2)) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e3) {
                    if (!C3151an.m9916a(e3)) {
                        e3.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong = (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024) + 0;
            String readLine2 = bufferedReader.readLine();
            if (readLine2 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    if (!C3151an.m9916a(e4)) {
                        e4.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e5) {
                    if (!C3151an.m9916a(e5)) {
                        e5.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong2 = Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
            Long.signum(parseLong2);
            long j2 = parseLong + (parseLong2 * 1024);
            String readLine3 = bufferedReader.readLine();
            if (readLine3 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    if (!C3151an.m9916a(e6)) {
                        e6.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e7) {
                    if (!C3151an.m9916a(e7)) {
                        e7.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong3 = j2 + (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024);
            try {
                bufferedReader.close();
            } catch (IOException e8) {
                if (!C3151an.m9916a(e8)) {
                    e8.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e9) {
                if (!C3151an.m9916a(e9)) {
                    e9.printStackTrace();
                }
            }
            return parseLong3;
        } catch (Throwable th3) {
            th = th3;
            try {
                if (!C3151an.m9916a(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e10) {
                        if (!C3151an.m9916a(e10)) {
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
                    if (C3151an.m9916a(e11)) {
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
                        if (!C3151an.m9916a(e12)) {
                            e12.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e13) {
                        if (!C3151an.m9916a(e13)) {
                            e13.printStackTrace();
                        }
                    }
                }
                throw th4;
            }
        }
    }

    /* renamed from: j */
    public static long m9613j() {
        if (!m9604e()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    /* renamed from: k */
    public static long m9615k() {
        if (!m9604e()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    /* renamed from: l */
    public static String m9617l() {
        try {
            return Locale.getDefault().getCountry();
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: m */
    public static String m9620m() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: n */
    public static boolean m9621n() {
        boolean z;
        String[] strArr = f10219a;
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

    /* JADX WARN: Removed duplicated region for block: B:39:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m9623o() {
        /*
            java.lang.String r0 = "/sys/block/mmcblk0/device/cid"
            java.lang.String r1 = "/sys/block/mmcblk0/device/name"
            java.lang.String r2 = ","
            java.lang.String r3 = "/sys/block/mmcblk0/device/type"
            r4 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8f
            r5.<init>()     // Catch: java.lang.Throwable -> L8f
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L8f
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L8f
            boolean r6 = r6.exists()     // Catch: java.lang.Throwable -> L8f
            if (r6 == 0) goto L30
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L8f
            java.io.FileReader r7 = new java.io.FileReader     // Catch: java.lang.Throwable -> L8f
            r7.<init>(r3)     // Catch: java.lang.Throwable -> L8f
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r3 = r6.readLine()     // Catch: java.lang.Throwable -> L8d
            if (r3 == 0) goto L2c
            r5.append(r3)     // Catch: java.lang.Throwable -> L8d
        L2c:
            r6.close()     // Catch: java.lang.Throwable -> L8d
            goto L31
        L30:
            r6 = r4
        L31:
            r5.append(r2)     // Catch: java.lang.Throwable -> L8d
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L8d
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L8d
            boolean r3 = r3.exists()     // Catch: java.lang.Throwable -> L8d
            if (r3 == 0) goto L56
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L8d
            java.io.FileReader r7 = new java.io.FileReader     // Catch: java.lang.Throwable -> L8d
            r7.<init>(r1)     // Catch: java.lang.Throwable -> L8d
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L8b
            if (r1 == 0) goto L52
            r5.append(r1)     // Catch: java.lang.Throwable -> L8b
        L52:
            r3.close()     // Catch: java.lang.Throwable -> L8b
            goto L57
        L56:
            r3 = r6
        L57:
            r5.append(r2)     // Catch: java.lang.Throwable -> L8b
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L8b
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L8b
            boolean r1 = r1.exists()     // Catch: java.lang.Throwable -> L8b
            if (r1 == 0) goto L79
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L8b
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L8b
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L8b
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L89
            if (r0 == 0) goto L7a
            r5.append(r0)     // Catch: java.lang.Throwable -> L89
            goto L7a
        L79:
            r1 = r3
        L7a:
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L89
            if (r1 == 0) goto L88
            r1.close()     // Catch: java.io.IOException -> L84
            goto L88
        L84:
            r1 = move-exception
            com.tencent.bugly.proguard.C3151an.m9916a(r1)
        L88:
            return r0
        L89:
            r3 = r1
            goto L90
        L8b:
            goto L90
        L8d:
            r3 = r6
            goto L90
        L8f:
            r3 = r4
        L90:
            if (r3 == 0) goto L9a
            r3.close()     // Catch: java.io.IOException -> L96
            goto L9a
        L96:
            r0 = move-exception
            com.tencent.bugly.proguard.C3151an.m9916a(r0)
        L9a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C3114b.m9623o():java.lang.String");
    }

    /* renamed from: p */
    public static String m9625p() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            String[] strArr = f10221c;
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

    /* renamed from: q */
    public static int m9627q() {
        try {
            Method method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
            method.setAccessible(true);
            return method.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy") ? 256 : 0;
        } catch (Exception unused) {
            return 256;
        }
    }

    /* renamed from: r */
    public static int m9629r() {
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

    /* renamed from: s */
    public static int m9630s() {
        BufferedReader bufferedReader;
        IOException e2;
        UnsupportedEncodingException e3;
        FileNotFoundException e4;
        int i2 = 0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    HashSet hashSet = new HashSet();
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/maps"), "utf-8"));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                                hashSet.add(readLine.substring(readLine.lastIndexOf(AbstractC1191a.f2568g) + 1));
                            }
                        } catch (FileNotFoundException e5) {
                            e4 = e5;
                            e4.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return i2;
                        } catch (UnsupportedEncodingException e6) {
                            e3 = e6;
                            e3.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return i2;
                        } catch (IOException e7) {
                            e2 = e7;
                            e2.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return i2;
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (((String) next).toLowerCase().contains("xposed")) {
                            i2 |= 64;
                        }
                        if (((String) next).contains("com.saurik.substrate")) {
                            i2 |= 128;
                        }
                    }
                    bufferedReader.close();
                } catch (FileNotFoundException e8) {
                    bufferedReader = null;
                    e4 = e8;
                } catch (UnsupportedEncodingException e9) {
                    bufferedReader = null;
                    e3 = e9;
                } catch (IOException e10) {
                    bufferedReader = null;
                    e2 = e10;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e12) {
                e12.printStackTrace();
            }
            return i2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0050, code lost:
    
        r0 = java.lang.System.getProperty("os.arch");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m9596a(android.content.Context r4, boolean r5) {
        /*
            r0 = 0
            java.lang.String r1 = "fail"
            if (r5 == 0) goto L4e
            java.lang.String r5 = "ro.product.cpu.abilist"
            java.lang.String r5 = com.tencent.bugly.proguard.C3154aq.m9979b(r4, r5)     // Catch: java.lang.Throwable -> L4c
            boolean r2 = com.tencent.bugly.proguard.C3154aq.m9970a(r5)     // Catch: java.lang.Throwable -> L4c
            if (r2 != 0) goto L17
            boolean r2 = r5.equals(r1)     // Catch: java.lang.Throwable -> L4c
            if (r2 == 0) goto L1d
        L17:
            java.lang.String r5 = "ro.product.cpu.abi"
            java.lang.String r5 = com.tencent.bugly.proguard.C3154aq.m9979b(r4, r5)     // Catch: java.lang.Throwable -> L4c
        L1d:
            boolean r4 = com.tencent.bugly.proguard.C3154aq.m9970a(r5)     // Catch: java.lang.Throwable -> L4c
            if (r4 != 0) goto L4e
            boolean r4 = r5.equals(r1)     // Catch: java.lang.Throwable -> L4c
            if (r4 == 0) goto L2a
            goto L4e
        L2a:
            java.lang.Class<com.tencent.bugly.crashreport.common.info.b> r4 = com.tencent.bugly.crashreport.common.info.C3114b.class
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4c
            r0.<init>()     // Catch: java.lang.Throwable -> L4c
            java.lang.String r2 = "ABI list: "
            r0.append(r2)     // Catch: java.lang.Throwable -> L4c
            r0.append(r5)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L4c
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L4c
            com.tencent.bugly.proguard.C3151an.m9917b(r4, r0, r3)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r4 = ","
            java.lang.String[] r4 = r5.split(r4)     // Catch: java.lang.Throwable -> L4c
            r0 = r4[r2]     // Catch: java.lang.Throwable -> L4c
            goto L4e
        L4c:
            r4 = move-exception
            goto L68
        L4e:
            if (r0 != 0) goto L56
            java.lang.String r4 = "os.arch"
            java.lang.String r0 = java.lang.System.getProperty(r4)     // Catch: java.lang.Throwable -> L4c
        L56:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4c
            r4.<init>()     // Catch: java.lang.Throwable -> L4c
            java.lang.String r5 = ""
            r4.append(r5)     // Catch: java.lang.Throwable -> L4c
            r4.append(r0)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L4c
            return r4
        L68:
            boolean r5 = com.tencent.bugly.proguard.C3151an.m9916a(r4)
            if (r5 != 0) goto L71
            r4.printStackTrace()
        L71:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C3114b.m9596a(android.content.Context, boolean):java.lang.String");
    }

    /* renamed from: c */
    public static String m9600c(Context context) {
        String str = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            str = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
            return str == null ? AbstractC1191a.f2571h : str.toLowerCase();
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                C3151an.m9915a("Failed to get Android ID.", new Object[0]);
            }
            return str;
        }
    }

    /* renamed from: e */
    public static boolean m9604e() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: l */
    public static String m9618l(Context context) {
        StringBuilder sb = new StringBuilder();
        String m9979b = C3154aq.m9979b(context, "gsm.sim.state");
        if (m9979b != null) {
            sb.append("gsm.sim.state");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(m9979b);
        }
        sb.append("\n");
        String m9979b2 = C3154aq.m9979b(context, "gsm.sim.state2");
        if (m9979b2 != null) {
            sb.append("gsm.sim.state2");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(m9979b2);
        }
        return sb.toString();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0030 -> B:13:0x0041). Please report as a decompilation issue!!! */
    /* renamed from: m */
    public static long m9619m(Context context) {
        BufferedReader bufferedReader;
        float f2 = 0.0f;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/uptime"));
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        f2 = (System.currentTimeMillis() / 1000) - Float.parseFloat(readLine.split(AbstractC1191a.f2568g)[0]);
                    }
                    bufferedReader.close();
                } catch (Throwable unused) {
                    try {
                        C3151an.m9915a("Failed to get boot time of device.", new Object[0]);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return (long) f2;
                    } catch (Throwable th) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                C3151an.m9916a(e2);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable unused2) {
                bufferedReader = null;
            }
        } catch (IOException e3) {
            C3151an.m9916a(e3);
        }
        return (long) f2;
    }

    /* renamed from: n */
    public static boolean m9622n(Context context) {
        return (m9624o(context) == null && m9625p() == null) ? false : true;
    }

    /* renamed from: q */
    public static int m9628q(Context context) {
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

    /* renamed from: f */
    public static String m9606f(Context context) {
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
            if (C3151an.m9916a(e2)) {
                return "unknown";
            }
            e2.printStackTrace();
            return "unknown";
        }
    }

    /* renamed from: g */
    public static String m9608g(Context context) {
        String m9979b = C3154aq.m9979b(context, "ro.miui.ui.version.name");
        if (!C3154aq.m9970a(m9979b) && !m9979b.equals("fail")) {
            return "XiaoMi/MIUI/" + m9979b;
        }
        String m9979b2 = C3154aq.m9979b(context, "ro.build.version.emui");
        if (!C3154aq.m9970a(m9979b2) && !m9979b2.equals("fail")) {
            return "HuaWei/EMOTION/" + m9979b2;
        }
        String m9979b3 = C3154aq.m9979b(context, "ro.lenovo.series");
        if (!C3154aq.m9970a(m9979b3) && !m9979b3.equals("fail")) {
            return "Lenovo/VIBE/" + C3154aq.m9979b(context, "ro.build.version.incremental");
        }
        String m9979b4 = C3154aq.m9979b(context, "ro.build.nubia.rom.name");
        if (!C3154aq.m9970a(m9979b4) && !m9979b4.equals("fail")) {
            return "Zte/NUBIA/" + m9979b4 + AbstractC1191a.f2606s1 + C3154aq.m9979b(context, "ro.build.nubia.rom.code");
        }
        String m9979b5 = C3154aq.m9979b(context, "ro.meizu.product.model");
        if (!C3154aq.m9970a(m9979b5) && !m9979b5.equals("fail")) {
            return "Meizu/FLYME/" + C3154aq.m9979b(context, "ro.build.display.id");
        }
        String m9979b6 = C3154aq.m9979b(context, "ro.build.version.opporom");
        if (!C3154aq.m9970a(m9979b6) && !m9979b6.equals("fail")) {
            return "Oppo/COLOROS/" + m9979b6;
        }
        String m9979b7 = C3154aq.m9979b(context, "ro.vivo.os.build.display.id");
        if (!C3154aq.m9970a(m9979b7) && !m9979b7.equals("fail")) {
            return "vivo/FUNTOUCH/" + m9979b7;
        }
        String m9979b8 = C3154aq.m9979b(context, "ro.aa.romver");
        if (!C3154aq.m9970a(m9979b8) && !m9979b8.equals("fail")) {
            return "htc/" + m9979b8 + "/" + C3154aq.m9979b(context, "ro.build.description");
        }
        String m9979b9 = C3154aq.m9979b(context, "ro.lewa.version");
        if (!C3154aq.m9970a(m9979b9) && !m9979b9.equals("fail")) {
            return "tcl/" + m9979b9 + "/" + C3154aq.m9979b(context, "ro.build.display.id");
        }
        String m9979b10 = C3154aq.m9979b(context, "ro.gn.gnromvernumber");
        if (!C3154aq.m9970a(m9979b10) && !m9979b10.equals("fail")) {
            return "amigo/" + m9979b10 + "/" + C3154aq.m9979b(context, "ro.build.display.id");
        }
        String m9979b11 = C3154aq.m9979b(context, "ro.build.tyd.kbstyle_version");
        if (!C3154aq.m9970a(m9979b11) && !m9979b11.equals("fail")) {
            return "dido/" + m9979b11;
        }
        return C3154aq.m9979b(context, "ro.build.fingerprint") + "/" + C3154aq.m9979b(context, "ro.build.rom.id");
    }

    /* renamed from: j */
    public static String m9614j(Context context) {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        StringBuilder sb = new StringBuilder();
        if (f10222d == null) {
            f10222d = C3154aq.m9979b(context, "ro.secure");
        }
        if (f10222d != null) {
            sb.append("ro.secure");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(f10222d);
            sb.append("\n");
        }
        if (f10223e == null) {
            f10223e = C3154aq.m9979b(context, "ro.debuggable");
        }
        if (f10223e != null) {
            sb.append("ro.debuggable");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(f10223e);
            sb.append("\n");
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/self/status"));
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        C3151an.m9916a(th);
                        return sb.toString();
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                C3151an.m9916a(e2);
                            }
                        }
                    }
                }
            } while (!readLine.startsWith("TracerPid:"));
            if (readLine != null) {
                String trim = readLine.substring(10).trim();
                sb.append("tracer_pid");
                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                sb.append(trim);
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                C3151an.m9916a(e3);
            }
            return sb2;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a7 A[Catch: IOException -> 0x00ab, TRY_LEAVE, TryCatch #4 {IOException -> 0x00ab, blocks: (B:17:0x00a7, B:44:0x00a0), top: B:2:0x000e }] */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m9616k(android.content.Context r8) {
        /*
            java.lang.String r8 = "/sys/class/power_supply/battery/capacity"
            java.lang.String r0 = "/sys/class/power_supply/usb/online"
            java.lang.String r1 = "\n"
            java.lang.String r2 = "/sys/class/power_supply/ac/online"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 0
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> La4
            r5.<init>(r2)     // Catch: java.lang.Throwable -> La4
            boolean r5 = r5.exists()     // Catch: java.lang.Throwable -> La4
            java.lang.String r6 = "|"
            if (r5 == 0) goto L3e
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> La4
            java.io.FileReader r7 = new java.io.FileReader     // Catch: java.lang.Throwable -> La4
            r7.<init>(r2)     // Catch: java.lang.Throwable -> La4
            r5.<init>(r7)     // Catch: java.lang.Throwable -> La4
            java.lang.String r2 = r5.readLine()     // Catch: java.lang.Throwable -> L3b
            if (r2 == 0) goto L36
            java.lang.String r4 = "ac_online"
            r3.append(r4)     // Catch: java.lang.Throwable -> L3b
            r3.append(r6)     // Catch: java.lang.Throwable -> L3b
            r3.append(r2)     // Catch: java.lang.Throwable -> L3b
        L36:
            r5.close()     // Catch: java.lang.Throwable -> L3b
            r4 = r5
            goto L3e
        L3b:
            r4 = r5
            goto La5
        L3e:
            r3.append(r1)     // Catch: java.lang.Throwable -> La4
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> La4
            r2.<init>(r0)     // Catch: java.lang.Throwable -> La4
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> La4
            if (r2 == 0) goto L6e
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> La4
            java.io.FileReader r5 = new java.io.FileReader     // Catch: java.lang.Throwable -> La4
            r5.<init>(r0)     // Catch: java.lang.Throwable -> La4
            r2.<init>(r5)     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L6c
            if (r0 == 0) goto L67
            java.lang.String r4 = "usb_online"
            r3.append(r4)     // Catch: java.lang.Throwable -> L6c
            r3.append(r6)     // Catch: java.lang.Throwable -> L6c
            r3.append(r0)     // Catch: java.lang.Throwable -> L6c
        L67:
            r2.close()     // Catch: java.lang.Throwable -> L6c
            r4 = r2
            goto L6e
        L6c:
            r4 = r2
            goto La5
        L6e:
            r3.append(r1)     // Catch: java.lang.Throwable -> La4
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> La4
            r0.<init>(r8)     // Catch: java.lang.Throwable -> La4
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> La4
            if (r0 == 0) goto L9d
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> La4
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> La4
            r1.<init>(r8)     // Catch: java.lang.Throwable -> La4
            r0.<init>(r1)     // Catch: java.lang.Throwable -> La4
            java.lang.String r8 = r0.readLine()     // Catch: java.lang.Throwable -> L9b
            if (r8 == 0) goto L97
            java.lang.String r1 = "battery_capacity"
            r3.append(r1)     // Catch: java.lang.Throwable -> L9b
            r3.append(r6)     // Catch: java.lang.Throwable -> L9b
            r3.append(r8)     // Catch: java.lang.Throwable -> L9b
        L97:
            r0.close()     // Catch: java.lang.Throwable -> L9b
            goto L9e
        L9b:
            r4 = r0
            goto La5
        L9d:
            r0 = r4
        L9e:
            if (r0 == 0) goto Laf
            r0.close()     // Catch: java.io.IOException -> Lab
            goto Laf
        La4:
        La5:
            if (r4 == 0) goto Laf
            r4.close()     // Catch: java.io.IOException -> Lab
            goto Laf
        Lab:
            r8 = move-exception
            com.tencent.bugly.proguard.C3151an.m9916a(r8)
        Laf:
            java.lang.String r8 = r3.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C3114b.m9616k(android.content.Context):java.lang.String");
    }

    /* renamed from: p */
    public static boolean m9626p(Context context) {
        return (((m9628q(context) | m9629r()) | m9630s()) | m9627q()) > 0;
    }

    /* renamed from: o */
    public static String m9624o(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            String[] strArr = f10220b;
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

    /* renamed from: h */
    public static String m9610h(Context context) {
        return C3154aq.m9979b(context, "ro.board.platform");
    }

    /* renamed from: i */
    public static String m9612i(Context context) {
        StringBuilder sb = new StringBuilder();
        String m9979b = C3154aq.m9979b(context, "ro.genymotion.version");
        if (m9979b != null) {
            sb.append("ro.genymotion.version");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(m9979b);
            sb.append("\n");
        }
        String m9979b2 = C3154aq.m9979b(context, "androVM.vbox_dpi");
        if (m9979b2 != null) {
            sb.append("androVM.vbox_dpi");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(m9979b2);
            sb.append("\n");
        }
        String m9979b3 = C3154aq.m9979b(context, "qemu.sf.fake_camera");
        if (m9979b3 != null) {
            sb.append("qemu.sf.fake_camera");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(m9979b3);
        }
        return sb.toString();
    }
}
