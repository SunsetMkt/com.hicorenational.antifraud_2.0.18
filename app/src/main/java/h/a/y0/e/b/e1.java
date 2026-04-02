package h.a.y0.e.b;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FlowableFromCallable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e1<T> extends h.a.l<T> implements Callable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends T> f10634b;

    public e1(Callable<? extends T> callable) {
        this.f10634b = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) h.a.y0.b.b.a((Object) this.f10634b.call(), "The callable returned a null value");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        h.a.y0.i.f fVar = new h.a.y0.i.f(cVar);
        cVar.onSubscribe(fVar);
        try {
            fVar.complete(h.a.y0.b.b.a((Object) this.f10634b.call(), "The callable returned a null value"));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            cVar.onError(th);
        }
    }
}
