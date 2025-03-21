package com.hihonor.push.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.hihonor.push.sdk.common.data.DownMsgType;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class HonorMessageService extends Service {

    /* renamed from: c */
    public static final /* synthetic */ int f6738c = 0;

    /* renamed from: a */
    public final HandlerC2181a f6739a;

    /* renamed from: b */
    public final Messenger f6740b;

    /* renamed from: com.hihonor.push.sdk.HonorMessageService$a */
    public static class HandlerC2181a extends Handler {

        /* renamed from: a */
        public final WeakReference<HonorMessageService> f6741a;

        public HandlerC2181a(Looper looper, HonorMessageService honorMessageService) {
            super(looper);
            this.f6741a = new WeakReference<>(honorMessageService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data;
            HonorMessageService honorMessageService = this.f6741a.get();
            if (honorMessageService == null || (data = message.getData()) == null) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtras(data);
            int i2 = HonorMessageService.f6738c;
            honorMessageService.m6350a(intent);
        }
    }

    public HonorMessageService() {
        HandlerC2181a handlerC2181a = new HandlerC2181a(Looper.getMainLooper(), this);
        this.f6739a = handlerC2181a;
        this.f6740b = new Messenger(handlerC2181a);
    }

    /* renamed from: a */
    public final void m6350a(Intent intent) {
        try {
            if (!TextUtils.equals(intent.getStringExtra("event_type"), DownMsgType.RECEIVE_TOKEN)) {
                C2185a1 m6360a = C2186b.m6360a(new CallableC2225q0(intent));
                C2183a c2183a = new C2183a(this);
                m6360a.getClass();
                m6360a.m6353a(new C2231t0(C2221o0.f6811c.f6812a, c2183a));
                return;
            }
            String stringExtra = intent.getStringExtra("push_token");
            Context m6393a = C2214l.f6798e.m6393a();
            C2193d c2193d = C2193d.f6759b;
            if (!TextUtils.equals(stringExtra, c2193d.m6381b(m6393a))) {
                c2193d.m6380a(m6393a, stringExtra);
            }
            onNewToken(stringExtra);
        } catch (Exception e2) {
            String str = "dispatch message error. " + e2.getMessage();
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f6740b.getBinder();
    }

    public void onMessageReceived(HonorPushDataMsg honorPushDataMsg) {
    }

    public void onNewToken(String str) {
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        m6350a(intent);
        return 2;
    }
}
