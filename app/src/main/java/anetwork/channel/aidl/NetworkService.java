package anetwork.channel.aidl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import anet.channel.util.ALog;
import anetwork.channel.aidl.InterfaceC0866b;
import anetwork.channel.aidl.InterfaceC0872h;
import p000a.p001a.p005m.BinderC0020b;
import p000a.p001a.p007o.BinderC0024b;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NetworkService extends Service {

    /* renamed from: a */
    private Context f1209a;

    /* renamed from: b */
    private InterfaceC0872h.a f1210b = null;

    /* renamed from: c */
    private InterfaceC0872h.a f1211c = null;

    /* renamed from: d */
    InterfaceC0866b.a f1212d = new BinderC0867c(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.f1209a = getApplicationContext();
        if (ALog.isPrintLog(2)) {
            ALog.m716i("anet.NetworkService", "onBind:" + intent.getAction(), null, new Object[0]);
        }
        this.f1210b = new BinderC0020b(this.f1209a);
        this.f1211c = new BinderC0024b(this.f1209a);
        if (InterfaceC0866b.class.getName().equals(intent.getAction())) {
            return this.f1212d;
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
