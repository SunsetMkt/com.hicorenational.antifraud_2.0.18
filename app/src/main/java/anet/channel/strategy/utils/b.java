package anet.channel.strategy.utils;

import anet.channel.util.ALog;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class b implements ThreadFactory {
    b() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger;
        StringBuilder sb = new StringBuilder();
        sb.append("AMDC");
        atomicInteger = a.f2026a;
        sb.append(atomicInteger.incrementAndGet());
        Thread thread = new Thread(runnable, sb.toString());
        ALog.i(anet.channel.strategy.dispatch.a.TAG, "thread created!", null, CommonNetImpl.NAME, thread.getName());
        thread.setPriority(5);
        return thread;
    }
}
