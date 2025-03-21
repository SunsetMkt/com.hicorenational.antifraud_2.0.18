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
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.util.LinkedList;

/* compiled from: UMSLNetWorkSender.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f10847a = 273;

    /* renamed from: b, reason: collision with root package name */
    private static Context f10848b = null;

    /* renamed from: c, reason: collision with root package name */
    private static HandlerThread f10849c = null;

    /* renamed from: d, reason: collision with root package name */
    private static Handler f10850d = null;

    /* renamed from: f, reason: collision with root package name */
    private static final int f10852f = 274;

    /* renamed from: g, reason: collision with root package name */
    private static final int f10853g = 275;

    /* renamed from: h, reason: collision with root package name */
    private static final int f10854h = 512;

    /* renamed from: i, reason: collision with root package name */
    private static a f10855i = null;

    /* renamed from: j, reason: collision with root package name */
    private static IntentFilter f10856j = null;

    /* renamed from: k, reason: collision with root package name */
    private static volatile boolean f10857k = false;

    /* renamed from: e, reason: collision with root package name */
    private static Object f10851e = new Object();

    /* renamed from: l, reason: collision with root package name */
    private static LinkedList<String> f10858l = new LinkedList<>();

    /* compiled from: UMSLNetWorkSender.java */
    static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i2, String str) {
            if ((i2 & 8) != 8) {
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            b.a(b.f10852f);
        }
    }

    public b(Context context) {
        synchronized (f10851e) {
            if (context != null) {
                try {
                    f10848b = context.getApplicationContext();
                    if (f10848b != null && f10849c == null) {
                        f10849c = new HandlerThread("SL-NetWorkSender");
                        f10849c.start();
                        if (f10855i == null) {
                            String str = f10848b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f10841f;
                            File file = new File(str);
                            if (!file.exists()) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                file.mkdir();
                            }
                            f10855i = new a(str);
                            f10855i.startWatching();
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                        }
                        if (f10850d == null) {
                            f10850d = new Handler(f10849c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.1
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    int i2 = message.what;
                                    if (i2 != 512) {
                                        switch (i2) {
                                            case 273:
                                                b.l();
                                                return;
                                            case b.f10852f /* 274 */:
                                                b.n();
                                                return;
                                            case b.f10853g /* 275 */:
                                                b.p();
                                                break;
                                            default:
                                                return;
                                        }
                                    }
                                    b.q();
                                }
                            };
                        }
                    }
                } finally {
                }
            }
        }
    }

    public static void a(boolean z) {
        f10857k = z;
        if (!z) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
            b(f10852f);
        }
    }

    public static void b(int i2) {
        try {
            if (!f10857k || f10850d == null || f10850d.hasMessages(i2)) {
                return;
            }
            Message obtainMessage = f10850d.obtainMessage();
            obtainMessage.what = i2;
            f10850d.sendMessage(obtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f10848b, th);
        }
    }

    public static void c() {
        b(f10853g);
    }

    public static void d() {
        b(512);
    }

    private static void i() {
        File[] c2 = d.c(f10848b);
        if (c2 != null) {
            if (f10858l.size() > 0) {
                f10858l.clear();
            }
            for (File file : c2) {
                f10858l.add(file.getAbsolutePath());
            }
        }
    }

    private static String j() {
        try {
            String peek = f10858l.peek();
            if (peek == null) {
                return peek;
            }
            try {
                f10858l.removeFirst();
                return peek;
            } catch (Throwable unused) {
                return peek;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    @TargetApi(9)
    private static void k() {
        String pollFirst;
        if (f10858l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            pollFirst = Build.VERSION.SDK_INT >= 9 ? f10858l.pollFirst() : j();
            if (!TextUtils.isEmpty(pollFirst)) {
                File file = new File(pollFirst);
                if (file.exists()) {
                    c cVar = new c(f10848b);
                    byte[] bArr = null;
                    try {
                        bArr = d.a(pollFirst);
                    } catch (Exception unused) {
                    }
                    String name = file.getName();
                    String substring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : bh.aK;
                    String c2 = d.c(d.d(name));
                    if (cVar.a(bArr, c2, com.umeng.commonsdk.vchannel.a.f11112c.equalsIgnoreCase(c2) ? com.umeng.commonsdk.vchannel.a.f11110a : "", substring) && !file.delete()) {
                        file.delete();
                    }
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                }
            }
        } while (pollFirst != null);
        f10858l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        File a2;
        if (!f10857k || f10848b == null) {
            return;
        }
        do {
            try {
                a2 = d.a(f10848b);
                if (a2 != null && a2.getParentFile() != null && !TextUtils.isEmpty(a2.getParentFile().getName())) {
                    c cVar = new c(f10848b);
                    String str = new String(Base64.decode(a2.getParentFile().getName(), 0));
                    if (!com.umeng.commonsdk.internal.a.f10755a.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.f10756b.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.H.equalsIgnoreCase(str)) {
                        ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                        byte[] bArr = null;
                        try {
                            bArr = d.a(a2.getAbsolutePath());
                        } catch (Exception unused) {
                        }
                        String str2 = com.umeng.commonsdk.vchannel.a.f11112c.equalsIgnoreCase(str) ? com.umeng.commonsdk.vchannel.a.f11110a : "";
                        String str3 = bh.aK;
                        if (UMServerURL.PATH_SHARE.equalsIgnoreCase(str)) {
                            str3 = bh.aE;
                        }
                        if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                            str3 = bh.aA;
                        }
                        if (!cVar.a(bArr, str, str2, str3)) {
                            ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                        File file = new File(a2.getAbsolutePath());
                        if (!file.delete()) {
                            ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                            file.delete();
                        }
                    }
                    new File(a2.getAbsolutePath()).delete();
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f10848b, th);
            }
        } while (a2 != null);
        m();
    }

    private static void m() {
        try {
            File file = new File(f10848b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f10840e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                d.a(file);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        if (!f10857k || f10848b == null) {
            return;
        }
        i();
        k();
        c();
    }

    private static void o() {
        try {
            File file = new File(f10848b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f10840e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(273);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p() {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
    }

    public static boolean a() {
        synchronized (f10851e) {
            return f10855i != null;
        }
    }

    public static void b() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        b(f10852f);
    }

    public static void a(int i2) {
        Handler handler;
        if (!f10857k || (handler = f10850d) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        f10850d.sendMessage(obtainMessage);
    }
}
