package anet.channel;

import android.content.Intent;
import anet.channel.util.ALog;
import java.util.Iterator;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ Intent a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AccsSessionManager f1385b;

    a(AccsSessionManager accsSessionManager, Intent intent) {
        this.f1385b = accsSessionManager;
        this.a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = AccsSessionManager.f1310c.iterator();
        while (it.hasNext()) {
            try {
                ((ISessionListener) it.next()).onConnectionChanged(this.a);
            } catch (Exception e2) {
                ALog.e("awcn.AccsSessionManager", "notifyListener exception.", null, e2, new Object[0]);
            }
        }
    }
}
