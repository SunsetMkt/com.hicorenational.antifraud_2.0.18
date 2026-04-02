package h.a.v0;

import h.a.y0.j.k;

/* JADX INFO: compiled from: Exceptions.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private b() {
        throw new IllegalStateException("No instances!");
    }

    @h.a.t0.f
    public static RuntimeException a(@h.a.t0.f Throwable th) {
        throw k.c(th);
    }

    public static void b(@h.a.t0.f Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
