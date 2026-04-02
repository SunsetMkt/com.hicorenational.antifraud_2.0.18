package h.a.y0.e.a;

/* JADX INFO: compiled from: CompletableToObservable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m0<T> extends h.a.b0<T> {
    final h.a.i a;

    /* JADX INFO: compiled from: CompletableToObservable.java */
    static final class a implements h.a.f {
        private final h.a.i0<?> a;

        a(h.a.i0<?> i0Var) {
            this.a = i0Var;
        }

        @Override // h.a.f
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.onSubscribe(cVar);
        }
    }

    public m0(h.a.i iVar) {
        this.a = iVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        this.a.a(new a(i0Var));
    }
}
