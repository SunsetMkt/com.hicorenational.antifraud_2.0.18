package p358k.p359a.p360a.p361a.p363j;

import android.content.Context;
import android.util.Log;
import cn.cloudwalk.util.LogUtils;
import java.io.File;
import p358k.p359a.p360a.p361a.C5849c;
import p358k.p359a.p360a.p361a.p363j.AbstractC5860b;

/* compiled from: LogHnIDAdpater.java */
/* renamed from: k.a.a.a.j.d */
/* loaded from: classes2.dex */
public final class C5862d extends AbstractC5860b {

    /* renamed from: b */
    private static final RunnableC5859a f21146b = new RunnableC5859a();

    /* renamed from: c */
    private static String f21147c = AbstractC5860b.m24665a();

    /* renamed from: d */
    private static C5862d f21148d;

    /* compiled from: LogHnIDAdpater.java */
    /* renamed from: k.a.a.a.j.d$a */
    static class a extends Thread {

        /* renamed from: a */
        private Context f21149a;

        a(Context context) {
            this.f21149a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                try {
                    String m24673b = AbstractC5860b.a.m24673b(this.f21149a);
                    AbstractC5860b.a.m24670a(this.f21149a);
                    C5862d.m24689b(m24673b);
                    C5862d.f21146b.m24663a(new File(m24673b, "honorid_advanced_log.txt"));
                    C5861c.m24679a(C5862d.f21146b);
                } catch (ArrayIndexOutOfBoundsException e2) {
                    String str = "ArrayIndexOutOfBoundsException" + e2.getMessage();
                    AbstractC5860b.a.m24670a(this.f21149a);
                } catch (Exception e3) {
                    String str2 = LogUtils.LOG_EXCEPTION + e3.getClass().getSimpleName();
                    AbstractC5860b.a.m24670a(this.f21149a);
                }
            } catch (Throwable th) {
                AbstractC5860b.a.m24670a(this.f21149a);
                throw th;
            }
        }
    }

    private C5862d(Context context) {
        new a(context).start();
    }

    @Override // p358k.p359a.p360a.p361a.p363j.AbstractC5860b
    /* renamed from: c */
    public void mo24669c(String str, String str2) {
        m24684a(4, str, str2, null, 2);
        C5861c.m24682b(str, str2);
    }

    /* renamed from: a */
    private static synchronized void m24684a(int i2, String str, String str2, Throwable th, int i3) {
        synchronized (C5862d.class) {
            if (m24686a(i2)) {
                if (str2 == null) {
                    str2 = "";
                }
                try {
                    Log.println(i2, f21147c + str, str2);
                } catch (IllegalArgumentException e2) {
                    String str3 = "println IllegalArgumentException" + e2.getMessage();
                } catch (Exception e3) {
                    String str4 = "println Exception" + e3.getClass().getSimpleName();
                }
            }
        }
    }

    /* renamed from: b */
    public static synchronized C5862d m24688b(Context context) {
        C5862d c5862d;
        synchronized (C5862d.class) {
            if (f21148d == null) {
                f21148d = new C5862d(context);
                f21147c = AbstractC5860b.m24666a(context);
            }
            c5862d = f21148d;
        }
        return c5862d;
    }

    /* renamed from: a */
    private static boolean m24686a(int i2) {
        return Log.isLoggable("honorid", i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m24689b(String str) {
        File file = new File(str, "apphnid.txt");
        File file2 = new File(str, "apphnid.txt.bak");
        C5849c.m24631a(file);
        C5849c.m24631a(file2);
    }

    @Override // p358k.p359a.p360a.p361a.p363j.AbstractC5860b
    /* renamed from: a */
    public void mo24667a(String str, String str2) {
        m24684a(3, str, str2, null, 2);
    }

    @Override // p358k.p359a.p360a.p361a.p363j.AbstractC5860b
    /* renamed from: b */
    public void mo24668b(String str, String str2) {
        m24684a(6, str, str2, null, 2);
        C5861c.m24678a(str, str2);
    }
}
