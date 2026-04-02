package h.a.y0.e.b;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FlowableScalarXMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d3 {

    /* JADX INFO: compiled from: FlowableScalarXMap.java */
    static final class a<T, R> extends h.a.l<R> {

        /* JADX INFO: renamed from: b */
        final T f10615b;

        /* JADX INFO: renamed from: c */
        final h.a.x0.o<? super T, ? extends j.d.b<? extends R>> f10616c;

        a(T t, h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar) {
            this.f10615b = t;
            this.f10616c = oVar;
        }

        @Override // h.a.l
        public void d(j.d.c<? super R> cVar) {
            try {
                j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.f10616c.apply(this.f10615b), "The mapper returned a null Publisher");
                if (!(bVar instanceof Callable)) {
                    bVar.subscribe(cVar);
                    return;
                }
                try {
                    Object objCall = ((Callable) bVar).call();
                    if (objCall == null) {
                        h.a.y0.i.g.complete(cVar);
                    } else {
                        cVar.onSubscribe(new h.a.y0.i.h(cVar, objCall));
                    }
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    h.a.y0.i.g.error(th, cVar);
                }
            } catch (Throwable th2) {
                h.a.y0.i.g.error(th2, cVar);
            }
        }
    }

    private d3() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> boolean a(j.d.b<T> bVar, j.d.c<? super R> cVar, h.a.x0.o<? super T, ? extends j.d.b<? extends R>> oVar) {
        if (!(bVar instanceof Callable)) {
            return false;
        }
        try {
            defpackage.a aVar = (Object) ((Callable) bVar).call();
            if (aVar == null) {
                h.a.y0.i.g.complete(cVar);
                return true;
            }
            try {
                j.d.b bVar2 = (j.d.b) h.a.y0.b.b.a(oVar.apply(aVar), "The mapper returned a null Publisher");
                if (bVar2 instanceof Callable) {
                    try {
                        Object objCall = ((Callable) bVar2).call();
                        if (objCall == null) {
                            h.a.y0.i.g.complete(cVar);
                            return true;
                        }
                        cVar.onSubscribe(new h.a.y0.i.h(cVar, objCall));
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        h.a.y0.i.g.error(th, cVar);
                        return true;
                    }
                } else {
                    bVar2.subscribe(cVar);
                }
                return true;
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                h.a.y0.i.g.error(th2, cVar);
                return true;
            }
        } catch (Throwable th3) {
            h.a.v0.b.b(th3);
            h.a.y0.i.g.error(th3, cVar);
            return true;
        }
    }

    public static <T, U> h.a.l<U> a(T t, h.a.x0.o<? super T, ? extends j.d.b<? extends U>> oVar) {
        return h.a.c1.a.a(new a(t, oVar));
    }
}
