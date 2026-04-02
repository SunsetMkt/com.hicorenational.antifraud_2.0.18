package h.a.y0.e.b;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: FlowableSkipLast.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n3<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f10826c;

    /* JADX INFO: compiled from: FlowableSkipLast.java */
    static final class a<T> extends ArrayDeque<T> implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = -3807491841935125653L;
        final j.d.c<? super T> actual;
        j.d.d s;
        final int skip;

        a(j.d.c<? super T> cVar, int i2) {
            super(i2);
            this.actual = cVar;
            this.skip = i2;
        }

        @Override // j.d.d
        public void cancel() {
            this.s.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.skip == size()) {
                this.actual.onNext(poll());
            } else {
                this.s.request(1L);
            }
            offer(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.s.request(j2);
        }
    }

    public n3(h.a.l<T> lVar, int i2) {
        super(lVar);
        this.f10826c = i2;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10826c));
    }
}
