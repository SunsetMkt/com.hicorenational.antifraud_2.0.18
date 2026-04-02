package h.a.y0.e.c;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: MaybeFromFuture.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k0<T> extends h.a.s<T> {
    final Future<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f11150c;

    public k0(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        this.a = future;
        this.f11149b = j2;
        this.f11150c = timeUnit;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        h.a.u0.c cVarB = h.a.u0.d.b();
        vVar.onSubscribe(cVarB);
        if (cVarB.isDisposed()) {
            return;
        }
        try {
            T t = this.f11149b <= 0 ? this.a.get() : this.a.get(this.f11149b, this.f11150c);
            if (cVarB.isDisposed()) {
                return;
            }
            if (t == null) {
                vVar.onComplete();
            } else {
                vVar.onSuccess(t);
            }
        } catch (InterruptedException e2) {
            if (cVarB.isDisposed()) {
                return;
            }
            vVar.onError(e2);
        } catch (ExecutionException e3) {
            if (cVarB.isDisposed()) {
                return;
            }
            vVar.onError(e3.getCause());
        } catch (TimeoutException e4) {
            if (cVarB.isDisposed()) {
                return;
            }
            vVar.onError(e4);
        }
    }
}
