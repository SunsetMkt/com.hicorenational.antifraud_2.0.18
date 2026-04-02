package h.a.y0.e.b;

import h.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableDebounceTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e0<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f10632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.j0 f10633e;

    /* JADX INFO: compiled from: FlowableDebounceTimed.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements Runnable, h.a.u0.c {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final b<T> parent;
        final T value;

        a(T t, long j2, b<T> bVar) {
            this.value = t;
            this.idx = j2;
            this.parent = bVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        void emit() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.emit(this.idx, this.value, this);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get() == h.a.y0.a.d.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }

        public void setResource(h.a.u0.c cVar) {
            h.a.y0.a.d.replace(this, cVar);
        }
    }

    /* JADX INFO: compiled from: FlowableDebounceTimed.java */
    static final class b<T> extends AtomicLong implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = -9102637559663639004L;
        final j.d.c<? super T> actual;
        boolean done;
        volatile long index;
        j.d.d s;
        final long timeout;
        final h.a.y0.a.k timer = new h.a.y0.a.k();
        final TimeUnit unit;
        final j0.c worker;

        b(j.d.c<? super T> cVar, long j2, TimeUnit timeUnit, j0.c cVar2) {
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

        void emit(long j2, T t, a<T> aVar) {
            if (j2 == this.index) {
                if (get() == 0) {
                    cancel();
                    this.actual.onError(new h.a.v0.c("Could not deliver value due to lack of requests"));
                } else {
                    this.actual.onNext(t);
                    h.a.y0.j.d.c(this, 1L);
                    aVar.dispose();
                }
            }
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            h.a.u0.c cVar = this.timer.get();
            if (h.a.y0.a.d.isDisposed(cVar)) {
                return;
            }
            a aVar = (a) cVar;
            if (aVar != null) {
                aVar.emit();
            }
            h.a.y0.a.d.dispose(this.timer);
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
            if (this.done) {
                return;
            }
            long j2 = this.index + 1;
            this.index = j2;
            h.a.u0.c cVar = this.timer.get();
            if (cVar != null) {
                cVar.dispose();
            }
            a aVar = new a(t, j2, this);
            if (this.timer.replace(aVar)) {
                aVar.setResource(this.worker.a(aVar, this.timeout, this.unit));
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

    public e0(h.a.l<T> lVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
        super(lVar);
        this.f10631c = j2;
        this.f10632d = timeUnit;
        this.f10633e = j0Var;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new b(new h.a.g1.e(cVar), this.f10631c, this.f10632d, this.f10633e.a()));
    }
}
