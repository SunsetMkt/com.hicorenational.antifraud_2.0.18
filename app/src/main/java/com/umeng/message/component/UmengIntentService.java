package com.umeng.message.component;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.taobao.agoo.TaobaoBaseIntentService;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.message.UTrack;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.AbstractServiceC3597q;
import com.umeng.message.proguard.C3566ao;
import com.umeng.message.proguard.C3586f;
import com.umeng.message.proguard.C3601u;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class UmengIntentService extends TaobaoBaseIntentService {
    @Override // org.android.agoo.control.BaseIntentService, android.app.Service
    public final IBinder onBind(Intent intent) {
        try {
            return super.onBind(intent);
        } catch (Throwable th) {
            UPLog.m12143e("UmengIntentService", th);
            return null;
        }
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService, org.android.agoo.control.BaseIntentService
    protected final void onError(Context context, String str) {
        UPLog.m12144e("UmengIntentService", "onError msg:", str);
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService, org.android.agoo.control.BaseIntentService
    protected final void onMessage(Context context, Intent intent) {
        String stringExtra;
        String stringExtra2;
        String stringExtra3;
        JSONObject optJSONObject;
        try {
            UPLog.m12145i("UmengIntentService", "onMessage");
            stringExtra = intent.getStringExtra("body");
            stringExtra2 = intent.getStringExtra("id");
            stringExtra3 = intent.getStringExtra(AgooConstants.MESSAGE_TASK_ID);
        } catch (Throwable th) {
            UPLog.m12143e("UmengIntentService", th);
        }
        if (stringExtra == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(stringExtra);
        jSONObject.put("agoo_msg_id", stringExtra2);
        jSONObject.put("agoo_task_id", stringExtra3);
        UMessage uMessage = new UMessage(jSONObject);
        C3566ao.m12272a(context).m12273a(uMessage.getMsgId(), 0, System.currentTimeMillis());
        UTrack.getInstance().trackMsgArrival(uMessage);
        if (TextUtils.equals(C3351bh.f11627az, uMessage.getDisplayType())) {
            try {
                String custom = uMessage.getCustom();
                if (custom == null || custom.length() <= 0 || (optJSONObject = new JSONObject(custom).optJSONObject("id_res")) == null) {
                    return;
                }
                C3586f.m12385a(context, optJSONObject.optString("id"), optJSONObject.optLong("d_ts", 0L));
                return;
            } catch (Throwable th2) {
                UPLog.m12143e("UmengIntentService", th2);
                return;
            }
        }
        UPLog.m12145i("UmengIntentService", "message:", jSONObject);
        Intent intent2 = new Intent("com.umeng.message.action");
        intent2.setPackage(context.getPackageName());
        intent2.putExtra("um_command", "handle");
        intent2.putExtra("body", uMessage.getRaw().toString());
        String pushIntentServiceClass = C3601u.m12450a().getPushIntentServiceClass();
        Class<?> cls = null;
        if (!TextUtils.isEmpty(pushIntentServiceClass)) {
            try {
                cls = Class.forName(pushIntentServiceClass);
            } catch (Throwable th3) {
                UPLog.m12143e("UmengIntentService", th3);
            }
        }
        if (cls == null) {
            cls = UmengMessageHandlerService.class;
        }
        intent2.setClass(context, cls);
        AbstractServiceC3597q.enqueueWork(context, cls, intent2);
        return;
        UPLog.m12143e("UmengIntentService", th);
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService, org.android.agoo.control.BaseIntentService
    protected final void onRegistered(Context context, String str) {
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService
    protected final void onUnregistered(Context context, String str) {
    }
}
