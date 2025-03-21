package p251g.p252a.p268y0.p281g;

import java.util.concurrent.Callable;

/* compiled from: ScheduledDirectTask.java */
/* renamed from: g.a.y0.g.m */
/* loaded from: classes2.dex */
public final class CallableC5124m extends AbstractC5112a implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public CallableC5124m(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            return null;
        } finally {
            lazySet(AbstractC5112a.FINISHED);
            this.runner = null;
        }
    }
}
