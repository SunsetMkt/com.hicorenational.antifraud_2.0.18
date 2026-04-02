package h.a.y0.e.d;

import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: ObservableBlockingSubscribe.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l {
    private l() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void a(h.a.g0<? extends T> g0Var, h.a.i0<? super T> i0Var) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        h.a.y0.d.i iVar = new h.a.y0.d.i(linkedBlockingQueue);
        i0Var.onSubscribe(iVar);
        g0Var.subscribe(iVar);
        while (!iVar.isDisposed()) {
            Object objPoll = linkedBlockingQueue.poll();
            if (objPoll == null) {
                try {
                    objPoll = linkedBlockingQueue.take();
                } catch (InterruptedException e2) {
                    iVar.dispose();
                    i0Var.onError(e2);
                    return;
                }
            }
            if (iVar.isDisposed() || g0Var == h.a.y0.d.i.TERMINATED || h.a.y0.j.q.acceptFull(objPoll, i0Var)) {
                return;
            }
        }
    }

    public static <T> void a(h.a.g0<? extends T> g0Var) {
        h.a.y0.j.f fVar = new h.a.y0.j.f();
        h.a.y0.d.v vVar = new h.a.y0.d.v(h.a.y0.b.a.d(), fVar, fVar, h.a.y0.b.a.d());
        g0Var.subscribe(vVar);
        h.a.y0.j.e.a(fVar, vVar);
        Throwable th = fVar.a;
        if (th != null) {
            throw h.a.y0.j.k.c(th);
        }
    }

    public static <T> void a(h.a.g0<? extends T> g0Var, h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar) {
        h.a.y0.b.b.a(gVar, "onNext is null");
        h.a.y0.b.b.a(gVar2, "onError is null");
        h.a.y0.b.b.a(aVar, "onComplete is null");
        a(g0Var, new h.a.y0.d.v(gVar, gVar2, aVar, h.a.y0.b.a.d()));
    }
}
