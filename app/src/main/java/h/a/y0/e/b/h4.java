package h.a.y0.e.b;

import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FlowableToList.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h4<T, U extends Collection<? super T>> extends h.a.y0.e.b.a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable<U> f10702c;

    /* JADX INFO: compiled from: FlowableToList.java */
    static final class a<T, U extends Collection<? super T>> extends h.a.y0.i.f<U> implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = -8134157938864266736L;
        j.d.d s;

        /* JADX WARN: Multi-variable type inference failed */
        a(j.d.c<? super U> cVar, U u) {
            super(cVar);
            this.value = u;
        }

        @Override // h.a.y0.i.f, j.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            complete(this.value);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.value = null;
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            Collection collection = (Collection) this.value;
            if (collection != null) {
                collection.add(t);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public h4(h.a.l<T> lVar, Callable<U> callable) {
        super(lVar);
        this.f10702c = callable;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super U> cVar) {
        try {
            this.f10561b.a((h.a.q) new a(cVar, (Collection) h.a.y0.b.b.a(this.f10702c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.i.g.error(th, cVar);
        }
    }
}
