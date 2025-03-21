package com.taobao.accs.p197a;

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
import com.taobao.accs.utl.C3043k;
import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.a.b */
/* loaded from: classes.dex */
class ServiceConnectionC2962b implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ Intent f9371a;

    /* renamed from: b */
    final /* synthetic */ Context f9372b;

    /* renamed from: c */
    final /* synthetic */ Context f9373c;

    /* renamed from: d */
    final /* synthetic */ int f9374d;

    ServiceConnectionC2962b(Intent intent, Context context, Context context2, int i2) {
        this.f9371a = intent;
        this.f9372b = context;
        this.f9373c = context2;
        this.f9374d = i2;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ALog.m9180d(C2961a.TAG, "bindService connected", "componentName", componentName.toString());
        try {
            Messenger messenger = new Messenger(iBinder);
            Message message = new Message();
            message.getData().putParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, this.f9371a);
            messenger.send(message);
            try {
                this.f9372b.unbindService(this);
            } catch (Throwable unused) {
            }
            if (!this.f9373c.getPackageName().equals(componentName.getPackageName())) {
                return;
            }
        } catch (Throwable th) {
            try {
                ALog.m9181e(C2961a.TAG, "dispatch intent with exception", th, new Object[0]);
                try {
                    this.f9372b.unbindService(this);
                } catch (Throwable unused2) {
                }
                if (!this.f9373c.getPackageName().equals(componentName.getPackageName())) {
                    return;
                }
            } finally {
            }
        }
        C3043k.m9249a("accs", BaseMonitor.ALARM_POINT_BIND, componentName.getClassName());
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ALog.m9180d(C2961a.TAG, "bindService on disconnect", "componentName", componentName.toString());
        try {
            this.f9372b.unbindService(this);
        } catch (Throwable unused) {
        }
        if (this.f9373c.getPackageName().equals(componentName.getPackageName())) {
            C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_BIND, componentName.getClassName(), UtilityImpl.m9194a(this.f9374d - 3), "onServiceDisconnected");
        }
    }
}
