package org.android.agoo.control;

import com.taobao.accs.utl.ALog;
import org.android.agoo.control.AgooFactory;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class f implements Runnable {
    final /* synthetic */ AgooFactory.a a;

    f(AgooFactory.a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ALog.d("AgooFactory", "onConnected running tid:" + Thread.currentThread().getId(), new Object[0]);
            this.a.f12869c.doSend(this.a.a);
            ALog.d("AgooFactory", "send finish. close this connection", new Object[0]);
            this.a.f12869c = null;
            try {
                AgooFactory.mContext.unbindService(this.a.f12870d);
            } catch (Throwable th) {
                ALog.e("AgooFactory", "unbindService error", th, new Object[0]);
            }
        } catch (Throwable th2) {
            try {
                ALog.e("AgooFactory", "send error", th2, new Object[0]);
                ALog.d("AgooFactory", "send finish. close this connection", new Object[0]);
                this.a.f12869c = null;
                try {
                    AgooFactory.mContext.unbindService(this.a.f12870d);
                } catch (Throwable th3) {
                    ALog.e("AgooFactory", "unbindService error", th3, new Object[0]);
                }
            } catch (Throwable th4) {
                ALog.d("AgooFactory", "send finish. close this connection", new Object[0]);
                this.a.f12869c = null;
                try {
                    AgooFactory.mContext.unbindService(this.a.f12870d);
                } catch (Throwable th5) {
                    ALog.e("AgooFactory", "unbindService error", th5, new Object[0]);
                }
                throw th4;
            }
        }
    }
}
