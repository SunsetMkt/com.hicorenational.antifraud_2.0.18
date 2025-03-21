package com.xiaomi.push;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;

/* renamed from: com.xiaomi.push.ad */
/* loaded from: classes2.dex */
public class C4075ad {
    /* renamed from: a */
    public static boolean m13695a(Context context) {
        try {
            return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m13696b(Context context) {
        Intent intent = null;
        try {
            intent = C4303m.m15701a(context, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), (String) null, (Handler) null);
        } catch (Exception unused) {
        }
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        return intExtra == 2 || intExtra == 5;
    }
}
