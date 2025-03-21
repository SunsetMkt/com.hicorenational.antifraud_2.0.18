package g.a.y0.e.a;

import java.util.concurrent.Callable;

/* compiled from: CompletableFromCallable.java */
/* loaded from: classes2.dex */
public final class q extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final Callable<?> f14091a;

    public q(Callable<?> callable) {
        this.f14091a = callable;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        g.a.u0.c b2 = g.a.u0.d.b();
        fVar.onSubscribe(b2);
        try {
            this.f14091a.call();
            if (b2.isDisposed()) {
                return;
            }
            fVar.onComplete();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            if (b2.isDisposed()) {
                return;
            }
            fVar.onError(th);
        }
    }
}
