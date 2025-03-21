package p251g.p252a.p268y0.p284j;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4564e;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5823d;

/* compiled from: EndConsumerHelper.java */
/* renamed from: g.a.y0.j.i */
/* loaded from: classes2.dex */
public final class C5169i {
    private C5169i() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static boolean m18618a(InterfaceC4552c interfaceC4552c, InterfaceC4552c interfaceC4552c2, Class<?> cls) {
        C4601b.m18284a(interfaceC4552c2, "next is null");
        if (interfaceC4552c == null) {
            return true;
        }
        interfaceC4552c2.dispose();
        if (interfaceC4552c == EnumC4592d.DISPOSED) {
            return false;
        }
        m18617a(cls);
        return false;
    }

    /* renamed from: a */
    public static boolean m18620a(AtomicReference<InterfaceC4552c> atomicReference, InterfaceC4552c interfaceC4552c, Class<?> cls) {
        C4601b.m18284a(interfaceC4552c, "next is null");
        if (atomicReference.compareAndSet(null, interfaceC4552c)) {
            return true;
        }
        interfaceC4552c.dispose();
        if (atomicReference.get() == EnumC4592d.DISPOSED) {
            return false;
        }
        m18617a(cls);
        return false;
    }

    /* renamed from: a */
    public static boolean m18619a(InterfaceC5823d interfaceC5823d, InterfaceC5823d interfaceC5823d2, Class<?> cls) {
        C4601b.m18284a(interfaceC5823d2, "next is null");
        if (interfaceC5823d == null) {
            return true;
        }
        interfaceC5823d2.cancel();
        if (interfaceC5823d == EnumC5160j.CANCELLED) {
            return false;
        }
        m18617a(cls);
        return false;
    }

    /* renamed from: a */
    public static boolean m18621a(AtomicReference<InterfaceC5823d> atomicReference, InterfaceC5823d interfaceC5823d, Class<?> cls) {
        C4601b.m18284a(interfaceC5823d, "next is null");
        if (atomicReference.compareAndSet(null, interfaceC5823d)) {
            return true;
        }
        interfaceC5823d.cancel();
        if (atomicReference.get() == EnumC5160j.CANCELLED) {
            return false;
        }
        m18617a(cls);
        return false;
    }

    /* renamed from: a */
    public static String m18616a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    /* renamed from: a */
    public static void m18617a(Class<?> cls) {
        C4476a.m17152b(new C4564e(m18616a(cls.getName())));
    }
}
