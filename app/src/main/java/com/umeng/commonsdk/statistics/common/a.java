package com.umeng.commonsdk.statistics.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: AdvertisingId.java */
/* loaded from: classes2.dex */
public class a {

    /* compiled from: AdvertisingId.java */
    /* renamed from: com.umeng.commonsdk.statistics.common.a$a, reason: collision with other inner class name */
    private static final class C0143a {

        /* renamed from: a, reason: collision with root package name */
        private final String f10895a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f10896b;

        C0143a(String str, boolean z) {
            this.f10895a = str;
            this.f10896b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f10895a;
        }

        public boolean a() {
            return this.f10896b;
        }
    }

    /* compiled from: AdvertisingId.java */
    private static final class b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f10897a;

        /* renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f10898b;

        private b() {
            this.f10897a = false;
            this.f10898b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.f10897a) {
                throw new IllegalStateException();
            }
            this.f10897a = true;
            return this.f10898b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f10898b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static String a(Context context) {
        try {
            C0143a c2 = c(context);
            if (c2 != null && !c2.a()) {
                return c2.b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String b(Context context) {
        try {
            C0143a c2 = c(context);
            if (c2 == null) {
                return null;
            }
            return c2.b();
        } catch (Exception unused) {
            return null;
        }
    }

    private static C0143a c(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            if (com.umeng.commonsdk.utils.b.a().a(context, "com.android.vending", 0) == null) {
                return null;
            }
            b bVar = new b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (!context.bindService(intent, bVar, 1)) {
                    throw new IOException("Google Play connection failed");
                }
                try {
                    c cVar = new c(bVar.a());
                    boolean a2 = cVar.a(true);
                    return new C0143a(a2 ? "" : cVar.a(), a2);
                } catch (Exception e2) {
                    throw e2;
                }
            } finally {
                context.unbindService(bVar);
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    /* compiled from: AdvertisingId.java */
    private static final class c implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f10899a;

        public c(IBinder iBinder) {
            this.f10899a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f10899a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f10899a;
        }

        public boolean a(boolean z) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.f10899a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
