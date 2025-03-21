package p251g.p252a.p268y0.p281g;

/* compiled from: ScheduledDirectPeriodicTask.java */
/* renamed from: g.a.y0.g.l */
/* loaded from: classes2.dex */
public final class RunnableC5123l extends AbstractC5112a implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public RunnableC5123l(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
        } finally {
            try {
            } finally {
            }
        }
    }
}
