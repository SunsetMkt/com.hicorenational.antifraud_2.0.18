package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableOnBackpressureLatest.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i2<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: compiled from: FlowableOnBackpressureLatest.java */
    static final class a<T> extends AtomicInteger implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = 163080509307634843L;
        final j.d.c<? super T> actual;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        j.d.d s;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<T> current = new AtomicReference<>();

        a(j.d.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // j.d.d
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

        boolean checkTerminated(boolean z, boolean z2, j.d.c<?> cVar, AtomicReference<T> atomicReference) {
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

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
        
            if (r7 != r1.get()) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
        
            r9 = r13.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
        
            if (r2.get() != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
        
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
        
            if (checkTerminated(r9, r11, r0, r2) == false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
        
            if (r7 == 0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
        
            h.a.y0.j.d.c(r1, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        
            r4 = addAndGet(-r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            j.d.c<? super T> cVar = this.actual;
            AtomicLong atomicLong = this.requested;
            AtomicReference<T> atomicReference = this.current;
            int iAddAndGet = 1;
            do {
                long j2 = 0;
                while (true) {
                    boolean z = false;
                    if (j2 == atomicLong.get()) {
                        break;
                    }
                    boolean z2 = this.done;
                    T andSet = atomicReference.getAndSet(null);
                    boolean z3 = andSet == null;
                    if (checkTerminated(z2, z3, cVar, atomicReference)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    cVar.onNext(andSet);
                    j2++;
                }
            } while (iAddAndGet != 0);
        }

        @Override // j.d.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.current.lazySet(t);
            drain();
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
                h.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }
    }

    public i2(h.a.l<T> lVar) {
        super(lVar);
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar));
    }
}
