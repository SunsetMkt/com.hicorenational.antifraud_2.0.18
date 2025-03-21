package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableOnBackpressureLatest.java */
/* loaded from: classes2.dex */
public final class i2<T> extends g.a.y0.e.b.a<T, T> {

    /* compiled from: FlowableOnBackpressureLatest.java */
    static final class a<T> extends AtomicInteger implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = 163080509307634843L;
        final i.d.c<? super T> actual;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        i.d.d s;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<T> current = new AtomicReference<>();

        a(i.d.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // i.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.current.lazySet(null);
            }
        }

        boolean checkTerminated(boolean z, boolean z2, i.d.c<?> cVar, AtomicReference<T> atomicReference) {
            if (this.cancelled) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                atomicReference.lazySet(null);
                cVar.onError(th);
                return true;
            }
            if (!z2) {
                return false;
            }
            cVar.onComplete();
            return true;
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            i.d.c<? super T> cVar = this.actual;
            AtomicLong atomicLong = this.requested;
            AtomicReference<T> atomicReference = this.current;
            int i2 = 1;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == atomicLong.get()) {
                        break;
                    }
                    boolean z = this.done;
                    T andSet = atomicReference.getAndSet(null);
                    boolean z2 = andSet == null;
                    if (checkTerminated(z, z2, cVar, atomicReference)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    cVar.onNext(andSet);
                    j2++;
                }
                if (j2 == atomicLong.get()) {
                    if (checkTerminated(this.done, atomicReference.get() == null, cVar, atomicReference)) {
                        return;
                    }
                }
                if (j2 != 0) {
                    g.a.y0.j.d.c(atomicLong, j2);
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // i.d.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.current.lazySet(t);
            drain();
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }
    }

    public i2(g.a.l<T> lVar) {
        super(lVar);
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar));
    }
}
