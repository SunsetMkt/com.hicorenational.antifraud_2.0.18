package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.umeng.analytics.pro.InterfaceC3343b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: SamsungDeviceIdSupplier.java */
/* renamed from: com.umeng.analytics.pro.bd */
/* loaded from: classes2.dex */
public class C3347bd implements InterfaceC3337au {

    /* compiled from: SamsungDeviceIdSupplier.java */
    /* renamed from: com.umeng.analytics.pro.bd$a */
    private static final class a implements ServiceConnection {

        /* renamed from: a */
        boolean f11545a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f11546b;

        /* renamed from: a */
        public IBinder m10896a() throws InterruptedException {
            if (this.f11545a) {
                throw new IllegalStateException();
            }
            this.f11545a = true;
            return this.f11546b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f11546b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
            this.f11545a = false;
            this.f11546b = new LinkedBlockingQueue<>();
        }
    }

    @Override // com.umeng.analytics.pro.InterfaceC3337au
    /* renamed from: a */
    public String mo10870a(Context context) {
        a aVar = new a();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return InterfaceC3343b.b.m10892a(aVar.m10896a()).mo10889a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
