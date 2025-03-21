package anet.channel;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import anet.channel.util.ALog;
import com.huawei.hms.support.api.entity.core.CommonCode;

/* compiled from: Taobao */
/* renamed from: anet.channel.h */
/* loaded from: classes.dex */
class ServiceConnectionC0788h implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ Intent f861a;

    /* renamed from: b */
    final /* synthetic */ Context f862b;

    /* renamed from: c */
    final /* synthetic */ SessionRequest f863c;

    ServiceConnectionC0788h(SessionRequest sessionRequest, Intent intent, Context context) {
        this.f863c = sessionRequest;
        this.f861a = intent;
        this.f862b = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ALog.m713d("awcn.SessionRequest", "onServiceConnected", null, new Object[0]);
        try {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message message = new Message();
                message.getData().putParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, this.f861a);
                messenger.send(message);
            } catch (Exception e2) {
                ALog.m714e("awcn.SessionRequest", "onServiceConnected sendMessage error.", null, e2, new Object[0]);
            }
        } finally {
            this.f862b.unbindService(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ALog.m713d("awcn.SessionRequest", "onServiceDisconnected", null, new Object[0]);
        this.f862b.unbindService(this);
    }
}
