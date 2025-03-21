package p251g.p252a.p264u0;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: SerialDisposable.java */
/* renamed from: g.a.u0.h */
/* loaded from: classes2.dex */
public final class C4557h implements InterfaceC4552c {

    /* renamed from: a */
    final AtomicReference<InterfaceC4552c> f17469a;

    public C4557h() {
        this.f17469a = new AtomicReference<>();
    }

    /* renamed from: a */
    public boolean m18191a(@InterfaceC4547g InterfaceC4552c interfaceC4552c) {
        return EnumC4592d.replace(this.f17469a, interfaceC4552c);
    }

    /* renamed from: b */
    public boolean m18192b(@InterfaceC4547g InterfaceC4552c interfaceC4552c) {
        return EnumC4592d.set(this.f17469a, interfaceC4552c);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        EnumC4592d.dispose(this.f17469a);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return EnumC4592d.isDisposed(this.f17469a.get());
    }

    @InterfaceC4547g
    /* renamed from: a */
    public InterfaceC4552c m18190a() {
        InterfaceC4552c interfaceC4552c = this.f17469a.get();
        return interfaceC4552c == EnumC4592d.DISPOSED ? C4553d.m18183a() : interfaceC4552c;
    }

    public C4557h(@InterfaceC4547g InterfaceC4552c interfaceC4552c) {
        this.f17469a = new AtomicReference<>(interfaceC4552c);
    }
}
