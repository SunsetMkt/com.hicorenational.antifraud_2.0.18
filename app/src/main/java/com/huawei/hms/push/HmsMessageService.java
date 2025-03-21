package com.huawei.hms.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.threads.AsyncExec;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.push.HandlerC2486f;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public class HmsMessageService extends Service {
    public static final String PROXY_TYPE = "proxy_type";
    public static final String SUBJECT_ID = "subject_id";

    /* renamed from: a */
    private final Messenger f7684a = new Messenger(new HandlerC2486f(new C2479b(this, null)));

    /* renamed from: com.huawei.hms.push.HmsMessageService$a */
    class RunnableC2478a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f7685a;

        /* renamed from: b */
        final /* synthetic */ String f7686b;

        RunnableC2478a(String str, String str2) {
            this.f7685a = str;
            this.f7686b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context applicationContext = HmsMessageService.this.getApplicationContext();
            if (this.f7686b.equals(BaseUtils.getLocalToken(applicationContext, this.f7685a))) {
                return;
            }
            HMSLog.m7717i("HmsMessageService", "receive a new token, refresh the local token");
            BaseUtils.saveToken(applicationContext, this.f7685a, this.f7686b);
        }
    }

    /* renamed from: com.huawei.hms.push.HmsMessageService$b */
    private class C2479b implements HandlerC2486f.a {
        private C2479b() {
        }

        @Override // com.huawei.hms.push.HandlerC2486f.a
        /* renamed from: a */
        public void mo7517a(Message message) {
            if (message == null) {
                HMSLog.m7715e("HmsMessageService", "receive message is null");
                return;
            }
            HMSLog.m7717i("HmsMessageService", "handle message start...");
            Bundle data = Message.obtain(message).getData();
            if (data != null) {
                Intent intent = new Intent();
                intent.putExtras(data);
                intent.putExtra(RemoteMessageConst.INPUT_TYPE, data.getInt(RemoteMessageConst.INPUT_TYPE, -1));
                HmsMessageService.this.handleIntentMessage(intent);
            }
        }

        /* synthetic */ C2479b(HmsMessageService hmsMessageService, RunnableC2478a runnableC2478a) {
            this();
        }
    }

    /* renamed from: a */
    private void m7512a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AsyncExec.submitSeqIO(new RunnableC2478a(str2, str));
    }

    /* renamed from: b */
    private void m7514b(Intent intent) {
        HMSLog.m7717i("HmsMessageService", "parse batch response.");
        String stringExtra = intent.getStringExtra("batchMsgbody");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(stringExtra);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String optString = jSONObject.optString("transactionId");
                String optString2 = jSONObject.optString(RemoteMessageConst.MSGID);
                int optInt = jSONObject.optInt("ret", ErrorEnum.ERROR_UNKNOWN.getInternalCode());
                if (ErrorEnum.SUCCESS.getInternalCode() == optInt) {
                    m7515b(optString, optString2);
                } else {
                    m7516b(optString, optString2, optInt);
                }
            }
        } catch (JSONException unused) {
            HMSLog.m7718w("HmsMessageService", "parse batch response failed.");
        }
    }

    protected void doMsgReceived(Intent intent) {
        onMessageReceived(new RemoteMessage(m7508a(intent)));
    }

    public void handleIntentMessage(Intent intent) {
        if (intent == null) {
            HMSLog.m7715e("HmsMessageService", "receive message is null");
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("message_id");
            String stringExtra2 = intent.getStringExtra("message_type");
            String stringExtra3 = intent.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);
            if ("new_token".equals(stringExtra2)) {
                HMSLog.m7717i("HmsMessageService", "onNewToken");
                m7511a(intent, stringExtra3);
            } else if ("received_message".equals(stringExtra2)) {
                HMSLog.m7717i("HmsMessageService", "onMessageReceived, message id:" + stringExtra);
                m7513a(PushNaming.RECEIVE_MSG_RSP, stringExtra, ErrorEnum.SUCCESS.getInternalCode());
                doMsgReceived(intent);
            } else if ("sent_message".equals(stringExtra2)) {
                m7515b(stringExtra3, stringExtra);
            } else if ("send_error".equals(stringExtra2)) {
                m7516b(stringExtra3, stringExtra, intent.getIntExtra("error", ErrorEnum.ERROR_UNKNOWN.getInternalCode()));
            } else if ("delivery".equals(stringExtra2)) {
                int intExtra = intent.getIntExtra("error", ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode());
                HMSLog.m7717i("HmsMessageService", "onMessageDelivery, message id:" + stringExtra + ", status:" + intExtra + ", transactionId: " + stringExtra3);
                m7513a(PushNaming.UPSEND_RECEIPT, stringExtra3, intExtra);
                onMessageDelivered(stringExtra, new SendException(intExtra));
            } else if ("server_deleted_message".equals(stringExtra2)) {
                HMSLog.m7717i("HmsMessageService", "delete message, message id:" + stringExtra);
                onDeletedMessages();
            } else if ("batchSent".equals(stringExtra2)) {
                m7514b(intent);
            } else {
                HMSLog.m7715e("HmsMessageService", "Receive unknown message: " + stringExtra2);
            }
        } catch (RuntimeException e2) {
            HMSLog.m7715e("HmsMessageService", "handle intent RuntimeException: " + e2.getMessage());
        } catch (Exception e3) {
            HMSLog.m7715e("HmsMessageService", "handle intent exception: " + e3.getMessage());
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        HMSLog.m7717i("HmsMessageService", "start to bind");
        return this.f7684a.getBinder();
    }

    public void onDeletedMessages() {
    }

    @Override // android.app.Service
    public void onDestroy() {
        HMSLog.m7717i("HmsMessageService", "start to destroy");
        super.onDestroy();
    }

    public void onMessageDelivered(String str, Exception exc) {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onNewToken(String str, Bundle bundle) {
    }

    public void onSendError(String str, Exception exc) {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        HMSLog.m7717i("HmsMessageService", "start to command , startId = " + i3);
        handleIntentMessage(intent);
        return 2;
    }

    public void onTokenError(Exception exc) {
    }

    public void onTokenError(Exception exc, Bundle bundle) {
    }

    /* renamed from: a */
    private Bundle m7508a(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putString("message_id", intent.getStringExtra("message_id"));
        bundle.putByteArray(RemoteMessageConst.MSGBODY, intent.getByteArrayExtra(RemoteMessageConst.MSGBODY));
        bundle.putString(RemoteMessageConst.DEVICE_TOKEN, intent.getStringExtra(RemoteMessageConst.DEVICE_TOKEN));
        if (intent.getIntExtra(RemoteMessageConst.INPUT_TYPE, -1) == 1) {
            bundle.putInt(RemoteMessageConst.INPUT_TYPE, 1);
        }
        return bundle;
    }

    /* renamed from: a */
    private void m7511a(Intent intent, String str) {
        int intExtra = intent.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode());
        m7513a(PushNaming.GETTOKEN_ASYNC_RSP, str, intExtra);
        String stringExtra = intent.getStringExtra("subjectId");
        String stringExtra2 = intent.getStringExtra("message_proxy_type");
        HMSLog.m7717i("HmsMessageService", "doOnNewToken:transactionId = " + str + " , internalCode = " + intExtra + ",subjectId:" + stringExtra + ",proxyType:" + stringExtra2);
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(stringExtra)) {
            bundle.putString(SUBJECT_ID, stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            bundle.putString(PROXY_TYPE, stringExtra2);
        }
        if (intExtra == ErrorEnum.SUCCESS.getInternalCode()) {
            HMSLog.m7717i("HmsMessageService", "Apply token OnNewToken, subId: " + stringExtra);
            m7509a(intent, bundle, stringExtra);
            return;
        }
        HMSLog.m7717i("HmsMessageService", "Apply token failed, subId: " + stringExtra);
        m7510a(intent, bundle, stringExtra, intExtra);
    }

    /* renamed from: b */
    private void m7515b(String str, String str2) {
        HMSLog.m7717i("HmsMessageService", "onMessageSent, message id:" + str2 + ", transactionId: " + str);
        m7513a(PushNaming.UPSEND_MSG_ASYNC_RSP, str, ErrorEnum.SUCCESS.getInternalCode());
        onMessageSent(str2);
    }

    /* renamed from: b */
    private void m7516b(String str, String str2, int i2) {
        HMSLog.m7717i("HmsMessageService", "onSendError, message id:" + str2 + " error:" + i2 + ", transactionId: " + str);
        m7513a(PushNaming.UPSEND_MSG_ASYNC_RSP, str, i2);
        onSendError(str2, new SendException(i2));
    }

    /* renamed from: a */
    private synchronized void m7510a(Intent intent, Bundle bundle, String str, int i2) {
        Context applicationContext = getApplicationContext();
        boolean z = !TextUtils.isEmpty(BaseUtils.getCacheData(applicationContext, applicationContext.getPackageName(), false));
        if (bundle.isEmpty() && z) {
            HMSLog.m7717i("HmsMessageService", "onTokenError to host app.");
            onTokenError(new BaseException(i2));
            BaseUtils.deleteCacheData(applicationContext, applicationContext.getPackageName());
        }
        if (TextUtils.isEmpty(str)) {
            String[] subjectIds = BaseUtils.getSubjectIds(applicationContext);
            if (subjectIds != null && subjectIds.length != 0) {
                for (int i3 = 0; i3 < subjectIds.length; i3++) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(SUBJECT_ID, subjectIds[i3]);
                    HMSLog.m7717i("HmsMessageService", "onTokenError to sub app, subjectId:" + subjectIds[i3]);
                    onTokenError(new BaseException(i2), bundle2);
                }
                BaseUtils.clearSubjectIds(applicationContext);
            }
            HMSLog.m7717i("HmsMessageService", "onTokenError to host app with bundle.");
            onTokenError(new BaseException(i2), bundle);
            return;
        }
        HMSLog.m7717i("HmsMessageService", "onTokenError to sub app, subjectId:" + str);
        onTokenError(new BaseException(i2), bundle);
    }

    /* renamed from: a */
    private synchronized void m7509a(Intent intent, Bundle bundle, String str) {
        String stringExtra = intent.getStringExtra(RemoteMessageConst.DEVICE_TOKEN);
        m7512a(stringExtra, str);
        Context applicationContext = getApplicationContext();
        boolean z = !TextUtils.isEmpty(BaseUtils.getCacheData(applicationContext, applicationContext.getPackageName(), false));
        if (bundle.isEmpty() && z) {
            HMSLog.m7717i("HmsMessageService", "onNewToken to host app.");
            onNewToken(stringExtra);
            BaseUtils.deleteCacheData(applicationContext, applicationContext.getPackageName());
        }
        if (TextUtils.isEmpty(str)) {
            String[] subjectIds = BaseUtils.getSubjectIds(applicationContext);
            if (subjectIds != null && subjectIds.length != 0) {
                for (int i2 = 0; i2 < subjectIds.length; i2++) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(SUBJECT_ID, subjectIds[i2]);
                    HMSLog.m7717i("HmsMessageService", "onNewToken to sub app, subjectId:" + subjectIds[i2]);
                    onNewToken(stringExtra, bundle2);
                    m7512a(stringExtra, subjectIds[i2]);
                }
                BaseUtils.clearSubjectIds(applicationContext);
            }
            HMSLog.m7717i("HmsMessageService", "onNewToken to host app with bundle.");
            bundle.putString("belongId", intent.getStringExtra("belongId"));
            onNewToken(stringExtra, bundle);
            return;
        }
        HMSLog.m7717i("HmsMessageService", "onNewToken to sub app, subjectId:" + str);
        onNewToken(stringExtra, bundle);
    }

    /* renamed from: a */
    private void m7513a(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = AbstractC1191a.f2571h;
        }
        PushBiUtil.reportExit(getApplicationContext(), str, str2, i2);
    }
}
