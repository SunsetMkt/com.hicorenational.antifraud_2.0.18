package p251g.p252a.p268y0.p269a;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4564e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: DisposableHelper.java */
/* renamed from: g.a.y0.a.d */
/* loaded from: classes2.dex */
public enum EnumC4592d implements InterfaceC4552c {
    DISPOSED;

    public static boolean dispose(AtomicReference<InterfaceC4552c> atomicReference) {
        InterfaceC4552c andSet;
        InterfaceC4552c interfaceC4552c = atomicReference.get();
        EnumC4592d enumC4592d = DISPOSED;
        if (interfaceC4552c == enumC4592d || (andSet = atomicReference.getAndSet(enumC4592d)) == enumC4592d) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean isDisposed(InterfaceC4552c interfaceC4552c) {
        return interfaceC4552c == DISPOSED;
    }

    public static boolean replace(AtomicReference<InterfaceC4552c> atomicReference, InterfaceC4552c interfaceC4552c) {
        InterfaceC4552c interfaceC4552c2;
        do {
            interfaceC4552c2 = atomicReference.get();
            if (interfaceC4552c2 == DISPOSED) {
                if (interfaceC4552c == null) {
                    return false;
                }
                interfaceC4552c.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(interfaceC4552c2, interfaceC4552c));
        return true;
    }

    public static void reportDisposableSet() {
        C4476a.m17152b(new C4564e("Disposable already set!"));
    }

    public static boolean set(AtomicReference<InterfaceC4552c> atomicReference, InterfaceC4552c interfaceC4552c) {
        InterfaceC4552c interfaceC4552c2;
        do {
            interfaceC4552c2 = atomicReference.get();
            if (interfaceC4552c2 == DISPOSED) {
                if (interfaceC4552c == null) {
                    return false;
                }
                interfaceC4552c.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(interfaceC4552c2, interfaceC4552c));
        if (interfaceC4552c2 == null) {
            return true;
        }
        interfaceC4552c2.dispose();
        return true;
    }

    public static boolean setOnce(AtomicReference<InterfaceC4552c> atomicReference, InterfaceC4552c interfaceC4552c) {
        C4601b.m18284a(interfaceC4552c, "d is null");
        if (atomicReference.compareAndSet(null, interfaceC4552c)) {
            return true;
        }
        interfaceC4552c.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        reportDisposableSet();
        return false;
    }

    public static boolean trySet(AtomicReference<InterfaceC4552c> atomicReference, InterfaceC4552c interfaceC4552c) {
        if (atomicReference.compareAndSet(null, interfaceC4552c)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        interfaceC4552c.dispose();
        return false;
    }

    public static boolean validate(InterfaceC4552c interfaceC4552c, InterfaceC4552c interfaceC4552c2) {
        if (interfaceC4552c2 == null) {
            C4476a.m17152b(new NullPointerException("next is null"));
            return false;
        }
        if (interfaceC4552c == null) {
            return true;
        }
        interfaceC4552c2.dispose();
        reportDisposableSet();
        return false;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return true;
    }
}
