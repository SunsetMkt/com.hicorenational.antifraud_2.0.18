package anetwork.channel.entity;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class f implements ThreadFactory {
    f() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger;
        atomicInteger = e.f2203b;
        return new Thread(runnable, String.format("RepeaterThread:%d", Integer.valueOf(atomicInteger.getAndIncrement())));
    }
}
