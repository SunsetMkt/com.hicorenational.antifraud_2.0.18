package h.a.y0.h;

import i.q2.t.m0;

/* JADX INFO: compiled from: DeferredScalarSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g<T, R> extends h.a.y0.i.f<R> implements h.a.q<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    protected boolean hasValue;
    protected j.d.d s;

    public g(j.d.c<? super R> cVar) {
        super(cVar);
    }

    @Override // h.a.y0.i.f, j.d.d
    public void cancel() {
        super.cancel();
        this.s.cancel();
    }

    public void onComplete() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            this.actual.onComplete();
        }
    }

    public void onError(Throwable th) {
        this.value = null;
        this.actual.onError(th);
    }

    public void onSubscribe(j.d.d dVar) {
        if (h.a.y0.i.j.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(m0.f12222b);
        }
    }
}
