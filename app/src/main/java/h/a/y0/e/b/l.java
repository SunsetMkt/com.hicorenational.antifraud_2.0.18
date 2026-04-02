package h.a.y0.e.b;

import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: FlowableBlockingSubscribe.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l {
    private l() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void a(j.d.b<? extends T> bVar, j.d.c<? super T> cVar) {
        Object objPoll;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        h.a.y0.h.f fVar = new h.a.y0.h.f(linkedBlockingQueue);
        bVar.subscribe(fVar);
        do {
            try {
                if (fVar.isCancelled()) {
                    return;
                }
                objPoll = linkedBlockingQueue.poll();
                if (objPoll == null) {
                    if (fVar.isCancelled()) {
                        return;
                    }
                    h.a.y0.j.e.a();
                    objPoll = linkedBlockingQueue.take();
                }
                if (fVar.isCancelled() || bVar == h.a.y0.h.f.TERMINATED) {
                    return;
                }
            } catch (InterruptedException e2) {
                fVar.cancel();
                cVar.onError(e2);
                return;
            }
        } while (!h.a.y0.j.q.acceptFull(objPoll, cVar));
    }

    public static <T> void a(j.d.b<? extends T> bVar) {
        h.a.y0.j.f fVar = new h.a.y0.j.f();
        h.a.y0.h.l lVar = new h.a.y0.h.l(h.a.y0.b.a.d(), fVar, fVar, h.a.y0.b.a.f10456l);
        bVar.subscribe(lVar);
        h.a.y0.j.e.a(fVar, lVar);
        Throwable th = fVar.a;
        if (th != null) {
            throw h.a.y0.j.k.c(th);
        }
    }

    public static <T> void a(j.d.b<? extends T> bVar, h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar) {
        h.a.y0.b.b.a(gVar, "onNext is null");
        h.a.y0.b.b.a(gVar2, "onError is null");
        h.a.y0.b.b.a(aVar, "onComplete is null");
        a(bVar, new h.a.y0.h.l(gVar, gVar2, aVar, h.a.y0.b.a.f10456l));
    }
}
