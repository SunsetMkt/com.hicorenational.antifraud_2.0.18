package org.android.agoo.control;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.taobao.accs.utl.ALog;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.service.SendMessage;

/* compiled from: Taobao */
/* renamed from: org.android.agoo.control.f */
/* loaded from: classes2.dex */
class RunnableC6019f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AgooFactory.ServiceConnectionC6012a f21494a;

    RunnableC6019f(AgooFactory.ServiceConnectionC6012a serviceConnectionC6012a) {
        this.f21494a = serviceConnectionC6012a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ServiceConnection serviceConnection;
        ServiceConnection serviceConnection2;
        SendMessage sendMessage;
        Intent intent;
        ServiceConnection serviceConnection3;
        try {
            ALog.m9180d("AgooFactory", "onConnected running tid:" + Thread.currentThread().getId(), new Object[0]);
            sendMessage = this.f21494a.f21475c;
            intent = this.f21494a.f21473a;
            sendMessage.doSend(intent);
            ALog.m9180d("AgooFactory", "send finish. close this connection", new Object[0]);
            this.f21494a.f21475c = null;
            try {
                Context context = AgooFactory.mContext;
                serviceConnection3 = this.f21494a.f21476d;
                context.unbindService(serviceConnection3);
            } catch (Throwable th) {
                ALog.m9181e("AgooFactory", "unbindService error", th, new Object[0]);
            }
        } catch (Throwable th2) {
            try {
                ALog.m9181e("AgooFactory", "send error", th2, new Object[0]);
                ALog.m9180d("AgooFactory", "send finish. close this connection", new Object[0]);
                this.f21494a.f21475c = null;
                try {
                    Context context2 = AgooFactory.mContext;
                    serviceConnection2 = this.f21494a.f21476d;
                    context2.unbindService(serviceConnection2);
                } catch (Throwable th3) {
                    ALog.m9181e("AgooFactory", "unbindService error", th3, new Object[0]);
                }
            } catch (Throwable th4) {
                ALog.m9180d("AgooFactory", "send finish. close this connection", new Object[0]);
                this.f21494a.f21475c = null;
                try {
                    Context context3 = AgooFactory.mContext;
                    serviceConnection = this.f21494a.f21476d;
                    context3.unbindService(serviceConnection);
                } catch (Throwable th5) {
                    ALog.m9181e("AgooFactory", "unbindService error", th5, new Object[0]);
                }
                throw th4;
            }
        }
    }
}
