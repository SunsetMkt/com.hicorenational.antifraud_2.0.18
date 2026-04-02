package h.a.y0.e.b;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FlowableDefer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f0<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends j.d.b<? extends T>> f10648b;

    public f0(Callable<? extends j.d.b<? extends T>> callable) {
        this.f10648b = callable;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        try {
            ((j.d.b) h.a.y0.b.b.a(this.f10648b.call(), "The publisher supplied is null")).subscribe(cVar);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.i.g.error(th, cVar);
        }
    }
}
