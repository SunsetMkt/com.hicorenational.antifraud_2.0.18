package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.C3113a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ap */
/* loaded from: classes2.dex */
public class C3153ap {

    /* renamed from: a */
    public static boolean f10574a = true;

    /* renamed from: b */
    private static SimpleDateFormat f10575b = null;

    /* renamed from: c */
    private static int f10576c = 5120;

    /* renamed from: d */
    private static StringBuilder f10577d = null;

    /* renamed from: e */
    private static StringBuilder f10578e = null;

    /* renamed from: f */
    private static boolean f10579f = false;

    /* renamed from: g */
    private static a f10580g = null;

    /* renamed from: h */
    private static String f10581h = null;

    /* renamed from: i */
    private static String f10582i = null;

    /* renamed from: j */
    private static Context f10583j = null;

    /* renamed from: k */
    private static String f10584k = null;

    /* renamed from: l */
    private static boolean f10585l = false;

    /* renamed from: m */
    private static boolean f10586m = false;

    /* renamed from: n */
    private static ExecutorService f10587n;

    /* renamed from: o */
    private static int f10588o;

    /* renamed from: p */
    private static final Object f10589p = new Object();

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.ap$a */
    public static class a {

        /* renamed from: a */
        private boolean f10596a;

        /* renamed from: b */
        private File f10597b;

        /* renamed from: c */
        private String f10598c;

        /* renamed from: d */
        private long f10599d;

        /* renamed from: e */
        private long f10600e = 30720;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f10598c = str;
            this.f10596a = m9941a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public boolean m9941a() {
            try {
                this.f10597b = new File(this.f10598c);
                if (this.f10597b.exists() && !this.f10597b.delete()) {
                    this.f10596a = false;
                    return false;
                }
                if (this.f10597b.createNewFile()) {
                    return true;
                }
                this.f10596a = false;
                return false;
            } catch (Throwable th) {
                C3151an.m9916a(th);
                this.f10596a = false;
                return false;
            }
        }

        /* renamed from: a */
        public boolean m9945a(String str) {
            FileOutputStream fileOutputStream;
            if (!this.f10596a) {
                return false;
            }
            try {
                fileOutputStream = new FileOutputStream(this.f10597b, true);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
                fileOutputStream.close();
                this.f10599d += r10.length;
                this.f10596a = true;
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Throwable th2) {
                th = th2;
                try {
                    C3151an.m9916a(th);
                    this.f10596a = false;
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
            f10575b = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static synchronized void m9930a(Context context) {
        synchronized (C3153ap.class) {
            if (f10585l || context == null || !f10574a) {
                return;
            }
            try {
                f10587n = Executors.newSingleThreadExecutor();
                f10578e = new StringBuilder(0);
                f10577d = new StringBuilder(0);
                f10583j = context;
                C3113a m9531a = C3113a.m9531a(context);
                f10581h = m9531a.f10197e;
                m9531a.getClass();
                f10582i = "";
                f10584k = f10583j.getFilesDir().getPath() + "/buglylog_" + f10581h + AbstractC1191a.f2606s1 + f10582i + ".txt";
                f10588o = Process.myPid();
            } catch (Throwable unused) {
            }
            f10585l = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static boolean m9938d(String str, String str2, String str3) {
        try {
            C3113a m9532b = C3113a.m9532b();
            if (m9532b == null || m9532b.f10148O == null) {
                return false;
            }
            return m9532b.f10148O.appendLogToNative(str, str2, str3);
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static synchronized void m9939e(String str, String str2, String str3) {
        synchronized (C3153ap.class) {
            String m9928a = m9928a(str, str2, str3, Process.myTid());
            synchronized (f10589p) {
                try {
                    f10578e.append(m9928a);
                } catch (Throwable unused) {
                }
                if (f10578e.length() <= f10576c) {
                    return;
                }
                if (f10579f) {
                    return;
                }
                f10579f = true;
                if (f10580g == null) {
                    f10580g = new a(f10584k);
                } else if (f10580g.f10597b == null || f10580g.f10597b.length() + f10578e.length() > f10580g.f10600e) {
                    f10580g.m9941a();
                }
                if (f10580g.m9945a(f10578e.toString())) {
                    f10578e.setLength(0);
                    f10579f = false;
                }
            }
        }
    }

    /* renamed from: b */
    private static String m9935b() {
        try {
            C3113a m9532b = C3113a.m9532b();
            if (m9532b == null || m9532b.f10148O == null) {
                return null;
            }
            return m9532b.f10148O.getLogFromNative();
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static void m9929a(int i2) {
        synchronized (f10589p) {
            f10576c = i2;
            if (i2 < 0) {
                f10576c = 0;
            } else if (i2 > 10240) {
                f10576c = 10240;
            }
        }
    }

    /* renamed from: a */
    public static void m9933a(boolean z) {
        C3151an.m9915a("[LogUtil] Whether can record user log into native: " + z, new Object[0]);
        f10586m = z;
    }

    /* renamed from: a */
    public static void m9932a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        m9931a(str, str2, message + '\n' + C3154aq.m9980b(th));
    }

    /* renamed from: a */
    public static synchronized void m9931a(final String str, final String str2, final String str3) {
        synchronized (C3153ap.class) {
            if (f10585l && f10574a) {
                try {
                    if (f10586m) {
                        f10587n.execute(new Runnable() { // from class: com.tencent.bugly.proguard.ap.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (C3153ap.m9938d(str, str2, str3)) {
                                }
                            }
                        });
                    } else {
                        f10587n.execute(new Runnable() { // from class: com.tencent.bugly.proguard.ap.2
                            @Override // java.lang.Runnable
                            public void run() {
                                C3153ap.m9939e(str, str2, str3);
                            }
                        });
                    }
                } catch (Exception e2) {
                    C3151an.m9919b(e2);
                }
            }
        }
    }

    /* renamed from: a */
    private static String m9928a(String str, String str2, String str3, long j2) {
        String date;
        f10577d.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = f10575b;
        if (simpleDateFormat != null) {
            date = simpleDateFormat.format(date2);
        } else {
            date = date2.toString();
        }
        StringBuilder sb = f10577d;
        sb.append(date);
        sb.append(AbstractC1191a.f2568g);
        sb.append(f10588o);
        sb.append(AbstractC1191a.f2568g);
        sb.append(j2);
        sb.append(AbstractC1191a.f2568g);
        sb.append(str);
        sb.append(AbstractC1191a.f2568g);
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return f10577d.toString();
    }

    /* renamed from: a */
    public static byte[] m9934a() {
        if (!f10574a) {
            return null;
        }
        if (f10586m) {
            C3151an.m9915a("[LogUtil] Get user log from native.", new Object[0]);
            String m9935b = m9935b();
            if (m9935b != null) {
                C3151an.m9915a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(m9935b.length()));
                return C3154aq.m9974a((File) null, m9935b, "BuglyNativeLog.txt");
            }
        }
        StringBuilder sb = new StringBuilder();
        synchronized (f10589p) {
            if (f10580g != null && f10580g.f10596a && f10580g.f10597b != null && f10580g.f10597b.length() > 0) {
                sb.append(C3154aq.m9955a(f10580g.f10597b, 30720, true));
            }
            if (f10578e != null && f10578e.length() > 0) {
                sb.append(f10578e.toString());
            }
        }
        return C3154aq.m9974a((File) null, sb.toString(), "BuglyLog.txt");
    }
}
