package i.e.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import h.f1;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: IOpenID.java */
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* compiled from: IOpenID.java */
    /* renamed from: i.e.a.a.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0257a extends Binder implements a {

        /* compiled from: IOpenID.java */
        /* renamed from: i.e.a.a.a.a$a$a, reason: collision with other inner class name */
        private static class C0258a implements a {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f16890a;

            public C0258a(IBinder iBinder) {
                this.f16890a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f16890a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f16890a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0258a(iBinder) : (a) queryLocalInterface;
        }
    }

    /* compiled from: HeytapIDSDK.java */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public static boolean f16891a = false;

        /* renamed from: b, reason: collision with root package name */
        public static boolean f16892b = false;
    }

    /* compiled from: OpenIDHelper.java */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public a f16893a = null;

        /* renamed from: b, reason: collision with root package name */
        public String f16894b = null;

        /* renamed from: c, reason: collision with root package name */
        public String f16895c = null;

        /* renamed from: d, reason: collision with root package name */
        public final Object f16896d = new Object();

        /* renamed from: e, reason: collision with root package name */
        public ServiceConnection f16897e = new ServiceConnectionC0259a();

        /* compiled from: OpenIDHelper.java */
        /* renamed from: i.e.a.a.a.a$c$a, reason: collision with other inner class name */
        public class ServiceConnectionC0259a implements ServiceConnection {
            public ServiceConnectionC0259a() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                c.this.f16893a = AbstractBinderC0257a.a(iBinder);
                synchronized (c.this.f16896d) {
                    c.this.f16896d.notify();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                c.this.f16893a = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: OpenIDHelper.java */
        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public static final c f16899a = new c(null);
        }

        public /* synthetic */ c(ServiceConnectionC0259a serviceConnectionC0259a) {
        }

        public boolean a(Context context) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
                return Build.VERSION.SDK_INT >= 28 ? packageInfo != null && packageInfo.getLongVersionCode() >= 1 : packageInfo != null && packageInfo.versionCode >= 1;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        public final String b(Context context, String str) {
            Signature[] signatureArr;
            if (TextUtils.isEmpty(this.f16894b)) {
                this.f16894b = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.f16895c)) {
                String str2 = null;
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(this.f16894b, 64).signatures;
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                    signatureArr = null;
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                        if (messageDigest != null) {
                            byte[] digest = messageDigest.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            for (byte b2 : digest) {
                                sb.append(Integer.toHexString((b2 & f1.f16099c) | 256).substring(1, 3));
                            }
                            str2 = sb.toString();
                        }
                    } catch (NoSuchAlgorithmException e3) {
                        e3.printStackTrace();
                    }
                }
                this.f16895c = str2;
            }
            String a2 = ((AbstractBinderC0257a.C0258a) this.f16893a).a(this.f16894b, this.f16895c, str);
            return TextUtils.isEmpty(a2) ? "" : a2;
        }

        public synchronized String a(Context context, String str) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                if (this.f16893a == null) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                    intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                    if (context.bindService(intent, this.f16897e, 1)) {
                        synchronized (this.f16896d) {
                            try {
                                this.f16896d.wait(3000L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    if (this.f16893a == null) {
                        return "";
                    }
                    try {
                        return b(context, str);
                    } catch (RemoteException e3) {
                        e3.printStackTrace();
                        return "";
                    }
                }
                try {
                    return b(context, str);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return "";
                }
            }
            throw new IllegalStateException("Cannot run on MainThread");
        }
    }
}
