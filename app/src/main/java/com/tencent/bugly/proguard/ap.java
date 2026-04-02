package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class ap {
    public static boolean a = true;

    /* JADX INFO: renamed from: b */
    private static SimpleDateFormat f6412b = null;

    /* JADX INFO: renamed from: c */
    private static int f6413c = 5120;

    /* JADX INFO: renamed from: d */
    private static StringBuilder f6414d = null;

    /* JADX INFO: renamed from: e */
    private static StringBuilder f6415e = null;

    /* JADX INFO: renamed from: f */
    private static boolean f6416f = false;

    /* JADX INFO: renamed from: g */
    private static a f6417g = null;

    /* JADX INFO: renamed from: h */
    private static String f6418h = null;

    /* JADX INFO: renamed from: i */
    private static String f6419i = null;

    /* JADX INFO: renamed from: j */
    private static Context f6420j = null;

    /* JADX INFO: renamed from: k */
    private static String f6421k = null;

    /* JADX INFO: renamed from: l */
    private static boolean f6422l = false;

    /* JADX INFO: renamed from: m */
    private static boolean f6423m = false;

    /* JADX INFO: renamed from: n */
    private static ExecutorService f6424n;
    private static int o;
    private static final Object p = new Object();

    /* JADX INFO: renamed from: com.tencent.bugly.proguard.ap$1 */
    /* JADX INFO: compiled from: BUGLY */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f6425b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ String f6426c;

        AnonymousClass1(String str, String str2, String str3) {
            str = str;
            str = str2;
            str = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ap.d(str, str, str)) {
            }
        }
    }

    /* JADX INFO: renamed from: com.tencent.bugly.proguard.ap$2 */
    /* JADX INFO: compiled from: BUGLY */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f6427b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ String f6428c;

        AnonymousClass2(String str, String str2, String str3) {
            str = str;
            str = str2;
            str = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            ap.e(str, str, str);
        }
    }

    /* JADX INFO: compiled from: BUGLY */
    public static class a {
        private boolean a;

        /* JADX INFO: renamed from: b */
        private File f6429b;

        /* JADX INFO: renamed from: c */
        private String f6430c;

        /* JADX INFO: renamed from: d */
        private long f6431d;

        /* JADX INFO: renamed from: e */
        private long f6432e = 30720;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f6430c = str;
            this.a = a();
        }

        public boolean a() {
            try {
                this.f6429b = new File(this.f6430c);
                if (this.f6429b.exists() && !this.f6429b.delete()) {
                    this.a = false;
                    return false;
                }
                if (this.f6429b.createNewFile()) {
                    return true;
                }
                this.a = false;
                return false;
            } catch (Throwable th) {
                an.a(th);
                this.a = false;
                return false;
            }
        }

        public boolean a(String str) {
            FileOutputStream fileOutputStream;
            if (!this.a) {
                return false;
            }
            try {
                fileOutputStream = new FileOutputStream(this.f6429b, true);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                byte[] bytes = str.getBytes("UTF-8");
                fileOutputStream.write(bytes);
                fileOutputStream.flush();
                fileOutputStream.close();
                this.f6431d += (long) bytes.length;
                this.a = true;
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Throwable th2) {
                th = th2;
                try {
                    an.a(th);
                    this.a = false;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    static {
        try {
            f6412b = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable unused) {
        }
    }

    public static synchronized void a(Context context) {
        if (f6422l || context == null || !a) {
            return;
        }
        try {
            f6424n = Executors.newSingleThreadExecutor();
            f6415e = new StringBuilder(0);
            f6414d = new StringBuilder(0);
            f6420j = context;
            com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(context);
            f6418h = aVarA.f6176e;
            aVarA.getClass();
            f6419i = "";
            f6421k = f6420j.getFilesDir().getPath() + "/buglylog_" + f6418h + d.c.a.b.a.a.s1 + f6419i + ".txt";
            o = Process.myPid();
        } catch (Throwable unused) {
        }
        f6422l = true;
    }

    public static boolean d(String str, String str2, String str3) {
        try {
            com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
            if (aVarB == null || aVarB.O == null) {
                return false;
            }
            return aVarB.O.appendLogToNative(str, str2, str3);
        } catch (Throwable th) {
            if (an.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public static synchronized void e(String str, String str2, String str3) {
        String strA = a(str, str2, str3, Process.myTid());
        synchronized (p) {
            try {
                f6415e.append(strA);
                if (f6415e.length() <= f6413c) {
                    return;
                }
                if (f6416f) {
                    return;
                }
                f6416f = true;
                if (f6417g == null) {
                    f6417g = new a(f6421k);
                } else if (f6417g.f6429b == null || f6417g.f6429b.length() + ((long) f6415e.length()) > f6417g.f6432e) {
                    f6417g.a();
                }
                if (f6417g.a(f6415e.toString())) {
                    f6415e.setLength(0);
                    f6416f = false;
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String b() {
        try {
            com.tencent.bugly.crashreport.common.info.a aVarB = com.tencent.bugly.crashreport.common.info.a.b();
            if (aVarB == null || aVarB.O == null) {
                return null;
            }
            return aVarB.O.getLogFromNative();
        } catch (Throwable th) {
            if (an.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static void a(int i2) {
        synchronized (p) {
            f6413c = i2;
            if (i2 < 0) {
                f6413c = 0;
            } else if (i2 > 10240) {
                f6413c = 10240;
            }
        }
    }

    public static void a(boolean z) {
        an.a("[LogUtil] Whether can record user log into native: " + z, new Object[0]);
        f6423m = z;
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        a(str, str2, message + '\n' + aq.b(th));
    }

    public static synchronized void a(String str, String str2, String str3) {
        if (f6422l && a) {
            try {
                if (f6423m) {
                    f6424n.execute(new Runnable() { // from class: com.tencent.bugly.proguard.ap.1
                        final /* synthetic */ String a;

                        /* JADX INFO: renamed from: b */
                        final /* synthetic */ String f6425b;

                        /* JADX INFO: renamed from: c */
                        final /* synthetic */ String f6426c;

                        AnonymousClass1(String str4, String str22, String str32) {
                            str = str4;
                            str = str22;
                            str = str32;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (ap.d(str, str, str)) {
                            }
                        }
                    });
                } else {
                    f6424n.execute(new Runnable() { // from class: com.tencent.bugly.proguard.ap.2
                        final /* synthetic */ String a;

                        /* JADX INFO: renamed from: b */
                        final /* synthetic */ String f6427b;

                        /* JADX INFO: renamed from: c */
                        final /* synthetic */ String f6428c;

                        AnonymousClass2(String str4, String str22, String str32) {
                            str = str4;
                            str = str22;
                            str = str32;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            ap.e(str, str, str);
                        }
                    });
                }
            } catch (Exception e2) {
                an.b(e2);
            }
        }
    }

    private static String a(String str, String str2, String str3, long j2) {
        String string;
        f6414d.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = f6412b;
        if (simpleDateFormat != null) {
            string = simpleDateFormat.format(date);
        } else {
            string = date.toString();
        }
        StringBuilder sb = f6414d;
        sb.append(string);
        sb.append(d.c.a.b.a.a.f10074g);
        sb.append(o);
        sb.append(d.c.a.b.a.a.f10074g);
        sb.append(j2);
        sb.append(d.c.a.b.a.a.f10074g);
        sb.append(str);
        sb.append(d.c.a.b.a.a.f10074g);
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return f6414d.toString();
    }

    public static byte[] a() {
        if (!a) {
            return null;
        }
        if (f6423m) {
            an.a("[LogUtil] Get user log from native.", new Object[0]);
            String strB = b();
            if (strB != null) {
                an.a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(strB.length()));
                return aq.a((File) null, strB, "BuglyNativeLog.txt");
            }
        }
        StringBuilder sb = new StringBuilder();
        synchronized (p) {
            if (f6417g != null && f6417g.a && f6417g.f6429b != null && f6417g.f6429b.length() > 0) {
                sb.append(aq.a(f6417g.f6429b, 30720, true));
            }
            if (f6415e != null && f6415e.length() > 0) {
                sb.append(f6415e.toString());
            }
        }
        return aq.a((File) null, sb.toString(), "BuglyLog.txt");
    }
}
