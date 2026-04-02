package h.a.y0.i;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SubscriptionHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public enum j implements j.d.d {
    CANCELLED;

    public static boolean cancel(AtomicReference<j.d.d> atomicReference) {
        j.d.d andSet;
        j.d.d dVar = atomicReference.get();
        j jVar = CANCELLED;
        if (dVar == jVar || (andSet = atomicReference.getAndSet(jVar)) == CANCELLED) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static void deferredRequest(AtomicReference<j.d.d> atomicReference, AtomicLong atomicLong, long j2) {
        j.d.d dVar = atomicReference.get();
        if (dVar != null) {
            dVar.request(j2);
            return;
        }
        if (validate(j2)) {
            h.a.y0.j.d.a(atomicLong, j2);
            j.d.d dVar2 = atomicReference.get();
            if (dVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    dVar2.request(andSet);
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference<j.d.d> atomicReference, AtomicLong atomicLong, j.d.d dVar) {
        if (!setOnce(atomicReference, dVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        dVar.request(andSet);
        return true;
    }

    public static boolean isCancelled(j.d.d dVar) {
        return dVar == CANCELLED;
    }

    public static boolean replace(AtomicReference<j.d.d> atomicReference, j.d.d dVar) {
        j.d.d dVar2;
        do {
            dVar2 = atomicReference.get();
            if (dVar2 == CANCELLED) {
                if (dVar == null) {
                    return false;
                }
                dVar.cancel();
                return false;
            }
        } while (!atomicReference.compareAndSet(dVar2, dVar));
        return true;
    }

    public static void reportMoreProduced(long j2) {
        h.a.c1.a.b(new h.a.v0.e("More produced than requested: " + j2));
    }

    public static void reportSubscriptionSet() {
        h.a.c1.a.b(new h.a.v0.e("Subscription already set!"));
    }

    public static boolean set(AtomicReference<j.d.d> atomicReference, j.d.d dVar) {
        j.d.d dVar2;
        do {
            dVar2 = atomicReference.get();
            if (dVar2 == CANCELLED) {
                if (dVar == null) {
                    return false;
                }
                dVar.cancel();
                return false;
            }
        } while (!atomicReference.compareAndSet(dVar2, dVar));
        if (dVar2 == null) {
            return true;
        }
        dVar2.cancel();
        return true;
    }

    public static boolean setOnce(AtomicReference<j.d.d> atomicReference, j.d.d dVar) {
        h.a.y0.b.b.a(dVar, "s is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        reportSubscriptionSet();
        return false;
    }

    public static boolean validate(j.d.d dVar, j.d.d dVar2) {
        if (dVar2 == null) {
            h.a.c1.a.b(new NullPointerException("next is null"));
            return false;
        }
        if (dVar == null) {
            return true;
        }
        dVar2.cancel();
        reportSubscriptionSet();
        return false;
    }

    @Override // j.d.d
    public void cancel() {
    }

    @Override // j.d.d
    public void request(long j2) {
    }

    public static boolean validate(long j2) {
        if (j2 > 0) {
            return true;
        }
        h.a.c1.a.b(new IllegalArgumentException("n > 0 required but it was " + j2));
        return false;
    }
}
