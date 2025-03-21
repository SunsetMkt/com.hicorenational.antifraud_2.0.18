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

/* compiled from: RemoteService.java */
/* renamed from: com.huawei.hms.push.r */
/* loaded from: classes.dex */
public class C2498r {

    /* renamed from: a */
    private ServiceConnection f7792a;

    /* renamed from: b */
    private Messenger f7793b = null;

    /* compiled from: RemoteService.java */
    /* renamed from: com.huawei.hms.push.r$a */
    class a implements ServiceConnection {

        /* renamed from: a */
        final /* synthetic */ Bundle f7794a;

        /* renamed from: b */
        final /* synthetic */ Context f7795b;

        a(Bundle bundle, Context context) {
            this.f7794a = bundle;
            this.f7795b = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HMSLog.m7717i("RemoteService", "remote service onConnected");
            C2498r.this.f7793b = new Messenger(iBinder);
            Message obtain = Message.obtain();
            obtain.setData(this.f7794a);
            try {
                C2498r.this.f7793b.send(obtain);
            } catch (RemoteException unused) {
                HMSLog.m7717i("RemoteService", "remote service message send failed");
            }
            HMSLog.m7717i("RemoteService", "remote service unbindservice");
            this.f7795b.unbindService(C2498r.this.f7792a);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.m7717i("RemoteService", "remote service onDisconnected");
            C2498r.this.f7793b = null;
        }
    }

    /* renamed from: a */
    public boolean m7633a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f7792a = new a(bundle, applicationContext);
        HMSLog.m7717i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f7792a, 1);
    }
}
