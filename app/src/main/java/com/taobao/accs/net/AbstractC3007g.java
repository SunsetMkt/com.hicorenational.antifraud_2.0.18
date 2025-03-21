package com.taobao.accs.net;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.internal.AccsJobService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3052t;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.g */
/* loaded from: classes2.dex */
public abstract class AbstractC3007g {

    /* renamed from: b */
    protected static volatile AbstractC3007g f9547b;

    /* renamed from: c */
    private static final int[] f9548c = {SubsamplingScaleImageView.ORIENTATION_270, 360, 480};

    /* renamed from: a */
    protected Context f9549a;

    /* renamed from: d */
    private int f9550d;

    /* renamed from: e */
    private long f9551e;

    /* renamed from: f */
    private boolean f9552f = false;

    /* renamed from: g */
    private int[] f9553g = {0, 0, 0};

    /* renamed from: h */
    private boolean f9554h;

    protected AbstractC3007g(Context context) {
        this.f9554h = true;
        try {
            this.f9549a = context;
            this.f9550d = 0;
            this.f9551e = System.currentTimeMillis();
            this.f9554h = C3052t.m9276a();
        } catch (Throwable th) {
            ALog.m9181e("HeartbeatManager", "HeartbeatManager", th, new Object[0]);
        }
    }

    /* renamed from: a */
    public static AbstractC3007g m9112a(Context context) {
        if (f9547b == null) {
            synchronized (AbstractC3007g.class) {
                if (f9547b == null) {
                    if (GlobalConfig.isJobHeartbeatEnable() && Build.VERSION.SDK_INT >= 21 && m9113b(context)) {
                        ALog.m9183i("HeartbeatManager", "hb use job", new Object[0]);
                        f9547b = new C3006f(context);
                    } else {
                        ALog.m9183i("HeartbeatManager", "hb use alarm", new Object[0]);
                        f9547b = new C3005e(context);
                    }
                }
            }
        }
        return f9547b;
    }

    /* renamed from: b */
    private static boolean m9113b(Context context) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), AccsJobService.class.getName()), 0);
            if (serviceInfo != null) {
                return serviceInfo.isEnabled();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    protected abstract void mo9111a(int i2);

    /* renamed from: c */
    public void m9116c() {
        this.f9551e = -1L;
        if (this.f9552f) {
            int[] iArr = this.f9553g;
            int i2 = this.f9550d;
            iArr[i2] = iArr[i2] + 1;
        }
        int i3 = this.f9550d;
        this.f9550d = i3 > 0 ? i3 - 1 : 0;
        ALog.m9180d("HeartbeatManager", "onNetworkTimeout", new Object[0]);
    }

    /* renamed from: d */
    public void m9117d() {
        this.f9551e = -1L;
        ALog.m9180d("HeartbeatManager", "onNetworkFail", new Object[0]);
    }

    /* renamed from: e */
    public void m9118e() {
        ALog.m9180d("HeartbeatManager", "onHeartbeatSucc", new Object[0]);
        if (System.currentTimeMillis() - this.f9551e <= 7199000) {
            this.f9552f = false;
            this.f9553g[this.f9550d] = 0;
            return;
        }
        int i2 = this.f9550d;
        if (i2 >= f9548c.length - 1 || this.f9553g[i2] > 2) {
            return;
        }
        ALog.m9180d("HeartbeatManager", "upgrade", new Object[0]);
        this.f9550d++;
        this.f9552f = true;
        this.f9551e = System.currentTimeMillis();
    }

    /* renamed from: f */
    public void m9119f() {
        this.f9550d = 0;
        this.f9551e = System.currentTimeMillis();
        ALog.m9180d("HeartbeatManager", "resetLevel", new Object[0]);
    }

    /* renamed from: b */
    public int m9115b() {
        int i2 = this.f9554h ? f9548c[this.f9550d] : SubsamplingScaleImageView.ORIENTATION_270;
        this.f9554h = C3052t.m9276a();
        return i2;
    }

    /* renamed from: a */
    public synchronized void m9114a() {
        try {
            if (this.f9551e < 0) {
                this.f9551e = System.currentTimeMillis();
            }
            int m9115b = m9115b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d("HeartbeatManager", "set " + m9115b, new Object[0]);
            }
            mo9111a(m9115b);
        } catch (Throwable th) {
            ALog.m9181e("HeartbeatManager", "set", th, new Object[0]);
        }
    }
}
