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

/* JADX INFO: compiled from: UMSLNetWorkSender.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static final int a = 273;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f7647b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static HandlerThread f7648c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Handler f7649d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f7651f = 274;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f7652g = 275;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f7653h = 512;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static a f7654i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static IntentFilter f7655j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile boolean f7656k = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Object f7650e = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static LinkedList<String> f7657l = new LinkedList<>();

    /* JADX INFO: compiled from: UMSLNetWorkSender.java */
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
            b.a(b.f7651f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0082 A[Catch: all -> 0x0084, DONT_GENERATE, TryCatch #0 {, blocks: (B:21:0x0082, B:20:0x007f, B:5:0x0008, B:7:0x0012, B:9:0x0016, B:11:0x0028, B:13:0x004f, B:14:0x0059, B:15:0x006c, B:17:0x0070), top: B:26:0x0006, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(Context context) {
        synchronized (f7650e) {
            if (context != null) {
                try {
                    f7647b = context.getApplicationContext();
                } finally {
                }
                if (f7647b != null && f7648c == null) {
                    f7648c = new HandlerThread("SL-NetWorkSender");
                    f7648c.start();
                    if (f7654i == null) {
                        String str = f7647b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f7641f;
                        File file = new File(str);
                        if (!file.exists()) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2\u53f7\u6570\u636e\u4ed3\u76ee\u5f55\u4e0d\u5b58\u5728\uff0c\u521b\u5efa\u4e4b\u3002");
                            file.mkdir();
                        }
                        f7654i = new a(str);
                        f7654i.startWatching();
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2\u53f7\u6570\u636e\u4ed3File Monitor\u542f\u52a8.");
                    }
                    if (f7649d == null) {
                        f7649d = new Handler(f7648c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                int i2 = message.what;
                                if (i2 != 512) {
                                    switch (i2) {
                                        case 273:
                                            b.l();
                                            return;
                                        case b.f7651f /* 274 */:
                                            b.n();
                                            return;
                                        case b.f7652g /* 275 */:
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
            }
        }
    }

    public static void a(boolean z) {
        f7656k = z;
        if (!z) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>\u7f51\u7edc\u65ad\u8fde\uff1a 2\u53f7\u6570\u636e\u4ed3");
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>\u7f51\u7edc\u53ef\u7528\uff1a \u89e6\u53d12\u53f7\u6570\u636e\u4ed3\u4fe1\u5c01\u6d88\u8d39\u52a8\u4f5c\u3002");
            b(f7651f);
        }
    }

    public static void b(int i2) {
        try {
            if (!f7656k || f7649d == null || f7649d.hasMessages(i2)) {
                return;
            }
            Message messageObtainMessage = f7649d.obtainMessage();
            messageObtainMessage.what = i2;
            f7649d.sendMessage(messageObtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f7647b, th);
        }
    }

    public static void c() {
        b(f7652g);
    }

    public static void d() {
        b(512);
    }

    private static void i() {
        File[] fileArrC = d.c(f7647b);
        if (fileArrC != null) {
            if (f7657l.size() > 0) {
                f7657l.clear();
            }
            for (File file : fileArrC) {
                f7657l.add(file.getAbsolutePath());
            }
        }
    }

    private static String j() {
        try {
            String strPeek = f7657l.peek();
            if (strPeek == null) {
                return strPeek;
            }
            try {
                f7657l.removeFirst();
                return strPeek;
            } catch (Throwable unused) {
                return strPeek;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    @TargetApi(9)
    private static void k() {
        String strPollFirst;
        if (f7657l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList\u65e0\u5185\u5bb9\uff0c\u65e0\u9700\u5904\u7406\u3002");
            return;
        }
        do {
            strPollFirst = Build.VERSION.SDK_INT >= 9 ? f7657l.pollFirst() : j();
            if (!TextUtils.isEmpty(strPollFirst)) {
                File file = new File(strPollFirst);
                if (file.exists()) {
                    c cVar = new c(f7647b);
                    byte[] bArrA = null;
                    try {
                        bArrA = d.a(strPollFirst);
                    } catch (Exception unused) {
                    }
                    String name = file.getName();
                    String strSubstring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : bh.aK;
                    String strC = d.c(d.d(name));
                    if (cVar.a(bArrA, strC, com.umeng.commonsdk.vchannel.a.f7864c.equalsIgnoreCase(strC) ? com.umeng.commonsdk.vchannel.a.a : "", strSubstring) && !file.delete()) {
                        file.delete();
                    }
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u4fe1\u5c01\u6587\u4ef6\u4e0d\u5b58\u5728\uff0c\u5904\u7406\u4e0b\u4e00\u4e2a\u6587\u4ef6\u3002");
                }
            }
        } while (strPollFirst != null);
        f7657l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        File fileA;
        if (!f7656k || f7647b == null) {
            return;
        }
        do {
            try {
                fileA = d.a(f7647b);
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f7647b, th);
            }
            if (fileA != null && fileA.getParentFile() != null && !TextUtils.isEmpty(fileA.getParentFile().getName())) {
                c cVar = new c(f7647b);
                String str = new String(Base64.decode(fileA.getParentFile().getName(), 0));
                if (!com.umeng.commonsdk.internal.a.a.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.f7577b.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.H.equalsIgnoreCase(str)) {
                    ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                    byte[] bArrA = null;
                    try {
                        bArrA = d.a(fileA.getAbsolutePath());
                    } catch (Exception unused) {
                    }
                    String str2 = com.umeng.commonsdk.vchannel.a.f7864c.equalsIgnoreCase(str) ? com.umeng.commonsdk.vchannel.a.a : "";
                    String str3 = bh.aK;
                    if (UMServerURL.PATH_SHARE.equalsIgnoreCase(str)) {
                        str3 = bh.aE;
                    }
                    if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                        str3 = bh.aA;
                    }
                    if (!cVar.a(bArrA, str, str2, str3)) {
                        ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                        return;
                    }
                    ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                    File file = new File(fileA.getAbsolutePath());
                    if (!file.delete()) {
                        ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                        file.delete();
                    }
                    m();
                }
                new File(fileA.getAbsolutePath()).delete();
            }
        } while (fileA != null);
        m();
    }

    private static void m() {
        try {
            File file = new File(f7647b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f7640e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2\u53f7\u6570\u636e\u4ed3\uff1a\u5220\u9664stateless\u76ee\u5f55\u3002");
                d.a(file);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        if (!f7656k || f7647b == null) {
            return;
        }
        i();
        k();
        c();
    }

    private static void o() {
        try {
            File file = new File(f7647b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f7640e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2\u53f7\u6570\u636e\u4ed3\uff1a\u68c0\u6d4b\u5230stateless\u76ee\u5f55\u3002");
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
        synchronized (f7650e) {
            return f7654i != null;
        }
    }

    public static void b() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>\u4fe1\u5c01\u6784\u5efa\u6210\u529f\uff1a \u89e6\u53d12\u53f7\u6570\u636e\u4ed3\u4fe1\u5c01\u6d88\u8d39\u52a8\u4f5c\u3002");
        b(f7651f);
    }

    public static void a(int i2) {
        Handler handler;
        if (!f7656k || (handler = f7649d) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i2;
        f7649d.sendMessage(messageObtainMessage);
    }
}
