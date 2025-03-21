package p251g.p252a.p268y0.p269a;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: SequentialDisposable.java */
/* renamed from: g.a.y0.a.k */
/* loaded from: classes2.dex */
public final class C4599k extends AtomicReference<InterfaceC4552c> implements InterfaceC4552c {
    private static final long serialVersionUID = -754898800686245608L;

    public C4599k() {
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        EnumC4592d.dispose(this);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return EnumC4592d.isDisposed(get());
    }

    public boolean replace(InterfaceC4552c interfaceC4552c) {
        return EnumC4592d.replace(this, interfaceC4552c);
    }

    public boolean update(InterfaceC4552c interfaceC4552c) {
        return EnumC4592d.set(this, interfaceC4552c);
    }

    public C4599k(InterfaceC4552c interfaceC4552c) {
        lazySet(interfaceC4552c);
    }
}
