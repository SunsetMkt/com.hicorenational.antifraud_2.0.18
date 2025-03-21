package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: HuaweiDeviceIdSupplier.java */
/* renamed from: com.umeng.analytics.pro.ay */
/* loaded from: classes2.dex */
class C3341ay implements InterfaceC3337au {

    /* renamed from: a */
    private static final String f11527a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";

    /* renamed from: b */
    private static final int f11528b = 1;

    /* renamed from: c */
    private static final int f11529c = 2;

    /* compiled from: HuaweiDeviceIdSupplier.java */
    /* renamed from: com.umeng.analytics.pro.ay$a */
    private static final class a implements ServiceConnection {

        /* renamed from: a */
        boolean f11530a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f11531b;

        private a() {
            this.f11530a = false;
            this.f11531b = new LinkedBlockingQueue<>();
        }

        /* renamed from: a */
        public IBinder m10886a() throws InterruptedException {
            if (this.f11530a) {
                throw new IllegalStateException();
            }
            this.f11530a = true;
            return this.f11531b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f11531b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: HuaweiDeviceIdSupplier.java */
    /* renamed from: com.umeng.analytics.pro.ay$b */
    private static final class b implements IInterface {

        /* renamed from: a */
        private IBinder f11532a;

        public b(IBinder iBinder) {
            this.f11532a = iBinder;
        }

        /* renamed from: a */
        public String m10887a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(C3341ay.f11527a);
                this.f11532a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f11532a;
        }

        /* renamed from: b */
        public boolean m10888b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(C3341ay.f11527a);
                this.f11532a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    C3341ay() {
    }

    @Override // com.umeng.analytics.pro.InterfaceC3337au
    /* renamed from: a */
    public String mo10870a(Context context) {
        a aVar = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return new b(aVar.m10886a()).m10887a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
