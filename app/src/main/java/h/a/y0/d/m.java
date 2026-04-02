package h.a.y0.d;

import h.a.i0;

/* JADX INFO: compiled from: DeferredScalarObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m<T, R> extends l<R> implements i0<T> {
    private static final long serialVersionUID = -266195175408988651L;
    protected h.a.u0.c s;

    public m(i0<? super R> i0Var) {
        super(i0Var);
    }

    @Override // h.a.y0.d.l, h.a.u0.c
    public void dispose() {
        super.dispose();
        this.s.dispose();
    }

    @Override // h.a.i0
    public void onComplete() {
        T t = this.value;
        if (t == null) {
            complete();
        } else {
            this.value = null;
            complete(t);
        }
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        this.value = null;
        error(th);
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        if (h.a.y0.a.d.validate(this.s, cVar)) {
            this.s = cVar;
            this.actual.onSubscribe(this);
        }
    }
}
