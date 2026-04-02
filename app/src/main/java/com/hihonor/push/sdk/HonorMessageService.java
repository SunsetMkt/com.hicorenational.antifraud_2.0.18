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

/* JADX INFO: loaded from: classes.dex */
public abstract class HonorMessageService extends Service {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f4228c = 0;
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Messenger f4229b;

    public static class a extends Handler {
        public final WeakReference<HonorMessageService> a;

        public a(Looper looper, HonorMessageService honorMessageService) {
            super(looper);
            this.a = new WeakReference<>(honorMessageService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data;
            HonorMessageService honorMessageService = this.a.get();
            if (honorMessageService == null || (data = message.getData()) == null) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtras(data);
            int i2 = HonorMessageService.f4228c;
            honorMessageService.a(intent);
        }
    }

    public HonorMessageService() {
        a aVar = new a(Looper.getMainLooper(), this);
        this.a = aVar;
        this.f4229b = new Messenger(aVar);
    }

    public final void a(Intent intent) {
        try {
            if (!TextUtils.equals(intent.getStringExtra("event_type"), DownMsgType.RECEIVE_TOKEN)) {
                a1 a1VarA = b.a(new q0(intent));
                com.hihonor.push.sdk.a aVar = new com.hihonor.push.sdk.a(this);
                a1VarA.getClass();
                a1VarA.a(new t0(o0.f4270c.a, aVar));
                return;
            }
            String stringExtra = intent.getStringExtra("push_token");
            Context contextA = l.f4263e.a();
            d dVar = d.f4240b;
            if (!TextUtils.equals(stringExtra, dVar.b(contextA))) {
                dVar.a(contextA, stringExtra);
            }
            onNewToken(stringExtra);
        } catch (Exception e2) {
            String str = "dispatch message error. " + e2.getMessage();
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f4229b.getBinder();
    }

    public void onMessageReceived(HonorPushDataMsg honorPushDataMsg) {
    }

    public void onNewToken(String str) {
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        a(intent);
        return 2;
    }
}
