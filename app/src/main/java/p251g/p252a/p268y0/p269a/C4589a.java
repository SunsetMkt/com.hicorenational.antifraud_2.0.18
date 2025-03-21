package p251g.p252a.p268y0.p269a;

import java.util.concurrent.atomic.AtomicReferenceArray;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: ArrayCompositeDisposable.java */
/* renamed from: g.a.y0.a.a */
/* loaded from: classes2.dex */
public final class C4589a extends AtomicReferenceArray<InterfaceC4552c> implements InterfaceC4552c {
    private static final long serialVersionUID = 2746389416410565408L;

    public C4589a(int i2) {
        super(i2);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        InterfaceC4552c andSet;
        if (get(0) != EnumC4592d.DISPOSED) {
            int length = length();
            for (int i2 = 0; i2 < length; i2++) {
                InterfaceC4552c interfaceC4552c = get(i2);
                EnumC4592d enumC4592d = EnumC4592d.DISPOSED;
                if (interfaceC4552c != enumC4592d && (andSet = getAndSet(i2, enumC4592d)) != EnumC4592d.DISPOSED && andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return get(0) == EnumC4592d.DISPOSED;
    }

    public InterfaceC4552c replaceResource(int i2, InterfaceC4552c interfaceC4552c) {
        InterfaceC4552c interfaceC4552c2;
        do {
            interfaceC4552c2 = get(i2);
            if (interfaceC4552c2 == EnumC4592d.DISPOSED) {
                interfaceC4552c.dispose();
                return null;
            }
        } while (!compareAndSet(i2, interfaceC4552c2, interfaceC4552c));
        return interfaceC4552c2;
    }

    public boolean setResource(int i2, InterfaceC4552c interfaceC4552c) {
        InterfaceC4552c interfaceC4552c2;
        do {
            interfaceC4552c2 = get(i2);
            if (interfaceC4552c2 == EnumC4592d.DISPOSED) {
                interfaceC4552c.dispose();
                return false;
            }
        } while (!compareAndSet(i2, interfaceC4552c2, interfaceC4552c));
        if (interfaceC4552c2 == null) {
            return true;
        }
        interfaceC4552c2.dispose();
        return true;
    }
}
