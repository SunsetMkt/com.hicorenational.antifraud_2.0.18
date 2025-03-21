package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.C2242z;
import com.hihonor.push.sdk.InterfaceC2187b0;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;

/* renamed from: com.hihonor.push.sdk.f0 */
/* loaded from: classes.dex */
public class ServiceConnectionC2200f0 implements ServiceConnection {

    /* renamed from: e */
    public static final Object f6770e = new Object();

    /* renamed from: a */
    public final RemoteServiceBean f6771a;

    /* renamed from: b */
    public a f6772b;

    /* renamed from: c */
    public Handler f6773c = null;

    /* renamed from: d */
    public boolean f6774d = false;

    /* renamed from: com.hihonor.push.sdk.f0$a */
    public interface a {
    }

    public ServiceConnectionC2200f0(RemoteServiceBean remoteServiceBean) {
        this.f6771a = remoteServiceBean;
    }

    /* renamed from: a */
    public final void m6385a(int i2) {
        a aVar = this.f6772b;
        if (aVar != null) {
            C2190c0 c2190c0 = (C2190c0) aVar;
            c2190c0.f6757a.f6760a.set(i2 == HonorPushErrorEnum.ERROR_SERVICE_TIME_OUT.statusCode ? 2 : 1);
            c2190c0.f6757a.m6382a(i2);
            c2190c0.f6757a.f6761b = null;
        }
    }

    /* renamed from: b */
    public void m6386b() {
        try {
            String str = "trying to unbind service from " + this;
            C2214l.f6798e.m6393a().unbindService(this);
        } catch (Exception e2) {
            String str2 = "on unBind service exception:" + e2.getMessage();
        }
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        if (this.f6774d) {
            this.f6774d = false;
            return;
        }
        m6386b();
        m6384a();
        a aVar = this.f6772b;
        if (aVar != null) {
            C2190c0 c2190c0 = (C2190c0) aVar;
            c2190c0.f6757a.f6760a.set(1);
            c2190c0.f6757a.m6382a(8002005);
            c2190c0.f6757a.f6761b = null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        m6384a();
        a aVar = this.f6772b;
        if (aVar != null) {
            C2190c0 c2190c0 = (C2190c0) aVar;
            c2190c0.f6757a.f6761b = IPushInvoke.Stub.asInterface(iBinder);
            if (c2190c0.f6757a.f6761b == null) {
                c2190c0.f6757a.f6763d.m6386b();
                c2190c0.f6757a.f6760a.set(1);
                c2190c0.f6757a.m6382a(8002001);
                return;
            }
            c2190c0.f6757a.f6760a.set(3);
            InterfaceC2187b0.a aVar2 = c2190c0.f6757a.f6762c;
            if (aVar2 != null) {
                C2242z.a aVar3 = (C2242z.a) aVar2;
                if (Looper.myLooper() == C2242z.this.f6857a.getLooper()) {
                    aVar3.m6407b();
                } else {
                    C2242z.this.f6857a.post(new RunnableC2238x(aVar3));
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        a aVar = this.f6772b;
        if (aVar != null) {
            C2190c0 c2190c0 = (C2190c0) aVar;
            c2190c0.f6757a.f6760a.set(1);
            c2190c0.f6757a.m6382a(8002002);
            c2190c0.f6757a.f6761b = null;
        }
    }

    /* renamed from: a */
    public final void m6384a() {
        synchronized (f6770e) {
            Handler handler = this.f6773c;
            if (handler != null) {
                handler.removeMessages(1001);
                this.f6773c = null;
            }
        }
    }
}
