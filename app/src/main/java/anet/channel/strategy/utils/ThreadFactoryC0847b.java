package anet.channel.strategy.utils;

import anet.channel.strategy.dispatch.C0830a;
import anet.channel.util.ALog;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.utils.b */
/* loaded from: classes.dex */
final class ThreadFactoryC0847b implements ThreadFactory {
    ThreadFactoryC0847b() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger;
        StringBuilder sb = new StringBuilder();
        sb.append("AMDC");
        atomicInteger = C0846a.f1146a;
        sb.append(atomicInteger.incrementAndGet());
        Thread thread = new Thread(runnable, sb.toString());
        ALog.m716i(C0830a.TAG, "thread created!", null, CommonNetImpl.NAME, thread.getName());
        thread.setPriority(5);
        return thread;
    }
}
