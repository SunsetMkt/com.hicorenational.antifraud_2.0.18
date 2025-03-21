package com.xiaomi.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: com.xiaomi.push.m */
/* loaded from: classes2.dex */
public class C4303m {

    /* renamed from: a */
    private static volatile Handler f16372a;

    /* renamed from: a */
    private static final Object f16373a = new Object();

    /* renamed from: b */
    private static volatile Handler f16374b;

    /* renamed from: a */
    public static Handler m15703a() {
        if (f16374b == null) {
            synchronized (f16373a) {
                if (f16374b == null) {
                    HandlerThread handlerThread = new HandlerThread("receiver_task");
                    handlerThread.start();
                    f16374b = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f16374b;
    }

    /* renamed from: b */
    private static Handler m15704b() {
        if (f16372a == null) {
            synchronized (C4303m.class) {
                if (f16372a == null) {
                    HandlerThread handlerThread = new HandlerThread("handle_receiver");
                    handlerThread.start();
                    f16372a = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f16372a;
    }

    /* renamed from: a */
    public static Intent m15699a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i2) {
        return m15700a(context, broadcastReceiver, intentFilter, (String) null, i2);
    }

    /* renamed from: a */
    public static Intent m15700a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, int i2) {
        return m15702a(context, broadcastReceiver, intentFilter, str, m15704b(), i2);
    }

    /* renamed from: a */
    public static Intent m15701a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return m15702a(context, broadcastReceiver, intentFilter, str, handler, 2);
    }

    /* renamed from: a */
    public static Intent m15702a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i2) {
        if (context == null || broadcastReceiver == null || intentFilter == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i2);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }
}
