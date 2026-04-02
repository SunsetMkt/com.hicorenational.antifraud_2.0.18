package anetwork.channel.aidl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import anet.channel.util.ALog;
import anetwork.channel.aidl.b;
import anetwork.channel.aidl.h;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class NetworkService extends Service {
    private Context a;

    /* JADX INFO: renamed from: b */
    private h.a f1675b = null;

    /* JADX INFO: renamed from: c */
    private h.a f1676c = null;

    /* JADX INFO: renamed from: d */
    b.a f1677d = new c(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.a = getApplicationContext();
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkService", "onBind:" + intent.getAction(), null, new Object[0]);
        }
        this.f1675b = new b.a.m.b(this.a);
        this.f1676c = new b.a.o.b(this.a);
        if (b.class.getName().equals(intent.getAction())) {
            return this.f1677d;
        }
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return 2;
    }
}
