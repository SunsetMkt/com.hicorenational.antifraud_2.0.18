package h.a.y0.e.b;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: FlowableFromFuture.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f1<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Future<? extends T> f10649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f10651d;

    public f1(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        this.f10649b = future;
        this.f10650c = j2;
        this.f10651d = timeUnit;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        h.a.y0.i.f fVar = new h.a.y0.i.f(cVar);
        cVar.onSubscribe(fVar);
        try {
            T t = this.f10651d != null ? this.f10649b.get(this.f10650c, this.f10651d) : this.f10649b.get();
            if (t == null) {
                cVar.onError(new NullPointerException("The future returned null"));
            } else {
                fVar.complete(t);
            }
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            if (fVar.isCancelled()) {
                return;
            }
            cVar.onError(th);
        }
    }
}
