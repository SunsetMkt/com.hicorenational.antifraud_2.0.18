package com.vivo.push.sdk.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.sdk.C3973a;
import com.vivo.push.util.C4010u;
import com.vivo.push.util.ContextDelegate;

/* loaded from: classes2.dex */
public class CommandService extends Service {
    /* renamed from: a */
    protected boolean mo13167a(String str) {
        return "com.vivo.pushservice.action.RECEIVE".equals(str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C4010u.m13306c("CommandService", "onBind initSuc: ");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        C4010u.m13306c("CommandService", getClass().getSimpleName() + " -- oncreate " + getPackageName());
        super.onCreate();
        Context context = ContextDelegate.getContext(getApplicationContext());
        C3932a.m13069a().m13070a(context);
        C3973a.m13163a().m12830a(context);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        C4010u.m13306c("CommandService", getClass().getSimpleName() + " -- onStartCommand " + getPackageName());
        if (intent == null) {
            stopSelf();
            return 2;
        }
        if (mo13167a(intent.getAction())) {
            try {
                C3973a.m13163a().m13165a(getClass().getName());
                C3973a.m13163a().m13164a(intent);
            } catch (Exception e2) {
                C4010u.m13293a("CommandService", "onStartCommand -- error", e2);
            }
            stopSelf();
            return 2;
        }
        C4010u.m13292a("CommandService", getPackageName() + " receive invalid action " + intent.getAction());
        stopSelf();
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
