package p251g.p252a.p268y0.p283i;

import java.util.concurrent.atomic.AtomicReferenceArray;
import p251g.p252a.p264u0.InterfaceC4552c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ArrayCompositeSubscription.java */
/* renamed from: g.a.y0.i.a */
/* loaded from: classes2.dex */
public final class C5151a extends AtomicReferenceArray<InterfaceC5823d> implements InterfaceC4552c {
    private static final long serialVersionUID = 2746389416410565408L;

    public C5151a(int i2) {
        super(i2);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        InterfaceC5823d andSet;
        if (get(0) != EnumC5160j.CANCELLED) {
            int length = length();
            for (int i2 = 0; i2 < length; i2++) {
                InterfaceC5823d interfaceC5823d = get(i2);
                EnumC5160j enumC5160j = EnumC5160j.CANCELLED;
                if (interfaceC5823d != enumC5160j && (andSet = getAndSet(i2, enumC5160j)) != EnumC5160j.CANCELLED && andSet != null) {
                    andSet.cancel();
                }
            }
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return get(0) == EnumC5160j.CANCELLED;
    }

    public InterfaceC5823d replaceResource(int i2, InterfaceC5823d interfaceC5823d) {
        InterfaceC5823d interfaceC5823d2;
        do {
            interfaceC5823d2 = get(i2);
            if (interfaceC5823d2 == EnumC5160j.CANCELLED) {
                if (interfaceC5823d == null) {
                    return null;
                }
                interfaceC5823d.cancel();
                return null;
            }
        } while (!compareAndSet(i2, interfaceC5823d2, interfaceC5823d));
        return interfaceC5823d2;
    }

    public boolean setResource(int i2, InterfaceC5823d interfaceC5823d) {
        InterfaceC5823d interfaceC5823d2;
        do {
            interfaceC5823d2 = get(i2);
            if (interfaceC5823d2 == EnumC5160j.CANCELLED) {
                if (interfaceC5823d == null) {
                    return false;
                }
                interfaceC5823d.cancel();
                return false;
            }
        } while (!compareAndSet(i2, interfaceC5823d2, interfaceC5823d));
        if (interfaceC5823d2 == null) {
            return true;
        }
        interfaceC5823d2.cancel();
        return true;
    }
}
