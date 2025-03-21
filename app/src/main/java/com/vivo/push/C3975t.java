package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.C4010u;

/* compiled from: PushClientThread.java */
/* renamed from: com.vivo.push.t */
/* loaded from: classes2.dex */
public final class C3975t {

    /* renamed from: a */
    private static final Handler f14198a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static final HandlerThread f14199b;

    /* renamed from: c */
    private static final Handler f14200c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        f14199b = handlerThread;
        handlerThread.start();
        f14200c = new HandlerC3976u(f14199b.getLooper());
    }

    /* renamed from: a */
    public static void m13168a(AbstractRunnableC3971s abstractRunnableC3971s) {
        if (abstractRunnableC3971s == null) {
            C4010u.m13292a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int m13160a = abstractRunnableC3971s.m13160a();
        Message message = new Message();
        message.what = m13160a;
        message.obj = abstractRunnableC3971s;
        f14200c.sendMessageDelayed(message, 0L);
    }

    /* renamed from: b */
    public static void m13170b(Runnable runnable) {
        f14198a.post(runnable);
    }

    /* renamed from: c */
    public static void m13171c(Runnable runnable) {
        Handler handler = f14200c;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    /* renamed from: a */
    public static void m13169a(Runnable runnable) {
        f14200c.removeCallbacks(runnable);
        f14200c.postDelayed(runnable, 15000L);
    }
}
