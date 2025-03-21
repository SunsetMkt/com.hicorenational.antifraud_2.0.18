package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.utils.PluginUtil;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: SelfShow.java */
/* renamed from: com.huawei.hms.push.t */
/* loaded from: classes.dex */
public class C2500t {
    /* renamed from: a */
    public static void m7636a(Context context, Intent intent) {
        try {
            if (context == null || intent == null) {
                HMSLog.m7712d("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");
                return;
            }
            String action = intent.getAction();
            if ("com.huawei.intent.action.PUSH".equals(action) || "com.huawei.push.msg.NOTIFY_MSG".equals(action) || "com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action)) {
                byte[] byteArrayExtra = intent.getByteArrayExtra("selfshow_info");
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("selfshow_token");
                if (byteArrayExtra != null && byteArrayExtra2 != null && byteArrayExtra.length != 0 && byteArrayExtra2.length != 0) {
                    m7639a(context, intent, byteArrayExtra, byteArrayExtra2);
                    return;
                }
                HMSLog.m7717i("PushSelfShowLog", "self show info or token is null.");
            }
        } catch (RuntimeException e2) {
            HMSLog.m7716e("PushSelfShowLog", "onReceive RuntimeException.", e2);
        } catch (Exception unused) {
            HMSLog.m7712d("PushSelfShowLog", "onReceive Exception.");
        }
    }

    /* renamed from: a */
    private static void m7639a(Context context, Intent intent, byte[] bArr, byte[] bArr2) {
        String stringExtra = intent.getStringExtra("selfshow_event_id");
        int intExtra = intent.getIntExtra("selfshow_notify_id", 0);
        HMSLog.m7717i("PushSelfShowLog", "get notifyId:" + intExtra);
        C2495o c2495o = new C2495o(bArr, bArr2);
        if (!c2495o.m7624y()) {
            HMSLog.m7712d("PushSelfShowLog", "parseMessage failed");
            return;
        }
        HMSLog.m7717i("PushSelfShowLog", "onReceive the msg id = " + c2495o.m7616o() + ",and cmd is " + c2495o.m7609h() + ",and the eventId is " + stringExtra);
        if (stringExtra == null) {
            m7637a(context, intent, c2495o);
        } else {
            m7638a(context, intent, stringExtra, c2495o, intExtra);
        }
    }

    /* renamed from: a */
    private static void m7637a(Context context, Intent intent, C2495o c2495o) {
        HMSLog.m7717i("PushSelfShowLog", "receive a selfshow message, the cmd type is " + c2495o.m7609h());
        if (C2501u.m7644a(c2495o.m7609h())) {
            new C2496p(context, c2495o).start();
        }
    }

    /* renamed from: a */
    private static void m7638a(Context context, Intent intent, String str, C2495o c2495o, int i2) {
        HMSLog.m7712d("PushSelfShowLog", "receive a selfshow user handle message eventId = " + str);
        if ("1".equals(str)) {
            new C2501u(context, c2495o).m7646c();
            PluginUtil.onNotificationClicked(context, c2495o.m7616o(), c2495o.m7603b());
        } else if ("2".equals(str)) {
            C2492l.m7571a(context, c2495o.m7616o(), c2495o.m7603b(), "2");
        } else {
            HMSLog.m7712d("PushSelfShowLog", "other event");
        }
    }
}
