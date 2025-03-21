package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.C4048b;
import com.xiaomi.mipush.sdk.C4062p;
import com.xiaomi.mipush.sdk.C4067u;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.EnumC4050d;
import com.xiaomi.mipush.sdk.EnumC4068v;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.C4092au;
import com.xiaomi.push.C4232fz;
import com.xiaomi.push.C4303m;
import com.xiaomi.push.service.ServiceClient;

/* loaded from: classes2.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static boolean f16767a = false;

    /* renamed from: b */
    private boolean f16768b;

    public NetworkStatusReceiver() {
        this.f16768b = false;
        this.f16768b = true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (this.f16768b) {
            return;
        }
        C4092au.m13797a();
        C4303m.m15703a().post(new Runnable() { // from class: com.xiaomi.push.service.receivers.NetworkStatusReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                NetworkStatusReceiver.this.m16224a(context);
            }
        });
    }

    /* renamed from: a */
    public static boolean m16226a() {
        return f16767a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16224a(Context context) {
        if (!C4067u.m13627a(context).m13671a() && C4048b.m13476a(context).m13496c() && !C4048b.m13476a(context).m13502f()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                ServiceClient.getInstance(context).startServiceSafely(intent);
            } catch (Exception e2) {
                AbstractC4022b.m13351a(e2);
            }
        }
        C4232fz.m14915a(context);
        if (C4092au.m13799a(context) && C4067u.m13627a(context).m13675b()) {
            C4067u.m13627a(context).m13676c();
        }
        if (C4092au.m13799a(context)) {
            if ("syncing".equals(C4062p.m13587a(context).m13589a(EnumC4068v.DISABLE_PUSH))) {
                MiPushClient.disablePush(context);
            }
            if ("syncing".equals(C4062p.m13587a(context).m13589a(EnumC4068v.ENABLE_PUSH))) {
                MiPushClient.enablePush(context);
            }
            if ("syncing".equals(C4062p.m13587a(context).m13589a(EnumC4068v.UPLOAD_HUAWEI_TOKEN))) {
                C4067u.m13627a(context).m13667a((String) null, EnumC4068v.UPLOAD_HUAWEI_TOKEN, EnumC4050d.ASSEMBLE_PUSH_HUAWEI, "net");
            }
            if ("syncing".equals(C4062p.m13587a(context).m13589a(EnumC4068v.UPLOAD_FCM_TOKEN))) {
                C4067u.m13627a(context).m13667a((String) null, EnumC4068v.UPLOAD_HUAWEI_TOKEN, EnumC4050d.ASSEMBLE_PUSH_HUAWEI, "net");
            }
            if ("syncing".equals(C4062p.m13587a(context).m13589a(EnumC4068v.UPLOAD_COS_TOKEN))) {
                C4067u.m13627a(context).m13667a((String) null, EnumC4068v.UPLOAD_COS_TOKEN, EnumC4050d.ASSEMBLE_PUSH_COS, "net");
            }
            if ("syncing".equals(C4062p.m13587a(context).m13589a(EnumC4068v.UPLOAD_FTOS_TOKEN))) {
                C4067u.m13627a(context).m13667a((String) null, EnumC4068v.UPLOAD_FTOS_TOKEN, EnumC4050d.ASSEMBLE_PUSH_FTOS, "net");
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
        this.f16768b = false;
        f16767a = true;
    }
}
