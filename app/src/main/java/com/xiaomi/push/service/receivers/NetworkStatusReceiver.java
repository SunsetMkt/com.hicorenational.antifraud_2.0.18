package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.p;
import com.xiaomi.mipush.sdk.u;
import com.xiaomi.mipush.sdk.v;
import com.xiaomi.push.au;
import com.xiaomi.push.fz;
import com.xiaomi.push.m;
import com.xiaomi.push.service.ServiceClient;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {
    private static boolean a = false;

    /* JADX INFO: renamed from: b */
    private boolean f9418b;

    /* JADX INFO: renamed from: com.xiaomi.push.service.receivers.NetworkStatusReceiver$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            NetworkStatusReceiver.this.a(context);
        }
    }

    public NetworkStatusReceiver() {
        this.f9418b = false;
        this.f9418b = true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f9418b) {
            return;
        }
        au.m148a();
        m.a().post(new Runnable() { // from class: com.xiaomi.push.service.receivers.NetworkStatusReceiver.1
            final /* synthetic */ Context a;

            AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkStatusReceiver.this.a(context);
            }
        });
    }

    public static boolean a() {
        return a;
    }

    public void a(Context context) {
        if (!u.a(context).m118a() && b.m73a(context).m82c() && !b.m73a(context).m85f()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                ServiceClient.getInstance(context).startServiceSafely(intent);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
        fz.m445a(context);
        if (au.m149a(context) && u.a(context).m121b()) {
            u.a(context).m122c();
        }
        if (au.m149a(context)) {
            if ("syncing".equals(p.a(context).a(v.DISABLE_PUSH))) {
                MiPushClient.disablePush(context);
            }
            if ("syncing".equals(p.a(context).a(v.ENABLE_PUSH))) {
                MiPushClient.enablePush(context);
            }
            if ("syncing".equals(p.a(context).a(v.UPLOAD_HUAWEI_TOKEN))) {
                u.a(context).a((String) null, v.UPLOAD_HUAWEI_TOKEN, d.ASSEMBLE_PUSH_HUAWEI, "net");
            }
            if ("syncing".equals(p.a(context).a(v.UPLOAD_FCM_TOKEN))) {
                u.a(context).a((String) null, v.UPLOAD_HUAWEI_TOKEN, d.ASSEMBLE_PUSH_HUAWEI, "net");
            }
            if ("syncing".equals(p.a(context).a(v.UPLOAD_COS_TOKEN))) {
                u.a(context).a((String) null, v.UPLOAD_COS_TOKEN, d.ASSEMBLE_PUSH_COS, "net");
            }
            if ("syncing".equals(p.a(context).a(v.UPLOAD_FTOS_TOKEN))) {
                u.a(context).a((String) null, v.UPLOAD_FTOS_TOKEN, d.ASSEMBLE_PUSH_FTOS, "net");
            }
            if (HWPushHelper.needConnect() && HWPushHelper.shouldTryConnect(context)) {
                HWPushHelper.setConnectTime(context);
                HWPushHelper.registerHuaWeiAssemblePush(context);
            }
            COSPushHelper.doInNetworkChange(context);
            FTOSPushHelper.doInNetworkChange(context);
        }
    }

    public NetworkStatusReceiver(Object obj) {
        this.f9418b = false;
        a = true;
    }
}
