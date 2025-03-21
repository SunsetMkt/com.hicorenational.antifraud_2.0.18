package p000a.p001a.p013t;

import anet.channel.thread.ThreadPoolExecutorFactory;

/* compiled from: Taobao */
/* renamed from: a.a.t.h */
/* loaded from: classes.dex */
class RunnableC0043h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0042g f118a;

    RunnableC0043h(C0042g c0042g) {
        this.f118a = c0042g;
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadPoolExecutorFactory.submitPriorityTask(this.f118a, ThreadPoolExecutorFactory.Priority.HIGH);
    }
}
