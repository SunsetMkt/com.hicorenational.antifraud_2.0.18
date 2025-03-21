package com.umeng.commonsdk.stateless;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.C3470a;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.vchannel.C3532a;
import java.io.File;
import java.util.LinkedList;

/* compiled from: UMSLNetWorkSender.java */
/* renamed from: com.umeng.commonsdk.stateless.b */
/* loaded from: classes2.dex */
public class C3490b {

    /* renamed from: a */
    public static final int f12692a = 273;

    /* renamed from: b */
    private static Context f12693b = null;

    /* renamed from: c */
    private static HandlerThread f12694c = null;

    /* renamed from: d */
    private static Handler f12695d = null;

    /* renamed from: f */
    private static final int f12697f = 274;

    /* renamed from: g */
    private static final int f12698g = 275;

    /* renamed from: h */
    private static final int f12699h = 512;

    /* renamed from: i */
    private static a f12700i = null;

    /* renamed from: j */
    private static IntentFilter f12701j = null;

    /* renamed from: k */
    private static volatile boolean f12702k = false;

    /* renamed from: e */
    private static Object f12696e = new Object();

    /* renamed from: l */
    private static LinkedList<String> f12703l = new LinkedList<>();

    /* compiled from: UMSLNetWorkSender.java */
    /* renamed from: com.umeng.commonsdk.stateless.b$a */
    static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i2, String str) {
            if ((i2 & 8) != 8) {
                return;
            }
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            C3490b.m11676a(C3490b.f12697f);
        }
    }

    public C3490b(Context context) {
        synchronized (f12696e) {
            if (context != null) {
                try {
                    f12693b = context.getApplicationContext();
                    if (f12693b != null && f12694c == null) {
                        f12694c = new HandlerThread("SL-NetWorkSender");
                        f12694c.start();
                        if (f12700i == null) {
                            String str = f12693b.getFilesDir() + File.separator + C3489a.f12686f;
                            File file = new File(str);
                            if (!file.exists()) {
                                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                file.mkdir();
                            }
                            f12700i = new a(str);
                            f12700i.startWatching();
                            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                        }
                        if (f12695d == null) {
                            f12695d = new Handler(f12694c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.1
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    int i2 = message.what;
                                    if (i2 != 512) {
                                        switch (i2) {
                                            case 273:
                                                C3490b.m11690l();
                                                return;
                                            case C3490b.f12697f /* 274 */:
                                                C3490b.m11692n();
                                                return;
                                            case C3490b.f12698g /* 275 */:
                                                C3490b.m11694p();
                                                break;
                                            default:
                                                return;
                                        }
                                    }
                                    C3490b.m11695q();
                                }
                            };
                        }
                    }
                } finally {
                }
            }
        }
    }

    /* renamed from: a */
    public static void m11677a(boolean z) {
        f12702k = z;
        if (!z) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
        } else {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
            m11680b(f12697f);
        }
    }

    /* renamed from: b */
    public static void m11680b(int i2) {
        try {
            if (!f12702k || f12695d == null || f12695d.hasMessages(i2)) {
                return;
            }
            Message obtainMessage = f12695d.obtainMessage();
            obtainMessage.what = i2;
            f12695d.sendMessage(obtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f12693b, th);
        }
    }

    /* renamed from: c */
    public static void m11681c() {
        m11680b(f12698g);
    }

    /* renamed from: d */
    public static void m11682d() {
        m11680b(512);
    }

    /* renamed from: i */
    private static void m11687i() {
        File[] m11713c = C3492d.m11713c(f12693b);
        if (m11713c != null) {
            if (f12703l.size() > 0) {
                f12703l.clear();
            }
            for (File file : m11713c) {
                f12703l.add(file.getAbsolutePath());
            }
        }
    }

    /* renamed from: j */
    private static String m11688j() {
        try {
            String peek = f12703l.peek();
            if (peek == null) {
                return peek;
            }
            try {
                f12703l.removeFirst();
                return peek;
            } catch (Throwable unused) {
                return peek;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    @TargetApi(9)
    /* renamed from: k */
    private static void m11689k() {
        String pollFirst;
        if (f12703l.size() <= 0) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            pollFirst = Build.VERSION.SDK_INT >= 9 ? f12703l.pollFirst() : m11688j();
            if (!TextUtils.isEmpty(pollFirst)) {
                File file = new File(pollFirst);
                if (file.exists()) {
                    C3491c c3491c = new C3491c(f12693b);
                    byte[] bArr = null;
                    try {
                        bArr = C3492d.m11706a(pollFirst);
                    } catch (Exception unused) {
                    }
                    String name = file.getName();
                    String substring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : C3351bh.f11586aK;
                    String m11712c = C3492d.m11712c(C3492d.m11714d(name));
                    if (c3491c.m11698a(bArr, m11712c, C3532a.f13027c.equalsIgnoreCase(m11712c) ? C3532a.f13025a : "", substring) && !file.delete()) {
                        file.delete();
                    }
                } else {
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                }
            }
        } while (pollFirst != null);
        f12703l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static void m11690l() {
        File m11700a;
        if (!f12702k || f12693b == null) {
            return;
        }
        do {
            try {
                m11700a = C3492d.m11700a(f12693b);
                if (m11700a != null && m11700a.getParentFile() != null && !TextUtils.isEmpty(m11700a.getParentFile().getName())) {
                    C3491c c3491c = new C3491c(f12693b);
                    String str = new String(Base64.decode(m11700a.getParentFile().getName(), 0));
                    if (!C3470a.f12587a.equalsIgnoreCase(str) && !C3470a.f12588b.equalsIgnoreCase(str) && !C3470a.f12582H.equalsIgnoreCase(str)) {
                        ULog.m11783i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                        byte[] bArr = null;
                        try {
                            bArr = C3492d.m11706a(m11700a.getAbsolutePath());
                        } catch (Exception unused) {
                        }
                        String str2 = C3532a.f13027c.equalsIgnoreCase(str) ? C3532a.f13025a : "";
                        String str3 = C3351bh.f11586aK;
                        if (UMServerURL.PATH_SHARE.equalsIgnoreCase(str)) {
                            str3 = C3351bh.f11580aE;
                        }
                        if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                            str3 = C3351bh.f11576aA;
                        }
                        if (!c3491c.m11698a(bArr, str, str2, str3)) {
                            ULog.m11783i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.m11783i("walle", "[stateless] Send envelope file success, delete it.");
                        File file = new File(m11700a.getAbsolutePath());
                        if (!file.delete()) {
                            ULog.m11783i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                            file.delete();
                        }
                    }
                    new File(m11700a.getAbsolutePath()).delete();
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f12693b, th);
            }
        } while (m11700a != null);
        m11691m();
    }

    /* renamed from: m */
    private static void m11691m() {
        try {
            File file = new File(f12693b.getFilesDir() + File.separator + C3489a.f12685e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                C3492d.m11705a(file);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static void m11692n() {
        if (!f12702k || f12693b == null) {
            return;
        }
        m11687i();
        m11689k();
        m11681c();
    }

    /* renamed from: o */
    private static void m11693o() {
        try {
            File file = new File(f12693b.getFilesDir() + File.separator + C3489a.f12685e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                m11680b(273);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public static void m11694p() {
        m11693o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public static void m11695q() {
    }

    /* renamed from: a */
    public static boolean m11678a() {
        synchronized (f12696e) {
            return f12700i != null;
        }
    }

    /* renamed from: b */
    public static void m11679b() {
        UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        m11680b(f12697f);
    }

    /* renamed from: a */
    public static void m11676a(int i2) {
        Handler handler;
        if (!f12702k || (handler = f12695d) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        f12695d.sendMessage(obtainMessage);
    }
}
