package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

/* renamed from: com.hihonor.push.sdk.g0 */
/* loaded from: classes.dex */
public class ServiceConnectionC2203g0 implements ServiceConnection {

    /* renamed from: a */
    public Messenger f6782a;

    /* renamed from: b */
    public Bundle f6783b;

    /* renamed from: c */
    public Context f6784c;

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f6782a = new Messenger(iBinder);
        Message obtain = Message.obtain();
        obtain.setData(this.f6783b);
        try {
            this.f6782a.send(obtain);
        } catch (Exception e2) {
            String str = "message sending failed. " + e2.getMessage();
        }
        try {
            this.f6784c.unbindService(this);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f6782a = null;
        this.f6783b = null;
        this.f6784c = null;
    }
}
