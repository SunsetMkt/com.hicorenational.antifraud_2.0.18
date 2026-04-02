package h.a.y0.e.d;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ObservableFromFuture.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c1<T> extends h.a.b0<T> {
    final Future<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f11269c;

    public c1(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        this.a = future;
        this.f11268b = j2;
        this.f11269c = timeUnit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        h.a.y0.d.l lVar = new h.a.y0.d.l(i0Var);
        i0Var.onSubscribe(lVar);
        if (lVar.isDisposed()) {
            return;
        }
        try {
            lVar.complete(h.a.y0.b.b.a((Object) (this.f11269c != null ? this.a.get(this.f11268b, this.f11269c) : this.a.get()), "Future returned null"));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            if (lVar.isDisposed()) {
                return;
            }
            i0Var.onError(th);
        }
    }
}
