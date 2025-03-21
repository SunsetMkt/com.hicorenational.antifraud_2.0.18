package p251g.p252a.p265v0;

import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p268y0.p284j.C5171k;

/* compiled from: Exceptions.java */
/* renamed from: g.a.v0.b */
/* loaded from: classes2.dex */
public final class C4561b {
    private C4561b() {
        throw new IllegalStateException("No instances!");
    }

    @InterfaceC4546f
    /* renamed from: a */
    public static RuntimeException m18198a(@InterfaceC4546f Throwable th) {
        throw C5171k.m18626c(th);
    }

    /* renamed from: b */
    public static void m18199b(@InterfaceC4546f Throwable th) {
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
