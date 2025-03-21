package com.taobao.accs;

import android.app.Notification;
import android.content.Context;
import com.taobao.accs.ChannelService;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ChannelService.KernelService f8376a;

    a(ChannelService.KernelService kernelService) {
        this.f8376a = kernelService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        ChannelService.KernelService kernelService;
        Context context2;
        Context context3;
        ChannelService.KernelService kernelService2;
        ChannelService.KernelService kernelService3;
        try {
            ChannelService channelService = ChannelService.getInstance();
            context = this.f8376a.f8375b;
            int i2 = context.getPackageManager().getPackageInfo(this.f8376a.getPackageName(), 0).applicationInfo.icon;
            if (i2 != 0) {
                context2 = this.f8376a.f8375b;
                Notification.Builder builder = new Notification.Builder(context2);
                builder.setSmallIcon(i2);
                builder.setContentText("正在运行…");
                channelService.startForeground(9371, builder.build());
                context3 = this.f8376a.f8375b;
                Notification.Builder builder2 = new Notification.Builder(context3);
                builder2.setSmallIcon(i2);
                builder2.setContentText("正在运行…");
                kernelService2 = ChannelService.KernelService.f8374a;
                kernelService2.startForeground(9371, builder2.build());
                kernelService3 = ChannelService.KernelService.f8374a;
                kernelService3.stopForeground(true);
            }
            kernelService = ChannelService.KernelService.f8374a;
            kernelService.stopSelf();
        } catch (Throwable th) {
            ALog.e("ChannelService", " onStartCommand run", th, new Object[0]);
        }
    }
}
