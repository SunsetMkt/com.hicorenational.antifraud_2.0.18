package h.a.y0.j;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: EndConsumerHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    private i() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean a(h.a.u0.c cVar, h.a.u0.c cVar2, Class<?> cls) {
        h.a.y0.b.b.a(cVar2, "next is null");
        if (cVar == null) {
            return true;
        }
        cVar2.dispose();
        if (cVar == h.a.y0.a.d.DISPOSED) {
            return false;
        }
        a(cls);
        return false;
    }

    public static boolean a(AtomicReference<h.a.u0.c> atomicReference, h.a.u0.c cVar, Class<?> cls) {
        h.a.y0.b.b.a(cVar, "next is null");
        if (atomicReference.compareAndSet(null, cVar)) {
            return true;
        }
        cVar.dispose();
        if (atomicReference.get() == h.a.y0.a.d.DISPOSED) {
            return false;
        }
        a(cls);
        return false;
    }

    public static boolean a(j.d.d dVar, j.d.d dVar2, Class<?> cls) {
        h.a.y0.b.b.a(dVar2, "next is null");
        if (dVar == null) {
            return true;
        }
        dVar2.cancel();
        if (dVar == h.a.y0.i.j.CANCELLED) {
            return false;
        }
        a(cls);
        return false;
    }

    public static boolean a(AtomicReference<j.d.d> atomicReference, j.d.d dVar, Class<?> cls) {
        h.a.y0.b.b.a(dVar, "next is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() == h.a.y0.i.j.CANCELLED) {
            return false;
        }
        a(cls);
        return false;
    }

    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void a(Class<?> cls) {
        h.a.c1.a.b(new h.a.v0.e(a(cls.getName())));
    }
}
