package h.a.y0.e.b;

import h.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableThrottleFirstTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c4<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f10600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.j0 f10601e;

    /* JADX INFO: compiled from: FlowableThrottleFirstTimed.java */
    static final class a<T> extends AtomicLong implements h.a.q<T>, j.d.d, Runnable {
        private static final long serialVersionUID = -9102637559663639004L;
        final j.d.c<? super T> actual;
        boolean done;
        volatile boolean gate;
        j.d.d s;
        final long timeout;
        final h.a.y0.a.k timer = new h.a.y0.a.k();
        final TimeUnit unit;
        final j0.c worker;

        a(j.d.c<? super T> cVar, long j2, TimeUnit timeUnit, j0.c cVar2) {
            this.actual = cVar;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar2;
        }

        @Override // j.d.d
        public void cancel() {
            this.s.cancel();
            this.worker.dispose();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.done || this.gate) {
                return;
            }
            this.gate = true;
            if (get() == 0) {
                this.done = true;
                cancel();
                this.actual.onError(new h.a.v0.c("Could not deliver value due to lack of requests"));
            } else {
                this.actual.onNext(t);
                h.a.y0.j.d.c(this, 1L);
                h.a.u0.c cVar = this.timer.get();
                if (cVar != null) {
                    cVar.dispose();
                }
                this.timer.replace(this.worker.a(this, this.timeout, this.unit));
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

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }
    }

    public c4(h.a.l<T> lVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
        super(lVar);
        this.f10599c = j2;
        this.f10600d = timeUnit;
        this.f10601e = j0Var;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(new h.a.g1.e(cVar), this.f10599c, this.f10600d, this.f10601e.a()));
    }
}
