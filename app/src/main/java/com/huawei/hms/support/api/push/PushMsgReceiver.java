package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.push.C2489i;
import com.huawei.hms.push.C2500t;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* loaded from: classes.dex */
public class PushMsgReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static void m7681a(Context context, Intent intent) {
        if (intent.hasExtra("selfshow_info")) {
            if (!C2489i.m7565a(context)) {
                HMSLog.m7717i("PushMsgReceiver", context.getPackageName() + " disable display notification.");
                if (!intent.hasExtra("selfshow_event_id")) {
                    return;
                }
            }
            C2500t.m7636a(context, intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        HMSLog.m7717i("PushMsgReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
        try {
            intent.getStringExtra("TestIntent");
            String action = intent.getAction();
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context.getApplicationContext());
            }
            if ("com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action) || ("com.huawei.intent.action.PUSH".equals(action) && HwBuildEx.VERSION.EMUI_SDK_INT < 10)) {
                m7681a(context, intent);
            } else {
                HMSLog.m7717i("PushMsgReceiver", "message can't be recognised.");
            }
        } catch (Exception unused) {
            HMSLog.m7715e("PushMsgReceiver", "intent has some error");
        }
    }
}
