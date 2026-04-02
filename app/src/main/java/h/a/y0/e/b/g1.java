package h.a.y0.e.b;

import java.util.Iterator;

/* JADX INFO: compiled from: FlowableFromIterable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g1<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable<? extends T> f10678b;

    /* JADX INFO: compiled from: FlowableFromIterable.java */
    static abstract class a<T> extends h.a.y0.i.d<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> it;
        boolean once;

        a(Iterator<? extends T> it) {
            this.it = it;
        }

        @Override // j.d.d
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // h.a.y0.c.o
        public final void clear() {
            this.it = null;
        }

        abstract void fastPath();

        @Override // h.a.y0.c.o
        public final boolean isEmpty() {
            Iterator<? extends T> it = this.it;
            return it == null || !it.hasNext();
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public final T poll() {
            Iterator<? extends T> it = this.it;
            if (it == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!it.hasNext()) {
                return null;
            }
            return (T) h.a.y0.b.b.a((Object) this.it.next(), "Iterator.next() returned a null value");
        }

        @Override // j.d.d
        public final void request(long j2) {
            if (h.a.y0.i.j.validate(j2) && h.a.y0.j.d.a(this, j2) == 0) {
                if (j2 == i.q2.t.m0.f12222b) {
                    fastPath();
                } else {
                    slowPath(j2);
                }
            }
        }

        @Override // h.a.y0.c.k
        public final int requestFusion(int i2) {
            return i2 & 1;
        }

        abstract void slowPath(long j2);
    }

    /* JADX INFO: compiled from: FlowableFromIterable.java */
    static final class b<T> extends a<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final h.a.y0.c.a<? super T> actual;

        b(h.a.y0.c.a<? super T> aVar, Iterator<? extends T> it) {
            super(it);
            this.actual = aVar;
        }

        @Override // h.a.y0.e.b.g1.a
        void fastPath() {
            Iterator<? extends T> it = this.it;
            h.a.y0.c.a<? super T> aVar = this.actual;
            while (!this.cancelled) {
                try {
                    T next = it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    aVar.tryOnNext(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            aVar.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        aVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    aVar.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
        
            r4 = addAndGet(-r9);
         */
        @Override // h.a.y0.e.b.g1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void slowPath(long j2) {
            Iterator<? extends T> it = this.it;
            h.a.y0.c.a<? super T> aVar = this.actual;
            long jAddAndGet = j2;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == jAddAndGet) {
                        jAddAndGet = get();
                        if (j3 == jAddAndGet) {
                            break;
                        }
                    } else {
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            T next = it.next();
                            if (this.cancelled) {
                                return;
                            }
                            if (next == null) {
                                aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                                return;
                            }
                            boolean zTryOnNext = aVar.tryOnNext(next);
                            if (this.cancelled) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (this.cancelled) {
                                        return;
                                    }
                                    aVar.onComplete();
                                    return;
                                } else if (zTryOnNext) {
                                    j3++;
                                }
                            } catch (Throwable th) {
                                h.a.v0.b.b(th);
                                aVar.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            h.a.v0.b.b(th2);
                            aVar.onError(th2);
                            return;
                        }
                    }
                }
            } while (jAddAndGet != 0);
        }
    }

    /* JADX INFO: compiled from: FlowableFromIterable.java */
    static final class c<T> extends a<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final j.d.c<? super T> actual;

        c(j.d.c<? super T> cVar, Iterator<? extends T> it) {
            super(it);
            this.actual = cVar;
        }

        @Override // h.a.y0.e.b.g1.a
        void fastPath() {
            Iterator<? extends T> it = this.it;
            j.d.c<? super T> cVar = this.actual;
            while (!this.cancelled) {
                try {
                    T next = it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    cVar.onNext(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            cVar.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        cVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    cVar.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
        
            r4 = addAndGet(-r9);
         */
        @Override // h.a.y0.e.b.g1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void slowPath(long j2) {
            Iterator<? extends T> it = this.it;
            j.d.c<? super T> cVar = this.actual;
            long jAddAndGet = j2;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == jAddAndGet) {
                        jAddAndGet = get();
                        if (j3 == jAddAndGet) {
                            break;
                        }
                    } else {
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            T next = it.next();
                            if (this.cancelled) {
                                return;
                            }
                            if (next == null) {
                                cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                                return;
                            }
                            cVar.onNext(next);
                            if (this.cancelled) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (this.cancelled) {
                                        return;
                                    }
                                    cVar.onComplete();
                                    return;
                                }
                                j3++;
                            } catch (Throwable th) {
                                h.a.v0.b.b(th);
                                cVar.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            h.a.v0.b.b(th2);
                            cVar.onError(th2);
                            return;
                        }
                    }
                }
            } while (jAddAndGet != 0);
        }
    }

    public g1(Iterable<? extends T> iterable) {
        this.f10678b = iterable;
    }

    public static <T> void a(j.d.c<? super T> cVar, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                h.a.y0.i.g.complete(cVar);
            } else if (cVar instanceof h.a.y0.c.a) {
                cVar.onSubscribe(new b((h.a.y0.c.a) cVar, it));
            } else {
                cVar.onSubscribe(new c(cVar, it));
            }
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.i.g.error(th, cVar);
        }
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        try {
            a((j.d.c) cVar, (Iterator) this.f10678b.iterator());
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.i.g.error(th, cVar);
        }
    }
}
