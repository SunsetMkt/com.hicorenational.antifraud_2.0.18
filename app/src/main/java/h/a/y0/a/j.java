package h.a.y0.a;

import h.a.i0;
import h.a.y0.j.q;

/* JADX INFO: compiled from: ObserverFullArbiter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j<T> extends g implements h.a.u0.c {
    final i0<? super T> F;
    final h.a.y0.f.c<Object> G;
    volatile h.a.u0.c H = e.INSTANCE;
    h.a.u0.c I;
    volatile boolean J;

    public j(i0<? super T> i0Var, h.a.u0.c cVar, int i2) {
        this.F = i0Var;
        this.I = cVar;
        this.G = new h.a.y0.f.c<>(i2);
    }

    void a() {
        h.a.u0.c cVar = this.I;
        this.I = null;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    public boolean b(h.a.u0.c cVar) {
        if (this.J) {
            return false;
        }
        this.G.offer(this.H, q.disposable(cVar));
        b();
        return true;
    }

    @Override // h.a.u0.c
    public void dispose() {
        if (this.J) {
            return;
        }
        this.J = true;
        a();
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        h.a.u0.c cVar = this.I;
        return cVar != null ? cVar.isDisposed() : this.J;
    }

    public boolean a(T t, h.a.u0.c cVar) {
        if (this.J) {
            return false;
        }
        this.G.offer(cVar, q.next(t));
        b();
        return true;
    }

    void b() {
        if (this.p.getAndIncrement() != 0) {
            return;
        }
        h.a.y0.f.c<Object> cVar = this.G;
        i0<? super T> i0Var = this.F;
        int iAddAndGet = 1;
        while (true) {
            Object objPoll = cVar.poll();
            if (objPoll == null) {
                iAddAndGet = this.p.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                Object objPoll2 = cVar.poll();
                if (objPoll == this.H) {
                    if (q.isDisposable(objPoll2)) {
                        h.a.u0.c disposable = q.getDisposable(objPoll2);
                        this.H.dispose();
                        if (!this.J) {
                            this.H = disposable;
                        } else {
                            disposable.dispose();
                        }
                    } else if (q.isError(objPoll2)) {
                        cVar.clear();
                        a();
                        Throwable error = q.getError(objPoll2);
                        if (!this.J) {
                            this.J = true;
                            i0Var.onError(error);
                        } else {
                            h.a.c1.a.b(error);
                        }
                    } else if (q.isComplete(objPoll2)) {
                        cVar.clear();
                        a();
                        if (!this.J) {
                            this.J = true;
                            i0Var.onComplete();
                        }
                    } else {
                        i0Var.onNext((Object) q.getValue(objPoll2));
                    }
                }
            }
        }
    }

    public void a(Throwable th, h.a.u0.c cVar) {
        if (this.J) {
            h.a.c1.a.b(th);
        } else {
            this.G.offer(cVar, q.error(th));
            b();
        }
    }

    public void a(h.a.u0.c cVar) {
        this.G.offer(cVar, q.complete());
        b();
    }
}
