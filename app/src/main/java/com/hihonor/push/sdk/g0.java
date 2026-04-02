package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

/* JADX INFO: loaded from: classes.dex */
public class g0 implements ServiceConnection {
    public Messenger a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f4256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f4257c;

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a = new Messenger(iBinder);
        Message messageObtain = Message.obtain();
        messageObtain.setData(this.f4256b);
        try {
            this.a.send(messageObtain);
        } catch (Exception e2) {
            String str = "message sending failed. " + e2.getMessage();
        }
        try {
            this.f4257c.unbindService(this);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a = null;
        this.f4256b = null;
        this.f4257c = null;
    }
}
