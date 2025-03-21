package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.umeng.analytics.pro.InterfaceC3316a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: CoolpadDeviceIdSupplier.java */
/* renamed from: com.umeng.analytics.pro.aw */
/* loaded from: classes2.dex */
public class C3339aw implements InterfaceC3337au {

    /* renamed from: a */
    private static final String f11516a = "Coolpad";

    /* renamed from: b */
    private static final String f11517b = "com.coolpad.deviceidsupport";

    /* renamed from: c */
    private static final String f11518c = "com.coolpad.deviceidsupport.DeviceIdService";

    /* renamed from: d */
    private static InterfaceC3316a f11519d;

    /* renamed from: f */
    private CountDownLatch f11521f;

    /* renamed from: g */
    private Context f11522g;

    /* renamed from: e */
    private String f11520e = "";

    /* renamed from: h */
    private final ServiceConnection f11523h = new ServiceConnection() { // from class: com.umeng.analytics.pro.aw.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                InterfaceC3316a unused = C3339aw.f11519d = InterfaceC3316a.b.m10805a(iBinder);
                C3339aw.this.f11520e = C3339aw.f11519d.mo10801b(C3339aw.this.f11522g.getPackageName());
                String str = "onServiceConnected: oaid = " + C3339aw.this.f11520e;
            } catch (RemoteException | NullPointerException e2) {
                String str2 = "onServiceConnected failed e=" + e2.getMessage();
            }
            C3339aw.this.f11521f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            InterfaceC3316a unused = C3339aw.f11519d = null;
        }
    };

    /* renamed from: b */
    private void m10878b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(f11517b, f11518c));
            context.bindService(intent, this.f11523h, 1);
        } catch (Throwable th) {
            String str = "bindService failed. e=" + th.getMessage();
            this.f11521f.countDown();
        }
    }

    /* renamed from: c */
    private void m10880c(Context context) {
        try {
            context.unbindService(this.f11523h);
        } catch (Throwable th) {
            String str = "unbindService failed. e=" + th.getMessage();
        }
    }

    @Override // com.umeng.analytics.pro.InterfaceC3337au
    /* renamed from: a */
    public String mo10870a(Context context) {
        if (context == null) {
            return null;
        }
        this.f11522g = context.getApplicationContext();
        this.f11521f = new CountDownLatch(1);
        try {
            m10878b(context);
            this.f11521f.await(500L, TimeUnit.MILLISECONDS);
            return this.f11520e;
        } catch (InterruptedException e2) {
            String str = "getOAID interrupted. e=" + e2.getMessage();
            return null;
        } finally {
            m10880c(context);
        }
    }
}
