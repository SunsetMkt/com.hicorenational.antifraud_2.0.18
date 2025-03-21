package util;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.webkit.WebView;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a;
import com.just.agentweb.AgentWebConfig;
import com.just.agentweb.LollipopFixedWebView;
import java.io.File;
import java.math.BigDecimal;
import java.util.Date;

/* compiled from: DataCleanManager.java */
/* renamed from: util.a1 */
/* loaded from: classes2.dex */
public class C7253a1 {

    /* renamed from: a */
    private static final String f25102a = "DataCleanManager";

    /* compiled from: DataCleanManager.java */
    /* renamed from: util.a1$a */
    static class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ File f25103a;

        a(File file) {
            this.f25103a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] listFiles;
            File file = this.f25103a;
            if (file == null || !file.exists() || !this.f25103a.isDirectory() || (listFiles = this.f25103a.listFiles()) == null || listFiles.length <= 0) {
                return;
            }
            for (File file2 : this.f25103a.listFiles()) {
                if (file2.isDirectory()) {
                    C7253a1.m26143b(file2);
                    file2.delete();
                } else if (file2.isFile()) {
                    file2.delete();
                }
            }
        }
    }

    /* renamed from: b */
    public static void m26142b(Context context) {
        m26143b(context.getFilesDir());
    }

    /* renamed from: c */
    public static long m26144c(File file) {
        long j2 = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                j2 += listFiles[i2].isDirectory() ? m26144c(listFiles[i2]) : listFiles[i2].length();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return j2;
    }

    /* renamed from: d */
    public static void m26146d(Context context) {
        m26145c(context);
        m26139a(context);
        m26147e(context);
        m26148f(context);
    }

    /* renamed from: e */
    public static void m26147e(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ComponentCallbacks2C1576b.m3633a(context).m3657b();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: f */
    public static void m26148f(Context context) {
        try {
            m26140a(context, new LollipopFixedWebView(context.getApplicationContext()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: g */
    public static long m26149g(Context context) {
        try {
            return m26144c(new File(context.getCacheDir() + "/" + InterfaceC1639a.a.f4336b));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    /* renamed from: h */
    public static String m26150h(Context context) {
        long m26144c = m26144c(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            m26144c += m26144c(context.getExternalCacheDir());
        }
        String str = "cacheSize==" + m26144c;
        return m26138a(m26144c);
    }

    /* renamed from: a */
    public static void m26139a(Context context) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            m26143b(context.getExternalCacheDir());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m26143b(File file) {
        new Thread(new a(file)).start();
    }

    /* renamed from: a */
    public static void m26140a(Context context, WebView webView) {
        try {
            AgentWebConfig.removeAllCookies(null);
            webView.getSettings().setCacheMode(2);
            context.deleteDatabase("webviewCache.db");
            context.deleteDatabase("webview.db");
            webView.clearCache(true);
            webView.clearHistory();
            webView.clearFormData();
            m26137a(new File(AgentWebConfig.getCachePath(context)), 0);
        } catch (Exception e2) {
            if (AgentWebConfig.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public static void m26145c(Context context) {
        m26143b(context.getCacheDir());
    }

    /* renamed from: a */
    public static int m26137a(File file, int i2) {
        int i3;
        if (file != null) {
            String str = "dir:" + file.getAbsolutePath();
        }
        if (file == null || !file.isDirectory()) {
            return 0;
        }
        try {
            i3 = 0;
            for (File file2 : file.listFiles()) {
                try {
                    if (file2.isDirectory()) {
                        i3 += m26137a(file2, i2);
                    }
                    if (file2.lastModified() < new Date().getTime() - (i2 * 86400000)) {
                        String str2 = "file name:" + file2.getName();
                        if (file2.delete()) {
                            i3++;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    String.format("Failed to clean the cache, result %s", e.getMessage());
                    return i3;
                }
            }
            return i3;
        } catch (Exception e3) {
            e = e3;
            i3 = 0;
        }
    }

    /* renamed from: a */
    public static String m26138a(long j2) {
        String str = "size==" + j2;
        long j3 = j2 / 1024;
        double d2 = j3;
        if (d2 < 1.0d) {
            return j3 + "kB";
        }
        double d3 = d2 / 1024.0d;
        if (d3 < 1.0d) {
            return new BigDecimal(Double.toString(d2)).setScale(1, 4).toPlainString() + "KB";
        }
        double d4 = d3 / 1024.0d;
        if (d4 < 1.0d) {
            return new BigDecimal(Double.toString(d3)).setScale(1, 4).toPlainString() + "MB";
        }
        double d5 = d4 / 1024.0d;
        if (d5 < 1.0d) {
            return new BigDecimal(Double.toString(d4)).setScale(2, 4).toPlainString() + "GB";
        }
        return new BigDecimal(d5).setScale(2, 4).toPlainString() + "TB";
    }
}
