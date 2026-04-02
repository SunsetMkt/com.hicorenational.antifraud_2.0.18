package i.k2.n.a;

import i.q0;
import i.r0;
import i.y1;

/* JADX INFO: compiled from: RunSuspend.kt */
/* JADX INFO: loaded from: classes2.dex */
final class l implements i.k2.d<y1> {

    @j.c.a.e
    private q0<y1> a;

    public final void a(@j.c.a.e q0<y1> q0Var) {
        this.a = q0Var;
    }

    @j.c.a.e
    public final q0<y1> b() {
        return this.a;
    }

    @Override // i.k2.d
    @j.c.a.d
    public i.k2.g getContext() {
        return i.k2.i.INSTANCE;
    }

    @Override // i.k2.d
    public void resumeWith(@j.c.a.d Object obj) {
        synchronized (this) {
            this.a = q0.m771boximpl(obj);
            notifyAll();
            y1 y1Var = y1.a;
        }
    }

    public final void a() {
        synchronized (this) {
            while (true) {
                q0<y1> q0Var = this.a;
                if (q0Var == null) {
                    wait();
                } else {
                    r0.b(q0Var.m780unboximpl());
                }
            }
        }
    }
}
