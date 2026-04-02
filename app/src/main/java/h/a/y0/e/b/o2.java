package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableRangeLong.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o2 extends h.a.l<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f10853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10854c;

    /* JADX INFO: compiled from: FlowableRangeLong.java */
    static abstract class a extends h.a.y0.i.d<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final long end;
        long index;

        a(long j2, long j3) {
            this.index = j2;
            this.end = j3;
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
        public final Long poll() {
            long j2 = this.index;
            if (j2 == this.end) {
                return null;
            }
            this.index = 1 + j2;
            return Long.valueOf(j2);
        }
    }

    /* JADX INFO: compiled from: FlowableRangeLong.java */
    static final class b extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        final h.a.y0.c.a<? super Long> actual;

        b(h.a.y0.c.a<? super Long> aVar, long j2, long j3) {
            super(j2, j3);
            this.actual = aVar;
        }

        @Override // h.a.y0.e.b.o2.a
        void fastPath() {
            long j2 = this.end;
            h.a.y0.c.a<? super Long> aVar = this.actual;
            for (long j3 = this.index; j3 != j2; j3++) {
                if (this.cancelled) {
                    return;
                }
                aVar.tryOnNext(Long.valueOf(j3));
            }
            if (this.cancelled) {
                return;
            }
            aVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
        
            r12.index = r7;
            r2 = addAndGet(-r13);
         */
        @Override // h.a.y0.e.b.o2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void slowPath(long j2) {
            long j3 = this.end;
            long j4 = this.index;
            h.a.y0.c.a<? super Long> aVar = this.actual;
            long j5 = j4;
            long jAddAndGet = j2;
            do {
                long j6 = 0;
                while (true) {
                    if (j6 == jAddAndGet || j5 == j3) {
                        if (j5 == j3) {
                            if (this.cancelled) {
                                return;
                            }
                            aVar.onComplete();
                            return;
                        } else {
                            jAddAndGet = get();
                            if (j6 == jAddAndGet) {
                                break;
                            }
                        }
                    } else {
                        if (this.cancelled) {
                            return;
                        }
                        if (aVar.tryOnNext(Long.valueOf(j5))) {
                            j6++;
                        }
                        j5++;
                    }
                }
            } while (jAddAndGet != 0);
        }
    }

    /* JADX INFO: compiled from: FlowableRangeLong.java */
    static final class c extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        final j.d.c<? super Long> actual;

        c(j.d.c<? super Long> cVar, long j2, long j3) {
            super(j2, j3);
            this.actual = cVar;
        }

        @Override // h.a.y0.e.b.o2.a
        void fastPath() {
            long j2 = this.end;
            j.d.c<? super Long> cVar = this.actual;
            for (long j3 = this.index; j3 != j2; j3++) {
                if (this.cancelled) {
                    return;
                }
                cVar.onNext(Long.valueOf(j3));
            }
            if (this.cancelled) {
                return;
            }
            cVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
        
            r11.index = r7;
            r2 = addAndGet(-r12);
         */
        @Override // h.a.y0.e.b.o2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void slowPath(long j2) {
            long j3 = this.end;
            long j4 = this.index;
            j.d.c<? super Long> cVar = this.actual;
            long j5 = j4;
            long jAddAndGet = j2;
            do {
                long j6 = 0;
                while (true) {
                    if (j6 == jAddAndGet || j5 == j3) {
                        if (j5 == j3) {
                            if (this.cancelled) {
                                return;
                            }
                            cVar.onComplete();
                            return;
                        } else {
                            jAddAndGet = get();
                            if (j6 == jAddAndGet) {
                                break;
                            }
                        }
                    } else {
                        if (this.cancelled) {
                            return;
                        }
                        cVar.onNext(Long.valueOf(j5));
                        j6++;
                        j5++;
                    }
                }
            } while (jAddAndGet != 0);
        }
    }

    public o2(long j2, long j3) {
        this.f10853b = j2;
        this.f10854c = j2 + j3;
    }

    @Override // h.a.l
    public void d(j.d.c<? super Long> cVar) {
        if (cVar instanceof h.a.y0.c.a) {
            cVar.onSubscribe(new b((h.a.y0.c.a) cVar, this.f10853b, this.f10854c));
        } else {
            cVar.onSubscribe(new c(cVar, this.f10853b, this.f10854c));
        }
    }
}
