package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
class ah implements ai {
    private static boolean a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ServiceConnection f164a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile int f162a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile String f166a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private volatile boolean f167b = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile String f8735b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f165a = new Object();

    private class a implements ServiceConnection {
        private a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            new Thread(new Runnable() { // from class: com.xiaomi.push.ah.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ah.this.f166a = b.a(iBinder);
                        ah.this.f167b = b.m136a(iBinder);
                        ah.this.b();
                        ah.this.f162a = 2;
                        synchronized (ah.this.f165a) {
                            try {
                                ah.this.f165a.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        ah.this.b();
                        ah.this.f162a = 2;
                        synchronized (ah.this.f165a) {
                            try {
                                ah.this.f165a.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        ah.this.b();
                        ah.this.f162a = 2;
                        synchronized (ah.this.f165a) {
                            try {
                                ah.this.f165a.notifyAll();
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

    public ah(Context context) {
        this.f163a = context;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ServiceConnection serviceConnection = this.f164a;
        if (serviceConnection != null) {
            try {
                this.f163a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo135a() {
        return a;
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo134a() {
        a("getOAID");
        return this.f166a;
    }

    private void a() {
        boolean zBindService;
        this.f164a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            zBindService = this.f163a.bindService(intent, this.f164a, 1);
        } catch (Exception unused) {
            zBindService = false;
        }
        this.f162a = zBindService ? 1 : 2;
    }

    private static class b {
        static String a(IBinder iBinder) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        static boolean m136a(IBinder iBinder) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    private void a(String str) {
        if (this.f162a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f165a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m48a("huawei's " + str + " wait...");
                this.f165a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context) {
        boolean z;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            z = (packageInfo.applicationInfo.flags & 1) != 0;
            a = packageInfo.versionCode >= 20602000;
        } catch (Exception unused) {
        }
        return z;
    }
}
