package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.b0;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.z;

/* JADX INFO: loaded from: classes.dex */
public class f0 implements ServiceConnection {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f4247e = new Object();
    public final RemoteServiceBean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f4248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f4249c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4250d = false;

    public interface a {
    }

    public f0(RemoteServiceBean remoteServiceBean) {
        this.a = remoteServiceBean;
    }

    public final void a(int i2) {
        a aVar = this.f4248b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.a.a.set(i2 == HonorPushErrorEnum.ERROR_SERVICE_TIME_OUT.statusCode ? 2 : 1);
            c0Var.a.a(i2);
            c0Var.a.f4241b = null;
        }
    }

    public void b() {
        try {
            String str = "trying to unbind service from " + this;
            l.f4263e.a().unbindService(this);
        } catch (Exception e2) {
            String str2 = "on unBind service exception:" + e2.getMessage();
        }
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        if (this.f4250d) {
            this.f4250d = false;
            return;
        }
        b();
        a();
        a aVar = this.f4248b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.a.a.set(1);
            c0Var.a.a(8002005);
            c0Var.a.f4241b = null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a();
        a aVar = this.f4248b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.a.f4241b = IPushInvoke.Stub.asInterface(iBinder);
            if (c0Var.a.f4241b == null) {
                c0Var.a.f4243d.b();
                c0Var.a.a.set(1);
                c0Var.a.a(8002001);
                return;
            }
            c0Var.a.a.set(3);
            b0.a aVar2 = c0Var.a.f4242c;
            if (aVar2 != null) {
                z.a aVar3 = (z.a) aVar2;
                if (Looper.myLooper() == z.this.a.getLooper()) {
                    aVar3.b();
                } else {
                    z.this.a.post(new x(aVar3));
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        a aVar = this.f4248b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.a.a.set(1);
            c0Var.a.a(8002002);
            c0Var.a.f4241b = null;
        }
    }

    public final void a() {
        synchronized (f4247e) {
            Handler handler = this.f4249c;
            if (handler != null) {
                handler.removeMessages(1001);
                this.f4249c = null;
            }
        }
    }
}
