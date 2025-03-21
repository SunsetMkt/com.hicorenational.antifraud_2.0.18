package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.push.C4172dt;

/* loaded from: classes2.dex */
public abstract class PushMessageReceiver extends BroadcastReceiver {
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            AbstractC4022b.m13363e("[CRcv] receive a msg broadcast: " + intent.getAction());
        }
        MessageHandleService.addJob(context.getApplicationContext(), new MessageHandleService.C4034a(intent, this));
        try {
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (intExtra == 2000) {
                C4172dt.m14529a(context.getApplicationContext()).m14532a(context.getPackageName(), intent, 2003, (String) null);
            } else if (intExtra == 6000) {
                C4172dt.m14529a(context.getApplicationContext()).m14532a(context.getPackageName(), intent, AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED, (String) null);
            }
        } catch (Exception e2) {
            AbstractC4022b.m13361d("meet error in PushMessageReceiver. " + e2);
        }
    }

    @Deprecated
    public void onReceiveMessage(Context context, MiPushMessage miPushMessage) {
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
    }

    public void onRequirePermissions(Context context, String[] strArr) {
    }
}
