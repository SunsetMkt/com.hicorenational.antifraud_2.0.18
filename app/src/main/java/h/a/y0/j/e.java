package h.a.y0.j;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: BlockingHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private e() {
        throw new IllegalStateException("No instances!");
    }

    public static void a(CountDownLatch countDownLatch, h.a.u0.c cVar) {
        if (countDownLatch.getCount() == 0) {
            return;
        }
        try {
            a();
            countDownLatch.await();
        } catch (InterruptedException e2) {
            cVar.dispose();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e2);
        }
    }

    public static void a() {
        if (h.a.c1.a.y()) {
            if ((Thread.currentThread() instanceof h.a.y0.g.j) || h.a.c1.a.B()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
