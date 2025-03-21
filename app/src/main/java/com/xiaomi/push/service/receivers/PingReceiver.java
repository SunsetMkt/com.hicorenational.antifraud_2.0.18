package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4178dz;
import com.xiaomi.push.service.AbstractC4362an;
import com.xiaomi.push.service.ServiceClient;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes2.dex */
public class PingReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AbstractC4022b.m13359c(intent.getPackage() + " is the package name");
        if (XMPushService.m15779e()) {
            return;
        }
        if (!AbstractC4362an.f16615q.equals(intent.getAction())) {
            AbstractC4022b.m13347a("cancel the old ping timer");
            C4178dz.m14578a();
        } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
            AbstractC4022b.m13359c("Ping XMChannelService on timer");
            try {
                Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
                intent2.putExtra("time_stamp", System.currentTimeMillis());
                intent2.setAction("com.xiaomi.push.timer");
                ServiceClient.getInstance(context).startServiceSafely(intent2);
            } catch (Exception e2) {
                AbstractC4022b.m13351a(e2);
            }
        }
    }
}
