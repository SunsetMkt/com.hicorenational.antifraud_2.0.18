package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: PushClientThread.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t {
    private static final Handler a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HandlerThread f8637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Handler f8638c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        f8637b = handlerThread;
        handlerThread.start();
        f8638c = new u(f8637b.getLooper());
    }

    public static void a(s sVar) {
        if (sVar == null) {
            com.vivo.push.util.u.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int iA = sVar.a();
        Message message = new Message();
        message.what = iA;
        message.obj = sVar;
        f8638c.sendMessageDelayed(message, 0L);
    }

    public static void b(Runnable runnable) {
        a.post(runnable);
    }

    public static void c(Runnable runnable) {
        Handler handler = f8638c;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public static void a(Runnable runnable) {
        f8638c.removeCallbacks(runnable);
        f8638c.postDelayed(runnable, 15000L);
    }
}
