package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableOnBackpressureError.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h2<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: compiled from: FlowableOnBackpressureError.java */
    static final class a<T> extends AtomicLong implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = -3176480756392482682L;
        final j.d.c<? super T> actual;
        boolean done;
        j.d.d s;

        a(j.d.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // j.d.d
        public void cancel() {
            this.s.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (get() == 0) {
                onError(new h.a.v0.c("could not emit value due to lack of requests"));
            } else {
                this.actual.onNext(t);
                h.a.y0.j.d.c(this, 1L);
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

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this, j2);
            }
        }
    }

    public h2(h.a.l<T> lVar) {
        super(lVar);
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar));
    }
}
