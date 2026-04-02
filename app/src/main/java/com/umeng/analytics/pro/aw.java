package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: CoolpadDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes2.dex */
public class aw implements au {
    private static final String a = "Coolpad";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7030b = "com.coolpad.deviceidsupport";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f7031c = "com.coolpad.deviceidsupport.DeviceIdService";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f7032d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CountDownLatch f7034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f7035g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7033e = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ServiceConnection f7036h = new ServiceConnection() { // from class: com.umeng.analytics.pro.aw.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = aw.f7032d = a.b.a(iBinder);
                aw.this.f7033e = aw.f7032d.b(aw.this.f7035g.getPackageName());
                String str = "onServiceConnected: oaid = " + aw.this.f7033e;
            } catch (RemoteException | NullPointerException e2) {
                String str2 = "onServiceConnected failed e=" + e2.getMessage();
            }
            aw.this.f7034f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a unused = aw.f7032d = null;
        }
    };

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(f7030b, f7031c));
            context.bindService(intent, this.f7036h, 1);
        } catch (Throwable th) {
            String str = "bindService failed. e=" + th.getMessage();
            this.f7034f.countDown();
        }
    }

    private void c(Context context) {
        try {
            context.unbindService(this.f7036h);
        } catch (Throwable th) {
            String str = "unbindService failed. e=" + th.getMessage();
        }
    }

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.f7035g = context.getApplicationContext();
        this.f7034f = new CountDownLatch(1);
        try {
            b(context);
            this.f7034f.await(500L, TimeUnit.MILLISECONDS);
            return this.f7033e;
        } catch (InterruptedException e2) {
            String str = "getOAID interrupted. e=" + e2.getMessage();
            return null;
        } finally {
            c(context);
        }
    }
}
