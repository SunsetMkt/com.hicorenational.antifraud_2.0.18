package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.vivo.push.PushClient;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.m;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.u;
import com.vivo.push.util.x;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class PushServiceReceiver extends BroadcastReceiver {
    private static HandlerThread a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Handler f8631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f8632c = new a();

    static class a implements Runnable {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f8633b;

        a() {
        }

        static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.a = ContextDelegate.getContext(context);
            aVar.f8633b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo networkInfoA = x.a(this.a);
            if (!(networkInfoA != null ? networkInfoA.isConnectedOrConnecting() : false)) {
                u.d("PushServiceReceiver", this.a.getPackageName() + ": \u65e0\u7f51\u7edc  by " + this.f8633b);
                u.a(this.a, "\u89e6\u53d1\u9759\u6001\u5e7f\u64ad:\u65e0\u7f51\u7edc(" + this.f8633b + Constants.ACCEPT_TIME_SEPARATOR_SP + this.a.getPackageName() + ")");
                return;
            }
            u.d("PushServiceReceiver", this.a.getPackageName() + ": \u6267\u884c\u5f00\u59cb\u51fa\u53d1\u52a8\u4f5c: " + this.f8633b);
            u.a(this.a, "\u89e6\u53d1\u9759\u6001\u5e7f\u64ad(" + this.f8633b + Constants.ACCEPT_TIME_SEPARATOR_SP + this.a.getPackageName() + ")");
            m.a().a(this.a);
            if (ClientConfigManagerImpl.getInstance(this.a).isCancleBroadcastReceiver()) {
                return;
            }
            try {
                PushClient.getInstance(this.a).initialize(com.vivo.push.restructure.a.a().e().l());
            } catch (VivoPushException e2) {
                e2.printStackTrace();
                u.a(this.a, " \u521d\u59cb\u5316\u5f02\u5e38 error= " + e2.getMessage());
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Context context2 = ContextDelegate.getContext(context);
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                a = handlerThread;
                handlerThread.start();
                f8631b = new Handler(a.getLooper());
            }
            u.d("PushServiceReceiver", context2.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f8631b);
            a.a(f8632c, context2, action);
            f8631b.removeCallbacks(f8632c);
            f8631b.postDelayed(f8632c, 2000L);
        }
    }
}
