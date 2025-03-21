package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.vivo.push.util.C3984aa;
import com.vivo.push.util.C3990ag;
import com.vivo.push.util.C4010u;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IPCManager.java */
/* renamed from: com.vivo.push.i */
/* loaded from: classes2.dex */
public final class ServiceConnectionC3920i implements ServiceConnection {

    /* renamed from: a */
    private static final Object f14057a = new Object();

    /* renamed from: b */
    private static Map<String, ServiceConnectionC3920i> f14058b = new HashMap();

    /* renamed from: c */
    private boolean f14059c;

    /* renamed from: d */
    private String f14060d;

    /* renamed from: e */
    private Context f14061e;

    /* renamed from: g */
    private volatile IPCInvoke f14063g;

    /* renamed from: i */
    private String f14065i;

    /* renamed from: j */
    private Handler f14066j;

    /* renamed from: h */
    private Object f14064h = new Object();

    /* renamed from: f */
    private AtomicInteger f14062f = new AtomicInteger(1);

    private ServiceConnectionC3920i(Context context, String str) {
        this.f14060d = null;
        this.f14066j = null;
        this.f14061e = context;
        this.f14065i = str;
        this.f14066j = new Handler(Looper.getMainLooper(), new C3921j(this));
        this.f14060d = C3984aa.m13180a(context);
        if (!TextUtils.isEmpty(this.f14060d) && !TextUtils.isEmpty(this.f14065i)) {
            this.f14059c = C3990ag.m13207a(context, this.f14060d) >= 1260;
            m12998b();
            return;
        }
        C4010u.m13308c(this.f14061e, "init error : push pkgname is " + this.f14060d + " ; action is " + this.f14065i);
        this.f14059c = false;
    }

    /* renamed from: d */
    private void m13002d() {
        this.f14066j.removeMessages(1);
        this.f14066j.sendEmptyMessageDelayed(1, 3000L);
    }

    /* renamed from: e */
    private void m13003e() {
        this.f14066j.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m13004f() {
        try {
            this.f14061e.unbindService(this);
        } catch (Exception e2) {
            C4010u.m13292a("AidlManager", "On unBindServiceException:" + e2.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        C4010u.m13301b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        m13003e();
        this.f14063g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.f14063g == null) {
            C4010u.m13309d("AidlManager", "onServiceConnected error : aidl must not be null.");
            m13004f();
            this.f14062f.set(1);
            return;
        }
        if (this.f14062f.get() == 2) {
            m12997a(4);
        } else if (this.f14062f.get() != 4) {
            m13004f();
        }
        synchronized (this.f14064h) {
            this.f14064h.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f14063g = null;
        m12997a(1);
    }

    /* renamed from: a */
    public static ServiceConnectionC3920i m12995a(Context context, String str) {
        ServiceConnectionC3920i serviceConnectionC3920i = f14058b.get(str);
        if (serviceConnectionC3920i == null) {
            synchronized (f14057a) {
                serviceConnectionC3920i = f14058b.get(str);
                if (serviceConnectionC3920i == null) {
                    serviceConnectionC3920i = new ServiceConnectionC3920i(context, str);
                    f14058b.put(str, serviceConnectionC3920i);
                }
            }
        }
        return serviceConnectionC3920i;
    }

    /* renamed from: b */
    private void m12998b() {
        int i2 = this.f14062f.get();
        C4010u.m13309d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i2)));
        if (i2 == 4 || i2 == 2 || i2 == 3 || i2 == 5 || !this.f14059c) {
            return;
        }
        m12997a(2);
        if (m13001c()) {
            m13002d();
        } else {
            m12997a(1);
            C4010u.m13292a("AidlManager", "bind core service fail");
        }
    }

    /* renamed from: c */
    private boolean m13001c() {
        Intent intent = new Intent(this.f14065i);
        intent.setPackage(this.f14060d);
        try {
            return this.f14061e.bindService(intent, this, 1);
        } catch (Exception e2) {
            C4010u.m13293a("AidlManager", "bind core error", e2);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean m13005a() {
        this.f14060d = C3984aa.m13180a(this.f14061e);
        if (TextUtils.isEmpty(this.f14060d)) {
            C4010u.m13308c(this.f14061e, "push pkgname is null");
            return false;
        }
        this.f14059c = C3990ag.m13207a(this.f14061e, this.f14060d) >= 1260;
        return this.f14059c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12997a(int i2) {
        this.f14062f.set(i2);
    }

    /* renamed from: a */
    public final boolean m13006a(Bundle bundle) {
        m12998b();
        if (this.f14062f.get() == 2) {
            synchronized (this.f14064h) {
                try {
                    this.f14064h.wait(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            int i2 = this.f14062f.get();
            if (i2 == 4) {
                this.f14066j.removeMessages(2);
                this.f14066j.sendEmptyMessageDelayed(2, 30000L);
                this.f14063g.asyncCall(bundle, null);
                return true;
            }
            C4010u.m13309d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i2)));
            return false;
        } catch (Exception e3) {
            C4010u.m13293a("AidlManager", "invoke error ", e3);
            int i3 = this.f14062f.get();
            C4010u.m13309d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i3)));
            if (i3 == 1) {
                return false;
            }
            if (i3 == 2) {
                m13003e();
                m12997a(1);
                return false;
            }
            if (i3 == 3) {
                m12997a(1);
                return false;
            }
            if (i3 != 4) {
                return false;
            }
            m12997a(1);
            m13004f();
            return false;
        }
    }
}
