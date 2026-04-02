package h.a.y0.e.e;

import h.a.q;
import i.q2.t.m0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ParallelReduceFull.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b */
    final h.a.b1.b<? extends T> f11812b;

    /* JADX INFO: renamed from: c */
    final h.a.x0.c<T, T, T> f11813c;

    /* JADX INFO: compiled from: ParallelReduceFull.java */
    static final class a<T> extends AtomicReference<j.d.d> implements q<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        boolean done;
        final b<T> parent;
        final h.a.x0.c<T, T, T> reducer;
        T value;

        a(b<T> bVar, h.a.x0.c<T, T, T> cVar) {
            this.parent = bVar;
            this.reducer = cVar;
        }

        void cancel() {
            h.a.y0.i.j.cancel(this);
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete(this.value);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
            } else {
                this.done = true;
                this.parent.innerError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            T t2 = this.value;
            if (t2 == null) {
                this.value = t;
                return;
            }
            try {
                this.value = (T) h.a.y0.b.b.a((Object) this.reducer.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                get().cancel();
                onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(m0.f12222b);
            }
        }
    }

    /* JADX INFO: compiled from: ParallelReduceFull.java */
    static final class b<T> extends h.a.y0.i.f<T> {
        private static final long serialVersionUID = -5370107872170712765L;
        final AtomicReference<c<T>> current;
        final AtomicReference<Throwable> error;
        final h.a.x0.c<T, T, T> reducer;
        final AtomicInteger remaining;
        final a<T>[] subscribers;

        b(j.d.c<? super T> cVar, int i2, h.a.x0.c<T, T, T> cVar2) {
            super(cVar);
            this.current = new AtomicReference<>();
            this.remaining = new AtomicInteger();
            this.error = new AtomicReference<>();
            a<T>[] aVarArr = new a[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                aVarArr[i3] = new a<>(this, cVar2);
            }
            this.subscribers = aVarArr;
            this.reducer = cVar2;
            this.remaining.lazySet(i2);
        }

        c<T> addValue(T t) {
            c<T> cVar;
            int iTryAcquireSlot;
            while (true) {
                cVar = this.current.get();
                if (cVar == null) {
                    cVar = new c<>();
                    if (!this.current.compareAndSet(null, cVar)) {
                        continue;
                    }
                }
                iTryAcquireSlot = cVar.tryAcquireSlot();
                if (iTryAcquireSlot >= 0) {
                    break;
                }
                this.current.compareAndSet(cVar, null);
            }
            if (iTryAcquireSlot == 0) {
                cVar.first = t;
            } else {
                cVar.second = t;
            }
            if (!cVar.releaseSlot()) {
                return null;
            }
            this.current.compareAndSet(cVar, null);
            return cVar;
        }

        @Override // h.a.y0.i.f, j.d.d
        public void cancel() {
            for (a<T> aVar : this.subscribers) {
                aVar.cancel();
            }
        }

        void innerComplete(T t) {
            if (t != null) {
                while (true) {
                    c<T> cVarAddValue = addValue(t);
                    if (cVarAddValue == null) {
                        break;
                    }
                    try {
                        t = (T) h.a.y0.b.b.a((Object) this.reducer.apply(cVarAddValue.first, cVarAddValue.second), "The reducer returned a null value");
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        innerError(th);
                        return;
                    }
                }
            }
            if (this.remaining.decrementAndGet() == 0) {
                c<T> cVar = this.current.get();
                this.current.lazySet(null);
                if (cVar != null) {
                    complete(cVar.first);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        void innerError(Throwable th) {
            if (this.error.compareAndSet(null, th)) {
                cancel();
                this.actual.onError(th);
            } else if (th != this.error.get()) {
                h.a.c1.a.b(th);
            }
        }
    }

    /* JADX INFO: compiled from: ParallelReduceFull.java */
    static final class c<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        T first;
        final AtomicInteger releaseIndex = new AtomicInteger();
        T second;

        c() {
        }

        boolean releaseSlot() {
            return this.releaseIndex.incrementAndGet() == 2;
        }

        int tryAcquireSlot() {
            int i2;
            do {
                i2 = get();
                if (i2 >= 2) {
                    return -1;
                }
            } while (!compareAndSet(i2, i2 + 1));
            return i2;
        }
    }

    public n(h.a.b1.b<? extends T> bVar, h.a.x0.c<T, T, T> cVar) {
        this.f11812b = bVar;
        this.f11813c = cVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        b bVar = new b(cVar, this.f11812b.a(), this.f11813c);
        cVar.onSubscribe(bVar);
        this.f11812b.a(bVar.subscribers);
    }
}
