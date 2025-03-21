package com.umeng.commonsdk.framework;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.C3470a;
import com.umeng.commonsdk.internal.C3471b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.C3495c;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: UMNetWorkSender.java */
/* renamed from: com.umeng.commonsdk.framework.a */
/* loaded from: classes2.dex */
public class C3469a implements UMImprintChangeCallback {

    /* renamed from: a */
    private static HandlerThread f12549a = null;

    /* renamed from: b */
    private static Handler f12550b = null;

    /* renamed from: c */
    private static Handler f12551c = null;

    /* renamed from: d */
    private static final int f12552d = 200;

    /* renamed from: e */
    private static final int f12553e = 273;

    /* renamed from: f */
    private static final int f12554f = 274;

    /* renamed from: g */
    private static final int f12555g = 512;

    /* renamed from: h */
    private static final int f12556h = 769;

    /* renamed from: i */
    private static a f12557i = null;

    /* renamed from: j */
    private static ConnectivityManager f12558j = null;

    /* renamed from: k */
    private static IntentFilter f12559k = null;

    /* renamed from: l */
    private static volatile boolean f12560l = false;

    /* renamed from: m */
    private static ArrayList<UMSenderStateNotify> f12561m = null;

    /* renamed from: p */
    private static final String f12564p = "report_policy";

    /* renamed from: q */
    private static final String f12565q = "report_interval";

    /* renamed from: s */
    private static final int f12567s = 15;

    /* renamed from: t */
    private static final int f12568t = 3;

    /* renamed from: u */
    private static final int f12569u = 90;

    /* renamed from: x */
    private static BroadcastReceiver f12572x;

    /* renamed from: n */
    private static Object f12562n = new Object();

    /* renamed from: o */
    private static ReentrantLock f12563o = new ReentrantLock();

    /* renamed from: r */
    private static boolean f12566r = false;

    /* renamed from: v */
    private static int f12570v = 15;

    /* renamed from: w */
    private static Object f12571w = new Object();

