package p251g.p252a.p268y0.p283i;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4564e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p284j.C5164d;
import p324i.p338d.InterfaceC5823d;

/* compiled from: SubscriptionHelper.java */
/* renamed from: g.a.y0.i.j */
/* loaded from: classes2.dex */
public enum EnumC5160j implements InterfaceC5823d {
    CANCELLED;

    public static boolean cancel(AtomicReference<InterfaceC5823d> atomicReference) {
        InterfaceC5823d andSet;
        InterfaceC5823d interfaceC5823d = atomicReference.get();
        EnumC5160j enumC5160j = CANCELLED;
        if (interfaceC5823d == enumC5160j || (andSet = atomicReference.getAndSet(enumC5160j)) == CANCELLED) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static void deferredRequest(AtomicReference<InterfaceC5823d> atomicReference, AtomicLong atomicLong, long j2) {
        InterfaceC5823d interfaceC5823d = atomicReference.get();
        if (interfaceC5823d != null) {
            interfaceC5823d.request(j2);
            return;
        }
        if (validate(j2)) {
            C5164d.m18607a(atomicLong, j2);
            InterfaceC5823d interfaceC5823d2 = atomicReference.get();
            if (interfaceC5823d2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    interfaceC5823d2.request(andSet);
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference<InterfaceC5823d> atomicReference, AtomicLong atomicLong, InterfaceC5823d interfaceC5823d) {
        if (!setOnce(atomicReference, interfaceC5823d)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        interfaceC5823d.request(andSet);
        return true;
    }

    public static boolean isCancelled(InterfaceC5823d interfaceC5823d) {
        return interfaceC5823d == CANCELLED;
    }

    public static boolean replace(AtomicReference<InterfaceC5823d> atomicReference, InterfaceC5823d interfaceC5823d) {
        InterfaceC5823d interfaceC5823d2;
        do {
            interfaceC5823d2 = atomicReference.get();
            if (interfaceC5823d2 == CANCELLED) {
                if (interfaceC5823d == null) {
                    return false;
                }
                interfaceC5823d.cancel();
                return false;
            }
        } while (!atomicReference.compareAndSet(interfaceC5823d2, interfaceC5823d));
        return true;
    }

    public static void reportMoreProduced(long j2) {
        C4476a.m17152b(new C4564e("More produced than requested: " + j2));
    }

    public static void reportSubscriptionSet() {
        C4476a.m17152b(new C4564e("Subscription already set!"));
    }

    public static boolean set(AtomicReference<InterfaceC5823d> atomicReference, InterfaceC5823d interfaceC5823d) {
        InterfaceC5823d interfaceC5823d2;
        do {
            interfaceC5823d2 = atomicReference.get();
            if (interfaceC5823d2 == CANCELLED) {
                if (interfaceC5823d == null) {
                    return false;
                }
                interfaceC5823d.cancel();
                return false;
            }
        } while (!atomicReference.compareAndSet(interfaceC5823d2, interfaceC5823d));
        if (interfaceC5823d2 == null) {
            return true;
        }
        interfaceC5823d2.cancel();
        return true;
    }

    public static boolean setOnce(AtomicReference<InterfaceC5823d> atomicReference, InterfaceC5823d interfaceC5823d) {
        C4601b.m18284a(interfaceC5823d, "s is null");
        if (atomicReference.compareAndSet(null, interfaceC5823d)) {
            return true;
        }
        interfaceC5823d.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        reportSubscriptionSet();
        return false;
    }

    public static boolean validate(InterfaceC5823d interfaceC5823d, InterfaceC5823d interfaceC5823d2) {
        if (interfaceC5823d2 == null) {
            C4476a.m17152b(new NullPointerException("next is null"));
            return false;
        }
        if (interfaceC5823d == null) {
            return true;
        }
        interfaceC5823d2.cancel();
        reportSubscriptionSet();
        return false;
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
    }

    public static boolean validate(long j2) {
        if (j2 > 0) {
            return true;
        }
        C4476a.m17152b(new IllegalArgumentException("n > 0 required but it was " + j2));
        return false;
    }
}
