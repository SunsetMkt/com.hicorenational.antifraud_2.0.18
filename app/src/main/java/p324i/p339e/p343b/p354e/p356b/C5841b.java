package p324i.p339e.p343b.p354e.p356b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import p324i.p339e.p343b.p354e.p355a.InterfaceC5839a;

/* compiled from: OpenDeviceId.java */
/* renamed from: i.e.b.e.b.b */
/* loaded from: classes2.dex */
public class C5841b {

    /* renamed from: e */
    private static String f21091e = "OpenDeviceId library";

    /* renamed from: f */
    private static boolean f21092f = false;

    /* renamed from: b */
    private InterfaceC5839a f21094b;

    /* renamed from: c */
    private ServiceConnection f21095c;

    /* renamed from: a */
    private Context f21093a = null;

    /* renamed from: d */
    private b f21096d = null;

    /* compiled from: OpenDeviceId.java */
    /* renamed from: i.e.b.e.b.b$a */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C5841b.this.f21094b = InterfaceC5839a.a.m24569a(iBinder);
            if (C5841b.this.f21096d != null) {
                C5841b.this.f21096d.m24584a("Deviceid Service Connected", C5841b.this);
            }
            C5841b.this.m24574a("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C5841b.this.f21094b = null;
            C5841b.this.m24574a("Service onServiceDisconnected");
        }
    }

    /* compiled from: OpenDeviceId.java */
    /* renamed from: i.e.b.e.b.b$b */
    public interface b<T> {
        /* renamed from: a */
        void m24584a(T t, C5841b c5841b);
    }

    /* renamed from: b */
    public String m24579b() {
        if (this.f21093a == null) {
            m24575b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.f21094b != null) {
                return this.f21094b.mo24565b();
            }
            return null;
        } catch (RemoteException e2) {
            m24575b("getUDID error, RemoteException!");
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            m24575b("getUDID error, Exception!");
            e3.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public boolean m24580c() {
        try {
            if (this.f21094b == null) {
                return false;
            }
            m24574a("Device support opendeviceid");
            return this.f21094b.mo24567c();
        } catch (RemoteException unused) {
            m24575b("isSupport error, RemoteException!");
            return false;
        }
    }

    /* renamed from: d */
    public String m24581d() {
        Context context = this.f21093a;
        if (context == null) {
            m24574a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        m24574a("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            m24574a("input package is null!");
            return null;
        }
        try {
            if (this.f21094b != null) {
                return this.f21094b.mo24564a(packageName);
            }
            return null;
        } catch (RemoteException e2) {
            m24575b("getVAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    public String m24582e() {
        Context context = this.f21093a;
        if (context == null) {
            m24574a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        m24574a("liufeng, getAAID package：" + packageName);
        String str = null;
        if (packageName == null || packageName.equals("")) {
            m24574a("input package is null!");
            return null;
        }
        try {
            if (this.f21094b == null) {
                return null;
            }
            str = this.f21094b.mo24566b(packageName);
            return ((str == null || "".equals(str)) && this.f21094b.mo24568c(packageName)) ? this.f21094b.mo24566b(packageName) : str;
        } catch (RemoteException unused) {
            m24575b("getAAID error, RemoteException!");
            return str;
        }
    }

    /* renamed from: f */
    public void m24583f() {
        try {
            this.f21093a.unbindService(this.f21095c);
            m24574a("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            m24575b("unBind Service exception");
        }
        this.f21094b = null;
    }

    /* renamed from: a */
    public int m24576a(Context context, b<String> bVar) {
        if (context != null) {
            this.f21093a = context;
            this.f21096d = bVar;
            this.f21095c = new a();
            Intent intent = new Intent();
            intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
            if (this.f21093a.bindService(intent, this.f21095c, 1)) {
                m24574a("bindService Successful!");
                return 1;
            }
            m24574a("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    /* renamed from: b */
    private void m24575b(String str) {
        boolean z = f21092f;
    }

    /* renamed from: a */
    public String m24577a() {
        if (this.f21093a != null) {
            try {
                if (this.f21094b != null) {
                    return this.f21094b.mo24563a();
                }
                return null;
            } catch (RemoteException e2) {
                m24575b("getOAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        }
        m24575b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    /* renamed from: a */
    public void m24578a(boolean z) {
        f21092f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m24574a(String str) {
        boolean z = f21092f;
    }
}
