package com.umeng.message;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.agoo.BaseNotifyClick;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.C3574aw;
import com.umeng.message.proguard.C3604x;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class UmengNotifyClick extends BaseNotifyClick {
    private static final String TAG = "NotifyClickActivity";

    protected void onChangeBadgeNumber(UMessage uMessage) {
        Application m12460a = C3604x.m12460a();
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(m12460a);
        if (TextUtils.equals(uMessage.getMsgId(), messageSharedPrefs.m12126f())) {
            return;
        }
        messageSharedPrefs.m12123c(uMessage.getMsgId());
        C3574aw.m12314b(m12460a, -1);
    }

    @Override // com.taobao.agoo.BaseNotifyClick
    public final void onMessage(Intent intent) {
        UMessage uMessage = null;
        try {
            String stringExtra = intent.getStringExtra("body");
            UPLog.m12145i(TAG, "msg:", stringExtra, "source:", intent.getStringExtra(AgooConstants.MESSAGE_SOURCE));
            onMessageReceived(intent);
            if (stringExtra != null && stringExtra.length() != 0) {
                String stringExtra2 = intent.getStringExtra("id");
                String stringExtra3 = intent.getStringExtra(AgooConstants.MESSAGE_TASK_ID);
                JSONObject jSONObject = new JSONObject(stringExtra);
                jSONObject.put("agoo_msg_id", stringExtra2);
                jSONObject.put("agoo_task_id", stringExtra3);
                UMessage uMessage2 = new UMessage(jSONObject);
                try {
                    UTrack.getInstance().trackMfrPushMsgClick(uMessage2);
                    onChangeBadgeNumber(uMessage2);
                    try {
                        onMessage(uMessage2);
                        return;
                    } catch (Throwable th) {
                        UPLog.m12143e(TAG, th);
                        return;
                    }
                } catch (Throwable th2) {
                    uMessage = uMessage2;
                    th = th2;
                    try {
                        UPLog.m12143e(TAG, th);
                        if (uMessage == null) {
                            try {
                            } catch (Throwable th3) {
                                return;
                            }
                        }
                        return;
                    } finally {
                        if (uMessage == null) {
                            try {
                                uMessage = new UMessage(new JSONObject());
                            } catch (Throwable th32) {
                                UPLog.m12143e(TAG, th32);
                            }
                        }
                        onMessage(uMessage);
                    }
                }
            }
            try {
                onMessage(new UMessage(new JSONObject()));
            } catch (Throwable th4) {
                UPLog.m12143e(TAG, th4);
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    protected abstract void onMessage(UMessage uMessage);

    protected void onMessageReceived(Intent intent) {
    }
}
