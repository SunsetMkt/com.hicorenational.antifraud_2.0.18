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
import com.vivo.push.util.ag;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: IPCManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements ServiceConnection {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, i> f8538b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f8541e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile IPCInvoke f8543g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f8545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Handler f8546j;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Object f8544h = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicInteger f8542f = new AtomicInteger(1);

    private i(Context context, String str) {
        this.f8540d = null;
        this.f8546j = null;
        this.f8541e = context;
        this.f8545i = str;
        this.f8546j = new Handler(Looper.getMainLooper(), new j(this));
        this.f8540d = com.vivo.push.util.aa.a(context);
        if (!TextUtils.isEmpty(this.f8540d) && !TextUtils.isEmpty(this.f8545i)) {
            this.f8539c = ag.a(context, this.f8540d) >= 1260;
            b();
            return;
        }
        com.vivo.push.util.u.c(this.f8541e, "init error : push pkgname is " + this.f8540d + " ; action is " + this.f8545i);
        this.f8539c = false;
    }

    private void d() {
        this.f8546j.removeMessages(1);
        this.f8546j.sendEmptyMessageDelayed(1, 3000L);
    }

    private void e() {
        this.f8546j.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            this.f8541e.unbindService(this);
        } catch (Exception e2) {
            com.vivo.push.util.u.a("AidlManager", "On unBindServiceException:" + e2.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        com.vivo.push.util.u.b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e();
        this.f8543g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.f8543g == null) {
            com.vivo.push.util.u.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            f();
            this.f8542f.set(1);
            return;
        }
        if (this.f8542f.get() == 2) {
            a(4);
        } else if (this.f8542f.get() != 4) {
            f();
        }
        synchronized (this.f8544h) {
            this.f8544h.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f8543g = null;
        a(1);
    }

    public static i a(Context context, String str) {
        i iVar = f8538b.get(str);
        if (iVar == null) {
            synchronized (a) {
                iVar = f8538b.get(str);
                if (iVar == null) {
                    iVar = new i(context, str);
                    f8538b.put(str, iVar);
                }
            }
        }
        return iVar;
    }

    private void b() {
        int i2 = this.f8542f.get();
        com.vivo.push.util.u.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i2)));
        if (i2 == 4 || i2 == 2 || i2 == 3 || i2 == 5 || !this.f8539c) {
            return;
        }
        a(2);
        if (c()) {
            d();
        } else {
            a(1);
            com.vivo.push.util.u.a("AidlManager", "bind core service fail");
        }
    }

    private boolean c() {
        Intent intent = new Intent(this.f8545i);
        intent.setPackage(this.f8540d);
        try {
            return this.f8541e.bindService(intent, this, 1);
        } catch (Exception e2) {
            com.vivo.push.util.u.a("AidlManager", "bind core error", e2);
            return false;
        }
    }

    public final boolean a() {
        this.f8540d = com.vivo.push.util.aa.a(this.f8541e);
        if (TextUtils.isEmpty(this.f8540d)) {
            com.vivo.push.util.u.c(this.f8541e, "push pkgname is null");
            return false;
        }
        this.f8539c = ag.a(this.f8541e, this.f8540d) >= 1260;
        return this.f8539c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        this.f8542f.set(i2);
    }

    public final boolean a(Bundle bundle) {
        b();
        if (this.f8542f.get() == 2) {
            synchronized (this.f8544h) {
                try {
                    this.f8544h.wait(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            int i2 = this.f8542f.get();
            if (i2 == 4) {
                this.f8546j.removeMessages(2);
                this.f8546j.sendEmptyMessageDelayed(2, 30000L);
                this.f8543g.asyncCall(bundle, null);
                return true;
            }
            com.vivo.push.util.u.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i2)));
            return false;
        } catch (Exception e3) {
            com.vivo.push.util.u.a("AidlManager", "invoke error ", e3);
            int i3 = this.f8542f.get();
            com.vivo.push.util.u.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i3)));
            if (i3 == 1) {
                return false;
            }
            if (i3 == 2) {
                e();
                a(1);
                return false;
            }
            if (i3 == 3) {
                a(1);
                return false;
            }
            if (i3 != 4) {
                return false;
            }
            a(1);
            f();
            return false;
        }
    }
}
