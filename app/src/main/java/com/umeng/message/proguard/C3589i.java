package com.umeng.message.proguard;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.taobao.accs.EventReceiver;
import com.taobao.agoo.AgooCommondReceiver;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.message.common.UPLog;
import org.json.JSONObject;

/* renamed from: com.umeng.message.proguard.i */
/* loaded from: classes2.dex */
public final class C3589i {

    /* renamed from: a */
    private static boolean f13284a = false;

    /* renamed from: b */
    private static volatile boolean f13285b = true;

    /* renamed from: com.umeng.message.proguard.i$a */
    static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(final Context context, final Intent intent) {
            if (!C3589i.f13285b || intent == null || intent.getData() == null) {
                return;
            }
            C3578b.m12327c(new Runnable() { // from class: com.umeng.message.proguard.i.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        C3589i.m12409a(context, intent);
                    } catch (Throwable th) {
                        UPLog.m12143e("RH", th);
                    }
                }
            });
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* renamed from: com.umeng.message.proguard.i$b */
    static class b extends BroadcastReceiver {

        /* renamed from: a */
        private final BroadcastReceiver f13289a = new EventReceiver();

        b() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(final Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            C3578b.m12327c(new Runnable() { // from class: com.umeng.message.proguard.i.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        b.this.f13289a.onReceive(context, intent);
                    } catch (Throwable th) {
                        UPLog.m12143e("RH", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m12411a(boolean z) {
        f13285b = z;
    }

    /* renamed from: a */
    public static synchronized void m12408a() {
        synchronized (C3589i.class) {
            if (f13284a) {
                return;
            }
            Application m12460a = C3604x.m12460a();
            if (m12460a == null) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                m12460a.registerReceiver(new b(), intentFilter);
            } catch (Throwable unused) {
            }
            if (f13285b) {
                try {
                    IntentFilter intentFilter2 = new IntentFilter();
                    intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter2.addAction("android.intent.action.PACKAGE_REMOVED");
                    intentFilter2.addDataScheme("package");
                    m12460a.registerReceiver(new a((byte) 0), intentFilter2);
                } catch (Throwable unused2) {
                }
                f13284a = true;
            }
        }
    }

    /* renamed from: a */
    private static void m12410a(String str, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pkg", str);
            jSONObject.put("action_type", i2);
            UMWorkDispatch.sendEvent(C3604x.m12460a(), 16390, C3602v.m12452a(), jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m12409a(Context context, Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        String action = intent.getAction();
        String schemeSpecificPart = data.getSchemeSpecificPart();
        if (schemeSpecificPart == null || schemeSpecificPart.length() == 0) {
            return;
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(action) && !booleanExtra) {
            m12410a(schemeSpecificPart, 80);
            new AgooCommondReceiver().onReceive(context, intent);
        } else if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
            if (booleanExtra) {
                m12410a(schemeSpecificPart, 81);
            } else {
                m12410a(schemeSpecificPart, 82);
            }
        }
    }
}
