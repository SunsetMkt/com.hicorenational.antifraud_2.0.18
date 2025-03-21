package anet.channel.util;

import anet.channel.statist.NetTypeStat;
import anet.channel.thread.ThreadPoolExecutorFactory;

/* compiled from: Taobao */
/* renamed from: anet.channel.util.d */
/* loaded from: classes.dex */
final class RunnableC0858d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f1178a;

    /* renamed from: b */
    final /* synthetic */ NetTypeStat f1179b;

    RunnableC0858d(String str, NetTypeStat netTypeStat) {
        this.f1178a = str;
        this.f1179b = netTypeStat;
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadPoolExecutorFactory.submitPriorityTask(new RunnableC0859e(this), ThreadPoolExecutorFactory.Priority.LOW);
    }
}
