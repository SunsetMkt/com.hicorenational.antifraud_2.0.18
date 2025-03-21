package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4300j;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public abstract class BaseService extends Service {

    /* renamed from: a */
    private HandlerC4031a f14337a;

    /* renamed from: com.xiaomi.mipush.sdk.BaseService$a */
    public static class HandlerC4031a extends Handler {

        /* renamed from: a */
        private WeakReference<BaseService> f14338a;

        public HandlerC4031a(WeakReference<BaseService> weakReference) {
            this.f14338a = weakReference;
        }

        /* renamed from: a */
        public void m13420a() {
            if (hasMessages(1001)) {
                removeMessages(1001);
            }
            sendEmptyMessageDelayed(1001, 1000L);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<BaseService> weakReference;
            BaseService baseService;
            if (message.what != 1001 || (weakReference = this.f14338a) == null || (baseService = weakReference.get()) == null) {
                return;
            }
            AbstractC4022b.m13359c("TimeoutHandler " + baseService.toString() + " kill self");
            if (!baseService.mo13419a()) {
                baseService.stopSelf();
            } else {
                AbstractC4022b.m13359c("TimeoutHandler has job");
                sendEmptyMessageDelayed(1001, 1000L);
            }
        }
    }

    /* renamed from: a */
    protected abstract boolean mo13419a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
        if (this.f14337a == null) {
            this.f14337a = new HandlerC4031a(new WeakReference(this));
        }
        this.f14337a.m13420a();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        int onStartCommand = super.onStartCommand(intent, i2, i3);
        if (C4300j.m15681a((Context) this)) {
            return onStartCommand;
        }
        return 2;
    }
}
