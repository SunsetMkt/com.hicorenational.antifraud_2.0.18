package j.e.a.a.a;

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
import i.f1;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: IOpenID.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: j.e.a.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IOpenID.java */
    public static abstract class AbstractBinderC0258a extends Binder implements a {

        /* JADX INFO: renamed from: j.e.a.a.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IOpenID.java */
        private static class C0259a implements a {
            public IBinder a;

            public C0259a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0259a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }

    /* JADX INFO: compiled from: HeytapIDSDK.java */
    public class b {
        public static boolean a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static boolean f12557b = false;
    }

    /* JADX INFO: compiled from: OpenIDHelper.java */
    public class c {
        public a a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12558b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f12559c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f12560d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ServiceConnection f12561e = new ServiceConnectionC0260a();

        /* JADX INFO: renamed from: j.e.a.a.a.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OpenIDHelper.java */
        public class ServiceConnectionC0260a implements ServiceConnection {
            public ServiceConnectionC0260a() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                c.this.a = AbstractBinderC0258a.a(iBinder);
                synchronized (c.this.f12560d) {
                    c.this.f12560d.notify();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                c.this.a = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: compiled from: OpenIDHelper.java */
        public static class b {
            public static final c a = new c(null);
        }

        public /* synthetic */ c(ServiceConnectionC0260a serviceConnectionC0260a) {
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
            if (TextUtils.isEmpty(this.f12558b)) {
                this.f12558b = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.f12559c)) {
                String string = null;
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(this.f12558b, 64).signatures;
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                    signatureArr = null;
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                        if (messageDigest != null) {
                            byte[] bArrDigest = messageDigest.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            for (byte b2 : bArrDigest) {
                                sb.append(Integer.toHexString((b2 & f1.f12066c) | 256).substring(1, 3));
                            }
                            string = sb.toString();
                        }
                    } catch (NoSuchAlgorithmException e3) {
                        e3.printStackTrace();
                    }
                }
                this.f12559c = string;
            }
            String strA = ((AbstractBinderC0258a.C0259a) this.a).a(this.f12558b, this.f12559c, str);
            return TextUtils.isEmpty(strA) ? "" : strA;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized String a(Context context, String str) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                if (this.a == null) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                    intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                    if (context.bindService(intent, this.f12561e, 1)) {
                        synchronized (this.f12560d) {
                            try {
                                this.f12560d.wait(3000L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (this.a != null) {
                            return "";
                        }
                        try {
                            return b(context, str);
                        } catch (RemoteException e3) {
                            e3.printStackTrace();
                            return "";
                        }
                    }
                    if (this.a != null) {
                    }
                } else {
                    try {
                        return b(context, str);
                    } catch (RemoteException e4) {
                        e4.printStackTrace();
                        return "";
                    }
                }
            }
            throw new IllegalStateException("Cannot run on MainThread");
        }
    }
}
