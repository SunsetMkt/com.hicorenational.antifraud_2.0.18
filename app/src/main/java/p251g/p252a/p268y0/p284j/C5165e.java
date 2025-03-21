package p251g.p252a.p268y0.p284j;

import java.util.concurrent.CountDownLatch;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p281g.InterfaceC5121j;

/* compiled from: BlockingHelper.java */
/* renamed from: g.a.y0.j.e */
/* loaded from: classes2.dex */
public final class C5165e {
    private C5165e() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static void m18613a(CountDownLatch countDownLatch, InterfaceC4552c interfaceC4552c) {
        if (countDownLatch.getCount() == 0) {
            return;
        }
        try {
            m18612a();
            countDownLatch.await();
        } catch (InterruptedException e2) {
            interfaceC4552c.dispose();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e2);
        }
    }

    /* renamed from: a */
    public static void m18612a() {
        if (C4476a.m17201y()) {
            if ((Thread.currentThread() instanceof InterfaceC5121j) || C4476a.m17116B()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
