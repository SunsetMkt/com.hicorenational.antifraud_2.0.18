package anetwork.channel.entity;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.entity.f */
/* loaded from: classes.dex */
final class ThreadFactoryC0894f implements ThreadFactory {
    ThreadFactoryC0894f() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger;
        atomicInteger = C0893e.f1341b;
        return new Thread(runnable, String.format("RepeaterThread:%d", Integer.valueOf(atomicInteger.getAndIncrement())));
    }
}
