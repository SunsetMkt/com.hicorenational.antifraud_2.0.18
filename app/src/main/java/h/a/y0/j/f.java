package h.a.y0.j;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: BlockingIgnoringReceiver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends CountDownLatch implements h.a.x0.g<Throwable>, h.a.x0.a {
    public Throwable a;

    public f() {
        super(1);
    }

    @Override // h.a.x0.g
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(Throwable th) {
        this.a = th;
        countDown();
    }

    @Override // h.a.x0.a
    public void run() {
        countDown();
    }
}
