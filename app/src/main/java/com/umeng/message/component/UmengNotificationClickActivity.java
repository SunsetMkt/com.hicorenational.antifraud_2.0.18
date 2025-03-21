package com.umeng.message.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.C3554ac;
import com.umeng.message.proguard.C3564am;
import com.umeng.message.proguard.C3603w;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class UmengNotificationClickActivity extends Activity {
    /* renamed from: a */
    private void m12152a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("MSG");
            if (stringExtra != null && stringExtra.length() != 0) {
                UMessage uMessage = new UMessage(new JSONObject(stringExtra));
                UTrack.getInstance().trackMsgClick(uMessage);
                Context applicationContext = getApplicationContext();
                UPLog.m12145i("NotificationClick", uMessage.getRaw());
                UPushMessageHandler notificationClickHandler = PushAgent.getInstance(applicationContext).getNotificationClickHandler();
                if (notificationClickHandler != null) {
                    notificationClickHandler.handleMessage(applicationContext, uMessage);
                } else {
                    UPLog.m12145i("NotificationClick", "handle == null skipped!");
                }
                C3603w m12454a = C3603w.m12454a();
                C3554ac m12455a = m12454a.m12455a(uMessage.getMsgId());
                if (m12455a != null) {
                    m12454a.m12458b(m12455a);
                    C3564am.m12269a(m12455a);
                }
            }
        } catch (Throwable th) {
            try {
                UPLog.m12143e("NotificationClick", th);
            } finally {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = 1;
            attributes.height = 1;
            attributes.gravity = 8388659;
            window.setAttributes(attributes);
            m12152a(getIntent());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            m12152a(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
