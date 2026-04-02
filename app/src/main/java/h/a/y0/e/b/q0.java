package h.a.y0.e.b;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: FlowableElementAt.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q0<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final T f10906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f10907e;

    /* JADX INFO: compiled from: FlowableElementAt.java */
    static final class a<T> extends h.a.y0.i.f<T> implements h.a.q<T> {
        private static final long serialVersionUID = 4066607327284737757L;
        long count;
        final T defaultValue;
        boolean done;
        final boolean errorOnFewer;
        final long index;
        j.d.d s;

        a(j.d.c<? super T> cVar, long j2, T t, boolean z) {
            super(cVar);
            this.index = j2;
            this.defaultValue = t;
            this.errorOnFewer = z;
        }

        @Override // h.a.y0.i.f, j.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            T t = this.defaultValue;
            if (t != null) {
                complete(t);
            } else if (this.errorOnFewer) {
                this.actual.onError(new NoSuchElementException());
            } else {
                this.actual.onComplete();
            }
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
            long j2 = this.count;
            if (j2 != this.index) {
                this.count = j2 + 1;
                return;
            }
            this.done = true;
            this.s.cancel();
            complete(t);
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

    public q0(h.a.l<T> lVar, long j2, T t, boolean z) {
        super(lVar);
        this.f10905c = j2;
        this.f10906d = t;
        this.f10907e = z;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10905c, this.f10906d, this.f10907e));
    }
}
