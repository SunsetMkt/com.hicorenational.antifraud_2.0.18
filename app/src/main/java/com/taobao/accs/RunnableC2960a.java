package com.taobao.accs;

import android.app.Notification;
import android.content.Context;
import com.taobao.accs.ChannelService;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.a */
/* loaded from: classes.dex */
class RunnableC2960a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ChannelService.KernelService f9370a;

    RunnableC2960a(ChannelService.KernelService kernelService) {
        this.f9370a = kernelService;
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
            context = this.f9370a.f9369b;
            int i2 = context.getPackageManager().getPackageInfo(this.f9370a.getPackageName(), 0).applicationInfo.icon;
            if (i2 != 0) {
                context2 = this.f9370a.f9369b;
                Notification.Builder builder = new Notification.Builder(context2);
                builder.setSmallIcon(i2);
                builder.setContentText("正在运行…");
                channelService.startForeground(9371, builder.build());
                context3 = this.f9370a.f9369b;
                Notification.Builder builder2 = new Notification.Builder(context3);
                builder2.setSmallIcon(i2);
                builder2.setContentText("正在运行…");
                kernelService2 = ChannelService.KernelService.f9368a;
                kernelService2.startForeground(9371, builder2.build());
                kernelService3 = ChannelService.KernelService.f9368a;
                kernelService3.stopForeground(true);
            }
            kernelService = ChannelService.KernelService.f9368a;
            kernelService.stopSelf();
        } catch (Throwable th) {
            ALog.m9181e("ChannelService", " onStartCommand run", th, new Object[0]);
        }
    }
}
