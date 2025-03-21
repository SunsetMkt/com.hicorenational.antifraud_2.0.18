package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import com.heytap.mcssdk.constant.C2084a;
import com.tencent.bugly.crashreport.InterfaceC3108a;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.crashreport.common.info.C3114b;
import com.tencent.bugly.crashreport.common.strategy.C3116a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.C3126b;
import com.tencent.bugly.crashreport.crash.C3127c;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C3150am;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3153ap;
import com.tencent.bugly.proguard.C3154aq;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import p000a.p001a.p014u.C0052a;
import p245d.C4443d;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class NativeCrashHandler implements InterfaceC3108a {

    /* renamed from: a */
    private static NativeCrashHandler f10436a = null;

    /* renamed from: l */
    private static boolean f10437l = false;

    /* renamed from: m */
    private static boolean f10438m = false;

    /* renamed from: o */
    private static boolean f10439o = true;

    /* renamed from: b */
    private final Context f10440b;

    /* renamed from: c */
    private final C3113a f10441c;

    /* renamed from: d */
    private final C3150am f10442d;

    /* renamed from: e */
    private NativeExceptionHandler f10443e;

    /* renamed from: f */
    private String f10444f;

    /* renamed from: g */
    private final boolean f10445g;

    /* renamed from: h */
    private boolean f10446h = false;

    /* renamed from: i */
    private boolean f10447i = false;

    /* renamed from: j */
    private boolean f10448j = false;

    /* renamed from: k */
    private boolean f10449k = false;

    /* renamed from: n */
    private C3126b f10450n;

    @SuppressLint({"SdCardPath"})
    protected NativeCrashHandler(Context context, C3113a c3113a, C3126b c3126b, C3116a c3116a, C3150am c3150am, boolean z, String str) {
        this.f10440b = C3154aq.m9946a(context);
        try {
            if (C3154aq.m9970a(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + C3113a.m9531a(context).f10196d + "/app_bugly";
        }
        this.f10450n = c3126b;
        this.f10444f = str;
        this.f10441c = c3113a;
        this.f10442d = c3150am;
        this.f10445g = z;
        this.f10443e = new C3134a(context, c3113a, c3126b, C3116a.m9635a());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, C3113a c3113a, C3126b c3126b, C3116a c3116a, C3150am c3150am, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f10436a == null) {
                f10436a = new NativeCrashHandler(context, c3113a, c3126b, c3116a, c3150am, z, str);
            }
            nativeCrashHandler = f10436a;
        }
        return nativeCrashHandler;
    }

    public static boolean isShouldHandleInJava() {
        return f10439o;
    }

    public static void setShouldHandleInJava(boolean z) {
        f10439o = z;
        NativeCrashHandler nativeCrashHandler = f10436a;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.m9767a(999, "" + z);
        }
    }

    @Override // com.tencent.bugly.crashreport.InterfaceC3108a
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f10446h || this.f10447i) && f10437l && str != null && str2 != null && str3 != null) {
            try {
                if (this.f10447i) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) C3154aq.m9950a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f10437l = false;
            } catch (Throwable th) {
                if (!C3151an.m9916a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f10442d.m9908a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public void run() {
                if (!C3154aq.m9967a(NativeCrashHandler.this.f10440b, "native_record_lock", C2084a.f6135q)) {
                    C3151an.m9915a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.f10439o) {
                    NativeCrashHandler.this.m9767a(999, C0052a.f159k);
                }
                CrashDetailBean m9779a = C3135b.m9779a(NativeCrashHandler.this.f10440b, NativeCrashHandler.this.f10444f, NativeCrashHandler.this.f10443e);
                if (m9779a != null) {
                    C3151an.m9915a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.f10450n.m9694a(m9779a)) {
                        NativeCrashHandler.this.f10450n.m9691a(m9779a, 3000L, false);
                    }
                    C3135b.m9785a(false, NativeCrashHandler.this.f10444f);
                }
                NativeCrashHandler.this.m9777b();
                C3154aq.m9994c(NativeCrashHandler.this.f10440b, "native_record_lock");
            }
        });
    }

    public boolean filterSigabrtSysLog() {
        return m9767a(C4443d.f16957h, C0052a.f158j);
    }

    public synchronized String getDumpFilePath() {
        return this.f10444f;
    }

    @Override // com.tencent.bugly.crashreport.InterfaceC3108a
    public String getLogFromNative() {
        if ((!this.f10446h && !this.f10447i) || !f10437l) {
            return null;
        }
        try {
            return this.f10447i ? getNativeLog() : (String) C3154aq.m9950a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
        } catch (UnsatisfiedLinkError unused) {
            f10437l = false;
            return null;
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f10443e;
    }

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    public synchronized boolean isUserOpened() {
        return this.f10449k;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f10230g != this.f10448j) {
                C3151an.m9922d("server native changed to %b", Boolean.valueOf(strategyBean.f10230g));
            }
        }
        boolean z = C3116a.m9635a().m9644c().f10230g && this.f10449k;
        if (z != this.f10448j) {
            C3151an.m9915a("native changed to %b", Boolean.valueOf(z));
            m9778b(z);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f10446h || this.f10447i) && f10437l && str != null && str2 != null) {
            try {
                if (this.f10447i) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) C3154aq.m9950a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f10437l = false;
            } catch (Throwable th) {
                if (!C3151an.m9916a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z, int i2);

    public void removeEmptyNativeRecordFiles() {
        C3135b.m9790d(this.f10444f);
    }

    protected native String removeNativeKeyValue(String str);

    public synchronized void setDumpFilePath(String str) {
        this.f10444f = str;
    }

    public boolean setNativeAppChannel(String str) {
        return m9767a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return m9767a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return m9767a(10, str);
    }

    protected native void setNativeInfo(int i2, String str);

    @Override // com.tencent.bugly.crashreport.InterfaceC3108a
    public boolean setNativeIsAppForeground(boolean z) {
        return m9767a(14, z ? C0052a.f158j : C0052a.f159k);
    }

    public boolean setNativeLaunchTime(long j2) {
        try {
            return m9767a(15, String.valueOf(j2));
        } catch (NumberFormatException e2) {
            if (C3151an.m9916a(e2)) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return m9767a(11, str);
    }

    public synchronized void setUserOpened(boolean z) {
        m9772c(z);
        boolean isUserOpened = isUserOpened();
        C3116a m9635a = C3116a.m9635a();
        if (m9635a != null) {
            isUserOpened = isUserOpened && m9635a.m9644c().f10230g;
        }
        if (isUserOpened != this.f10448j) {
            C3151an.m9915a("native changed to %b", Boolean.valueOf(isUserOpened));
            m9778b(isUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        String str;
        if (!this.f10447i && !this.f10446h) {
            String str2 = "Bugly";
            boolean z = !C3154aq.m9970a(this.f10441c.f10212t);
            if (C3127c.f10361b) {
                if (z) {
                    str = this.f10441c.f10212t;
                } else {
                    str = "Bugly-rqd";
                }
                this.f10447i = m9769a(str, z);
                if (!this.f10447i && !z) {
                    this.f10446h = m9769a("NativeRQD", false);
                }
            } else {
                String str3 = this.f10441c.f10212t;
                if (z) {
                    str2 = str3;
                } else {
                    this.f10441c.getClass();
                }
                this.f10447i = m9769a(str2, z);
            }
            if (this.f10447i || this.f10446h) {
                m9776a(this.f10445g);
                if (f10437l) {
                    setNativeAppVersion(this.f10441c.f10208p);
                    setNativeAppChannel(this.f10441c.f10211s);
                    setNativeAppPackage(this.f10441c.f10196d);
                    setNativeUserId(this.f10441c.m9573g());
                    setNativeIsAppForeground(this.f10441c.m9559a());
                    setNativeLaunchTime(this.f10441c.f10160a);
                }
                return;
            }
            return;
        }
        m9776a(this.f10445g);
    }

    protected native void testCrash();

    public void testNativeCrash() {
        if (this.f10447i) {
            testCrash();
        } else {
            C3151an.m9922d("[Native] Bugly SO file has not been load.", new Object[0]);
        }
    }

    protected native String unregist();

    /* renamed from: b */
    protected void m9777b() {
        long m9978b = C3154aq.m9978b() - C3127c.f10366g;
        long m9978b2 = C3154aq.m9978b() + 86400000;
        File file = new File(this.f10444f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (lastModified < m9978b || lastModified >= m9978b2) {
                            C3151an.m9915a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i2++;
                            if (file2.delete()) {
                                i3++;
                            }
                        }
                    }
                    C3151an.m9921c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                }
            } catch (Throwable th) {
                C3151an.m9916a(th);
            }
        }
    }

    /* renamed from: a */
    private static void m9766a(String str) {
        C3151an.m9921c("[Native] Check extra jni for Bugly NDK v%s", str);
        String replace = "2.1.1".replace(".", "");
        String replace2 = "2.3.0".replace(".", "");
        String replace3 = str.replace(".", "");
        if (replace3.length() == 2) {
            replace3 = replace3 + "0";
        } else if (replace3.length() == 1) {
            replace3 = replace3 + "00";
        }
        try {
            if (Integer.parseInt(replace3) >= Integer.parseInt(replace)) {
                f10437l = true;
            }
            if (Integer.parseInt(replace3) >= Integer.parseInt(replace2)) {
                f10438m = true;
            }
        } catch (Throwable unused) {
        }
        if (f10438m) {
            C3151an.m9915a("[Native] Info setting jni can be accessed.", new Object[0]);
        } else {
            C3151an.m9922d("[Native] Info setting jni can not be accessed.", new Object[0]);
        }
        if (f10437l) {
            C3151an.m9915a("[Native] Extra jni can be accessed.", new Object[0]);
        } else {
            C3151an.m9922d("[Native] Extra jni can not be accessed.", new Object[0]);
        }
    }

    /* renamed from: c */
    private synchronized void m9772c(boolean z) {
        if (this.f10449k != z) {
            C3151an.m9915a("user change native %b", Boolean.valueOf(z));
            this.f10449k = z;
        }
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f10436a;
        }
        return nativeCrashHandler;
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        m9767a(16, "" + z);
        m9767a(17, "" + z2);
        m9767a(18, "" + z3);
        testNativeCrash();
    }

    /* renamed from: b */
    protected synchronized void m9778b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            m9775a();
        }
    }

    /* renamed from: a */
    protected synchronized void m9776a(boolean z) {
        if (this.f10448j) {
            C3151an.m9922d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.f10447i) {
            try {
                String regist = regist(this.f10444f, z, 1);
                if (regist != null) {
                    C3151an.m9915a("[Native] Native Crash Report enable.", new Object[0]);
                    m9766a(regist);
                    this.f10441c.f10213u = regist;
                    String concat = Constants.ACCEPT_TIME_SEPARATOR_SERVER.concat(this.f10441c.f10213u);
                    if (!C3127c.f10361b && !this.f10441c.f10202j.contains(concat)) {
                        this.f10441c.f10202j = this.f10441c.f10202j.concat(Constants.ACCEPT_TIME_SEPARATOR_SERVER).concat(this.f10441c.f10213u);
                    }
                    C3151an.m9915a("comInfo.sdkVersion %s", this.f10441c.f10202j);
                    C3153ap.m9933a(f10437l);
                    this.f10448j = true;
                    return;
                }
            } catch (Throwable unused) {
                C3151an.m9921c("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.f10446h) {
            try {
                Class[] clsArr = {String.class, String.class, Integer.TYPE, Integer.TYPE};
                Object[] objArr = new Object[4];
                objArr[0] = this.f10444f;
                objArr[1] = C3114b.m9596a(this.f10440b, false);
                objArr[2] = Integer.valueOf(z ? 1 : 5);
                objArr[3] = 1;
                String str = (String) C3154aq.m9950a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, clsArr, objArr);
                if (str == null) {
                    str = (String) C3154aq.m9950a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, new Class[]{String.class, String.class, Integer.TYPE}, new Object[]{this.f10444f, C3114b.m9596a(this.f10440b, false), Integer.valueOf(C3113a.m9532b().m9545K())});
                }
                if (str != null) {
                    this.f10448j = true;
                    this.f10441c.f10213u = str;
                    Boolean bool = (Boolean) C3154aq.m9950a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", null, new Class[]{String.class}, new Object[]{str});
                    if (bool != null) {
                        f10437l = bool.booleanValue();
                        C3153ap.m9933a(f10437l);
                    }
                    C3154aq.m9950a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{true});
                    C3154aq.m9950a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(z ? 1 : 5)});
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        this.f10447i = false;
        this.f10446h = false;
    }

    /* renamed from: a */
    private boolean m9769a(String str, boolean z) {
        boolean z2;
        try {
            C3151an.m9915a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                C3151an.m9915a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                C3151an.m9922d(th.getMessage(), new Object[0]);
                C3151an.m9922d("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    /* renamed from: a */
    protected synchronized void m9775a() {
        if (!this.f10448j) {
            C3151an.m9922d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                C3151an.m9915a("[Native] Successfully closed native crash report.", new Object[0]);
                this.f10448j = false;
                return;
            }
        } catch (Throwable unused) {
            C3151an.m9921c("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            C3154aq.m9950a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{false});
            this.f10448j = false;
            C3151an.m9915a("[Native] Successfully closed native crash report.", new Object[0]);
        } catch (Throwable unused2) {
            C3151an.m9921c("[Native] Failed to close native crash report.", new Object[0]);
            this.f10447i = false;
            this.f10446h = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m9767a(int i2, String str) {
        if (this.f10447i && f10438m) {
            try {
                setNativeInfo(i2, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                f10438m = false;
            } catch (Throwable th) {
                if (!C3151an.m9916a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }
}