    /* compiled from: UMNetWorkSender.java */
    /* renamed from: com.umeng.commonsdk.framework.a$a */
    static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i2, String str) {
            if ((i2 & 8) != 8) {
                return;
            }
            ULog.m11768d("--->>> envelope file created >>> " + str);
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            C3469a.m11577c(273);
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f12558j = (ConnectivityManager) appContext.getSystemService("connectivity");
        }
        f12572x = new BroadcastReceiver() { // from class: com.umeng.commonsdk.framework.a.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    UMWorkDispatch.sendEvent(context, C3470a.f12579E, C3471b.m11589a(context).m11590a(), null);
                }
            }
        };
    }

    public C3469a(Context context, Handler handler) {
        if (f12558j == null) {
            Context appContext = UMGlobalContext.getAppContext();
            if (f12558j != null) {
                f12558j = (ConnectivityManager) appContext.getSystemService("connectivity");
            }
        }
        f12551c = handler;
        try {
            if (f12549a == null) {
                f12549a = new HandlerThread("NetWorkSender");
                f12549a.start();
                if (f12557i == null) {
                    f12557i = new a(UMFrUtils.getEnvelopeDirPath(context));
                    f12557i.startWatching();
                    ULog.m11768d("--->>> FileMonitor has already started!");
                }
                m11584j();
                if (f12550b == null) {
                    f12550b = new Handler(f12549a.getLooper()) { // from class: com.umeng.commonsdk.framework.a.3
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i2 = message.what;
                            if (i2 == 273) {
                                ULog.m11768d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                                try {
                                    C3469a.f12563o.tryLock(1L, TimeUnit.SECONDS);
                                    try {
                                        C3469a.m11588n();
                                    } catch (Throwable unused) {
                                    }
                                    C3469a.f12563o.unlock();
                                    return;
                                } catch (Throwable unused2) {
                                    return;
                                }
                            }
                            if (i2 == C3469a.f12554f) {
                                C3469a.m11586l();
                            } else {
                                if (i2 != 512) {
                                    return;
                                }
                                C3469a.m11587m();
                            }
                        }
                    };
                }
                ImprintHandler.getImprintService(context).registImprintCallback(f12564p, this);
                ImprintHandler.getImprintService(context).registImprintCallback(f12565q, this);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    /* renamed from: b */
    public static int m11573b() {
        int i2;
        synchronized (f12571w) {
            i2 = f12570v;
        }
        return i2;
    }

    /* renamed from: c */
    public static void m11576c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m11577c(int i2) {
        Handler handler;
        if (!f12560l || (handler = f12550b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        f12550b.sendMessage(obtainMessage);
    }

    /* renamed from: d */
    public static void m11578d() {
        if (f12563o.tryLock()) {
            try {
                m11574b(273);
            } finally {
                f12563o.unlock();
            }
        }
    }

    /* renamed from: e */
    public static void m11579e() {
        m11567a(f12554f, PathInterpolatorCompat.MAX_NUM_POINTS);
    }

    /* renamed from: j */
    private void m11584j() {
        synchronized (f12571w) {
            if ("11".equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f12564p, ""))) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                f12566r = true;
                f12570v = 15;
                int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f12565q, "15")).intValue();
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    f12570v = intValue * 1000;
                }
                f12570v = 15;
            } else {
                f12566r = false;
            }
        }
    }

    /* renamed from: k */
    private static void m11585k() {
        if (f12549a != null) {
            f12549a = null;
        }
        if (f12550b != null) {
            f12550b = null;
        }
        if (f12551c != null) {
            f12551c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static void m11586l() {
        int size;
        synchronized (f12562n) {
            if (f12561m != null && (size = f12561m.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    f12561m.get(i2).onSenderIdle();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static void m11587m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static void m11588n() {
        ULog.m11768d("--->>> handleProcessNext: Enter...");
        if (f12560l) {
            Context appContext = UMModuleRegister.getAppContext();
            try {
                if (UMFrUtils.envelopeFileNumber(appContext) > 0) {
                    ULog.m11768d("--->>> The envelope file exists.");
                    if (UMFrUtils.envelopeFileNumber(appContext) > 200) {
                        ULog.m11768d("--->>> Number of envelope files is greater than 200, remove old files first.");
                        UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                    }
                    File envelopeFile = UMFrUtils.getEnvelopeFile(appContext);
                    if (envelopeFile != null) {
                        String path = envelopeFile.getPath();
                        ULog.m11768d("--->>> Ready to send envelope file [" + path + "].");
                        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> send envelope file [ " + path + "].");
                        if (!new C3495c(appContext).m11737a(envelopeFile)) {
                            ULog.m11768d("--->>> Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.m11768d("--->>> Send envelope file success, delete it.");
                        if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                            ULog.m11768d("--->>> Failed to delete already processed file. We try again after delete failed.");
                            UMFrUtils.removeEnvelopeFile(envelopeFile);
                        }
                        m11577c(273);
                        return;
                    }
                }
                m11579e();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
            }
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        synchronized (f12571w) {
            if (f12564p.equals(str)) {
                if ("11".equals(str2)) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    f12566r = true;
                } else {
                    f12566r = false;
                }
            }
            if (f12565q.equals(str)) {
                int intValue = Integer.valueOf(str2).intValue();
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    f12570v = intValue * 1000;
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f12570v);
                }
                f12570v = 15000;
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f12570v);
            }
        }
    }

    /* renamed from: a */
    public static void m11569a(Context context) {
        if (f12558j != null || context == null) {
            return;
        }
        f12558j = (ConnectivityManager) context.getSystemService("connectivity");
        if (f12558j != null) {
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> createCMIfNeeded:注册网络状态监听器。");
            m11575b(context);
        }
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    /* renamed from: b */
    public static void m11575b(Context context) {
        if (context == null) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> registerNetReceiver: context is null, registerNetReceiver failed.");
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            if (DeviceConfig.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkRequest build = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).build();
                if (f12558j != null) {
                    final Context applicationContext = context.getApplicationContext();
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerNetworkCallback");
                    f12558j.registerNetworkCallback(build, new ConnectivityManager.NetworkCallback() { // from class: com.umeng.commonsdk.framework.a.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network2) {
                            Context context2 = applicationContext;
                            UMWorkDispatch.sendEvent(context2, C3470a.f12579E, C3471b.m11589a(context2).m11590a(), null);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onCapabilitiesChanged(Network network2, NetworkCapabilities networkCapabilities) {
                            super.onCapabilitiesChanged(network2, networkCapabilities);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onLost(Network network2) {
                            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> onLost");
                            Context context2 = applicationContext;
                            UMWorkDispatch.sendEvent(context2, C3470a.f12579E, C3471b.m11589a(context2).m11590a(), null, 2000L);
                        }
                    });
                    return;
                }
                return;
            }
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
            return;
        }
        if (DeviceConfig.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            if (f12558j == null || f12559k != null) {
                return;
            }
            f12559k = new IntentFilter();
            f12559k.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (f12572x != null) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerReceiver");
                context.registerReceiver(f12572x, f12559k);
                return;
            }
            return;
        }
        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
    }

    /* renamed from: a */
    public static void m11570a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (f12562n) {
            try {
                if (f12561m == null) {
                    f12561m = new ArrayList<>();
                }
                if (uMSenderStateNotify != null) {
                    for (int i2 = 0; i2 < f12561m.size(); i2++) {
                        if (uMSenderStateNotify == f12561m.get(i2)) {
                            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                            return;
                        }
                    }
                    f12561m.add(uMSenderStateNotify);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
        }
    }

    /* renamed from: a */
    public static boolean m11572a() {
        boolean z;
        synchronized (f12571w) {
            z = f12566r;
        }
        return z;
    }

    /* renamed from: a */
    public static void m11571a(boolean z) {
        int size;
        f12560l = z;
        if (z) {
            synchronized (f12562n) {
                if (f12561m != null && (size = f12561m.size()) > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        f12561m.get(i2).onConnectionAvailable();
                    }
                }
            }
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
            m11578d();
            return;
        }
        ULog.m11780i("--->>> network disconnected.");
        f12560l = false;
    }

    /* renamed from: b */
    private static void m11574b(int i2) {
        Handler handler;
        if (!f12560l || (handler = f12550b) == null || handler.hasMessages(i2)) {
            return;
        }
        Message obtainMessage = f12550b.obtainMessage();
        obtainMessage.what = i2;
        f12550b.sendMessage(obtainMessage);
    }

    /* renamed from: a */
    private static void m11568a(int i2, long j2) {
        Handler handler;
        if (!f12560l || (handler = f12550b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> sendMsgDelayed: " + j2);
        f12550b.sendMessageDelayed(obtainMessage, j2);
    }

    /* renamed from: a */
    private static void m11567a(int i2, int i3) {
        Handler handler;
        if (!f12560l || (handler = f12550b) == null) {
            return;
        }
        handler.removeMessages(i2);
        Message obtainMessage = f12550b.obtainMessage();
        obtainMessage.what = i2;
        f12550b.sendMessageDelayed(obtainMessage, i3);
    }
}
