package p251g.p252a.p268y0.p283i;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p324i.p338d.InterfaceC5823d;

/* compiled from: AsyncSubscription.java */
/* renamed from: g.a.y0.i.b */
/* loaded from: classes2.dex */
public final class C5152b extends AtomicLong implements InterfaceC5823d, InterfaceC4552c {
    private static final long serialVersionUID = 7028635084060361255L;
    final AtomicReference<InterfaceC5823d> actual;
    final AtomicReference<InterfaceC4552c> resource;

    public C5152b() {
        this.resource = new AtomicReference<>();
        this.actual = new AtomicReference<>();
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
        dispose();
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        EnumC5160j.cancel(this.actual);
        EnumC4592d.dispose(this.resource);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return this.actual.get() == EnumC5160j.CANCELLED;
    }

    public boolean replaceResource(InterfaceC4552c interfaceC4552c) {
        return EnumC4592d.replace(this.resource, interfaceC4552c);
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
        EnumC5160j.deferredRequest(this.actual, this, j2);
    }

    public boolean setResource(InterfaceC4552c interfaceC4552c) {
        return EnumC4592d.set(this.resource, interfaceC4552c);
    }

    public void setSubscription(InterfaceC5823d interfaceC5823d) {
        EnumC5160j.deferredSetOnce(this.actual, this, interfaceC5823d);
    }

    public C5152b(InterfaceC4552c interfaceC4552c) {
        this();
        this.resource.lazySet(interfaceC4552c);
    }
}
