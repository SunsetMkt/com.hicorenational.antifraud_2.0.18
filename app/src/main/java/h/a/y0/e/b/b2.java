package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableMaterialize.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b2<T> extends h.a.y0.e.b.a<T, h.a.a0<T>> {

    /* JADX INFO: compiled from: FlowableMaterialize.java */
    static final class a<T> extends h.a.y0.h.s<T, h.a.a0<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        a(j.d.c<? super h.a.a0<T>> cVar) {
            super(cVar);
        }

        @Override // j.d.c
        public void onComplete() {
            complete(h.a.a0.f());
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            complete(h.a.a0.a(th));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j.d.c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(h.a.a0.a(t));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // h.a.y0.h.s
        public void onDrop(h.a.a0<T> a0Var) {
            if (a0Var.d()) {
                h.a.c1.a.b(a0Var.a());
            }
        }
    }

    public b2(h.a.l<T> lVar) {
        super(lVar);
    }

    @Override // h.a.l
    protected void d(j.d.c<? super h.a.a0<T>> cVar) {
        this.f10561b.a((h.a.q) new a(cVar));
    }
}
