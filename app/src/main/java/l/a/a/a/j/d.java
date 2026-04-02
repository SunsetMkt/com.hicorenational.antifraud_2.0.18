package l.a.a.a.j;

import android.content.Context;
import android.util.Log;
import cn.cloudwalk.util.LogUtils;
import java.io.File;
import l.a.a.a.j.b;

/* JADX INFO: compiled from: LogHnIDAdpater.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends b {

    /* JADX INFO: renamed from: b */
    private static final l.a.a.a.j.a f12672b = new l.a.a.a.j.a();

    /* JADX INFO: renamed from: c */
    private static String f12673c = b.a();

    /* JADX INFO: renamed from: d */
    private static d f12674d;

    /* JADX INFO: compiled from: LogHnIDAdpater.java */
    static class a extends Thread {
        private Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                try {
                    String strB = b.a.b(this.a);
                    b.a.a(this.a);
                    d.b(strB);
                    d.f12672b.a(new File(strB, "honorid_advanced_log.txt"));
                    c.a(d.f12672b);
                } catch (ArrayIndexOutOfBoundsException e2) {
                    String str = "ArrayIndexOutOfBoundsException" + e2.getMessage();
                    b.a.a(this.a);
                } catch (Exception e3) {
                    String str2 = LogUtils.LOG_EXCEPTION + e3.getClass().getSimpleName();
                    b.a.a(this.a);
                }
            } catch (Throwable th) {
                b.a.a(this.a);
                throw th;
            }
        }
    }

    private d(Context context) {
        new a(context).start();
    }

    @Override // l.a.a.a.j.b
    public void c(String str, String str2) {
        a(4, str, str2, null, 2);
        c.b(str, str2);
    }

    private static synchronized void a(int i2, String str, String str2, Throwable th, int i3) {
        if (a(i2)) {
            if (str2 == null) {
                str2 = "";
            }
            try {
                Log.println(i2, f12673c + str, str2);
            } catch (IllegalArgumentException e2) {
                String str3 = "println IllegalArgumentException" + e2.getMessage();
            } catch (Exception e3) {
                String str4 = "println Exception" + e3.getClass().getSimpleName();
            }
        }
    }

    public static synchronized d b(Context context) {
        if (f12674d == null) {
            f12674d = new d(context);
            f12673c = b.a(context);
        }
        return f12674d;
    }

    private static boolean a(int i2) {
        return Log.isLoggable("honorid", i2);
    }

    public static void b(String str) {
        File file = new File(str, "apphnid.txt");
        File file2 = new File(str, "apphnid.txt.bak");
        l.a.a.a.c.a(file);
        l.a.a.a.c.a(file2);
    }

    @Override // l.a.a.a.j.b
    public void a(String str, String str2) {
        a(3, str, str2, null, 2);
    }

    @Override // l.a.a.a.j.b
    public void b(String str, String str2) {
        a(6, str, str2, null, 2);
        c.a(str, str2);
    }
}
