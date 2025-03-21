package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;

/* renamed from: com.xiaomi.push.ah */
/* loaded from: classes2.dex */
class C4079ah implements InterfaceC4080ai {

    /* renamed from: a */
    private static boolean f14499a;

    /* renamed from: a */
    private Context f14501a;

    /* renamed from: a */
    private ServiceConnection f14502a;

    /* renamed from: a */
    private volatile int f14500a = 0;

    /* renamed from: a */
    private volatile String f14504a = null;

    /* renamed from: b */
    private volatile boolean f14506b = false;

    /* renamed from: b */
    private volatile String f14505b = null;

    /* renamed from: a */
    private final Object f14503a = new Object();

    /* renamed from: com.xiaomi.push.ah$a */
    private class a implements ServiceConnection {
        private a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            new Thread(new Runnable() { // from class: com.xiaomi.push.ah.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C4079ah.this.f14504a = b.m13738a(iBinder);
                        C4079ah.this.f14506b = b.m13739a(iBinder);
                        C4079ah.this.m13735b();
                        C4079ah.this.f14500a = 2;
                        synchronized (C4079ah.this.f14503a) {
                            try {
                                C4079ah.this.f14503a.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        C4079ah.this.m13735b();
                        C4079ah.this.f14500a = 2;
                        synchronized (C4079ah.this.f14503a) {
                            try {
                                C4079ah.this.f14503a.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        C4079ah.this.m13735b();
                        C4079ah.this.f14500a = 2;
                        synchronized (C4079ah.this.f14503a) {
                            try {
                                C4079ah.this.f14503a.notifyAll();
                            } catch (Exception unused4) {
                            }
                            throw th;
                        }
                    }
                }
            }).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public C4079ah(Context context) {
        this.f14501a = context;
        m13730a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13735b() {
        ServiceConnection serviceConnection = this.f14502a;
        if (serviceConnection != null) {
            try {
                this.f14501a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC4080ai
    /* renamed from: a */
    public boolean mo13737a() {
        return f14499a;
    }

    @Override // com.xiaomi.push.InterfaceC4080ai
    /* renamed from: a */
    public String mo13736a() {
        m13732a("getOAID");
        return this.f14504a;
    }

    /* renamed from: a */
    private void m13730a() {
        boolean z;
        this.f14502a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            z = this.f14501a.bindService(intent, this.f14502a, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f14500a = z ? 1 : 2;
    }

    /* renamed from: com.xiaomi.push.ah$b */
    private static class b {
        /* renamed from: a */
        static String m13738a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* renamed from: a */
        static boolean m13739a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* renamed from: a */
    private void m13732a(String str) {
        if (this.f14500a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f14503a) {
            try {
                AbstractC4022b.m13347a("huawei's " + str + " wait...");
                this.f14503a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m13733a(Context context) {
        boolean z;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            z = (packageInfo.applicationInfo.flags & 1) != 0;
            f14499a = packageInfo.versionCode >= 20602000;
        } catch (Exception unused) {
        }
        return z;
    }
}
