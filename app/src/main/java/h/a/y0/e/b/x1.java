package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableLimit.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.e
public final class x1<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f11043c;

    /* JADX INFO: compiled from: FlowableLimit.java */
    static final class a<T> extends AtomicLong implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = 2288246011222124525L;
        final j.d.c<? super T> actual;
        long remaining;
        j.d.d upstream;

        a(j.d.c<? super T> cVar, long j2) {
            this.actual = cVar;
            this.remaining = j2;
            lazySet(j2);
        }

        @Override // j.d.d
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.remaining > 0) {
                this.remaining = 0L;
                this.actual.onComplete();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.remaining <= 0) {
                h.a.c1.a.b(th);
            } else {
                this.remaining = 0L;
                this.actual.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            long j2 = this.remaining;
            if (j2 > 0) {
                long j3 = j2 - 1;
                this.remaining = j3;
                this.actual.onNext(t);
                if (j3 == 0) {
                    this.upstream.cancel();
                    this.actual.onComplete();
                }
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.upstream, dVar)) {
                if (this.remaining == 0) {
                    dVar.cancel();
                    h.a.y0.i.g.complete(this.actual);
                } else {
                    this.upstream = dVar;
                    this.actual.onSubscribe(this);
                }
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            long j3;
            long j4;
            if (h.a.y0.i.j.validate(j2)) {
                do {
                    j3 = get();
                    if (j3 == 0) {
                        return;
                    } else {
                        j4 = j3 <= j2 ? j3 : j2;
                    }
                } while (!compareAndSet(j3, j3 - j4));
                this.upstream.request(j4);
            }
        }
    }

    public x1(h.a.l<T> lVar, long j2) {
        super(lVar);
        this.f11043c = j2;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f11043c));
    }
}
