package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.vivo.push.C3924m;
import com.vivo.push.PushClient;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.util.C4010u;
import com.vivo.push.util.C4013x;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class PushServiceReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static HandlerThread f14189a;

    /* renamed from: b */
    private static Handler f14190b;

    /* renamed from: c */
    private static RunnableC3972a f14191c = new RunnableC3972a();

    /* renamed from: com.vivo.push.sdk.PushServiceReceiver$a */
    static class RunnableC3972a implements Runnable {

        /* renamed from: a */
        private Context f14192a;

        /* renamed from: b */
        private String f14193b;

        RunnableC3972a() {
        }

        /* renamed from: a */
        static /* synthetic */ void m13161a(RunnableC3972a runnableC3972a, Context context, String str) {
            runnableC3972a.f14192a = ContextDelegate.getContext(context);
            runnableC3972a.f14193b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo m13315a = C4013x.m13315a(this.f14192a);
            if (!(m13315a != null ? m13315a.isConnectedOrConnecting() : false)) {
                C4010u.m13309d("PushServiceReceiver", this.f14192a.getPackageName() + ": 无网络  by " + this.f14193b);
                C4010u.m13297a(this.f14192a, "触发静态广播:无网络(" + this.f14193b + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f14192a.getPackageName() + ")");
                return;
            }
            C4010u.m13309d("PushServiceReceiver", this.f14192a.getPackageName() + ": 执行开始出发动作: " + this.f14193b);
            C4010u.m13297a(this.f14192a, "触发静态广播(" + this.f14193b + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f14192a.getPackageName() + ")");
            C3924m.m13016a().m13030a(this.f14192a);
            if (ClientConfigManagerImpl.getInstance(this.f14192a).isCancleBroadcastReceiver()) {
                return;
            }
            try {
                PushClient.getInstance(this.f14192a).initialize(C3932a.m13069a().m13074e().mo13130l());
            } catch (VivoPushException e2) {
                e2.printStackTrace();
                C4010u.m13297a(this.f14192a, " 初始化异常 error= " + e2.getMessage());
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Context context2 = ContextDelegate.getContext(context);
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f14189a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f14189a = handlerThread;
                handlerThread.start();
                f14190b = new Handler(f14189a.getLooper());
            }
            C4010u.m13309d("PushServiceReceiver", context2.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f14190b);
            RunnableC3972a.m13161a(f14191c, context2, action);
            f14190b.removeCallbacks(f14191c);
            f14190b.postDelayed(f14191c, 2000L);
        }
    }
}
