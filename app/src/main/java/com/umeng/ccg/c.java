package com.umeng.ccg;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

/* JADX INFO: compiled from: Dispatch.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static final int a = 101;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f7456b = 102;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7457c = 103;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7458d = 104;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7459e = 105;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7460f = 106;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f7461g = 107;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f7462h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f7463i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f7464j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f7465k = 201;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f7466l = 202;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f7467m = 203;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f7468n = 301;
    public static final int o = 302;
    public static final int p = 303;
    private static HandlerThread q = null;
    private static Handler r = null;
    private static HashMap<Integer, a> s = null;
    private static final int t = 256;

    /* JADX INFO: compiled from: Dispatch.java */
    public interface a {
        void a(Object obj, int i2);
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Message message) {
        int i2 = message.arg1;
        Object obj = message.obj;
        Integer numValueOf = Integer.valueOf(i2 / 100);
        HashMap<Integer, a> map = s;
        if (map == null) {
            return;
        }
        a aVar = map.containsKey(numValueOf) ? s.get(numValueOf) : null;
        if (aVar != null) {
            aVar.a(obj, i2);
        }
    }

    public static void a(Context context, int i2, int i3, a aVar, Object obj, long j2) {
        if (context == null || aVar == null) {
            return;
        }
        if (s == null) {
            s = new HashMap<>();
        }
        Integer numValueOf = Integer.valueOf(i3 / 100);
        if (!s.containsKey(numValueOf)) {
            s.put(numValueOf, aVar);
        }
        if (q == null || r == null) {
            a();
        }
        try {
            if (r != null) {
                Message messageObtainMessage = r.obtainMessage();
                messageObtainMessage.what = i2;
                messageObtainMessage.arg1 = i3;
                messageObtainMessage.obj = obj;
                r.sendMessageDelayed(messageObtainMessage, j2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i2, a aVar, Object obj) {
        a(context, 256, i2, aVar, obj, 0L);
    }

    public static void a(Context context, int i2, a aVar, Object obj, long j2) {
        a(context, 256, i2, aVar, obj, j2);
    }

    private static synchronized void a() {
        try {
            if (q == null) {
                q = new HandlerThread("ccg_dispatch");
                q.start();
                if (r == null) {
                    r = new Handler(q.getLooper()) { // from class: com.umeng.ccg.c.1
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            if (message.what != 256) {
                                return;
                            }
                            c.b(message);
                        }
                    };
                }
            }
        } catch (Throwable unused) {
        }
    }
}
