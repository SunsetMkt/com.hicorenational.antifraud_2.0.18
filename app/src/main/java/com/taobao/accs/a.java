package com.taobao.accs;

import android.app.Notification;
import com.taobao.accs.ChannelService;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class a implements Runnable {
    final /* synthetic */ ChannelService.KernelService a;

    a(ChannelService.KernelService kernelService) {
        this.a = kernelService;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ChannelService channelService = ChannelService.getInstance();
            int i2 = this.a.f5705b.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).applicationInfo.icon;
            if (i2 != 0) {
                Notification.Builder builder = new Notification.Builder(this.a.f5705b);
                builder.setSmallIcon(i2);
                builder.setContentText("\u6b63\u5728\u8fd0\u884c\u2026");
                channelService.startForeground(9371, builder.build());
                Notification.Builder builder2 = new Notification.Builder(this.a.f5705b);
                builder2.setSmallIcon(i2);
                builder2.setContentText("\u6b63\u5728\u8fd0\u884c\u2026");
                ChannelService.KernelService.a.startForeground(9371, builder2.build());
                ChannelService.KernelService.a.stopForeground(true);
            }
            ChannelService.KernelService.a.stopSelf();
        } catch (Throwable th) {
            ALog.e("ChannelService", " onStartCommand run", th, new Object[0]);
        }
    }
}
