package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableFromArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d1<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final T[] f10611b;

    /* JADX INFO: compiled from: FlowableFromArray.java */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final h.a.y0.c.a<? super T> actual;

        a(h.a.y0.c.a<? super T> aVar, T[] tArr) {
            super(tArr);
            this.actual = aVar;
        }

        @Override // h.a.y0.e.b.d1.c
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            h.a.y0.c.a<? super T> aVar = this.actual;
            for (int i2 = this.index; i2 != length; i2++) {
                if (this.cancelled) {
                    return;
                }
                T t = tArr[i2];
                if (t == null) {
                    aVar.onError(new NullPointerException("array element is null"));
                    return;
                }
                aVar.tryOnNext(t);
            }
            if (this.cancelled) {
                return;
            }
            aVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
        
            r10.index = r2;
            r6 = addAndGet(-r11);
         */
        @Override // h.a.y0.e.b.d1.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void slowPath(long j2) {
            T[] tArr = this.array;
            int length = tArr.length;
            int i2 = this.index;
            h.a.y0.c.a<? super T> aVar = this.actual;
            long jAddAndGet = j2;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == jAddAndGet || i2 == length) {
                        if (i2 == length) {
                            if (this.cancelled) {
                                return;
                            }
                            aVar.onComplete();
                            return;
                        } else {
                            jAddAndGet = get();
                            if (j3 == jAddAndGet) {
                                break;
                            }
                        }
                    } else {
                        if (this.cancelled) {
                            return;
                        }
                        T t = tArr[i2];
                        if (t == null) {
                            aVar.onError(new NullPointerException("array element is null"));
                            return;
                        } else {
                            if (aVar.tryOnNext(t)) {
                                j3++;
                            }
                            i2++;
                        }
                    }
                }
            } while (jAddAndGet != 0);
        }
    }

    /* JADX INFO: compiled from: FlowableFromArray.java */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final j.d.c<? super T> actual;

        b(j.d.c<? super T> cVar, T[] tArr) {
            super(tArr);
            this.actual = cVar;
        }

        @Override // h.a.y0.e.b.d1.c
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            j.d.c<? super T> cVar = this.actual;
            for (int i2 = this.index; i2 != length; i2++) {
                if (this.cancelled) {
                    return;
                }
                T t = tArr[i2];
                if (t == null) {
                    cVar.onError(new NullPointerException("array element is null"));
                    return;
                }
                cVar.onNext(t);
            }
            if (this.cancelled) {
                return;
            }
            cVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
        
            r10.index = r2;
            r6 = addAndGet(-r11);
         */
        @Override // h.a.y0.e.b.d1.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void slowPath(long j2) {
            T[] tArr = this.array;
            int length = tArr.length;
            int i2 = this.index;
            j.d.c<? super T> cVar = this.actual;
            long jAddAndGet = j2;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == jAddAndGet || i2 == length) {
                        if (i2 == length) {
                            if (this.cancelled) {
                                return;
                            }
                            cVar.onComplete();
                            return;
                        } else {
                            jAddAndGet = get();
                            if (j3 == jAddAndGet) {
                                break;
                            }
                        }
                    } else {
                        if (this.cancelled) {
                            return;
                        }
                        T t = tArr[i2];
                        if (t == null) {
                            cVar.onError(new NullPointerException("array element is null"));
                            return;
                        } else {
                            cVar.onNext(t);
                            j3++;
                            i2++;
                        }
                    }
                }
            } while (jAddAndGet != 0);
        }
    }

    /* JADX INFO: compiled from: FlowableFromArray.java */
    static abstract class c<T> extends h.a.y0.i.d<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;

        c(T[] tArr) {
            this.array = tArr;
        }

        @Override // j.d.d
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // h.a.y0.c.o
        public final void clear() {
            this.index = this.array.length;
        }

        abstract void fastPath();

        @Override // h.a.y0.c.o
        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public final T poll() {
            int i2 = this.index;
            T[] tArr = this.array;
            if (i2 == tArr.length) {
                return null;
            }
            this.index = i2 + 1;
            return (T) h.a.y0.b.b.a((Object) tArr[i2], "array element is null");
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

    public d1(T[] tArr) {
        this.f10611b = tArr;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        if (cVar instanceof h.a.y0.c.a) {
            cVar.onSubscribe(new a((h.a.y0.c.a) cVar, this.f10611b));
        } else {
            cVar.onSubscribe(new b(cVar, this.f10611b));
        }
    }
}
