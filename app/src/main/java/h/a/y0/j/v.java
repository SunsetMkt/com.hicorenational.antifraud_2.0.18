package h.a.y0.j;

import h.a.i0;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: QueueDrainHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v {
    static final long a = Long.MIN_VALUE;

    /* JADX INFO: renamed from: b */
    static final long f12045b = Long.MAX_VALUE;

    private v() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> void a(h.a.y0.c.n<T> nVar, j.d.c<? super U> cVar, boolean z, h.a.u0.c cVar2, u<T, U> uVar) {
        int iA = 1;
        while (true) {
            boolean zC = uVar.c();
            T tPoll = nVar.poll();
            boolean z2 = tPoll == null;
            if (a(zC, z2, cVar, z, nVar, uVar)) {
                if (cVar2 != null) {
                    cVar2.dispose();
                    return;
                }
                return;
            } else if (z2) {
                iA = uVar.a(-iA);
                if (iA == 0) {
                    return;
                }
            } else {
                long jRequested = uVar.requested();
                if (jRequested == 0) {
                    nVar.clear();
                    if (cVar2 != null) {
                        cVar2.dispose();
                    }
                    cVar.onError(new h.a.v0.c("Could not emit value due to lack of requests."));
                    return;
                }
                if (uVar.a(cVar, tPoll) && jRequested != Long.MAX_VALUE) {
                    uVar.a(1L);
                }
            }
        }
    }

    public static <T> boolean b(long j2, j.d.c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, h.a.x0.e eVar) {
        long j3;
        do {
            j3 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j3, d.a(Long.MAX_VALUE & j3, j2) | (j3 & Long.MIN_VALUE)));
        if (j3 != Long.MIN_VALUE) {
            return false;
        }
        a(j2 | Long.MIN_VALUE, cVar, queue, atomicLong, eVar);
        return true;
    }

    public static <T, U> boolean a(boolean z, boolean z2, j.d.c<?> cVar, boolean z3, h.a.y0.c.o<?> oVar, u<T, U> uVar) {
        if (uVar.d()) {
            oVar.clear();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            Throwable thA = uVar.a();
            if (thA != null) {
                cVar.onError(thA);
            } else {
                cVar.onComplete();
            }
            return true;
        }
        Throwable thA2 = uVar.a();
        if (thA2 != null) {
            oVar.clear();
            cVar.onError(thA2);
            return true;
        }
        if (!z2) {
            return false;
        }
        cVar.onComplete();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0033, code lost:
    
        r1 = r15.a(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0038, code lost:
    
        if (r1 != 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x003a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T, U> void a(h.a.y0.c.n<T> nVar, i0<? super U> i0Var, boolean z, h.a.u0.c cVar, r<T, U> rVar) {
        int iA = 1;
        while (!a(rVar.c(), nVar.isEmpty(), i0Var, z, nVar, cVar, rVar)) {
            while (true) {
                boolean zC = rVar.c();
                T tPoll = nVar.poll();
                boolean z2 = tPoll == null;
                if (a(zC, z2, i0Var, z, nVar, cVar, rVar)) {
                    return;
                }
                if (z2) {
                    break;
                } else {
                    rVar.a(i0Var, tPoll);
                }
            }
        }
    }

    public static <T, U> boolean a(boolean z, boolean z2, i0<?> i0Var, boolean z3, h.a.y0.c.o<?> oVar, h.a.u0.c cVar, r<T, U> rVar) {
        if (rVar.d()) {
            oVar.clear();
            cVar.dispose();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            cVar.dispose();
            Throwable thA = rVar.a();
            if (thA != null) {
                i0Var.onError(thA);
            } else {
                i0Var.onComplete();
            }
            return true;
        }
        Throwable thA2 = rVar.a();
        if (thA2 != null) {
            oVar.clear();
            cVar.dispose();
            i0Var.onError(thA2);
            return true;
        }
        if (!z2) {
            return false;
        }
        cVar.dispose();
        i0Var.onComplete();
        return true;
    }

    public static <T> h.a.y0.c.o<T> a(int i2) {
        if (i2 < 0) {
            return new h.a.y0.f.c(-i2);
        }
        return new h.a.y0.f.b(i2);
    }

    public static void a(j.d.d dVar, int i2) {
        dVar.request(i2 < 0 ? Long.MAX_VALUE : i2);
    }

    static boolean a(h.a.x0.e eVar) {
        try {
            return eVar.getAsBoolean();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            return true;
        }
    }

    static <T> boolean a(long j2, j.d.c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, h.a.x0.e eVar) {
        long j3 = j2 & Long.MIN_VALUE;
        while (true) {
            if (j3 != j2) {
                if (a(eVar)) {
                    return true;
                }
                T tPoll = queue.poll();
                if (tPoll == null) {
                    cVar.onComplete();
                    return true;
                }
                cVar.onNext(tPoll);
                j3++;
            } else {
                if (a(eVar)) {
                    return true;
                }
                if (queue.isEmpty()) {
                    cVar.onComplete();
                    return true;
                }
                j2 = atomicLong.get();
                if (j2 == j3) {
                    long jAddAndGet = atomicLong.addAndGet(-(j3 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & jAddAndGet) == 0) {
                        return false;
                    }
                    j2 = jAddAndGet;
                    j3 = jAddAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T> void a(j.d.c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, h.a.x0.e eVar) {
        long j2;
        long j3;
        if (queue.isEmpty()) {
            cVar.onComplete();
            return;
        }
        if (a(atomicLong.get(), cVar, queue, atomicLong, eVar)) {
            return;
        }
        do {
            j2 = atomicLong.get();
            if ((j2 & Long.MIN_VALUE) != 0) {
                return;
            } else {
                j3 = j2 | Long.MIN_VALUE;
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        if (j2 != 0) {
            a(j3, cVar, queue, atomicLong, eVar);
        }
    }
}
