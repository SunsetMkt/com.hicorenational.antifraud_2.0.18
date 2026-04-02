package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: FlowableTake.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u3<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f11012c;

    /* JADX INFO: compiled from: FlowableTake.java */
    static final class a<T> extends AtomicBoolean implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = -5636543848937116287L;
        final j.d.c<? super T> actual;
        boolean done;
        final long limit;
        long remaining;
        j.d.d subscription;

        a(j.d.c<? super T> cVar, long j2) {
            this.actual = cVar;
            this.limit = j2;
            this.remaining = j2;
        }

        @Override // j.d.d
        public void cancel() {
            this.subscription.cancel();
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
                return;
            }
            this.done = true;
            this.subscription.cancel();
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.remaining;
            this.remaining = j2 - 1;
            if (j2 > 0) {
                boolean z = this.remaining == 0;
                this.actual.onNext(t);
                if (z) {
                    this.subscription.cancel();
                    onComplete();
                }
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.subscription, dVar)) {
                this.subscription = dVar;
                if (this.limit != 0) {
                    this.actual.onSubscribe(this);
                    return;
                }
                dVar.cancel();
                this.done = true;
                h.a.y0.i.g.complete(this.actual);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                if (get() || !compareAndSet(false, true) || j2 < this.limit) {
                    this.subscription.request(j2);
                } else {
                    this.subscription.request(i.q2.t.m0.f12222b);
                }
            }
        }
    }

    public u3(h.a.l<T> lVar, long j2) {
        super(lVar);
        this.f11012c = j2;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f11012c));
    }
}
