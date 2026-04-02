package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: FlowableUnsubscribeOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j4<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.j0 f10726c;

    /* JADX INFO: compiled from: FlowableUnsubscribeOn.java */
    static final class a<T> extends AtomicBoolean implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = 1015244841293359600L;
        final j.d.c<? super T> actual;
        j.d.d s;
        final h.a.j0 scheduler;

        /* JADX INFO: renamed from: h.a.y0.e.b.j4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FlowableUnsubscribeOn.java */
        final class RunnableC0193a implements Runnable {
            RunnableC0193a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.s.cancel();
            }
        }

        a(j.d.c<? super T> cVar, h.a.j0 j0Var) {
            this.actual = cVar;
            this.scheduler = j0Var;
        }

        @Override // j.d.d
        public void cancel() {
            if (compareAndSet(false, true)) {
                this.scheduler.a(new RunnableC0193a());
            }
        }

        @Override // j.d.c
        public void onComplete() {
            if (get()) {
                return;
            }
            this.actual.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (get()) {
                h.a.c1.a.b(th);
            } else {
                this.actual.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.actual.onNext(t);
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

    public j4(h.a.l<T> lVar, h.a.j0 j0Var) {
        super(lVar);
        this.f10726c = j0Var;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10726c));
    }
}
