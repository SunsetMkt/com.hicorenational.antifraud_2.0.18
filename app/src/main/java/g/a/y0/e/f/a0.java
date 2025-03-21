package g.a.y0.e.f;

import java.util.concurrent.Callable;

/* compiled from: SingleFromCallable.java */
/* loaded from: classes2.dex */
public final class a0<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends T> f15726a;

    public a0(Callable<? extends T> callable) {
        this.f15726a = callable;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        g.a.u0.c b2 = g.a.u0.d.b();
        n0Var.onSubscribe(b2);
        if (b2.isDisposed()) {
            return;
        }
        try {
            a.a.a aVar = (Object) g.a.y0.b.b.a((Object) this.f15726a.call(), "The callable returned a null value");
            if (b2.isDisposed()) {
                return;
            }
            n0Var.onSuccess(aVar);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            if (b2.isDisposed()) {
                g.a.c1.a.b(th);
            } else {
                n0Var.onError(th);
            }
        }
    }
}
