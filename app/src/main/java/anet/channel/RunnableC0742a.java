package anet.channel;

import android.content.Intent;
import anet.channel.util.ALog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Taobao */
/* renamed from: anet.channel.a */
/* loaded from: classes.dex */
class RunnableC0742a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Intent f743a;

    /* renamed from: b */
    final /* synthetic */ AccsSessionManager f744b;

    RunnableC0742a(AccsSessionManager accsSessionManager, Intent intent) {
        this.f744b = accsSessionManager;
        this.f743a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        CopyOnWriteArraySet copyOnWriteArraySet;
        copyOnWriteArraySet = AccsSessionManager.f632c;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            try {
                ((ISessionListener) it.next()).onConnectionChanged(this.f743a);
            } catch (Exception e2) {
                ALog.m714e("awcn.AccsSessionManager", "notifyListener exception.", null, e2, new Object[0]);
            }
        }
    }
}
