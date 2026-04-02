package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeConcatArrayDelayError.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.y<? extends T>[] f11130b;

    /* JADX INFO: compiled from: MaybeConcatArrayDelayError.java */
    static final class a<T> extends AtomicInteger implements h.a.v<T>, j.d.d {
        private static final long serialVersionUID = 3520831347801429610L;
        final j.d.c<? super T> actual;
        int index;
        long produced;
        final h.a.y<? extends T>[] sources;
        final AtomicLong requested = new AtomicLong();
        final h.a.y0.a.k disposables = new h.a.y0.a.k();
        final AtomicReference<Object> current = new AtomicReference<>(h.a.y0.j.q.COMPLETE);
        final h.a.y0.j.c errors = new h.a.y0.j.c();

        a(j.d.c<? super T> cVar, h.a.y<? extends T>[] yVarArr) {
            this.actual = cVar;
            this.sources = yVarArr;
        }

        @Override // j.d.d
        public void cancel() {
            this.disposables.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<Object> atomicReference = this.current;
            j.d.c<? super T> cVar = this.actual;
            h.a.y0.a.k kVar = this.disposables;
            while (!kVar.isDisposed()) {
                Object obj = atomicReference.get();
                if (obj != null) {
                    boolean z = true;
                    if (obj != h.a.y0.j.q.COMPLETE) {
                        long j2 = this.produced;
                        if (j2 != this.requested.get()) {
                            this.produced = j2 + 1;
                            atomicReference.lazySet(null);
                            cVar.onNext(obj);
                        } else {
                            z = false;
                        }
                    } else {
                        atomicReference.lazySet(null);
                    }
                    if (z && !kVar.isDisposed()) {
                        int i2 = this.index;
                        h.a.y<? extends T>[] yVarArr = this.sources;
                        if (i2 == yVarArr.length) {
                            if (this.errors.get() != null) {
                                cVar.onError(this.errors.terminate());
                                return;
                            } else {
                                cVar.onComplete();
                                return;
                            }
                        }
                        this.index = i2 + 1;
                        yVarArr[i2].a(this);
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // h.a.v
        public void onComplete() {
            this.current.lazySet(h.a.y0.j.q.COMPLETE);
            drain();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.current.lazySet(h.a.y0.j.q.COMPLETE);
            if (this.errors.addThrowable(th)) {
                drain();
            } else {
                h.a.c1.a.b(th);
            }
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            this.disposables.replace(cVar);
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.current.lazySet(t);
            drain();
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }
    }

    public f(h.a.y<? extends T>[] yVarArr) {
        this.f11130b = yVarArr;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        a aVar = new a(cVar, this.f11130b);
        cVar.onSubscribe(aVar);
        aVar.drain();
    }
}
