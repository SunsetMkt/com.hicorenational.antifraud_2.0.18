package com.huawei.hms.opendevice;

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
/* renamed from: com.huawei.hms.opendevice.k */
/* loaded from: classes.dex */
public class C2473k {

    /* renamed from: a */
    private ServiceConnection f7667a;

    /* renamed from: b */
    private Messenger f7668b = null;

    /* compiled from: RemoteService.java */
    /* renamed from: com.huawei.hms.opendevice.k$a */
    class a implements ServiceConnection {

        /* renamed from: a */
        final /* synthetic */ Bundle f7669a;

        /* renamed from: b */
        final /* synthetic */ Context f7670b;

        a(Bundle bundle, Context context) {
            this.f7669a = bundle;
            this.f7670b = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HMSLog.m7717i("RemoteService", "remote service onConnected");
            C2473k.this.f7668b = new Messenger(iBinder);
            Message obtain = Message.obtain();
            obtain.setData(this.f7669a);
            try {
                C2473k.this.f7668b.send(obtain);
            } catch (RemoteException unused) {
                HMSLog.m7717i("RemoteService", "remote service message send failed");
            }
            HMSLog.m7717i("RemoteService", "remote service unbindservice");
            this.f7670b.unbindService(C2473k.this.f7667a);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.m7717i("RemoteService", "remote service onDisconnected");
            C2473k.this.f7668b = null;
        }
    }

    /* renamed from: a */
    public boolean m7480a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f7667a = new a(bundle, applicationContext);
        HMSLog.m7717i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f7667a, 1);
    }
}
