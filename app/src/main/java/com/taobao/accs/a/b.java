package com.taobao.accs.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.k;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class b implements ServiceConnection {
    final /* synthetic */ Intent a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ Context f5706b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ Context f5707c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ int f5708d;

    b(Intent intent, Context context, Context context2, int i2) {
        this.a = intent;
        this.f5706b = context;
        this.f5707c = context2;
        this.f5708d = i2;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ALog.d(a.TAG, "bindService connected", "componentName", componentName.toString());
        try {
            Messenger messenger = new Messenger(iBinder);
            Message message = new Message();
            message.getData().putParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, this.a);
            messenger.send(message);
            try {
                this.f5706b.unbindService(this);
            } catch (Throwable unused) {
            }
            if (!this.f5707c.getPackageName().equals(componentName.getPackageName())) {
                return;
            }
        } catch (Throwable th) {
            try {
                ALog.e(a.TAG, "dispatch intent with exception", th, new Object[0]);
                try {
                    this.f5706b.unbindService(this);
                } catch (Throwable unused2) {
                }
                if (!this.f5707c.getPackageName().equals(componentName.getPackageName())) {
                    return;
                }
            } finally {
            }
        }
        k.a("accs", BaseMonitor.ALARM_POINT_BIND, componentName.getClassName());
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ALog.d(a.TAG, "bindService on disconnect", "componentName", componentName.toString());
        try {
            this.f5706b.unbindService(this);
        } catch (Throwable unused) {
        }
        if (this.f5707c.getPackageName().equals(componentName.getPackageName())) {
            k.a("accs", BaseMonitor.ALARM_POINT_BIND, componentName.getClassName(), UtilityImpl.a(this.f5708d - 3), "onServiceDisconnected");
        }
    }
}
