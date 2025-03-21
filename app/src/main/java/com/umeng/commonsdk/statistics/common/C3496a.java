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
import com.umeng.commonsdk.utils.C3529b;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: AdvertisingId.java */
/* renamed from: com.umeng.commonsdk.statistics.common.a */
/* loaded from: classes2.dex */
public class C3496a {

    /* compiled from: AdvertisingId.java */
    /* renamed from: com.umeng.commonsdk.statistics.common.a$a */
    private static final class a {

        /* renamed from: a */
        private final String f12746a;

        /* renamed from: b */
        private final boolean f12747b;

        a(String str, boolean z) {
            this.f12746a = str;
            this.f12747b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public String m11802b() {
            return this.f12746a;
        }

        /* renamed from: a */
        public boolean m11803a() {
            return this.f12747b;
        }
    }

    /* compiled from: AdvertisingId.java */
    /* renamed from: com.umeng.commonsdk.statistics.common.a$b */
    private static final class b implements ServiceConnection {

        /* renamed from: a */
        boolean f12748a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f12749b;

        private b() {
            this.f12748a = false;
            this.f12749b = new LinkedBlockingQueue<>(1);
        }

        /* renamed from: a */
        public IBinder m11804a() throws InterruptedException {
            if (this.f12748a) {
                throw new IllegalStateException();
            }
            this.f12748a = true;
            return this.f12749b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f12749b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: a */
    public static String m11798a(Context context) {
        try {
            a m11800c = m11800c(context);
            if (m11800c != null && !m11800c.m11803a()) {
                return m11800c.m11802b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: b */
    public static String m11799b(Context context) {
        try {
            a m11800c = m11800c(context);
            if (m11800c == null) {
                return null;
            }
            return m11800c.m11802b();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static a m11800c(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            if (C3529b.m12093a().m12094a(context, "com.android.vending", 0) == null) {
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
                    c cVar = new c(bVar.m11804a());
                    boolean m11806a = cVar.m11806a(true);
                    return new a(m11806a ? "" : cVar.m11805a(), m11806a);
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
    /* renamed from: com.umeng.commonsdk.statistics.common.a$c */
    private static final class c implements IInterface {

        /* renamed from: a */
        private IBinder f12750a;

        public c(IBinder iBinder) {
            this.f12750a = iBinder;
        }

        /* renamed from: a */
        public String m11805a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f12750a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f12750a;
        }

        /* renamed from: a */
        public boolean m11806a(boolean z) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.f12750a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
