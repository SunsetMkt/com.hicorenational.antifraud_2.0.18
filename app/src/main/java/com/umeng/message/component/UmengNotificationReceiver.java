package com.umeng.message.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.C3554ac;
import com.umeng.message.proguard.C3564am;
import com.umeng.message.proguard.C3578b;
import com.umeng.message.proguard.C3603w;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class UmengNotificationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        C3578b.m12327c(new Runnable() { // from class: com.umeng.message.component.UmengNotificationReceiver.1
            @Override // java.lang.Runnable
            public final void run() {
                String stringExtra;
                try {
                    if (intent == null || (stringExtra = intent.getStringExtra("MSG")) == null) {
                        return;
                    }
                    int intExtra = intent.getIntExtra("ACTION", -1);
                    UPLog.m12145i("NotificationProxy", String.format(Locale.getDefault(), "onReceive[msg=%s, action=%d]", stringExtra, Integer.valueOf(intExtra)));
                    UMessage uMessage = new UMessage(new JSONObject(stringExtra));
                    if (intExtra == 11) {
                        UPLog.m12145i("NotificationProxy", "notification ignored!");
                        if (!TextUtils.isEmpty(uMessage.getMsgId())) {
                            UTrack.getInstance().trackMsgDismissed(uMessage);
                        }
                        uMessage.dismiss = true;
                        UPushMessageHandler notificationClickHandler = PushAgent.getInstance(context).getNotificationClickHandler();
                        if (notificationClickHandler != null) {
                            notificationClickHandler.handleMessage(context, uMessage);
                        }
                    }
                    C3603w m12454a = C3603w.m12454a();
                    C3554ac m12455a = m12454a.m12455a(uMessage.getMsgId());
                    if (m12455a != null) {
                        m12454a.m12458b(m12455a);
                        C3564am.m12269a(m12455a);
                    }
                } catch (Throwable th) {
                    UPLog.m12143e("NotificationProxy", th);
                }
            }
        });
    }
}
