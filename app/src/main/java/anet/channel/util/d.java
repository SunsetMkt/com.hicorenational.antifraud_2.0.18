package anet.channel.util;

import anet.channel.statist.NetTypeStat;
import anet.channel.thread.ThreadPoolExecutorFactory;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class d implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ NetTypeStat f1654b;

    d(String str, NetTypeStat netTypeStat) {
        this.a = str;
        this.f1654b = netTypeStat;
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadPoolExecutorFactory.submitPriorityTask(new e(this), ThreadPoolExecutorFactory.Priority.LOW);
    }
}
