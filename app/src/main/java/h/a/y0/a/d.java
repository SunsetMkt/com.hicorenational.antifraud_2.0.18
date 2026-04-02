package h.a.y0.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: DisposableHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public enum d implements h.a.u0.c {
    DISPOSED;

    public static boolean dispose(AtomicReference<h.a.u0.c> atomicReference) {
        h.a.u0.c andSet;
        h.a.u0.c cVar = atomicReference.get();
        d dVar = DISPOSED;
        if (cVar == dVar || (andSet = atomicReference.getAndSet(dVar)) == dVar) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean isDisposed(h.a.u0.c cVar) {
        return cVar == DISPOSED;
    }

    public static boolean replace(AtomicReference<h.a.u0.c> atomicReference, h.a.u0.c cVar) {
        h.a.u0.c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar == null) {
                    return false;
                }
                cVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        return true;
    }

    public static void reportDisposableSet() {
        h.a.c1.a.b(new h.a.v0.e("Disposable already set!"));
    }

    public static boolean set(AtomicReference<h.a.u0.c> atomicReference, h.a.u0.c cVar) {
        h.a.u0.c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar == null) {
                    return false;
                }
                cVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        if (cVar2 == null) {
            return true;
        }
        cVar2.dispose();
        return true;
    }

    public static boolean setOnce(AtomicReference<h.a.u0.c> atomicReference, h.a.u0.c cVar) {
        h.a.y0.b.b.a(cVar, "d is null");
        if (atomicReference.compareAndSet(null, cVar)) {
            return true;
        }
        cVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        reportDisposableSet();
        return false;
    }

    public static boolean trySet(AtomicReference<h.a.u0.c> atomicReference, h.a.u0.c cVar) {
        if (atomicReference.compareAndSet(null, cVar)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        cVar.dispose();
        return false;
    }

    public static boolean validate(h.a.u0.c cVar, h.a.u0.c cVar2) {
        if (cVar2 == null) {
            h.a.c1.a.b(new NullPointerException("next is null"));
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar2.dispose();
        reportDisposableSet();
        return false;
    }

    @Override // h.a.u0.c
    public void dispose() {
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return true;
    }
}
