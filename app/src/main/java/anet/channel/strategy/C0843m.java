package anet.channel.strategy;

import android.content.Context;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.statist.StrategyStatObject;
import anet.channel.util.ALog;
import anet.channel.util.SerializeHelper;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.m */
/* loaded from: classes.dex */
class C0843m {

    /* renamed from: a */
    private static File f1142a = null;

    /* renamed from: b */
    private static volatile boolean f1143b = false;

    /* renamed from: c */
    private static Comparator<File> f1144c = new C0844n();

    C0843m() {
    }

    /* renamed from: a */
    public static void m694a(Context context) {
        if (context != null) {
            try {
                f1142a = new File(context.getFilesDir(), "awcn_strategy");
                if (!m696a(f1142a)) {
                    ALog.m715e("awcn.StrategySerializeHelper", "create directory failed!!!", null, "dir", f1142a.getAbsolutePath());
                }
                if (!GlobalAppRuntimeInfo.isTargetProcess()) {
                    String currentProcess = GlobalAppRuntimeInfo.getCurrentProcess();
                    f1142a = new File(f1142a, currentProcess.substring(currentProcess.indexOf(58) + 1));
                    if (!m696a(f1142a)) {
                        ALog.m715e("awcn.StrategySerializeHelper", "create directory failed!!!", null, "dir", f1142a.getAbsolutePath());
                    }
                }
                ALog.m716i("awcn.StrategySerializeHelper", "StrateyFolder", null, "path", f1142a.getAbsolutePath());
                if (!f1143b) {
                    m698c();
                } else {
                    m693a();
                    f1143b = false;
                }
            } catch (Throwable th) {
                ALog.m714e("awcn.StrategySerializeHelper", "StrategySerializeHelper initialize failed!!!", null, th, new Object[0]);
            }
        }
    }

    /* renamed from: b */
    static synchronized File[] m697b() {
        synchronized (C0843m.class) {
            if (f1142a == null) {
                return null;
            }
            File[] listFiles = f1142a.listFiles();
            if (listFiles != null) {
                Arrays.sort(listFiles, f1144c);
            }
            return listFiles;
        }
    }

    /* renamed from: c */
    static synchronized void m698c() {
        synchronized (C0843m.class) {
            File[] m697b = m697b();
            if (m697b == null) {
                return;
            }
            int i2 = 0;
            for (File file : m697b) {
                if (!file.isDirectory()) {
                    if (System.currentTimeMillis() - file.lastModified() > 172800000) {
                        file.delete();
                    } else if (file.getName().startsWith("WIFI")) {
                        int i3 = i2 + 1;
                        if (i2 > 10) {
                            file.delete();
                        }
                        i2 = i3;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m696a(File file) {
        if (file == null || file.exists()) {
            return true;
        }
        return file.mkdir();
    }

    /* renamed from: a */
    public static File m691a(String str) {
        m696a(f1142a);
        return new File(f1142a, str);
    }

    /* renamed from: a */
    static synchronized void m693a() {
        synchronized (C0843m.class) {
            ALog.m716i("awcn.StrategySerializeHelper", "clear start.", null, new Object[0]);
            if (f1142a == null) {
                ALog.m718w("awcn.StrategySerializeHelper", "folder path not initialized, wait to clear", null, new Object[0]);
                f1143b = true;
                return;
            }
            File[] listFiles = f1142a.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file : listFiles) {
                if (file.isFile()) {
                    file.delete();
                }
            }
            ALog.m716i("awcn.StrategySerializeHelper", "clear end.", null, new Object[0]);
        }
    }

    /* renamed from: a */
    static synchronized void m695a(Serializable serializable, String str, StrategyStatObject strategyStatObject) {
        synchronized (C0843m.class) {
            SerializeHelper.persist(serializable, m691a(str), strategyStatObject);
        }
    }

    /* renamed from: a */
    static synchronized <T> T m692a(String str, StrategyStatObject strategyStatObject) {
        T t;
        synchronized (C0843m.class) {
            t = (T) SerializeHelper.restore(m691a(str), strategyStatObject);
        }
        return t;
    }
}
