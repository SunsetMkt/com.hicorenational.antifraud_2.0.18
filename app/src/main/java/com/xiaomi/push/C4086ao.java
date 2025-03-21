package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.security.MessageDigest;
import p286h.C5230f1;

/* renamed from: com.xiaomi.push.ao */
/* loaded from: classes2.dex */
class C4086ao implements InterfaceC4080ai {

    /* renamed from: a */
    private static boolean f14546a;

    /* renamed from: a */
    private Context f14548a;

    /* renamed from: a */
    private ServiceConnection f14549a;

    /* renamed from: a */
    private volatile int f14547a = 0;

    /* renamed from: a */
    private volatile a f14550a = null;

    /* renamed from: a */
    private final Object f14551a = new Object();

    /* renamed from: com.xiaomi.push.ao$a */
    private class a {

        /* renamed from: a */
        String f14553a;

        /* renamed from: b */
        String f14554b;

        /* renamed from: c */
        String f14555c;

        /* renamed from: d */
        String f14556d;

        private a() {
            this.f14553a = null;
            this.f14554b = null;
            this.f14555c = null;
            this.f14556d = null;
        }
    }

    /* renamed from: com.xiaomi.push.ao$b */
    private class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            if (C4086ao.this.f14550a != null) {
                return;
            }
            new Thread(new Runnable() { // from class: com.xiaomi.push.ao.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String packageName = C4086ao.this.f14548a.getPackageName();
                        String m13772b = C4086ao.this.m13772b();
                        a aVar = new a();
                        aVar.f14554b = c.m13774a(iBinder, packageName, m13772b, "OUID");
                        C4086ao.this.f14550a = aVar;
                        C4086ao.this.m13773b();
                        C4086ao.this.f14547a = 2;
                        synchronized (C4086ao.this.f14551a) {
                            try {
                                C4086ao.this.f14551a.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        C4086ao.this.m13773b();
                        C4086ao.this.f14547a = 2;
                        synchronized (C4086ao.this.f14551a) {
                            try {
                                C4086ao.this.f14551a.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        C4086ao.this.m13773b();
                        C4086ao.this.f14547a = 2;
                        synchronized (C4086ao.this.f14551a) {
                            try {
                                C4086ao.this.f14551a.notifyAll();
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

    /* renamed from: com.xiaomi.push.ao$c */
    private static class c {
        /* renamed from: a */
        static String m13774a(IBinder iBinder, String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public C4086ao(Context context) {
        this.f14548a = context;
        m13768a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13773b() {
        ServiceConnection serviceConnection = this.f14549a;
        if (serviceConnection != null) {
            try {
                this.f14548a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m13772b() {
        try {
            Signature[] signatureArr = this.f14548a.getPackageManager().getPackageInfo(this.f14548a.getPackageName(), 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            StringBuilder sb = new StringBuilder();
            for (byte b2 : messageDigest.digest(signatureArr[0].toByteArray())) {
                sb.append(Integer.toHexString((b2 & C5230f1.f20085c) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.xiaomi.push.InterfaceC4080ai
    /* renamed from: a */
    public boolean mo13737a() {
        return f14546a;
    }

    @Override // com.xiaomi.push.InterfaceC4080ai
    /* renamed from: a */
    public String mo13736a() {
        m13770a("getOAID");
        if (this.f14550a == null) {
            return null;
        }
        return this.f14550a.f14554b;
    }

    /* renamed from: a */
    private void m13768a() {
        boolean z;
        this.f14549a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        try {
            z = this.f14548a.bindService(intent, this.f14549a, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f14547a = z ? 1 : 2;
    }

    /* renamed from: a */
    private void m13770a(String str) {
        if (this.f14547a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f14551a) {
            try {
                AbstractC4022b.m13347a("oppo's " + str + " wait...");
                this.f14551a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m13771a(Context context) {
        long j2;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
            if (packageInfo != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    j2 = packageInfo.getLongVersionCode();
                } else {
                    j2 = packageInfo.versionCode;
                }
                boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
                f14546a = j2 >= 1;
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
