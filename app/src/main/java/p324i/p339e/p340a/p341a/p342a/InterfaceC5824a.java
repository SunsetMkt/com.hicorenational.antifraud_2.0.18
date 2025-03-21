package p324i.p339e.p340a.p341a.p342a;

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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p286h.C5230f1;

/* compiled from: IOpenID.java */
/* renamed from: i.e.a.a.a.a */
/* loaded from: classes2.dex */
public interface InterfaceC5824a extends IInterface {

    /* compiled from: IOpenID.java */
    /* renamed from: i.e.a.a.a.a$a */
    public static abstract class a extends Binder implements InterfaceC5824a {

        /* compiled from: IOpenID.java */
        /* renamed from: i.e.a.a.a.a$a$a, reason: collision with other inner class name */
        private static class C7432a implements InterfaceC5824a {

            /* renamed from: a */
            public IBinder f20949a;

            public C7432a(IBinder iBinder) {
                this.f20949a = iBinder;
            }

            /* renamed from: a */
            public String m24441a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f20949a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f20949a;
            }
        }

        /* renamed from: a */
        public static InterfaceC5824a m24440a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC5824a)) ? new C7432a(iBinder) : (InterfaceC5824a) queryLocalInterface;
        }
    }

    /* compiled from: HeytapIDSDK.java */
    /* renamed from: i.e.a.a.a.a$b */
    public class b {

        /* renamed from: a */
        public static boolean f20950a = false;

        /* renamed from: b */
        public static boolean f20951b = false;
    }

    /* compiled from: OpenIDHelper.java */
    /* renamed from: i.e.a.a.a.a$c */
    public class c {

        /* renamed from: a */
        public InterfaceC5824a f20952a = null;

        /* renamed from: b */
        public String f20953b = null;

        /* renamed from: c */
        public String f20954c = null;

        /* renamed from: d */
        public final Object f20955d = new Object();

        /* renamed from: e */
        public ServiceConnection f20956e = new a();

        /* compiled from: OpenIDHelper.java */
        /* renamed from: i.e.a.a.a.a$c$a */
        public class a implements ServiceConnection {
            public a() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                c.this.f20952a = a.m24440a(iBinder);
                synchronized (c.this.f20955d) {
                    c.this.f20955d.notify();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                c.this.f20952a = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: OpenIDHelper.java */
        /* renamed from: i.e.a.a.a.a$c$b */
        public static class b {

            /* renamed from: a */
            public static final c f20958a = new c(null);
        }

        public /* synthetic */ c(a aVar) {
        }

        /* renamed from: a */
        public boolean m24443a(Context context) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
                return Build.VERSION.SDK_INT >= 28 ? packageInfo != null && packageInfo.getLongVersionCode() >= 1 : packageInfo != null && packageInfo.versionCode >= 1;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        /* renamed from: b */
        public final String m24444b(Context context, String str) {
            Signature[] signatureArr;
            if (TextUtils.isEmpty(this.f20953b)) {
                this.f20953b = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.f20954c)) {
                String str2 = null;
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(this.f20953b, 64).signatures;
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
                                sb.append(Integer.toHexString((b2 & C5230f1.f20085c) | 256).substring(1, 3));
                            }
                            str2 = sb.toString();
                        }
                    } catch (NoSuchAlgorithmException e3) {
                        e3.printStackTrace();
                    }
                }
                this.f20954c = str2;
            }
            String m24441a = ((a.C7432a) this.f20952a).m24441a(this.f20953b, this.f20954c, str);
            return TextUtils.isEmpty(m24441a) ? "" : m24441a;
        }

        /* renamed from: a */
        public synchronized String m24442a(Context context, String str) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                if (this.f20952a == null) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                    intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                    if (context.bindService(intent, this.f20956e, 1)) {
                        synchronized (this.f20955d) {
                            try {
                                this.f20955d.wait(3000L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    if (this.f20952a == null) {
                        return "";
                    }
                    try {
                        return m24444b(context, str);
                    } catch (RemoteException e3) {
                        e3.printStackTrace();
                        return "";
                    }
                }
                try {
                    return m24444b(context, str);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return "";
                }
            }
            throw new IllegalStateException("Cannot run on MainThread");
        }
    }
}
