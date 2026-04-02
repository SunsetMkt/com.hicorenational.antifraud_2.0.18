package com.taobao.accs.net;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.internal.AccsJobService;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static volatile g f5816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f5817c = {SubsamplingScaleImageView.ORIENTATION_270, 360, 480};
    protected Context a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5820f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int[] f5821g = {0, 0, 0};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f5822h;

    protected g(Context context) {
        this.f5822h = true;
        try {
            this.a = context;
            this.f5818d = 0;
            this.f5819e = System.currentTimeMillis();
            this.f5822h = com.taobao.accs.utl.t.a();
        } catch (Throwable th) {
            ALog.e("HeartbeatManager", "HeartbeatManager", th, new Object[0]);
        }
    }

    public static g a(Context context) {
        if (f5816b == null) {
            synchronized (g.class) {
                if (f5816b == null) {
                    if (GlobalConfig.isJobHeartbeatEnable() && Build.VERSION.SDK_INT >= 21 && b(context)) {
                        ALog.i("HeartbeatManager", "hb use job", new Object[0]);
                        f5816b = new f(context);
                    } else {
                        ALog.i("HeartbeatManager", "hb use alarm", new Object[0]);
                        f5816b = new e(context);
                    }
                }
            }
        }
        return f5816b;
    }

    private static boolean b(Context context) {
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

    protected abstract void a(int i2);

    public void c() {
        this.f5819e = -1L;
        if (this.f5820f) {
            int[] iArr = this.f5821g;
            int i2 = this.f5818d;
            iArr[i2] = iArr[i2] + 1;
        }
        int i3 = this.f5818d;
        this.f5818d = i3 > 0 ? i3 - 1 : 0;
        ALog.d("HeartbeatManager", "onNetworkTimeout", new Object[0]);
    }

    public void d() {
        this.f5819e = -1L;
        ALog.d("HeartbeatManager", "onNetworkFail", new Object[0]);
    }

    public void e() {
        ALog.d("HeartbeatManager", "onHeartbeatSucc", new Object[0]);
        if (System.currentTimeMillis() - this.f5819e <= 7199000) {
            this.f5820f = false;
            this.f5821g[this.f5818d] = 0;
            return;
        }
        int i2 = this.f5818d;
        if (i2 >= f5817c.length - 1 || this.f5821g[i2] > 2) {
            return;
        }
        ALog.d("HeartbeatManager", "upgrade", new Object[0]);
        this.f5818d++;
        this.f5820f = true;
        this.f5819e = System.currentTimeMillis();
    }

    public void f() {
        this.f5818d = 0;
        this.f5819e = System.currentTimeMillis();
        ALog.d("HeartbeatManager", "resetLevel", new Object[0]);
    }

    public int b() {
        int i2 = this.f5822h ? f5817c[this.f5818d] : SubsamplingScaleImageView.ORIENTATION_270;
        this.f5822h = com.taobao.accs.utl.t.a();
        return i2;
    }

    public synchronized void a() {
        try {
            if (this.f5819e < 0) {
                this.f5819e = System.currentTimeMillis();
            }
            int iB = b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("HeartbeatManager", "set " + iB, new Object[0]);
            }
            a(iB);
        } catch (Throwable th) {
            ALog.e("HeartbeatManager", "set", th, new Object[0]);
        }
    }
}
