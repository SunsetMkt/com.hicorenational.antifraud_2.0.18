package anet.channel;

import android.content.Intent;
import anet.channel.util.ALog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f1669a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AccsSessionManager f1670b;

    a(AccsSessionManager accsSessionManager, Intent intent) {
        this.f1670b = accsSessionManager;
        this.f1669a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        CopyOnWriteArraySet copyOnWriteArraySet;
        copyOnWriteArraySet = AccsSessionManager.f1583c;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            try {
                ((ISessionListener) it.next()).onConnectionChanged(this.f1669a);
            } catch (Exception e2) {
                ALog.e("awcn.AccsSessionManager", "notifyListener exception.", null, e2, new Object[0]);
            }
        }
    }
}
