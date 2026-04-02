package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableRange.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n2 extends h.a.l<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f10824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f10825c;

    /* JADX INFO: compiled from: FlowableRange.java */
    static abstract class a extends h.a.y0.i.d<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final int end;
        int index;

        a(int i2, int i3) {
            this.index = i2;
            this.end = i3;
        }

        @Override // j.d.d
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // h.a.y0.c.o
        public final void clear() {
            this.index = this.end;
        }

        abstract void fastPath();

        @Override // h.a.y0.c.o
        public final boolean isEmpty() {
            return this.index == this.end;
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

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public final Integer poll() {
            int i2 = this.index;
            if (i2 == this.end) {
                return null;
            }
            this.index = i2 + 1;
            return Integer.valueOf(i2);
        }
    }

    /* JADX INFO: compiled from: FlowableRange.java */
    static final class b extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        final h.a.y0.c.a<? super Integer> actual;

        b(h.a.y0.c.a<? super Integer> aVar, int i2, int i3) {
            super(i2, i3);
            this.actual = aVar;
        }

        @Override // h.a.y0.e.b.n2.a
        void fastPath() {
            int i2 = this.end;
            h.a.y0.c.a<? super Integer> aVar = this.actual;
            for (int i3 = this.index; i3 != i2; i3++) {
                if (this.cancelled) {
                    return;
                }
                aVar.tryOnNext(Integer.valueOf(i3));
            }
            if (this.cancelled) {
                return;
            }
            aVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
        
            r9.index = r1;
            r5 = addAndGet(-r10);
         */
        @Override // h.a.y0.e.b.n2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void slowPath(long j2) {
            int i2 = this.end;
            int i3 = this.index;
            h.a.y0.c.a<? super Integer> aVar = this.actual;
            long jAddAndGet = j2;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == jAddAndGet || i3 == i2) {
                        if (i3 == i2) {
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
                        if (aVar.tryOnNext(Integer.valueOf(i3))) {
                            j3++;
                        }
                        i3++;
                    }
                }
            } while (jAddAndGet != 0);
        }
    }

    /* JADX INFO: compiled from: FlowableRange.java */
    static final class c extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        final j.d.c<? super Integer> actual;

        c(j.d.c<? super Integer> cVar, int i2, int i3) {
            super(i2, i3);
            this.actual = cVar;
        }

        @Override // h.a.y0.e.b.n2.a
        void fastPath() {
            int i2 = this.end;
            j.d.c<? super Integer> cVar = this.actual;
            for (int i3 = this.index; i3 != i2; i3++) {
                if (this.cancelled) {
                    return;
                }
                cVar.onNext(Integer.valueOf(i3));
            }
            if (this.cancelled) {
                return;
            }
            cVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
        
            r9.index = r1;
            r5 = addAndGet(-r10);
         */
        @Override // h.a.y0.e.b.n2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void slowPath(long j2) {
            int i2 = this.end;
            int i3 = this.index;
            j.d.c<? super Integer> cVar = this.actual;
            long jAddAndGet = j2;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == jAddAndGet || i3 == i2) {
                        if (i3 == i2) {
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
                        cVar.onNext(Integer.valueOf(i3));
                        j3++;
                        i3++;
                    }
                }
            } while (jAddAndGet != 0);
        }
    }

    public n2(int i2, int i3) {
        this.f10824b = i2;
        this.f10825c = i2 + i3;
    }

    @Override // h.a.l
    public void d(j.d.c<? super Integer> cVar) {
        if (cVar instanceof h.a.y0.c.a) {
            cVar.onSubscribe(new b((h.a.y0.c.a) cVar, this.f10824b, this.f10825c));
        } else {
            cVar.onSubscribe(new c(cVar, this.f10824b, this.f10825c));
        }
    }
}
