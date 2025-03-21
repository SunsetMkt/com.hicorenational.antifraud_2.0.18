package com.huawei.hms.support.api.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hms.push.C2483c;
import com.huawei.hms.push.C2489i;
import com.huawei.hms.push.C2500t;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Objects;

/* loaded from: classes.dex */
public class HmsMsgService extends Service {

    /* renamed from: com.huawei.hms.support.api.push.service.HmsMsgService$a */
    private static class HandlerC2522a extends Handler {

        /* renamed from: a */
        private Context f7857a;

        HandlerC2522a(Context context) {
            this.f7857a = context;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            Bundle data = message.getData();
            if (Objects.equals(this.f7857a.getApplicationContext().getPackageManager().getNameForUid(message.sendingUid), HMSPackageManager.getInstance(this.f7857a).getHMSPackageName()) && data != null && HMSPackageManager.getInstance(this.f7857a).getHMSPackageStates() == PackageManagerHelper.PackageStates.ENABLED) {
                if (HMSPackageManager.getInstance(this.f7857a).getHMSPackageStates() != PackageManagerHelper.PackageStates.ENABLED) {
                    HMSLog.m7717i("HmsMsgService", "service not start by hms");
                } else {
                    HMSLog.m7717i("HmsMsgService", "chose push type");
                    if (Objects.equals(C2483c.m7541b(data, "push_action"), "com.huawei.push.msg.NOTIFY_MSG")) {
                        if (ResourceLoaderUtil.getmContext() == null) {
                            ResourceLoaderUtil.setmContext(this.f7857a.getApplicationContext());
                        }
                        HMSLog.m7717i("HmsMsgService", "invokeSelfShow");
                        HmsMsgService.m7691c(this.f7857a, data);
                    } else if (Objects.equals(C2483c.m7541b(data, "push_action"), "com.huawei.push.msg.PASSBY_MSG")) {
                        HMSLog.m7717i("HmsMsgService", "sendBroadcastToHms");
                        HmsMsgService.m7692d(this.f7857a, data);
                    }
                }
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m7691c(Context context, Bundle bundle) {
        if (!C2489i.m7565a(context)) {
            HMSLog.m7717i("HmsMsgService", context.getPackageName() + " disable display notification.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
        intent.putExtra("selfshow_info", C2483c.m7540a(bundle, "selfshow_info"));
        intent.putExtra("selfshow_token", C2483c.m7540a(bundle, "selfshow_token"));
        intent.setPackage(C2483c.m7542c(bundle, "push_package"));
        C2500t.m7636a(context, intent);
        HMSLog.m7717i("HmsMsgService", "invokeSelfShow done");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m7692d(Context context, Bundle bundle) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.huawei.android.push.intent.RECEIVE");
            intent.putExtra("msg_data", C2483c.m7540a(bundle, "msg_data"));
            intent.putExtra(RemoteMessageConst.DEVICE_TOKEN, C2483c.m7540a(bundle, RemoteMessageConst.DEVICE_TOKEN));
            intent.putExtra("msgIdStr", C2483c.m7542c(bundle, "msgIdStr"));
            intent.setFlags(32);
            intent.setPackage(C2483c.m7542c(bundle, "push_package"));
            context.sendBroadcast(intent, context.getPackageName() + ".permission.PROCESS_PUSH_MSG");
            HMSLog.m7717i("HmsMsgService", "send broadcast passby done");
        } catch (SecurityException unused) {
            HMSLog.m7717i("HmsMsgService", "send broadcast SecurityException");
        } catch (Exception unused2) {
            HMSLog.m7717i("HmsMsgService", "send broadcast Exception");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        HMSLog.m7717i("HmsMsgService", "onBind");
        return new Messenger(new HandlerC2522a(this)).getBinder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        HMSLog.m7717i("HmsMsgService", "Enter onStartCommand.");
        return 2;
    }
}
