package j.e.b.e.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import j.e.b.e.a.a;

/* JADX INFO: compiled from: OpenDeviceId.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f12632e = "OpenDeviceId library";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f12633f = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j.e.b.e.a.a f12634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ServiceConnection f12635c;
    private Context a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC0263b f12636d = null;

    /* JADX INFO: compiled from: OpenDeviceId.java */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.f12634b = a.AbstractBinderC0261a.a(iBinder);
            if (b.this.f12636d != null) {
                b.this.f12636d.a("Deviceid Service Connected", b.this);
            }
            b.this.a("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.f12634b = null;
            b.this.a("Service onServiceDisconnected");
        }
    }

    /* JADX INFO: renamed from: j.e.b.e.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OpenDeviceId.java */
    public interface InterfaceC0263b<T> {
        void a(T t, b bVar);
    }

    public String b() {
        if (this.a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.f12634b != null) {
                return this.f12634b.b();
            }
            return null;
        } catch (RemoteException e2) {
            b("getUDID error, RemoteException!");
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            b("getUDID error, Exception!");
            e3.printStackTrace();
            return null;
        }
    }

    public boolean c() {
        try {
            if (this.f12634b == null) {
                return false;
            }
            a("Device support opendeviceid");
            return this.f12634b.c();
        } catch (RemoteException unused) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public String d() {
        Context context = this.a;
        if (context == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        a("liufeng, getVAID package\uff1a" + packageName);
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
            return null;
        }
        try {
            if (this.f12634b != null) {
                return this.f12634b.a(packageName);
            }
            return null;
        } catch (RemoteException e2) {
            b("getVAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public String e() {
        Context context = this.a;
        if (context == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        a("liufeng, getAAID package\uff1a" + packageName);
        String strB = null;
        if (packageName == null || packageName.equals("")) {
            a("input package is null!");
            return null;
        }
        try {
            if (this.f12634b == null) {
                return null;
            }
            strB = this.f12634b.b(packageName);
            return ((strB == null || "".equals(strB)) && this.f12634b.c(packageName)) ? this.f12634b.b(packageName) : strB;
        } catch (RemoteException unused) {
            b("getAAID error, RemoteException!");
            return strB;
        }
    }

    public void f() {
        try {
            this.a.unbindService(this.f12635c);
            a("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            b("unBind Service exception");
        }
        this.f12634b = null;
    }

    public int a(Context context, InterfaceC0263b<String> interfaceC0263b) {
        if (context != null) {
            this.a = context;
            this.f12636d = interfaceC0263b;
            this.f12635c = new a();
            Intent intent = new Intent();
            intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
            if (this.a.bindService(intent, this.f12635c, 1)) {
                a("bindService Successful!");
                return 1;
            }
            a("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    private void b(String str) {
        boolean z = f12633f;
    }

    public String a() {
        if (this.a != null) {
            try {
                if (this.f12634b != null) {
                    return this.f12634b.a();
                }
                return null;
            } catch (RemoteException e2) {
                b("getOAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        }
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public void a(boolean z) {
        f12633f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        boolean z = f12633f;
    }
}
