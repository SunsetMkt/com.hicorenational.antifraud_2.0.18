package com.huawei.hms.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: compiled from: RemoteService.java */
/* JADX INFO: loaded from: classes.dex */
public class r {
    private ServiceConnection a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Messenger f4901b = null;

    /* JADX INFO: compiled from: RemoteService.java */
    class a implements ServiceConnection {
        final /* synthetic */ Bundle a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f4902b;

        a(Bundle bundle, Context context) {
            this.a = bundle;
            this.f4902b = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HMSLog.i("RemoteService", "remote service onConnected");
            r.this.f4901b = new Messenger(iBinder);
            Message messageObtain = Message.obtain();
            messageObtain.setData(this.a);
            try {
                r.this.f4901b.send(messageObtain);
            } catch (RemoteException unused) {
                HMSLog.i("RemoteService", "remote service message send failed");
            }
            HMSLog.i("RemoteService", "remote service unbindservice");
            this.f4902b.unbindService(r.this.a);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.i("RemoteService", "remote service onDisconnected");
            r.this.f4901b = null;
        }
    }

    public boolean a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.a = new a(bundle, applicationContext);
        HMSLog.i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.a, 1);
    }
}
