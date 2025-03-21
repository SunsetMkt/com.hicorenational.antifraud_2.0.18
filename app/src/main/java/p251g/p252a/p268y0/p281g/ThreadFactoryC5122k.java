package p251g.p252a.p268y0.p281g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: RxThreadFactory.java */
/* renamed from: g.a.y0.g.k */
/* loaded from: classes2.dex */
public final class ThreadFactoryC5122k extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    /* compiled from: RxThreadFactory.java */
    /* renamed from: g.a.y0.g.k$a */
    static final class a extends Thread implements InterfaceC5121j {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public ThreadFactoryC5122k(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.prefix + '-' + incrementAndGet();
        Thread aVar = this.nonBlocking ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.priority);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.prefix + "]";
    }

    public ThreadFactoryC5122k(String str, int i2) {
        this(str, i2, false);
    }

    public ThreadFactoryC5122k(String str, int i2, boolean z) {
        this.prefix = str;
        this.priority = i2;
        this.nonBlocking = z;
    }
}
