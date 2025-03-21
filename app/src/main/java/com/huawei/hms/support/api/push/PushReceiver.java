package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.push.AbstractC2481a;
import com.huawei.hms.push.AbstractC2484d;
import com.huawei.hms.push.C2497q;
import com.huawei.hms.push.C2498r;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class PushReceiver extends BroadcastReceiver {

    /* renamed from: com.huawei.hms.support.api.push.PushReceiver$b */
    private static class RunnableC2520b implements Runnable {

        /* renamed from: a */
        private Context f7853a;

        /* renamed from: b */
        private Intent f7854b;

        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
            intent.setPackage(this.f7854b.getPackage());
            try {
                JSONObject m7686b = PushReceiver.m7686b(this.f7854b);
                String string = JsonUtil.getString(m7686b, "moduleName", "");
                int i2 = JsonUtil.getInt(m7686b, "msgType", 0);
                int i3 = JsonUtil.getInt(m7686b, NotificationCompat.CATEGORY_STATUS, 0);
                if (ErrorEnum.SUCCESS.getInternalCode() != i3) {
                    i3 = ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode();
                }
                Bundle bundle = new Bundle();
                if ("Push".equals(string) && i2 == 1) {
                    bundle.putString("message_type", "delivery");
                    bundle.putString("message_id", JsonUtil.getString(m7686b, RemoteMessageConst.MSGID, ""));
                    bundle.putInt("error", i3);
                    bundle.putString(CommonCode.MapKey.TRANSACTION_ID, JsonUtil.getString(m7686b, "transactionId", ""));
                } else {
                    if (this.f7854b.getExtras() != null) {
                        bundle.putAll(this.f7854b.getExtras());
                    }
                    bundle.putString("message_type", "received_message");
                    bundle.putString("message_id", this.f7854b.getStringExtra("msgIdStr"));
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, this.f7854b.getByteArrayExtra("msg_data"));
                    bundle.putString(RemoteMessageConst.DEVICE_TOKEN, AbstractC2481a.m7538a(this.f7854b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN)));
                    bundle.putInt(RemoteMessageConst.INPUT_TYPE, 1);
                    bundle.putString("message_proxy_type", this.f7854b.getStringExtra("message_proxy_type"));
                }
                if (new C2498r().m7633a(this.f7853a, bundle, intent)) {
                    HMSLog.m7717i("PushReceiver", "receive " + this.f7854b.getAction() + " and start service success");
                    return;
                }
                HMSLog.m7715e("PushReceiver", "receive " + this.f7854b.getAction() + " and start service failed");
            } catch (RuntimeException unused) {
                HMSLog.m7715e("PushReceiver", "handle push message occur exception.");
            }
        }

        private RunnableC2520b(Context context, Intent intent) {
            this.f7853a = context;
            this.f7854b = intent;
        }
    }

    /* renamed from: com.huawei.hms.support.api.push.PushReceiver$c */
    private static class RunnableC2521c implements Runnable {

        /* renamed from: a */
        private Context f7855a;

        /* renamed from: b */
        private Intent f7856b;

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] byteArrayExtra = this.f7856b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN);
                if (byteArrayExtra != null && byteArrayExtra.length != 0) {
                    HMSLog.m7717i("PushReceiver", "receive a push token: " + this.f7855a.getPackageName());
                    Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
                    intent.setPackage(this.f7856b.getPackage());
                    Bundle bundle = new Bundle();
                    bundle.putString("message_type", "new_token");
                    bundle.putString(RemoteMessageConst.DEVICE_TOKEN, AbstractC2481a.m7538a(byteArrayExtra));
                    bundle.putString(CommonCode.MapKey.TRANSACTION_ID, this.f7856b.getStringExtra(CommonCode.MapKey.TRANSACTION_ID));
                    bundle.putString("subjectId", this.f7856b.getStringExtra("subjectId"));
                    bundle.putInt("error", this.f7856b.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode()));
                    bundle.putString("belongId", this.f7856b.getStringExtra("belongId"));
                    if (new C2498r().m7633a(this.f7855a, bundle, intent)) {
                        return;
                    }
                    HMSLog.m7715e("PushReceiver", "receive " + this.f7856b.getAction() + " and start service failed");
                    return;
                }
                HMSLog.m7717i("PushReceiver", "get a deviceToken, but it is null or empty");
            } catch (RejectedExecutionException unused) {
                HMSLog.m7715e("PushReceiver", "execute task error");
            } catch (Exception unused2) {
                HMSLog.m7715e("PushReceiver", "handle push token error");
            }
        }

        private RunnableC2521c(Context context, Intent intent) {
            this.f7855a = context;
            this.f7856b = intent;
        }
    }

    /* renamed from: b */
    private void m7688b(Context context, Intent intent) {
        try {
            if (intent.hasExtra(RemoteMessageConst.DEVICE_TOKEN)) {
                C2497q.m7629a().execute(new RunnableC2521c(context, intent));
            } else {
                HMSLog.m7717i("PushReceiver", "This message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.m7715e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.m7715e("PushReceiver", "handlePushTokenEvent execute task error");
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        HMSLog.m7717i("PushReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
        try {
            intent.getStringExtra("TestIntent");
            String action = intent.getAction();
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context.getApplicationContext());
            }
            if ("com.huawei.android.push.intent.REGISTRATION".equals(action)) {
                m7688b(context, intent);
            } else if ("com.huawei.android.push.intent.RECEIVE".equals(action)) {
                m7685a(context, intent);
            } else {
                HMSLog.m7717i("PushReceiver", "message can't be recognised.");
            }
        } catch (Exception unused) {
            HMSLog.m7715e("PushReceiver", "intent has some error");
        }
    }

    /* renamed from: a */
    private void m7685a(Context context, Intent intent) {
        try {
            if (intent.hasExtra("msg_data")) {
                C2497q.m7629a().execute(new RunnableC2520b(context, intent));
            } else {
                HMSLog.m7717i("PushReceiver", "This push message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.m7715e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.m7715e("PushReceiver", "handlePushMessageEvent execute task error");
        }
    }

    /* renamed from: b */
    private static JSONObject m7687b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    /* renamed from: a */
    private static JSONObject m7684a(byte[] bArr) {
        try {
            return new JSONObject(AbstractC2481a.m7538a(bArr));
        } catch (JSONException unused) {
            HMSLog.m7718w("PushReceiver", "JSONException:parse message body failed.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static JSONObject m7686b(Intent intent) throws RuntimeException {
        JSONObject m7684a = m7684a(intent.getByteArrayExtra("msg_data"));
        JSONObject m7683a = m7683a(m7684a);
        String string = JsonUtil.getString(m7683a, "data", null);
        if (AbstractC2484d.m7545a(m7683a, m7687b(m7683a), string)) {
            return m7684a;
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static JSONObject m7683a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
